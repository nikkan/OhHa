
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * KESKEN VIELÄ. EI PISTEIDEN LASKUA YMS. TOIMINNASSA + FIKSATTU KENTÄN
 * KOKO YMS.
 * 
 * 
 * @author Anu Nikkanen
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
//import muistipeli.sovelluslogiikka.Muistipelikortit;
//import muistipeli.sovelluslogiikka.OmaPistelaskuri;

        
public class KlikkaustenKuuntelija implements ActionListener {
    private HashMap<JButton, String> napit;
    private int kierros;
    private JButton ekaNappi;
    private JButton tokaNappi;
    private String lahde1;
    private String lahde2;
    private JLabel alateksti;
          
    
    public KlikkaustenKuuntelija(HashMap<JButton, String> yksi, JLabel alapalkki) { // tarvitseeko tälle välittää pistelaskuri?
        this.napit = yksi;
        this.kierros = 0;
        this.lahde1 = " "; // vakioksi tjms?
        this.lahde2 = " ";        
        this.alateksti = alapalkki;
        //this.laskin = laskuri;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        System.out.println("kierros: "+kierros);
        
        
        if (kierros == 2 && onkoPari() == false) { // saisiko tätä vielä järkeistettyä ja vähennettyä copypastea?
            ekaNappi.setEnabled(true);
            tokaNappi.setEnabled(true);
            kierros = 0;
            this.lahde1 = " ";
            this.lahde2 = " ";
        }
        
        if (kierros == 2 && onkoPari() == true) {
            //n.setEnabled(false);
            //m.setEnabled(false);
            this.lahde1 = " ";
            this.lahde2 = " ";
            kierros = 0;
        } 
        
        for (JButton jButton : napit.keySet()) {
                if (ae.getSource() == jButton ) {
                    jButton.setEnabled(false);
                    tallenna(this.napit.get(jButton), jButton);
                    kierros++;  
                }
          
        } 
        // muualle? esim. laskuri-luokkaan tarkistusmetodi?
        int laskuri = 0;
        for (JButton j : napit.keySet()) {
            if (j.isEnabled() == false ) {
                laskuri++;
            }
            
        } if (laskuri == 6) {
            this.alateksti.setText("Wohoo!");
            
        }
        
        
     
    }
    
    // NÄMÄ PITÄÄ SAADA TÄÄLTÄ POIS!?
    public void tallenna(String tiedosto, JButton nappi) {
        if (this.lahde1.equals(" ")) {
            this.lahde1 = tiedosto;
            this.ekaNappi = nappi;
        } else {
            this.lahde2 = tiedosto;
            this.ekaNappi = nappi;     
        }
        
    }
    
    public boolean onkoPari() {
        if (this.lahde1.equals(this.lahde2)) {
            return true;
        } return false;  
        
    }
    
}
