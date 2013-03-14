/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo;

/**
 *
 * @author petteriv
 */
public class Taistelu {
    
    public Taistelu(){
        
    }
    
    public void taistele(Henkilo lyoja, Henkilo torjuja){
        int vahinko = lyoja.getVoima() - torjuja.getPanssari();
        
        torjuja.otaVahinkoa(vahinko);
        
    }
}
