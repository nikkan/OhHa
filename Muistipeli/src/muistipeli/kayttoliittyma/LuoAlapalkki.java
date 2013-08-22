
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * LuoAlapalkki-luokassa luodaan käyttöliittymän alalaitaan palkki,
 * jossa on pelikentän koon valitseen liittyviä nappeja. Tällä hetkellä
 * kentän koon valinta ei ole kätössä, joten napit eivät ole pelaajan
 * käytettävissä.
 * 
 */

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;


public class LuoAlapalkki {
    private JPanel alapalkki;
    private JButton uusipeli1, uusipeli2, uusipeli3, lopeta;
    
    public LuoAlapalkki(JPanel mainPanel) {
        
        alapalkki = new JPanel();
        uusipeli1 = new JButton("Uusi peli 2x2");
        uusipeli1.setEnabled(false);
        uusipeli2 = new JButton("Uusi peli 4x4");
        uusipeli2.setEnabled(false);
        uusipeli3 = new JButton("Uusi peli 8x8");
        uusipeli3.setEnabled(false);
        
        alapalkki.add(uusipeli1);
        alapalkki.add(uusipeli2);
        alapalkki.add(uusipeli3);
      
        
        // GridBagConstraints 
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 5;
        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 5;
        c.insets = new Insets(2,2,2,2);
        mainPanel.add(alapalkki, c);
        
    }
    
    

}
