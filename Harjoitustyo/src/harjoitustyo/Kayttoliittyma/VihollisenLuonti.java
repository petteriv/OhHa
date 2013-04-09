/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import harjoitustyo.hahmoJaVarusteet.Panssari;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author DemPetteri
 */
public class VihollisenLuonti implements ActionListener {
    
     private JTextField nimiKentta;
    
    public VihollisenLuonti(JTextField nimikentta){
        this.nimiKentta = nimikentta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Henkilo vihu = new Henkilo(nimiKentta.getText());
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(vihu);
        vihu.lisaaAse(new Ase("Nuija", 10,10,8));
        vihu.lisaaPanssari(new Panssari("Nahkanuttu", 5));
        SwingUtilities.invokeLater(kayttoliittyma);
        
    }
    
    
}
