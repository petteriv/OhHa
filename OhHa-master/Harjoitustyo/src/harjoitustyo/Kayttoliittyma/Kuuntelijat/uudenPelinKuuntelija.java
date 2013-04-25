/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma.Kuuntelijat;

import harjoitustyo.Kayttoliittyma.Aloitusruutu;
import harjoitustyo.Kayttoliittyma.Selostusruutu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author DemPetteri
 */
public class uudenPelinKuuntelija implements ActionListener{
    
    private JFrame frame;
    private JFrame kaytto;
    private Selostusruutu selostus;
    
    public uudenPelinKuuntelija(Selostusruutu selostus, JFrame frame, JFrame kaytto){
        this.kaytto = kaytto;
        this.frame = frame;
        this.selostus = selostus;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.kaytto.dispose();
        this.frame.dispose();
        this.selostus.sulje();
        Aloitusruutu alku = new Aloitusruutu();
        alku.run();
    }
    
}
