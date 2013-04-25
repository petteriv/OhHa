/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.Kayttoliittyma;

import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import harjoitustyo.hahmoJaVarusteet.Panssari;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.Graphics;

/**
 *
 * @author DemPetteri
 */
public class VihollisenLuonti implements ActionListener {
    
     private String nimi;
     private Henkilo paaHenkilo;
     private Component component;
    
    public VihollisenLuonti(String nimi, Henkilo paaHenkilo, Component component){
        this.nimi = nimi;
        this.paaHenkilo = paaHenkilo;
        this.component = component;
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
        Henkilo vihu = new Henkilo(this.nimi);       
        vihu.lisaaAse(new Ase("Nuija", 10,10,8));
        vihu.lisaaPanssari(new Panssari("Nahkanuttu", 5));
        
        
    
    }
    
    
}
