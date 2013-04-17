
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import harjoitustyo.hahmoJaVarusteet.Panssari;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Kamanvaihtaja implements Runnable {
    
    private Henkilo henkilo;
    private JFrame frame;
    private Henkilo vihu;
    
    public Kamanvaihtaja(Henkilo henkilo, Henkilo vihu){
        this.henkilo = henkilo;
        this.vihu = vihu;
        
    }

    @Override
    public void run() {
        
        frame = new JFrame("Hahmon aseiden vaihto");
        frame.setPreferredSize(new Dimension(250, 200));

       

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
        
    public void luoKomponentit(Container container){
    
        GridLayout layout = new GridLayout(4, 1);
        
        
        JLabel uusiAse = new JLabel("Uuden aseen nimi:");       
        JTextField uudenTavaranNimi = new JTextField();
        
        JLabel aseVoima = new JLabel("Aseen voima:");
        JTextField aseVoimaa = new JTextField();
        //int voima = Integer.parseInt(aseVoimaa.getText());
        
        JLabel kritPros = new JLabel("Kriittisen %");     
        JTextField kritPrs = new JTextField();
       // int krit = Integer.parseInt(kritPrs.getText());
        
        JLabel extVahinko = new JLabel("Kriittinen vahinko");
        JTextField extraVahinko = new JTextField();
        //int extrVahinko = Integer.parseInt(extraVahinko.getText());
        
        JButton vahvista = new JButton("Vahvista");
        vahvista.addActionListener(new AseenAsettajaKuuntelija(new Ase("prkl",5,5,5), henkilo, this.vihu));
        
        container.setLayout(layout);
        container.add(uusiAse);
        container.add(uudenTavaranNimi);
        container.add(aseVoima);
        container.add(aseVoimaa);
        container.add(kritPros);
        container.add(kritPrs);
        container.add(extVahinko);
        container.add(extraVahinko);
        container.add(vahvista);
         
        
    }
    
}
