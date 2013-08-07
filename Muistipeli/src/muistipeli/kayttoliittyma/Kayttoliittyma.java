
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * KESKEN VIELÄ. EI PISTEIDEN LASKUA YMS. TOIMINNASSA + FIKSATTU KENTÄN
 * KOKO YMS.
 * 
 * 
 * @author Anu Nikkanen
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


public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private ArrayList<String> ikonit = new ArrayList<String>();
    private HashMap<JButton, String> napit = new HashMap<JButton, String>();
    //private Muistipelikortit kortit;
    
   
    public Kayttoliittyma() {
        
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
        
      
        JLabel ylateksti = new JLabel("<html><p>Tervetuloa pelaamaan hienoa muistipeliäni!<br />"
                + "Voit kääntää kerrallaan kaksi korttia - yritä löytää parit.<br />"
                + "Kun olet löytänyt kaikki parit, peli päättyy.</p></html>"); // tämä johonkin muualle "hae ohjeet"
        ylateksti.setOpaque(true);
        ylateksti.setBackground(Color.yellow);

        container.add(ylateksti, BorderLayout.NORTH);
        
        this.ikonit.add("src/kuvat/ikoni1.gif"); // nämä pitää generoida toisella tavalla (luetaan tiedostosta/listasta,
        this.ikonit.add("src/kuvat/ikoni2.gif"); // jossa kuvat ovat, seuraava kuvatiedoston nimi), kortit ovat listassa
        this.ikonit.add("src/kuvat/ikoni2.gif"); // sekoitettuna
        this.ikonit.add("src/kuvat/ikoni3.gif"); // ja tietysti kuvat ja koko käyttöliittymä pitää vielä laittaa kuntoon
        this.ikonit.add("src/kuvat/ikoni3.gif");
        this.ikonit.add("src/kuvat/ikoni4.gif");
        this.ikonit.add("src/kuvat/ikoni4.gif");
        container.add(luoNappaimet());
        
        JLabel alateksti = new JLabel("Alatekstikenttä");
        container.add(alateksti);
       
        KlikkaustenKuuntelija kuuntelija = new KlikkaustenKuuntelija(napit, alateksti);
        for (JButton nappi : napit.keySet()) {
            nappi.addActionListener(kuuntelija);
        }
    }
    
    
    private JPanel luoNappaimet() {
        JPanel panel = new JPanel(new GridLayout(2,3));
        panel.setMaximumSize(new Dimension(200, 200));
        
        for (int i=0; i<6; i++) {
            ImageIcon kuva = new ImageIcon(ikonit.get(0)); // lisää virheiden tarkistus + tarkista logiikka
            JButton b = new JButton(kuva);                  // kun kuvien lähde oikea
            ImageIcon kuva2 = new ImageIcon(ikonit.get(i+1)); 
            b.setDisabledIcon(kuva2);
            b.setPreferredSize(new Dimension(2,2));
            b.setBorder(new LineBorder(Color.BLACK, 2));
            this.napit.put(b, ikonit.get(i+1));
            panel.add(b); 
        } return panel;
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    
}
