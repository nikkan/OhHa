
import muistipeli.sovelluslogiikka.Pelaaja;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 */
public class PelaajaTest {
    
    Pelaaja pelaaja;
   
    
    @Before
    public void setUp() {
        this.pelaaja = new Pelaaja("Testi", 10);
    }
    
    @Test
    public void konstruktoriAsettaaNimenJaIanOikein() {
        String vastaus = this.pelaaja.toString();
        assertEquals("Testi:10\n", vastaus);
    }
    
    @Test
    public void pelaajanNimiHaetaanOikein() {
        String nimi = this.pelaaja.getNimi();
        assertEquals("Testi", nimi);
    }
    
    @Test
    public void pelaajanPisteetHaetaanOikein() {
        int pisteet = this.pelaaja.getPisteet();
        assertEquals(10, pisteet);
    }
    
    @Test
    public void compareToPalauttaaOikeanJarjestyksenA() {
        Pelaaja pA = new Pelaaja("Vertailu", 5);
        int jarjestys = this.pelaaja.compareTo(pA);
        assertEquals(-1, jarjestys);
    }
    
    @Test
    public void compareToPalauttaaOikeanJarjestyksenB() {
        Pelaaja pB = new Pelaaja("Vertailu", 20);
        int jarjestys = this.pelaaja.compareTo(pB);
        assertEquals(1, jarjestys);
    }
    
    @Test
    public void compareToPalauttaaOikeanJarjestyksenC() {
        Pelaaja pC = new Pelaaja("Kokeilu", 10);
        int jarjestys = this.pelaaja.compareTo(pC);
        assertEquals(1, jarjestys);
    }
    
    @Test
    public void compareToPalauttaaOikeanJarjestyksenD() {
        Pelaaja pD = new Pelaaja("Testi", 10);
        int jarjestys = this.pelaaja.compareTo(pD);
        assertEquals(0, jarjestys);
    }
}
