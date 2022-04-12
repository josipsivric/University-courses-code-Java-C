package opisStabla;

public class IzrazPridruzivanja extends Cvor {
	
	public IzrazPridruzivanja(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<log_ili_izraz>")) {
			Cvor c = djeca.get(0);
			c.provjeri();
			tip = new Tip(c.tip);
			lIzraz = c.lIzraz;
		} else if(odluka.equals("<postfiks_izraz>OP_PRIDRUZI<izraz_pridruzivanja>")) {
			Cvor c0 = djeca.get(0);
			Cvor c2 = djeca.get(2);
			c0.provjeri();
		
			if(c0.lIzraz == 0) {
				greska(); //TODO dodaj
			}
			
			c2.provjeri();
			//moze li se svesti na int
			boolean svodiv;
			svodiv = jeSvodiv(c2.tip.getJtip(), c0.tip.getJtip());
			if(c2.tip.isFun()) svodiv = false;
			if(c0.tip.isFun()) svodiv = false;
			if(! svodiv) {
				greska();//TODO dodaj
			}
			
			tip = new Tip(c0.tip);
			lIzraz = 0;
			
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
