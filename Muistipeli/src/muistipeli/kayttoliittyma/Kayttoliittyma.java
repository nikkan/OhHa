
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * Kayttoliittyma-luokassa luodaan muistipelin käyttöliittymäkomponentit.
 * 
 */

import java.awt.Container;
import java.awt.GridBagLayout;
import javax.swing.*;
import muistipeli.sovelluslogiikka.Pistelista;


public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Pistelista plista;
    private JPanel mainPanel;
    
    /* Luokan parametriton konstruktori */
    public Kayttoliittyma() {
        this.plista = new Pistelista("src/muistipeli/pisteet.txt");
    }

    @Override
    public void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("Muistipeli");  
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    
    /* Luodaan käyttöliittymäkomponentit GridBagLayoutia hyödyntäen */
    private void luoKomponentit(Container container) {
      
        JPanel totalGUI = new JPanel();
        mainPanel = new JPanel(new GridBagLayout());
        
        // Luodaan mainPanelin sisälle tulevat palkit 
        LuoOtsikkopalkki otsikkopalkki = new LuoOtsikkopalkki(mainPanel);
        LuoOhjepalkki ohjepalkki = new LuoOhjepalkki(mainPanel);
        LuoPistepalkki pistepalkki = new LuoPistepalkki(mainPanel);  
        LuoHighscorepalkki highscorepalkki = new LuoHighscorepalkki(mainPanel, this.plista);
        LuoPelikentta pelikentta = new LuoPelikentta(2, mainPanel);
        LuoAlapalkki alapalkki = new LuoAlapalkki(mainPanel);
    
        // Lisätään mainPanel kokonaisuuteen (totalGUI) ja totalGUI JFrameen 
        totalGUI.add(mainPanel);
        totalGUI.setOpaque(true);
        container.add(totalGUI);
        
        // Lisätään klikkaustenkuuntelija käyttöliittymäkomponenteille
        KlikkaustenKuuntelija kuuntelija = new KlikkaustenKuuntelija(pistepalkki, highscorepalkki, pelikentta, plista);
        
        // Muistipelikortit:
        for (JButton nappi : pelikentta.getKorttilista().keySet()) {
            nappi.addActionListener(kuuntelija);
        }
        
        // Muut:
        pistepalkki.getTallennaNappi().addActionListener(kuuntelija);
        pistepalkki.getOkNappi().addActionListener(kuuntelija);
       
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    
}
