
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * VIELÄ HYYYYVIN ALKUVAIHEESSA, LÄHINNÄ OMAA TESTAILUA...
 * 
 * @author Anu Nikkanen
 */


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private JButton yksi, kaksi, kolme, nelja;
    
    public Kayttoliittyma() {
        
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
        
        KlikkaustenKuuntelija kuuntelija = new KlikkaustenKuuntelija(this.yksi, this.kaksi, this.kolme, this.nelja);
        this.yksi.addActionListener(kuuntelija);
        this.kaksi.addActionListener(kuuntelija);
        this.kolme.addActionListener(kuuntelija);
        this.nelja.addActionListener(kuuntelija);  
    }
    
    private JPanel luoNappaimet() {
        JPanel panel = new JPanel(new GridLayout(3,3));
        panel.add(this.yksi = new JButton(" ")); // pystyisikö näille antamaan arvoja muualta?
        panel.add(this.kaksi = new JButton(" "));
        panel.add(this.kolme = new JButton(" "));
        panel.add(this.nelja = new JButton(" "));
        
        return panel;
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    
}

