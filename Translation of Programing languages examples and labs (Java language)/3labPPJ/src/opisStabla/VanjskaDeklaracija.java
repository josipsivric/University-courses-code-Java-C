package opisStabla;

public class VanjskaDeklaracija extends Cvor {
	
	public VanjskaDeklaracija(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<definicija_funkcije>")) {
			djeca.get(0).provjeri();
		} else if(odluka.equals("<deklaracija>")) {
			djeca.get(0).provjeri();
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
