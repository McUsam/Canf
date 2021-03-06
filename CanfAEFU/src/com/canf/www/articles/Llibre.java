package com.canf.www.articles;

import java.io.Serializable;

import com.canf.www.errors.ValidacionException;
import com.canf.www.validacions.Validacions;

public final class Llibre extends Article implements Serializable{

	private String autor;
	private String editor;
	private int numPagines;
	private String isbn;

	public Llibre(String autor, String editor, int numPagines, String isbn, String nom, String descripcio, double preu,
			int stock) throws ValidacionException {
		super(nom, descripcio, preu, TipusArticle.LLIBRE, stock);
		setAutor(autor);
		setEditor(editor);
		setNumPagines(numPagines);
		if (Validacions.validaString(isbn))
			this.isbn = isbn;
		else
			throw new ValidacionException("No pot ser null o una cadena buida.");
	}

	 @Override
		public String toXML(TipusExtensio x) {
			
			String txtXml = "";
	                if (x == TipusExtensio.EXTENS) {
				txtXml = txtXml + "<Llibre>" + "\n";
				txtXml = txtXml + "<referencia>" + getReferencia() + "</referencia> " + "\n";
				txtXml = txtXml + "<nom>" + getNom() + "</nom>" + "\n";
				txtXml = txtXml + "<descripcio>" + getDescripcio() + "</descripcio>" + "\n";
				txtXml = txtXml + "<preu>" + getPreu() + "</preu>" + "\n";
				txtXml = txtXml + "<tipusArticle>" + getTipusArticle() + "</tipusArticle>" + "\n";
				txtXml = txtXml + "<stock>" + getStock() + "</stock>" + "\n";
				txtXml = txtXml + "<autor>" + getAutor() + "</autor>" + "\n";
				txtXml = txtXml + "<editor>" + getEditor() + "</editor>" + "\n";
				txtXml = txtXml + "</Llibre>";
			} else {
				txtXml = txtXml + "<Llibre>" + "\n";
				txtXml = txtXml + "<referencia>" + getReferencia() + "</referencia> " + "\n";
				txtXml = txtXml + "<nom>" + getNom() + "</nom>" + "\n";
				txtXml = txtXml + "<descripcio>" + getDescripcio() + "</descripcio>" + "\n";
				txtXml = txtXml + "</Llibre>";
			}
			return txtXml;
		}


	public String getAutor() {
		return autor;
	}

	public String getEditor() {
		return editor;
	}

	public int getNumPagines() {
		return numPagines;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setAutor(String autor) throws ValidacionException {
		if (Validacions.validaString(autor))
			this.autor = autor;
		else
			throw new ValidacionException("No pot ser null o una cadena buida.");
	}

	public void setEditor(String editor) throws ValidacionException {
		if (Validacions.validaString(editor))
			this.editor = editor;
		else
			throw new ValidacionException("No pot ser null o una cadena buida.");
	}

	public void setNumPagines(int numPagines) throws ValidacionException {
		if (Validacions.validaInt(numPagines))
			this.numPagines = numPagines;
		else
			throw new ValidacionException("El numero de pagines no pot ser 0 o negatiu");
	}

	@Override
	public String toString() {
		return "Llibre [autor=" + autor + ", editor=" + editor + ", numPagines=" + numPagines + ", isbn=" + isbn + "]";
	}

	

}
