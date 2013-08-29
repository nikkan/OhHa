
package muistipeli.sovelluslogiikka;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Ikonikuvat-luokka vastaa muistipelikorttien kuvien eli ikonien hakemisesta 
 * tekstitiedostosta ja tallentamisesta listaan. 
 * 
 * Jos tekstitiedostoa ei löydy, ikonien paikalle tallennetaan numeroita merkki-
 * jonona. Ennen listan palauttamista ikonit sekoitetan.
 * 
 * @author Anu N.
 */

public class Ikonikuvat {
    
    private ArrayList<String> ikonikuvat;
    private String kaantopuoli;
    private boolean onkoKuvia;
    private Scanner tl;
    File t;
   
    /**
     * Konstruktori yrittää hakea tekstitiedostosta oikean kokoisen muistipelin
     * korttien tiedot ja tallentaa ne listarakenteeseen.
     * 
     * Jos tiedostoa ei löydy, 'ikoneiksi' asetetaan numeroita merkkijonomuodossa.
     * 
     * @param koko Muistipelikentän koko (esim. 2 --> 2x2 pelikenttä)
     */
    public Ikonikuvat(int koko) {
        // Kutsutaan haeIkonitTiedostosta()-metodia. Jos metodi palauttaa false,
        // lisätään listaan pyydetyn kokoinen pelikentällinen numeroita merkkijonoina.
        if (this.haeIkonitTiedostosta(koko) == false ) {
            this.ikonikuvat = new ArrayList<String>();
            int lkm = 0;
            if (koko == 2) {
                lkm = 2;
            } else if (koko == 4) {
                lkm = 16;
            } else {    // jos pyydetty koko ei ole validi
                lkm = 36; 
            }
            for (int i=0; i<lkm; ++i) {
                this.ikonikuvat.add(""+i+""); // kukin numero lisätään kahdesti,
                this.ikonikuvat.add(""+i+""); // jotta saadaan parit
            } 
            this.onkoKuvia = false;
            this.kaantopuoli = "?"; // lisätään kysymysmerkki kääntöpuoleksi
               
           } 
        }
       
    /**
     * Yksityinen metodi yrittää lukea kuhunkin ikoniin liittyvän tiedostopolun
     * ja tallentaa sen listaan.
     * 
     * Metodi heittää poikkeuksen, jos tiedostoa ei löytynyt.
     * 
     * @param koko Muistipelikentän koko (indeksi, jolla löydetään oikea tekstitiedosto)
     * @return Jos tiedoston lukeminen onnistui, palautetaan true
     * @exception Metodi heittää poikkeuksen, jos tiedostoa ei löydy
     */
    private boolean haeIkonitTiedostosta(int koko) {
        this.ikonikuvat = new ArrayList<String>();
        this.tl = null;
            this.t = new File("src/muistipeli/pelikentat/kortit"+koko+".txt");
            try {
                this.tl = new Scanner(t);
            } catch (Exception poikkeus) {
                System.out.println("Tiedostoa ei voitu lukea. Virhe: " + poikkeus.getMessage() ); 
                this.onkoKuvia = false;
                return false;
            } while (this.tl.hasNextLine()) {
                String rivi = this.tl.nextLine();
                this.ikonikuvat.add(rivi); // kukin tiedostopolku lisätään kahdesti,
                this.ikonikuvat.add(rivi); // jotta saadaan parit
            }  
            this.tl.close();
            this.onkoKuvia = true;
            return true; 
    }
    
    /**
     * Palauttaa tiedon siitä, onko listassa tiedostopolkuja kuvatiedostoihin.
     * 
     * @return Palautetaan true, jos listassa on tiedostopolut kuvatiedostoihin
     */
    public boolean onkoKuvia() {
        return this.onkoKuvia;
    }
    
    /**
     * Palauttaa sekoitetut ikonit listassa ja lisää kuvakortteihin
     * kääntöpuolen, jos se löytyy.
     * 
     * @return ArrayList-listallinen tiedostopolkuja kuvatiedostoihin merkkijonoina
     */
    public ArrayList<String> getIkonit() {
        sekoitaKortit();
        if (this.onkoKuvia == true) {
            this.kaantopuoli = "src/muistipeli/kuvat/nurjapuoli.gif";
            this.ikonikuvat.add(kaantopuoli);
        } 
        return this.ikonikuvat;
    }
    
    
    /**
     * Tirasta tuttu sekoitusalgoritmi sekoittaa listassa olevat ikonit
     */
    private void sekoitaKortit() {
        Random satunnaisluku = new Random();
      
        for (int j=ikonikuvat.size()-1; j>=1; j--) {
            int s = satunnaisluku.nextInt(ikonikuvat.size()); 
            String apu = ikonikuvat.get(j);
            ikonikuvat.set(j, ikonikuvat.get(s));
            ikonikuvat.set(s, apu);
        }
    }
    
    @Override
    public String toString() {
        String lista = "";
        for (String ikoni : ikonikuvat) {
            lista += ikoni+",";
        }
        return lista;
    }
    
  
}
