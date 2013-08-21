
package muistipeli.sovelluslogiikka;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;

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
    private JButton ekaNappi;
    private JButton tokaNappi;
    private String lahde1;
    private String lahde2;
    private int kierros;
    private JLabel pistekentta;
    private final String TYHJA;
    private Pistelaskuri laskin;
    private int arvaukset;
    private int parit;
    private boolean kaannetaan;
    
    public Pelitoiminnot(HashMap<JButton, String> map, JLabel alapalkki) {
        this.kortit = map;
        this.kierros = 0;
        this.pistekentta = alapalkki;
        this.laskin = new Pistelaskuri();
        this.TYHJA = " ";
        this.lahde1 = this.TYHJA;
        this.lahde2 = this.TYHJA;
        this.arvaukset = 0;
        this.kaannetaan = false;
    }
    
    // Metodi suorittaa pelikierroksen.
    public void pelikierros(ActionEvent toiminto) {
        for (JButton j : this.kortit.keySet()) {
            if (toiminto.getSource() == j) {
                this.kierros++;
                kaannetaanEdelliset();
                j.setEnabled(false);
                tallenna(this.kortit.get(j), j);
          
                if (this.kierros == 2 && onkoPari() == false) {
                    eiPari();
                } else if (this.kierros == 2 && onkoPari() == true) {
                    onPari();
                }
            } 
        } asetaPisteet();
    }
    
    // Metodi tallentaa kortin (tiedostonimen ja napin) toiseen kahdesta muuttujasta.
    private void tallenna(String tiedosto, JButton nappi) {
        if (this.lahde1.equals(this.TYHJA)) {
            this.lahde1 = tiedosto;
            this.ekaNappi = nappi;
        } else {
            this.lahde2 = tiedosto;
            this.tokaNappi = nappi;
        }
    }
    
    // Metodi vertaa, ovatko kaksi korttia (=niiden kuvapuolet) samoja.
    private boolean onkoPari() {
        if (this.lahde1.equals(this.lahde2)) {
            return true;
        }
        return false;
    }
    
    // Metodi suoritetaan, mikäli kaksi korttia eivät ole pareja.
    private void eiPari() {
        kierros = 0;
        this.lahde1 = this.TYHJA;
        this.lahde2 = this.TYHJA;
        this.kaannetaan = true;
        this.arvaukset++;
    }
    
    // Metodi suoritetaan, mikäli kaksi korttia ovat parit.
    private void onPari() {
        this.lahde1 = this.TYHJA;
        this.lahde2 = this.TYHJA;
        this.kierros = 0;
        laskin.kasvataArvoa(this.arvaukset);
        this.parit++;
        this.arvaukset=0;
    }
    
    // Metodi tulostaa pisteet käyttöliittymän alapalkkiin.
    private void asetaPisteet() {
        if (this.parit == 3) {
            this.pistekentta.setText("WOHOO! Loppupisteesi: "+laskin.annaArvo() );
            //this.pistekentta.
           
        } else {
            this.pistekentta.setText("pisteesi: "+laskin.annaArvo() );
        }
    }
    
    // Metodi kääntää edellisen kierroksen kortit, mikäli paria ei löytynyt,
    // kun uutta korttia klikataan.
    private void kaannetaanEdelliset() {
        if (this.kaannetaan == true) {
            this.ekaNappi.setEnabled(true);
            this.tokaNappi.setEnabled(true);
            this.kaannetaan = false;
        } 
    }

}
