
public class Redak {
	private String niz;
	private int razina;
	private boolean list;
	
	public Redak(String niz, int razina) {
		this.niz = niz;
		this.razina = razina;
		if(niz.charAt(0) == '<') {
			list = false;
		} else {
			list = true;
		}
	}

	public boolean isList() {
		return list;
	}

	public void setList(boolean list) {
		this.list = list;
	}

	public String getNiz() {
		return niz;
	}

	public void setNiz(String niz) {
		this.niz = niz;
	}

	public int getRazina() {
		return razina;
	}

	public void setRazina(int razina) {
		this.razina = razina;
	}
	
}
