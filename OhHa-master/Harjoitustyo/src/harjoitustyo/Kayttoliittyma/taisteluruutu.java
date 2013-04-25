/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author petteriv
 */
public class taisteluruutu extends JPanel {
    
    
    
    private Henkilo paaHenkilo;
    private Henkilo vihu;
    public taisteluruutu(Henkilo paahenkilo,Henkilo vihu ){
        this.paaHenkilo = paahenkilo;
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
