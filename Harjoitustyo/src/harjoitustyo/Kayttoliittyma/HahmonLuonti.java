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
 * @author petteriv
 */
public class HahmonLuonti implements ActionListener {
    
    private JTextField nimiKentta;
    
    public HahmonLuonti(JTextField nimikentta){
        this.nimiKentta = nimikentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Henkilo paaHenkilo = new Henkilo(nimiKentta.getText());
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(paaHenkilo);
        paaHenkilo.lisaaAse(new Ase("Nuija", 10,10,8));
        paaHenkilo.lisaaPanssari(new Panssari("Nahkanuttu", 5));
        paaHenkilo.sijoita(150, 400);
        SwingUtilities.invokeLater(kayttoliittyma);
        System.out.println("Aloitat pelin hahmolla: " + nimiKentta.getText());
    }
    
    
}
