
import muistipeli.sovelluslogiikka.Pelilauta;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * 
 * @author Anu Nikkanen
 */

public class PelilautaTest {
    
    Pelilauta pelilauta;
    
    @Before
    public void setUp() {
        pelilauta = new Pelilauta();
    }
    
    @Test
    public void annaOhjeetMetodiPalauttaaOhjeet() {
        String vastaus = pelilauta.annaOhjeet();
        assertEquals("<html><p>Tervetuloa pelaamaan hienoa muistipeliäni!<br />"
                + "Voit kääntää kerrallaan kaksi korttia - yritä löytää parit.<br />"
                + "Kun olet löytänyt kaikki parit, peli päättyy.</p></html>", vastaus);
       
    }
}
