
package muistipeli.sovelluslogiikka;

import java.util.Random;

/**
 * Ohjelmoinnin jatkokurssi, syksy 2013
 * VIELÄ HYYYYVIN ALKUVAIHEESSA, LÄHINNÄ OMAA TESTAILUA...
 * 
 * @author anunikkanen
 */
public class KorttienSekoittaja {
    public static void main(String[] args) {
        // HUOM!! VIELÄ HYVIN AJATUKSEN TASOLLA!!!
        // idea: kortit ovat tallennettuna esim. talukkoon,
        // josta luodaan "sekoitettu matriisi". Tämä matriisi toimii sitten 
        // graafisen käyttöliittymän gridirakenteen/korttien pohjana
        
        int[] taulukkoA = {1,1,2,2,3,3,4,4,5,5,6,6};
        // luodaan Random-objekti:
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
        
        // metodi testaamista varten..
        System.out.println("taulukko nyt: ");
        for (int t=0; t<12; ++t) {
            System.out.println(taulukkoA[t]);
        }
         
    }

    
}
