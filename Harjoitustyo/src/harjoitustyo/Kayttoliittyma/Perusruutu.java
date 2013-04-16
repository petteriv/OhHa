/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;


import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Perusruutu extends JPanel {
    
    private Henkilo henkilo;
    private Henkilo uusiHenkilo;
    public Perusruutu(Henkilo henkilo){
        this.henkilo = henkilo;
         super.setBackground(Color.WHITE);
    }

    
     @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        henkilo.piirra(graphics);
    }
     
    public void piirraUusi(Graphics graphics ,Henkilo henkilo) {
        this.uusiHenkilo = henkilo;
        this.uusiHenkilo.sijoita(150, 100);
        super.paintComponent(graphics);
        this.uusiHenkilo.piirra(graphics);
        
    } 
    
}
