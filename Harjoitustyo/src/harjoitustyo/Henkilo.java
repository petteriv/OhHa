/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo;

/**
 *
 * @author petteriv
 */
public class Henkilo {
    
    private String nimi;
    private int HP;
    private int panssari;
    private int voima;
    private int lvl;
    private boolean elava;
    
    public Henkilo(String nimi){
        this.nimi = nimi;
        this.HP = 100;
        this.panssari = 10;
        this.voima = 20;
        this.lvl = 1;
        this.elava = true;
    }
    
    public String getNimi(){
        return this.nimi;
    }
        
    public int aiheutaVahinkoa(){
        return this.voima;
    }
    
    public int otaVahinkoa(int vahinko){
        this.HP = this.HP - vahinko;
        return this.HP;
    }
    
    public boolean kuolema(){
        if(this.HP<=0){
            this.elava = false;
        }
        return this.elava;
    }
    
    public int lisaaHP(int lisaHP){
        this.HP = this.HP + lisaHP;
        return this.HP;
    }
    
    public int lisaaVoimaa(int lisaVoima){
        this.voima = this.voima + lisaVoima;
        return this.voima;
    }
    
}
