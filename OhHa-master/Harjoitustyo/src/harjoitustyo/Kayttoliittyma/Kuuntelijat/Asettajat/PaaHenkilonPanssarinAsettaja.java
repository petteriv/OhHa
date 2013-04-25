package harjoitustyo.Kayttoliittyma.Kuuntelijat.Asettajat;

import harjoitustyo.Kayttoliittyma.Kayttoliittyma;
import harjoitustyo.Kayttoliittyma.Selostusruutu;
import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import harjoitustyo.hahmoJaVarusteet.Panssari;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *Luokka asettaa viholliselle aseen
 * 
 * 
 * 
 */
public class PaaHenkilonPanssarinAsettaja implements ActionListener {
    
    private Panssari panssari;
    private Henkilo henkilo;
    private Henkilo vihu;
    private Selostusruutu selostus;
    private JFrame frame;
    /**
     * konstruktori luo asettajan, joka asettaa päähenkilölle aseen.
     * @param frame edellinen ruutu joka suljetaan
     * @param selostus selostusruutu joka pidetään ajan tasalla
     * @param panssari panssari joka henkilolle laitetaan
     * @param henkilo päähenkilö jolle uusi panssari laitetaan
     * @param vihu  vihollinen käyttöliittymää varten
     */
    public PaaHenkilonPanssarinAsettaja(JFrame frame, Selostusruutu selostus, Panssari panssari, 
            Henkilo henkilo, Henkilo vihu) {
        this.frame = frame;
        this.selostus = selostus;
        this.panssari = panssari;
        this.henkilo = henkilo;
        this.vihu = vihu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        selostus.lisaaTekstia("Henkilölle " + this.henkilo.getNimi() 
                + " lisättiin " + panssari.getNimi());
        henkilo.lisaaPanssari(panssari);
        selostus.hahmojenTiedot(henkilo, vihu);
        frame.dispose();
        Kayttoliittyma kats = new Kayttoliittyma(this.selostus,this.henkilo, this.vihu);
        SwingUtilities.invokeLater(kats);
    }
    
}