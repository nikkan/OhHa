
package muistipeli.sovelluslogiikka;

import muistipeli.kayttoliittyma.Pelikentta;
import muistipeli.kayttoliittyma.Pistepalkki;

/**
 * Pelitoiminnot-luokka toteuttaa muistipelin varsinaisen pelilogiikan, eli
 * suorittaa yhteen kierrokseen liittyvät pelitoiminnot.
 * 
 * @author Anu N.
 *
 */

public class Pelitoiminnot {
   
    private int kierros, arvaukset, parit;
    private Pistelaskuri laskin;
    private boolean kaannetaan;
    private Pistepalkki pistepalkki;
    private Pelikentta pelikentta;
    private Kortti kortti1;
    private Kortti kortti2;
    
    /**
     * Konstruktori asettaa Pelitoiminnot nollatilaan.
     * 
     * @param pelikentta Pelikentta-luokan ilmentymä
     * @param pistepalkki Pistepalkki-luokan ilmentymä
     */
    public Pelitoiminnot(Pelikentta pelikentta, Pistepalkki pistepalkki) {
        this.laskin = new Pistelaskuri();
        this.kierros = 0;
        this.arvaukset = 0;
        this.parit = 0;
        this.kaannetaan = false;
        this.pistepalkki = pistepalkki;
        this.pelikentta = pelikentta;
        this.kortti1 = null;
        this.kortti2 = null;
    }
    
    /**
     * Metodi suorittaa muistipelin yhden pelikierroksen
     * 
     * @param kortti Kortti-luokan ilmentymä (tiedot muistipelikortista)
     */
    public void pelikierros(Kortti kortti) { 
        this.kierros++;
        if (kaannetaan == true) {
            kaannetaanEdelliset();
        }
        kortti.kaannaOikeinPain();
        tallenna(kortti);
        
        // Katsotaan, olivatko kaksi korttia parit ja suoritetaan vastaavat toiminnot
        if (this.kierros == 2 && onkoPari() == false) {
            eiPari(); 
        } if (this.kierros == 2 && onkoPari() == true) {
            onPari();
        }
        asetaPisteet();  
    } 
    
    /**
     * Metodi tallentaa parametrina saadun Kortin toiseen kahdesta muuttujasta
     * riippuen siitä, onko ensimmäinen muuttuja jo täynnä.
     * 
     * @param kortti Kortti-luokan ilmentymä
     */
    public void tallenna(Kortti kortti) {
        if (this.kortti1 == null) {
            this.kortti1 = kortti;
        } else {
            this.kortti2 = kortti;
        }
    }
    
    /**
     * Metodi vertaa, ovatko kahden kortin kuvapuolet samoja.
     * 
     * @return true, jos kuvapuolet (eli tiedostonimet) ovat samoja
     */
    public boolean onkoPari() {
        if (this.kortti1.getKuvapuoli().equals(this.kortti2.getKuvapuoli()) ) {
            return true;
        } return false;
        
    }
    
    /**
     * Metodi suoritetaan, mikäli kaksi korttia eivät ole pareja.
     * 
     * Asetetaan tieto, että kortit käännetään seuraavan kierroksen alussa.
     */
    public void eiPari() {
        kierros = 0;
        this.kaannetaan = true;   
        this.arvaukset++;
    }
    
    /**
     * Metodi suoritetaan, mikäli kaksi korttia ovat parit.
     * 
     * Tyhjennetään muuttujat ja kasvatetaan pistelaskurin arvoa ja parien lukumäärää.
     */    
    public void onPari() {
        this.kortti1 = null;
        this.kortti1 = null;
        this.kierros = 0;
        laskin.kasvataArvoa(this.arvaukset);
        this.parit++;
        this.arvaukset=0;
    }
    
    /**
     * Metodi tulostaa pelaajan pisteet käyttöliittymän oikeaan reunaan.
     */
    public void asetaPisteet() {
        int lkm = 0;
        lkm = this.pelikentta.getKoko();
        if (this.parit == lkm*lkm/2) {
            this.pistepalkki.getOmatPisteetKentta().setText("<html>"+" #"+"<strong> Pisteesi:</strong>"+" "+laskin.annaArvo()+"</html>");
            // jos peli päättyi, annetaan pelaajalle mahdollisuus tallentaa pisteet
            this.pistepalkki.getTallennaNappi().setVisible(true); 
        } else {
            this.pistepalkki.getOmatPisteetKentta().setText("<html>"+" #"+"<strong> Pisteesi:</strong>"+" "+laskin.annaArvo()+"</html>");
        }
    }
    
    /**
     * Metodi palauttaa pelaajan loppupisteet.
     * 
     * @return pisteet kokonaislukuna
     */
    public int finalScore() {
        return this.laskin.annaArvo();
    }
    
    /**
     * Metodi kääntää edellisen kierroksen kortit, mikäli paria ei löytynyt
     * ja tyhjentää kortti1- ja kortti2-muuttujat
     */
    public void kaannetaanEdelliset() {
        this.kortti1.kaannaNurinPain();
        this.kortti2.kaannaNurinPain();
        this.kortti1 = null;
        this.kortti2 = null;
        this.kaannetaan = false;
        
    }
    
    /**
     * Metodi nollaa kaikki pelitoiminnot uutta peliä varten.
     */
    public void nollaaKaikki() {
        this.kierros = 0;
        this.laskin = new Pistelaskuri();
        this.arvaukset = 0;
        this.kaannetaan = false;
        this.pistepalkki.getOmatPisteetKentta().setText("<html>"+" #"+"<strong> Pisteesi:</strong>"+" "+0+"</html>");
        this.parit = 0;
        this.pistepalkki.getTallennaNappi().setVisible(false);
        this.kortti1 = null;
        this.kortti2 = null;
    }

}
