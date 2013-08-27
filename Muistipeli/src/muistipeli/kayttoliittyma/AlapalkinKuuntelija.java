
package muistipeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import muistipeli.sovelluslogiikka.Kortti;
import muistipeli.sovelluslogiikka.Pelitoiminnot;

/**                                                                                                    
 * Luokka vastaa muistipelin käyttöliittymän alapalkissa olevien valintanappien 
 * kuuntelusta ja nappeja vastaavien toimintojen toteuttamisesta.
 * 
 * Nappien avulla käyttäjä voi valita uuden pelin 2x2, 4x4 tai 6x6 -kokoisella
 * muistipelikentällä tai lopettaa pelaamisen. 
 * 
 * @author Anu Nikkanen
 */

public class AlapalkinKuuntelija implements ActionListener {
    private Pelikentta pelikentta;
    private Alapalkki alapalkki;
    private KorttienKuuntelija klikkaustenkuuntelija;
    private Pelitoiminnot pelitoiminnot;
 
    /**
     * Asettaa luokan private-muuttujien arvoksi parametrina saadut arvot, eli
     * kuuntelijan tarvitsemat tiedot muistipelistä ja käyttöliittymästä.
     * 
     * @param pt Pelitoiminnot -luokan ilmentymä, sis. muistipelin pelitoiminnot
     * @param pk Pelikentta -luokan ilmentymä, sis. tiedot muistipelin pelikentästä
     * @param ap Alapalkki -luokan ilmentymä, sis. tiedot käyttöliittymän alapalkista
     *           ja siihen sisältyvistä napeista
     * @param kk Muistipelikorttien (eli JButtonien) kuuntelija
     */
    public AlapalkinKuuntelija(Pelitoiminnot pt, Pelikentta pk, Alapalkki ap, KorttienKuuntelija kk) {
        this.pelikentta = pk;
        this.alapalkki = ap;
        this.klikkaustenkuuntelija = kk;
        this.pelitoiminnot = pt;
    }
    
    /**
     * Toteuttaa muistipelin käyttöliittymän alapalkissa sijaitseviin nappeihin 
     * liittyvät toiminnot.
     * 
     * Mikäli klikkauksen lähde on jokin kolmesta ensimmäisestä napista, kutsutaan
     * luokan yksityistä uusiPeli()-metodia, joka käynnistää uuden halutun kokoisen
     * muistipelin. 
     * 
     * Mikäli klikkauksen lähde on lopeta-nappi, ohjelma suljetaan.
     * 
     * @param ae ActionEvent-tapahtuma, eli alapalkissa olevan napin klikkaus
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == alapalkki.get2x2()) {
            uusiPeli(2);
        }
        else if (ae.getSource() == alapalkki.get4x4()) {
            uusiPeli(4);
        }
        else if (ae.getSource() == alapalkki.get6x6()) {
            uusiPeli(6);
        }
        else if (ae.getSource() == alapalkki.getLopeta()) {
            System.exit(0);
        }
        
    }
    
    /**
     * Luo uuden halutun kokoisen muistipelin.
     * 
     * Vanha pelikenttä poistetaan ja tilalle luodaan uusi halutun kokoinen
     * pelikenttä. Uusiin kortteihin lisätään klikkaustenKuuntelija.
     * Vanhat pelitoiminnot nollataan.
     * 
     * @param koko Kokonaisluku, joka kertoo halutun muistipelikentän koon
     */
    private void uusiPeli(int koko) {
            // poistetaan vanhat kortit pelikentältä
            this.pelikentta.getPelikentta().removeAll();
            this.pelikentta.getPelikentta().validate();
            
            // haetaan uusi pelikenttä
            this.pelikentta.getPelikentta().add(pelikentta.getUusiPeli(koko));
            
            // lisätään uusille korteille klikkaustenKuuntelija
            for (Kortti k : this.pelikentta.getKorttilista2() ) {
            k.addActionListener(this.klikkaustenkuuntelija);
            }
            
            // nollataan vanhat pelitoiminnot
            this.pelitoiminnot.nollaaKaikki();
            
            // piirretään ja validoidaan uusi pelikenttä
            this.pelikentta.getPelikentta().repaint();
            this.pelikentta.getPelikentta().validate();
        
    }
    
}
