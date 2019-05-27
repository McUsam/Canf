package com.canf.www.articles;

import java.util.concurrent.atomic.AtomicInteger;

import com.canf.www.errors.ValidacionException;
import com.canf.www.validacions.Validacions;

public abstract class Article {
	private static final AtomicInteger count = new AtomicInteger(0);
    private int referencia;
    private String nom;
    private String descripcio;
    private double preu;
    private TipusArticle tipusArticle;
    private int stock;

    public Article(String nom, String descripcio, double preu, TipusArticle tipusArticle, int stock) throws ValidacionException {
    	referencia= count.incrementAndGet();
        setNom(nom);
        setDescripcio(descripcio);
        setPreu(preu);
        this.tipusArticle = tipusArticle;
        setStock(stock);
    }

    
    
    public void toXML(String x){
        
    }
    
    public void setNom(String nom) throws ValidacionException {
    	if (Validacions.validaString(nom))
			this.nom = nom;
		else
			throw new ValidacionException("No pot ser null o una cadena buida.");
    }

    public int getReferencia() {
		return referencia;
	}

	public TipusArticle getTipusArticle() {
		return tipusArticle;
	}

	public String getNom() {
		return nom;
	}



	public String getDescripcio() {
		return descripcio;
	}



	public double getPreu() {
		return preu;
	}



	public int getStock() {
		return stock;
	}



	public void setDescripcio(String descripcio) throws ValidacionException {
		if (Validacions.validaString(descripcio))
			this.descripcio = descripcio;
		else
			throw new ValidacionException("No pot ser null o una cadena buida.");
    }

    public void setPreu(double preu) throws ValidacionException {
    	if (Validacions.validaDouble(preu))
			this.preu = preu;
		else
			throw new ValidacionException("No pot ser negatiu ni més petit que 0.");
    }

    public void setStock(int stock) throws ValidacionException {
    	if (Validacions.validaInt(stock))
			this.stock = stock;
		else
			throw new ValidacionException("No pot ser negatiu ni més petit que 0.");
    }

public String toXml() {
    	String txtXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    	txtXml = txtXml + (char) 10 + (char) 13;
		txtXml = txtXml + "<Article>";
		txtXml = txtXml + "referencia=\"" + referencia + "\" ";
		txtXml = txtXml + "nom=\"" + nom + "\" ";
		txtXml = txtXml + "descripcio=\"" + descripcio + "\" ";
		txtXml = txtXml + "preu=\"" + preu	+ "\" ";
		txtXml = txtXml + "tipusArticle=\"" + tipusArticle + "\" ";
		txtXml = txtXml + "stock=\"" + stock + "\">";
		txtXml = txtXml + "</Article>";
    	return txtXml;
	}

	@Override
	public String toString() {
		return "Article [referencia=" + referencia + ", nom=" + nom + ", descripcio=" + descripcio + ", preu=" + preu
				+ ", tipusArticle=" + tipusArticle + ", stock=" + stock + "]";
	}

}
