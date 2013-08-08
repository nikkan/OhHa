
import muistipeli.sovelluslogiikka.Muistipelikortit;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * 
 * @author Anu Nikkanen
 */
public class MuistipelikortitTest {
    
    Muistipelikortit kortit;
    
    @Before
    public void setUp() {
        this.kortit = new Muistipelikortit(3);
    }
    
    @Test
    public void toimiikoKonstruktoriValidillaArvollaOikein() {
        String vastaus = this.kortit.toString();
        assertEquals("placeholder,placeholder,placeholder,", vastaus);
    }
    
    @Test
    public void huomaakoSyotteenKoonTarkistajaVirheellisenKoon() {
        boolean tarkiste = this.kortit.tarkistaKoko(2);
        assertEquals(false, tarkiste);
    }
    
    @Test
    public void toimiikoSyotteenKoonTarkistajaOikeinValidillaArvolla() {
        boolean tarkista = this.kortit.tarkistaKoko(3);
        assertEquals(true, tarkista);
    }
    
    @Test
    public void sekoitaKortitEiTeeYlimaaraisiaMuutoksiaTaulukkoon() {
        this.kortit.sekoitaKortit();
        assertEquals("placeholder,placeholder,placeholder,", this.kortit.toString());
        
    }
    
    
    
}
