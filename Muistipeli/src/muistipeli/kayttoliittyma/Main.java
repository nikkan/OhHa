
package muistipeli.kayttoliittyma;

import javax.swing.SwingUtilities;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * VIELÄ HYYYYVIN ALKUVAIHEESSA, LÄHINNÄ OMAA TESTAILUA...
 * 
 * @author Anu Nikkanen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) {
    
        Kayttoliittyma kali = new Kayttoliittyma();
        SwingUtilities.invokeLater(kali);
    }

}
