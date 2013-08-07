
package muistipeli.kayttoliittyma;

import javax.swing.SwingUtilities;
//import muistipeli.sovelluslogiikka.Muistipelikortit;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * KESKEN VIELÄ. EI PISTEIDEN LASKUA YMS. TOIMINNASSA + FIKSATTU KENTÄN
 * KOKO YMS.
 * 
 * 
 * @author Anu Nikkanen
 */

        
public class Main {
    public static void main(String[] args) {
        //Muistipelikortit peli = new Muistipelikortit();    
        Kayttoliittyma kali = new Kayttoliittyma();
        SwingUtilities.invokeLater(kali);
        
    }
}