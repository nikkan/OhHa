
package muistipeli.sovelluslogiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 * Ohjelmoinnin jatkokurssi, syksy 2013
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
    
    public Muistipelikortit() {
        this.ikonit = new ArrayList<String>();
        this.ikonit.add("src/muistipeli/kuvat/ikoni2.gif"); 
        this.ikonit.add("src/muistipeli/kuvat/ikoni2.gif"); 
        this.ikonit.add("src/muistipeli/kuvat/ikoni3.gif"); 
        this.ikonit.add("src/muistipeli/kuvat/ikoni3.gif");
        this.ikonit.add("src/muistipeli/kuvat/ikoni4.gif");
        this.ikonit.add("src/muistipeli/kuvat/ikoni4.gif");  
        this.kaantopuoli = "src/muistipeli/kuvat/ikoni1.gif";
    }
    
    public Muistipelikortit(int koko) {
        if (tarkistaKoko(koko) == true) {
            this.ikonit = new ArrayList<String>(); // luetaan vastaavasta listasta tai tiedostosta
            for (int i = 0; i < koko; ++i ) {
                this.ikonit.add("placeholder"); // placeholderin tilalle tiedostosta lukeminen/taulukko 
            }   
        }
    }
    
    public boolean tarkistaKoko(int annettuKoko) {
        if (annettuKoko == 3) { // muuta vastaamaan todellisia arvoja, kun pelikentän koko vaihdettavissa
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
