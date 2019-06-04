package com.canf.www.proves;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

import com.canf.www.articles.Article;
import com.canf.www.articles.Disc;
import com.canf.www.articles.Llibre;
import com.canf.www.articles.Pelicula;
import com.canf.www.articles.TipusArticle;
import com.canf.www.articles.TipusExtensio;
import com.canf.www.errors.ArticleNoExistentException;
import com.canf.www.errors.DataException;
import com.canf.www.errors.QuantitatNoDisponibleException;
import com.canf.www.errors.ValidacionException;
import com.canf.www.gestio.LiniaFactura;
import com.canf.www.gestio.Magatzem;
import com.canf.www.gestio.Venta;
import com.canf.www.streams.Streams;

public class Proves {

	public static void main(String[] args) throws ValidacionException, QuantitatNoDisponibleException {
		Proves p = new Proves();
		//p.provaArticle();
		p.provaMagatzem();
	}

	public void provaArticle() {
		try {
			String canso1 = "canso1";
			String canso2 = "canso2";
			Disc disc = new Disc("Cantant", "discogradica1", "disc1", "descripcio disc1", 4.5, 5);
			disc.afegirCanso(canso1);
			disc.afegirCanso(canso2);
			System.out.println(disc.toXML(TipusExtensio.EXTENS));
			Llibre llibre = new Llibre("Autor", "Editor", 205, "isbn1", "Llibre1", "descripcio llibre1", 25.20, 30);
			System.out.println(llibre.toXML(TipusExtensio.EXTENS));
			Pelicula pelicula = new Pelicula("Director", "Sinopsis1", "Pelicula", "descripcio pelicula", 12.50, 10);
			String actor1 = "actor1";
			String actor2 = "actor2";
			pelicula.afageixActor(actor1);
			pelicula.afageixActor(actor2);
			System.out.println(pelicula.toXML(TipusExtensio.EXTENS));
			Streams.escriuArticle("desti que vulguis", llibre);
			Streams.escriuArticle("desti que vulguis", disc);
			Streams.escriuArticle("desti que vulguis", pelicula);
			
           
		
		
		//Disc
//
//               	
//            ArrayList<String> albun1 = new ArrayList<>();
//            albun1.add("1.Highway to hell");
//            albun1.add("2.Welcome to the jungle");
//            albun1.add("3.Walk All Over You");
//
//            Disc disc1 = new Disc("ACDC", albun1, "Trui", "Hight voltage", "Disc 20 aniversari", 12.20, 5);
//            disc1.afegirCanso("4.Nifht Prowler");
//            disc1.afegirCanso("5.Shot Down in Flames");
//            disc1.esborraCanso("5.Shot Down in Flames");
//            //Veim el contingut amb el tipus de extensio.extens que veim tot el nom del interpret, llistat de cançons, la discografica
//            System.out.println(disc1.toXML(TipusExtensio.EXTENS));
//            System.out.println("");
//
//               Disc disc2 = new Disc("Cucorba", "blau", "dudua", "Peasos", 5.5, 2);
//            disc2.afegirCanso("1.Bon dia");
//            disc2.afegirCanso("2.El gegant del pi");
//            disc2.afegirCanso("3.Adéu siau");
//            // Velm el contingut del xml amb una forma més resumida sense les cançons, ni seong que, només el més 
//            System.out.println(disc2.toXML(TipusExtensio.SENZILL));
//             
//            
//            
//            
//            //La quantitat demanada a la compra es superior a la del stock, per tant no deixarà comprar.
//            LiniaFactura lf5 = new LiniaFactura(disc1, 6);
//            LiniaFactura lf6 = new LiniaFactura(disc2, 10);
//            
//
//            HashMap<Integer, LiniaFactura> venta3 = new HashMap<Integer, LiniaFactura>();
//            venta3.put(1, lf5);
//            venta3.put(2, lf6);
//           
//            
//            
//            Venta v3 = new Venta(venta3, "6");
//
////            Magatzem m1 = new Magatzem("Spain");
//            m1.afegeixVenta(v3);
//
//            String llistat2 = m1.llistaVenta();
//            System.out.println(llistat2);
		} catch (ValidacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void provaMagatzem() {
		try {
			Magatzem magatzem = new Magatzem("Direccio1");
			Disc disc = new Disc("Cantant", "discogradica1", "disc1", "descripcio disc1", 4.5, 5);
			Llibre llibre = new Llibre("Autor", "Editor", 205, "isbn1", "Llibre1", "descripcio llibre1", 25.20, 30);
			Pelicula pelicula = new Pelicula("Director", "Sinopsis1", "Pelicula", "descripcio pelicula", 12.50, 10);
			magatzem.afegeixArticle(disc);
			magatzem.afegeixArticle(llibre);
			magatzem.afegeixArticle(pelicula);

			System.out.println(disc.getStock());
			//System.out.println(magatzem.tornaLlista(TipusExtensio.SENZILL));
			System.out.println(magatzem.afegeixStock(1, 1));
			Venta venta1= new Venta("Client");
			LiniaFactura linia1 = new LiniaFactura(disc, 2);
			LiniaFactura linia2 = new LiniaFactura(llibre, 3);
			venta1.afegeixArticle(linia1);
			venta1.afegeixArticle(linia2);
			
			System.out.println(venta1.toXML());
			magatzem.afegeixVenta(venta1);
			System.out.println(disc.getStock());
			System.out.println(magatzem.llistaVenta());
			System.out.println(magatzem.cercaDiscsCantant("Cantant", TipusExtensio.SENZILL));
			magatzem.eliminarArticle(1);
			System.out.println(magatzem.tornaLlista(TipusExtensio.EXTENS));
			System.out.println(llibre.toXML(TipusExtensio.EXTENS));
			magatzem.restaStock(2, 10);
			System.out.println(llibre.getStock());
			Streams.escriuMagatzem("desti que vulguis", magatzem);
			Magatzem magatzem1 = new Magatzem("Spain");
			 Pelicula pelicula1 = new Pelicula("George Lucas", "Aventures Espacials", "La amanaça fantasma", "Aventures Espacials", 25.30, 15);
	            Pelicula pelicula2 = new Pelicula("George Lucas", "Aventures Espacials", "la guerra dels clons", "Aventures Espacials", 27.30, 12);
	            
	            Pelicula pelicula3 = new Pelicula("George Lucas", "Aventures Espacials", "Una nova esperança", "Aventures Espacials", 27.30, 12);
	            Pelicula pelicula4 = new Pelicula("George Lucas", "Aventures Espacials", "El imperi contraataca", "Aventures Espacials", 27.30, 12);
	            Pelicula pelicula5 = new Pelicula("George Lucas", "Aventures Espacials", "El retorn del jedi", "Aventures Espacials", 27.30, 12);
	            
	            
	            System.out.println(magatzem1.afegeixArticle(pelicula1)); // a afegir la pelicules una a una amb el métode al megatzem de Espanya.
	            System.out.println(magatzem1.afegeixArticle(pelicula2)); 
	            System.out.println(magatzem1.afegeixArticle(pelicula3));
	            System.out.println(magatzem1.afegeixArticle(pelicula4));
	            System.out.println(magatzem1.afegeixArticle(pelicula5));
	            System.out.println(magatzem1.eliminaArticle(pelicula2)); // esborra pelicula2 per un objecte Article
	            
	            System.out.println(magatzem1.llistaArticle(TipusArticle.PELICULA, TipusExtensio.EXTENS)); //veim llistat de pelicules -  llistaArticle - EXTENS
	            System.out.println("");            
	            System.out.println(magatzem1.llistaArticle(TipusArticle.PELICULA, TipusExtensio.SENZILL)); //veim llistat de pelicules - llistaArticle - SENZILL
	            System.out.println("");
			
		} catch (ValidacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QuantitatNoDisponibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArticleNoExistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
