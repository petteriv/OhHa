/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.hahmoJaVarusteet;

/**
 *olio joka liitetään Henkilo-olioon, josta Henkilo saa panssaripisteitä
 * 
 * 
 */
public class Panssari {
    private int panssariPisteet;
    private String nimi;
    /**
     * Kun panssari luodaan, se saa nimen, sekä panssaripisteitä 
     * sen mukaan kuinka hyvä panssari on
     * @param nimi
     * @param panssariPisteet 
     */
    public Panssari(String nimi, int panssariPisteet){
        this.nimi = nimi;
        this.panssariPisteet = panssariPisteet;
    }
    
    public int getPanssariPisteet(){
        return this.panssariPisteet;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    @Override
    public String toString(){
        return this.nimi + "(" + this.panssariPisteet + ")";
        
    }
    
}
