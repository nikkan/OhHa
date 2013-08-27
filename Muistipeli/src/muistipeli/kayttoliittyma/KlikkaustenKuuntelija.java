
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
import javax.swing.JPanel;
import muistipeli.sovelluslogiikka.Pelitoiminnot;
import muistipeli.sovelluslogiikka.Pistelista;


public class KlikkaustenKuuntelija implements ActionListener {
    private Pelitoiminnot pt;
    private Pistelista pisteet;
    private LuoPistepalkki pp;
    private LuoHighscorepalkki hp;
    private LuoAlapalkki ap;
    private JPanel mp;
    private LuoPelikentta pk;


    public KlikkaustenKuuntelija(Pelitoiminnot pt, LuoAlapalkki ap, LuoPistepalkki pp, LuoHighscorepalkki hp, LuoPelikentta pk, Pistelista p) {  
        this.pt = pt;
        this.pisteet = p;
        this.hp = hp;
        this.pp = pp;
        this.ap = ap;
        this.mp = mp;
        this.pk = pk;
    }
    
    /* Metodi suorittaa kuhunkin JButtoniin liittyvät toiminnot */
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.pt.pelikierros(ae);
        
        if (ae.getSource() == pp.getTallennaNappi()) {
          
            pp.getNimim().setVisible(true);
            pp.getAnnaNimim().setVisible(true);
            pp.getOkNappi().setVisible(true);
        }
        
        if (ae.getSource() == pp.getOkNappi() ) {
                this.pisteet.haePisteet();
                this.pisteet.lisaaPisteet(this.pp.getNimim().getText(), pt.finalScore());
                this.pp.getNimim().setVisible(false);
                this.pp.getTallennaNappi().setVisible(false);
                this.pp.getOkNappi().setVisible(false);
                this.pp.getNimim().setVisible(false);
                this.pp.getNimim().setText("");
                this.pp.getAnnaNimim().setVisible(false);
                this.pisteet.tallennaPisteet();
                this.hp.getHighscorekentta().setVisible(true);
                this.hp.getHighscorekentta().setText(this.pisteet.tulostaPisteet());
                
        }
        
        
        
        
    }   
    
       
        
}
