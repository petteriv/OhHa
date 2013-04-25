/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma.Kuuntelijat;

import harjoitustyo.Kayttoliittyma.Kamanvaihtaja;
import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import harjoitustyo.hahmoJaVarusteet.Panssari;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author DemPetteri
 */
public class KamanVaihdonKuuntelija implements ActionListener {
    
     
     private Henkilo paaHenkilo;
     private Henkilo vihu;
     
    
    public KamanVaihdonKuuntelija(Henkilo paaHenkilo, Henkilo vihu){
        
        this.paaHenkilo = paaHenkilo;
        this.vihu = vihu;
        
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
        Kamanvaihtaja vaihtis = new Kamanvaihtaja(this.paaHenkilo, this.vihu);
        
        SwingUtilities.invokeLater(vaihtis);
        
    
    }
    
    
}
