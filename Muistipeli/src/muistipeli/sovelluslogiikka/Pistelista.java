
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
 * Tällä hetkellä top5-pistelistan tulostaminen ei vielä ole käytössä.
 *
 */


public class Pistelista {
    private List<Pelaaja> pistelista;
    private File tiedosto;
    private Scanner lukija;
    private FileWriter kirjoittaja;
    
    public Pistelista(String t) { 
        this.tiedosto = new File(t);
        this.pistelista = null;
        this.kirjoittaja = null; 
        this.lukija = null; 
    }
    
    /*Metodi hakee pisteet tekstidokumentista ja siirtää ne listarakenteeseen.*/
    public boolean haePisteet() {
        this.pistelista = new ArrayList<Pelaaja>();
        this.lukija = null;
        try {
            this.lukija = new Scanner(this.tiedosto);
        } catch (Exception poikkeus) {
            System.out.println("Tiedostoa ei voitu lukea. Virhe: " + poikkeus.getMessage() ); 
        } while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] pisteet = rivi.split(":");
            String nimi = pisteet[0];
            String pistemaara = pisteet[1];
            int lkm = Integer.parseInt(pistemaara); // exception?? --> tähän try-catchit vielä?
            this.lisaaPisteet(nimi, lkm);
        } lukija.close();
        return true;
    }

    /*Metodi lisää pistelistaan uuden pistemäärän ja vastaavan pelaajan.*/
    public void lisaaPisteet(String pelaajanNimi, int pelaajanPisteet) {
        if (this.pistelista == null) {
            this.pistelista = new ArrayList<Pelaaja>();
        }
        this.pistelista.add(new Pelaaja(pelaajanNimi, pelaajanPisteet));
    }
   
   
    
    /*Metodi tallentaa pistelistan tekstitiedostoon. Vanhat pistetiedot yliajetaan.*/
    public void tallennaPisteet() {
        if (this.pistelista == null) { 
            haePisteet(); 
        }
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
    
    public List annaPistelista() {
        return this.pistelista;
    }
    
    /*Metodi palauttaa kutsumishetkellä pistelistassa olevan parhaan pistemäärän+*/
    public String tulostaHighscore() {
        if (this.pistelista == null) {haePisteet();}
        String palautus = "";
        if (this.pistelista.size() >= 1) {
            Collections.sort(this.pistelista);
            palautus+=this.pistelista.get(0);
            return palautus;
        } else return "0";
    }
    
    /* Metodi tulostaa top5-pisteet */
    public String tulostaPisteet() {
       String palauta = "";
        if (this.pistelista.size() < 5) {
            for (Pelaaja pelaaja : this.pistelista) {
                palauta+=pelaaja.toString2()+"\n";
            }
        } else {
            for (int p=0; p<5; p++) {
                palauta+=pistelista.get(p).toString2()+"\n";
           
        } 
    } return palauta+"";
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

