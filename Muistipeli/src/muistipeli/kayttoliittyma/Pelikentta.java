
package muistipeli.kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import muistipeli.sovelluslogiikka.Kortti;
import muistipeli.sovelluslogiikka.Ikonikuvat;

/**
 * Pelikentta-luokka vastaa halutun kokoisen muistipelikentän luomisesta ja 
 * lisäämisestä mainPaneliin graafiseen käyttöliittymään.
 * 
 * Luokka palauttaa getUusiPeli-metodin välityksellä myös uuden pelikentän.
 * 
 * @author Anu N.
 * 
 */

public class Pelikentta {
    
    private JPanel pelikentta;
    private JPanel tausta;
    private Ikonikuvat kortit;
    private ArrayList<String> ikonit;
    private ArrayList<Kortti> korttilista; 
    private int koko;
    private JPanel mainPanel;
    
    /**
     * Konstruktori luo muistipelikentän ja siihen sisältyvät kortit (=napit)
     * 
     * @param koko Kokonaisluku, joka kertoo halutun muistipelikentän koon.
     * @param mainPanel Paneli, johon muistipelikenttä lisätään 
     */
    public Pelikentta(int koko, JPanel mainPanel) {
        this.koko = koko;
        this.mainPanel = mainPanel;
         
        // luodaan uusi Muistipelikortit-olio, jolle annetaan parametrina koko
        this.kortit = new Ikonikuvat(this.koko);
        // haetaan ikonit eli muistipelikorttien kuvat
        this.ikonit = kortit.getIkonit();
        // luodaan lista, johon muistipelikortit tallennetaan
        this.korttilista = new ArrayList<Kortti>(); 
        // luodaan pelikenttä-paneli
        this.pelikentta = new JPanel(new GridLayout(1,1));
        // annetaan pelikentälle asetukset 
        this.pelikentta.setMaximumSize(new Dimension(400, 400));
        this.pelikentta.setMinimumSize(new Dimension(400, 400));
        this.pelikentta.setPreferredSize(new Dimension(400, 400));
        this.pelikentta.setBackground(Color.WHITE);
        
        // asetetaan GridBagConstraints
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(2,2,2,2);
        
        // luodaan tausta, johon kortit asetetaan
        this.tausta = new JPanel(new GridLayout(this.koko,this.koko));
        // luodaan kortit ja asetetaan ne tausta-paneliin
        this.luoKortit(this.tausta);
        // lisätään tausta pelikenttään
        this.pelikentta.add(this.tausta);
        // lisätään pelikenttä mainPaneliin
        this.mainPanel.add(this.pelikentta, c);
    
    }
     
    public ArrayList<Kortti> getKorttilista() {
        return this.korttilista;
    }
    
    public JPanel getPelikentta() {
        return this.pelikentta;
    }
    
    public Ikonikuvat getMuistipelikortit() {
        return this.kortit;
    }
    
    public JPanel getKorttipohja() {
        return this.tausta;
    }
    
    public int getKoko() {
        return this.koko;
    }
    
    /**
     * Palauttaa uuden pelin, eli taustapaneelin, johon on asetettu
     * halutun koon verran muistipelikortteja sekoitettuna.
     * 
     * @param uusiKoko Uuden muistipelikentän koko
     * @return JPanel tautapaneeli, johon uudet muistipelikortit on asetettu
     */
    public JPanel getUusiPeli(int uusiKoko) {
        this.koko = uusiKoko;
        this.kortit = new Ikonikuvat(this.koko);
        this.ikonit = kortit.getIkonit();
        this.tausta = new JPanel(new GridLayout(this.koko,this.koko));
        this.luoKortit(this.tausta);   
        return this.tausta;
    }
    
   
    /**
     * Luokan yksityinen metodi, joka lisää muistipelikortit taustaan. 
     * 
     * Metodi hakee kuvaikonit, jos ne löytyvät. Jos kuvia ei löydy, kuvapuoleksi
     * tulee numeroita.
     * 
     * @param paneeli Taustapaneeli, johon muistipelikortit (JButtonit) lisätään.
     */
    private void luoKortit(JPanel paneeli) {
        
        for (int i=0; i<this.koko*this.koko; i++) {
            // Jos kuvapuolet löytyy, haetaan ja asetetaan ikonit kortin oikealle
            // ja nurjalle puolelle. Lisätään kortti taustapaneeliin ja korttilistaan.
            if (kortit.onkoKuvia() == true) {
                ImageIcon kaantopuoli = new ImageIcon(ikonit.get(this.koko*this.koko));
                ImageIcon kuvapuoli = new ImageIcon(ikonit.get(i));
                Kortti k = new Kortti(kuvapuoli, kaantopuoli);
                paneeli.add(k);
                this.korttilista.add(k);
            // Jos kuvaikoneita ei löydy, lisätään numeroita 'kuviksi' ja lisätään
            // kortti taustapaneeliin ja korttilistaan.    
            } else {
                Kortti k = new Kortti(ikonit.get(i));
                paneeli.add(k);
                this.korttilista.add(k);
            }
             
        }
          
     }
       
}
