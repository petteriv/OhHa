/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma.Kuuntelijat;


import harjoitustyo.Kayttoliittyma.Kuolemaruutu;
import harjoitustyo.Kayttoliittyma.Selostusruutu;
import harjoitustyo.Taistelu;

import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author DemPetteri
 */
public class Liikkumisenkuuntelija implements ActionListener{
    
    private Henkilo henkilo;
    private Henkilo vihu;
    private Component component;
    private int x;
    private int y;
    private JFrame kaytto;
    private Selostusruutu selostus;
    
    public Liikkumisenkuuntelija(JFrame kaytto, Selostusruutu selostus, 
            Henkilo henkilo, Henkilo vihu, Component component, int x, int y){
        
        this.selostus = selostus;
        this.kaytto = kaytto;   
        this.henkilo = henkilo;
        this.vihu = vihu;
        this.component = component;
        this.x = x;
        this.y = y;
    }
    

     public boolean etaisyys(){
           int Xetaisyys = this.henkilo.getX() - this.vihu.getX();
           int Yetaisyys = this.henkilo.getY() - this.vihu.getY();
           if((Math.abs(Xetaisyys)<41) & Math.abs(Yetaisyys)<41 ){
               
               return true;
           }else{
               return false;
           }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        henkilo.siirra(x, y);
        int Xetaisyys = this.henkilo.getX() - this.vihu.getX();
        int Yetaisyys = this.henkilo.getY() - this.vihu.getY();
        if(Xetaisyys < 0 & Yetaisyys <0){
            vihu.siirra(-20, -20);
        }else if(Xetaisyys < 0 & Yetaisyys > 0){
            vihu.siirra(-20, 20);
        }else if(Xetaisyys > 0 & Yetaisyys > 0){
            vihu.siirra( 20,  20);
        }else if(Xetaisyys > 0 & Yetaisyys < 0){
            vihu.siirra( 20, -20);
        }
        if(etaisyys()){
            Taistelu tappelu = new Taistelu();
            tappelu.taistele(selostus, vihu, henkilo);
        }if(!henkilo.tarkistaKuolema() || !vihu.tarkistaKuolema()){
                    Kuolemaruutu kr = new Kuolemaruutu(kaytto, selostus, henkilo, vihu);
                    kr.run();
                }


        component.repaint();
        
    }
    
}
