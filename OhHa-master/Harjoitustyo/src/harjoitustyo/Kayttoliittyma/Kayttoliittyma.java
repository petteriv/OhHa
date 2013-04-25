/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.Kayttoliittyma.Kuuntelijat.Liikkumisenkuuntelija;
import harjoitustyo.Kayttoliittyma.Kuuntelijat.AseenVaihdonKuuntelija;
import harjoitustyo.Kayttoliittyma.Kuuntelijat.PanssarinVaihdonKuuntelija;
import harjoitustyo.Kayttoliittyma.Kuuntelijat.tappelunkuuntelija;
import harjoitustyo.Kayttoliittyma.Kuuntelijat.nappaintenKuuntelija;
import harjoitustyo.Kayttoliittyma.Kuuntelijat.pelinSulkija;
import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import harjoitustyo.hahmoJaVarusteet.Panssari;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author DemPetteri
 */
public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Henkilo paaHenkilo;
    private Henkilo vihu;
    private Perusruutu perus;
    private Selostusruutu selostus;
    
    public Kayttoliittyma(Selostusruutu selostus, Henkilo paaHenkilo, Henkilo vihu){
        this.selostus = selostus;
        this.paaHenkilo = paaHenkilo;
        this.vihu = vihu;      
    }
    

    @Override
    public void run() {
        frame = new JFrame("TOIMII");
        frame.setPreferredSize(new Dimension(600, 600));
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true); 
        frame.repaint();
    }

    private void luoKomponentit(Container container) {
        perus = new Perusruutu(paaHenkilo, vihu);
        container.add(perus);
        frame.addKeyListener(new nappaintenKuuntelija(paaHenkilo, vihu, perus));
        container.add(sivupalkki(), BorderLayout.EAST);  
        container.add(lopetusPalikka(), BorderLayout.SOUTH);

       
    }
    private JPanel sivupalkki(){
        JPanel palkki = new JPanel(new GridLayout(3,1));
        palkki.setPreferredSize(new Dimension(300,300));
        palkki.add(paaHenkilonTiedot());
        palkki.add(valikkonappulat());
        palkki.add(vihunTiedot());
        return palkki;
    }
    
    
    
     private JTextArea paaHenkilonTiedot(){
        JTextArea tietokentta = new JTextArea(paaHenkilo.toString());
        tietokentta.setEnabled(false);
        return tietokentta;
    }
     
    private JPanel lopetusPalikka(){
        JPanel palikka = new JPanel(new GridLayout(1,1));
        palikka.setPreferredSize(new Dimension(10, 40));
        JButton lopetus = new JButton("lopeta peli");
        lopetus.addActionListener(new pelinSulkija());
        palikka.add(lopetus);
        return palikka;
    } 
    

    private JPanel valikkonappulat() {
        JPanel nappulat = new JPanel(new GridLayout(3,1));
        JButton omatKamat = new JButton("Aselista");
        omatKamat.addActionListener(new AseenVaihdonKuuntelija(selostus, frame, paaHenkilo, vihu));
        nappulat.add(omatKamat); 
        JButton panssarit = new JButton("Panssarilista");
        panssarit.addActionListener(new PanssarinVaihdonKuuntelija(selostus, frame, paaHenkilo, vihu));        
        nappulat.add(liikkumisnapit());
        nappulat.add(panssarit);
        return nappulat;
    }
    
    private JPanel liikkumisnapit() {
        JPanel napit = new JPanel (new GridLayout(3,3));
        JButton vasenYlos = new JButton("<^");
        JButton ylos = new JButton("^");
        JButton oikeaYlos = new JButton("^>");
        JButton vasen = new JButton("<");
        JButton tappele = new JButton("FIGHT");
        JButton oikea = new JButton (">");
        JButton vasenAlas = new JButton("<V");
        JButton alas = new JButton("V");
        JButton oikeaAlas = new JButton("V>");
                
        tappele.addActionListener(new tappelunkuuntelija(selostus,frame, this.paaHenkilo, this.vihu));
        vasenYlos.addActionListener(new Liikkumisenkuuntelija(frame, selostus,paaHenkilo,vihu, perus, -20, -20));
        ylos.addActionListener(new Liikkumisenkuuntelija(frame, selostus,paaHenkilo,vihu, perus, 0, -20));
        oikeaYlos.addActionListener(new Liikkumisenkuuntelija(frame, selostus,paaHenkilo,vihu, perus, 20, -20));
        vasen.addActionListener(new Liikkumisenkuuntelija(frame, selostus,paaHenkilo,vihu, perus, -20, 0));
        oikea.addActionListener(new Liikkumisenkuuntelija(frame, selostus,paaHenkilo,vihu, perus, 20, 0));
        vasenAlas.addActionListener(new Liikkumisenkuuntelija(frame, selostus,paaHenkilo,vihu, perus, -20, 20));
        alas.addActionListener(new Liikkumisenkuuntelija(frame, selostus,paaHenkilo,vihu, perus, 0, 20));
        oikeaAlas.addActionListener(new Liikkumisenkuuntelija(frame, selostus,paaHenkilo,vihu, perus, 20, 20));

        napit.add(vasenYlos);
        napit.add(ylos);
        napit.add(oikeaYlos);
        napit.add(vasen);
        napit.add(tappele);
        napit.add(oikea);
        napit.add(vasenAlas);
        napit.add(alas);
        napit.add(oikeaAlas);
        return napit;
        
                
    }
    
    private JTextArea vihunTiedot() {
        JTextArea tietokentta = new JTextArea(vihu.toString());
        tietokentta.setEnabled(false);
        return tietokentta;
    }
    
    public JFrame getFrame() {
        return frame;
    }
   
    
}
