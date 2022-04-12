package opisStabla;

public class SlozenaNaredba extends Cvor {
	
	public SlozenaNaredba(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("L_VIT_ZAGRADA<lista_naredbi>D_VIT_ZAGRADA")) {
			djeca.get(1).provjeri();
		} else if(odluka.equals("L_VIT_ZAGRADA<lista_deklaracija><lista_naredbi>D_VIT_ZAGRADA")) {
			djeca.get(1).provjeri();
			djeca.get(2).provjeri();
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
