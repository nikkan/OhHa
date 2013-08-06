
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * VIELÄ HYYYYVIN ALKUVAIHEESSA, LÄHINNÄ OMAA TESTAILUA...
 * 
 * @author Anu Nikkanen
 */


// importtaa tarvittavat luokat, esim. import sovelluslogiikka.jotakin;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import muistipeli.sovelluslogiikka.Muistipelikortit;


public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private JButton yksi, kaksi, kolme, nelja; 
    private Muistipelikortit kortit;
    
   
    public Kayttoliittyma(Muistipelikortit pelilauta) {
        this.kortit = pelilauta;
    }

    @Override
    public void run() {
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(400, 400));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(3,1));
        
        JLabel ylateksti = new JLabel("Ylätekstikenttä");
        container.add(ylateksti, BorderLayout.NORTH);
        
        container.add(luoNappaimet());
        
        JLabel alateksti = new JLabel("Alatekstikenttä");
        container.add(alateksti);
        
        KlikkaustenKuuntelija kuuntelija = new KlikkaustenKuuntelija(this.kortit, this.yksi, this.kaksi, this.kolme, this.nelja);
        this.yksi.addActionListener(kuuntelija); // copypastea?
        this.kaksi.addActionListener(kuuntelija);
        this.kolme.addActionListener(kuuntelija);
        this.nelja.addActionListener(kuuntelija);  
        
        // huom! lisää se 'set resizable false'-juttu!!
    }
    
    private JPanel luoNappaimet() {
        JPanel panel = new JPanel(new GridLayout(3,3)); // pystyisikö tämän panelin välittämään; ei jokaista erikseen?
       
        panel.add(this.yksi = new JButton(kortit.annaKaantopuoli(0, 1))); // copypastea?
        panel.add(this.kaksi = new JButton(kortit.annaKaantopuoli(0, 1)));
        panel.add(this.kolme = new JButton(kortit.annaKaantopuoli(1, 0)));
        panel.add(this.nelja = new JButton(kortit.annaKaantopuoli(1, 1)));
        
        return panel;
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    
}
