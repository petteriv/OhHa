import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class aseenLuontiTest {
    Ase testiAse;  
    @Before
    public void setUp() {
         
        }
    
    
    @Test
    public void aseenLuontiOnnistuu(){
        testiAse = new Ase("testiase", 10,5,5);
        
        assertEquals("testiase(10)(5%)(+5)",testiAse.toString() );
    }
    
    @Test
    public void tyhjaNimiJaLuontiOnnistuu(){
        testiAse = new Ase("", 10,6,6);
        assertEquals("risu", testiAse.getNimi());
    }
    
    @Test
    public void negatiivistaArvoaEiVoiLaittaa(){
        testiAse = new Ase("tesmi", -10, -10, -10);
        assertEquals(0, testiAse.getPerusVahinko()
                +testiAse.getKritTodNak()
                +testiAse.getExtraVahinko());     
    }
}
