import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInfo extends JPanel implements ActionListener
{
    public static final int CENTER = 1;

    private FrameCasino frameMere;
    private JButton     btnPret;
    private JLabel      lblBanque;
    private JButton     btnRecommencer;
    private JButton     btnQuitter;
    private int         cptPret;

    public PanelInfo(FrameCasino frameMere)
    {

        this.setLayout(new FlowLayout(CENTER, 50, 0));

        /*-----------------------------*/
		/* Création des Controles      */
		/*-----------------------------*/

        this.frameMere      = frameMere;
        this.btnPret        = new JButton("Prêt");
        this.lblBanque      = new JLabel("Banque (" + this.cptPret + ") : " + this.frameMere.getBanque());
        this.btnRecommencer = new JButton("Recommencer");
        this.btnQuitter     = new JButton("Sauvegarder et Quitter");

        /*-----------------------------*/
		/* Positionnement des Controles*/
		/*-----------------------------*/

        this.add(this.btnPret);
        this.add(this.lblBanque);
        this.add(this.btnRecommencer);
        this.add(this.btnQuitter);

        /*-----------------------------*/
		/* Activation des Controles    */
		/*-----------------------------*/

        this.btnPret        .addActionListener  ( this );
        this.btnRecommencer .addActionListener  ( this );
        this.btnQuitter     .addActionListener  ( this );  

    }

    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == this.btnQuitter )
        {
            this.frameMere.ecrire("quitter");

            this.frameMere.dispose();
        }
        if ( e.getSource() == this.btnPret    )
        {
            if (this.cptPret != 0)
            {
                if (this.frameMere.pret())
                {
                    this.cptPret--;
                    this.maj();
                }
            }
        } 

        if (e.getSource() == this.btnRecommencer)
        {
            this.frameMere.ecrire("recommencer");
            new Controleur();
            this.frameMere.dispose();
        }
    }

    public void maj()
    {
        this.lblBanque.setText("Banque (" + this.cptPret + ") : " + this.frameMere.getBanque());
    }

    public int getCptPret()
    {
        return this.cptPret;
    }

    public void setCptPret(int nb)
    {
        this.cptPret = nb;
    }
}