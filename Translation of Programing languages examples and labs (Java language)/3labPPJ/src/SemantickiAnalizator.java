import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import opisStabla.AditivniIzraz;
import opisStabla.BinIIzraz;
import opisStabla.BinIliIzraz;
import opisStabla.BinXiliIzraz;
import opisStabla.CastIzraz;
import opisStabla.Cvor;
import opisStabla.DefinicijaFunkcije;
import opisStabla.Deklaracija;
import opisStabla.DeklaracijaParametra;
import opisStabla.Djelokrug;
import opisStabla.ImeTipa;
import opisStabla.Inicijalizator;
import opisStabla.InitDeklarator;
import opisStabla.IzravniDeklarator;
import opisStabla.Izraz;
import opisStabla.IzrazNaredba;
import opisStabla.IzrazPridruzivanja;
import opisStabla.JednakosniIzraz;
import opisStabla.ListaArgumenata;
import opisStabla.ListaDeklaracija;
import opisStabla.ListaInitDeklaratora;
import opisStabla.ListaIzrazaPridruzivanja;
import opisStabla.ListaNaredbi;
import opisStabla.ListaParametara;
import opisStabla.Listic;
import opisStabla.LogIIzraz;
import opisStabla.LogIliIzraz;
import opisStabla.MultiplikativniIzraz;
import opisStabla.Naredba;
import opisStabla.NaredbaGrananja;
import opisStabla.NaredbaPetlje;
import opisStabla.NaredbaSkoka;
import opisStabla.OdnosniIzraz;
import opisStabla.PostfiksIzraz;
import opisStabla.PrijevodnaJedinica;
import opisStabla.PrimarniIzraz;
import opisStabla.SlozenaNaredba;
import opisStabla.SpecifikatorTipa;
import opisStabla.Tip;
import opisStabla.UnarniIzraz;
import opisStabla.UnarniOperator;
import opisStabla.VanjskaDeklaracija;


public class SemantickiAnalizator {

	/**
	 * Pocetni cvor generativnog stabla
	 */
	private static Cvor genS;
	private static List<Redak> ulaz;
	private static List<Djelokrug> djelokruzi = new ArrayList<Djelokrug>();
	

	
	public static void main(String[] args) {
		Djelokrug korijenski;
		korijenski = new Djelokrug(null, 1);
		djelokruzi.add(korijenski);

		try{
			ucitaj();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		genS = dodajCvor(0, ulaz.size(), korijenski);
		//System.out.println("\n\nIspis Stabla:");
		//ispisStabla(genS, 0);
		
		genS.provjeri();
		
		//provjera maina
		if(! korijenski.getTablica().containsKey("main")) {
			System.out.println("main");
		} else {
			Tip t = korijenski.getTablica().get("main");
			if(t.isFun()) {
				if(t.getFtip().get(0) != Tip.INT || t.getFtip().get(1) != Tip.VOID) {
					System.out.println("main");
					System.exit(0);
				}
			} else {
				System.out.println("main");
				System.exit(0);
			}
		}
		//+++++++++++++++++++++++++++
		
		//provjera deklaracija
		Set<String> imena = djelokruzi.get(0).getTablica().keySet();
		for(String s : imena) {
			Tip t = djelokruzi.get(0).getTablica().get(s);
			if(t.isFun()) {
				if(t.getDefinirana() == 1) {
					System.out.println("funkcija");
					System.exit(0);
				}
			}
		}
		for(Djelokrug d : djelokruzi) {
			Set<String> skup = d.getTablica().keySet();
			for(String s : skup) {
				Tip t = d.getTablica().get(s);
				if(t.isFun()) {
					if(djelokruzi.get(0).getTablica().get(s) != null) {
						if(djelokruzi.get(0).getTablica().get(s).getDefinirana() != 2) {
							System.out.println("funkcija");
							System.exit(0);
						}
					} else {
						System.out.println("funkcija");
						System.exit(0);
					}
				}
			}
		}
		//++++++++++++++++++++++++++++++++++++++++++
		
	}
	
	
	private static void ucitaj() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ulaz = new ArrayList<Redak>();
		Redak redak;
		String s;
		s=in.readLine();
		while(s != null) {
			redak = new Redak(s.trim(), brojRazmaka(s));
			ulaz.add(redak);
			s=in.readLine();
		}
	}
	
	
	
	private static int brojRazmaka(String s) {
		int vrati=0;
		while(s.charAt(vrati) == ' ') {
			vrati++;
		}
		return vrati;
	}

	
	private static Cvor dodajCvor(int poc, int kraj, Djelokrug djelokrug) {
		String vrijednost = null;
		String brRedak = null;
		Cvor vrati = null;
		List<Integer> oznaka = new ArrayList<Integer>();
		Redak trenutni = ulaz.get(poc);
		poc++;
		boolean isp = false;
		String ime = trenutni.getNiz();
		if(ime.charAt(0) != '<') {
			isp = true;
			String pom = new String(ime);
			ime = pom.split(" ")[0];
			brRedak = pom.split(" ")[1];
			vrijednost = pom.substring(pom.indexOf(' ') + 1);
			vrijednost = vrijednost.substring(vrijednost.indexOf(' ') + 1);
		}
		if(isp) {
			vrati = new Listic(ime);
			vrati.setVrijednost(vrijednost);
			vrati.setBrRedak(brRedak);
			vrati.setDjelokrug(djelokrug);
			
		} else if(ime.equals("<primarni_izraz>")) {
			vrati = new PrimarniIzraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<postfiks_izraz>")) {
			vrati = new PostfiksIzraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<lista_argumenata>")) {
			vrati = new ListaArgumenata(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<unarni_izraz>")) {
			vrati = new UnarniIzraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<unarni_operator>")) {
			vrati = new UnarniOperator(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<cast_izraz>")) {
			vrati = new CastIzraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<ime_tipa>")) {
			vrati = new ImeTipa(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<specifikator_tipa>")) {
			vrati = new SpecifikatorTipa(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<multiplikativni_izraz>")) {
			vrati = new MultiplikativniIzraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<aditivni_izraz>")) {
			vrati = new AditivniIzraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<odnosni_izraz>")) {
			vrati = new OdnosniIzraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<jednakosni_izraz>")) {
			vrati = new JednakosniIzraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<bin_i_izraz>")) {
			vrati = new BinIIzraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<bin_xili_izraz>")) {
			vrati = new BinXiliIzraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<bin_ili_izraz>")) {
			vrati = new BinIliIzraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<log_i_izraz>")) {
			vrati = new LogIIzraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<log_ili_izraz>")) {
			vrati = new LogIliIzraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<izraz_pridruzivanja>")) {
			vrati = new IzrazPridruzivanja(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<izraz>")) {
			vrati = new Izraz(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<slozena_naredba>")) {
			Djelokrug novi = null;
			if(djelokrug.getPripadnost() == 1) {
				novi = new Djelokrug(djelokrug,1);
				//djelokrug.setPodredeni(novi);
			} else {
				novi = djelokrug;
			}
			vrati = new SlozenaNaredba(ime);
			vrati.setDjelokrug(novi);
			djelokruzi.add(novi);
		} else if(ime.equals("<lista_naredbi>")) {
			vrati = new ListaNaredbi(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<naredba>")) {
			vrati = new Naredba(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<izraz_naredba>")) {
			vrati = new IzrazNaredba(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<naredba_grananja>")) {
			vrati = new NaredbaGrananja(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<naredba_petlje>")) {
			vrati = new NaredbaPetlje(ime);
			vrati.setDjelokrug(djelokrug);
			vrati.setPetlja(true);
		} else if(ime.equals("<naredba_skoka>")) {
			vrati = new NaredbaSkoka(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<prijevodna_jedinica>")) {
			vrati = new PrijevodnaJedinica(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<vanjska_deklaracija>")) {
			vrati = new VanjskaDeklaracija(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<definicija_funkcije>")) {
			//funkcija zapocinje novi djelokrug, ali se deklarira i definira u 
			//djelokrugu iznad
			Djelokrug novi = new Djelokrug(djelokrug, 2);
			//djelokrug.setPodredeni(novi);
			vrati = new DefinicijaFunkcije(ime);
			vrati.setDjelokrug(novi);
			djelokruzi.add(novi);
		} else if(ime.equals("<lista_parametara>")) {
			vrati = new ListaParametara(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<deklaracija_parametra>")) {
			vrati = new DeklaracijaParametra(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<lista_deklaracija>")) {
			vrati = new ListaDeklaracija(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<deklaracija>")) {
			vrati = new Deklaracija(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<lista_init_deklaratora>")) {
			vrati = new ListaInitDeklaratora(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<init_deklarator>")) {
			vrati = new InitDeklarator(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<izravni_deklarator>")) {
			vrati = new IzravniDeklarator(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<inicijalizator>")) {
			vrati = new Inicijalizator(ime);
			vrati.setDjelokrug(djelokrug);
		} else if(ime.equals("<lista_izraza_pridruzivanja>")) {
			vrati = new ListaIzrazaPridruzivanja(ime);
			vrati.setDjelokrug(djelokrug);
		} else {
			System.err.println("Moja greska u mainu");
		}
		int razina = trenutni.getRazina();
		int podRazina = razina + 1;
		int r;
		for(int i = poc; i < kraj; i++) {
			r = ulaz.get(i).getRazina();
			if(r == podRazina) oznaka.add(i);		
			if(r <= razina) {
				oznaka.add(i);
				break;
			}
		}
		if(oznaka.size() == 0) {
			vrati.setDjeca(null);
			return vrati;
		} else {
			for(int i = 0; i < oznaka.size() - 1; i++) {
				Cvor novi = dodajCvor(oznaka.get(i), oznaka.get(i+1), vrati.getDjelokrug());
				novi.setRoditelj(vrati);
				vrati.getDjeca().add(novi);
			}
			Cvor novi = dodajCvor(oznaka.get(oznaka.size() - 1), kraj, vrati.getDjelokrug());
			novi.setRoditelj(vrati);
			vrati.getDjeca().add(novi);
		}	
		return vrati;
	}
	
	
	
	
	
//****************samo probni ispisi**********************
	private static void ispisiUlaz() {
		for(Redak trenutni:ulaz) {
			System.err.println(trenutni.getRazina() + trenutni.getNiz() + " list:" + trenutni.isList());
		}
	}
	
	private static void ispisStabla(Cvor c, int razina) {
		for(int i=0; i < razina; i++) System.out.print(' ');
		if(c.getIme().charAt(0) != '<') {
			System.err.print(c.getIme());
			System.err.print(" ");
			System.err.print(c.getBrRedak());
			System.err.print(" ");
			System.err.println(c.getVrijednost());
		} else {
			System.err.println(c.getIme());
		}
		if(c.getDjeca() != null) {
			for(Cvor cvor : c.getDjeca()) {
				ispisStabla(cvor, razina + 1);
			}
		}	
	}
	
	

}
