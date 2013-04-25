package HenkiloTestit;

import harjoitustyo.hahmoJaVarusteet.Ase;
import harjoitustyo.hahmoJaVarusteet.Henkilo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AseenJaPanssarinLuontiTest {
    Ase testiAse;  
    @Before
    public void setUp() {
         
        }
    
    
    @Test
    public void aseenLuontiOnnistuu(){
        testiAse = new Ase("testiase", 10,5,5);
        
        assertEquals("testiase(10)(%5)(+5)",testiAse.toString() );
    }    
  


}
