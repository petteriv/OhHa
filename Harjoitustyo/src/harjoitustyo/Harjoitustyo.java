/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo;

/**
 *
 * @author petteriv
 */
public class Harjoitustyo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Henkilo paaHenkilo = new Henkilo("Pekka");
        Henkilo vihu = new Henkilo("Vihu");
        
        Taistelu testiTappelu = new Taistelu();
        testiTappelu.taistele(paaHenkilo, vihu);
        System.out.println(vihu.toString());
        
        
        vihu.tasoKasvaa();
        System.out.println(vihu.toString());
        
        
        
        
    }
}
