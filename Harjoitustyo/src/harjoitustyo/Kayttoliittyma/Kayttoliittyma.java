/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

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
    private boolean taistelussa;
    private Perusruutu perus;
    
    public Kayttoliittyma(Henkilo paaHenkilo, Henkilo vihu){
        this.paaHenkilo = paaHenkilo;
        this.vihu = vihu;
        this.taistelussa = false;
       
    }
    

    @Override
    public void run() {
        frame = new JFrame("TOIMII");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true); 
    }

    private void luoKomponentit(Container container) {
        perus = new Perusruutu(paaHenkilo, vihu);
        container.add(perus);
        container.add(sivupalkki(), BorderLayout.EAST);
        
        frame.addKeyListener(new nappaintenKuuntelija(paaHenkilo, vihu, perus));
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

    private JPanel valikkonappulat() {
        JPanel nappulat = new JPanel(new GridLayout(3,1));
        JButton omatKamat = new JButton("Omat kamat");
        omatKamat.addActionListener(new KamanVaihdonKuuntelija(paaHenkilo, vihu));
        nappulat.add(omatKamat); 
        nappulat.add(liikkumisnapit());
        nappulat.add(new JButton("LVL up"));
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
        vasenYlos.addActionListener(new Liikkumisenkuuntelija(paaHenkilo, perus, -20, -20));
        ylos.addActionListener(new Liikkumisenkuuntelija(paaHenkilo, perus, 0, -20));
        oikeaYlos.addActionListener(new Liikkumisenkuuntelija(paaHenkilo, perus, 20, -20));
        vasen.addActionListener(new Liikkumisenkuuntelija(paaHenkilo, perus, -20, 0));
        oikea.addActionListener(new Liikkumisenkuuntelija(paaHenkilo, perus, 20, 0));
        vasenAlas.addActionListener(new Liikkumisenkuuntelija(paaHenkilo, perus, -20, 20));
        alas.addActionListener(new Liikkumisenkuuntelija(paaHenkilo, perus, 0, 20));
        oikeaAlas.addActionListener(new Liikkumisenkuuntelija(paaHenkilo, perus, 20, 20));
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

    
    
}
