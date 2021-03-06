package com.canf.www.articles;

import com.canf.www.errors.ValidacionException;
import com.canf.www.validacions.Validacions;

public final class Llibre extends Article {

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

	public String toXml() {

		String txtXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		txtXml = txtXml + (char) 10 + (char) 13;
		txtXml = txtXml + "<llibre ";
		txtXml = txtXml + "autor=\"" + autor + "\" ";
		txtXml = txtXml + "editor=\"" + editor + "\" ";
		txtXml = txtXml + "numPagines=\"" + numPagines + "\" ";
		txtXml = txtXml + "isbn=\"" + isbn	+ "\" ";
		return txtXml;
	}
	
	@Override
	public String toString() {
		return "Llibre [autor=" + autor + ", editor=" + editor + ", numPagines=" + numPagines + ", isbn=" + isbn + "]";
	}

	

}
