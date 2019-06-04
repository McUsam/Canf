package com.canf.www.gestio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.canf.www.articles.Article;
import com.canf.www.articles.TipusExtensio;
import com.canf.www.errors.DataException;
import com.canf.www.errors.ValidacionException;

public class Venta implements Serializable {
	  private HashMap<Integer, LiniaFactura> factura;
	    private String client;
	    private LocalDate data;

	    public Venta(String client) {
	        super();
	        this.factura = new HashMap<Integer, LiniaFactura>();
	        this.client = client;
	        data = LocalDate.now();
	    }

	    public Venta(HashMap<Integer, LiniaFactura> factura, String client) {
	        super();
	        this.factura = factura;
	        this.client = client;
	        data = LocalDate.now();
	    }

	    public String getClient() {
	        return client;
	    }

	    public LocalDate getData() {
	        return data;
	    }

	    public boolean afegeixArticle(LiniaFactura a) throws DataException {

	        if (data.isEqual(LocalDate.now())) {
	            if (factura.containsValue(a)) {
	                return false;
	            } else {
	                factura.put(a.getArticle().getReferencia(), a);
	                return true;
	            }
	        } else {
	            throw new DataException("No se pot afegir productes.");
	        }
	    }

	    public double esborraArticle(LiniaFactura a) throws ValidacionException {
	        double b = factura.get(a).getPreu() * factura.get(a).getQuantitat();
	        factura.get(a).getArticle().setStock(factura.get(a).getArticle().getStock() + factura.get(a).getQuantitat());
	        factura.remove(a);
	        return b;
	    }

	    public HashMap<Integer, LiniaFactura> llista() {
	        return factura;
	    }

	    public double calculaTotal() {
	        double a = 0;
	        for (LiniaFactura entry : factura.values()) {
	            a = a + entry.getPreu() * entry.getQuantitat();
	        }
	        
	        return a;
	    }

	    public String toXML() {
	        String txtXml = "";
	        int cont = 0;
	        txtXml = txtXml + "<Venta>" + "\n";
	        txtXml = txtXml + "<data>" + data + "</data>" + "\n";
	        for (int i = 0; i < factura.size(); i++) {
	            cont = i++;
	            txtXml = txtXml + "<linia>" + cont + "</linia>" + "\n";
	            txtXml = txtXml + factura.get(i).toXML() + "\n";

	        }
	        txtXml = txtXml + "<client>" + client + "</client> " + "\n";
	        txtXml = txtXml + "<total>" + calculaTotal() + "</total>" + "\n";
	        txtXml = txtXml + "</Venta>";
	        return txtXml;
	    }
}