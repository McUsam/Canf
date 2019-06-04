package com.canf.www.proves;

import java.util.ArrayList;
import java.util.HashMap;

import com.canf.www.articles.Llibre;
import com.canf.www.errors.QuantitatNoDisponibleException;
import com.canf.www.errors.ValidacionException;
import com.canf.www.gestio.LiniaFactura;
import com.canf.www.gestio.Magatzem;
import com.canf.www.gestio.Venta;

public class Proves {

	public static void main(String[] args) {
		
		System.out.println("0");
		try {
			Llibre l1 = new Llibre("1","1",1,"1","1","1",1,1);
			Llibre l2 = new Llibre("2","2",2,"2","2","2",2,2);
			Llibre l3 = new Llibre("3","3",3,"3","3","3",3,3);
			Llibre l4 = new Llibre("4","4",4,"4","4","4",4,4);
			LiniaFactura lf1 = new LiniaFactura(l1,2);
			LiniaFactura lf2 = new LiniaFactura(l2,3);
			LiniaFactura lf3 = new LiniaFactura(l3,1);
			LiniaFactura lf4 = new LiniaFactura(l4,3);
			HashMap<Integer, LiniaFactura> venta = new HashMap<Integer,LiniaFactura>();
			venta.put(1,lf1);
			venta.put(2,lf2);
			
			HashMap<Integer, LiniaFactura> venta2 = new HashMap<Integer,LiniaFactura>();
			venta2.put(1,lf3);
			venta2.put(2,lf4);
		

		Venta v1 = new Venta(venta, "1");
		Venta v2 = new Venta(venta2, "2");
	
		
		Magatzem m1 = new Magatzem("Espain");
		
		m1.afegeixVenta(v1);
		m1.afegeixVenta(v2);
		
		
		ArrayList<String> llistat = new ArrayList<String>();
		llistat = m1.llistaVenta();
		System.out.println("1");
		for(String st : llistat) {
			System.out.println("2");
			System.out.println(st);
		}

		
		} catch (ValidacionException | QuantitatNoDisponibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
