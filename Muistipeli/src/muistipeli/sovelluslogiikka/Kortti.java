/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.sovelluslogiikka;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author anunikkanen
 */
public class Kortti extends JButton {
    private int indeksi;
    private JButton kortti;
    private ImageIcon oikeapuoli;
    private ImageIcon kaantopuoli;
    private boolean pelityyppi;
    private String kuvapuoli;
    private String nurjapuoli;
    
    public Kortti(ImageIcon oikeapuoli, ImageIcon kaantopuoli) {
        super();
        this.oikeapuoli = oikeapuoli;
        this.kaantopuoli = kaantopuoli;
        super.setIcon(this.kaantopuoli);
        super.setDisabledIcon(this.oikeapuoli);
        super.setBorder(new LineBorder(Color.BLACK, 1));
        
        this.pelityyppi = true;
        super.setFocusPainted(false);
    }
     
    public Kortti(String kuvapuoli) {
        super();
        this.kuvapuoli = kuvapuoli;
        this.nurjapuoli = " ";
        super.setText(nurjapuoli);
      
        this.pelityyppi = false;
    }
    
    public int getIndeksi() {
        return this.indeksi;
    }
    
    public void kaannaOikeinPain() {
        if (this.pelityyppi == true) {
            super.setEnabled(false);
        } else {
            super.setText(kuvapuoli);
        }
    }
    
    public void kaannaNurinPain() {
        if (this.pelityyppi == true) {
            super.setEnabled(true);
        } else {
            super.setText(this.nurjapuoli);
        }
    }
    
    public String getKuvapuoli() {
        if (this.pelityyppi == true) {
            return this.oikeapuoli.toString();
        } else return this.kuvapuoli;
    }
    
    /*public JButton getKortti() {
        return this.kortti;
    }*/
}
