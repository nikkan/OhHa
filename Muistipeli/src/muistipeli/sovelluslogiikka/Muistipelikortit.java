
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
    
    private ArrayList<String> ikonikuvat;
    //private ArrayList<Integer> ikoninumerot;
    private String kaantopuoli;
    private boolean onkoMahdollinen, onkoKuvia;
    private Scanner tl;
    File t;
    
    /*public Muistipelikortit() {
        this.ikonikuvat = new ArrayList<String>();
        this.tl = null;
    }*/
    
    /* Luokan konstruktori hakee tiedostosta oikean kokoisen muistipelin korttien tiedot 
    /*ja tallentaa ne ArrayListiin.*/
    public Muistipelikortit(int koko) {
        if (this.haeIkonitTiedostosta(koko) == false ) {
            this.ikonikuvat = new ArrayList<String>();
            int lkm = 0;
            if (koko == 2) {
                lkm = 2;
            } else if (koko == 4) {
                lkm = 16;
            } else {
                lkm = 36;
             
            }
            for (int i=0; i<lkm; ++i) {
                    this.ikonikuvat.add(""+i+"");
                    this.ikonikuvat.add(""+i+"");
            } this.onkoMahdollinen = true;
            this.onkoKuvia = false;
            this.kaantopuoli = " ";
            System.out.println("ikonit:"+ikonikuvat.toString());
               
           } else {
                this.onkoMahdollinen = false;
            }
        }

       
        /* if (tarkistaKoko(koko) == true) {
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
            this.kaantopuoli = "src/muistipeli/kuvat/nurjapuoli.gif";
        } else {
            System.out.println("Pelikentän koko ei ole mahdollinen.");
        }*/
    
    
    private boolean haeIkonitTiedostosta(int koko) {
        this.ikonikuvat = new ArrayList<String>(); 
            this.tl = null;
            this.t = new File("src/muistipeli/pelikentat/kortit"+koko+".txt");
            try {
                this.tl = new Scanner(t);
            } catch (Exception poikkeus) {
                System.out.println("Tiedostoa ei voitu lukea. Virhe: " + poikkeus.getMessage() ); // mihin ohjataan?
                return false;
            } while (this.tl.hasNextLine()) {
                String rivi = this.tl.nextLine();
                this.ikonikuvat.add(rivi);
                this.ikonikuvat.add(rivi);
            }  
            this.tl.close();
            this.onkoMahdollinen = true;
            this.onkoKuvia = true;
            return true; 
    }
    
    /* Metodi lisää listaan uuden ikonin*/
    private void lisaaIkoni(String ikoni) {
        this.ikonikuvat.add(ikoni);
    }
    
    public boolean onkoKokoMahdollinen() {
        return this.onkoMahdollinen;
    }
    
    public boolean onkoKuvia() {
        return this.onkoKuvia;
    }
    
    ///public String getKaantopuoli() {
       // return this.kaantopuoli;
    //}
    
    /*Metodi tarkistaa, onko pyydetyn muistipelin koko validi.*/
    /*public boolean tarkistaKoko(int annettuKoko) {
        if (annettuKoko == 2 || annettuKoko == 4 || annettuKoko == 6) {
            return true;
        } return false; 
    }*/
    
    /* Metodi palauttaa listallisen ikoneita halutun kokoiseen muistipeliin.*/
    public ArrayList<String> annaIkonit() {
        sekoitaKortit();
        if (this.onkoKuvia == true) {
            lisaaKaantopuoli();
        } 
        return this.ikonikuvat;
    }
    
    /*Tirasta tuttu sekoitusalgoritmi sekoittaa muistikorttipakan, jotta
    /*pelilauta on joka kerta erilainen.*/
    private void sekoitaKortit() {
        Random satunnaisluku = new Random();
      
        for (int j=ikonikuvat.size()-1; j>=1; j--) {
            int s = satunnaisluku.nextInt(ikonikuvat.size()); 
            String apu = ikonikuvat.get(j);
            ikonikuvat.set(j, ikonikuvat.get(s));
            ikonikuvat.set(s, apu);
        }
    }
    
    private boolean lisaaKaantopuoli() {
        try {
            this.kaantopuoli = "src/muistipeli/kuvat/nurjapuoli.gif";
            this.ikonikuvat.add(kaantopuoli);
        } catch (Exception poikkeus) {
            System.out.println("Kuvatiedostoa ei löytynyt. Virhe: "+ poikkeus.getMessage());
            this.ikonikuvat.add(kaantopuoli);
            return false;
           
        }
        return true;
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
