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
    private int MaxHP;
    private int HP;
    private int panssari;
    private int voima;
    private int lvl;
    private boolean elava;
    
    //Tämä olio toimii pohjana kaikkiin pelissä tarvittaviin hahmoihin
    //Olio luodaan valmiiden arvojen pohjalta, pelaaja valitsee itse alussa
    //hahmolleen nimen.
    
    
    //boolean elava kuvaa onko hahmo hengissä vai ei. Kun elava=false, hahmo 
    //kuolee. Jos hahmo on päähenkilö, peli loppuu.
    public Henkilo(String nimi){
        this.nimi = nimi;
        this.MaxHP = 100;
        this.HP = 100;
        this.panssari = 10;
        this.voima = 20;
        this.lvl = 1;
        this.elava = true;
    }
    //kun tarvitaan hahmon nimeä, kutsutaan tätä metodia
    public String getNimi(){
        return this.nimi;
    }
     //kun pelissä päästään taistelutilanteeseen, hahmo aiheuttaa vastustajaansa
    //vahinkoa voimansa verran.
    public int aiheutaVahinkoa(){
        return this.voima;
    }
    //taistelutilanteessa hahmo ottaa itseensä vahinkoa, jolloin vähennetään 
    //HP:ta.
    public int otaVahinkoa(int vahinko){
        this.HP = this.HP - vahinko;
        return this.HP;
    }
    //kun hahmon HP laskee 0 tai sen alle, hahmo kuolee. Eli this.elava vaihtuu
    //falseksi.
    public boolean kuolema(){
        if(this.HP<=0){
            this.elava = false;
        }
        return this.elava;
    }
    //Parannukset ja kehittyminen palauttaa HP.ta
    //HP ei voi kasvaa yli maksimiHP:n
    
    public int lisaaHP(int lisaHP){
        this.HP = this.HP + lisaHP;
        if(this.HP>this.MaxHP){
            this.HP = this.MaxHP;
        }
        return this.HP;
    }
    
    //hahmon kehittyessä voima lisääntyy
    
    public int lisaaVoimaa(int lisaVoima){
        this.voima = this.voima + lisaVoima;
        return this.voima;
    }
    
}
