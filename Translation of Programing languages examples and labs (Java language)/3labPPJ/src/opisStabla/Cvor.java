package opisStabla;
import java.util.ArrayList;
import java.util.List;


public abstract class Cvor {
	
	public static final int maxInt = 2147483647;
	public static final int minInt = -2147483648;
	public static final int minChar = 0;
	public static final int maxChar = 255;
	
	protected boolean jeList;
	protected int lIzraz;
	protected Tip ntip;
	protected Tip tip; // TODO = new Tip(0)
	protected List<Cvor> djeca;
	protected Cvor roditelj;
	protected String ime;
	protected Djelokrug djelokrug;
	protected List<Integer> tipovi;
	/**
	 * imena tipova
	 */
	protected List<String> imena;
	protected String brRedak;
	protected String vrijednost;
	protected boolean petlja;
	/**
	 * Ime funkcije unutar koje se nalazi cvor, <br>
	 * ako je null onda nije unutar funkcije
	 */
	protected String imeFunkcije;

	
	public Cvor(String ime) {	
		petlja = false;
		tip = new Tip(0);
		this.ime = ime;
		tipovi = new ArrayList<Integer>();
		djeca = new ArrayList<Cvor>(); 
		if(ime.charAt(0)=='<') {
			jeList = false;
		} else {
			jeList = true;
		}
		
	}
	
	abstract public void provjeri();

	public boolean isJeList() {
		return jeList;
	}

	public void setJeList(boolean jeList) {
		this.jeList = jeList;
	}

	public int getlIzraz() {
		return lIzraz;
	}

	public void setlIzraz(int lIzraz) {
		this.lIzraz = lIzraz;
	}

	public Tip getNtip() {
		return ntip;
	}

	public void setNtip(Tip ntip) {
		this.ntip = ntip;
	}

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}

	public List<Cvor> getDjeca() {
		return djeca;
	}

	public void setDjeca(List<Cvor> djeca) {
		this.djeca = djeca;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public List<Integer> getTipovi() {
		return tipovi;
	}

	public void setTipovi(List<Integer> tipovi) {
		this.tipovi = new ArrayList<Integer>(tipovi);
	}
	
	
	public boolean isPetlja() {
		return petlja;
	}

	public void setPetlja(boolean petlja) {
		this.petlja = petlja;
	}

	public String getImeFunkcije() {
		return imeFunkcije;
	}

	public void setImeFunkcije(String imeFunkcije) {
		this.imeFunkcije = imeFunkcije;
	}
	
	

	public Djelokrug getDjelokrug() {
		return djelokrug;
	}

	public void setDjelokrug(Djelokrug djelokrug) {
		this.djelokrug = djelokrug;
	}

	public List<String> getImena() {
		return imena;
	}

	public void setImena(List<String> imena) {
		this.imena = imena;
	}

	public String getBrRedak() {
		return brRedak;
	}

	public void setBrRedak(String brRedak) {
		this.brRedak = brRedak;
	}

	public String getVrijednost() {
		return vrijednost;
	}

	public void setVrijednost(String vrijednost) {
		this.vrijednost = vrijednost;
	}
	
	

	public Cvor getRoditelj() {
		return roditelj;
	}

	public void setRoditelj(Cvor roditelj) {
		this.roditelj = roditelj;
	}

	/**
	 *
	 * @return Funkcija vraca imena djece promatranog cvora, nanizana bez razmaka, u jednom stringu
	 */
	protected String imenaDjece() {
		String vrati="";
		if(djeca != null) {
			for(Cvor c:djeca) {
				vrati +=c.ime;
			}
		}
		return vrati;
	}
	
	/**
	 * Metoda provjerava da li se tip prvi implicitno moze svesti na tip drugi
	 * @param prvi
	 * @param drugi
	 * @return
	 */
	public boolean jeSvodiv(int prvi, int drugi) {
		boolean vrati = true;
		switch(prvi) {
		case Tip.CCHAR:
			if( drugi == Tip.NIZCCHAR || drugi == Tip.NIZCHAR || drugi == Tip.NIZCINT || drugi == Tip.NIZINT 
				|| drugi == Tip.VOID) vrati = false;
			break;
		case Tip.CHAR:
			if( drugi == Tip.NIZCCHAR || drugi == Tip.NIZCHAR || drugi == Tip.NIZCINT || drugi == Tip.NIZINT 
			|| drugi == Tip.VOID ) vrati = false;
			break;
		case Tip.CINT:
			if(drugi == Tip.CCHAR || drugi == Tip.CHAR || drugi == Tip.NIZCCHAR || drugi == Tip.NIZCHAR
			|| drugi == Tip.NIZCINT || drugi == Tip.NIZINT || drugi == Tip.VOID) vrati = false;
			break;
		case Tip.INT:
			if(drugi == Tip.CCHAR || drugi == Tip.CHAR || drugi == Tip.NIZCCHAR || drugi == Tip.NIZCHAR
				|| drugi == Tip.NIZCINT || drugi == Tip.NIZINT || drugi == Tip.VOID) vrati = false;
			break;
		case Tip.NIZCCHAR:
			vrati = false;
			if(drugi == Tip.NIZCCHAR) vrati = true;
			break;
		case Tip.NIZCHAR:
			vrati = false;
			if(drugi == Tip.NIZCHAR || drugi == Tip.NIZCCHAR) vrati = true;
			break;
		case Tip.NIZCINT:
			vrati = false;
			if(drugi == Tip.NIZCINT) vrati = true;
			break;
		case Tip.NIZINT:
			vrati = false;
			if(drugi == Tip.NIZCINT || drugi == Tip.NIZINT) vrati = true;
			break;
		case Tip.VOID:
			vrati = false;
			if(drugi == Tip.VOID) vrati = true;
			break;
		}
		return vrati;
	}
	
	public void greska() {
		System.out.print(ime + " ::= ");
		if(djeca != null) {
			for(int i = 0; i < djeca.size() - 1; i++) {
				Cvor c = djeca.get(i);
				if(c.ime.charAt(0) == '<') {
					System.out.print(c.ime + " ");
				} else {
					System.out.print(c.ime + "(" + c.brRedak +
							"," + c.vrijednost + ") ");
				}
			}
			Cvor c = djeca.get(djeca.size() - 1);
			if(c.ime.charAt(0) == '<') {
				System.out.println(c.ime);
			} else {
				System.out.println(c.ime + "(" + c.brRedak +
						"," + c.vrijednost + ")");
			}
		}
		/*
		//pomocni ispis djelokruga
		Djelokrug pom;
		pom = djelokrug;
		Set<String> kljucevi = pom.getTablica().keySet();
		System.err.println("djelokrug:");
		for(String s : kljucevi) {
			System.err.println(s);
		}
		while(pom.getNadredeni() != null) {
			pom = pom.getNadredeni();
			kljucevi = pom.getTablica().keySet();
			System.err.println("djelokrug:");
			for(String s : kljucevi) {
				System.err.println(s);
			}
		}
		//************
		 */
		System.exit(0);
		
	}
	
	
	

	
}
