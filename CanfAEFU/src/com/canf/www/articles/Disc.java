package com.canf.www.articles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import com.canf.www.errors.ValidacionException;
import com.canf.www.validacions.Validacions;

public final class Disc extends Article implements Serializable {

	private String interpret;
	private ArrayList<String> llistaCansons;
	private String discografica;

	

	public Disc(String interpret, ArrayList<String> llistaCansons, String discografica, String nom, String descripcio, double preu, int stock) throws ValidacionException {
        super(nom, descripcio, preu, TipusArticle.DISC, stock);
        setInterpret(interpret);
       this.llistaCansons = llistaCansons;
       Collections.sort(this.llistaCansons);
       setDiscografica(discografica);
    }

	public Disc(String interpret, String discografia, String nom, String descripcio, double preu, int stock) throws ValidacionException {
		super(nom, descripcio, preu, TipusArticle.DISC, stock);
		setInterpret(interpret);
		this.llistaCansons = new ArrayList<>();
		setDiscografica(discografia);
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

    


	public String getInterpret() {
		return interpret;
	}

	public ArrayList<String> getLlistaCansons() {
		Collections.sort(this.llistaCansons);
		return llistaCansons;
	}

	public String getDiscografica() {
		return discografica;
	}

	public void setInterpret(String interpret) throws ValidacionException {
		if(Validacions.validaString(interpret))
			this.interpret = interpret;
		else 
			throw new ValidacionException("No pot ser null o una cadena buida.");
	}

	public void setDiscografica(String discografia) throws ValidacionException {
		if(Validacions.validaString(discografia))
			this.discografica = discografia;
		else 
			throw new ValidacionException("No pot ser null o una cadena buida.");
	}

	@Override
	public String toString() {
		return "Disc [interpret=" + interpret + ", llistaCansons=" + llistaCansons + ", discografia=" + discografica
				+ "]";
	}
	@Override
	public String toXML(TipusExtensio x) {
		
		String txtXml = "";
                if (x == TipusExtensio.EXTENS) {
			txtXml = txtXml + "<Disc>" + "\n";
			txtXml = txtXml + "<referencia>" + getReferencia() + "</referencia> " + "\n";
			txtXml = txtXml + "<nom>" + getNom() + "</nom>" + "\n";
			txtXml = txtXml + "<descripcio>" + getDescripcio() + "</descripcio>" + "\n";
			txtXml = txtXml + "<preu>" + getPreu() + "</preu>" + "\n";
			txtXml = txtXml + "<tipusArticle>" + getTipusArticle() + "</tipusArticle>" + "\n";
			txtXml = txtXml + "<stock>" + getStock() + "</stock>" + "\n";
                        
			txtXml = txtXml + "<intetpret>" + getInterpret() + "</interpret>" + "\n";
                        txtXml = txtXml + "<llistaCansons>" + "\n";
                                for (String llistaCansons1 : llistaCansons) {
                        txtXml = txtXml   + "<canso>" + llistaCansons1  + "</canso>" + "\n" ;
                    }
                             txtXml = txtXml   + "</llistaCansons>" + "\n";
                                
			txtXml = txtXml + "<discografica>" + discografica +  "</discografica>" + "\n";
			txtXml = txtXml + "</Disc>";
		} else {
			txtXml = txtXml + "<Disc>" + "\n";
			txtXml = txtXml + "<referencia>" + getReferencia() + "</referencia> " + "\n";
			txtXml = txtXml + "<nom>" + getNom() + "</nom>" + "\n";
			txtXml = txtXml + "<descripcio>" + getDescripcio() + "</descripcio>" + "\n";
			txtXml = txtXml + "</Disc>";
		}
		return txtXml;
	}

	

}
