
package muistipeli.sovelluslogiikka;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * 
 * @author Anu Nikkanen
 * 
 * Tarkoitus on, että Pelilauta-luokka tarjoaa palveluja x-kokoiselle pelilaudalle.
 * Nyt luokka ei tarjoa vielä muita palveluita kuin ohjeiden palauttamisen -
 * ohjeet voisivat olla myös oma luokkansa, ja erilaisille pelilaudoille voisi
 * mahdollisesti olla jopa oma rajapintansa.
 * 
 */

public class Pelilauta {
    Muistipelikortit kortit;
    String ohjeet;
    
    
    public Pelilauta() {
        this.ohjeet = "<html><p>Tervetuloa pelaamaan hienoa muistipeliäni!<br />"
                + "Voit kääntää kerrallaan kaksi korttia - yritä löytää parit.<br />"
                + "Kun olet löytänyt kaikki parit, peli päättyy.</p></html>";
        
    }
    
    public String annaOhjeet() {
        return this.ohjeet;
    }
    
    
    
}
