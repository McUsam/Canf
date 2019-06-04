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
import java.util.HashMap;

import com.canf.www.articles.Disc;
import com.canf.www.articles.Llibre;
import com.canf.www.articles.Pelicula;
import com.canf.www.articles.TipusArticle;
import com.canf.www.articles.TipusExtensio;
import com.canf.www.errors.ArticleNoExistentException;
import com.canf.www.errors.QuantitatNoDisponibleException;
import com.canf.www.errors.ValidacionException;
import com.canf.www.gestio.LiniaFactura;
import com.canf.www.gestio.Magatzem;
import com.canf.www.gestio.Venta;

public class Proves {

	public static void main(String[] args) {
		
		Proves proves = new Proves();
		try {
			proves.provaMagatzem();
		} catch (ValidacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArticleNoExistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QuantitatNoDisponibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void provaMagatzem() throws ValidacionException, ArticleNoExistentException, QuantitatNoDisponibleException{
		
		Llibre llibre1 = new Llibre("autor1","editor1", 100, "isbn1", "nom", "descripcio", 100, 5);
		Llibre llibre2 = new Llibre("autor2","editor2", 100, "isbn2", "nom", "descripcio", 200, 10);
		Disc disc1 = new Disc("Interpret1", "Discografica1", "nom", "descripcio", 4, 20);
		Disc disc2 = new Disc("Interpret2", "Discografica2", "nom", "descripcio", 8, 40);
		Pelicula pelicula1 = new Pelicula("Director1","sinopsi","nom","descripcio",2,4);
		Pelicula pelicula2 = new Pelicula("Director2","sinopsi","nom","descripcio",2,4);
		
		disc1.afegirCanso("canso1");
		disc1.afegirCanso("canso2");

		Magatzem magatzem = new Magatzem("Direccio 1");
		magatzem.afegeixArticle(llibre1);
		magatzem.afegeixArticle(llibre2);
		magatzem.afegeixArticle(pelicula1);
		magatzem.afegeixArticle(pelicula2);
		magatzem.afegeixArticle(disc1);
		magatzem.afegeixArticle(disc2);
		

		magatzem.cercaDiscsCantant("Interpret1", TipusExtensio.EXTENS);
		magatzem.cercaLlibreAutor("autor1", TipusExtensio.EXTENS);
		magatzem.cercaPeliculaDirector("Director1", TipusExtensio.EXTENS);
		
		magatzem.afegeixStock(1, 20);
		Venta venta1 = new Venta("cliente1");
		magatzem.afegeixVenta(venta1);
		
		magatzem.cercaArticle(1);
		magatzem.eliminaArticle(disc1);
		magatzem.eliminarArticle(2);
		
		magatzem.getDireccio();
		magatzem.llistaArticle(TipusArticle.DISC, TipusExtensio.EXTENS);
		
		magatzem.llistaVenta();
		
		magatzem.restaStock(2, 3);
		
		magatzem.setDireccio("direccio2");
		
		magatzem.tornaLlista(TipusExtensio.EXTENS);
		
		System.out.println(magatzem.cercaArticle(1).getStock());	
	
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
	
	}
	
	
	public void escriuTotsObjectes(String desti, Magatzem magatzem) {
		try (ObjectOutputStream p = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(desti)));) {
			p.writeObject(magatzem);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Magatzem llegeixTotsObjectes(String origen) {
		Magatzem magatzem = null;
		try (ObjectInputStream p = new ObjectInputStream(new BufferedInputStream(new FileInputStream(origen)));) {

			try {
				while (true) {
					magatzem=((Magatzem) p.readObject());
				}
			} catch (EOFException e) {

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return magatzem;
	}

	
	
	
	
}
