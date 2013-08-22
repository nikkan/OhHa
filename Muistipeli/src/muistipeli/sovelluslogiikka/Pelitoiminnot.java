
package muistipeli.sovelluslogiikka;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.JButton;
import muistipeli.kayttoliittyma.LuoPelikentta;
import muistipeli.kayttoliittyma.LuoPistepalkki;

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
    
    private HashMap<JButton, String> kortit;
    private JButton ekaNappi, tokaNappi;
    private String lahde1, lahde2;
    private int kierros, arvaukset, parit;
    private final String TYHJA;
    private Pistelaskuri laskin;
    private boolean kaannetaan;
    private LuoPistepalkki pp;
    private LuoPelikentta pk;
    
    public Pelitoiminnot(LuoPelikentta pk, LuoPistepalkki pp) {
        this.kierros = 0;
        this.laskin = new Pistelaskuri();
        this.TYHJA = " ";
        this.lahde1 = this.TYHJA;
        this.lahde2 = this.TYHJA;
        this.arvaukset = 0;
        this.kaannetaan = false;
        this.pp = pp;
        this.pk = pk;
    }
    
    /* Metodi suorittaa muistipelin pelikierroksen */
    public void pelikierros(ActionEvent toiminto) {
        for (JButton j : this.pk.getKorttilista().keySet()) {
            if (toiminto.getSource() == j) {
                this.kierros++;
                kaannetaanEdelliset();
                j.setEnabled(false);
                tallenna(this.pk.getKorttilista().get(j), j);
          
                if (this.kierros == 2 && onkoPari() == false) {
                    eiPari();
                } else if (this.kierros == 2 && onkoPari() == true) {
                    onPari();
                }
            } 
        } asetaPisteet();
    }
    
    /* Metodi tallentaa kortin (ImageIconin tiedoston nimen ja JButtonin) toiseen kahdesta muuttujasta.*/
    public void tallenna(String tiedosto, JButton nappi) {
        if (this.lahde1.equals(this.TYHJA)) {
            this.lahde1 = tiedosto;
            this.ekaNappi = nappi;
        } else {
            this.lahde2 = tiedosto;
            this.tokaNappi = nappi;
        }
    }
    
    /* Metodi vertaa, ovatko kaksi korttia (=niiden kuvapuolet) samoja.*/
    public boolean onkoPari() {
        if (this.lahde1.equals(this.lahde2)) {
            return true;
        }
        return false;
    }
    
    /*Metodi suoritetaan, mikäli kaksi korttia eivät ole pareja.*/
    public void eiPari() {
        kierros = 0;
        this.lahde1 = this.TYHJA;
        this.lahde2 = this.TYHJA;
        this.kaannetaan = true;
        this.arvaukset++;
    }
    
    /* Metodi suoritetaan, mikäli kaksi korttia ovat parit.*/
    public void onPari() {
        this.lahde1 = this.TYHJA;
        this.lahde2 = this.TYHJA;
        this.kierros = 0;
        laskin.kasvataArvoa(this.arvaukset);
        this.parit++;
        this.arvaukset=0;
    }
    
    /*Metodi tulostaa pisteet käyttöliittymän alapalkkiin.*/
    public void asetaPisteet() {
        if (this.parit == 2) {
            this.pp.getPisteesikentta().setText("pisteesi: "+laskin.annaArvo() );
            this.pp.getTallennaNappi().setEnabled(true);
        } else {
            this.pp.getPisteesikentta().setText("pisteesi: "+laskin.annaArvo() );
        }
    }
    
    /* Metodi palauttaa pelaajan loppupisteet */
    public int finalScore() {
        return this.laskin.annaArvo();
    }
    
    /*Metodi kääntää edellisen kierroksen kortit, mikäli paria ei löytynyt,
      kun uutta korttia klikataan.*/
    public void kaannetaanEdelliset() {
        if (this.kaannetaan == true) {
            this.ekaNappi.setEnabled(true);
            this.tokaNappi.setEnabled(true);
            this.kaannetaan = false;
        } 
    }

}
