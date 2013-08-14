
package muistipeli.sovelluslogiikka;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 */

public class Pelaaja implements Comparable<Pelaaja> {
    private String nimi;
    private int pisteet;
    
    public Pelaaja(String n, int p) {
        this.nimi = n;
        this.pisteet = p;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public int getPisteet() {
        return this.pisteet;
    }
    
    @Override
    public String toString() {
        return this.getNimi() + ":" + this.getPisteet() + "\n";
    }

    @Override
    public int compareTo(Pelaaja pelaaja) {
        if (this.pisteet == pelaaja.getPisteet() ) {
            if (this.nimi.compareTo(pelaaja.getNimi()) > 1 ) {
                return 1;
            } else if (this.nimi.compareTo(pelaaja.getNimi() ) == 0 ) {
                return 0;
            } else {
                return -1;
            }
        } else if (this.pisteet > pelaaja.getPisteet() ) {
            return -1;
            } else {
                return 1;
            }
        }
    
}
