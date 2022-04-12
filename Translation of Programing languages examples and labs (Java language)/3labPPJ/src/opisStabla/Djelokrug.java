package opisStabla;

import java.util.HashMap;
import java.util.Map;

public class Djelokrug {
	private Djelokrug nadredeni;
	/**
	 * da li je djelokrug samo slozene naredbe - vrijednost 1 <br>
	 * oli je djelokrug slozene naredbe u funkiji - vrijednost 2
	 */
	private int pripadnost;
	private Map<String, Tip> tablica;
	
	public Djelokrug(Djelokrug nadredeni, int pripadnost) {
		tablica = new HashMap<String, Tip>();
		this.pripadnost = pripadnost;
		this.nadredeni = nadredeni;
	}
	
	public Tip jeDeklarirano(String s) {
		if(tablica.containsKey(s)){
			return tablica.get(s);
		}
		else if(nadredeni != null) {
			return nadredeni.jeDeklarirano(s);
		} else {
			return null;
		}
	}

	public Djelokrug getNadredeni() {
		return nadredeni;
	}

	public void setNadredeni(Djelokrug nadredeni) {
		this.nadredeni = nadredeni;
	}

	public Map<String, Tip> getTablica() {
		return tablica;
	}

	public void setTablica(Map<String, Tip> tablica) {
		this.tablica = tablica;
	}


	public int getPripadnost() {
		return pripadnost;
	}

	public void setPripadnost(int pripadnost) {
		this.pripadnost = pripadnost;
	}
	
	
	
	
	
	
	
}
