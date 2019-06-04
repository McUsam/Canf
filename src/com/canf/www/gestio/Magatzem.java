package com.canf.www.gestio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.canf.www.articles.Article;
import com.canf.www.articles.TipusArticle;
import com.canf.www.articles.TipusExtensio;
import com.canf.www.errors.ArticleNoExistentException;
import com.canf.www.errors.QuantitatNoDisponibleException;
import com.canf.www.errors.ValidacionException;

public class Magatzem {

	private HashMap<Integer, Article> llistaArticles;
	private ArrayList<Venta> historial;
	private String direccio;

	public Magatzem(String direccio) {
		this.direccio = direccio;
		this.historial = new ArrayList<Venta>();
		this.llistaArticles = new HashMap<Integer, Article>();
	}

	public String getDireccio() {
		return direccio;
	}

	public void setDireccio(String direccio) {
		this.direccio = direccio;
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

	public String llistaArticle(TipusArticle tipusArticle, TipusExtensio tipusExtensio) {
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
				txtXml = txtXml + entry.getValue().toXML(tipusExtensio)+"\n";
			}
		}

		if (tipusArticle.equals(TipusArticle.DISC)) {
			txtXml = txtXml + "</LlistaDiscs>" + "\n";
		} else if (tipusArticle.equals(TipusArticle.LLIBRE)) {
			txtXml = txtXml + "</LlistaLlibres>" + "\n";
		} else {
			txtXml = txtXml + "</LlistaPelicules>" + "\n";
		}
		return txtXml;
	}

	public ArrayList<String> tornaLlista(TipusExtensio tipusExtensio) {

		ArrayList<String> llista = new ArrayList<String>();

		for (Map.Entry<Integer, Article> entry : llistaArticles.entrySet()) {

			llista.add(entry.getValue().toXML(tipusExtensio));

		}
		Collections.sort(llista);
		return llista;
	}

	public Article cercaArticle(Integer referencia) throws ArticleNoExistentException {

		if (this.llistaArticles.containsKey(referencia)) {
			return this.llistaArticles.get(referencia);

		} else {

			throw new ArticleNoExistentException("L'article no existeix");
		}

	}

	public void afegeixVenta(Venta venta) {
		this.historial.add(venta);
	}

	public boolean afegeixStock(Integer referencia, int quantitat) throws ValidacionException {

		quantitat = this.llistaArticles.get(referencia).getStock() + quantitat;

		this.llistaArticles.get(referencia).setStock(quantitat);

		return true;
	}

	public boolean restaStock(Integer referencia, int quantitat)
			throws QuantitatNoDisponibleException, ValidacionException {

		if (this.llistaArticles.get(referencia).getStock() - quantitat <= 0) {
			throw new QuantitatNoDisponibleException("No hi ha suficiente stock");
		} else {
			quantitat = this.llistaArticles.get(referencia).getStock() - quantitat;
			this.llistaArticles.get(referencia).setStock(quantitat);
			return true;
		}

	}
	public String cercaDiscsCantant(String nom, TipusExtensio tipus) throws ArticleNoExistentException, ValidacionException {
		if(Validacions.validaString(nom)) {
			throw new ValidacionException("El nom no pot ser una cadena buida o null.");
		}
		
		String txtXml = "";
		txtXml = txtXml + "<LlistaArtista>" + "\n";
		txtXml = txtXml + "<Artista>" + nom+"</Artista>"+"\n";
		txtXml = txtXml + "<Discs>" + "\n";
		Disc a = null;
		for (Article entry : llistaArticles.values()) {
			if (entry.getTipusArticle().equals(TipusArticle.DISC)) {
				a = (Disc) entry;
				if(a.getInterpret().equals(nom))
					txtXml = txtXml +a.toXML(tipus)+"\n";
			}
		}
		txtXml = txtXml + "</Discs>" + "\n";
		txtXml = txtXml + "</LlistaArtista>" + "\n";
		return txtXml;
		
		
	}
	public String cercaLlibreAutor(String nom, TipusExtensio tipus) throws ArticleNoExistentException, ValidacionException {
		if(Validacions.validaString(nom)) {
			throw new ValidacionException("El nom no pot ser una cadena buida o null.");
		}
		String txtXml = "";
		txtXml = txtXml + "<LlistaAutor>" + "\n";
		txtXml = txtXml + "<Autor>" + nom+"</Autor>"+"\n";
		txtXml = txtXml + "<Llibres>" + "\n";
		Llibre a = null;
		for (Article entry : llistaArticles.values()) {
			if (entry.getTipusArticle().equals(TipusArticle.LLIBRE)) {
				a = (Llibre) entry;
				if(a.getAutor().equals(nom)) {
					txtXml = txtXml +a.toXML(tipus)+"\n";
				}
			}
		}
		txtXml = txtXml + "</Llibres>" + "\n";
		txtXml = txtXml + "</LlistaArtista>" + "\n";
		return txtXml;
		
		
	}
	public String cercaPeliculaDirector(String nom, TipusExtensio tipus) throws ArticleNoExistentException, ValidacionException {
		if(Validacions.validaString(nom)) {
			throw new ValidacionException("El nom no pot ser una cadena buida o null.");
		}
		String txtXml = "";
		txtXml = txtXml + "<LlistaArtista>" + "\n";
		txtXml = txtXml + "<Director>" + nom+"</Director>"+"\n";
		txtXml = txtXml + "<Pelicules>"+"\n";
		Pelicula a = null;
		for (Article entry : llistaArticles.values()) {
			if (entry.getTipusArticle().equals(TipusArticle.PELICULA)) {
				a = (Pelicula) entry;
				if(a.getDirector().equals(nom))
					txtXml = txtXml +a.toXML(tipus)+"\n";
			}
		}
		
		txtXml = txtXml + "</Pelicules>"+"\n";
		txtXml = txtXml + "</LlistaArtista>" + "\n";
		return txtXml;
		
		
	}

	public String llistaVenta() {
		
		String toXML = "";

		for (Venta venta : this.historial) {
			toXML = toXML+"</LlistaVentes>" + "\n" + venta.toXML() + "\n" + "</LlistaVentes>";
		}
		return toXML;

	}

}
