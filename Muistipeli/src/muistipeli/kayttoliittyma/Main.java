
package muistipeli.kayttoliittyma;

import javax.swing.SwingUtilities;
import muistipeli.sovelluslogiikka.Muistipelikortit;
import muistipeli.sovelluslogiikka.Pistelista;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * 
 */

        
public class Main {
    public static void main(String[] args) {
        //Muistipelikortit kortit = new Muistipelikortit(4); 
        //System.out.println(kortit.getKaantopuoli());
        //System.out.println(kortit.annaIkonit().toString());
        Kayttoliittyma kali = new Kayttoliittyma();
        SwingUtilities.invokeLater(kali);
       // Pistelista l = new Pistelista("src/muistipeli/testaus.txt");
       // l.tallennaPisteet();
       // l.lisaaPisteet("testi", 10);
        //l.lisaaPisteet("testi2", 5);
        //System.out.println(l.tulostaHighscore());
        //l.tallennaPisteet();
       
        //l.haePisteet();
        //System.out.println(l.toString());
        //System.out.println(l.tulostaPisteet());
        //*/
        
        
    
    }
}