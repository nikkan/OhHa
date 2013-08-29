
package muistipeli.kayttoliittyma;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Pistepalkki-luokan vastuuna on luoda Muistipelin graafisen käyttöliittymään
 * oikeaan yläkulmaan palkki, johon tulostetaan käyttäjän pisteet pelin aikana 
 * ja annetaan käyttäjälle mahdollisuus tallentaa omat pisteensä.
 * 
 * @author Anu N.
 */

public class Pistepalkki {
    
    private JButton tallennaPisteet;
    private JButton ok;
    private JPanel pistepalkki;
    private JLabel annaNimim;
    private JTextField nimim;
    private JLabel omatPisteet;
    
   /**
    * Konstruktori luo pistepalkin ja siihen sisältyvät komponentit käyttöliittymään.
    * 
    * @param mainPanel Käyttöliittymän pääpaneli, johon Pistepalkki lisätään                     
    */
    public Pistepalkki(JPanel mainPanel) {
        // Luodaan pistepalkki ja laitetaan sille asetukset
        this.pistepalkki = new JPanel(new GridLayout(6, 1));
        this.pistepalkki.setOpaque(true);
        this.pistepalkki.setBackground(Color.pink);
        
        // Luodaan ja lisätään omatPisteet-kenttä
        this.omatPisteet = new JLabel();
        this.omatPisteet.setText("<html>"+" # "+"<strong>Pisteesi: </strong>"+" "+0+"</html>");
        this.pistepalkki.add(this.omatPisteet);
        
        // Luodaan ja lisätään 'Tallenna pisteet'-nappi
        this.tallennaPisteet = new JButton("Tallenna pisteet");
        this.tallennaPisteet.setVisible(false);
        this.pistepalkki.add(this.tallennaPisteet);
        
        // Luodaan ja lisätään JLabel, joka kehoittaa käyttäjää antamaan nimimerkin
        this.annaNimim = new JLabel("Anna nimimerkkisi");
        this.annaNimim.setVisible(false);
        this.pistepalkki.add(this.annaNimim);
        
        // Luodaan ja lisätään tekstikenttä, johon käyttäjä voi syöttää nimimerkin
        this.nimim = new JTextField();
        this.nimim.setVisible(false);
        this.pistepalkki.add(this.nimim);
        
        // Luodaan ja lisätään 'OK'-nappi
        this.ok = new JButton("OK");
        this.ok.setVisible(false);
        this.pistepalkki.add(this.ok);
        
        // Asetetaan GridBag-rajoitukset 
        GridBagConstraints c = new GridBagConstraints();
       
        c.gridx = 3;
        c.gridy = 1;
        c.gridheight = 2;
        c.insets = new Insets(2,0,0,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        
        // Lisätään pistepalkki mainPaneliin
        mainPanel.add(this.pistepalkki, c);
    }
    
    public JButton getTallennaNappi() {
        return this.tallennaPisteet;
    }
    
    public JButton getOkNappi() {
        return this.ok;
    }
    
    public JTextField getNimim() {
        return this.nimim;
    }
    
    public JLabel getAnnaNimim() {
        return this.annaNimim;
    }
    
    public JLabel getOmatPisteetKentta() {
        return this.omatPisteet;
    }
}
