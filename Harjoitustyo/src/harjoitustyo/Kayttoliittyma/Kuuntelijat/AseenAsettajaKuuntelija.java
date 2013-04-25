/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma.Kuuntelijat;

import harjoitustyo.Kayttoliittyma.Kayttoliittyma;
import harjoitustyo.Kayttoliittyma.Selostusruutu;
import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author DemPetteri
 */
public class AseenAsettajaKuuntelija implements ActionListener {
    
    private Ase ase;
    private Henkilo henkilo;
    private Henkilo vihu;
    private Selostusruutu selostus;
    private JFrame frame;
    
    public AseenAsettajaKuuntelija(JFrame frame, Selostusruutu selostus, Ase ase, 
            Henkilo henkilo, Henkilo vihu) {
        this.frame = frame;
        this.selostus = selostus;
        this.ase = ase;
        this.henkilo = henkilo;
        this.vihu = vihu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        henkilo.lisaaAse(ase);
        frame.dispose();
        Kayttoliittyma kats = new Kayttoliittyma(this.selostus,this.henkilo, this.vihu);
        SwingUtilities.invokeLater(kats);
    }
    
}
