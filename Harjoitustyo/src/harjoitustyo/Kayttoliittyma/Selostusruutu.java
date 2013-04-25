/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author petteriv
 */
public class Selostusruutu implements Runnable {
    
    private JFrame frame;
    private JTextArea area;
    private Henkilo paaHenkilo;
    private Henkilo vihu;
    
    public Selostusruutu(Henkilo paaHenkilo, Henkilo vihu){
        this.paaHenkilo = paaHenkilo;
        this.vihu = vihu;
    }

    @Override
    public void run() {
        frame = new JFrame("Kuolema!");
        frame.setPreferredSize(new Dimension(550, 400));  

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);throw new UnsupportedOperationException("Not supported yet.");
    }

    private void luoKomponentit(Container container) {
            area = new JTextArea("Aloitit pelin hahmolla: " + paaHenkilo.getNimi() 
                    + "\n Vastustajasi on: " + vihu.getNimi());
            area.setEditable(false);
            container.add(area);
    }
    
    public void lisaaTekstia(String lisaTeksti){
            area.setText(area.getText() +"\n"+ lisaTeksti);
    }
}
