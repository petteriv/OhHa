/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;


import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Perusruutu extends JPanel {
    
    private Henkilo henkilo;
    public Perusruutu(Henkilo henkilo){
        this.henkilo = henkilo;
         super.setBackground(Color.WHITE);
    }

    
     @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        henkilo.piirra(graphics);
    }
    
}
