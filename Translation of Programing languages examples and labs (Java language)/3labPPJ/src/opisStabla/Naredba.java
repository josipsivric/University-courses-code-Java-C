package opisStabla;

public class Naredba extends Cvor {
	
	public Naredba(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<slozena_naredba>")) {
			djeca.get(0).provjeri();
		} else if(odluka.equals("<izraz_naredba>")) {
			djeca.get(0).provjeri();
		}else if(odluka.equals("<naredba_grananja>")) {
			djeca.get(0).provjeri();
		}else if(odluka.equals("<naredba_petlje>")) {
			djeca.get(0).provjeri();
		}else if(odluka.equals("<naredba_skoka>")) {
			djeca.get(0).provjeri();
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
