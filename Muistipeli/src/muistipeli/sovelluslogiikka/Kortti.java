
package muistipeli.sovelluslogiikka;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 * Kortti-luokka vastaa muistipelikorttien luomisesta ja korttien kääntämisestä
 * oikein tai nurin päin. 
 * 
 * Luokka perii JButton-luokan.
 * 
 * @author Anu N.
 */
public class Kortti extends JButton {
 
    private ImageIcon oikeapuoli;
    private ImageIcon kaantopuoli;
    private String kuvapuoli;
    private String nurjapuoli;
    private boolean pelityyppi;
    
    /**
     * Konstruktori asettaa kortille oikean puolen ja kääntöpuolen, sekä
     * mustan ohuen rajauksen.
     * 
     * Kortista on defaulttina esillä nurja puoli. Kun nappia painetaan, oikea
     * puoli tulee näkyviin (eli asetetaan super.setEnabled(false))
     * 
     * @param oikeapuoli Kortin eli napin DisabledIcon (ImageIcon)
     * @param kaantopuoli Kortin eli napin Icon (ImageIcon)
     */
    public Kortti(ImageIcon oikeapuoli, ImageIcon kaantopuoli) {
        super();
        this.oikeapuoli = oikeapuoli;
        this.kaantopuoli = kaantopuoli;
        super.setIcon(this.kaantopuoli);
        super.setDisabledIcon(this.oikeapuoli); 
        super.setBorder(new LineBorder(Color.BLACK, 1));
        
        // Asetetaan pelittyyppi:
        // pelityyppi==true tarkoittaa peliä, jossa käytetään ikoneita korttien 
        // kuvina (eli DisabledIconeina). 
        this.pelityyppi = true;
        // Kortteja ei 'esikorosteta' painettavaksi
        super.setFocusPainted(false);
    }
    
    /**
     * Konstruktori asettaa kortille oikean puolen ja kääntöpuolen sekä rajauksen,
     * kun käytetään numeroita korttien 'kuvina'.
     * 
     * @param kuvapuoli String-muodossa oleva numero kortin kuvapuolelle
     */
    public Kortti(String kuvapuoli) {
        super();
        this.kuvapuoli = kuvapuoli;
        this.nurjapuoli = "?"; 
        super.setText(nurjapuoli);
        super.setBorder(new LineBorder(Color.BLACK, 1));
        //Jos kuvia ei löydy ja käytetään numeroita, pelityyppi=false
        this.pelityyppi = false;
    }
    
    /**
     * Metodi kääntää kortin oikein päin, eli jos kyseessä on kuvakortti,
     * asetetaan DisabledIcon näkyville, ja jos numerokortti, asetetaan
     * numeropuoli näkyville.
     */
    public void kaannaOikeinPain() {
        if (this.pelityyppi == true) {
            super.setEnabled(false);
        } else {
            super.setText(kuvapuoli);
        }
    }
    
    /**
     * Metodi kääntää kortin nurin päin, eli jos kyseessä on kuvakortti,
     * asetetaan kortin kuvaikoni (eli nurja puoli) näkyville, ja jos kyseessä
     * on numerokortti, näkyville tulee kysymysmerkki.
     */
    public void kaannaNurinPain() {
        if (this.pelityyppi == true) {
            super.setEnabled(true);
        } else {
            super.setText(this.nurjapuoli);
        }
    }
    
   /**
    * Metodi palauttaa kortin kuvapuolen merkkijonona, eli joko kuvakortin 
    * DisabledIconina olevan kuvan tiedostonimen tai numerokortin numeron.
    * 
    * @return Ikonin tiedostonimi tai numero merkkijonona
    */
    public String getKuvapuoli() {
        if (this.pelityyppi == true) {
            return this.oikeapuoli.toString();
        } else {
            return this.kuvapuoli;
        }
    }
    /**
     * Metodi palauttaa kortin kääntöpuolen merkkijonona, eli joko kuvakortin 
     * Iconina olevan kuvan tiedostonimen tai kysymysmerkin.
     * 
     * @return Ikonin tiedostonimi merkkijonona tai kysymysmerkki
     */
    public String getNurjapuoli() {
        if (this.pelityyppi == true) {
            return this.kaantopuoli.toString();
        } else {
            return this.nurjapuoli.toString();
        }
    }
    
   
}
