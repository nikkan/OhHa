
package muistipeli.kayttoliittyma;

import javax.swing.SwingUtilities;
import muistipeli.sovelluslogiikka.Muistipelikortit;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * VIELÄ HYYYYVIN ALKUVAIHEESSA, LÄHINNÄ OMAA TESTAILUA...
 * 
 * @author Anu Nikkanen
 */

        
public class Main {
    public static void main(String[] args) {
   
        Muistipelikortit peli = new Muistipelikortit();    
        Kayttoliittyma kali = new Kayttoliittyma(peli);
        SwingUtilities.invokeLater(kali);
        
    }
}