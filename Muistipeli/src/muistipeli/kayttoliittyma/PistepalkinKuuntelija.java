
package muistipeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import muistipeli.sovelluslogiikka.Pelitoiminnot;
import muistipeli.sovelluslogiikka.Pistelista;

/**                                                                                                    
 * Luokka vastaa muistipelin käyttöliittymän oikeassa reunassa olevan pistepalkin
 * nappien kuuntelusta ja nappeja vastaavien toimintojen toteuttamisesta.
 * 
 * Nappien avulla käyttäjä voi halutessaan tallentaa omat pisteensä pistelistaan.
 * Luokka implementoi ActionListener -rajapinnan.
 * 
 * @author Anu N.
 */

public class PistepalkinKuuntelija implements ActionListener {
    private Pistepalkki pistepalkki;
    private Pistelista pistelista;
    private Highscorepalkki highscore;
    private Pelitoiminnot pelitoiminnot;
    
    /**
     * Konstruktori asettaa luokan private-muuttujien arvoksi parametrina saadut 
     * arvot, eli kuuntelijan tarvitsemat tiedot muistipelistä ja käyttöliittymästä.
     * 
     * @param pp Pistepalkki -luokan ilmentymä, välittää pistepalkin nappien tiedot
     * @param pistelista Pistelista -luokan ilmentymä, mahdollistaa pisteiden käsittelyn
     * @param hp Highscorepalkki -luokan ilmentymä, välittää tekstikentän pisteiden
     *           tulostamiseen käyttöliittymässä
     * @param pt Pelitoiminnot -luokan ilmentymä, välittää tiedot pelitoiminnoista
     */
    public PistepalkinKuuntelija(Pistepalkki pp, Pistelista pistelista, Highscorepalkki hp, Pelitoiminnot pt) {
        this.pistepalkki = pp;
        this.pistelista = pistelista;
        this.highscore = hp;
        this.pelitoiminnot = pt;
    }
                
    /**
     * Toteuttaa pisteiden tallentamiseen liittyvien Tallenna -ja 
     * OK-nappien toiminnot.
     * 
     * Mikäli klikkauksen lähde on Tallenna-nappi, tulee käyttäjän näkyviin
     * tekstikenttä, johon hän voi kirjoittaa nimimerkkinsä.
     * 
     * Mikäli klikkauksen lähde on Ok-nappi, tallennetaan nimimerkki ja pisteet
     * pistelistaan ja päivitetään top10-lista käyttöliittymässä. Napit ja 
     * tekstikenttä häviää käyttäjän näkyvistä.
     * 
     * @param ae ActionEvent-tapahtuma, eli oikean reunan palkissa olevan napin klikkaus
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        // Jos klikkauksen lähde on Tallenna-nappi
        if (ae.getSource() == this.pistepalkki.getTallennaNappi()) {
           // Asetetaan ok-nappi ja tekstikentät näkyviksi
           this.pistepalkki.getNimim().setVisible(true);
           this.pistepalkki.getAnnaNimim().setVisible(true);
           this.pistepalkki.getOkNappi().setVisible(true);
        }
        // Jos klikkauksen lähde on Ok-nappi
        else if (ae.getSource() == pistepalkki.getOkNappi()) {
           // haetaan tallennetut pisteet listasta 
           this.pistelista.haePisteet();
           // rajataan käyttäjän syöttämän nimimerkin pituus 8 merkkiin
           String nimim = this.pistepalkki.getNimim().getText();
           if (nimim.length() > 7) {
                nimim = nimim.substring(0, 8);
           }
           // lisätään uudet pisteet ja tallennetaan ne pistelistaan
           this.pistelista.lisaaPisteet(nimim, pelitoiminnot.finalScore());
           this.pistelista.tallennaPisteet();
           // palautetaan kentät näkymättömiksi
           this.asetaKentatNakymattomaksi();
           // asetetaan top10-pisteet näkyväksi käyttäjälle
           this.highscore.getHighscorekentta().setVisible(true);
           this.highscore.getHighscorekentta().setText(this.pistelista.tulostaPisteet());       
        }
        
    }
    
    /**
     * Yksityinen metodi asettaa käyttöliittymän oikeassa reunassa olevan palkin 
     * kentät näkymättömäksi käyttäjälle, kun käyttäjän pisteet on tallennettu.
     */
    private void asetaKentatNakymattomaksi() {
           this.pistepalkki.getNimim().setVisible(false);
           this.pistepalkki.getTallennaNappi().setVisible(false);
           this.pistepalkki.getOkNappi().setVisible(false);
           this.pistepalkki.getNimim().setVisible(false);
           this.pistepalkki.getNimim().setText("");
           this.pistepalkki.getAnnaNimim().setVisible(false);
    }
    
     
}
