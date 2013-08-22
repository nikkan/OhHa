
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
 * ts. ikoneita JButtoneille. Tällä hetkellä pakan koko on fiksattu 2x2, mutta lisää
 * valinnanvapautta on tulossa..
 *
 */

public class Muistipelikortit {
    
    private ArrayList<String> ikonit;
    private String kaantopuoli;
    private Scanner tl;
    File t;
    
    public Muistipelikortit() {
        this.ikonit = new ArrayList<String>();
        this.tl = null;
    }
    
    /* Luokan konstruktori hakee tiedostosta oikean kokoisen muistipelin korttien tiedot 
    /*ja tallentaa ne ArrayListiin.*/
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
            this.kaantopuoli = "src/muistipeli/kuvat/viikset.gif";
        } else {
            System.out.println("Pelikentän koko ei ole mahdollinen.");
        }
    }
    
    /* Metodi lisää listaan uuden ikonin*/
    public void lisaaIkoni(String ikoni) {
        this.ikonit.add(ikoni);
    }
    
    public String getKaantopuoli() {
        return this.kaantopuoli;
    }
    
    /*Metodi tarkistaa, onko pyydetyn muistipelin koko validi.*/
    public boolean tarkistaKoko(int annettuKoko) {
        if (annettuKoko == 2 || annettuKoko == 4 || annettuKoko == 6) {
            return true;
        } return false; 
    }
    
    /* Metodi palauttaa listallisen ikoneita halutun kokoiseen muistipeliin.*/
    public ArrayList<String> annaIkonit() {
        sekoitaKortit();
        lisaaIkoni(this.kaantopuoli);
        return this.ikonit;
    }
    
    /*Tirasta tuttu sekoitusalgoritmi sekoittaa muistikorttipakan, jotta
    /*pelilauta on joka kerta erilainen.*/
    public void sekoitaKortit() {
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
