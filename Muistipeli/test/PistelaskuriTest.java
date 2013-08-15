
import muistipeli.sovelluslogiikka.Pistelaskuri;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * 
 * @author Anu Nikkanen
 */

public class PistelaskuriTest {
    
    Pistelaskuri laskuri;
    
    @Before
    public void setUp() {
        laskuri = new Pistelaskuri();
    }

    @Test
    public void konstruktoriAsettaaLaskurinAlkutilaan() {
        assertEquals("laskurin arvo on nyt 0", laskuri.toString());
    }
    
    @Test 
    public void pistelaskuriKasvattaaYhdellaOikein() {
        laskuri.kasvataArvoaYhdella();
        assertEquals("laskurin arvo on nyt 1", laskuri.toString());
    }
    
    @Test
    public void pistelaskuriKasvattaaLaskuriaAnnetunArvausLkmHuomioiden() {
        laskuri.kasvataArvoa(6);
        assertEquals("laskurin arvo on nyt 4", laskuri.toString());
    }
    
    @Test
    public void annaArvoHakeeOikeanArvon() {
        int arvo = laskuri.annaArvo();
        assertEquals(0,arvo);
    }
    
    @Test
    public void annaArvaustenLkmHakeeOikeanLkm() {
        int arvaukset = laskuri.annaArvaustenLkm();
        assertEquals(0, arvaukset);
    }

            
}
