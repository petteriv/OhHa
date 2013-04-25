/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.Kayttoliittyma.Kuuntelijat.pelinSulkija;
import harjoitustyo.Kayttoliittyma.Kuuntelijat.uudenPelinKuuntelija;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author petteriv
 */
public class Kuolemaruutu implements Runnable {
    
    private Henkilo paaHenkilo;
    private Henkilo vihu;
    private JFrame frame;
    private Selostusruutu selostus;
    private JFrame kaytto;
    
    public Kuolemaruutu(JFrame kaytto, Selostusruutu selostus, Henkilo paaHenkilo, Henkilo vihu){
        this.kaytto = kaytto;
        this.selostus = selostus;
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
            JPanel panel = new JPanel(new GridLayout(1,2));
            JButton uusiPeli = new JButton("Uusi peli");
            uusiPeli.addActionListener(new uudenPelinKuuntelija(selostus, frame, kaytto));
            JButton sulje = new JButton("Sulje peli");
            sulje.addActionListener(new pelinSulkija());
            panel.add(uusiPeli);
            panel.add(sulje);
            container.add(kuolit);
            container.add(panel, BorderLayout.SOUTH);
           
        }else{
            JTextArea tapoit = new JTextArea("Tapoit vihollisen " + vihu.getNimi());
            tapoit.setEditable(false);
            JPanel panel = new JPanel(new GridLayout(1,2));
            JButton uusiPeli = new JButton("Uusi peli");
            uusiPeli.addActionListener(new uudenPelinKuuntelija(selostus, frame, kaytto));
            JButton sulje = new JButton("Sulje peli");
            sulje.addActionListener(new pelinSulkija());
            panel.add(uusiPeli);
            panel.add(sulje);
            container.add(tapoit);
            container.add(panel, BorderLayout.SOUTH);
            
        }
    }
    
}
