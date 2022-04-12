package opisStabla;

import java.util.ArrayList;
import java.util.List;

public class Tip {
	
	public static final int CHAR = 0;
	public static final int CCHAR = 1;
	public static final int CINT = 2;
	public static final int INT = 3;
	public static final int NIZCHAR = 4;
	public static final int NIZCCHAR = 5;
	public static final int NIZINT = 6;
	public static final int NIZCINT = 7;
	public static final int VOID = 8;
	
	private int jtip;
	private boolean fun;
	/**
	 * ftip[0] -> povratna vrijednost funkcije, ostali elementi su parametri redom
	 */
	private List<Integer> ftip;
	/**
	 * ako je 0 nije ni deklarirana ni definirana, 1-deklarirana, 2-definirana 
	 */
	private int definirana;
	/**
	 * samo za nizove
	 */
	private int brelem;
	/**
	 * 
	 * @param i ako je i==0 onda je normalan tip, inace je tip funkcije
	 */
	public Tip(int i) {
		jtip = -1;
		definirana = 0;
		if(i!=0) {
			ftip = new ArrayList<Integer>();
			fun = true;
		} else {
			fun = false;
		}		
	}
	
	public Tip(Tip t) {
		if(t.ftip != null) {
			this.ftip = new ArrayList<Integer>(t.ftip);
		}	
		this.fun = t.fun;
		this.jtip = t.jtip;
		this.definirana = t.definirana;
		this.brelem = t.brelem;
	}

	public int getJtip() {
		return jtip;
	}

	public void setJtip(int jtip) {
		this.jtip = jtip;
	}

	public boolean isFun() {
		return fun;
	}

	public void setFun(boolean fun) {
		this.fun = fun;
	}

	public List<Integer> getFtip() {
		return ftip;
	}

	public void setFtip(List<Integer> ftip) {
		this.ftip = new ArrayList<Integer>(ftip);
	}

	public int getDefinirana() {
		return definirana;
	}

	public void setDefinirana(int definirana) {
		this.definirana = definirana;
	}

	public int getBrelem() {
		return brelem;
	}

	public void setBrelem(int brelem) {
		this.brelem = brelem;
	}
	
	
	
	
	
	
	
	
	
}
