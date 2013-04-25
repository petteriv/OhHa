/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma.Kuuntelijat;

import harjoitustyo.Kayttoliittyma.Kamanvaihtaja;
import harjoitustyo.Kayttoliittyma.PanssarinVaihtaja;
import harjoitustyo.Kayttoliittyma.Selostusruutu;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author DemPetteri
 */
public class PanssarinVaihdonKuuntelija implements ActionListener {

    private Henkilo paaHenkilo;
     private Henkilo vihu;
     private JFrame frame;
     private Selostusruutu selostus;
     
     public PanssarinVaihdonKuuntelija(Selostusruutu selostus, JFrame frame, Henkilo paaHenkilo, Henkilo vihu){
        this.frame = frame;
        this.paaHenkilo = paaHenkilo;
        this.vihu = vihu;
        this.selostus = selostus;
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.frame.dispose();
        PanssarinVaihtaja pans = new PanssarinVaihtaja(this.selostus,this.paaHenkilo, this.vihu);
        
        SwingUtilities.invokeLater(pans);
    }
    
}
