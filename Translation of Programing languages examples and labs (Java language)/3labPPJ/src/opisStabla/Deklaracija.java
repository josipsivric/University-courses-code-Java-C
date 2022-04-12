package opisStabla;

public class Deklaracija extends Cvor {
	
	public Deklaracija(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<ime_tipa><lista_init_deklaratora>TOCKAZAREZ")) {
			djeca.get(0).provjeri();
			djeca.get(1).setNtip(djeca.get(0).tip);
			djeca.get(1).provjeri();
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
