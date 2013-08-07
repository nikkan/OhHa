
package muistipeli.sovelluslogiikka;

import java.util.Random;

/**
 * Ohjelmoinnin jatkokurssi, syksy 2013
 * SOVELLUKSEN LOGIIKKAA UUSITTU, TÄMÄN LUOKAN TARPEELLISUUS MIETINNÄSSÄ.
 * 
 * @author anunikkanen
 */
public class Muistipelikortit {

    
    private String[][] matriisi;
    private String[][] tyhja;
    
    public Muistipelikortit() {
        this.matriisi = new String[][] {{"1", "1"}, {"2", "2"}};  
        this.tyhja = new String[2][2];
        
        for (int t=0; t<tyhja.length; ++t) {
            for (int s=0; s<tyhja.length; ++s) {
                tyhja[t][s] = " ";
            }
        }
    }
    
    public String[][] annaPelilauta() {
        return this.matriisi;
    }

    public String annaKaantopuoli(int x, int y) {
        return this.tyhja[x][y];
    }
    
    public String annaOikeaPuoli(int x, int y) {
        return this.matriisi[x][y];
    }
   
    public void vaihdaArvoa(int x, int y) {
        this.tyhja[x][y] = this.matriisi[x][y];
    }
    
    
    /* KORTTIEN SEKOITTAMINEN:
        
        int[] taulukkoA = {1,1,2,2,3,3,4,4,5,5,6,6};
        // luo Random-objektin:
        Random satunnaisluku = new Random();
        
        
        for (int i=0; i<12; ++i) {
            System.out.println(taulukkoA[i]);
        }
        
        // randomize
        for (int j=taulukkoA.length-1; j>=1; j--) {
            int s = satunnaisluku.nextInt(taulukkoA.length-1+1) + 0; // järkeistä tämä!
            System.out.println("nextint: "+s);
            int apu = taulukkoA[j];
            taulukkoA[j] = taulukkoA[s];
            taulukkoA[s] = apu;
        }
        // testiprintti..
        System.out.println("taulukko nyt: ");
        for (int t=0; t<12; ++t) {
            System.out.println(taulukkoA[t]);
        }
         
    }*/
}
