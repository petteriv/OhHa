/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.hahmoJaVarusteet;

/**
 *
 * @author petteriv
 */
public class Panssari {
    private int panssariPisteet;
    private String nimi;
    
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
    
}
