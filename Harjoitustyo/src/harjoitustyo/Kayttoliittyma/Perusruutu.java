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
    
    private Henkilo paaHenkilo;
    private Henkilo vihu;
    public Perusruutu(Henkilo paaHenkilo, Henkilo vihu){
        this.paaHenkilo = paaHenkilo;
        this.vihu = vihu;
         super.setBackground(Color.WHITE);
    }

    
     @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        paaHenkilo.piirra(graphics);
        vihu.piirra(graphics);
    }
     
   
       
}
