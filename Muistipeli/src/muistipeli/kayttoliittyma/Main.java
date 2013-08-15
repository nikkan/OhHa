
package muistipeli.kayttoliittyma;

import javax.swing.SwingUtilities;
import muistipeli.sovelluslogiikka.Muistipelikortit;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * 
 */

        
public class Main {
    public static void main(String[] args) {
        //Muistipelikortit kortit = new Muistipelikortit(3); 
        //System.out.println(kortit.toString());
        Kayttoliittyma kali = new Kayttoliittyma();
        SwingUtilities.invokeLater(kali);
    
    }
}