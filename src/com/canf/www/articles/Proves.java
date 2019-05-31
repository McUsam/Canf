/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.www.articles;

import com.canf.www.errors.ValidacionException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esteve SC
 */
public class Proves {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        try {
            

            ArrayList<String> albun1 = new ArrayList<String>();
            albun1.add("1.Highway to hell");
            albun1.add("2.Welcome to the jungle");
            albun1.add("3.Walk All Over You");
            
            
            Disc disc1 = new Disc("ACDC", albun1 ,"Trui", "Hight voltage", "Disc 20 aniversari", 12.20, 5);
            disc1.afegirCanso("4.Nifht Prowler");
            disc1.afegirCanso("5.Shot Down in Flames");
            disc1.esborraCanso("5.Shot Down in Flames");
            
            System.out.println(disc1.toXML(TipusExtensio.EXTENS));
            System.out.println("");
            
            
            Disc disc2 = new Disc("Cucorba", "blau", "dudua", "Peasos", 5.5, 2);
            disc2.afegirCanso("1.Bon dia");
            disc2.afegirCanso("2.El gegant del pi");
            disc2.afegirCanso("3.Adéu siau");

            System.out.println(disc2.toXML(TipusExtensio.SENZILL));
            
        

            
//            Pelicula pelicula1 = new Pelicula("George Lucas", "FUTURISTIC", "Star wars", "futurista", 10.2, 10);
//            pelicula1.afageixActor("Harrison Ford");
//            pelicula1.afageixActor("Mark Hamill");
//            pelicula1.afageixActor("asdfsdf");
//            pelicula1.afageixActor("bafafafe");
//            
//            System.out.println(pelicula1.toXML(TipusExtensio.EXTENS));
            
            
            
        } catch (ValidacionException ex) {
            Logger.getLogger(Proves.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
