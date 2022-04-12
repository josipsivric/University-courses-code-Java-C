package opisStabla;

public class PrijevodnaJedinica extends Cvor {
	
	public PrijevodnaJedinica(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<vanjska_deklaracija>")) {
			djeca.get(0).provjeri();
		} else if(odluka.equals("<prijevodna_jedinica><vanjska_deklaracija>")) {
			djeca.get(0).provjeri();
			djeca.get(1).provjeri();
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
