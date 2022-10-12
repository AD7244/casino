import java.awt.BorderLayout;
import javax.swing.JFrame;

public class FrameCasino extends JFrame
{
    private Controleur ctrl;
    private PanelCasino panelCasino;
    private PanelInfo   panelInfo;
    private PanelLancer panelLancer;

    public FrameCasino(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setTitle       ("Casino"    );
        this.setLocation    (0, 0               );
        this.setSize        (700, 250       );
        this.setLayout      (new BorderLayout() );
        
        /*-----------------------------*/
		/* Création des Controles      */
		/*-----------------------------*/

        this.panelCasino = new PanelCasino  (this);
        this.panelInfo   = new PanelInfo    (this);
        this.panelLancer = new PanelLancer  (this);

        /*-----------------------------*/
		/* Positionnement des Controles*/
		/*-----------------------------*/

        this.add(this.panelCasino, BorderLayout.CENTER);
        this.add(this.panelInfo,   BorderLayout.SOUTH);
        this.add(this.panelLancer, BorderLayout.WEST);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public int getBanque()
    {
        return this.ctrl.getBanque();
    }

    public boolean setBanque(int nb)
    {
        return this.ctrl.setBanque(nb);
    }

    public boolean pret()
    {
        return this.ctrl.pret();
    }

    public boolean lancer()
    {
        return this.ctrl.lancer();
    }

    public void maj()
    {
        this.panelInfo.maj();
    }

    public String getMise()
    {
        return this.panelLancer.getMise();
    }

    public void setLblInfo(String mess)
    {
        this.panelCasino.setLblInfo(mess);
    }

    public void setLblDesAdverses(String mess)
    {
        this.panelCasino.setLblDesAdverses(mess);
    }

    public void setLblDesAdversesImage(String mess)
    {
        this.panelCasino.setLblDesAdversesImage(mess);
    }

    public void setLblDesJoueur(String mess)
    {
        this.panelCasino.setLblDesJoueur(mess);
    }

    public void setLblDesJoueurImage(String mess)
    {
        this.panelCasino.setLblDesJoueurImage(mess);
    }

    public int getCptPret()
    {
        return this.panelInfo.getCptPret();
    }

    public void setCptPret(int nb)
    {
        this.panelInfo.setCptPret(nb);
    }

    public void ecrire(String choix)
    {
        this.ctrl.ecrire(choix);
    }
}


