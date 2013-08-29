
package muistipeli.sovelluslogiikka;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Luokka vastaa pistetilastojen käsittelystä.
 * 
 * @author Anu N.
 *
 */

public class Pistelista {
    private List<Pelaaja> pistelista;
    private File tiedosto;
    private Scanner lukija;
    private FileWriter kirjoittaja;
    private String otsikko;
    
    /**
     * Konstruktori saa parametrina pistetilasto-tekstitiedoston tiedostonimen
     * 
     * @param t pisteet-tiedoston tiedostonimi/-polku
     */
    public Pistelista(String t) { 
        this.tiedosto = new File(t);
        this.pistelista = new ArrayList<Pelaaja>();
        this.kirjoittaja = null; 
        this.lukija = null; 
        this.otsikko = "TOP 10 PISTEET";
    }
    
    /*
     * Metodi hakee pisteet tekstidokumentista ja siirtää ne listarakenteeseen.
     * Pisteet on tallennettu muodossa nimi:pisteet
     * 
     * @return true, jos pisteiden haku onnistui
     * @exception heittää poikkeuksen, jos tiedostoa ei voitu lukea.
     */
    public boolean haePisteet() {
        this.pistelista = new ArrayList<Pelaaja>();
        this.lukija = null;
        try {
            this.lukija = new Scanner(this.tiedosto);
        } catch (Exception poikkeus) {
            System.out.println("Tiedostoa ei voitu lukea. Virhe: " + poikkeus.getMessage() ); 
            return false;
        } while (lukija.hasNextLine()) {
            try {
                String rivi = lukija.nextLine();
                String[] pisteet = rivi.split(":");
                String nimi = pisteet[0];
                String pistemaara = pisteet[1];
                int lkm = Integer.parseInt(pistemaara); // exception?? --> tähän try-catchit vielä?
                this.lisaaPisteet(nimi, lkm);
        } catch (Exception poikkeus) {
                System.out.println("Virhe tiedoston lukemisessa: " + poikkeus.getMessage());
                return false;
        }
           
    } lukija.close();
        return true;
    }

    /**
     * Metodi lisää pistelistaan uuden pistemäärän ja vastaavan pelaajan.
     * 
     * @param pelaajanNimi pelaajan nimi, merkkijono
     * @param pelaajanPisteet pelaajan pisteet, kokonaisluku
     */
    public void lisaaPisteet(String pelaajanNimi, int pelaajanPisteet) {
        this.pistelista.add(new Pelaaja(pelaajanNimi, pelaajanPisteet));
    }
   
    /**
     * Metodi tallentaa pistelistan tekstitiedostoon. 
     * 
     * Vanhat pistetiedot yliajetaan.
     * @exception heittää poikkeuksen, jos tiedoston tallentaminen ei onnistu
     */
    public void tallennaPisteet() {
        // jos pistelista on tyhjä, haetaan ensin vanhat pisteet
        if (this.pistelista.isEmpty()) { 
            if (this.haePisteet() == true) {
            haePisteet(); 
        }
        }
        this.kirjoittaja = null; 
        try {
            this.kirjoittaja = new FileWriter(this.tiedosto);
            for (Pelaaja pelaaja : this.pistelista) {
                kirjoittaja.write(pelaaja.toString() );
            } this.kirjoittaja.close();
        } catch (IOException poikkeus) {
            System.out.println("Tiedoston tallentaminen ei onnistunut. Virhe: " + poikkeus);
        }
     } 
    
    public List annaPistelista() {
        return this.pistelista;
    }
    
    /**
     * Metodi palauttaa kutsumishetkellä pistelistassa olevan parhaan pistemäärän
     * 
     * @return highscore merkkijonona
     */
    public String tulostaHighscore() {
       haePisteet(); 
       String palautus = "<html>";
            if (this.pistelista.size() >= 1) {
            Collections.sort(this.pistelista);
                palautus+=this.pistelista.get(0)+"<br>";
            } else {
                palautus = "0";
       } return palautus+"</html>";
            
    }
    
    /**
     * Metodi tulostaa top10-pisteet
     * 
     * @return pisteet merkkijonona
     */
    public String tulostaPisteet() {
       int laskuri = 1;
       String palauta = "<html><strong><br>TOP 10 PISTEET</strong></br><br>";
       Collections.sort(this.pistelista);
        if (this.pistelista.size() < 10) {
            for (Pelaaja pelaaja : this.pistelista) {
                palauta=palauta+laskuri+". "+pelaaja.toString()+"<br>";
                laskuri++;
            }
        } else {
            for (int p=0; p<10; p++) {
                palauta=palauta+laskuri+". "+pistelista.get(p).toString2()+"<br>";
                laskuri++;
           
        } 
    } return palauta+"</hmtl>";
    }
    
    
    @Override
    public String toString() {
        String lista = "";
        for (Pelaaja p : this.pistelista) {
            lista += p.toString();
        }
        return lista;
    }
    
}

