package com.canf.www.articles;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import com.canf.www.errors.ValidacionException;
import com.canf.www.validacions.Validacions;

public abstract class Article implements Serializable{
	private static final AtomicInteger count = new AtomicInteger(0);
	private int referencia;
	private String nom;
	private String descripcio;
	private double preu;
	private TipusArticle tipusArticle;
	private int stock;

	public Article(String nom, String descripcio, double preu, TipusArticle tipusArticle, int stock)
			throws ValidacionException {
		referencia = count.incrementAndGet();
		setNom(nom);
		setDescripcio(descripcio);
		setPreu(preu);
		this.tipusArticle = tipusArticle;
		setStock(stock);
	}

	public String toXML(TipusExtensio x) {
		String txtXml = "";
		if (x == TipusExtensio.EXTENS) {
			txtXml = txtXml + "<Article>" + "\n";
			txtXml = txtXml + "<referencia>" + referencia + "</referencia> " + "\n";
			txtXml = txtXml + "<nom>" + nom + "</nom>" + "\n";
			txtXml = txtXml + "<descripcio>" + descripcio + "</descripcio>" + "\n";
			txtXml = txtXml + "<preu>" + preu + "</preu>" + "\n";
			txtXml = txtXml + "<tipusArticle>" + tipusArticle + "</tipusArticle>" + "\n";
			txtXml = txtXml + "<stock>" + stock + "</stock>" + "\n";
			txtXml = txtXml + "</Article>";
		} else {
			txtXml = txtXml + "<Article>" + "\n";
			txtXml = txtXml + "<referencia>" + referencia + "</referencia> " + "\n";
			txtXml = txtXml + "<nom>" + nom + "</nom>" + "\n";
			txtXml = txtXml + "<descripcio>" + descripcio + "</descripcio>" + "\n";
			txtXml = txtXml + "</Article>";
		}
		return txtXml;
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
			throw new ValidacionException("No pot ser negatiu ni m�s petit que 0.");
	}

	public void setStock(int stock) throws ValidacionException {
		if (Validacions.validaInt(stock))
			this.stock = stock;
		else
			throw new ValidacionException("No pot ser negatiu ni m�s petit que 0.");
	}

	@Override
	public String toString() {
		return "Article [referencia=" + referencia + ", nom=" + nom + ", descripcio=" + descripcio + ", preu=" + preu
				+ ", tipusArticle=" + tipusArticle + ", stock=" + stock + "]";
	}

}
