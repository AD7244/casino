import java.io.*;
import java.lang.Thread;

public class Metier
{
    private Controleur ctrl;
    private int banque;

    public Metier(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.banque = 0;
    }

    public int getBanque()
    {
        return this.banque;
    }

    public boolean setBanque(int nb)
    {
        if ((this.banque + nb) >= 0)    //verifie que le joueur a de quoi miser 
        {
            this.banque += nb;
            this.ctrl.maj();
            return true;
        }
        return false;
    }

    public void setDonneeBanque(int nb)
    {
        this.banque = nb;
    }

    public boolean pret()
    {
        if(this.ctrl.getMise() == "" && this.banque <= 10)
        {
            this.banque += 10;
            this.ctrl.maj();
            return true;
        }
        return false;
    }

    public boolean lancer() 
    {
        int mise;
        int deAdverse   = (int) (Math.random() * 11) +2;
        int deJoueur    = (int) (Math.random() * 11) +2;

        if (this.ctrl.getMise() == "")
        {
            this.ctrl.setLblInfo("Aucune mise entrée");
            return false;
        }

        mise = Integer.parseInt(this.ctrl.getMise());

        this.ctrl.setLblDesAdversesImage(String.valueOf(deAdverse));

        
        this.ctrl.setLblDesJoueurImage  (String.valueOf(deJoueur )); 



        if (deJoueur > deAdverse)
        {
            if (deJoueur == 12)
            {
                this.ctrl.setLblInfo("Bravo ! Vous avez fait 12, vous gagnez donc 4x votre mise");
                this.banque += mise*4;
                this.ctrl.maj();
            }
            else
            {
                this.ctrl.setLblInfo("Vous avez gagné " + mise*2 + " jetons!");
                this.banque += mise*2;
                this.ctrl.maj();
            }
        }
        
        if (deJoueur < deAdverse)
        {
            this.ctrl.setLblInfo("Vous avez perdu " + mise + " jetons...");
        }
        if (deJoueur == deAdverse)
        {
            this.ctrl.setLblInfo("Égalité, vous regagnez votre mise");
            this.banque += mise;
            this.ctrl.maj();
        }

        return true;
        
    }
}