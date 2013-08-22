
import muistipeli.sovelluslogiikka.Muistipelikortit;
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
        this.kortit = new Muistipelikortit(2);
        String vastaus = this.kortit.toString();
        assertEquals("src/muistipeli/kuvat/omppu.gif,"
                + "src/muistipeli/kuvat/omppu.gif,"
                + "src/muistipeli/kuvat/lasit.gif,"
                + "src/muistipeli/kuvat/lasit.gif,", vastaus);
    }
    
    @Test
    public void huomaakoSyotteenKoonTarkistajaVirheellisenKoon() {
        this.kortit = new Muistipelikortit(2);
        boolean tarkista = this.kortit.tarkistaKoko(3);
        assertEquals(false, tarkista);
    }
    
    @Test
    public void toimiikoSyotteenKoonTarkistajaOikeinValidillaArvolla() {
        this.kortit = new Muistipelikortit(2);
        boolean tarkista = this.kortit.tarkistaKoko(2);
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
