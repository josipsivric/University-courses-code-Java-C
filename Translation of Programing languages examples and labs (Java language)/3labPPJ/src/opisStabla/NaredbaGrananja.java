package opisStabla;

public class NaredbaGrananja extends Cvor {
	
	public NaredbaGrananja(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("KR_IFL_ZAGRADA<izraz>D_ZAGRADA<naredba>")) {
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
			
		} else if(odluka.equals("KR_IFL_ZAGRADA<izraz>D_ZAGRADA<naredba>KR_ELSE<naredba>")) {
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
			djeca.get(6).provjeri();
			
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
