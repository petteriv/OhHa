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
        Ase ase = new Ase("nuija", 10, 10, 10);
        Panssari panssari = new Panssari("Harniska", 10);
        Henkilo paaHenkilo = new Henkilo("Pekka");
        Henkilo vihu = new Henkilo("Vihu");
        paaHenkilo.lisaaAse(ase);
        vihu.lisaaPanssari(panssari);
        
        
        Taistelu testiTappelu = new Taistelu();
        testiTappelu.taistele(paaHenkilo, vihu);
        System.out.println(vihu.toString());
        
        
        
        vihu.tasoKasvaa();
        System.out.println(vihu.toString());
        
        
        
        
    }
}
