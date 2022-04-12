package opisStabla;

public class IzrazNaredba extends Cvor {
	
	public IzrazNaredba(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("TOCKAZAREZ")) {
			tip.setJtip(Tip.INT);
		} else if(odluka.equals("<izraz>TOCKAZAREZ")) {
			Cvor c = djeca.get(0);
			c.provjeri();
			tip = new Tip(c.tip);
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
