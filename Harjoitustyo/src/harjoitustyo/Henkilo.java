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
    public int getVoima(){
        return this.voima;
    }
    
    public int getHP(){
        return this.HP;
    }
    
    public int getPanssari(){
        return this.panssari;
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
    
    //kun hahmon taso kasvaa, sen taidot kehittyvät
    
    public void tasoKasvaa(){
        this.lvl++;
        lisaaVoimaa(5);
        lisaaMaxHP(20);
        lisaaHP(20);
        
    }
    
    
    
    //toString palauttaa arvona hahmon tiedot. 
    //hahmon elossa olevuutta ei näytetä
    public String toString(){
        return  " " + this.nimi + 
                "\n taso: "+ this.lvl + 
                "\n HP: " + this.HP + "/" + this.MaxHP + 
                "\n panssari: " + this.panssari + 
                "\n voima: " + this.voima;
    }
    
}
