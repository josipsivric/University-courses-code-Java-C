package opisStabla;

public class SpecifikatorTipa extends Cvor {
	
	public SpecifikatorTipa(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("KR_VOID")) {
			tip.setJtip(Tip.VOID);
		} else if(odluka.equals("KR_CHAR")) {
			tip.setJtip(Tip.CHAR);
		} else if(odluka.equals("KR_INT")) {
			tip.setJtip(Tip.INT);
		} else {
			System.err.println("Moja greska u:" + ime);
		}

	}

}
