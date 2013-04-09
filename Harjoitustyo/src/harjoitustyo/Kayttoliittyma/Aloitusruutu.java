/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Aloitusruutu implements Runnable {
     private JFrame frame;
     
     public Aloitusruutu(){
         
     }


    @Override
    public void run() {
        frame = new JFrame("Luo hahmo");
        frame.setPreferredSize(new Dimension(250, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    
    }
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(2, 1);
        container.setLayout(layout);

        JLabel nimiTeksti = new JLabel("Nimi: ");
        JTextField nimiKentta = new JTextField();
        

        JButton lisaaNappi = new JButton("Luo hahmo");
        HahmonLuonti luoja = new HahmonLuonti(nimiKentta);
        lisaaNappi.addActionListener(luoja);

        container.add(nimiTeksti);
        container.add(nimiKentta);
        container.add(new JLabel(""));
        container.add(lisaaNappi);
    }
    
}
