/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
    private JTextArea paaHenkilonTiedot;
    private JTextArea vihunTiedot;
    
    public Selostusruutu(Henkilo paaHenkilo, Henkilo vihu){
        this.paaHenkilo = paaHenkilo;
        this.vihu = vihu;
    }

    @Override
    public void run() {
        frame = new JFrame("Mertarannan selostuslaatikko");
        frame.setPreferredSize(new Dimension(550, 400));  

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
            area = new JTextArea("Aloitit pelin hahmolla: " + paaHenkilo.getNimi() 
                    + "\n Vastustajasi on: " + vihu.getNimi());
            area.setEditable(false);
            container.add(area);
            JPanel alapalkki = new JPanel(new GridLayout(1,2));

            paaHenkilonTiedot = new JTextArea(paaHenkilo.toString());
            vihunTiedot = new JTextArea(vihu.toString());
            alapalkki.add(paaHenkilonTiedot);
            alapalkki.add(vihunTiedot);
            container.add(alapalkki, BorderLayout.SOUTH);
    }
    
    public void lisaaTekstia(String lisaTeksti){
            if(area.getText().length()>300){
                area.setText(lisaTeksti);
            }else{
            area.setText(area.getText() +"\n"+ lisaTeksti);
            }
    }
    public void hahmojenTiedot(Henkilo paaHenkilo, Henkilo vihu){
            paaHenkilonTiedot.setText(paaHenkilo.toString());
            vihunTiedot.setText(vihu.toString());
    }
    
    public void sulje(){
            frame.dispose();
    }
}
