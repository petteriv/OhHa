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
    
    public String getNimi(){
        return this.nimi;
    }

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
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    /**
     * metodin avulla hahmon voi sijoittaa ruudulla
     * @param x
     * @param y 
     */
    public void sijoita(int x, int y){
        this.x = x;
        this.y = y;
    }
    /**
     * metodin avulla hahmoa voi liikuttaa ruudulla.
     * @param x luku kuinka paljon hahmo liikkuu sivuttaissuunnassa
     * @param y luku kuinka paljon hahmo liikkuu pystysuunnassa
     */
    public void siirra(int x, int y) {
        this.x = this.x + x;
        if(this.x >280){
            this.x = 280;
        }else if(this.x<0){
            this.x = 0;
        }
         this.y = this.y + y;
        if(this.y < 0){
            this.y = 0;
        }else if(this.y >500){
            this.y = 500;
        }
    }
    
    /**
     * metodi vähentää hahmolta elämänpisteitä. Tarkistaa vähennyksen 
     * jälkeen kuoliko hahmo
     * @param vahinko kuinka paljon vahinkoa hahmo ottaa
     * @return palauttaa jäljellä olevan hp:n määrän
     */
    public int otaVahinkoa(int vahinko){
        this.HP = this.HP - vahinko;
        tarkistaKuolema();
        return this.HP;
    }
    /**
     * tarkistaa onko hahmo kuollut, eli onko HP 0 tai vähemmän
     * @return palauttaa joko true tai false riippuen onko hahmo kuollut
     */
    public boolean tarkistaKuolema(){
        if(this.HP<=0){
            this.elava = false;
        }
        return this.elava;
    }
    /**
     * metodi lisää hahmolle HP.ta. 
     * @param lisaHP lisättävän HP:n määrä
     */
    
    public void lisaaHP(int lisaHP){
        this.HP = this.HP + lisaHP;
        if(this.HP>this.MaxHP){
            this.HP = this.MaxHP;
        }
        
    }
    /**
     * metodi kasvattaa HP:n maksimimäärää
     * @param lisaHP määrä jolla maksimiHP kasvaa
     */
    public void lisaaMaxHP(int lisaHP){
        this.MaxHP = this.MaxHP + lisaHP;
    }
    
    /**
     * metodi lisää hahmon voimaa
     * @param lisaVoima määrä jolla voima kasvaa
     */
    public void lisaaVoimaa(int lisaVoima){
        if(lisaVoima<=0){
            
        }else{
        this.voima = this.voima + lisaVoima;
        
        }
        
        /**
         * metodi jolla lisätään hahmolle ase
         * @param Ase Ase-olio toimii parametrinä
         */
    }
        public void lisaaAse(Ase ase){
        this.ase = ase;
    }
        /**
        * metodi jolla liitetään hahmoon panssari
        * @param panssari parametrinä panssari
        */
        public void lisaaPanssari(Panssari panssari){
            this.panssari = panssari;
        }
    
    /**
     * metodi kasvattaa hahmon tasoa ja sen kykyjä
     */
    
    public void tasoKasvaa(){
        this.lvl++;
        lisaaVoimaa(5);
        lisaaMaxHP(20);
        lisaaHP(20);
        
    }
    /**
     * metodi graafista käyttöliittymää varten. Piirtää
     * @param graphics 
     */
    public void piirra(Graphics graphics){
       graphics.fillRect(x, y, 20, 20);
    }
    

    
    
    
    /**
     * metodi palauttaa hahmon tiedot
     * @return palauttaa tekstinä tiedot
     */
    @Override
    public String toString(){
        return  "\n----------------------------\n " + this.nimi + 
                "\n Taso: "+ this.lvl + 
                "\n HP: " + this.HP + "/" + this.MaxHP + 
                "\n Panssari: " 
                + this.panssari.getNimi()+ " " + this.alkuPanssari +
                "(+" + this.panssari.getPanssariPisteet() + ")" + 
                "\n Voima: " + this.voima + 
                "\n Ase: " + this.ase.getNimi() +
                "(+" + this.ase.getPerusVahinko() + ")" +
                
                "\n----------------------------";
    }
    
}
