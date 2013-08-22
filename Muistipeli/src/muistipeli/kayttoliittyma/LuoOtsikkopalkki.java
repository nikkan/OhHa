
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * LuoOstikkopalkki-luokassa luodaan käyttöliittymään yläkulmaan otsikkopalkki.
 * 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LuoOtsikkopalkki {
  
    private JPanel otsikkopalkki;
    
    public LuoOtsikkopalkki(JPanel main) {
        otsikkopalkki = new JPanel();
        otsikkopalkki.setOpaque(true);
        otsikkopalkki.setBackground(Color.black);
   
        JLabel otsikko = new JLabel("MUISTIPELI");
        Font font = new Font("Arial", Font.BOLD, 18);
        otsikko.setFont(font);
        otsikko.setForeground(Color.white);
        otsikkopalkki.add(otsikko);
        
        // GridBagConstraints //
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 5;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(1,1,1,1);
        c.fill = GridBagConstraints.HORIZONTAL;
        main.add(otsikkopalkki, c);  
    }
    
   
    
}
