package com.canf.www.gestio;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;

import com.canf.www.articles.Article;

public class Venta {
	private HashMap< Article, Integer> llista;
	private String client;
	private LocalDate data;
	
	public Venta(String client) {
		super();
		this.client = client;
	}

	public Venta(HashMap<Article, Integer> llista, String client) {
		super();
		this.llista = new HashMap<Article, Integer>();
		this.client = client;
	}

	public String getClient() {
		return client;
	}

	public LocalDate getData() {
		return data;
	}
	
	public void afageixArticle(Integer a, Article b) {
		llista.put(b,a);
	}
	public void canviaQuantitat(Integer a, Article b) {
		llista.put(b,a);
	}
	public void esborraArticle(Article a) {
		llista.remove(a);
	}

	public Collection llista(){
		return llista;
	}
	public double calculaTotal() {
		double a = 0;
		for(int i =0; i<llista.size();i++) {
			a = a + llista.get(i).getPreu();
		}
		return a;
	}
	
}
