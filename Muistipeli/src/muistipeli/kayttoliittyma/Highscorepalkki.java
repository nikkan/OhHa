
package muistipeli.kayttoliittyma;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import muistipeli.sovelluslogiikka.Pistelista;

/**
 * Highscorepalkki-luokka vastaa highscorepalkin luomisesta ja lisäämisestä
 * graafiseen käyttöliittymään. 
 * 
 * Palkkiin tulostetaan kulloinkin voimassa oleva TOP10-pistelistaus. 
 * 
 * @author Anu N.
 */

public class Highscorepalkki {
    
    private JPanel highscorepalkki;
    private JLabel highscore;
    private Pistelista lista;
    
    /**
     * Konstruktori luo highscorepalkin ja lisää sen käyttöliittymään.
     * 
     * @param mainPanel Käyttöliittymän pääpaneli, johon alapalkki lisätään.
     * @param pistelista Pistelista-luokan ilmentymä, välittää tiedot pisteistä
     *                 
     */
    public Highscorepalkki(JPanel mainPanel, Pistelista lista) {
        this.lista = lista;
        // luodaan highscorepalkki ja asetetaan sen asetukset
        this.highscorepalkki = new JPanel();
        this.highscorepalkki.setOpaque(true);
        this.highscorepalkki.setBackground(Color.PINK);
        
        // haetaan top10-listaus ja asetetaan se highscorepalkkiin lisättävään
        // tekstikenttään
        this.lista.haePisteet();
        this.highscore = new JLabel();
        this.highscore.setText(this.lista.tulostaPisteet());
        this.highscorepalkki.add(this.highscore);
      
        // Asetetaan GridBag-rajoitukset
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 2;
        c.gridheight = 2;
        c.insets = new Insets(2,0,0,0);
        c.fill = GridBagConstraints.BOTH;
        
        // lisätään highscorepalkki pääpaneliin
        mainPanel.add(this.highscorepalkki, c);
        
    }
    
    public JLabel getHighscorekentta() {
        return this.highscore;
    }
}
