package opisStabla;

public class ListaInitDeklaratora extends Cvor {
	
	public ListaInitDeklaratora(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<init_deklarator>")) {
			Cvor c0 = djeca.get(0);
			c0.ntip = ntip;;
			c0.provjeri();
		} else if(odluka.equals("<lista_init_deklaratora>ZAREZ<init_deklarator>")) {
			Cvor c0 = djeca.get(0);
			Cvor c2 = djeca.get(2);
			c0.ntip = ntip;
			c0.provjeri();
			c2.ntip = ntip;
			c2.provjeri();
		} else {
			System.err.println("Moja greska u:" + ime);
		}
	}

}
