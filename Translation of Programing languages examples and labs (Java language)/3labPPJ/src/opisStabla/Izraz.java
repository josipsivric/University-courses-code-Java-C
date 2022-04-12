package opisStabla;

public class Izraz extends Cvor {
	
	public Izraz(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<izraz_pridruzivanja>")) {
			Cvor c = djeca.get(0);
			c.provjeri();
			tip = new Tip(c.tip);
			lIzraz = c.lIzraz;
		} else if(odluka.equals("<izraz>ZAREZ<izraz_pridruzivanja>")) {
			Cvor c0 = djeca.get(0);
			Cvor c2 = djeca.get(2);
			c0.provjeri();
			c2.provjeri();
			tip = new Tip(c2.tip);
			lIzraz = 0;
		} else {
			System.err.println("Moja greska u:" + ime);
		}
	}

}
