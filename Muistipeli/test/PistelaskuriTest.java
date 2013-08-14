
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
        assertEquals("laskurin arvo on nyt 0 ja arvausten lkm 0", laskuri.toString());
    }
    
    @Test 
    public void pistelaskuriKasvattaaYhdellaOikein() {
        laskuri.kasvataArvoaYhdella();
        assertEquals("laskurin arvo on nyt 1 ja arvausten lkm 0", laskuri.toString());
    }
    
    @Test
    public void pistelaskuriKasvattaaLaskuriaAnnetuillaPisteilla() {
        laskuri.kasvataArvoa(5);
        assertEquals("laskurin arvo on nyt 5 ja arvausten lkm 0", laskuri.toString());
    }
    
    @Test
    public void annaArvoToimiiOikein() {
        int arvo = laskuri.annaArvo();
        assertEquals(arvo,0);
    }

            
}
