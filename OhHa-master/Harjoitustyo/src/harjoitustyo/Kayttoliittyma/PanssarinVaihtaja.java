package harjoitustyo.Kayttoliittyma;

import harjoitustyo.Kayttoliittyma.Kuuntelijat.Asettajat.AseenAsettajaKuuntelija;
import harjoitustyo.Kayttoliittyma.Kuuntelijat.Asettajat.PaaHenkilonPanssarinAsettaja;
import harjoitustyo.Kayttoliittyma.Kuuntelijat.Asettajat.VihunAseenAsettaja;
import harjoitustyo.Kayttoliittyma.Kuuntelijat.Asettajat.VihunPanssarinAsettaja;
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

public class PanssarinVaihtaja implements Runnable {
    
    private Henkilo henkilo;
    private JFrame frame;
    private Henkilo vihu;
    private ArrayList<Panssari> tavaralista;

    private Selostusruutu selostus;
    
    public PanssarinVaihtaja(Selostusruutu selostus, Henkilo henkilo, Henkilo vihu){
        this.selostus = selostus;

        this.henkilo = henkilo;
        this.vihu = vihu;
        tavaralista = new ArrayList<Panssari>();
        
    }

    @Override
    public void run() {
        
        frame = new JFrame("Hahmon panssarin vaihto");
        frame.setPreferredSize(new Dimension(550, 400));

       

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    public void lisataanListaan(){
        tavaralista.add(new Panssari("Silmukkahaarniska",10));
        tavaralista.add(new Panssari("Besaittuhaarniska",20));
        tavaralista.add(new Panssari("Levyhaarniska",30));
        tavaralista.add(new Panssari("Teräshaarniska",60));
        tavaralista.add(new Panssari("Mahtihaarniska",90));
    }
    
    public JPanel palkki(){
        JPanel palkki = new JPanel(new GridLayout(6,1));
        lisataanListaan();
        for (Panssari panssari : tavaralista) {
            JTextArea tietokentta = new JTextArea(panssari.toString());
            tietokentta.setEnabled(false);
            JButton lisaaAseVihulle = new JButton("Aseta panssari vihulle");
            lisaaAseVihulle.addActionListener(
                    new VihunPanssarinAsettaja(frame, selostus, panssari, henkilo, vihu));
            
            JButton lisaaAseItselle = new JButton("Aseta panssari itselle");
            lisaaAseItselle.addActionListener(
                    new PaaHenkilonPanssarinAsettaja(frame, selostus, panssari, henkilo, vihu));

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
