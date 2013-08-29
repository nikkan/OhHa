
import muistipeli.sovelluslogiikka.Ikonikuvat;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Luokka vastaa Ikonikuvat-luokan testaamisesta
 * 
 * @author Anu N.
 */
public class IkonikuvatTest {
    
    Ikonikuvat ikonit;
   
    
    @Test
    public void toimiikoKonstruktoriValidillaArvollaOikein() {
        this.ikonit = new Ikonikuvat(2);
        String vastaus = this.ikonit.toString();
        assertEquals("src/muistipeli/kuvat/ankkuri.gif,"
                + "src/muistipeli/kuvat/ankkuri.gif,"
                + "src/muistipeli/kuvat/lintuhakki.gif,"
                + "src/muistipeli/kuvat/lintuhakki.gif,", vastaus);
    }
    
    @Test
    public void toimiikoKonstruktoriOikeinKunKuviaEiOle() {
        this.ikonit = new Ikonikuvat(8);
        String vastaus = this.ikonit.toString();
        assertEquals("0,0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,"
                + "11,11,12,12,13,13,14,14,15,15,16,16,17,17,18,18,19,19,"
                + "20,20,21,21,22,22,23,23,24,24,25,25,26,26,27,27,28,28,"
                + "29,29,30,30,31,31,32,32,33,33,34,34,35,35,", vastaus);
        
    }
  
    
}
