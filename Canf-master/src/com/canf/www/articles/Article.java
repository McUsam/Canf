package com.canf.www.articles;

public abstract class Article {

    private int referencia;
    private String nom;
    private String descripcio;
    private double preu;
    private TipusArticle tipusArticle;
    private int stock;

    public Article(String nom, String descripcio, double preu, TipusArticle tipusArticle, int stock) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.preu = preu;
        this.tipusArticle = tipusArticle;
        this.stock = stock;
    }

    public Article(int referencia, String nom, String descripcio, double preu, TipusArticle tipusArticle, int stock) {
        this.referencia = referencia;
        this.nom = nom;
        this.descripcio = descripcio;
        this.preu = preu;
        this.tipusArticle = tipusArticle;
        this.stock = stock;
    }
    
 //    public void toXML(String x){
//        
//    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
