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
		
		System.out.println(magatzem.cercaArticle(1).getStock());	}
	
	
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
