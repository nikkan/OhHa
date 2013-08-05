
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * VIELÄ HYYYYVIN ALKUVAIHEESSA, LÄHINNÄ OMAA TESTAILUA...
 * @author Anu Nikkanen
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import muistipeli.sovelluslogiikka.OmaPistelaskuri;
// muut omat importit...


public class KlikkaustenKuuntelija implements ActionListener {
   

    private JButton eka;
    private JButton toka;
    private JButton kolmas;
    private JButton neljas;
    private OmaPistelaskuri laskin;
    private int kierros;
   
    
    public KlikkaustenKuuntelija(JButton eka, JButton toka, JButton kolmas, JButton neljas) { // tarvitseeko tälle välittää pistelaskuri?
        this.eka = eka;
        this.toka = toka;
        this.kolmas = kolmas;
        this.neljas = neljas;
        this.kierros = 0;
        
        //this.laskin = laskuri;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (kierros == 2 ) {
            this.eka.setText(" ");
            this.toka.setText(" ");
            this.kolmas.setText(" ");
            this.neljas.setText(" ");
            this.kierros = 0;
        }
        
        
        if (ae.getSource() == this.eka) {
            this.eka.setText("böö");
            kasvataKierrosta();
           
        } else if (ae.getSource() == this.toka) {
            this.toka.setText("möö");
            kasvataKierrosta();
          
        } else if (ae.getSource() == this.kolmas) {
            this.kolmas.setText("böö");
            kasvataKierrosta();
    
        } else if (ae.getSource() == this.neljas) {
            this.neljas.setText("möö");
            kasvataKierrosta();
     
        }
    }
    
    public int kierrosTarkistin() {
        return this.kierros;
    }
    
    public void kasvataKierrosta() {
        this.kierros++; 
    }
    
    public void nollaaKierros() {
        this.kierros = 0;
    }
    
   
        
}
