
package muistipeli.kayttoliittyma;

import javax.swing.SwingUtilities;

/**
 * Luokka vastaa Muistipelin käynnistämisestä.
 * 
 * Ohjelmoinnin harjoitustyö, loppukesa 2013.
 * 
 * @author Anu N.
 */
  
public class Main {
    /**
     * Pääohjelmametodi luo käyttöliittymäolion ja käynnistää muistipelin.
     */
    public static void main(String[] args) {
        // Luodaan uusi käyttöliittymäolio
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        // Käynnistetään käyttöliittymä
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}