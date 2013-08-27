/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import muistipeli.sovelluslogiikka.Pelitoiminnot;

/**
 * Ohjelmoinnin harjoitustyö, syksy 2013
 * 
 * Luokka vastaa käyttöliittymän alapalkissa olevien valintanappien kuuntelusta
 * ja toimintojen toteuttamisesta.
 * 
 * @author Anu Nikkanen
 */

public class AlapalkinKuuntelija implements ActionListener {
    private LuoPelikentta lpk;
    private LuoAlapalkki lap;
    private KlikkaustenKuuntelija kk;
    private Pelitoiminnot pt;
    private LuoPistepalkki pp;
    
    public AlapalkinKuuntelija(Pelitoiminnot pt, LuoPelikentta lpk, LuoAlapalkki lap, KlikkaustenKuuntelija kk ) {
        this.lpk = lpk;
        this.lap = lap;
        this.kk = kk;
        this.pt = pt;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == lap.get2x2()) {
            uusiPeli(2);
        }
        if (ae.getSource() == lap.get4x4()) {
            uusiPeli(4);
        }
        if (ae.getSource() == lap.get6x6()) {
            uusiPeli(6);
        }
        
    }
    
    private void uusiPeli(int koko) {
            this.lpk.getPelikentta().removeAll();
            this.lpk.getPelikentta().repaint();
            this.lpk.getPelikentta().validate();
            this.lpk.getPelikentta().add(lpk.getUusiPeli(koko));
            
            for (JButton nappi : lpk.getKorttilista().keySet()) {
            nappi.addActionListener(kk);
            }
            
            pt.nollaaKaikki();
            this.lpk.getPelikentta().repaint();
            this.lpk.getPelikentta().validate();
        
    }
    
}
