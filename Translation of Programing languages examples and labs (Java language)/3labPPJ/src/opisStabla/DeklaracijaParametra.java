package opisStabla;

public class DeklaracijaParametra extends Cvor {
	
	public DeklaracijaParametra(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<ime_tipa>IDN")) {
			Cvor c0 = djeca.get(0);
			c0.provjeri();
			if(c0.tip.getJtip() == Tip.VOID) {
				greska();//TODO dodaj
			}
			tip = new Tip(c0.tip);
			vrijednost = djeca.get(1).vrijednost;
			Tip t = new Tip(tip);
			djelokrug.getTablica().put(vrijednost, t);
		} else if (odluka.equals("<ime_tipa>IDNL_UGL_ZAGRADAD_UGL_ZAGRADA")) {
			Cvor c0 = djeca.get(0);
			c0.provjeri();
			if(c0.tip.getJtip() == Tip.VOID) {
				greska();//TODO dodaj
			}
			
			int t = 0;
			switch(c0.tip.getJtip()) {
			case Tip.CCHAR :
				t = Tip.NIZCCHAR;
				break;
			case Tip.CHAR : 
				t = Tip.NIZCHAR;
				break;
			case Tip.CINT : 
				t = Tip.NIZCINT;
				break;
			case Tip.INT :
				t = Tip.NIZINT;
				break;
			default : 
				System.err.println("Moja greska * u " + ime);
			}
			tip.setJtip(t);
			vrijednost = djeca.get(1).vrijednost;
			
			Tip tp = new Tip(tip);
			djelokrug.getTablica().put(vrijednost, tp);
					
		} else {
			System.err.println("Moja greska u:" + ime);
		}
	}

}
