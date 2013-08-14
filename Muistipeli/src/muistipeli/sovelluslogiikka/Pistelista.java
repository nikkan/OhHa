
package muistipeli.sovelluslogiikka;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Ohjelmoinnin harjoitustyö, loppukesä 2013
 * 
 * @author Anu Nikkanen
 * 
 * Luokka tarjoaa palveluita pistelistojen tallentamiseen ja tulostamiseen. 
 * 
 * Tarkoitus on, että tiedostonkäsittely eriytetään vielä omaksi luokakseen.
 * 
 */


public class Pistelista {
    private List<Pelaaja> pistelista;
    private File tiedosto;
    private Scanner lukija;
    private FileWriter kirjoittaja;
    
    public Pistelista(String t) { // pitäiskö 'juuri tämän muistipelin' asetukset tallentaa johonkin omaan luokkaansa tjms?
        this.tiedosto = new File(t);
        this.pistelista = new ArrayList<Pelaaja>();
        this.kirjoittaja = null;
        this.lukija = null; //?
    }
    
    // Metodi hakee pisteet tekstidokumentista ja siirtää ne listarakenteeseen.
    public boolean haePisteet() {
        this.pistelista = new ArrayList<Pelaaja>();
        this.lukija = null;
        try {
            this.lukija = new Scanner(this.tiedosto);
        } catch (Exception poikkeus) {
            System.out.println("Tiedostoa ei voitu lukea. Virhe: " + poikkeus.getMessage() ); // tämä pitänee ohjata GUI:hin?
        } while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] pisteet = rivi.split(":");
            String nimi = pisteet[0];
            String pistemaara = pisteet[1];
            int lkm = Integer.parseInt(pistemaara); // exception?? --> tähn try-catchit vielä?
            this.lisaaPisteet(nimi, lkm);
        } lukija.close();
        return true;
    }

    // Metodi lisää pistelistaan uuden pistemäärän ja vastaavan pelaajan.
    private void lisaaPisteet(String pelaajanNimi, int pelaajanPisteet) {
        this.pistelista.add(new Pelaaja(pelaajanNimi, pelaajanPisteet));
    }
    
    // Metodi tallentaa pistelistan tekstitiedostoon. Vanhat pistetiedot yliajetaan.
    public void tallennaPisteet() {
        this.kirjoittaja = null; // onko tämä tässä tarpeellinen?
        try {
            this.kirjoittaja = new FileWriter(this.tiedosto);
            for (Pelaaja pelaaja : this.pistelista) {
                kirjoittaja.write(pelaaja.toString() );
            } this.kirjoittaja.close();
        } catch (IOException poikkeus) {
            System.out.println("Tiedoston tallentaminen ei onnistunut. Virhe: " + poikkeus);
        }
     } 
    
    // Metodi tulostaa kutsumishetkellä pistelistassa olevat "top 10"-pisteet
    public void tulostaPisteet() {
        /*if (this.pistelista.size() > 1) {
            Collections.sort(this.pistelista);
        }*/
        if (this.pistelista.size() < 10) {
            for (Pelaaja pelaaja : this.pistelista) {
                System.out.println(pelaaja.toString());
            }
        } else {
            for (int p=0; p<10; ++p) {
                System.out.println(this.pistelista.get(p).toString());
            }
        }
        
    }
    
    
}
