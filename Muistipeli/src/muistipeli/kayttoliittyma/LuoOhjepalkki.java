
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * LuoOhjepalkki-luokassa luodaan käyttöliittymään yläosaan palkki,
 * johon lisätään tulostetaan ohjeet.
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LuoOhjepalkki {
    
    private JPanel ohjepalkki;
    
    public LuoOhjepalkki(JPanel main) {
        
        ohjepalkki = new JPanel();
        ohjepalkki.setMinimumSize(new Dimension(150, 150));
        ohjepalkki.setPreferredSize(new Dimension(150, 150));
        JLabel ohjeet = new JLabel( "<html><p><br />Tervetuloa pelaamaan muistipeliä!<br /><br />"
                + "Voit kääntää kerrallaan kaksi korttia - yritä löytää parit.<br />"
                + "Mikäli et löydä paria, kortit kääntyvät <br />"
                + "nurin päin kun klikkaat seuraavaa korttia.<br />"
                + "Kun olet löytänyt kaikki parit, peli <br />"
                + "päättyy ja voit tallentaa loppupisteesi.</p></html>" );
        ohjepalkki.add(ohjeet);
       
        // GridBagConstraints 
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(2,2,2,2);
        
        main.add(ohjepalkki, c);
    }
}
