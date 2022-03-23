package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {
	
	protected Radnja vulkanizerskaRadnja;


	@Test
	void testDodajGumu() {
		
		AutoGuma ag = new AutoGuma("Michelin", 15, 150, 70);
		
		vulkanizerskaRadnja.dodajGumu(ag);
		
		assertEquals(1, vulkanizerskaRadnja.vratiSveGume().size());
		assertEquals(ag, vulkanizerskaRadnja.vratiSveGume().get(0));
		assertTrue(vulkanizerskaRadnja.vratiSveGume().contains(ag));
	}
	
	@Test
	void testDodajGumuNullVrednost() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> vulkanizerskaRadnja.dodajGumu(null));
	}
	
	@Test
	void testDodajGumuVecPostojiGuma() {
		
		AutoGuma ag = new AutoGuma("Michelin", 15, 180, 70);
		vulkanizerskaRadnja.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma("Michelin", 15, 180, 70);
		
		assertThrows(java.lang.RuntimeException.class, 
				() -> vulkanizerskaRadnja.dodajGumu(ag2));
	}

	@Test
	void testPronadjiGumuMarkaModelNull() {
		assertEquals(null, vulkanizerskaRadnja.pronadjiGumu(null));
	}
	
	@Test
	void testPronadjiGumuNepostojecaMarka() {
		AutoGuma ag = new AutoGuma("Michelin", 15, 150, 70);
		vulkanizerskaRadnja.dodajGumu(ag);
		//niz nije null, vec je inicijalizovan na prazan niz
		//assertEquals(null, vulkanizerskaRadnja.pronadjiGumu("Good Year"));
		assertEquals(0, vulkanizerskaRadnja.pronadjiGumu("Good Year").size());
		assertTrue(vulkanizerskaRadnja.pronadjiGumu("Good Year").isEmpty());
	}
	
	@Test
	void testPronadjiGumuViseIsteMarke() {
		AutoGuma ag = new AutoGuma("Michelin", 15, 150, 70);
		vulkanizerskaRadnja.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma("Michelin", 17, 160, 90);
		vulkanizerskaRadnja.dodajGumu(ag2);
		
		AutoGuma ag3 = new AutoGuma("Michelin", 18, 190, 80);
		vulkanizerskaRadnja.dodajGumu(ag3);
		
		assertEquals(3, vulkanizerskaRadnja.pronadjiGumu("Michelin").size());
		assertNotEquals(vulkanizerskaRadnja.vratiSveGume().get(0).getSirina(), vulkanizerskaRadnja.vratiSveGume().get(1).getSirina());
		assertNotEquals(vulkanizerskaRadnja.vratiSveGume().get(0).getVisina(), vulkanizerskaRadnja.vratiSveGume().get(1).getVisina());
		assertNotEquals(vulkanizerskaRadnja.vratiSveGume().get(0).getPrecnik(), vulkanizerskaRadnja.vratiSveGume().get(1).getPrecnik());
	}
	

	@Test
	void testVratiSveGume() {
		AutoGuma ag = new AutoGuma("Michelin", 15, 150, 70);
		vulkanizerskaRadnja.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma("Good Year", 18, 180, 90);
		vulkanizerskaRadnja.dodajGumu(ag2);
		
		assertEquals(2, vulkanizerskaRadnja.vratiSveGume().size());
	}
	
	@Test
	void testVratiSveGumePraznaRadnja() {
		assertEquals(0, vulkanizerskaRadnja.vratiSveGume().size());
	}

}
