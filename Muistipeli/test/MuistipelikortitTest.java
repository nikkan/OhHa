
import muistipeli.sovelluslogiikka.Muistipelikortit;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 */
public class MuistipelikortitTest {
    
    Muistipelikortit kortit;
    
    /*@Before
    public void setUp() {
        this.kortit = new Muistipelikortit(3);
    }*/
    
    @Test
    public void toimiikoKonstruktoriValidillaArvollaOikein() {
        this.kortit = new Muistipelikortit(3);
        String vastaus = this.kortit.toString();
        assertEquals("src/muistipeli/kuvat/ikoni2.gif,"
                + "src/muistipeli/kuvat/ikoni2.gif,"
                + "src/muistipeli/kuvat/ikoni3.gif,"
                + "src/muistipeli/kuvat/ikoni3.gif,"
                + "src/muistipeli/kuvat/ikoni4.gif,"
                + "src/muistipeli/kuvat/ikoni4.gif,", vastaus);
    }
    
    @Test
    public void huomaakoSyotteenKoonTarkistajaVirheellisenKoon() {
        this.kortit = new Muistipelikortit(3);
        boolean tarkista = this.kortit.tarkistaKoko(2);
        assertEquals(false, tarkista);
    }
    
    @Test
    public void toimiikoSyotteenKoonTarkistajaOikeinValidillaArvolla() {
        this.kortit = new Muistipelikortit(3);
        boolean tarkista = this.kortit.tarkistaKoko(3);
        assertEquals(true, tarkista);
    }
    
    @Test
    public void lisaaIkoniToimiiOikein() {
        this.kortit = new Muistipelikortit();
        this.kortit.lisaaIkoni("Testi");
        String ikoni = this.kortit.toString();
        assertEquals("Testi,", ikoni);
    }
    
    
    
}
