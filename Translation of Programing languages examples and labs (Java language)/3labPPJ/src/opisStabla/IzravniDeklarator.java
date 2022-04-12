package opisStabla;

public class IzravniDeklarator extends Cvor {
	
	public IzravniDeklarator(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("IDN")) {
			if(ntip.getJtip() == Tip.VOID) {
				greska();//TODO dodaj
			}
			if(djelokrug.getTablica().get(djeca.get(0).vrijednost) != null) {
				greska();//TODO dodaj
			}
			tip = ntip;
			Tip t = new Tip(tip);
			djelokrug.getTablica().put(djeca.get(0).vrijednost, t);
		} else if(odluka.equals("IDNL_UGL_ZAGRADABROJD_UGL_ZAGRADA")) {
			if(ntip.getJtip() == Tip.VOID) {
				greska();//TODO dodaj
			}
			if(djelokrug.getTablica().get(djeca.get(0).vrijednost) != null) {
				greska();//TODO dodaj
			}
			int broj = 1025;
			try {
				broj = Integer.parseInt(djeca.get(2).vrijednost);
			} catch (NumberFormatException e) {
				greska();//TODO dodaj
			}
		
			if(broj <= 0 || broj > 1024) {
				greska();//TODO dodaj
			}
			int pom = 20; //nesto bezveze
			switch(ntip.getJtip()) {
			case Tip.INT:
				pom = Tip.NIZINT;
				break;
			case Tip.CHAR:
				pom = Tip.NIZCHAR;
				break;
			case Tip.CCHAR:
				pom = Tip.NIZCCHAR;
				break;
			case Tip.CINT:
				pom = Tip.NIZCINT;
				break;
			}
			tip.setJtip(pom);
			tip.setBrelem(broj);
			Tip t = new Tip(tip);
			djelokrug.getTablica().put(djeca.get(0).vrijednost, t);
			
		} else if(odluka.equals("IDNL_ZAGRADAKR_VOIDD_ZAGRADA")) {
			String pomIme = djeca.get(0).vrijednost;
			Tip pom;
			//tocka 1
			boolean provjera = true;
			if((pom = djelokrug.getTablica().get(pomIme)) != null) {
				if(pom.isFun()) {
					if(pom.getFtip().get(0) != ntip.getJtip()) provjera = false;
					if(pom.getFtip().get(1) != Tip.VOID) provjera = false; 
				}
			}
			if(! provjera) {
				greska();//TODO dodaj
			}
			
			Tip t = new Tip(1);
			t.getFtip().add(ntip.getJtip());
			t.getFtip().add(Tip.VOID);
			
			tip = t;
			
			t = new Tip(tip);
			djelokrug.getTablica().put(pomIme, t);
			
			
		} else if(odluka.equals("IDNL_ZAGRADA<lista_parametara>D_ZAGRADA")) {
			Cvor c2 = djeca.get(2);
			c2.provjeri();
			
			//tocka 2
			Tip pom;
			String pomIme = djeca.get(0).vrijednost;
			boolean provjera = true;
			if((pom = djelokrug.getTablica().get(pomIme)) != null) {
				if(pom.isFun()) {
					if(pom.getFtip().get(0) != ntip.getJtip()) provjera = false;
					if(pom.getFtip().size() != c2.tipovi.size() + 1) {
						provjera = false;
					} else {
						for(int i = 0; i < c2.tipovi.size(); i++) {
							if(c2.tipovi.get(i) != pom.getFtip().get(i+1)) {
								provjera = false;
								break;
							}
						}
					}
				}
			}
			if(! provjera) {
				greska();//TODO dodaj
			}
			
			Tip t = new Tip(1);
			t.getFtip().add(ntip.getJtip());
			for(int i : c2.tipovi) {
				t.getFtip().add(i);
			}
			
			tip = t;
			
			t = new Tip(tip);
			djelokrug.getTablica().put(pomIme, t);
			
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
