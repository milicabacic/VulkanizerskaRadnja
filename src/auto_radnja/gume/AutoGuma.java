package auto_radnja.gume;

/**
 * Klasa koja predstavlja gumu za automobil.
 * 
 * Auto guma se odlikuje odgovarajucom markom modela (String), precnikom, sirinom i visinom (int).
 * 
 * @author Milica Bacic
 *
 */
public class AutoGuma {
	/**
	 * Marka modela gume u vidu tekstualne promenljive.
	 * 
	 * Default vrednost marke je null.
	 */
	private String markaModel = null;
	/**
	 * Precnik gume u vidu celobrojne vrednosti.
	 * 
	 * Pocetna vrednost precnika je -1.
	 */
	private int precnik = -1;
	/**
	 * Sirina gume u vidu celobrojne vrednosti.
	 * 
	 * Pocetna vrednost sirine je -1.
	 */
	private int sirina = -1;
	/**
	 * Visina gume u vidu celobrojne vrednosti.
	 * 
	 * Pocetna vrednost visine je -1.
	 */
	private int visina = -1;
	
	/**
	 * Konstruktor klase AutoGuma koji inicijalizuje objekat ove klase.
	 */
	public AutoGuma() {
		
	}
	
	/**
	 * Konstruktor klase AutoGuma koji postavlja vrednosti marke modela, precnika, sirine i visine.
	 * 
	 * @param markaModel Marka modela gume kao tekstualna vrednost
	 * @param precnik Precnik gume kao celobrojna vrednost
	 * @param sirina Sirina gume kao celobrojna vrednost
	 * @param visina Visina gume kao celobrojna vrednost
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
		}
	
	/**
	 * Metoda koja vraca naziv marke odredjenog modela gume.
	 * 
	 * @return Marka modela gume
	 */
	public String getMarkaModel() {
		return markaModel;
		}
	
	/**
	 * Postavlja vrednost marke modela na odgovarajucu vrednost.
	 * 
	 * Ukoliko je prosledjena vrednost null ili je naziv kraci od tri karaktera, baca se odgovarajuci izuzetak.
	 * 
	 * @param markaModel naziv marke modela gume kao tekstualna vrednost
	 * 
	 * @throws java.lang.NullPointerException Ukoliko je uneta vrednost naziva marke gume null
	 * @throws java.lang.IllegalArgumentException Ukoliko je naziv marke modela String sa manje od 3 karaktera
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel==null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length()<3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		
		this.markaModel = markaModel;
		}
	/**
	 * Vraca vrednost precnika gume kao celobrojnu vrednost.
	 * 
	 * @return Precnik gume kao int vrednost
	 */
	public int getPrecnik() {
		return precnik;
		}
	
	/**
	 * Postavlja vrednost precnika gume na osnovu prosledjene vrednosti.
	 * 
	 * Ukoliko je vrednost precnika van intervala [13,22], baca se izuzetak.
	 * 
	 * @param precnik Vrednost precnika gume kao int vrednost
	 * 
	 * @throws java.lang.IllegalArgumentException Ukoliko vrednost precnika nije u intervalu [13,22]
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		
		this.precnik = precnik;
		}
	
	/**
	 * Vraca sirinu gume kao celobrojnu vrednost.
	 * 
	 * @return Sirina gume kao int vrednost
	 */
	public int getSirina() {
		return sirina;
	}
	
	/**
	 * Postavlja vrednost sirine gume na osnovu prosledjene celobrojne vrednosti.
	 * 
	 * Ukoliko prosledjena sirina gume nije u intervalu [135,355], baca se izuzetak.
	 * 
	 * @param sirina Sirina gume kao int vrednost
	 * 
	 * @throws java.lang.IllegalArgumentException Ukoliko prosledjena sirina gume nije u intervalu [135,355]
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		
		this.sirina = sirina;
		}
	
	/**
	 * Vraca visinu gume kao celobrojnu vrednost.
	 * 
	 * @return Visina gume kao int vrednost
	 */
	public int getVisina() {
		return visina;
		
	 }
	
	/**
	 * Postavlja visinu gume na osnovu prosledjenje celobrojne vrednost.
	 * 
	 * Ukoliko visina gume nije u intervalu [25,95], baca se izuzetak.
	 *
	 * @param visina Visina gume kao int vrednost
	 * 
	 * @throws java.lang.IllegalArgumentException Ukoliko prosledjena visina gume nije u intervalu [25,95]
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		
		this.visina = visina;
		}
	
	/**
	 * @return Vraca String koji sadrzi sve podatke o auto gumi.
	 */
	@Override
	public String toString() {
		return"AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina=" + visina + "]";
		}
	
	/**
	 * Poredi dve auto gume i vraca vrednost true u slucaju da su iste, a false u slucaju da nisu.
	 * 
	 * Poredi gume na osnovu naziva marke modela, precnika, sirine i visine i svi parametri moraju biti isti.
	 * 
	 * @return 
	 * <ul>
	 * 		<li>true ukoliko su auto gume jednake po svim navedenim parametrima</li>
	 * 		<li>false ukoliko auto gume nisu jednake po svim navedenim parametrima</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
			} else if (!markaModel.equals(other.markaModel))
		return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
		}
	}