
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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import muistipeli.sovelluslogiikka.Muistipelikortit;


public class LuoPelikentta {
    
    private JPanel pelikentta;
    private Muistipelikortit kortit;
    private ArrayList<String> ikonit;
    private HashMap<JButton, String> korttilista;
    private int koko;
    private GridBagConstraints gbc;
    private JPanel paneli;
    
    public LuoPelikentta(int koko, JPanel paneli) {
        this.koko = koko;
        this.kortit = new Muistipelikortit(this.koko);
        this.ikonit = kortit.annaIkonit();
        this.korttilista = new HashMap<JButton, String>();
        this.gbc = new GridBagConstraints();
        this.paneli = paneli;
        
        pelikentta = new JPanel(new GridLayout(2,2));
        
        luoKortit(pelikentta);
        pelikentta.setMaximumSize(new Dimension(400, 400));
        pelikentta.setMinimumSize(new Dimension(400, 400));
        pelikentta.setPreferredSize(new Dimension(400, 400));
  
        // GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(2,2,2,2);
        
        this.paneli.add(pelikentta, gbc);
    
    }
    
    /* Metodi palauttaa HashMap:ssä pelilaudan kortit (ts. JButtonit) ja
     * korttien kääntöpuolet (ImageIconit) */
    public HashMap<JButton, String> getKorttilista() {
        return this.korttilista;
    }
    
    /* Metodi palauttaa ArrayList:ssä korttien kuvapuolten ImageIconit */
    public Muistipelikortit getMuistipelikortit() {
        return this.kortit;
    }
    
   
    /* luoKortit() -metodi luo muistipelikortteina toimivat JButtonit.*/
    private JPanel luoKortit(JPanel paneeli) {
        
        for (int i=0; i<this.koko*2; i++) { 
            ImageIcon kuva = new ImageIcon(ikonit.get(this.koko*2)); 
            JButton b = new JButton(kuva);                  
            ImageIcon kuva2 = new ImageIcon(ikonit.get(i)); 
            b.setDisabledIcon(kuva2);
            b.setPreferredSize(new Dimension(2,2));
            b.setBorder(new LineBorder(Color.BLACK, 2));
            this.korttilista.put(b, ikonit.get(i));
            paneeli.add(b); 
        } return paneeli;
    }
}
