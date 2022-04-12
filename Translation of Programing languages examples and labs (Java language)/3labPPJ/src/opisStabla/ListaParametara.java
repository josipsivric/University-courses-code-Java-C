package opisStabla;

import java.util.ArrayList;
import java.util.List;

public class ListaParametara extends Cvor {
	
	public ListaParametara(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<deklaracija_parametra>")) {
			Cvor c = djeca.get(0);
			c.provjeri();
			List<Integer> lt = tipovi;
			if(lt == null) {
				lt = new ArrayList<Integer>();
			}
			List<String> li = imena;
			if(li == null) {
				li = new ArrayList<String>();
			}
			lt.add(c.tip.getJtip());
			li.add(c.vrijednost);
			
			tipovi = lt;
			imena = li;
		} else if(odluka.equals("<lista_parametara>ZAREZ<deklaracija_parametra>")) {
			Cvor c0 = djeca.get(0);
			Cvor c2 = djeca.get(2);
			c0.provjeri();
			c2.provjeri();
			
			//provjera jedinstvenosti imena
			boolean provjera = true;
			for(String s : c0.imena) {
				if(c2.vrijednost == s) {
					provjera = false;
					break;
				}
			}
			if(! provjera) {
				System.err.println(ime + " Postoji isto ime");
				greska();//TODO dodaj
			}
			
			List<Integer> lt = tipovi;
			if(lt == null) {
				lt = new ArrayList<Integer>();
			}
			List<String> li = imena;
			if(li == null) {
				li = new ArrayList<String>();
			}
			
			lt.addAll(c0.tipovi);
			lt.add(c2.tip.getJtip());
			tipovi = lt;
			
			li.addAll(c0.imena);
			li.add(c2.vrijednost);
			imena = li;
			
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
