package opisStabla;

public class CastIzraz extends Cvor {
	
	public CastIzraz(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<unarni_izraz>")) {
			Cvor c = djeca.get(0);
			c.provjeri();
			tip = new Tip(c.tip);
			lIzraz = c.lIzraz;
		} else if(odluka.equals("L_ZAGRADA<ime_tipa>D_ZAGRADA<cast_izraz>")) {
			String s1 = djeca.get(0).brRedak;
			String s3 = djeca.get(2).brRedak;
			Cvor c1 = djeca.get(1);
			Cvor c3 = djeca.get(3);
			c1.provjeri();
			c3.provjeri();
			//moze li se pretvoriti castanjem
			boolean pretvorivo = true;
			Tip c3t = c3.tip;
			Tip c1t = c1.tip;
			if(c3t.isFun()) pretvorivo = false;
			if(c3t.getJtip() != Tip.CCHAR && c3t.getJtip() != Tip.CHAR &&
					c3t.getJtip() != Tip.CINT && c3t.getJtip() != Tip.INT) pretvorivo = false;
			if(! jeSvodiv(c3t.getJtip(), c1t.getJtip())) pretvorivo = false;
			if(c3t.getJtip() == Tip.INT && (c1t.getJtip() == Tip.CCHAR || c1t.getJtip() == Tip.CHAR)) pretvorivo = true;
			if(c3t.getJtip() == Tip.CINT && (c1t.getJtip() == Tip.CCHAR || c1t.getJtip() == Tip.CHAR)) pretvorivo = true;
			if(! pretvorivo) {
				greska(); 			
			}		
			tip = new Tip(c1.tip);
			
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
