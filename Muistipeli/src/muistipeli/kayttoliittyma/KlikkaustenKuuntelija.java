
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * KlikkaustenKuuntelija toteuttaa kuhunkin JButtoniin (esim. muistipelikortit)
 * liittyvät toiminnot.
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import muistipeli.sovelluslogiikka.Pelitoiminnot;


public class KlikkaustenKuuntelija implements ActionListener {
    private Pelitoiminnot pt;

    // Metodi suorittaa muistipelin pelikierroksen toiminnot.  
    public KlikkaustenKuuntelija(HashMap<JButton, String> napit, JLabel alapalkki) { 
        this.pt = new Pelitoiminnot(napit, alapalkki);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.pt.pelikierros(ae);
    }
}
