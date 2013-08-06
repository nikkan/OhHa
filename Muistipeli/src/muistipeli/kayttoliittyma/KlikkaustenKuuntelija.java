
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * VIELÄ HYYYYVIN ALKUVAIHEESSA, LÄHINNÄ OMAA TESTAILUA...
 * @author Anu Nikkanen
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import muistipeli.sovelluslogiikka.Muistipelikortit;
import muistipeli.sovelluslogiikka.OmaPistelaskuri;

// TÄTÄ LUOKKAA PITÄÄ JÄRKEISTÄÄ; LIIKAA MUUTTUJIA JA TOISTOA!!! 
// LIIAN 'FIKSATTU' RATKAISU, PITÄÄ SAADA YLEISKÄYTTÖISEMMÄKSI JA
// SELKEÄMMÄKSI
// MIETI, MITEN JBUTTONIT VOISI SAADA JÄRKEVÄMMIN VÄLITETTYÄ TÄNNE JA 
// KÄSITELTYÄ/LISÄTTYÄ TOIMINNALLISUUKSIA.
        
public class KlikkaustenKuuntelija implements ActionListener {
    private JButton eka; 
    private JButton toka;
    private JButton kolmas;
    private JButton neljas;
    private OmaPistelaskuri laskin;
    private int kierros;
    private String muuttuja1;
    private String muuttuja2;
    private Muistipelikortit kortit;
    private JButton lahde1;
    private JButton lahde2;
    private int x1, x2, y1, y2;
          
    
    public KlikkaustenKuuntelija(Muistipelikortit lauta, JButton eka, JButton toka, JButton kolmas, JButton neljas) { // tarvitseeko tälle välittää pistelaskuri?
        this.eka = eka;
        this.toka = toka;
        this.kolmas = kolmas;
        this.neljas = neljas;
        this.kierros = 0;
        this.x1 = 0;
        this.x2 = 0;
        this.y1 = 0;
        this.y2 = 0;
        this.muuttuja1 = "0";
        this.muuttuja2 = "0";
        this.kortit = lauta;
        //this.laskin = laskuri;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (kierros == 2 && onkoPari() == true) {
            this.kortit.vaihdaArvoa(x1, y1);
            this.kortit.vaihdaArvoa(x2, y2);
            this.muuttuja1 = "0";
            this.muuttuja2 = "0";
            this.kierros = 0;
        }
        
        if (kierros == 2 && onkoPari() == false) {
            this.eka.setText(kortit.annaKaantopuoli(0, 0));
            this.toka.setText(kortit.annaKaantopuoli(0, 1));
            this.kolmas.setText(kortit.annaKaantopuoli(1, 0));
            this.neljas.setText(kortit.annaKaantopuoli(1, 1));
            this.muuttuja1 = "0";
            this.muuttuja2 = "0";
            this.kierros = 0;
        }
        
 
        if (ae.getSource() == this.eka) {
            this.eka.setText(kortit.annaOikeaPuoli(0,0)); // COPYPASTEA --> LISÄÄ METODI/LUOKKA...
            kasvataKierrosta();
            talletaMuuttujaan(this.eka, 0, 0);
        } else if (ae.getSource() == this.toka) {
            this.toka.setText(kortit.annaOikeaPuoli(0, 1));
            kasvataKierrosta();
            talletaMuuttujaan(this.toka, 0, 1);
        } else if (ae.getSource() == this.kolmas) {
            this.kolmas.setText(kortit.annaOikeaPuoli(1, 0));
            kasvataKierrosta();
            talletaMuuttujaan(this.kolmas, 1, 0);
        } else if (ae.getSource() == this.neljas) {
            this.neljas.setText(kortit.annaOikeaPuoli(1, 1));
            kasvataKierrosta();
            talletaMuuttujaan(this.neljas, 1, 1);
        }
    }
    
    // NÄMÄ PITÄÄ SAADA TÄÄLTÄ POIS!
    public int kierrosTarkistin() {
        return this.kierros;
    }
    
    public void kasvataKierrosta() {
        this.kierros++; 
    }
    
    public void nollaaKierros() {
        this.kierros = 0;
    }
    
    public boolean onkoPari() {
        if (muuttuja1.equals(muuttuja2)) {
            return true;
        } return false;
    }
    
    public void talletaMuuttujaan(JButton nappi, int y, int x) {
        if (muuttuja1.equals("0")) {
            this.muuttuja1 = kortit.annaOikeaPuoli(y, x);
            System.out.println("muuttuja1="+muuttuja1);
            this.lahde1 = nappi;
            x1 = x;
            y1 = y;
            
        } else
        if (muuttuja1.equals("0") == false && muuttuja2.equals("0") == true ) {
            this.muuttuja2 = kortit.annaOikeaPuoli(y, x);
            System.out.println("muuttuja2="+muuttuja2);
            this.lahde2 = nappi;
            x2 = x;
            y2 = y;
 
        } 
    }
    
}
