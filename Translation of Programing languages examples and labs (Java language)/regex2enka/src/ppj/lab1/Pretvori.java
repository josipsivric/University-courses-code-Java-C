package ppj.lab1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import ppj.lab1.parStanja;

@SuppressWarnings("unused")

/**
 * e-nka se ispisuje u datoteku u obliku
 * 
 * ime stanja leks analizatora
 * pocetno stanje
 * prihvatljivo stanje
 * broj stanja
 * prijelazi u obliku stanje1,znak->stanje2
 * ##
 * 
 * 
 * 
 * @author mateikki
 *
 */
public class Pretvori {
	
	
	
	/*public static void main(String[] args) throws IOException {
		
		String[] regex = new String[3];
		
		String[] name = new String[3];
		
		regex[0]="a|b";
		regex[1]="kkk\\||asd*";
		regex[2]="a\\|*|b";
		
		name[0]="S1";
		name[1]="S2";
		name[2]="S3";
		
		BufferedWriter buf = new BufferedWriter(new FileWriter("D:\\text.txt"));
		for(int i=0;i<3;i++){
			izgradiAutomat(regex[i],name[i],buf);
		}
			
		
	}
	*/
	
	
	public static void izgradiAutomat(String regex, String stanje, BufferedWriter w){
		
		Automat automat = new Automat();
		
		parStanja rezultat = pretvori(regex,automat);
		automat.pocetnoStanje = rezultat.lijevoStanje;
		automat.prihvatljivoStanje = rezultat.desnoStanje;
		String enka = stanje+"\n"+automat.pocetnoStanje+"\n"+automat.prihvatljivoStanje+"\n"+automat.brStanja;
		enka+=automat.toString();
		enka+="##\n";
		
		try {
			w.write(enka);
			w.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	private static void dodaj_prijelaz(Automat automat, int a, int b, char charAt) {
		String prijelaz = a+","+charAt+"->"+b;
		automat.prijelazi.add(prijelaz);
	
	}

	private static void dodaj_epsilon_prijelaz(Automat automat, int lijevoStanje,int lijevoStanje2) {
		dodaj_prijelaz(automat,lijevoStanje,lijevoStanje2,'$');	
	}
	
	private static int pronadjiZagradu(String izraz, int i) {
	
	
		int brojZagrada=0;
		for(int j=i;j<izraz.length();j++){
			
			if(izraz.charAt(j)=='(' && je_operator(izraz,j)) {
				brojZagrada++;
			
			}
			
			if(izraz.charAt(j)==')' && je_operator(izraz,j)){
				
				if(brojZagrada>0){
					
					brojZagrada--;
				}
				else{
					
					return j;
					
				}
				
			}
			
			
		}
		//u slucaju da nema zatvorene zagrade, ide exception kasnije zbog - indexa u stringu
		
		return -1;
			
	}

	
	
	
	public static int novo_stanje(Automat automat){
		automat.brStanja = automat.brStanja + 1;
		return automat.brStanja - 1;
	}

    public static boolean je_operator(String izraz, int i){
		int br = 0;
		while( i-1>=0 && izraz.charAt(i)=='\\'){
			br = br + 1;
			i = i - 1;
		}
	return br%2 == 0;
    }

 static parStanja pretvori(String izraz, Automat automat){
	List<String> izbori = new ArrayList<String>();
	int br_zagrada = 0;
	int zadnjiOpIzbora = 0;
	for(int i=0; i<izraz.length(); i=i+1){
		if( izraz.charAt(i)=='(' && je_operator(izraz, i)){
			br_zagrada = br_zagrada + 1;
		}else if(izraz.charAt(i)==')' && je_operator(izraz, i)){
			br_zagrada = br_zagrada - 1;
			
		}else if( br_zagrada==0 && izraz.charAt(i)=='|' && je_operator(izraz, i)){
			izbori.add(izraz.substring(zadnjiOpIzbora,i));
			zadnjiOpIzbora = i;
		}
	}
	if(zadnjiOpIzbora != 0){
		izbori.add(izraz.substring(zadnjiOpIzbora+1,izraz.length()));
	}
		
    int lijevo_stanje = novo_stanje(automat);
	int desno_stanje = novo_stanje(automat);
	if(zadnjiOpIzbora != 0){
	
	   for(int i=0; i<izbori.size(); i=i+1){
	        parStanja privremeno = pretvori(izbori.get(i), automat);
	        dodaj_epsilon_prijelaz(automat, lijevo_stanje, privremeno.lijevoStanje);
	        dodaj_epsilon_prijelaz(automat, privremeno.desnoStanje, desno_stanje);
	    }
	}else{
        boolean prefiksirano = false;
        int zadnje_stanje = lijevo_stanje;
	    for(int i=0; i<izraz.length(); i=i+1){
            int a, b;
	        if(prefiksirano == true){
                // sluèaj 1
                prefiksirano = false;
                char prijelazni_znak;
                if(izraz.charAt(i) == 't'){
                    prijelazni_znak = '\t';
                }else if (izraz.charAt(i) == 'n'){
                    prijelazni_znak = '\n';
                }else if(izraz.charAt(i) == '_'){
                    prijelazni_znak = ' ';
                }else{
                    prijelazni_znak = izraz.charAt(i);
                }
                
                a = novo_stanje(automat);
                b = novo_stanje(automat);
                dodaj_prijelaz(automat, a, b, prijelazni_znak);
	        }else{
                // sluèaj 2
                if(izraz.charAt(i) == '\\'){
                    prefiksirano = true;
                    continue; // continue u Cu
                }
                if(izraz.charAt(i) != '('){
                    // sluèaj 2a
                    a = novo_stanje(automat);
                    b = novo_stanje(automat);
                    if(izraz.charAt(i) == '$'){
                        dodaj_epsilon_prijelaz(automat, a, b);
                    }else{
                        dodaj_prijelaz(automat, a, b, izraz.charAt(i));
                    }
                }else{
                    // sluèaj 2b
                    int j = pronadjiZagradu(izraz,i+1);
                  //  System.out.println("j="+j);
                    parStanja privremeno = pretvori(izraz.substring(i+1,j-1), automat);
                    
                    a = privremeno.lijevoStanje;
                    b = privremeno.desnoStanje;
                    i = j;
                }
	        }

            // provjera ponavljanja
           if(i+1<izraz.length() && izraz.charAt(i+1)=='*'){
                int x = a;
                int y = b;
                a = novo_stanje(automat);
                b = novo_stanje(automat);
                dodaj_epsilon_prijelaz(automat, a, x);
                dodaj_epsilon_prijelaz(automat, y, b);
                dodaj_epsilon_prijelaz(automat, a, b);
                dodaj_epsilon_prijelaz(automat, y, x);
                i = i+1;
           }

            // povezivanje s ostatkom automata
            dodaj_epsilon_prijelaz(automat, zadnje_stanje, a);
            zadnje_stanje = b;
	    }
        dodaj_epsilon_prijelaz(automat, zadnje_stanje, desno_stanje);
        
    }
    
    return new parStanja(lijevo_stanje, desno_stanje);

}


}
