/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.Taistelu;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author petteriv
 */
public class tappelunkuuntelija implements ActionListener {

    private Henkilo paaHenkilo;
    private Henkilo vihu;
    
    public tappelunkuuntelija(Henkilo paaHenkilo, Henkilo vihu){
        this.paaHenkilo = paaHenkilo;
        this.vihu = vihu;
    }
    
    public boolean tappeluetaisyys(){
           int Xetaisyys = this.paaHenkilo.getX() - this.vihu.getX();
           int Yetaisyys = this.paaHenkilo.getY() - this.vihu.getY();
           if((Xetaisyys < 20 || Xetaisyys > -20) && (Yetaisyys < 20 || Yetaisyys > -20 )){
               return true;
           }else{
               return false;
           }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
            boolean tapellaanko =tappeluetaisyys();
            if(tapellaanko = true){
                Taistelu tappelu = new Taistelu();
                tappelu.taistele(paaHenkilo, vihu);
                tappelu.taistele(vihu, paaHenkilo);
  
            }else{
                System.out.println("liian kaukana");
            }
        
    }
    
}
