public class Labos {
 
    public static String ulaznaDatoteka[] = {
        "{prvaDecZnamenka} 1|2|3|4|5|6|7|8|9",
        "{decZnamenka} 0|{prvaDecZnamenka}",
        "{decBroj} {prvaDecZnamenka}{decZnamenka}*",
        "{hexZnamenka} {decZnamenka}|a|b|c|d|f",
        "{hexBroj} 0x{hexZnamenka}{hexZnamenka}*",
        "<S_komentar>{sviZnakovi}",
        "{",
        "-",
        "}"
    };
 
    /*
     * za svaku regularnu definiciju {regDef} u Ulaznoj Datoteci neka je regEx regularni izraz
     * koji opisuje definicjiu {regDef}
     * za svaku referencu {refRegDef} u regularnom izrazu regEx
     * zamijeni {refRegDef} u izrazu regEx s "(" + regularniIzraz[{refRegDef}] + ")"
     * regularniIzraz[{regDef}] = regEx
     */
 
    public static String pripremiRegex(String regDef){
       
        String regEx = pronadiDefiniciju(regDef);
        //System.out.println(regEx);
       
        if(regEx == null)
            return null;
       
        String pomocni[] = regEx.split("\\{");
       
        //System.out.println(Arrays.toString(pomocni));
               
        for(int i = 1; i < pomocni.length; ++i) {
            String pomocni2[] = pomocni[i].split("\\}", 2);
            //System.out.println(Arrays.toString(pomocni2));
            if(pomocni[0] != null)
                regEx = regEx.replaceAll("\\{" + pomocni2[0] + "\\}", "(" + pripremiRegex(pomocni2[0]) + ")");
        }
       
        return regEx;
    }
   
   
    // pronalazi liniju sa definicijom u "ulaznoj datoteci"
    public static String pronadiDefiniciju(String regDef) {
        regDef = regDef.trim();
        for(String s : ulaznaDatoteka) {   
            String regEx[] = s.split("\\{|\\}", 3);
           
            //System.out.println(Arrays.toString(regEx));
           
            if(regEx[1].trim().equals(regDef)){
                return regEx[2].trim();
            }
        }
       
        return null;
    }
 
 
    /**
     * @param args
     */
    public static void main(String[] args) {
       
        System.out.println("prvaDecZnamenka = " + pripremiRegex("prvaDecZnamenka"));
        System.out.println("decZnamenka = " + pripremiRegex("decZnamenka"));
        System.out.println("decBroj = " + pripremiRegex("decBroj"));
        System.out.println("hexZnamenka = " + pripremiRegex("hexZnamenka"));
        System.out.println("hexBroj = " + pripremiRegex("hexBroj"));
    }
}