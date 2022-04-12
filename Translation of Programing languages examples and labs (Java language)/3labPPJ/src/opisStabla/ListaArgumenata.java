package opisStabla;

import java.util.ArrayList;
import java.util.List;

public class ListaArgumenata extends Cvor {
	
	public ListaArgumenata(String ime) {
		super(ime);
	}
	
	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<izraz_pridruzivanja>")) {
			Cvor c = djeca.get(0);
			c.provjeri();
			List<Integer> l = tipovi;
			if(l == null) {
				l = new ArrayList<Integer>();
			}	
			l.add(c.tip.getJtip());
			tipovi = l;
			
		} else if(odluka.equals("<lista_argumenata>ZAREZ<izraz_pridruzivanja>")) {
			Cvor c0 = djeca.get(0);
			Cvor c2 = djeca.get(2);
			c0.provjeri();
			c2.provjeri();
			List<Integer> l = tipovi;
			if(l == null) {
				l = new ArrayList<Integer>();
			}	
			l.addAll(c0.tipovi);
			l.add(c2.tip.getJtip());
			tipovi = l;
			
		} else {
			System.err.println("Moja greska u:" + ime);
		}
	}
	
}
