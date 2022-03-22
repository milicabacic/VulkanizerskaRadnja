package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma ag;
	
	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma(); 
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}

	@Test
	void testAutoGuma() {
		ag = new AutoGuma();
		
		assertNotNull(ag);
	}

	@Test
	void testAutoGumaStringIntIntInt() {

		ag = new AutoGuma("Michelin", 15, 150, 50);
		
		assertNotNull(ag);
		assertEquals("Michelin", ag.getMarkaModel());
		assertEquals(15, ag.getPrecnik());
		assertEquals(150, ag.getSirina());
		assertEquals(50, ag.getVisina());
	
	}

	@Test
	void testSetMarkaModel() {
		
		ag.setMarkaModel("Michelin");
		
		assertEquals("Michelin", ag.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelNullVrednost() {
		
		assertThrows(java.lang.NullPointerException.class,  
				() -> ag.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelBrKaraktera() {
		
		assertThrows(java.lang.IllegalArgumentException.class, 
				() -> ag.setMarkaModel("M"));
	}
	
	@Test
	void testSetMarkaModelPrazanString() {
		
		assertThrows(java.lang.IllegalArgumentException.class, 
				() -> ag.setMarkaModel(""));
	}

	@ParameterizedTest
	@CsvSource({
		"13",
		"22",
		"15",
		"19",
		"21"
	})
	void testSetPrecnik(int precnik) {
		ag.setPrecnik(precnik);
		
		assertEquals(precnik, ag.getPrecnik());
	}
	
	//u ovom testu trebalo bi da budu prijavljene greske ukoliko je precnik van opsega, medjutim u metodi je za uslov stavljeno greskom && umesto ||
	@ParameterizedTest
	@CsvSource({
		"5",
		"29"
	})
	void testSetPrecnikVanIntervala(int precnik) {
		
		assertThrows(java.lang.IllegalArgumentException.class, 
				() -> ag.setPrecnik(precnik));
		
	}

	@ParameterizedTest
	@CsvSource({
		"135",
		"355",
		"178"
	})
	void testSetSirina(int sirina) {
		ag.setSirina(sirina);
		
		assertEquals(sirina, ag.getSirina());
	}
	
	@ParameterizedTest
	@CsvSource({
		"134",
		"356"
	})
	void testSetSirinaVanIntervala(int sirina) {
		assertThrows(java.lang.IllegalArgumentException.class, 
				() -> ag.setSirina(sirina));
	}

	@ParameterizedTest
	@CsvSource({
		"25",
		"95",
		"78"
	})
	void testSetVisina(int visina) {
		ag.setVisina(visina);
		
		assertEquals(visina, ag.getVisina());
	}
	
	@ParameterizedTest
	@CsvSource({
		"24",
		"96"
	})
	void testSetVisinaVanIntervala(int visina) {
		assertThrows(java.lang.IllegalArgumentException.class, 
				()->ag.setVisina(visina));
	}
	

	@Test
	void testToString() {
		ag = new AutoGuma("Good Year", 17, 170, 70);
		
		String string = ag.toString();
		
		assertEquals("AutoGuma [markaModel=Good Year, precnik=17, sirina=170, visina=70]", string);
	}

	@ParameterizedTest
	@CsvSource({
		"Michelin, Michelin, 15, 15, 150, 150, 50, 50, true",
		"Michelin, Good Year, 15, 17, 150, 150, 50, 50, false",
		"Michelin, Michelin, 15, 15, 150, 170, 50, 50, false",
		"Michelin, Michelin, 15, 15, 150, 150, 50, 70, false"
	})
	void testEqualsObject(String marka1, String marka2, int precnik1, int precnik2, int sirina1, int sirina2, int visina1, int visina2, boolean rezultat) {
		ag = new AutoGuma(marka1, precnik1, sirina1, visina1);
		
		AutoGuma ag2 = new AutoGuma(marka2, precnik2, sirina2, visina2);
		
		assertEquals(rezultat, ag.equals(ag2));
	}

}
