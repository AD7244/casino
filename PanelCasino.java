import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.*;

public class PanelCasino extends JPanel
{
    private FrameCasino     frameMere;
    private JLabel lblDesAdverses;
    private JLabel lblInfo;
    private JLabel lblDesJoueur;

    public PanelCasino(FrameCasino frameMere)
    {
        this.setBackground (new Color(240, 13, 13));
        this.setLayout(new GridLayout(3, 1, 100, 5));

        /*-----------------------------*/       
		/* Création des Controles      */
		/*-----------------------------*/

        this.frameMere = frameMere;
        
        this.lblDesAdverses = new JLabel("", SwingConstants.CENTER);
        this.lblInfo        = new JLabel("", SwingConstants.CENTER);
        this.lblDesJoueur   = new JLabel("", SwingConstants.CENTER);

        /*-----------------------------*/
		/* Positionnement des Controles*/
		/*-----------------------------*/

        this.add(this.lblDesAdverses);
        this.add(this.lblInfo);
        this.add(this.lblDesJoueur);
    }

    public void setLblInfo(String mess)
    {
        this.lblInfo.setText(mess);
    }

    public void setLblDesAdverses(String mess)
    {
        this.lblDesAdverses.setText(mess);
    }

    public void setLblDesAdversesImage(String mess)
    {
        if (mess == null)
        {
            this.lblDesAdverses.setIcon(null);
        }
        else 
        {
            Icon icon = new ImageIcon("../images\\" + Integer.parseInt(mess)  + ".png");    //affichage des des adverses selon le score obtenue
            this.lblDesAdverses.setIcon(icon);
        }
    }

    public void setLblDesJoueur(String mess)
    {
        this.lblDesJoueur.setText(mess);
    }

    public void setLblDesJoueurImage(String mess)
    {
        if (mess == null)
        {
            this.lblDesJoueur.setIcon(null);
        }
        else 
        {
            Icon icon = new ImageIcon("../images\\" + Integer.parseInt(mess)  + ".png");    //affichage des des du joueur selon le score obtenue
            this.lblDesJoueur.setIcon(icon);
        }    
    }

}
