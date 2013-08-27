
package muistipeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import muistipeli.sovelluslogiikka.Pelitoiminnot;
import muistipeli.sovelluslogiikka.Pistelista;

/**                                                                                                    
 * Luokka vastaa muistipelin käyttöliittymän oikeassa reunassa olevan palkin
 * nappien kuuntelusta ja nappeja vastaavien toimintojen toteuttamisesta.
 * 
 * Nappien avulla käyttäjä voi halutessaan tallentaa omat pisteensä pistelistaan.
 * 
 * @author Anu Nikkanen
 */

public class PistepalkinKuuntelija implements ActionListener {
    private Pistepalkki pistepalkki;
    private Pistelista pistelista;
    private Highscorepalkki highscore;
    private Pelitoiminnot pelitoiminnot;
    
    
    /**
     * Asettaa luokan private-muuttujien arvoksi parametrina saadut arvot, eli
     * kuuntelijan tarvitsemat tiedot muistipelistä ja käyttöliittymästä.
     * 
     * @param pp Pistepalkki -luokan ilmentymä, sis. pistepalkin nappien tiedot
     * @param pistelista Pistelista -luokan ilmentymä pisteiden käsittelyyn
     * @param hp Highscorepalkki -luokan ilmentymä, sis. tekstikentän pisteiden
     *           tulostamiseen käyttöliittymässä
     * @param pt Pelitoiminnot -luokan ilmentymä
     */
    public PistepalkinKuuntelija(Pistepalkki pp, Pistelista pistelista, Highscorepalkki hp, Pelitoiminnot pt) {
        this.pistepalkki = pp;
        this.pistelista = pistelista;
        this.highscore = hp;
        this.pelitoiminnot = pt;
    }
                
    /**
     * Toteuttaa muistipelin käyttöliittymän oikeassa yläreunassa sijaitseviin  
     * nappeihin liittyvät toiminnot.
     * 
     * Mikäli klikkauksen lähde on Tallenna-nappi, tulee käyttäjän näkyviin
     * tekstikenttä, johon hän voi kirjoittaa nimimerkkinsä.
     * 
     * Mikäli klikkauksen lähde on Ok-nappi, tallennetaan nimimerkki ja pisteet
     * pistelistaan ja päivitetään top10-lista käyttöliittymässä.
     * 
     * @param ae ActionEvent-tapahtuma, eli oikean reunan palkissa olevan napin klikkaus
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
       if (ae.getSource() == this.pistepalkki.getTallennaNappi()) {
            // asetetaan käyttöliittymäkomponentit nähtäväksi
           this.pistepalkki.getNimim().setVisible(true);
           this.pistepalkki.getAnnaNimim().setVisible(true);
           this.pistepalkki.getOkNappi().setVisible(true);
        }
        else if (ae.getSource() == pistepalkki.getOkNappi()) {
           // haetaan tallennetut pisteet listasta ja lisätään ja tallennetaan uudet pisteet
           this.pistelista.haePisteet();
           // rajataan nimimerkin pituus 8 merkkiin
           String nimim = this.pistepalkki.getNimim().getText();
           if (nimim.length() > 7) {
                nimim = nimim.substring(0, 8);
           }
           this.pistelista.lisaaPisteet(nimim, pelitoiminnot.finalScore());
           this.pistelista.tallennaPisteet();
           this.asetaKentatNakymattomaksi();
           
           // asetetaan top10-pisteet näkyväksi käyttäjälle
           this.highscore.getHighscorekentta().setVisible(true);
           this.highscore.getHighscorekentta().setText(this.pistelista.tulostaPisteet());       
        }
        
    }
    
    /**
     * Asettaa käyttöliittymän oikeassa reunassa olevan palkin kentät 
     * näkymättömäksi käyttäjälle, kun käyttäjän pisteet on tallennettu.
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
