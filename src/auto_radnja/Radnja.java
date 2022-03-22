package auto_radnja;

import java.util.List;

import auto_radnja.gume.AutoGuma;

/**
 * Omogucava specifikaciju metoda koje omogucavaju rad vulkanizerske radnje.
 * 
 * @author Milica Bacic
 * 
 */
public interface Radnja {
	/**
	 * Dodaje odgovarajucu gumu koja je prosledjena kao ulazni parametar.
	 * 
	 * @param a Guma koja se dodaje u radnju
	 */
	void dodajGumu(AutoGuma a);
	/**
	 * Pronalazi sve gume koja su istog model marke kao prosledjena vrednost.
	 * 
	 * @param markaModel Marka modela na osnovu koje se pretrazuje radnja
	 * @return Lista svih guma koje su datog modela marke
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);
	/**
	 * Vraca listu svih guma koje su u radnji.
	 * 
	 * @return Sve gume u radnji
	 */
	List<AutoGuma> vratiSveGume();
	}