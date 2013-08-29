
package muistipeli.sovelluslogiikka;


/**
 * Pistelaskuri laskee pelaajan muistipelissä saavuttamat pisteet. 
 * 
 * Mitä vähemmän arvauksia ennen paria, sitä enemmän pisteitä pelaaja saa.
 * 
 * @author Anu N.
 */
public class Pistelaskuri {
    
    private int arvo;
    private int arvaustenLkm;
    
    /**
     * Konstruktori asettaa laskurin nollatilaan.
     */
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
    
    /** Metodi kasvattaa laskurin arvoa arvausten määrän huomioon ottaen.
     * 
     *  Mikäli arvausten lkm on pienempi kuin 10, 
     *  oikeasta parista annetaan
     *  pisteitä (10-arvausten lkm).
     * 
     * @param arvaukset Pelaajan arvausten määrä
     */
    public void kasvataArvoa(int arvaukset) {
        if (arvaukset<10) {
            this.arvo=this.arvo+(10-arvaukset);
        }
    }
    
    @Override
    public String toString() {
        return "laskurin arvo on nyt " + this.arvo;
    }
    
    

}

