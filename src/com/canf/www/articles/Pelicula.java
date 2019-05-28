package com.canf.www.articles;

import java.util.HashSet;

import com.canf.www.errors.ValidacionException;
import com.canf.www.validacions.Validacions;

public final class Pelicula extends Article {

	private String director;
	private HashSet<String> llistaActorsPelicula;
	private String sinopsis;

	public Pelicula(String director, String sinopsis, String nom, String descripcio, double preu, int stock) throws ValidacionException {
		super(nom, descripcio, preu, TipusArticle.PELICULA, stock);
		this.director = director;
		this.llistaActorsPelicula = new HashSet<>();
		this.sinopsis = sinopsis;
	}

	public boolean afageixActor(String nomActor) throws ValidacionException {
		if (Validacions.validaString(nomActor))
			return llistaActorsPelicula.add(nomActor);
		else
			throw new ValidacionException("No pot ser null o una cadena buida.");

	}

	public boolean eliminaActor(String nomActor) throws ValidacionException {
		if (Validacions.validaString(nomActor))
			return llistaActorsPelicula.remove(nomActor);
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
			txtXml = txtXml + "director=\"" + director + "\" ";
			txtXml = txtXml + "llistaActorsPelicula=\"" + llistaActorsPelicula + "\" ";
			txtXml = txtXml + "sinopsis=\"" + sinopsis + "\" ";
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
		return "Pelicula [director=" + director + ", llistaActorsPelicula=" + llistaActorsPelicula + ", sinopsis="
				+ sinopsis + "]";
	}

	public String llistaActors() {
		for (String llistaActorsPelicula1 : llistaActorsPelicula) {
			return llistaActorsPelicula1;
		}
		return null;
	}

	public void toXML(String x) {
	}

	public String getDirector() {
		return director;
	}

	public HashSet<String> getLlistaActorsPelicula() {
		return llistaActorsPelicula;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setDirector(String director) throws ValidacionException {
		if (Validacions.validaString(director))
			this.director = director;
		else
			throw new ValidacionException("No pot ser null o una cadena buida.");
	}

	public void setSinopsis(String sinopsis) throws ValidacionException {
		if (Validacions.validaString(sinopsis))
			this.sinopsis = sinopsis;
		else
			throw new ValidacionException("No pot ser null o una cadena buida.");
	}

}
