
import muistipeli.sovelluslogiikka.Kortti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Luokka vastaa Kortti-luokan konstruktorin testaamisesta tapauksessa, jossa
 * kortin kuvapuolena on 'numero' (String-muodossa).
 * 
 * @author Anu N.
 */
public class KorttiTest {
    
    Kortti kortti;
    
    public KorttiTest() {
    }
    
    @Before
    public void setUp() {
        this.kortti = new Kortti("5");
    }
   
    @Test
    public void kontruktoriAsettaaKortinOikeanPuolenOikein() {
        String kuvapuoli = this.kortti.getKuvapuoli();
        assertEquals("5", kuvapuoli);
    }
    
    @Test
    public void kontruktoriAsettaaKortinNurjanPuolenOikein() {
        String nurjapuoli = this.kortti.getNurjapuoli();
        assertEquals("?", nurjapuoli);
    }
    
  
    
}
