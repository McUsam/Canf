package com.canf.www.gestio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.canf.www.articles.Article;
import com.canf.www.errors.ValidacionException;

public class Venta {
	private static final AtomicInteger count = new AtomicInteger(0);
	private HashMap<Integer,LiniaFactura> factura;
	private String client;
	private LocalDate data;
	
	public Venta(String client) {
		super();
		this.client = client;
	}

	public Venta(HashMap<Integer,LiniaFactura> factura, String client) {
		super();
		this.factura = new HashMap<Integer,LiniaFactura>();
		this.client = client;
	}

	public String getClient() {
		return client;
	}

	public LocalDate getData() {
		return data;
	}
	public void afegeixArticle(LiniaFactura a) {
		if( !factura.containsValue(a))
			factura.put(count.getAndIncrement(),a);
	}
	public double esborraArticle(LiniaFactura a) throws ValidacionException {
		double b = factura.get(a).getPreu() * factura.get(a).getQuantitat();
		factura.get(a).getArticle().setStock(factura.get(a).getArticle().getStock()+factura.get(a).getQuantitat());
		factura.remove(a);
		return b;
	}

	public HashMap<Integer,LiniaFactura> llista(){
		return factura;
	}
	public double calculaTotal() {
		double a = 0;
		for(int i =0; i<factura.size();i++) {
			a = a + factura.get(i).getPreu() * factura.get(i).getQuantitat() ;
		}
		return a;
	}
	
}
