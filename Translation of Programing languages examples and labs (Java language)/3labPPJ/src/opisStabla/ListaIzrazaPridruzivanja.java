package opisStabla;

import java.util.ArrayList;

public class ListaIzrazaPridruzivanja extends Cvor {
	
	public ListaIzrazaPridruzivanja(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<izraz_pridruzivanja>")) {
			Cvor c0 = djeca.get(0);
			c0.provjeri();
			if(tipovi == null) {
				tipovi = new ArrayList<Integer>();
			}
			tipovi.add(c0.tip.getJtip());
			tip.setBrelem(1);
			
		} else if(odluka.equals("<lista_izraza_pridruzivanja>ZAREZ<izraz_pridruzivanja>")) {
			Cvor c0 = djeca.get(0);
			Cvor c2 = djeca.get(2);
			c0.provjeri();
			c2.provjeri();
			if(tipovi == null) {
				tipovi = new ArrayList<Integer>();
			}
			tipovi.addAll(c0.tipovi);
			tipovi.add(c2.tip.getJtip());
			tip.setBrelem(c0.tip.getBrelem() + 1);
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
