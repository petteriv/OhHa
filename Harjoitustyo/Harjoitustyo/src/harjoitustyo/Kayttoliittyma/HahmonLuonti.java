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
    
    private JTextField paaHenkNimi;
    private JTextField vihunNimi;
    
    public HahmonLuonti(JTextField paaHenkNimi, JTextField vihunNimi){
        this.paaHenkNimi = paaHenkNimi;
        this.vihunNimi = vihunNimi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Henkilo paaHenkilo = new Henkilo(paaHenkNimi.getText());
        Henkilo vihu = new Henkilo(vihunNimi.getText());
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(paaHenkilo, vihu);
        paaHenkilo.lisaaAse(new Ase("Nuija", 10,10,8));
        paaHenkilo.lisaaPanssari(new Panssari("Nahkanuttu", 5));
        paaHenkilo.sijoita(150, 400);
        
        vihu.lisaaAse(new Ase("Nuija", 10,10,8));
        vihu.lisaaPanssari(new Panssari("Nahkanuttu", 5));
        vihu.sijoita(150, 100);
        
        SwingUtilities.invokeLater(kayttoliittyma);
        System.out.println("Aloitat pelin hahmolla: " + paaHenkNimi.getText());
    }
    
    
}
