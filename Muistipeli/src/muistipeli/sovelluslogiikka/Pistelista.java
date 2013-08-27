
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
    private String otsikko;
    
    public Pistelista(String t) { 
        this.tiedosto = new File(t);
        this.pistelista = new ArrayList<Pelaaja>();
        this.kirjoittaja = null; 
        this.lukija = null; 
        this.otsikko = "TOP 10 PISTEET";
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
        
        this.pistelista.add(new Pelaaja(pelaajanNimi, pelaajanPisteet));
    }
   
   
    
    /*Metodi tallentaa pistelistan tekstitiedostoon. Vanhat pistetiedot yliajetaan.*/
    public void tallennaPisteet() {
        if (this.pistelista.isEmpty()) { 
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
       haePisteet(); 
       String palautus = "<html>";
            if (this.pistelista.size() >= 1) {
            Collections.sort(this.pistelista);
                palautus+=this.pistelista.get(0)+"<br>";
            } else {
                palautus = "0";
       } return palautus+"</html>";
            
    }
    
    /* Metodi tulostaa top10-pisteet */
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

