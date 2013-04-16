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
    
    public Kayttoliittyma(Henkilo henkilo){
        this.paaHenkilo = henkilo;
        this.taistelussa = false;
    }
    

    @Override
    public void run() {
        frame = new JFrame("TOIMII");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true); //To change body of generated methods, choose Tools | Templates.
    }

    private void luoKomponentit(Container container) {
        Perusruutu perus = new Perusruutu(paaHenkilo);
        container.add(perus);
        container.add(sivupalkki(), BorderLayout.EAST);
    }
    private JPanel sivupalkki(){
        JPanel palkki = new JPanel(new GridLayout(3,1));
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
        JPanel nappulat = new JPanel(new GridLayout(1,3));
        JButton taistelu = new JButton("Taistele");
        taisteluruutu taistelua = new taisteluruutu(paaHenkilo,uusiVihu("Reiska"));
        VihollisenLuonti luonti = new VihollisenLuonti(
                "Vihu", paaHenkilo,taistelua);
        nappulat.add(taistelu);
        taistelu.addActionListener(luonti);
        nappulat.add(new JButton("Kauppa"));
        nappulat.add(new JButton("LVL up"));
        return nappulat;
    }
    
    public Henkilo uusiVihu(String nimi){
        Henkilo vihu = new Henkilo(nimi);
        vihu.lisaaAse(new Ase("keppi", 5, 5, 5));
        vihu.lisaaPanssari(new Panssari("nahkanuttu", 4));
        return vihu;
    }

    private JTextArea vihunTiedot() {
        return (new JTextArea(""));
        
//        if(this.taistelussa = false){
//            return (new JTextArea(""));
//        }else{
//            return (new JTextArea(vihu.toString()));
//        }
    }

    
    
}
