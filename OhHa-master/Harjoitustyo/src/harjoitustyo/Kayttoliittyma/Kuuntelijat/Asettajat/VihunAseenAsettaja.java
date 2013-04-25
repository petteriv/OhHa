package harjoitustyo.Kayttoliittyma.Kuuntelijat.Asettajat;

import harjoitustyo.Kayttoliittyma.Kayttoliittyma;
import harjoitustyo.Kayttoliittyma.Selostusruutu;
import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
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
public class VihunAseenAsettaja implements ActionListener {
    
    private Ase ase;
    private Henkilo henkilo;
    private Henkilo vihu;
    private Selostusruutu selostus;
    private JFrame frame;
    /**
     * konstruktori luo asettajan, joka asettaa viholliselle aseen.
     * @param frame edellinen ruutu joka suljetaan
     * @param selostus selostusruutu joka pidetään ajan tasalla
     * @param ase ase joka viholliselle lisätään
     * @param henkilo päähenkilö jota tarvitaan uuden ruudun aikaansaamiseksi
     * @param vihu  vihollinen joka saa uuden aseen
     */
    public VihunAseenAsettaja(JFrame frame, Selostusruutu selostus, Ase ase, 
            Henkilo henkilo, Henkilo vihu) {
        this.frame = frame;
        this.selostus = selostus;
        this.ase = ase;
        this.henkilo = henkilo;
        this.vihu = vihu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        selostus.lisaaTekstia("Henkilölle " + this.vihu.getNimi() 
                + " lisättiin " + ase.getNimi());
        vihu.lisaaAse(ase);
        selostus.hahmojenTiedot(henkilo, vihu);
        frame.dispose();
        Kayttoliittyma kats = new Kayttoliittyma(this.selostus,this.henkilo, this.vihu);
        SwingUtilities.invokeLater(kats);
    }
    
}