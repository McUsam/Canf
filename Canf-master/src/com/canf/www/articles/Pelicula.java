package com.canf.www.articles;

import java.util.HashSet;

public final class Pelicula extends Article{

    private String director;
    private HashSet<String> llistaActorsPelicula;
    private String sinopsis;

    public Pelicula(String director, String sinopsis, String nom, String descripcio, double preu, TipusArticle tipusArticle, int stock) {
        super(nom, descripcio, preu, tipusArticle, stock);
        this.director = director;
        this.llistaActorsPelicula = new HashSet<>();
        this.sinopsis = sinopsis;
    }
    
    
    public boolean afageixActor(String nomActor){
      return llistaActorsPelicula.add(nomActor);
    }

    public boolean eliminaActor(String nomActor){
        return llistaActorsPelicula.remove(nomActor);
    }
    
    public String llistaActors(){
        for (String llistaActorsPelicula1 : llistaActorsPelicula) {
            return llistaActorsPelicula1;
        }
        return null;
    }
    
//    public void toXML(String x){
//        
//    }
    
    public String getDirector() {
        return director;
    }

    public HashSet<String> getLlistaActorsPelicula() {
        return llistaActorsPelicula;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    
    

}
