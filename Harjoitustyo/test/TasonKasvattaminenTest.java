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
public class TasonKasvattaminenTest {
    Henkilo testiHenkilo;
    
    public TasonKasvattaminenTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testiHenkilo = new Henkilo("Testihenkilo");
        testiHenkilo.tasoKasvaa();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tasonKasvattaminenKasvattaaTasoa(){
        
        assertEquals(2, testiHenkilo.getTaso() );
    }
    
    @Test
    public void tasonKasvattaminenKasvattaaHPtaOikein(){
        assertEquals(120, testiHenkilo.getHP());
    }
    
    @Test
    public void tasonKasvattaminenKasvattaaVoimaa(){
        assertEquals(25, testiHenkilo.getVoima());
    }
}
