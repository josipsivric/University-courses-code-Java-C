package ppj.lab1.priprema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Priprema {
	
	public static ArrayList<String> pripremiRegex(ArrayList<String> ulaznaLista){
		
		ArrayList<String> novaLista = new ArrayList<String>();
		Map<String, String> tablicaIzraza = new HashMap<String, String>();
	
		int index = 0;
		String trenutnaLinija;
		String temp1, temp2;
		
		do {
			trenutnaLinija = ulaznaLista.get(index);
			
			Scanner sc = new Scanner(trenutnaLinija);
			
			if (trenutnaLinija.startsWith("%"))
				break;
			
			temp1 = sc.next();
			temp2 = sc.next();
			
			sc.close();
			
			if (temp2.startsWith("{")) {
				for (Map.Entry<String, String> izraz : tablicaIzraza.entrySet()) {
					temp2 = temp2.replace(izraz.getKey(),'(' + izraz.getValue() + ')');
				}
			}
			
			tablicaIzraza.put(temp1, temp2);
			novaLista.add(temp1 + " " + temp2);
			index = index + 1;
		} while (true);
		
		while (index != ulaznaLista.size()) {
			trenutnaLinija = ulaznaLista.get(index);
			
			for (Map.Entry<String, String> izraz : tablicaIzraza.entrySet()) {
				trenutnaLinija = trenutnaLinija.replace(izraz.getKey(), izraz.getValue());
			}
			
			novaLista.add(trenutnaLinija);
			index = index + 1;
		}
		
		return novaLista;
	}

	public static void main(String[] args) {
		
		ArrayList<String> lista = new ArrayList<String>();
		ArrayList<String> novaLista = new ArrayList<String>();
		
		lista.add("{znamenka} 0|1|2|3|4|5|6|7|8|9");
		lista.add("{hexZnamenka} {znamenka}|a|b|c|d|e|f|A|B|C|D|E|F");
		lista.add("{broj} {znamenka}{znamenka}*|0x{hexZnamenka}{hexZnamenka}*");
		lista.add("{bjelina} \\t|\\n|\\_");
		lista.add("{sviZnakovi} \\(|\\)|\\{|\\}|\\||\\*|\\\\|\\$|\\t|\\n|\\_|!|\"|#|%|&|'|+|,|-|.|/|0|1|2|3|4|5|6|7|8|9|:|;|<|=|>|?|@|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|[|]|^|_|`|a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|~");
		lista.add("%X S_pocetno S_komentar S_unarni");
		lista.add("%L OPERAND OP_MINUS UMINUS LIJEVA_ZAGRADA DESNA_ZAGRADA");
		lista.add("{");
		lista.add("-");
		lista.add("}");
		lista.add("NOVI_REDAK");
		lista.add("}");
		lista.add("<S_pocetno>#\\|");
		lista.add("{");
		lista.add("-");
		lista.add("UDJI_U_STANJE S_komentar");
		lista.add("}");
		lista.add("<S_komentar>\\|#");
		lista.add("{");
		lista.add("-");
		lista.add("UDJI_U_STANJE S_pocetno");
		lista.add("}");
		lista.add("<S_komentar>\\n");
		lista.add("{");
		lista.add("-");
		lista.add("NOVI_REDAK");
		lista.add("}");
		lista.add("<S_komentar>{sviZnakovi}");
		lista.add("{");
		lista.add("-");
		lista.add("}");
		lista.add("<S_pocetno>{broj}");
		lista.add("{");
		lista.add("OPERAND");
		lista.add("}");
		lista.add("<S_pocetno>\\(");
		lista.add("{");
		lista.add("LIJEVA_ZAGRADA");
		lista.add("}");
		lista.add("<S_pocetno>\\)");
		lista.add("{");
		lista.add("DESNA_ZAGRADA");
		lista.add("}");
		lista.add("<S_pocetno>-");
		lista.add("{");
		lista.add("OP_MINUS");
		lista.add("}");
		lista.add("<S_pocetno>-{bjelina}*-");
		lista.add("{");
		lista.add("OP_MINUS");
		lista.add("UDJI_U_STANJE S_unarni");
		lista.add("VRATI_SE 1");
		lista.add("}");
		lista.add("<S_pocetno>\\({bjelina}*-");
		lista.add("{");
		lista.add("LIJEVA_ZAGRADA");
		lista.add("UDJI_U_STANJE S_unarni");
		lista.add("VRATI_SE 1");
		lista.add("}");
		lista.add("<S_unarni>\\t|\\_");
		lista.add("{");
		lista.add("-");
		lista.add("}");
		lista.add("<S_unarni>\\n");
		lista.add("{");
		lista.add("-");
		lista.add("NOVI_REDAK");
		lista.add("}");
		lista.add("<S_unarni>-");
		lista.add("{");
		lista.add("UMINUS");
		lista.add("UDJI_U_STANJE S_pocetno");
		lista.add("}");
		lista.add("<S_unarni>-{bjelina}*-");
		lista.add("{");
		lista.add("UMINUS");
		lista.add("VRATI_SE 1");
		lista.add("}");
		lista.add("");
		
		novaLista = pripremiRegex(lista);
		
		int index = 0;
		do {
			System.out.print(novaLista.get(index) + "\n");
			index = index + 1;
		} while (index != novaLista.size());
	}
}