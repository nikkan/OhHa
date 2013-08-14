
package muistipeli.sovelluslogiikka;


/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * Pistelaskuri laskee pelaajan muistipelissä saavuttamat pisteet. Mitä
 * vähemmän arvauksia, sitä enemmän pisteitä pelaaja saa.
 * 
 */
public class Pistelaskuri {
    
    private int arvo;
    private int arvaustenLkm;
    
    public Pistelaskuri() {
        this.arvo = 0;
        this.arvaustenLkm = 0;
    }
    
    public int annaArvo() {
        return this.arvo;
    }
    
    public int annaArvaustenLkm() {
        return this.arvaustenLkm;
    }
    
    public void kasvataArvaustenLkmYhdella() {
        this.arvaustenLkm++;
    }
    

    public void kasvataArvoaYhdella() {
        this.arvo++; 
    }
    
    // Mikäli arvausten lkm on pienempi kuin 10, oikeasta parista annetaan
    // pisteitä 10-arvausten lkm.
    public void kasvataArvoa(int arvaukset) {
        if (arvaukset<10) {
            this.arvo=this.arvo+(10-arvaukset);
        }
    }
    
    @Override
    public String toString() {
        return "laskurin arvo on nyt " + this.arvo + " ja arvausten lkm " + this.arvaustenLkm;
    }
    
    

}

