/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import harjoitustyo.Henkilo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author petteriv
 */
public class HenkilotiedotTest {
    Henkilo testiHenkilo;
    
    public HenkilotiedotTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testiHenkilo = new Henkilo("");
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void henkilonNimiEiVoiOllaTyhja(){
        assertEquals("default", testiHenkilo.getNimi());
    }
    
    @Test
    public void konstruktoriLaittaaHPnOikein(){
        assertEquals( 100, testiHenkilo.getHP() );
    }
    
    @Test
    public void lisaVoimaEiVoiOllaNegatiivinen(){
        testiHenkilo.lisaaVoimaa( -10 );
        assertEquals( 20, testiHenkilo.getVoima() );
    }
    
    @Test
    public void lisaaHPEiLisaaYliMaksimiHPn(){
        testiHenkilo.lisaaHP(300);
        assertEquals( 100, testiHenkilo.getHP());
    }
    
    @Test
    public void lisaaHPLisaaHPnMaksimiin(){
        testiHenkilo.otaVahinkoa(30);
        testiHenkilo.lisaaHP(100);
        assertEquals( 100, testiHenkilo.getHP());
    }
    
    @Test
    public void vahingonOttaminenVahentaaHP(){
        testiHenkilo.otaVahinkoa(30);
        assertEquals( 70, testiHenkilo.getHP());
    }
    
    @Test
    public void tarpeeksiVahinkoaNiinElavaOnFalse(){
        testiHenkilo.otaVahinkoa(150);
        assertEquals( false, testiHenkilo.tarkistaKuolema());
    }
    
    @Test
    public void tasonKasvattaminenToimii(){
        testiHenkilo.tasoKasvaa();
        assertEquals(" default \n" + 
                     " taso: 2\n" + 
                     " HP: 120/120\n" +
                     " panssari: 10\n" +
                     " voima: 25", testiHenkilo.toString() );
    }
    
}
