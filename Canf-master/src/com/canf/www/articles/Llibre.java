package com.canf.www.articles;

public final class Llibre extends Article{
    
    private String autor;
    private String editor;
    private int numPagines;
    private String isbn;

    public Llibre(String autor, String editor, int numPagines, String isbn, String nom, String descripcio, double preu, TipusArticle tipusArticle, int stock) {
        super(nom, descripcio, preu, tipusArticle, stock);
        this.autor = autor;
        this.editor = editor;
        this.numPagines = numPagines;
        this.isbn = isbn;
    }

//    public void toXML(String x){
//        
//    }
    
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

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setNumPagines(int numPagines) {
        this.numPagines = numPagines;
    }

    

}
