
package muistipeli.sovelluslogiikka;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * Laskuri on rajapinta, joka antaa 'ohjeet' Laskuri-olion käyttämiselle.
 * Ajatus on, että rajapintaa voi hyödyntää Pistelaskurin lisäksi myös esim.
 * Kierroslaskuri (luokkaa ei vielä olemassa).
 * 
 */

public interface Laskuri {
    public int annaArvo();
    public void kasvataArvoaYhdella(); 
    public void kasvataArvoa(int luku);
   
}
