package com.canf.www.articles;

import java.util.HashSet;

public final class Disc extends Article{

    private String interpret;
    private HashSet<String> llistaCançons;
    private String discografia;

//    public Disc(String interpret, String discografia, String nom, String descripcio, double preu, TipusArticle tipusArticle, int stock) {
//        super(nom, descripcio, preu, tipusArticle, stock);
//        this.interpret = interpret;
//        this.discografia = discografia;
//    }

//    public Disc(String interpret, HashSet<String> llistaCançons, String discografia, String nom, String descripcio, double preu, TipusArticle tipusArticle, int stock) {
//        super(nom, descripcio, preu, tipusArticle, stock);
//        this.interpret = interpret;
//        this.llistaCançons = llistaCançons;
//        this.discografia = discografia;
//    }
    
    
    public Disc(String interpret, String discografia, String nom, String descripcio, double preu, TipusArticle tipusArticle, int stock) {
        super(nom, descripcio, preu, tipusArticle, stock);
        this.interpret = interpret;
        this.llistaCançons = new HashSet<>();
        this.discografia = discografia;
    }

    
    public boolean afegirCanço(String nomCanço){
       return llistaCançons.add(nomCanço);
    }
    
    public boolean esborraCanço(String nomCanço){
        return llistaCançons.remove(nomCanço);
    }
    
    public String llistaCançons(){
        for (String llistaCanço1 : llistaCançons) {
            return llistaCanço1;
        }
        return null;
    }
    
//    public void toXML(String x){
//        
//    }
    
    public String getInterpret() {
        return interpret;
    }

    public HashSet<String> getLlistaCançons() {
        return llistaCançons;
    }

    public String getDiscografia() {
        return discografia;
    }
    
    

}
