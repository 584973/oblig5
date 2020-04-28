package no.hvl.dat102;

import java.util.Iterator;

import no.hvl.dat102.adt.BSTreADT;

//********************************************************************
// KjedetBinærSøkeTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>, Iterable<T> {

	private int antall;
	private BinaerTreNode<T> rot;

	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	public KjedetBSTre(T element) {
		rot = new BinaerTreNode<T>(element);
		antall = 1;
	}

	public int antall() {
		return antall;
	}

	public boolean erTom() {
		return (antall == 0);
	}

	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> rot, T key) {

		if (rot == null) {
			rot = new BinaerTreNode<T>(key);
			return rot;
		}

		if (key.compareTo(rot.getElement()) < 0)
			rot.setVenstre(leggTilRek(rot.getVenstre(), key));
		else if (key.compareTo(rot.getElement()) >= 0)
			rot.setHoyre(leggTilRek(rot.getHoyre(), key));

		return rot;
	}

	public void leggTil2(T element) {
		//
	}

	public T fjernMin() {

		return null;

	}

	public T fjernMaks() {

		return null;
	}

	public T finnMin() {

		return null;
	}

	public T finnMaks() {

		return null;
	}

	public T finn(T element) {

		return finnRek(element, rot);

	}

	private T finnRek(T key, BinaerTreNode<T> rot) {

		if (rot == null) {
			return null;
		}
		int cmp = key.compareTo(rot.getElement());
		if (cmp < 0) {
			return finnRek(key, rot.getVenstre());
		} else if (cmp > 0) {
			return finnRek(key, rot.getHoyre());
		} else {
			return rot.getElement();
		}
	}

	public T finn2(T element) {
		// TODO
		return null;
	}

	public void visInorden() {
		visInorden(rot);
		System.out.println();
	}

	private void visInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visInorden(p.getVenstre());
			System.out.print(" " + p.getElement());
			visInorden(p.getHoyre());
		}
	}

	public int finnHoyde() {

		return finnHoydeRek(rot);

	}

	private int finnHoydeRek(BinaerTreNode<T> p) {

		int heightLeft = 0;
		int heightRight = 0;

		if (p.getVenstre() != null)
			heightLeft = finnHoydeRek(p.getVenstre());
		if (p.getHoyre() != null)
			heightRight = finnHoydeRek(p.getHoyre());
		if (heightLeft > heightRight) {
			return heightLeft + 1;
		} else {
			return heightRight + 1;
		}
	}

	public int teoretiskMinHoyde() {
		int n = antall();
		int h = (int) (Math.log(n) / Math.log(2));

		return h;
	}

	@Override
	public Iterator<T> iterator() {
		return new InordenIterator<T>(rot);

	}

}// class
