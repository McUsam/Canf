package com.canf.www.articles;

import java.util.HashSet;

import com.canf.www.errors.ValidacionException;
import com.canf.www.validacions.Validacions;

public final class Disc extends Article {

	private String interpret;
	private HashSet<String> llistaCansons;
	private String discografia;

	

	public Disc(String interpret, HashSet<String> llistaCansons, String discografia, String nom, String descripcio, double preu, int stock) throws ValidacionException {
        super(nom, descripcio, preu, TipusArticle.DISC, stock);
        setInterpret(interpret);
       this.llistaCansons = llistaCansons;
       setDiscografia(discografia);
    }

	public Disc(String interpret, String discografia, String nom, String descripcio, double preu,
			TipusArticle tipusArticle, int stock) throws ValidacionException {
		super(nom, descripcio, preu, tipusArticle, stock);
		this.interpret = interpret;
		this.llistaCansons = new HashSet<>();
		this.discografia = discografia;
	}

	public boolean afegirCanso(String nomCanso) {
		return llistaCansons.add(nomCanso);
	}

	public boolean esborraCanso(String nomCanso) {
		return llistaCansons.remove(nomCanso);
	}

	public String llistaCansons() {
		for (String llistaCanso1 : llistaCansons) {
			return llistaCanso1;
		}
		return null;
	}

    public void toXML(String x){
       
    }

	public String getInterpret() {
		return interpret;
	}

	public HashSet<String> getLlistaCansons() {
		return llistaCansons;
	}

	public String getDiscografia() {
		return discografia;
	}

	public void setInterpret(String interpret) throws ValidacionException {
		if(Validacions.validaString(interpret))
			this.interpret = interpret;
		else 
			throw new ValidacionException("No pot ser null o una cadena buida.");
	}

	public void setDiscografia(String discografia) throws ValidacionException {
		if(Validacions.validaString(discografia))
			this.discografia = discografia;
		else 
			throw new ValidacionException("No pot ser null o una cadena buida.");
	}

	public String toXml() {
		//https://codebeautify.org/xmlvalidator

		String txtXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		txtXml = txtXml + (char) 10 + (char) 13;
		txtXml = txtXml + "<Disc ";
		txtXml = txtXml + "interpret=\"" + interpret + "\" ";
		txtXml = txtXml + "llistaCansons=\"" + llistaCansons + "\" ";
		txtXml = txtXml + "discografia=\"" + discografia + "\" ";
		return txtXml;
	}
	
	@Override
	public String toString() {
		return "Disc [interpret=" + interpret + ", llistaCansons=" + llistaCansons + ", discografia=" + discografia
				+ "]";
	}

	

}
