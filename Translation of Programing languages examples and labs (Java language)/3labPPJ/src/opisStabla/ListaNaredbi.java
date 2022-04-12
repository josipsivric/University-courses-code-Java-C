package opisStabla;

public class ListaNaredbi extends Cvor {
	
	public ListaNaredbi(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<naredba>")) {
			djeca.get(0).provjeri();
		} else if(odluka.equals("<lista_naredbi><naredba>")) {
			djeca.get(0).provjeri();
			djeca.get(1).provjeri();
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
