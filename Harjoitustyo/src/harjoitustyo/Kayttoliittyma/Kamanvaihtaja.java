
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.Kayttoliittyma.Kuuntelijat.AseenAsettajaKuuntelija;
import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import harjoitustyo.hahmoJaVarusteet.Panssari;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Kamanvaihtaja implements Runnable {
    
    private Henkilo henkilo;
    private JFrame frame;
    private Henkilo vihu;
    private ArrayList<Ase> tavaralista;
    private Selostusruutu selostus;
    
    public Kamanvaihtaja(Selostusruutu selostus, Henkilo henkilo, Henkilo vihu){
        this.selostus = selostus;
        this.henkilo = henkilo;
        this.vihu = vihu;
        tavaralista = new ArrayList<Ase>();
        
    }

    @Override
    public void run() {
        
        frame = new JFrame("Hahmon aseiden vaihto");
        frame.setPreferredSize(new Dimension(550, 400));

       

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    public void lisataanListaan(){
        tavaralista.add(new Ase("Keihäs", 20, 20, 10));
        tavaralista.add(new Ase("Bastardimiekka", 30, 15, 40));
        tavaralista.add(new Ase("Tulikeihäs", 50, 10, 20));
        tavaralista.add(new Ase("Katana", 30, 30, 40));
        tavaralista.add(new Ase("Alin sapeli", 40, 70, 40));
        tavaralista.add(new Ase("Excalibur", 100, 90, 80));
        
    }
    
    public JPanel palkki(){
        JPanel palkki = new JPanel(new GridLayout(6,1));
        lisataanListaan();
        for (Ase ase : tavaralista) {
            JTextArea tietokentta = new JTextArea(ase.toString());
            tietokentta.setEnabled(false);
            JButton lisaaAseVihulle = new JButton("Aseta ase vihulle");
            
            JButton lisaaAseItselle = new JButton("Aseta ase itselle");
            lisaaAseItselle.addActionListener(
                    new AseenAsettajaKuuntelija(frame, selostus, ase, henkilo, vihu));
            palkki.add(tietokentta);
            palkki.add(lisaaAseItselle);
            palkki.add(lisaaAseVihulle);
                    
        }
        return palkki;
    }
        
    public void luoKomponentit(Container container){
    
       container.add(palkki());
        
        
        
   
        
    }
    
}
