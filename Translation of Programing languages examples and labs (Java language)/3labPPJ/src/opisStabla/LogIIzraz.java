package opisStabla;

public class LogIIzraz extends Cvor {
	
	public LogIIzraz(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<bin_ili_izraz>")) {
			Cvor c = djeca.get(0);
			c.provjeri();
			tip = new Tip(c.tip);
			lIzraz = c.lIzraz;
		} else if(odluka.equals("<log_i_izraz>OP_I<bin_ili_izraz>")) {
			Cvor c0 = djeca.get(0);
			Cvor c2 = djeca.get(2);
			c0.provjeri();
			//moze li se svesti na int
			boolean svodiv;
			svodiv = jeSvodiv(c0.tip.getJtip(), Tip.INT);
			if(c0.tip.isFun()) svodiv = false;
			if(! svodiv) {
				greska();//TODO dodaj
			}
			
			c2.provjeri();
			//moze li se svesti na int
			svodiv = jeSvodiv(c2.tip.getJtip(), Tip.INT);
			if(c2.tip.isFun()) svodiv = false;
			if(! svodiv) {
				greska();//TODO dodaj
			}
			
			tip.setJtip(Tip.INT);
			lIzraz = 0;
			
		} else {
			System.err.println("Moja greska u:" + ime);
		}


	}

}
