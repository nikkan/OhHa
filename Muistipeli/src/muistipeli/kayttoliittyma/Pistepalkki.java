
package muistipeli.kayttoliittyma;

/**
 * Ohjelmoinnin harjoitustyo, loppukesa 2013
 * 
 * @author Anu Nikkanen
 * 
 * LuoPistepalkki-luokassa luodaan käyttöliittymään oikeaan yläkulmaan
 * palkki, johon tulostetaan käyttäjän pisteet pelin aikana ja annetaan
 * käyttäjälle mahdollisuus tallentaa omat pisteensä.
 * 
 */

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Pistepalkki {
    
    private JButton tallennaPisteet;
    private JButton ok;
    private JLabel annaNimim;
    private JTextField nimim;
    private JLabel pisteesi;
    
    
    public Pistepalkki(JPanel mainPanel) {
       
        JPanel score = new JPanel(new GridLayout(6, 1));
        score.setOpaque(true);
        score.setBackground(Color.pink);
        
        pisteesi = new JLabel();
        pisteesi.setText("<html>"+" # "+"<strong>Pisteesi: </strong>"+" "+0+"</html>");
        score.add(pisteesi);
        
        tallennaPisteet = new JButton("Tallenna pisteet");
        tallennaPisteet.setVisible(false);
        score.add(tallennaPisteet);
        
        annaNimim = new JLabel("Anna nimimerkkisi");
        annaNimim.setVisible(false);
        score.add(annaNimim);
        
        nimim = new JTextField();
        nimim.setVisible(false);
        score.add(nimim);
        
        ok = new JButton("OK");
        ok.setVisible(false);
        score.add(ok);
        
        // GridBagConstraints // 
        GridBagConstraints c = new GridBagConstraints();
       
        c.gridx = 3;
        c.gridy = 1;
        c.gridheight = 2;
        c.insets = new Insets(2,0,0,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        
        mainPanel.add(score, c);
    }
    
    /* Metodi palauttaa 'Tallenna' -napin */
    public JButton getTallennaNappi() {
        return this.tallennaPisteet;
    }
    
    /* Metodi palauttaa 'OK' -napin */
    public JButton getOkNappi() {
        return this.ok;
    }
    
    /* Metodi palauttaa tekstikentän, johon käyttäjä voi kirjoittaa nimimerkkinsä */
    public JTextField getNimim() {
        return this.nimim;
    }
    
    /* Metodi palauttaa tekstikentän, jonka teksti kehoittaa käyttäjää lisäämään nimimerkkinsä */
    public JLabel getAnnaNimim() {
        return this.annaNimim;
    }
    
    /* Metodi palauttaa kentän, jossa ovat käyttäjän pisteet */
    public JLabel getPisteesikentta() {
        return this.pisteesi;
    }
}
