/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma.Kuuntelijat;

import harjoitustyo.Kayttoliittyma.Kayttoliittyma;
import harjoitustyo.Kayttoliittyma.Kuolemaruutu;
import harjoitustyo.Kayttoliittyma.Selostusruutu;
import harjoitustyo.Taistelu;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author petteriv
 */
public class tappelunkuuntelija implements ActionListener {

    private Henkilo paaHenkilo;
    private Henkilo vihu;
    private JTextArea paaHtiedot;
    private JTextArea vihunTiedot;
    private JFrame frame;
    private Selostusruutu selostus;
    
    public tappelunkuuntelija(Selostusruutu selostus, JFrame frame, 
            Henkilo paaHenkilo, Henkilo vihu,
            JTextArea paaHtiedot,JTextArea vihunTiedot){
        this.selostus = selostus;
        this.paaHenkilo = paaHenkilo;
        this.vihu = vihu;
        this.paaHtiedot = paaHtiedot;
        this.vihunTiedot = vihunTiedot;
        this.frame = frame;
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
                tappelu.taistele(selostus, paaHenkilo, vihu);
                tappelu.taistele(selostus, vihu, paaHenkilo);
                this.paaHtiedot.setText(this.paaHenkilo.toString());
                this.vihunTiedot.setText(this.vihu.toString());                
 //               Kayttoliittyma kayt = new Kayttoliittyma(paaHenkilo, vihu);                
   //             frame.dispose(); 
     //           kayt.run();
                if(!paaHenkilo.tarkistaKuolema() || !vihu.tarkistaKuolema()){
                    Kuolemaruutu kr = new Kuolemaruutu(paaHenkilo, vihu);
                    kr.run();
                }
  
            }else{
                
                System.out.println("liian kaukana");
            }
        
    }
    
}
