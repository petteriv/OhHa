/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma.Kuuntelijat;

import harjoitustyo.Kayttoliittyma.Kamanvaihtaja;
import harjoitustyo.Kayttoliittyma.Selostusruutu;
import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import harjoitustyo.hahmoJaVarusteet.Panssari;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author DemPetteri
 */
public class AseenVaihdonKuuntelija implements ActionListener {
    
     
     private Henkilo paaHenkilo;
     private Henkilo vihu;
     private JFrame frame;
     private Selostusruutu selostus;
     
    
    public AseenVaihdonKuuntelija(Selostusruutu selostus, JFrame frame, Henkilo paaHenkilo, Henkilo vihu){
        
        this.frame = frame;
        this.paaHenkilo = paaHenkilo;
        this.vihu = vihu;
        this.selostus = selostus;
        
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.frame.dispose();
        Kamanvaihtaja vaihtis = new Kamanvaihtaja(this.selostus,this.paaHenkilo, this.vihu);
        
        SwingUtilities.invokeLater(vaihtis);
        
    
    }
    
    
}
