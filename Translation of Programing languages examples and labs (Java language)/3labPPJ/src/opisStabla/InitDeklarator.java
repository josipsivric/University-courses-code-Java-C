package opisStabla;

public class InitDeklarator extends Cvor {
	
	public InitDeklarator(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<izravni_deklarator>")) {
			Cvor c0 = djeca.get(0);
			c0.ntip = ntip;
			c0.provjeri();
			
			//provjera da nije const
			boolean provjera = true;
			int t = c0.tip.getJtip();
			if(t == Tip.CCHAR || t == Tip.CINT || t == Tip.NIZCCHAR || t == Tip.NIZCINT) {
				provjera = false;
			}
			if(! provjera) {
				greska();//TODO dodaj
			}
			
		} else if(odluka.equals("<izravni_deklarator>OP_PRIDRUZI<inicijalizator>")) {
			Cvor c0 = djeca.get(0);
			Cvor c2 = djeca.get(2);
			c0.ntip = ntip;
			c0.provjeri();
			c2.provjeri();
			
			//tocka 3
			boolean provjera = true;
			int t = c0.tip.getJtip();
			if(t == Tip.CCHAR || t == Tip.CHAR || t == Tip.CINT || t == Tip.INT) {
				if(!jeSvodiv(c2.tip.getJtip(), Tip.INT) && !jeSvodiv(c2.tip.getJtip(),Tip.CHAR)) {
					provjera = false;
				}
				if(c2.tip.getJtip() == Tip.INT || c2.tip.getJtip() == Tip.CINT) {
					if(t == Tip.CHAR || t == Tip.CCHAR) provjera = false;
				}
			} else if( t == Tip.NIZCCHAR || t == Tip.NIZCHAR || t == Tip.NIZCINT || t == Tip.NIZINT) {
				if(c2.tip.getBrelem() > c0.tip.getBrelem()) provjera = false;
				int pom = 100; // nesto bezveze
				switch(t) {
				case Tip.NIZCCHAR:
					pom = Tip.CHAR;
					break;
				case Tip.NIZCHAR:
					pom = Tip.CHAR;
					break;
				case Tip.NIZCINT:
					pom = Tip.INT;
					break;
				case Tip.NIZINT:
					pom = Tip.INT;
					break;
				}
				for(int i : c2.tipovi) {
					if(! jeSvodiv(i, pom)) {
						provjera = false;
						break;
					}
					if(i == Tip.INT || i == Tip.CINT) {
						if(pom == Tip.CHAR || pom == Tip.CCHAR) provjera = false;
					}
				}
			} else {
				greska();
			}
			if(! provjera) {
				greska();
			}
			
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
