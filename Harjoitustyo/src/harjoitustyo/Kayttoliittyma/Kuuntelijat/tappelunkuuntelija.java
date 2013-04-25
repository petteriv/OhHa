/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma.Kuuntelijat;

import harjoitustyo.Taistelu;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

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
    
    public boolean tappeluetaisyysX(){
           int Xetaisyys = this.paaHenkilo.getX() - this.vihu.getX();
           int Yetaisyys = this.paaHenkilo.getY() - this.vihu.getY();
           if((Math.abs(Xetaisyys)<41) & Math.abs(Yetaisyys)<41 ){
               
               return true;
           }else{
               return false;
           }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
           
            if(tappeluetaisyysX()){
                Taistelu tappelu = new Taistelu();
                tappelu.taistele(paaHenkilo, vihu);
                tappelu.taistele(vihu, paaHenkilo);
  
            }else{
                System.out.println("liian kaukana");
            }
        
    }
    
}
