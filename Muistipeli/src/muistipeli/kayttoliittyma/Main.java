
package muistipeli.kayttoliittyma;

import javax.swing.SwingUtilities;
import muistipeli.sovelluslogiikka.Muistipelikortit;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * 
 * @author Anu Nikkanen
 * 
 * 
 */

        
public class Main {
    public static void main(String[] args) {
        Muistipelikortit kortit = new Muistipelikortit();    
        Kayttoliittyma kali = new Kayttoliittyma(kortit);
        SwingUtilities.invokeLater(kali);
    
    }
}