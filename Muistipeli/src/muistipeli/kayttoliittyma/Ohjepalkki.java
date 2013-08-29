
package muistipeli.kayttoliittyma;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Ohjepalkki-luokka vastaa ohjepalkin luomisesta Muistipelin graafiseen
 * käyttöliittymään.
 * 
 * @author Anu N.  
 */

public class Ohjepalkki {
    
    private JPanel ohjepalkki;
    
    /**
     * Kontruktori luo ohjepalkin ja siihen sisältyvän tekstikentän ohjeineen.
     * 
     * @param mainPanel 
     */
    public Ohjepalkki(JPanel mainPanel) {
        // Luodaan ohjepalkki ja laitetaan sille asetukset
        this.ohjepalkki = new JPanel();
        this.ohjepalkki.setMinimumSize(new Dimension(150, 150));
        this.ohjepalkki.setPreferredSize(new Dimension(150, 150));
        
        // Luodaan JLabel, jolle annetaan parametrina Muistipelin ohjeteksti
        JLabel ohjeet = new JLabel( "<html><p><br />Tervetuloa pelaamaan muistipeliä!<br /><br />"
                + "Voit kääntää kerrallaan kaksi korttia - yritä löytää parit.<br />"
                + "Mikäli et löydä paria, kortit kääntyvät <br />"
                + "nurin päin kun klikkaat seuraavaa korttia.<br />"
                + "Kun olet löytänyt kaikki parit, peli <br />"
                + "päättyy ja voit tallentaa loppupisteesi.</p></html>" );
        
        // Lisätään ohjeet ohjepalkkiin
        this.ohjepalkki.add(ohjeet);
       
        // Asetetaan GridBag-rajoitukset 
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(2,2,2,2);
        
        // Lisätään ohjepalkki mainPaneliin
        mainPanel.add(this.ohjepalkki, c);
    }
}
