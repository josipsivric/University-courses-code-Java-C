package opisStabla;

import java.util.ArrayList;
import java.util.List;

public class Inicijalizator extends Cvor {
	
	public Inicijalizator(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<izraz_pridruzivanja>")) {
			djeca.get(0).provjeri();
			Cvor pom = djeca.get(0);
			while(pom.djeca != null) {
				pom = pom.djeca.get(0);
			}
			if(pom.ime.equals("NIZ_ZNAKOVA")) {
				int brelem;
				brelem = pom.vrijednost.length() - 2;
				for(int i = 1; i < pom.vrijednost.length() - 1; i++) {
					if(pom.vrijednost.charAt(i) == '\\') {
						brelem--;
						i++;
					}
				}
				tip.setBrelem(brelem + 1);
				tipovi = new ArrayList<Integer>();
				for(int i = 0; i < brelem + 1; i++) {
					tipovi.add(Tip.CHAR);
				}
			} else {
				tip = new Tip(djeca.get(0).tip);
				
			}
			
		} else if(odluka.equals("L_VIT_ZAGRADA<lista_izraza_pridruzivanja>D_VIT_ZAGRADA")) {
			Cvor c1 = djeca.get(1);
			c1.provjeri();
			tip.setBrelem(c1.tip.getBrelem());
			List<Integer> t = new ArrayList<Integer>(c1.tipovi);
			tipovi = t;
			
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
