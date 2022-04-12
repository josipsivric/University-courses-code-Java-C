package opisStabla;

public class ImeTipa extends Cvor {
	
	public ImeTipa(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<specifikator_tipa>")) {
			Cvor c = djeca.get(0);
			c.provjeri();
			tip = new Tip(c.tip);
		} else if(odluka.equals("KR_CONST<specifikator_tipa>")) {
			Cvor c = djeca.get(1);
			c.provjeri();
			if(c.tip.getJtip() == Tip.VOID) {
				greska(); //TODO dodaj
			}
			switch(c.tip.getJtip()) {
			case Tip.INT:
				tip.setJtip(Tip.CINT);
				break;
			case Tip.CHAR:
				tip.setJtip(Tip.CCHAR);
				break;
			case Tip.NIZCHAR:
				tip.setJtip(Tip.NIZCCHAR);
				break;
			case Tip.NIZINT:
				tip.setJtip(Tip.NIZCINT);
				break;
			}
			
		} else {
			System.err.println("Moja greska u:" + ime);
		}
	}

}
