/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author DemPetteri
 */
public class AseenAsettajaKuuntelija implements ActionListener {
    
    private Ase ase;
    private Henkilo henkilo;
    private Henkilo vihu;
    
    public AseenAsettajaKuuntelija(Ase ase, Henkilo henkilo, Henkilo vihu) {
        this.ase = ase;
        this.henkilo = henkilo;
        this.vihu = vihu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        henkilo.lisaaAse(ase);
        Kayttoliittyma kats = new Kayttoliittyma(this.henkilo, this.vihu);
        SwingUtilities.invokeLater(kats);
    }
    
}
