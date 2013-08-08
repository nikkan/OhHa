
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * 
 * @author Anu Nikkanen
 * 
 * KlikkaustenKuuntelija toteuttaa kuhunkin muistipelikorttiin sidottavat
 * toiminnot. Tällä hetkellä actionPerformed-metodi on liian mammuttimainen;
 * vastuuta tulee siirtää esim. Pelilauta-oliolle sovelluslogiikka-pakettiin.
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;

        
public class KlikkaustenKuuntelija implements ActionListener {
    private HashMap<JButton, String> napit;
    private int kierros;
    private JButton ekaNappi;
    private JButton tokaNappi;
    private String lahde1;
    private String lahde2;
    private JLabel alateksti;
    private final String TYHJA;
          
    
    public KlikkaustenKuuntelija(HashMap<JButton, String> map, JLabel alapalkki) { 
        this.napit = map;
        this.kierros = 0;
        this.TYHJA = " ";
        this.lahde1 = this.TYHJA; 
        this.lahde2 = this.TYHJA;        
        this.alateksti = alapalkki;
        //this.laskin = laskuri;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (kierros == 2 && onkoPari() == false) { // copypastea pitää vielä vähentää
            ekaNappi.setEnabled(true);
            tokaNappi.setEnabled(true);
            kierros = 0;
            this.lahde1 = this.TYHJA;
            this.lahde2 = this.TYHJA;
        }
        
        if (kierros == 2 && onkoPari() == true) {
            this.lahde1 = this.TYHJA;
            this.lahde2 = this.TYHJA;
            kierros = 0;
        } 
        
        for (JButton jButton : napit.keySet()) {
                if (ae.getSource() == jButton ) {
                    jButton.setEnabled(false);
                    tallenna(this.napit.get(jButton), jButton);
                    kierros++;  
                }
        } 
        
        // Tällaiset pätkät ainakin muualle!
        int laskuri = 0;
        for (JButton j : napit.keySet()) {
            if (j.isEnabled() == false ) {
                laskuri++;
            }
            
        } if (laskuri == 6) {
            this.alateksti.setText("Wohoo!");
            
        }
        
    }
    
    // NÄMÄ PITÄÄ SIIVOTA TÄÄLTÄ POIS 
    public void tallenna(String tiedosto, JButton nappi) {
        if (this.lahde1.equals(this.TYHJA)) {
            this.lahde1 = tiedosto;
            this.ekaNappi = nappi;
        } else {
            this.lahde2 = tiedosto;
            this.tokaNappi = nappi;     
        }
        
    }
    
    public boolean onkoPari() {
        if (this.lahde1.equals(this.lahde2)) {
            return true;
        } return false;  
        
    }
    
}
