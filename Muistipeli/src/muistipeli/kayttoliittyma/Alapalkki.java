
package muistipeli.kayttoliittyma;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

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


public class Alapalkki {
    private JPanel alapalkki;
    private JButton uusipeli1, uusipeli2, uusipeli3, lopeta;
    
    
    /**
     * Luo alapalkin ja siihen sisältyvät napit käyttöliittymään.
     * 
     * @param mainPanel Käyttöliittymän pääpaneli, johon alapalkki lisätään.
     *                  mainPanelilla on GridBag -layout
     */
    public Alapalkki(JPanel mainPanel ) {
        
        this.alapalkki = new JPanel();
        this.alapalkki.setBackground(Color.black);
        
        // luodaan napit ja asetetaan ne klikattaviksi
        this.uusipeli1 = new JButton("Uusi peli 2x2");
        this.uusipeli1.setEnabled(true);
        this.uusipeli1.setFocusPainted(false);
        this.uusipeli2 = new JButton("Uusi peli 4x4");
        this.uusipeli2.setFocusPainted(false);
        this.uusipeli2.setEnabled(true);
        this.uusipeli3 = new JButton("Uusi peli 8x8");
        this.uusipeli3.setEnabled(true);
        this.uusipeli3.setFocusPainted(false);
        this.lopeta = new JButton("Lopeta");
        
        // lisätään napit alapalkkiin
        this.alapalkki.add(this.uusipeli1);
        this.alapalkki.add(this.uusipeli2);
        this.alapalkki.add(this.uusipeli3);
        this.alapalkki.add(this.lopeta);
        
        // Asetetaan alapalkin GridBag-rajoitukset 
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 5;
        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 5;
        c.insets = new Insets(2,2,2,2);
        
        // lisätään alapalkki ja GridBag-rajoitukset mainPaneliin
        mainPanel.add(alapalkki, c);
        
    }
    
    public JButton get2x2() {
        return this.uusipeli1;
    }
    
    public JButton get4x4() {
        return this.uusipeli2;
    }
    
    public JButton get6x6() {
        return this.uusipeli3;
    }
    
    public JButton getLopeta() {
        return this.lopeta;
    }
    
    
}
