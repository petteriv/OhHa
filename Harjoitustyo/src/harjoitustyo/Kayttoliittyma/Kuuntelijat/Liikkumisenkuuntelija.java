/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma.Kuuntelijat;

import harjoitustyo.hahmoJaVarusteet.Henkilo;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DemPetteri
 */
public class Liikkumisenkuuntelija implements ActionListener{
    
    private Henkilo henkilo;
    private Henkilo vihu;
    private Component component;
    private int x;
    private int y;
    
    public Liikkumisenkuuntelija(Henkilo henkilo, Henkilo vihu, Component component, int x, int y){
        this.henkilo = henkilo;
        this.vihu = vihu;
        this.component = component;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        henkilo.siirra(x, y);
        vihu.siirra(-x, -y);
        component.repaint();
        
    }
    
}
