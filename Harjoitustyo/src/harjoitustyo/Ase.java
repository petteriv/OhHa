/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo;

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
    
    public boolean iskeekoKriittisesti(){
        if(random.nextInt(100) 
                < this.kriittisenIskunTodennakoisyys){
            return true;
        } else{
            return false;
        }
    }
    
    public int vahinko(){
        boolean kritti = iskeekoKriittisesti();
        if(kritti = true){
        return this.perusVahinko + 5 + random.nextInt(extraVahinko);
    }else{
            return this.perusVahinko;
        }
    }
    
}
