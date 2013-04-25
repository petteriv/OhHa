/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo;

import harjoitustyo.Kayttoliittyma.Selostusruutu;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Panssari;

/**
 *
 * @author petteriv
 */
public class Taistelu {
    private Henkilo lyoja;
    private Henkilo torjuja;
    private int vahinko;
    private Selostusruutu selostus;
    
   
    
    public Taistelu(){
       
    }
    
    public void taistele(Selostusruutu selostus, Henkilo lyoja, Henkilo torjuja){
        this.selostus = selostus;
        this.lyoja = lyoja;
        this.torjuja = torjuja;
        int aseenVahinko = lyoja.getAse().vahinko();
        this.vahinko = lyoja.getVoima() + aseenVahinko - torjuja.getYhteisPanssari();
        if(this.vahinko<0){
            this.vahinko=0;
        }
        torjuja.otaVahinkoa(this.vahinko);
        System.out.println("\n-- " + lyoja.getNimi() + " aiheuttaa " + vahinko 
                + " pistettä vahinkoa aseellaan "
                + lyoja.getAse().getNimi() + " vastustajaan " 
                + torjuja.getNimi() + "! -- \n");
        this.selostus.lisaaTekstia(selosta());
      
    }
    public String selosta(){
        return "\n-- " + lyoja.getNimi() + " aiheuttaa " + vahinko 
                + " pistettä vahinkoa aseellaan "
                + lyoja.getAse().getNimi() + " vastustajaan " 
                + torjuja.getNimi() + "! -- \n";
    }
    
}
