package com.canf.www.gestio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.canf.www.articles.Article;
import com.canf.www.articles.Disc;
import com.canf.www.articles.Llibre;
import com.canf.www.articles.Pelicula;
import com.canf.www.articles.TipusArticle;
import com.canf.www.articles.TipusExtensio;
import com.canf.www.errors.ArticleNoExistentException;
import com.canf.www.errors.QuantitatNoDisponibleException;
import com.canf.www.errors.ValidacionException;
import com.canf.www.validacions.Validacions;

public class Magatzem {

	private HashMap<Integer, Article> llistaArticles;
	private ArrayList<Venta> historial;
	private String direccio;

	public Magatzem(String direccio) throws ValidacionException {
		System.out.println("hola");
		setDireccio(direccio);
		this.historial = new ArrayList<Venta>();
		this.llistaArticles = new HashMap<Integer, Article>();
	}

	public String getDireccio() {
		return direccio;
	}

	public void setDireccio(String direccio) throws ValidacionException {
		if (Validacions.validaString(direccio))
			this.direccio = direccio;
		else
			throw new ValidacionException("No pot ser null o una cadena buida.");
	}

	public boolean afegeixArticle(Article article) {

		if (!this.llistaArticles.containsKey(article.getReferencia())) {
			this.llistaArticles.put(article.getReferencia(), article);
			return true;
		}
		return false;

	}

	public boolean eliminarArticle(String idArticle) {

		if (this.llistaArticles.containsKey(idArticle)) {
			this.llistaArticles.remove(idArticle);
			return true;
		}
		return false;

	}

	public boolean eliminaArticle(Article article) {

		if (this.llistaArticles.containsValue(article)) {
			this.llistaArticles.remove(article.getReferencia(), article);
			return true;
		}
		return false;

	}

	public ArrayList<String> llistaArticle(TipusArticle tipusArticle, TipusExtensio tipusExtensio) {
		ArrayList<String> llista = new ArrayList<String>();
		String txtXml = "";

		if (tipusArticle.equals(TipusArticle.DISC)) {
			txtXml = txtXml + "<LlistaDiscs>" + "\n";
		} else if (tipusArticle.equals(TipusArticle.LLIBRE)) {
			txtXml = txtXml + "<LlistaLlibres>" + "\n";
		} else {
			txtXml = txtXml + "<LlistaPelicules>" + "\n";
		}

		for (Map.Entry<Integer, Article> entry : llistaArticles.entrySet()) {
			if (entry.getValue().getTipusArticle().equals(tipusArticle)) {
				llista.add(entry.getValue().toXML(tipusExtensio));
			}
		}

		if (tipusArticle.equals(TipusArticle.DISC)) {
			txtXml = txtXml + "</LlistaDiscs>" + "\n";
		} else if (tipusArticle.equals(TipusArticle.LLIBRE)) {
			txtXml = txtXml + "</LlistaLlibres>" + "\n";
		} else {
			txtXml = txtXml + "</LlistaPelicules>" + "\n";
		}

		Collections.sort(llista);
		return llista;
	}

	public ArrayList<String> tornaLlista(TipusExtensio tipusExtensio) {

		ArrayList<String> llista = new ArrayList<String>();

		for (Map.Entry<Integer, Article> entry : llistaArticles.entrySet()) {

			llista.add(entry.getValue().toXML(tipusExtensio));

		}
		Collections.sort(llista);
		return llista;
	}

	public Article cercaArticle(Integer referencia) throws ArticleNoExistentException, ValidacionException {
		if(Validacions.validaInt(referencia)) {
			throw new ValidacionException("La referencia no pot ser null ni menor que 1");
		}
		if (this.llistaArticles.containsKey(referencia)) {
			return this.llistaArticles.get(referencia);

		} else {

			throw new ArticleNoExistentException("L'article no existeix");
		}

	}

	public ArrayList<String> cercaDiscsCantant(String nom, TipusExtensio tipus) throws ArticleNoExistentException, ValidacionException {
		if(Validacions.validaString(nom)) {
			throw new ValidacionException("El nom no pot ser una cadena buida o null.");
		}
		ArrayList<Disc> discs = new ArrayList<Disc>();
		ArrayList<String> llistaEspecifica = new ArrayList<String>();
		for (Map.Entry<Integer, Article> entry : llistaArticles.entrySet()) {
			if (entry.getValue().getTipusArticle().equals(TipusArticle.DISC)) {
				discs.add((Disc) entry.getValue());
			}
		}
		String txtXml = "";
		txtXml = txtXml + "<LlistaArtista>" + "\n";
		txtXml = txtXml + "<Artista>" + nom+"</Artista>"+"\n";
		txtXml = txtXml + "<Discs>" + "\n";
		for(Disc a: discs) {
			if(a.getInterpret().equals(nom)) {
				txtXml= txtXml+ llistaEspecifica.add(a.toXML(tipus))+"\n";
			}
		}
		txtXml = txtXml + "</Discs>" + "\n";
		txtXml = txtXml + "</LlistaArtista>" + "\n";
		return llistaEspecifica;
		
		
	}
	public ArrayList<String> cercaLlibreAutor(String nom, TipusExtensio tipus) throws ArticleNoExistentException, ValidacionException {
		if(Validacions.validaString(nom)) {
			throw new ValidacionException("El nom no pot ser una cadena buida o null.");
		}
		ArrayList<Llibre> llibres = new ArrayList<Llibre>();
		ArrayList<String> llistaEspecifica = new ArrayList<String>();
		for (Map.Entry<Integer, Article> entry : llistaArticles.entrySet()) {
			if (entry.getValue().getTipusArticle().equals(TipusArticle.LLIBRE)) {
				llibres.add((Llibre) entry.getValue());
			}
		}
		String txtXml = "";
		txtXml = txtXml + "<LlistaAutor>" + "\n";
		txtXml = txtXml + "<Autor>" + nom+"</Autor>"+"\n";
		txtXml = txtXml + "<Llibres>" + "\n";
		for(Llibre a: llibres) {
			if(a.getAutor().equals(nom)) {
				txtXml= txtXml+ llistaEspecifica.add(a.toXML(tipus))+"\n";
			}
		}
		txtXml = txtXml + "</Llibres>" + "\n";
		txtXml = txtXml + "</LlistaArtista>" + "\n";
		return llistaEspecifica;
		
		
	}
	public ArrayList<String> cercaPeliculaDirector(String nom, TipusExtensio tipus) throws ArticleNoExistentException, ValidacionException {
		if(Validacions.validaString(nom)) {
			throw new ValidacionException("El nom no pot ser una cadena buida o null.");
		}
		ArrayList<Pelicula> pelicules = new ArrayList<Pelicula>();
		ArrayList<String> llistaEspecifica = new ArrayList<String>();
		for (Map.Entry<Integer, Article> entry : llistaArticles.entrySet()) {
			if (entry.getValue().getTipusArticle().equals(TipusArticle.PELICULA)) {
				pelicules.add((Pelicula) entry.getValue());
			}
		}
		String txtXml = "";
		txtXml = txtXml + "<LlistaArtista>" + "\n";
		txtXml = txtXml + "<Director>" + nom+"</Director>"+"\n";
		txtXml = txtXml + "<Pelicules>"+"\n";
		for(Pelicula a: pelicules) {
			if(a.getDirector().equals(nom)) {
				txtXml= txtXml+ llistaEspecifica.add(a.toXML(tipus))+"\n";
			}
		}
		txtXml = txtXml + "</Pelicules>"+"\n";
		txtXml = txtXml + "</LlistaArtista>" + "\n";
		return llistaEspecifica;
		
		
	}

	public void afegeixVenta(Venta venta) {
		this.historial.add(venta);
	}

	public boolean afegeixStock(Integer referencia, int quantitat) {

		quantitat = this.llistaArticles.get(referencia).getStock() + quantitat;

		try {
			this.llistaArticles.get(referencia).setStock(quantitat);
		} catch (ValidacionException e) {
			e.printStackTrace();
		}

		return true;
	}

	public boolean restaStock(Integer referencia, int quantitat)
			throws QuantitatNoDisponibleException, ValidacionException {
		if(Validacions.validaInt(referencia) || Validacions.validaInt(quantitat)) {
			throw new ValidacionException("Ni la referencia ni la quantitat poden ser null");
		}
		if (this.llistaArticles.get(referencia).getStock() - quantitat < 0) {
			throw new QuantitatNoDisponibleException("Quantitat no disponible!");
		} else {
			quantitat = this.llistaArticles.get(referencia).getStock() - quantitat;
			this.llistaArticles.get(referencia).setStock(quantitat);
			return true;
		}

	}

	public ArrayList<String> llistaVenta() {

		ArrayList<String> llista = new ArrayList<String>();

		String txtXml = "";

		for (Venta venta : this.historial) {

			txtXml = txtXml + "<venta>" + "\n";
			for (Map.Entry<Integer, LiniaFactura> entry : venta.llista().entrySet()) {
				txtXml = txtXml + "<LiniaFactura>" + "\n";
				txtXml = entry.getValue().getArticle().toXML(TipusExtensio.SENZILL);
				txtXml = "<Preu>" + entry.getValue().getPreu() + "</preu>" + "\n";
				txtXml = "<Quantitat>" + entry.getValue().getQuantitat() + "</Quantitat>" + "\n";
				txtXml = txtXml + "</LiniaFactura>" + "\n";
			}
			txtXml = txtXml + "</venta>" + "\n";
			llista.add(new String(txtXml));
			txtXml = "";

		}

		return llista;

	}

}