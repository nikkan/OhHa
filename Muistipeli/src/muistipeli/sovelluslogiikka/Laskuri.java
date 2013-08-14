
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
    public void asetaArvo(int luku);
    public void nollaa();
    public int haeArvo();
    public void kasvataArvoa(); 
    public void kasvataArvoa(int luku);
    
   
}
