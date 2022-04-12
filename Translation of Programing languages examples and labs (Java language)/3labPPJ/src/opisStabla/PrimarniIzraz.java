package opisStabla;

public class PrimarniIzraz extends Cvor {
	
	public PrimarniIzraz(String ime) {
		super(ime);		
	}
	
	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("IDN")) {
			Cvor c = djeca.get(0);
			String ime = c.vrijednost;
			Tip pom;
			if((pom = djelokrug.jeDeklarirano(ime)) == null) { 
				greska(); //TODO dodaj
			} else {
				tip = new Tip(pom);
				if(pom.getJtip() == Tip.CHAR || pom.getJtip() == Tip.INT) {
					lIzraz = 1;
				} else {
					lIzraz = 0;
				}
			}
			
		} else if(odluka.equals("BROJ")) {
			Cvor c = djeca.get(0);
			tip.setJtip(Tip.INT);
			lIzraz = 0;
			int broj = 0;
			try {
				broj = Integer.parseInt(c.vrijednost);
			} catch(NumberFormatException e) {
				greska(); //TODO dodaj
			}
			
			if(broj <= Cvor.minInt || broj >= Cvor.maxInt) {
				greska(); //TODO dodaj
			}
		} else if(odluka.equals("ZNAK")) {
			tip.setJtip(Tip.CHAR);
			lIzraz = 0;
			//provjeri  znak
			boolean provjera = true;
			Cvor c = djeca.get(0);
			String znak = c.vrijednost;
			if(znak.length() > 3) {
				char izaBS = znak.charAt(2);
				if(izaBS == 't' || izaBS == 'n' || izaBS == '0' || izaBS == '\'' || izaBS == '"' || izaBS =='\\') {
					provjera = true;
				} else {
					provjera = false;
				}
			}
			if(!provjera) {
				greska(); //TODO dodaj
			}
			
		} else if(odluka.equals("NIZ_ZNAKOVA")) {
			tip.setJtip(Tip.NIZCCHAR);
			lIzraz = 0;
			//provjeri niz znakova
			boolean provjera = true;
			Cvor c = djeca.get(0);
			String niz = c.vrijednost;
			int i = 0;
			while(i < niz.length()) {
				if(niz.charAt(i) == '\\') {
					i++;
					char z = niz.charAt(i);
					if(!(z == 't' || z == 'n' || z == '0' || z == '\'' || z == '"' || z =='\\')) {
						provjera = false;
						break;
					}
				}
				i++;
			}
			if(niz.charAt(niz.length() - 2) == '\\') provjera = false;
			if(!provjera) {
				greska();//TODO dodaj
			}
			
		} else if(odluka.equals("L_ZAGRADA<izraz>D_ZAGRADA")) {
			Cvor c = djeca.get(1);
			c.provjeri();
			tip = new Tip(c.tip);
			lIzraz = c.lIzraz;
		} else {
			System.err.println("Moja greska u:" + ime);
		}
	}
}
