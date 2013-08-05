
package muistipeli.sovelluslogiikka;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * 
 * @author Anu Nikkanen
 */
public class OmaPistelaskuri implements Pistelaskuri {
    
    private int arvo;
    private int lkm; // jos jää tälleen, niin tee tälle oma luokka -> ei copypastea!
    
    public OmaPistelaskuri() {
        this.arvo = 0;
        this.lkm = 0;
    }
    
    @Override
    public int annaArvo() {
        return this.arvo;
    }

    @Override
    public void kasvataArvoa() {
        this.arvo++; // tämä pitää muuttaa vielä myöhemmin oikein toimivaksi,
        // eli niin, että on myös toinen laskuri (pisteidenLaskija), johon tämä viittaa.. eli mitä
        // vähemmän on arvauksia, niin sitä paremmat pisteet
    }
    // lisätäänkö rajapintaan??
    public int pisteidenLaskija(int arvo) {
        // tämän laskurin on tarkoitus pitää kirjaa arvauksista. tähän joku sellainen
        // logiikka, että pelaaja saa eri määrän pisteitä esim. riippuen siitä,
        // kuinka monta kierrosta on mennyt 
        return 0;
    } 

    @Override
    public int annaKierrokset() { // väliaikainen soluzione
        return this.lkm;
    }

    @Override
    public void kasvataKierrosta() { // väliaikainen soluzione
        this.lkm++;
    }
    
    
}

