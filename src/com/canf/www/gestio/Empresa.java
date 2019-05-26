package com.canf.www.gestio;

import java.util.HashSet;

public class Empresa {
	private HashSet<Magatzem> llista;

	public Empresa() {
		super();
		this.llista = new HashSet<Magatzem>();
	}
	public void afageixMagatzem(Magatzem a) {
		llista.add(a);
	}
	public void esborraMagatzem(Magatzem a) {
		llista.remove(a);
	}
	public HashSet<Magatzem> llistaMagatzem(){
		return llista;
	}
}
