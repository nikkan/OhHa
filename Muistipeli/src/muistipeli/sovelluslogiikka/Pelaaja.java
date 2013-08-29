
package muistipeli.sovelluslogiikka;

/**
 * Pelaaja-luokka vastaa pelaajan nimi- ja pistetiedoista sekä näiden
 * vertailusta muihin pelaajiin.
 * 
 * Luokka implementoi Comparable-rajapinnan
 * 
 * @author Anu N.
 * 
 */

public class Pelaaja implements Comparable<Pelaaja> {
    
    private String nimi;
    private int pisteet;
    
    /**
     * Konstruktori asettaa pelaajalle nimi- ja pistetiedot
     * @param nimi Pelaajan nimimerkki merkkijonona
     * @param pisteet Pelaajan pisteet kokonaislukuna 
     */
    public Pelaaja(String nimi, int pisteet) {
        this.nimi = nimi;
        this.pisteet = pisteet;
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
    
    public String toString2() {
        return this.getNimi() + ":" + this.getPisteet();
    }
    
    /**
     * CompareTo-metodi palauttaa järjestystiedon pelaajien vertilusta.
     * 
     * Pelaajia vertaillaan ensisijaisesti pisteiden ja toissijaisesti nimen 
     * perusteella.
     * 
     * @param pelaaja pelaaja, johon 'tätä' pelaajaa verrataan
     * @return Vertailutieto kokonaislukuna 
     */
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
