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
		int antallTre = 100; // Antall tr�r
		int minstehoyde = Integer.MAX_VALUE;
		int storsthoyde = Integer.MIN_VALUE;
		int trehoyde = 0;
		double gjennomsnittet = 0;

		Random terning = new Random();

		// Loop for � lage alle tr�ra
		for (int i = 0; i < antallTre; i++) {

			KjedetBSTre bstre = new KjedetBSTre();

			// Loop for � fylle hvert enkelte tre
			for (int j = 0; j < antallNoder; j++) {

				bstre.leggTil(terning.nextInt(100));
			}
			trehoyde = bstre.finnHoyde();
			gjennomsnittet += trehoyde;

			minstehoyde = Math.min(trehoyde, minstehoyde);
			storsthoyde = Math.max(trehoyde, storsthoyde);

		}

		System.out.println("Antall noder pr tre " + antallNoder);

		System.out.println("Teoretisk maksimal h�yde: " + (antallNoder - 1));

		System.out.println("Teoretisk minimal h�yde: " + ((int) (Math.log((antallNoder+1)-1) / Math.log(2))));

		System.out.println("St�rste h�yde fra gjennomkj�ring: " + storsthoyde);

		System.out.println("Minste h�yde fra gjennomkj�ring: " + minstehoyde);

		System.out.println("Gjennomsnittlig h�yde: " + ((double)gjennomsnittet / antallTre));

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
