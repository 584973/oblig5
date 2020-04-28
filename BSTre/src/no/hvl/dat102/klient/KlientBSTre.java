package no.hvl.dat102.klient;

import java.util.Random;

import no.hvl.dat102.KjedetBSTre;

public class KlientBSTre {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		//test(); // kommer med informasjon fra flere tretester
		test2();
		
		
	}
	
	
	public static void test () {
		int antallNoder = 8192; // Antall noder pr tre
		int antallTre = 100; // Antall trær
		int minstehoyde = Integer.MAX_VALUE;
		int storsthoyde = Integer.MIN_VALUE;
		int trehoyde = 0;
		double gjennomsnittet = 0;

		Random terning = new Random();

		// Loop for å lage alle træra
		for (int i = 0; i < antallTre; i++) {

			KjedetBSTre bstre = new KjedetBSTre();

			// Loop for å fylle hvert enkelte tre
			for (int j = 0; j < antallNoder; j++) {

				bstre.leggTil(terning.nextInt(100));
			}
			trehoyde = bstre.finnHoyde();
			gjennomsnittet += trehoyde;

			minstehoyde = Math.min(trehoyde, minstehoyde);
			storsthoyde = Math.max(trehoyde, storsthoyde);

		}

		System.out.println("Antall noder pr tre " + antallNoder);

		System.out.println("Teoretisk maksimal høyde: " + (antallNoder - 1));

		System.out.println("Teoretisk minimal høyde: " + ((int) (Math.log((antallNoder+1)-1) / Math.log(2))));

		System.out.println("Største høyde fra gjennomkjøring: " + storsthoyde);

		System.out.println("Minste høyde fra gjennomkjøring: " + minstehoyde);

		System.out.println("Gjennomsnittlig høyde: " + ((double)gjennomsnittet / antallTre));

	}
	
	public static void test2() {
		
		
		KjedetBSTre bstre = new KjedetBSTre();

		bstre.leggTil(7);
		bstre.leggTil(5);
		bstre.leggTil(6);
	/*	bstre.leggTil(4);
		bstre.leggTil(9);
		bstre.leggTil(10);
		bstre.leggTil(8);
		bstre.leggTil(3);
		*/
		
		bstre.visInorden();
		bstre.fjernMin();
		bstre.visInorden();
	}

}
