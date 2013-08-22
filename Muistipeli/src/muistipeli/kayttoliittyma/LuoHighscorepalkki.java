
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * LuoHighScore-luokassa luodaan käyttöliittymään oikeaan alakulmaan
 * palkki, johon tulostetaan voimassa oleva highscore.
 * 
 */

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import muistipeli.sovelluslogiikka.Pistelista;


public class LuoHighscorepalkki {
    
    private JPanel highscorepalkki;
    private JLabel highscoreotsikko;
    private JLabel highscore, highscore2;
    private Pistelista lista;
    
    public LuoHighscorepalkki(JPanel mainPanel, Pistelista lista) {
        
        this.lista = lista;
        
        this.highscorepalkki = new JPanel(new GridLayout(2,1));
        this.highscorepalkki.setOpaque(true);
        this.highscorepalkki.setBackground(Color.pink);
        
        this.highscoreotsikko = new JLabel("TOP SCORE");
        this.highscorepalkki.add(this.highscoreotsikko);
        
        this.highscore = new JLabel(this.lista.tulostaHighscore());
        this.highscorepalkki.add(this.highscore);
        
        this.highscore2 = new JLabel("");
        this.highscorepalkki.add(this.highscore2);
        
        // GridBagConstraints
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 2;
        c.gridheight = 2;
        c.insets = new Insets(2,0,0,0);
        c.fill = GridBagConstraints.BOTH;
        
        mainPanel.add(this.highscorepalkki, c);
        
    }
    
    /* Metodi palauttaa JLabel-kentän, johon highscore tulostetaan. */
    public JLabel getHighscorekentta() {
        return this.highscore;
    }
}
