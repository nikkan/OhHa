
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * LuoPelikentta-luokassa luodaan uusi halutun kokoinen muistipelikenttä.
 * Tällä hetkellä kentän koko on fiksattu 2x2.
 * 
 */

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import muistipeli.sovelluslogiikka.Kortti;
import muistipeli.sovelluslogiikka.Muistipelikortit;


public class Pelikentta {
    
    private JPanel pelikentta;
    private JPanel korttipohja;
    private Muistipelikortit kortit;
    private ArrayList<String> ikonit;
    private HashMap<JButton, String> korttilista;
    private ArrayList<Kortti> korttilista2; // TESTIITESTII!
    private int koko;
    private GridBagConstraints gbc;
    private JPanel paneli;
    private Kortti kortti; // tESTIITESTII
    
    public Pelikentta(int koko, JPanel paneli) {
        this.koko = koko;
        this.kortit = new Muistipelikortit(this.koko);
        this.ikonit = kortit.annaIkonit();
        this.korttilista = new HashMap<JButton, String>();
        this.korttilista2 = new ArrayList<Kortti>();  // TESTIITESTIILISÄTTY!
        this.gbc = new GridBagConstraints();
        this.paneli = paneli;
        this.pelikentta = new JPanel(new GridLayout(1,1));
  
       
        //luoKortit(pelikentta);
        pelikentta.setMaximumSize(new Dimension(400, 400));
        pelikentta.setMinimumSize(new Dimension(400, 400));
        pelikentta.setPreferredSize(new Dimension(400, 400));
        pelikentta.setBackground(Color.WHITE);
        
  
        // GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(2,2,2,2);
        
        this.korttipohja = new JPanel(new GridLayout(this.koko,this.koko));
        luoKortit(korttipohja);
        this.pelikentta.add(korttipohja);
        
        this.paneli.add(pelikentta, gbc);
    
    }
    
    /* Metodi palauttaa HashMap:ssä pelilaudan kortit (ts. JButtonit) ja
     * korttien kääntöpuolet (ImageIconit) */
    public HashMap<JButton, String> getKorttilista() {
        return this.korttilista;
    }
    
    public ArrayList<Kortti> getKorttilista2() {
        return this.korttilista2;
    }
    
    public JPanel getPelikentta() {
        return this.pelikentta;
    }
    
    /* Metodi palauttaa ArrayList:ssä korttien kuvapuolten ImageIconit */
    public Muistipelikortit getMuistipelikortit() {
        return this.kortit;
    }
    
    public JPanel getKorttipohja() {
        return this.korttipohja;
    }
    
    public int getKoko() {
        return this.koko;
    }
    
    public JPanel getUusiPeli(int uusiKoko) {
        this.koko = uusiKoko;
        this.kortit = new Muistipelikortit(this.koko);
        this.ikonit = kortit.annaIkonit();
        this.korttilista = new HashMap<JButton, String>();
       
        this.korttipohja = new JPanel(new GridLayout(this.koko,this.koko));
        luoKortit(korttipohja);
        //this.pelikentta.add(testi);
        
        return korttipohja;
        
        
    }
    
   
    /* luoKortit() -metodi luo muistipelikortteina toimivat JButtonit.*/
    private JPanel luoKortit(JPanel paneeli) {
        
        for (int i=0; i<this.koko*this.koko; i++) {
            if (kortit.onkoKuvia() == true) {
                ImageIcon kaantopuoli = new ImageIcon(ikonit.get(this.koko*this.koko));
                ImageIcon kuvapuoli = new ImageIcon(ikonit.get(i));
                Kortti k = new Kortti(kuvapuoli, kaantopuoli);
                paneeli.add(k);
                this.korttilista2.add(k);
                
            } else {
                Kortti k = new Kortti(ikonit.get(i));
                paneeli.add(k);
                this.korttilista2.add(k);
            }
             
        }
            return this.paneli;
        }
        
        /*for (int i=0; i<this.koko*this.koko; i++) { 
            if (kortit.onkoKuvia() == true) {
                ImageIcon kuva = new ImageIcon(ikonit.get(this.koko*this.koko)); 
                JButton b = new JButton(kuva); 
                ImageIcon kuva2 = new ImageIcon(ikonit.get(i)); 
                b.setFocusPainted(false);
                b.setDisabledIcon(kuva2);
                b.setHorizontalAlignment(SwingConstants.CENTER);
                b.setVerticalAlignment(SwingConstants.CENTER);
                // b.setPreferredSize(new Dimension(2,2));
                b.setBorder(new LineBorder(Color.BLACK, 1));
                //b.setMargin(new Insets(0, 0, 0, 0));
                this.korttilista.put(b, ikonit.get(i));
                paneeli.add(b); 
            } else {
                JButton b = new JButton("");
                //ImageIcon kuva2 = new ImageIcon(ikonit.get(i)); 
                b.setFocusPainted(false);
           
                //b.setDisabledIcon(kuva2);
                b.setHorizontalAlignment(SwingConstants.CENTER);
                b.setVerticalAlignment(SwingConstants.CENTER);
                // b.setPreferredSize(new Dimension(2,2));
                b.setBorder(new LineBorder(Color.BLACK, 1));
                //b.setMargin(new Insets(0, 0, 0, 0));
                this.korttilista.put(b, ikonit.get(i));
                paneeli.add(b); 
            }
      
           
        } return paneeli;
    }*/
}
