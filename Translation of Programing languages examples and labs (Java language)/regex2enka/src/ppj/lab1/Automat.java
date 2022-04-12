package ppj.lab1;
import java.util.*;


public class Automat {
	
	public int brStanja = 0;
	public int pocetnoStanje;
	public int prihvatljivoStanje;
	
	public ArrayList<String> prijelazi = new ArrayList<String>();
	
	//prijelazi se zapisuju u obliku "stanje1,znak->stanje2"
	
	@Override
	public String toString() {
		
		String ret = "";
		// TODO Auto-generated method stub
		
		for(String tmp : prijelazi){
			
			ret+="\n"+tmp;
			
			
		}
		
		return ret+"\n";
	}
	
	

}
