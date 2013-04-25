/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.Taistelu;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 *
 * @author petteriv
 */
public class HahmojenTietojenPaivitys implements ActionListener{
    
    private Henkilo paaHenkilo;
    private Henkilo vihu;
    private Taistelu taistelu;
    private JTextArea paaHtiedot;
    private JTextArea vihunTiedot;
    
    public HahmojenTietojenPaivitys(JTextArea paaHtiedot,JTextArea vihunTiedot,
            Henkilo paaHenkilo, Henkilo vihu){
        this.paaHtiedot = paaHtiedot;
        this.vihunTiedot = vihunTiedot;
        this.paaHenkilo = paaHenkilo;
        this.vihu = vihu;
               
    }
    
    public JTextArea taistelunSelostus(Taistelu taistelu){
        this.taistelu = taistelu;
        JTextArea selostus = new JTextArea();
        selostus.setText(this.taistelu.selosta());
        return selostus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.paaHtiedot.setText(this.paaHenkilo.toString());
        this.vihunTiedot.setText(this.vihu.toString());
       
    }
    
}
