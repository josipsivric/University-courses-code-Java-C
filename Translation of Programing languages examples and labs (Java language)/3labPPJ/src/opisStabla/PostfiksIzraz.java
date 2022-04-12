package opisStabla;

public class PostfiksIzraz extends Cvor {
	
	public PostfiksIzraz(String ime) {
		super(ime);
	}
	
	@Override
	public void provjeri() {
		String odluka;
		odluka = imenaDjece();
		if(odluka.equals("<primarni_izraz>")){
			Cvor c = djeca.get(0);
			c.provjeri();
			tip = new Tip(c.tip);
			lIzraz = c.lIzraz;			
		} else if(odluka.equals("<postfiks_izraz>L_UGL_ZAGRADA<izraz>D_UGL_ZAGRADA")) {
			djeca.get(0).provjeri();
			Tip t = djeca.get(0).tip;
			if(t.getJtip() == Tip.NIZCCHAR) {
				tip.setJtip(Tip.CCHAR);
				lIzraz = 0;
			} else if(t.getJtip() == Tip.NIZCHAR) {
				tip.setJtip(Tip.CHAR);
				lIzraz = 1;
			} else if(t.getJtip() == Tip.NIZCINT) {
				tip.setJtip(Tip.CINT);
				lIzraz = 0;
			} else if(t.getJtip() == Tip.NIZINT) {
				tip.setJtip(Tip.INT);
				lIzraz = 1;
			} else {
				greska(); 
			}
			djeca.get(2).provjeri();
			t=djeca.get(2).tip;
			if(!(t.getJtip() == Tip.CCHAR || t.getJtip() == Tip.CHAR || t.getJtip() == Tip.CINT || t.getJtip() == Tip.INT)) {
				greska(); 
			}
		} else if(odluka.equals("<postfiks_izraz>L_ZAGRADAD_ZAGRADA")) {
			lIzraz = 0;
			Cvor c = djeca.get(0);
			c.provjeri();
			Tip t = c.tip;
			if(!(t.isFun() && t.getFtip().get(1) == Tip.VOID)) {
				greska(); //TODO 
			}
			tip.setJtip(t.getFtip().get(0));				
		} else if(odluka.equals("<postfiks_izraz>L_ZAGRADA<lista_argumenata>D_ZAGRADA")) {
			Cvor c0 = djeca.get(0);
			Cvor c2 = djeca.get(2);
			c0.provjeri();
			c2.provjeri();
			//trece pravilo:
			Tip p = c0.getTip();
			boolean provjera = true;
			if(p.isFun() && p.getFtip() != null && p.getFtip().size() == (c2.tipovi.size() + 1)) {
				tip.setJtip(p.getFtip().get(0));
				for(int i = 0; i < c2.tipovi.size(); i++) {
					provjera = jeSvodiv(c2.tipovi.get(i),p.getFtip().get(i+1));
					if(p.getFtip().get(i+1) == Tip.INT || p.getFtip().get(i+1) == Tip.CINT) {
						if(c2.tipovi.get(i) == Tip.CHAR || c2.tipovi.get(i) == Tip.CCHAR) {
							provjera = false;
						}
					}
					if(!provjera) break;
				}
			} else {
				provjera = false;
			}
			if(!provjera) {
				greska(); //TODO dodaj
			}
			
		} else if(odluka.equals("<postfiks_izraz>OP_INC") || odluka.equals("<postfiks_izraz>OP_DEC")) {
			Cvor c = djeca.get(0);
			c.provjeri();
			if(c.lIzraz == 0 || !jeSvodiv(c.tip.getJtip(), Tip.INT)) {
				greska(); // TODO dodaj
			}
			if(c.tip.getJtip() == Tip.CCHAR || c.tip.getJtip() == Tip.CHAR) {
				greska();
			}
			tip.setJtip(Tip.INT);
			lIzraz = 0;
			
		}else {
			System.err.println("Moja greska u:" + ime);
		}
		
	}
	
}
