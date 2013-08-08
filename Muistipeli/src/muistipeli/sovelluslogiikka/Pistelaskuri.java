
package muistipeli.sovelluslogiikka;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * 
 * @author Anu Nikkanen
 * 
 * Pistelaskuri laskee pelaajan muistipelissä saavuttamat pisteet. Mitä
 * vähemmän arvauksia, sitä enemmän pisteitä pelaaja saa.
 * 
 * PISTELASKURIA EI OLE TÄLLÄ HETKELLÄ VIELÄ KYTKETTY KÄYTTÖLIITTYMÄÄN/
 * VARSINAISEEN SOVELLUSLOGIIKKAAN.
 * 
 */
public class Pistelaskuri implements Laskuri {
    
    private int arvo;
    private int arvaustenLkm;
    
    public Pistelaskuri() {
        this.arvo = 0;
        this.arvaustenLkm = 0;
    }
    
    @Override
    public int annaArvo() {
        return this.arvo;
    }
    
    public int annaArvaustenLkm() {
        return this.arvaustenLkm;
    }
    
    public void kasvataArvaustenLkmYhdella() {
        this.arvaustenLkm++;
    }
    
    @Override
    public void kasvataArvoaYhdella() {
        this.arvo++; 
    }
    
    public void lisaaBonus() {
        if (arvaustenLkm < 3) { // tämä ei tule olemaan sidottu tähän lukuun, vaan riippuu korttien määrästä.
            kasvataArvoa(10);
        } 
    } 
    
    @Override
    public void kasvataArvoa(int luku) {
        this.arvo=+luku;
    }
    
    @Override
    public String toString() {
        return "laskurin arvo on nyt " + this.arvo + " ja arvausten lkm " + this.arvaustenLkm;
    }
    
    

}

