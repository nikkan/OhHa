
package muistipeli.sovelluslogiikka;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * Luokka palauttaa parametrina saadun koon mukaisen sekoitetun pakan muistikortteja,
 * ts. ikoneita JButtoneille. Ttällä hetkellä pakan koko on fiksattu 2x3, 
 * mutta tarkoitus on, että korteille luetaan kuvat tiedostosta tai taulukosta
 * sen mukaan, minkä koon käyttäjä valitsee pelille. 
 * 
 */

public class Muistipelikortit {
    
    private ArrayList<String> ikonit;
    private String kaantopuoli;
    private Scanner tl;
    File t;
    
    public Muistipelikortit() {
        this.ikonit = new ArrayList<String>();
        this.kaantopuoli = "src/muistipeli/kuvat/ikoni1.gif";
        this.tl = null;
    }
    
    public Muistipelikortit(int koko) {
        if (tarkistaKoko(koko) == true) {
            this.ikonit = new ArrayList<String>(); 
            this.tl = null;
            this.t = new File("src/muistipeli/pelikentat/kortit"+koko+".txt");
            try {
                this.tl = new Scanner(t);
            } catch (Exception poikkeus) {
                System.out.println("Tiedostoa ei voitu lukea. Virhe: " + poikkeus.getMessage() ); // mihin ohjataan?
            } while (this.tl.hasNextLine()) {
                String rivi = this.tl.nextLine();
                this.ikonit.add(rivi);
                this.ikonit.add(rivi);
            }  
            this.tl.close();
            this.kaantopuoli = "src/muistipeli/kuvat/ikoni1.gif";
        } else {
            System.out.println("Pelikentän koko ei ole mahdollinen.");
        }
    }
    
    public static boolean tarkistaKoko(int annettuKoko) {
        if (annettuKoko == 3 || annettuKoko == 4 || annettuKoko == 5) { // muuta vastaamaan todellisia arvoja, kun pelikentän koko vaihdettavissa
            return true;
        } return false; 
    }
    
    public ArrayList<String> annaIkonit() {
        sekoitaKortit();
        this.ikonit.add(this.kaantopuoli);
        return this.ikonit;
    }
    
    public void sekoitaKortit() {
        // tirasta tuttu sekoitusalgoritmi sovellettuna
        Random satunnaisluku = new Random();
      
        for (int j=ikonit.size()-1; j>=1; j--) {
            int s = satunnaisluku.nextInt(ikonit.size()); 
            String apu = ikonit.get(j);
            ikonit.set(j, ikonit.get(s));
            ikonit.set(s, apu);
        }
     
    }
    
    @Override
    public String toString() {
        String lista = "";
        for (String ikoni : ikonit) {
            lista += ikoni+",";
        }
        return lista;
    }
    
    
  
}
