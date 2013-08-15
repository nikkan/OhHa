
import muistipeli.sovelluslogiikka.Pistelista;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Ohjelmoinnin harjoitustyo, syksy 2013
 * 
 * @author Anu Nikkanen
 * 
 */
public class PistelistaTest {
    
    Pistelista lista;
    
    public PistelistaTest() {
    }
   
    @Before
    public void setUp() {
        this.lista = new Pistelista("src/muistipeli/testaus.txt");
    }
    
    @Test
    public void pisteidenLisaysToimii() {
        this.lista.lisaaPisteet("Testi", 10);
        String vastaus = this.lista.toString();
        assertEquals("Testi:10\n,", vastaus);
        
    }
    
    @Test
    public void tulostaPisteetPalauttaaPisteet() {
        this.lista.lisaaPisteet("Testi", 10);
        String pisteet = this.lista.tulostaPisteet();
        assertEquals("Testi:10\n", pisteet);
    }
    
    @Test
    public void tallennaPisteetTallentaaPisteetTiedostoonJaHakuToimii() {
        this.lista.lisaaPisteet("Testi", 10);
        this.lista.tallennaPisteet();
        this.lista.lisaaPisteet("Testi2", 5);
        this.lista.haePisteet();
        String pisteet = this.lista.tulostaPisteet();
        assertEquals("Testi:10\n", pisteet);
    }
    
    
    
}
