
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * KlikkaustenKuuntelija toteuttaa kuhunkin JButtoniin (esim. muistipelikortit)
 * liittyvät toiminnot.
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import muistipeli.sovelluslogiikka.Pelitoiminnot;
import muistipeli.sovelluslogiikka.Pistelista;


public class KlikkaustenKuuntelija implements ActionListener {
    private Pelitoiminnot pt;
    private Pistelista pisteet;
    private LuoPistepalkki pp;
    private LuoHighscorepalkki hp;


    public KlikkaustenKuuntelija(LuoPistepalkki pp, LuoHighscorepalkki hp, LuoPelikentta pk, Pistelista p) {  
        this.pt = new Pelitoiminnot(pk, pp);
        this.pisteet = p;
        this.hp = hp;
        this.pp = pp;
    }
    
    /* Metodi suorittaa kuhunkin JButtoniin liittyvät toiminnot */
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.pt.pelikierros(ae);
        
        if (ae.getSource() == pp.getTallennaNappi()) {
          
            pp.getNimim().setEnabled(true);
            pp.getAnnaNimim().setEnabled(true);
            pp.getOkNappi().setEnabled(true);
        }
        
        if (ae.getSource() == pp.getOkNappi() ) {
                this.pisteet.lisaaPisteet(this.pp.getNimim().getText(), pt.finalScore());
                this.pp.getNimim().setEnabled(false);
                this.pp.getTallennaNappi().setEnabled(false);
                this.pp.getOkNappi().setEnabled(false);
                this.pp.getNimim().setText(" ");
                this.pisteet.tallennaPisteet();
                this.hp.getHighscorekentta().setVisible(true);
                this.hp.getHighscorekentta().setText("<html>"+this.pisteet.tulostaHighscore()+"</html>");
                
        }
        
        
    }   
    
       
        
}
