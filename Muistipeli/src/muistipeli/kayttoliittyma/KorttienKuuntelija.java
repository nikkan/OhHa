
package muistipeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import muistipeli.sovelluslogiikka.Kortti;
import muistipeli.sovelluslogiikka.Pelitoiminnot;

/**
 * Kuuntelee muistipelikortteja ja toteuttaa muistipelikorttien klikkaamiseen
 * liittyvät toiminnot.
 * 
 * @author Anu Nikkanen
 */
public class KorttienKuuntelija implements ActionListener {
    private Pelitoiminnot pt;
    private Pelikentta pk;

    
    /**
     * Konstruktori, joka saa parametrinaan käyttöliittymässä luodun
     * pelitoiminnot-olion ja pelikenttä-olion eli tiedon muistipelikorteista.
     * 
     * @param pt Pelitoiminnot -luokan ilmentymä
     * @param pk Pelikenttä -luokan ilmentymä
     */
    public KorttienKuuntelija(Pelitoiminnot pt, Pelikentta pk) {  
        this.pt = pt;
        this.pk = pk;
    }
    
    /**
     * Suorittaa muistipelin kierrokseen liittyvät toiminnot, mikäli
     * lähde on jokin muistipelikorteista.
     * 
     * @param ae ActionEvent -tapahtuma, eli muistipelikortin klikkaaminen
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        for (Kortti k : this.pk.getKorttilista2()) {
            if (ae.getSource() == k) {
                this.pt.pelikierros(k);
            }
        }
        
    }   
    
        
}
