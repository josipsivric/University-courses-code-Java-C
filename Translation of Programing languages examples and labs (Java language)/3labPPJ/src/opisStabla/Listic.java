package opisStabla;

public class Listic extends Cvor {
	
	public Listic(String ime) {
		super(ime);
	}

	@Override
	public void provjeri() {
		if(ime.equals("BROJ")) {
			tip.setJtip(Tip.INT);
		} else if(ime.equals("ZNAK")) {
			tip.setJtip(Tip.CHAR);
		} else if(ime.equals("NIZ_ZNAKOVA")) {
			tip.setJtip(Tip.NIZCCHAR);
		}
	}

}