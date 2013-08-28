
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
  
    
    
    
}
