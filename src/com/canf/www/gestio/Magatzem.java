package com.canf.www.gestio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.canf.www.articles.Article;
import com.canf.www.articles.TipusArticle;
import com.canf.www.articles.TipusExtensio;

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

	public boolean elmininarArticle(String idArticle) {

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

		for (Map.Entry<Integer, Article> entry : llistaArticles.entrySet()) {
			if (entry.getValue().getTipusArticle().equals(tipusArticle)) {
				llista.add(entry.getValue().toXML(tipusExtensio));
			}
		}
		if (tipusArticle.equals(TipusArticle.DISC)) {
			String txtXml = "";
			txtXml = txtXml + "<LlistaDiscs>" + "\n";
			txtXml = txtXml + "</LlistaDiscs>" + "\n";
		} else if (tipusArticle.equals(TipusArticle.LLIBRE)) {
			String txtXml = "";
			txtXml = txtXml + "<LlistaLlibres>" + "\n";
			txtXml = txtXml + "</LlistaLlibres>" + "\n";
		} else {
			String txtXml = "";
			txtXml = txtXml + "<LlistaPelicules>" + "\n";
			txtXml = txtXml + "</LlistaPelicules>" + "\n";
		}
		return llista;
	}

	public ArrayList<String> tornaLlista(TipusExtensio tipusExtensio) {

		ArrayList<String> llista = new ArrayList<String>();

		for (Map.Entry<Integer, Article> entry : llistaArticles.entrySet()) {

			llista.add(entry.getValue().toXML(tipusExtensio));

		}
		return llista;
	}

	public Article cercaArticle(Integer referencia) {

		if (this.llistaArticles.containsKey(referencia)) {
			return this.llistaArticles.get(referencia);

		}
		return null;

	}


	public void afegeixVenta(Venta venta) {
		this.historial.add(venta);
	}

	// public boolean afegeixStock(){}

	// public boolean restaStock() {}

	
}

///////////////////////////////////////////

/* falta metodo actualizar stock con parametros referencia String y integer */
