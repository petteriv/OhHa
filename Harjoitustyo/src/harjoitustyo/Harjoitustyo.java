/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo;

import harjoitustyo.Kayttoliittyma.Aloitusruutu;
import harjoitustyo.hahmoJaVarusteet.Panssari;
import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;

/**
 *
 * @author petteriv
 */
public class Harjoitustyo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ase ase = new Ase("nuija", 10, 10, 10);
        Panssari panssari = new Panssari("Harniska", 10);
        Henkilo paaHenkilo = new Henkilo("Pekka");
        Henkilo vihu = new Henkilo("Vihu");
        paaHenkilo.lisaaAse(ase);
        paaHenkilo.lisaaPanssari(panssari);
        vihu.lisaaAse(ase);
        vihu.lisaaPanssari(panssari);
        
        
        Taistelu testiTappelu = new Taistelu();
        testiTappelu.taistele(paaHenkilo, vihu);
        System.out.println(vihu.toString());
        
        
        
        vihu.tasoKasvaa();
        System.out.println(vihu.toString());
        
        System.out.println(paaHenkilo.toString());
        
        Aloitusruutu alk = new Aloitusruutu();
        alk.run();
        
        
        
        
        
    }
}
