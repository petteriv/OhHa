/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

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
        Perusruutu perus = new Perusruutu();
    }
    
    
}
