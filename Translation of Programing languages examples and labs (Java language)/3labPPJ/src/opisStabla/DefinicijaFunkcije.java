package opisStabla;

import java.util.List;

public class DefinicijaFunkcije extends Cvor {
	
	public DefinicijaFunkcije(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<ime_tipa>IDNL_ZAGRADAKR_VOIDD_ZAGRADA<slozena_naredba>")) {
			Cvor c1 = djeca.get(1);
			imeFunkcije = new String(c1.vrijednost);
			Cvor c0 = djeca.get(0);
			Cvor c5 = djeca.get(5);
			c0.provjeri();
			if(c0.tip.getJtip() == Tip.CCHAR || c0.tip.getJtip() == Tip.CINT) {
				System.err.println(ime + " Tip je konstantni");
				greska();//TODO dodaj
			}
			//postoji li prije definirana funkcija
			boolean provjera = true;
			String ime = imeFunkcije;
			Tip t = djelokrug.getNadredeni().jeDeklarirano(ime); //TODO djelokrug
			if(t != null && t.isFun()) {
				if(t.getDefinirana() == 2) provjera = false;
				List<Integer> ftip = t.getFtip();
				if(ftip.get(0) != c0.tip.getJtip()) provjera = false;
				if(ftip.get(1) != Tip.VOID) provjera = false;
			}
			if(! provjera) {
				System.err.println(ime + " Problem se prethodnom definicijom ");
				greska();//TODO dodaj
			}
			
			//zabiljezi definiciju i deklaraciju funkcije
			Tip zaUpis = new Tip(1);
			zaUpis.setDefinirana(2);
			List<Integer> ftip = zaUpis.getFtip();
			ftip.add(c0.tip.getJtip());
			ftip.add(Tip.VOID);
			djelokrug.getNadredeni().getTablica().put(ime, zaUpis);
			djelokrug.getTablica().put(ime, zaUpis);//TODO djelokrug
			
			c5.provjeri();
			
			
		} else if(odluka.equals("<ime_tipa>IDNL_ZAGRADA<lista_parametara>D_ZAGRADA<slozena_naredba>")) {
			Cvor c1 = djeca.get(1);
			imeFunkcije = new String(c1.vrijednost);
			Cvor c0 = djeca.get(0);
			Cvor c3 = djeca.get(3);
			Cvor c5 = djeca.get(5);
			
			c0.provjeri();
			if(c0.tip.getJtip() == Tip.CCHAR || c0.tip.getJtip() == Tip.CINT) {
				System.err.println(ime + " Tip je konstantni");
				greska();//TODO dodaj
			}
			
			//postoji li prije definirana funkcija
			boolean provjera = true;
			String ime = imeFunkcije;
			Tip t = djelokrug.getNadredeni().jeDeklarirano(ime); //TODO djelokrug
			if(t != null && t.isFun()) {
				if(t.getDefinirana() == 2) provjera = false;
			}
			if(! provjera) {
				System.err.println(ime + " Prije definirano");
				greska();//TODO dodaj
			}
			c3.provjeri();
			
			//provjera prethodne deklaracije
			if(t != null && t.isFun()) {
				if(t.getFtip().get(0) != c0.tip.getJtip()) provjera = false;
				if(t.getFtip().size() == c3.tipovi.size() + 1) {
					for(int i=0; i < c3.tipovi.size(); i++) {
						if(c3.tipovi.get(i) != t.getFtip().get(i+1)) {
							provjera = false;
							break;
						}
					}
				} else {
					provjera = false;
				}
			}
			if(! provjera) {
				System.err.println(ime + " Prethodna deklaracija");
				greska();//TODO dodaj
			}
			
			//zabiljezi definiciju i deklaraciju funkcije
			Tip zaUpis = new Tip(1);
			zaUpis.setDefinirana(2);
			List<Integer> ftip = zaUpis.getFtip();
			ftip.add(c0.tip.getJtip());
			for(int i : c3.tipovi) {
				ftip.add(i);
			}
			djelokrug.getNadredeni().getTablica().put(ime, zaUpis);
			djelokrug.getTablica().put(ime, zaUpis);//TODO djelokrug
			
			c5.provjeri();
			
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
