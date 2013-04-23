/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo;

import harjoitustyo.hahmoJaVarusteet.Henkilo;
import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Panssari;

/**
 *
 * @author petteriv
 */
public class Taistelu {
    
   
    
    public Taistelu(){
       
    }
    
    public void taistele(Henkilo lyoja, Henkilo torjuja){
        int aseenVahinko = lyoja.getAse().vahinko();
        int vahinko = lyoja.getVoima() + aseenVahinko - torjuja.getAlkuPanssari();
        
        torjuja.otaVahinkoa(vahinko);
        System.out.println("\n-- " + lyoja.getNimi() + " aiheuttaa " + vahinko 
                + " pistettä vahinkoa aseellaan "
                + lyoja.getAse().getNimi() + " vastustajaan " 
                + torjuja.getNimi() + "! -- \n");
        
    }
}
