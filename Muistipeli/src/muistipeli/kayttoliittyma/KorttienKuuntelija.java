
package muistipeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import muistipeli.sovelluslogiikka.Kortti;
import muistipeli.sovelluslogiikka.Pelitoiminnot;

/**
 * Vastaa muistipelikorttien kuuntelusta ja toteuttaa korttien (JButtoneita)
 * klikkaamiseen liittyvät toiminnot.
 * 
 * Luokka implementoi ActionListener -rajapinnan.
 * 
 * @author Anu N.
 */

public class KorttienKuuntelija implements ActionListener {
    private Pelitoiminnot pt;
    private Pelikentta pk;

    /**
     * Konstruktori saa parametrinaan käyttöliittymässä luodun
     * Pelitoiminnot-olion ja Pelikentta-olion, eli tiedon muistipelikorteista.
     * 
     * @param pt Pelitoiminnot -luokan ilmentymä
     * @param pk Pelikenttä -luokan ilmentymä
     */
    public KorttienKuuntelija(Pelitoiminnot pt, Pelikentta pk) {  
        this.pt = pt;
        this.pk = pk;
    }
    
    /**
     * Suorittaa muistipelin kierrokseen liittyvät toiminnot, mikäli toiminnon
     * lähde on jokin muistipelikorteista.
     * 
     * @param ae ActionEvent -tapahtuma, eli muistipelikortin klikkaaminen
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        for (Kortti k : this.pk.getKorttilista()) {
            if (ae.getSource() == k) {
                this.pt.pelikierros(k);
            }
        }
        
    }   
    
}
