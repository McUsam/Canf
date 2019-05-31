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
		System.out.println("hola");
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
		 return llista;	}

	public Article cercaArticle(Integer referencia) throws ArticleNoExistentException {

		if (this.llistaArticles.containsKey(referencia)) {
			return this.llistaArticles.get(referencia);

		}else {
			
			throw new ArticleNoExistentException();
		}
		
		
		
	}

	public void afegeixVenta(Venta venta) {
		this.historial.add(venta);
	}

	 public boolean afegeixStock(Integer referencia, int quantitat){
		 
		 quantitat = this.llistaArticles.get(referencia).getStock() + quantitat;
		 
		 try {
			this.llistaArticles.get(referencia).setStock(quantitat);
		} catch (ValidacionException e) {
			e.printStackTrace();
		}
		 
		 return true;
	 }

	 public boolean restaStock(Integer referencia, int quantitat) throws QuantitatNoDisponibleException, ValidacionException {
		 
		 
		 if(this.llistaArticles.get(referencia).getStock() - quantitat < 0) {
			 throw new QuantitatNoDisponibleException();
		 }
		 else {
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


