/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.hahmoJaVarusteet;

import java.awt.Graphics;

/**
 *
 * @author petteriv
 */
public class Henkilo {
    
    private String nimi;
    private int MaxHP;
    private int HP;
    private int alkuPanssari;
    private int voima;
    private int lvl;
    private boolean elava;
    private Ase ase;
    private Panssari panssari;
    private int x;
    private int y;
    
    //Tämä olio toimii pohjana kaikkiin pelissä tarvittaviin hahmoihin
    //Olio luodaan valmiiden arvojen pohjalta, pelaaja valitsee itse alussa
    //hahmolleen nimen.
    
    //maxHP ilmaisee hahmon maksimikestopisteet. pelin edetessä pistemäärä nousee
    //HP ilmaisee hahmon kestopisteet kyseisellä hetkellä. määrä ei voi olla
    //suurempi kuin maksimiHP
    
    
    
    
    
    //boolean elava kuvaa onko hahmo hengissä vai ei. Kun elava=false, hahmo 
    //kuolee. Jos hahmo on päähenkilö, peli loppuu.
    public Henkilo(String nimi){
        if(nimi.isEmpty()){
            this.nimi = "default";
        }else{
            this.nimi = nimi;
        }
        this.MaxHP = 100;
        this.HP = 100;
        this.alkuPanssari = 10;
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
    public int getVoima(){
        return this.voima;
    }
    
    public int getHP(){
        return this.HP;
    }
    
    public int getAlkuPanssari(){
        return this.alkuPanssari;
    }
    
    public int getYhteisPanssari(){
        
        return this.alkuPanssari + this.panssari.getPanssariPisteet();
         
    }
    
    public int getTaso(){
        return this.lvl;
    }
    
    public Ase getAse(){
        return this.ase;
    }
    
    public void sijoita(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    //taistelutilanteessa hahmo ottaa itseensä vahinkoa, jolloin vähennetään 
    //HP:ta.
    public int otaVahinkoa(int vahinko){
        this.HP = this.HP - vahinko;
        tarkistaKuolema();
        return this.HP;
    }
    //kun hahmon HP laskee 0 tai sen alle, hahmo kuolee. Eli this.elava vaihtuu
    //falseksi.
    public boolean tarkistaKuolema(){
        if(this.HP<=0){
            this.elava = false;
        }
        return this.elava;
    }
    //Parannukset ja kehittyminen palauttaa HP.ta
    //HP ei voi kasvaa yli maksimiHP:n
    
    public void lisaaHP(int lisaHP){
        this.HP = this.HP + lisaHP;
        if(this.HP>this.MaxHP){
            this.HP = this.MaxHP;
        }
        
    }
    
    public void lisaaMaxHP(int lisaHP){
        this.MaxHP = this.MaxHP + lisaHP;
    }
    
    //hahmon kehittyessä voima lisääntyy
    
    public void lisaaVoimaa(int lisaVoima){
        if(lisaVoima<=0){
            
        }else{
        this.voima = this.voima + lisaVoima;
        
        }
        
    }
        public void lisaaAse(Ase ase){
        this.ase = ase;
    }
        
        public void lisaaPanssari(Panssari panssari){
            this.panssari = panssari;
        }
    
    //kun hahmon taso kasvaa, sen taidot kehittyvät
    
    public void tasoKasvaa(){
        this.lvl++;
        lisaaVoimaa(5);
        lisaaMaxHP(20);
        lisaaHP(20);
        
    }
    
    public void piirra(Graphics graphics){
       graphics.fillRect(x, y, 10, 10);
    }
    

    
    
    
    //toString palauttaa arvona hahmon tiedot. 
    //hahmon elossa olevuutta ei näytetä
    public String toString(){
        return  "\n--------------------\n " + this.nimi + 
                "\n Taso: "+ this.lvl + 
                "\n HP: " + this.HP + "/" + this.MaxHP + 
                "\n Panssari: " 
                + this.panssari.getNimi()+ " " + this.alkuPanssari +
                "(+" + this.panssari.getPanssariPisteet() + ")" + 
                "\n Voima: " + this.voima + 
                "\n Ase: " + this.ase.getNimi() +
                "(+" + this.ase.getPerusVahinko() + ")" +
                
                "\n--------------------";
    }
    
}
