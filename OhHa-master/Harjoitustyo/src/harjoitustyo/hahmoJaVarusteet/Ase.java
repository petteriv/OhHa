package harjoitustyo.hahmoJaVarusteet;

import java.util.Random;

/**
 *
 * @author petteriv
 */
public class Ase {
    Random random = new Random();
    private String nimi;
    private int perusVahinko;
    private int extraVahinko;
    private int kriittisenIskunTodennakoisyys;
    //perusvahinko ilmoittaa luvun jonka ase tuottaa vahinkoa joka tapauksessa
    //extravahinko on vahinko, joka lisätään yhteisvahinkoon, jos ase iskee
    //kriittisesti. KriittisenIskunTodennäköisyys kertoo todennäköisyyden
    //kriittiselle iskulle.
    
    /*'
     * Olion Ase konstruktori
     * 
     * @param nimi              Aseelle annettava nimi
     * @param iskuvoima         Aseen perusvahinko
     * @param kriittisenIskunTodennakoisyys todennäköisyys kriittiselle 
     * iskulle lukuna 0-100
     * @param extraVahinko      Aseen iskiessä kriittisesti lisätään vahinkoon tämä
     * 
     */
    
    public Ase(String nimi, int iskuvoima, int kriittisenIskunTodennakoisyys,
            int extraVahinko){
        this.nimi = nimi;
        this.perusVahinko = iskuvoima;
        this.extraVahinko = extraVahinko;
        this.kriittisenIskunTodennakoisyys = kriittisenIskunTodennakoisyys;
        
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    public int getPerusVahinko(){
        return this.perusVahinko;
    }
    
    public int getKritTodNak(){
        return this.kriittisenIskunTodennakoisyys;
    }
    
    public int getExtraVahinko(){
        return this.extraVahinko;
    }
    

    /**
     * metodi arpoo luvun 0 ja 100 väliltä. metodi palauttaa joko true tai
     * false, riippuen onko arvottu numero suurempi vai pienempi kuin 
     * this.kriittisenIskunTodennkoisyys
     * @return palauttaa true jos arvottu luku on pienempi kuin aseen kriittisen 
     * iskun todennäköisyys. Muuten palautuu false.
     */

    public boolean iskeekoKriittisesti(){
        if(random.nextInt(100) 
                < this.kriittisenIskunTodennakoisyys){
            return true;
        } else{
            return false;
        }
    }
    
    /**
     * metodi palauttaa aseen aiheuttaman vahingon tarkistaen käyttäen metodia 
     * iskeekoKriittisesti()
     * @return palauttaa aseen aiheuttaman vahingon. Jos ase iskee kriittisesti,
     * arvotaan mukaan aseen extraVahinko
     */
    public int vahinko(){
        if(iskeekoKriittisesti()){
        return this.perusVahinko + random.nextInt(extraVahinko);
    }else{
            return this.perusVahinko;
        }
    }
    
    @Override
    public String toString(){
        return this.nimi + "(" + this.perusVahinko + ")(%" 
                + this.kriittisenIskunTodennakoisyys + ")(+" 
                + this.extraVahinko + ")"; 
    }
    
}
