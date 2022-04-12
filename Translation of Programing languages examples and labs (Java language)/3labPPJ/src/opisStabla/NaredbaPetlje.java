package opisStabla;

public class NaredbaPetlje extends Cvor {
	
	public NaredbaPetlje(String ime) {
		super(ime);
	}


	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("KR_WHILEL_ZAGRADA<izraz>D_ZAGRADA<naredba>")) {
			Cvor c2 = djeca.get(2);
			c2.provjeri();
			//moze li se svesti na int
			boolean svodiv;
			svodiv = jeSvodiv(c2.tip.getJtip(), Tip.INT);
			if(c2.tip.isFun()) svodiv = false;
			if(! svodiv) {
				greska();//TODO dodaj
			}
			
			djeca.get(4).provjeri();
			
		} else if(odluka.equals("KR_FORL_ZAGRADA<izraz_naredba><izraz_naredba>D_ZAGRADA<naredba>")) {
			djeca.get(2).provjeri();
			Cvor c3 = djeca.get(3);
			c3.provjeri();
			//moze li se svesti na int
			boolean svodiv;
			svodiv = jeSvodiv(c3.tip.getJtip(), Tip.INT);
			if(c3.tip.isFun()) svodiv = false;
			if(! svodiv) {
				greska();//TODO dodaj
			}
			
			djeca.get(5).provjeri();
			
		} else if(odluka.equals("KR_FORL_ZAGRADA<izraz_naredba><izraz_naredba><izraz>D_ZAGRADA<naredba>")) {
			djeca.get(2).provjeri();
			Cvor c3 = djeca.get(3);
			c3.provjeri();
			//moze li se svesti na int
			boolean svodiv;
			svodiv = jeSvodiv(c3.tip.getJtip(), Tip.INT);
			if(c3.tip.isFun()) svodiv = false;
			if(! svodiv) {
				greska();//TODO dodaj
			}
			
			djeca.get(4).provjeri();
			djeca.get(6).provjeri();
			
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
