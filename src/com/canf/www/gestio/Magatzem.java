package com.canf.www.gestio;

import java.util.ArrayList;
import java.util.HashSet;

import com.canf.www.articles.Article;

public class Magatzem {

	private HashSet<Article> llistaArticles;
	private ArrayList<Venta> historial;
	private String direccio;
	
	
	//Constructor
	public Magatzem(HashSet<Article> llistaArticles, ArrayList<Venta> historial, String direccio) {
		this.llistaArticles = llistaArticles;
		this.historial = historial;
		this.direccio = direccio;
	}
	///////////////////////////////////////////
	
	//Setters & Getters
	public HashSet<Article> getLlistaArticles() {
		return llistaArticles;
	}
	public void setLlistaArticles(HashSet<Article> llistaArticles) {
		this.llistaArticles = llistaArticles;
	}
	public ArrayList<Venta> getHistorial() {
		return historial;
	}
	public void setHistorial(ArrayList<Venta> historial) {
		this.historial = historial;
	}
	public String getDireccio() {
		return direccio;
	}
	public void setDireccio(String direccio) {
		this.direccio = direccio;
	}
	///////////////////////////////////////////
	
	
	//Metodos
	public boolean afegeixArticle(Article article){}
	
	public boolean elminiaArticle(String idArticle){}
	public boolean eliminaArticle(Article article){}
	
	public ArrayList<Article> llistaArticle(TipusArticle tipusArticle){}

	public ArrayList<String> tornaLlista(TipusExtensio tipusExtensio){}
	
	public ArrayList<Article> cercaArticle(TipusArticle tipusArticle){}
	
	/* Metodos del historial*/
	public void afegeixVenta(Venta venta){}
	public ArrayList<Venta> llistaVenta(){}
	
	///////////////////////////////////////////
	
}
