
package muistipeli.sovelluslogiikka;

import muistipeli.kayttoliittyma.Pelikentta;
import muistipeli.kayttoliittyma.Pistepalkki;

/**
 *
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * Pelitoiminnot-luokka toteuttaa muistipelin varsinaisen pelilogiikan, eli
 * käynnistää kierroksen ja suorittaa yhteen kierrokseen liittyvät toiminnot,
 * kuten korttien kääntämisen ja niiden vertailemisen.
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
    
    /* Metodi suorittaa muistipelin pelikierroksen */
    public void pelikierros(Kortti kortti) { 
        this.kierros++;
        if (kaannetaan == true) {
            kaannetaanEdelliset();
        }
        kortti.kaannaOikeinPain();
        tallenna(kortti);
        
        if (this.kierros == 2 && onkoPari() == false) {
            eiPari();
        } if (this.kierros == 2 && onkoPari() == true) {
            onPari();
        }
        asetaPisteet();
        
    } 
    
    /* Metodi tallentaa kortin (ImageIconin tiedoston nimen ja JButtonin) toiseen kahdesta muuttujasta.*/
    public void tallenna(Kortti kortti) {
        if (this.kortti1 == null) {
            this.kortti1 = kortti;
        } else {
            this.kortti2 = kortti;
        }
    }
    
    /* Metodi vertaa, ovatko kaksi korttia (=niiden kuvapuolet) samoja.*/
    public boolean onkoPari() {
        if (this.kortti1.getKuvapuoli().equals(this.kortti2.getKuvapuoli()) ) {
            return true;
        } return false;
        
    }
    
    /*Metodi suoritetaan, mikäli kaksi korttia eivät ole pareja.*/
    public void eiPari() {
        kierros = 0;
        this.kaannetaan = true;   
        this.arvaukset++;
    }
    
    /* Metodi suoritetaan, mikäli kaksi korttia ovat parit.*/    
    public void onPari() {
        this.kortti1 = null;
        this.kortti1 = null;
        this.kierros = 0;
        laskin.kasvataArvoa(this.arvaukset);
        this.parit++;
        this.arvaukset=0;
    }
    
    /*Metodi tulostaa pisteet käyttöliittymän alapalkkiin.*/
    public void asetaPisteet() {
        int lkm = 0;
        lkm = this.pelikentta.getKoko();
        if (this.parit == lkm*lkm/2) {
            this.pistepalkki.getOmatPisteetKentta().setText("<html>"+" #"+"<strong> Pisteesi:</strong>"+" "+laskin.annaArvo()+"</html>");
            this.pistepalkki.getTallennaNappi().setVisible(true);
        } else {
            this.pistepalkki.getOmatPisteetKentta().setText("<html>"+" #"+"<strong> Pisteesi:</strong>"+" "+laskin.annaArvo()+"</html>");
        }
    }
    
    /* Metodi palauttaa pelaajan loppupisteet */
    public int finalScore() {
        return this.laskin.annaArvo();
    }
    
    /*Metodi kääntää edellisen kierroksen kortit, mikäli paria ei löytynyt*/
    public void kaannetaanEdelliset() {
        this.kortti1.kaannaNurinPain();
        this.kortti2.kaannaNurinPain();
        this.kortti1 = null;
        this.kortti2 = null;
        this.kaannetaan = false;
        
    }
    
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
