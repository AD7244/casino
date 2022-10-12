import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

public class PanelLancer extends JPanel implements ActionListener
{
    private FrameCasino     frameMere;
    private JButton         btnAjouterMise;
    private JButton         btnRetirerMise;
    private JLabel          lblMiseTotal;
    private JButton         btnLancer;
    private int             mise = 0;

    public PanelLancer(FrameCasino frameMere)
    {
        this.setLayout(new GridLayout(5, 1, 100, 25));

        /*-----------------------------*/
		/* Création des Controles      */
		/*-----------------------------*/

        this.frameMere      = frameMere;
        JLabel lblMise      = new JLabel("Mise : ");
        this.btnAjouterMise = new JButton("Ajouter 10");
        this.btnRetirerMise = new JButton("Retirer 10");
        this.lblMiseTotal   = new JLabel("");
        this.btnLancer      = new JButton("Lancer");

        /*-----------------------------*/
		/* Positionnement des Controles*/
		/*-----------------------------*/

        this.add(lblMise);
        this.add(this.btnAjouterMise);
        this.add(this.btnRetirerMise);
        this.add(this.lblMiseTotal);
        this.add(this.btnLancer);

        /*-----------------------------*/
		/* Activation des Controles    */
		/*-----------------------------*/

        this.btnLancer.addActionListener  ( this );
        this.btnAjouterMise  .addActionListener  ( this );
        this.btnRetirerMise  .addActionListener  ( this );
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.btnLancer)
        {
            if (this.frameMere.lancer())
            {
                this.lblMiseTotal.setText("");
                this.mise = 0;
            }
        }

        if (e.getSource() == this.btnAjouterMise)
        {
            if (this.frameMere.setBanque(-10))
            {
                this.mise += 10;
                this.lblMiseTotal.setText(String.valueOf(this.mise) );

                this.frameMere.setLblDesJoueurImage  (null);
                this.frameMere.setLblDesAdversesImage(null);
                this.frameMere.setLblInfo       ("vous pariez " + this.mise);                
            }

        }

        if (e.getSource() == this.btnRetirerMise)
        {
            if (this.mise != 0)
            {
                if (this.frameMere.setBanque(10))
                {
                    this.mise += -10;
                    this.lblMiseTotal.setText(String.valueOf(this.mise) );
                }

                if (this.mise == 0)
                {
                    this.lblMiseTotal.setText("");
                }

                this.frameMere.setLblInfo       ("vous pariez " + this.mise); 
            }

        }
    }

    public String getMise()
    {
        return this.lblMiseTotal.getText();
    }
}