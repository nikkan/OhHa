
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * 
 * @author Anu Nikkanen
 * 
 * Kayttoliittyma-luokassa luodaan käyttöliittymäkomponentit.
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.LineBorder;
import muistipeli.sovelluslogiikka.Muistipelikortit;
import muistipeli.sovelluslogiikka.Pelilauta;


public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private ArrayList<String> ikonit = new ArrayList<String>();
    private HashMap<JButton, String> napit = new HashMap<JButton, String>();
    private Muistipelikortit kortit;
    private Pelilauta peli;
    
    public Kayttoliittyma(Muistipelikortit pelikortit) {
        this.kortit = pelikortit;
        this.peli = new Pelilauta();
    }

    @Override
    public void run() {
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(400, 400));   
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(3,1));
        
        JLabel ylateksti = new JLabel(peli.annaOhjeet()); 
        ylateksti.setOpaque(true);
        ylateksti.setBackground(Color.yellow);
        container.add(ylateksti, BorderLayout.NORTH);
        
        this.ikonit = kortit.annaIkonit();
      
        container.add(luoNappaimet());
        
        JLabel alateksti = new JLabel(" ");
        container.add(alateksti);
       
        KlikkaustenKuuntelija kuuntelija = new KlikkaustenKuuntelija(napit, alateksti);
        for (JButton nappi : napit.keySet()) {
            nappi.addActionListener(kuuntelija);
        }
    }
    
    // luoNappaimet() -metodi luo muistipelikortteina toimivat JButtonit.
    // Tarkoitus on siirtää osa nyt metodin sisällä olevasta koodista omaan luokkaan tai
    // pelilauta -luokkaan. Metodista puuttuu myös vielä esim. virheiden tarkistus.
    private JPanel luoNappaimet() {
        JPanel panel = new JPanel(new GridLayout(2,3));
        panel.setMaximumSize(new Dimension(200, 200));
        
        for (int i=0; i<6; i++) { // tämä pitää tehdä muualla -> pelikentän koko vaihtelee
            ImageIcon kuva = new ImageIcon(ikonit.get(6)); 
            JButton b = new JButton(kuva);                  
            ImageIcon kuva2 = new ImageIcon(ikonit.get(i)); 
            b.setDisabledIcon(kuva2);
            b.setPreferredSize(new Dimension(2,2));
            b.setBorder(new LineBorder(Color.BLACK, 2));
            this.napit.put(b, ikonit.get(i));
            panel.add(b); 
        } return panel;
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    
}
