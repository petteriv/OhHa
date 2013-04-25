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
public class Kuolemaruutu implements Runnable {
    
    private Henkilo paaHenkilo;
    private Henkilo vihu;
    private JFrame frame;
    
    public Kuolemaruutu(Henkilo paaHenkilo, Henkilo vihu){
        this.paaHenkilo = paaHenkilo;
        this.vihu = vihu;
    }
    public Kuolemaruutu(Henkilo vihu){
        this.vihu = vihu;
        
    }

    @Override
    public void run() {
        frame = new JFrame("Kuolema!");
        frame.setPreferredSize(new Dimension(550, 400));  

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        if(!this.paaHenkilo.tarkistaKuolema()){
            JTextArea kuolit = new JTextArea("Kuolit, peli päättyi");
            kuolit.setEditable(false);
            container.add(kuolit);
        }else{
            JTextArea tapoit = new JTextArea("Tapoit vihollisen " + vihu.getNimi());
            tapoit.setEditable(false);
            container.add(tapoit);
        }
    }
    
}
