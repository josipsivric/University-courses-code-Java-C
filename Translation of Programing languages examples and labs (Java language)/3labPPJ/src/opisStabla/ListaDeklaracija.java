package opisStabla;

public class ListaDeklaracija extends Cvor {
	
	public ListaDeklaracija(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<deklaracija>")) {
			djeca.get(0).provjeri();
		} else if(odluka.equals("<lista_deklaracija><deklaracija>")) {
			djeca.get(0).provjeri();
			djeca.get(1).provjeri();
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
