
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * Kayttoliittyma-luokassa luodaan käyttöliittymä muistipelille.
 * 
 * 
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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

    
    public Kayttoliittyma() {
        this.kortit = new Muistipelikortit(3);
        this.peli = new Pelilauta();
    }

    @Override
    public void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame(" Muistipeli ");
        frame.setPreferredSize(new Dimension(400, 400));   
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    
    // Metodi luo käyttöliittymäkomponentit muistipelille.
    private void luoKomponentit(Container container) {
        /*UUTTA GUITA TULOSSA!
        JPanel totalGUI = new JPanel();
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        // OTSIKKOPALKKI //
        JPanel otsikkopalkki = new JPanel();
        otsikkopalkki.setOpaque(true);
        otsikkopalkki.setBackground(Color.black);
        JLabel otsikko = new JLabel("HIPSTERIMUISTIPELI");
        Font font = new Font("Arial", Font.BOLD, 18);
        otsikko.setFont(font);
        otsikko.setForeground(Color.white);
        otsikkopalkki.add(otsikko);
        // GBC:
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 5;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(1,1,1,1);
        c.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(otsikkopalkki, c);
        
        // OHJEPALKKI //
        JPanel ohjepalkki = new JPanel();
        ohjepalkki.setMinimumSize(new Dimension(150, 150));
        ohjepalkki.setPreferredSize(new Dimension(150, 150));
        JLabel ohjeet = new JLabel( "<html><p><br />Tervetuloa pelaamaan hipsterimuistipeliä!<br /><br />"
                + "Voit kääntää kerrallaan kaksi korttia - yritä löytää parit.<br />"
                + "Mikäli et löydä paria, kortit kääntyvät <br />"
                + "nurin päin kun klikkaat seuraavaa korttia.<br />"
                + "Kun olet löytänyt kaikki parit, peli <br />"
                + "päättyy ja näet loppupisteesi.</p></html>" );
        ohjepalkki.add(ohjeet);
        // GBC:
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(2,2,2,2);
        
        mainPanel.add(ohjepalkki, c);
        
        // MYSCOREPALKKI //
        JPanel score = new JPanel(new GridLayout(6, 1));
        score.setOpaque(true);
        score.setBackground(Color.pink);
        JLabel yourScore = new JLabel("Pisteesi: \n70");
        score.add(yourScore);
        JButton tallennaPisteet = new JButton("Tallenna pisteet");
        score.add(tallennaPisteet);
        JLabel annaNimimerkki = new JLabel("Anna nimimerkkisi");
        score.add(annaNimimerkki);
        JTextField nimimerkki = new JTextField();
        score.add(nimimerkki);
        JButton okNappi = new JButton("OK");
        score.add(okNappi);
        //GBC:
        c.gridx = 3;
        c.gridy = 1;
        c.gridheight = 2;
        c.insets = new Insets(2,0,0,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        
        mainPanel.add(score, c);
        
        // TOP10SCORE //
        JPanel top10 = new JPanel();
        top10.setOpaque(true);
        top10.setBackground(Color.pink);
        JLabel topscore = new JLabel("<html><p><br />TOP 10 SCORE<br /><br />1. Aku Ankka\t1000<br /><br />"
                + "2. Iines Ankka\t900<br /><br />"
                + "3. Hessu Hopo\t800 <br /><br />"
                + "4. Roope Ankka\t700<br /><br />"
                + "5. Tupu\t500 <br /><br />"
                + "6. Lupu\t400 <br /><br />"
                + "</p></html>");
        top10.add(topscore);
        // GBC:
        c.gridx = 3;
        c.gridy = 2;
        c.gridheight = 2;
        c.insets = new Insets(2,0,0,0);
        c.fill = GridBagConstraints.BOTH;
        
        mainPanel.add(top10, c);
        
        // PELIKENTTA //
        JPanel pelikentta = new JPanel(new GridLayout(2,2));
        pelikentta.setMaximumSize(new Dimension(400, 400));
        pelikentta.setMinimumSize(new Dimension(400, 400));
        pelikentta.setPreferredSize(new Dimension(400, 400));
       
        ImageIcon testikuva = new ImageIcon("src/muistipeli/kuvat/viikset.gif");
        JButton nappi1 = new JButton(testikuva);
        ImageIcon lasit = new ImageIcon("src/muistipeli/kuvat/lasit.gif");
        JButton nappi2 = new JButton(lasit);
        ImageIcon omppu = new ImageIcon("src/muistipeli/kuvat/omppu.gif");
        JButton nappi3 = new JButton(omppu);
        JButton nappi4 = new JButton(testikuva);
        
        pelikentta.add(nappi1);
        pelikentta.add(nappi2);
        pelikentta.add(nappi3);
        pelikentta.add(nappi4);
        
        // GBC:
        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(2,2,2,2);
     
        mainPanel.add(pelikentta, c);
        
        // ALAPALKKI // 
        JPanel alapalkki = new JPanel();
        JButton uusipeli1 = new JButton("Uusi peli 2x2");
        JButton uusipeli2 = new JButton("Uusi peli 4x4");
        JButton uusipeli3 = new JButton("Uusi peli 8x8");
        JButton lopeta = new JButton("Lopeta pelaaminen");
        
        alapalkki.add(uusipeli1);
        alapalkki.add(uusipeli2);
        alapalkki.add(uusipeli3);
        alapalkki.add(lopeta);
        
        // GBC:
        c.gridy = 5;
        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 5;
        c.insets = new Insets(2,2,2,2);
        mainPanel.add(alapalkki, c);
        
        totalGUI.add(mainPanel);
        totalGUI.setOpaque(true);
        container.add(totalGUI);
        */
        
        container.setLayout(new GridLayout(3,1));
        
        JMenuBar menu = new JMenuBar();
      
        JLabel ylateksti = new JLabel(peli.annaOhjeet()); 
        ylateksti.setOpaque(true);
        ylateksti.setBackground(Color.yellow);
        container.add(ylateksti, BorderLayout.NORTH);
        
        this.ikonit = kortit.annaIkonit();
      
        container.add(luoNappaimet());
        
        JPanel alakentta = new JPanel(new GridLayout(3,2));
        JLabel alateksti = new JLabel(" ");
        JButton tallennapisteet = new JButton("Tallenna pisteet");
        JLabel annaNimimerkki = new JLabel("Anna nimimerkki");
        JTextField tekstikentta = new JTextField();
        JLabel tyhjakentta = new JLabel(" ");
        JButton ok = new JButton("OK");
        alakentta.add(alateksti);
        alakentta.add(tallennapisteet);
        tallennapisteet.setVisible(false);
        alakentta.add(annaNimimerkki);
        annaNimimerkki.setVisible(false);
        alakentta.add(tekstikentta);
        tekstikentta.setVisible(false);
        alakentta.add(tyhjakentta);
        alakentta.add(ok);
        ok.setVisible(false);
        
        container.add(alakentta);
       
        KlikkaustenKuuntelija kuuntelija = new KlikkaustenKuuntelija(napit, alateksti);
        for (JButton nappi : napit.keySet()) {
            nappi.addActionListener(kuuntelija);
        }
    }
    
    // luoNappaimet() -metodi luo muistipelikortteina toimivat JButtonit.
    // Tarkoitus on siirtää osa nyt metodin sisällä olevasta koodista omaan luokkaan tai
    // pelilauta -luokkaan. Metodista puuttuu vielä virheiden tarkistus.
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
