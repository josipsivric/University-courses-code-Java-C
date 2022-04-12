package opisStabla;

public class NaredbaSkoka extends Cvor {
	
	public NaredbaSkoka(String ime) {
		super(ime);
	}


	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("KR_CONTINUETOCKAZAREZ") ||
				odluka.equals("KR_BREAKTOCKAZAREZ")) {
			Cvor pom = this;
			boolean provjera = false;
			if(pom.petlja) provjera = true;
			while(pom.roditelj != null) {
				if(pom.petlja) {
					provjera = true;
					break;
				}
				pom = pom.roditelj;
			}
			if(! provjera) {
				greska();
			}
		} else if (odluka.equals("KR_RETURNTOCKAZAREZ")) {
			Cvor pom = this;
			boolean provjera = false;
			if(pom.imeFunkcije != null) {
				Tip t;
				if((t=djelokrug.jeDeklarirano(imeFunkcije)) != null) {
					if (t.getFtip().get(0) == Tip.VOID) provjera = true;
				}
			}
			while(pom.roditelj != null) {
				Tip t;
				pom = pom.roditelj;
				if(pom.imeFunkcije != null) {
					if((t=djelokrug.jeDeklarirano(imeFunkcije)) != null) {
						if (t.getFtip().get(0) == Tip.VOID) {
							provjera = true;
							break;
						}
					}
				}					
			}
			
			if(! provjera) {
				greska();//TODO dodaj
			}
		} else if(odluka.equals("KR_RETURN<izraz>TOCKAZAREZ")) {
			Cvor c1 = djeca.get(1);
			c1.provjeri();
			Cvor pom = this;
			boolean provjera = false;
			if(pom.imeFunkcije != null) {
				//provjera = true; //TODO nije dobro
				Tip t;
				if((t=djelokrug.jeDeklarirano(pom.imeFunkcije)) != null) {
					if(jeSvodiv(c1.tip.getJtip(), t.getFtip().get(0))) provjera = true;
					if(t.getFtip().get(0) == Tip.CHAR || t.getFtip().get(0) == Tip.CCHAR) {
						if(c1.tip.getJtip() == Tip.INT || c1.tip.getJtip() == Tip.CINT) {
							provjera = false;
						}
					}
				} else {
					System.err.println("nije deklarirano");
				}
			}
			while(pom.roditelj != null) {
				pom = pom.roditelj;
				Tip t;
				if(pom.imeFunkcije != null) {
					//provjera = true; //TODO nije dobro
					if((t=djelokrug.jeDeklarirano(pom.imeFunkcije)) != null) {
						if(jeSvodiv(c1.tip.getJtip(), t.getFtip().get(0))) {
							provjera = true;
							break;
						}
						if(t.getFtip().get(0) == Tip.CHAR || t.getFtip().get(0) == Tip.CCHAR) {
							if(c1.tip.getJtip() == Tip.INT || c1.tip.getJtip() == Tip.CINT) {
								provjera = false;
							}
						}
					} else {
						System.err.println("nije deklarirano");
					}
				}			
			}
			if(! provjera) {
				greska();//TODO dodaj
			}
		} else {
			System.err.println("Moja greska u:" + ime);
		}
		
	}

}
