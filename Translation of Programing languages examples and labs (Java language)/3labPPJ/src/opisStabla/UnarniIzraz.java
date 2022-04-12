package opisStabla;

public class UnarniIzraz extends Cvor {
	
	public UnarniIzraz(String ime) {
		super(ime);
	}
	
	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<postfiks_izraz>")) {
			Cvor c = djeca.get(0);
			c.provjeri();
			tip = new Tip(c.tip);
			lIzraz = c.lIzraz;
		} else if(odluka.equals("OP_INC<unarni_izraz>") || odluka.equals("OP_DEC<unarni_izraz>")) {
			Cvor c = djeca.get(1);
			c.provjeri();
			if(c.lIzraz == 0 || !jeSvodiv(c.tip.getJtip(), Tip.INT) || c.tip.isFun()) {
				greska(); //TODO dodaj
			}
			tip.setJtip(Tip.INT);
			lIzraz = 0;
			
		} else if(odluka.equals("<unarni_operator><cast_izraz>")) {
			Cvor c = djeca.get(1);
			c.provjeri();
			if(!jeSvodiv(c.tip.getJtip(), Tip.INT) || c.tip.isFun()) {
				greska(); //TODO dodaj
			}
			tip.setJtip(Tip.INT);
			lIzraz = 0;
			
		} else {
			System.err.println("Moja greska u:" + ime);
		}
	}

}
