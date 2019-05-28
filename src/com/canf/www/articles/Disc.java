package com.canf.www.articles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import com.canf.www.errors.ValidacionException;
import com.canf.www.validacions.Validacions;

public final class Disc extends Article {

	private String interpret;
	private ArrayList<String> llistaCansons;
	private String discografia;

	

	public Disc(String interpret, ArrayList<String> llistaCansons, String discografia, String nom, String descripcio, double preu, int stock) throws ValidacionException {
        super(nom, descripcio, preu, TipusArticle.DISC, stock);
        setInterpret(interpret);
       this.llistaCansons = llistaCansons;
       Collections.sort(this.llistaCansons);
       setDiscografia(discografia);
    }

	public Disc(String interpret, String discografia, String nom, String descripcio, double preu, int stock) throws ValidacionException {
		super(nom, descripcio, preu, TipusArticle.DISC, stock);
		setInterpret(interpret);
		this.llistaCansons = new ArrayList<>();
		setDiscografia(discografia);
	}

	public boolean afegirCanso(String nomCanso) {
		Collections.sort(this.llistaCansons);
		return llistaCansons.add(nomCanso);
	}

	public boolean esborraCanso(String nomCanso) {
		Collections.sort(this.llistaCansons);
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

	public ArrayList<String> getLlistaCansons() {
		Collections.sort(this.llistaCansons);
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

	public String toXML(TipusExtensio x) {
		String txtXml = "";
		if (x == TipusExtensio.EXTENS) {
			txtXml = txtXml + "<Article>" + "\n";
			txtXml = txtXml + "<referencia>" + getReferencia() + "</referencia> " + "\n";
			txtXml = txtXml + "<nom>" + getNom() + "</nom>" + "\n";
			txtXml = txtXml + "<descripcio>" + getDescripcio() + "</descripcio>" + "\n";
			txtXml = txtXml + "<preu>" + getPreu() + "</preu>" + "\n";
			txtXml = txtXml + "<tipusArticle>" + getTipusArticle() + "</tipusArticle>" + "\n";
			txtXml = txtXml + "<stock>" + getStock() + "</stock>" + "\n";
			txtXml = txtXml + "<interpret>" + interpret + "</interpret> " + "\n";
			txtXml = txtXml + "llistaCansons=\"" + llistaCansons + "</llistaCansons> " + "\n";
			txtXml = txtXml + "discografia=\"" + discografia + "</discografia> " + "\n";
			txtXml = txtXml + "</Article>";
		} else {
			txtXml = txtXml + "<Article>" + "\n";
			txtXml = txtXml + "<referencia>" + getReferencia() + "</referencia> " + "\n";
			txtXml = txtXml + "<nom>" + getNom() + "</nom>" + "\n";
			txtXml = txtXml + "<descripcio>" + getDescripcio() + "</descripcio>" + "\n";
			txtXml = txtXml + "</Article>";
		}
		return txtXml;
	}	
	@Override
	public String toString() {
		return "Disc [interpret=" + interpret + ", llistaCansons=" + llistaCansons + ", discografia=" + discografia
				+ "]";
	}

	

}
