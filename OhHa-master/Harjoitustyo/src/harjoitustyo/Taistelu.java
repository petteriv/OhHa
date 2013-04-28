/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo;

import harjoitustyo.Kayttoliittyma.Selostusruutu;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Panssari;

/**
 * Luokka on olio, joka toimii pelissä taistelun simuloijana
 * 
 */
public class Taistelu {
    private Henkilo lyoja;
    private Henkilo torjuja;
    private int vahinko;
    private Selostusruutu selostus;

    
    public Taistelu(){
       
    }
    /**
     * metodi on olion tärkein ominaisuus. Sen avulla pelin henkilöt ottavat 
     * ja aiheuttavat vahinkoa.
     * Vahinko on henkilön ja aseen vahinko, josta on vähennetty puolustavan 
     * Henkilo-olion panssaripisteet
     * 
     * @param selostus selostusruutu annetaan parametrinä metodille, jotta
     * selostusruutu osaa kertoa taistelun kulusta
     * @param lyoja Henkilo-olio joka aiheuttaa vahinkoa
     * @param torjuja Henkilo olio joka ottaa vastaan vahinkoa
     */
    
    public void taistele(Selostusruutu selostus, Henkilo lyoja, Henkilo torjuja){
        this.selostus = selostus;
        this.lyoja = lyoja;
        this.torjuja = torjuja;
        int aseenVahinko = lyoja.getAse().vahinko();
        this.vahinko = lyoja.getVoima() + aseenVahinko - torjuja.getYhteisPanssari();
        if(this.vahinko<0){
            this.vahinko=0;
        }
        torjuja.otaVahinkoa(this.vahinko);
        System.out.println("\n-- " + lyoja.getNimi() + " aiheuttaa " + vahinko 
                + " pistettä vahinkoa aseellaan "
                + lyoja.getAse().getNimi() + " vastustajaan " 
                + torjuja.getNimi() + "! -- \n");
        this.selostus.lisaaTekstia(selosta());
      
    }
    /**
     * metodi palauttaa merkkijonon, jonka selostusruutu näyttää pelaajalle
     * @return 
     */
    
    public String selosta(){
        return "\n-- " + lyoja.getNimi() + " aiheuttaa " + vahinko 
                + " pistettä vahinkoa aseellaan "
                + lyoja.getAse().getNimi() + " vastustajaan " 
                + torjuja.getNimi() + "! -- \n";
    }
    
}
