
package muistipeli.kayttoliittyma;

/**
 * Luo muistipelille graafisen käyttöliittymän.
 * 
 * @author Anu Nikkanen
 */

import java.awt.Container;
import java.awt.GridBagLayout;
import javax.swing.*;
import muistipeli.sovelluslogiikka.Kortti;
import muistipeli.sovelluslogiikka.Pelitoiminnot;
import muistipeli.sovelluslogiikka.Pistelista;


public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Pistelista pistelista;
    private JPanel mainPanel;
    private Pelitoiminnot pelitoiminnot;
    
    /**
     * Parametriton konstruktori, luo uuden pistelistaolion. 
     */
    public Kayttoliittyma() {
        this.pistelista = new Pistelista("src/muistipeli/pisteet.txt");
    }

    @Override
    public void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("Muistipeli");  
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        //frame.setResizable(false);
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
      
        JPanel graafinenKayttoliittyma = new JPanel();
        mainPanel = new JPanel(new GridBagLayout());
        
        // Luodaan mainPanelin sisälle tulevat palkit 
        LuoOtsikkopalkki otsikkopalkki = new LuoOtsikkopalkki(mainPanel);
        LuoOhjepalkki ohjepalkki = new LuoOhjepalkki(mainPanel);
        Pistepalkki pistepalkki = new Pistepalkki(mainPanel);  
        Highscorepalkki highscorepalkki = new Highscorepalkki(mainPanel, this.pistelista);
        Pelikentta pelikentta = new Pelikentta(2, mainPanel);
        Alapalkki alapalkki = new Alapalkki(mainPanel);
        
        this.pelitoiminnot = new Pelitoiminnot(pelikentta, pistepalkki);
    
        // Lisätään mainPanel graafiseenKayttoliittymaan ja graafinenKayttoliittyma
        // containeriin
        graafinenKayttoliittyma.add(mainPanel);
        graafinenKayttoliittyma.setOpaque(true);
        container.add(graafinenKayttoliittyma);
        
        // Lisätään tapahtumankuuntelijat käyttöliittymäkomponenteille:
        
        // Muistipelikortit
        KorttienKuuntelija kuuntelija = new KorttienKuuntelija(pelitoiminnot, pelikentta);
        
        for (Kortti kortti : pelikentta.getKorttilista2()) {
            kortti.addActionListener(kuuntelija);
        }
        
        // Pistepalkin napit
        PistepalkinKuuntelija ppk = new PistepalkinKuuntelija(pistepalkki, pistelista, highscorepalkki, pelitoiminnot);
        
        pistepalkki.getTallennaNappi().addActionListener(ppk);
        pistepalkki.getOkNappi().addActionListener(ppk);
        
        
        // Alapalkin napit
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
