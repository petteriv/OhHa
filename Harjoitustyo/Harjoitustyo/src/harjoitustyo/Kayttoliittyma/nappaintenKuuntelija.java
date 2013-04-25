/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author petteriv
 */
public class nappaintenKuuntelija implements KeyListener {
    
    private Henkilo paaHenkilo;
    private Henkilo vihu;
    private Component component;
    
    public nappaintenKuuntelija(Henkilo paaHenkilo, Henkilo vihu, Component component){
        this.component = component;
        this.paaHenkilo = paaHenkilo;
        this.vihu = vihu;
    }

  
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_KP_UP){
            this.paaHenkilo.siirra(0, 5);
        }else if(e.getKeyCode() == KeyEvent.VK_KP_DOWN){
            this.paaHenkilo.siirra(0, -5);
        }else if(e.getKeyCode() == KeyEvent.VK_KP_LEFT){
            this.paaHenkilo.siirra(-5, 0);
        }else if(e.getKeyCode() == KeyEvent.VK_KP_RIGHT){
            this.paaHenkilo.siirra(5, 0);
        }else if(e.getKeyCode() == KeyEvent.VK_W){
            this.vihu.siirra(0, 5);
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            this.vihu.siirra(0, -5);
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            this.vihu.siirra(-5, 0);
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            this.vihu.siirra(5, 0);
        }
        component.repaint();
    }
    
    

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
      @Override
    public void keyTyped(KeyEvent e) {
        
    }

}
