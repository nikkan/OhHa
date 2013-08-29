
package muistipeli.kayttoliittyma;

import java.awt.Container;
import java.awt.GridBagLayout;
import javax.swing.*;
import muistipeli.sovelluslogiikka.Kortti;
import muistipeli.sovelluslogiikka.Pelitoiminnot;
import muistipeli.sovelluslogiikka.Pistelista;

/**
 * Kayttoliittyma-luokka vastaa Muistipelin graafisen käyttöliittymän
 * luomisesta ja välittämisestä pelaajalle. 
 * 
 * Kayttoliittyma implementoi Runnable-rajapinnan.
 * 
 * @author Anu N.
 */

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Pistelista pistelista;
    private JPanel mainPanel;
    private Pelitoiminnot pelitoiminnot;
    
    /**
     * Parametriton konstruktori luo uuden pistelistaolion, jolle annetaan
     * parametrina tekstitiedostoon tallennettu pistelistaus.
     */
    public Kayttoliittyma() {
        this.pistelista = new Pistelista("src/muistipeli/pisteet/pisteet.txt");
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
    
    /**
     * Luo käyttöliittymäkomponentit GridBagLayoutia hyödyntäen.
     *
     * @param container JFramen 'sisältöpaneeli' (ContentPane), johon käyttö-
     *                  liittymäkomponentit lisätään
     */
    private void luoKomponentit(Container container) {
        // Luodaan 'kokonaisGUI' -paneeli ja mainPanel -paneeli, jolle asetetaan
        // GridBagLayout
        JPanel kokonaisGUI = new JPanel();
        mainPanel = new JPanel(new GridBagLayout());
        
        // Luodaan mainPanelin sisälle tulevat komponentit ja lisätään ne mainPaneliin
        Otsikkopalkki otsikkopalkki = new Otsikkopalkki(mainPanel);
        Ohjepalkki ohjepalkki = new Ohjepalkki(mainPanel);
        Pistepalkki pistepalkki = new Pistepalkki(mainPanel);  
        Highscorepalkki highscorepalkki = new Highscorepalkki(mainPanel, this.pistelista);
        Pelikentta pelikentta = new Pelikentta(2, mainPanel); // default-aloituskentän koko on 2
        Alapalkki alapalkki = new Alapalkki(mainPanel);
        
        // luodaan uusi Pelitoiminnot-olio, joka välitetään parametrina kuuntelijoille
        this.pelitoiminnot = new Pelitoiminnot(pelikentta, pistepalkki);
    
        // Lisätään mainPanel totalGUI:hin ja totalGUI Containeriin
        kokonaisGUI.add(mainPanel);
        kokonaisGUI.setOpaque(true);
        container.add(kokonaisGUI);
        
        // Lisätään tapahtumankuuntelijat käyttöliittymäkomponenteille:
        
        // 1. Muistipelikortit
        KorttienKuuntelija kuuntelija = new KorttienKuuntelija(pelitoiminnot, pelikentta);
        
        for (Kortti kortti : pelikentta.getKorttilista()) {
            kortti.addActionListener(kuuntelija);
        }
        
        // 2. Pistepalkin napit
        PistepalkinKuuntelija ppk = new PistepalkinKuuntelija(pistepalkki, pistelista, highscorepalkki, pelitoiminnot);
        
        pistepalkki.getTallennaNappi().addActionListener(ppk);
        pistepalkki.getOkNappi().addActionListener(ppk);
        
        
        // 3. Alapalkin napit
        AlapalkinKuuntelija apk = new AlapalkinKuuntelija(pelitoiminnot, pelikentta, alapalkki, kuuntelija);
        
        alapalkki.get2x2().addActionListener(apk);
        alapalkki.get4x4().addActionListener(apk);
        alapalkki.get6x6().addActionListener(apk);
        alapalkki.getLopeta().addActionListener(apk);
       
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    
}
