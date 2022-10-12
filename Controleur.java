import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Controleur
{
    private FrameCasino ihm;
    private Metier      metier;

    public Controleur()
    {
        this.metier = new Metier(this); 
        this.ihm    = new FrameCasino (this);
        this.lireDonnees(); //recupere les donnees des parties precedentes
    }

    public int getBanque()
    {
        return this.metier.getBanque();
    }

     public boolean setBanque(int nb)
    {
        return this.metier.setBanque(nb);
    }

    public boolean pret()
    {
        return this.metier.pret();
    }

    public boolean lancer()
    {
        return this.metier.lancer();
    }

    public void maj()
    {
        this.ihm.maj();
    }

    public String getMise()
    {
        return this.ihm.getMise();
    }

    public void setLblInfo(String mess)
    {
        this.ihm.setLblInfo(mess);
    }

    public void setLblDesAdversesImage(String mess)
    {
        this.ihm.setLblDesAdversesImage(mess);
    }

    public void setLblDesJoueurImage(String mess)
    {
        this.ihm.setLblDesJoueurImage(mess);
    }

    public void ecrire(String choix)
    {
        switch (choix)
        {
            case "quitter":
            {
                try
                {
                    PrintWriter pw = new PrintWriter( new FileOutputStream("./sauvegarde.txt"));

                    pw.println( String.valueOf(this.getBanque()) );     //sauvegarde le nombre de jetons du joueur dans le fichier 
                    pw.println( String.valueOf(this.ihm.getCptPret())); //sauvegarde le nombre de pret disponible du jouer dans le fichier
                    pw.close();
                }
                catch (Exception a){ a.printStackTrace(); }

                break;
            }

            case "recommencer":
            {
                try
                {
                    PrintWriter pw = new PrintWriter( new FileOutputStream("./sauvegarde.txt"));

                    pw.println( String.valueOf(20) );   //reinitialise le nombre de jeton a 20
                    pw.println( String.valueOf(10));    //reinitialise le nombre de pret disponible a 10
                    pw.close();
                }
                catch (Exception a){ a.printStackTrace(); }

                break;
            }
        }
    }

    public void lireDonnees()
    {
        File file = new File("./sauvegarde.txt"); 
        try(FileInputStream fis = new FileInputStream(file)) 
        {
            Scanner sc = new Scanner(fis);
            this.metier.setDonneeBanque(Integer.parseInt(sc.nextLine()));   //recupere le nombre de jeton dans la banque
            this.ihm.setCptPret(Integer.parseInt(sc.nextLine()));   //recupere le nombre de pret disponible
            sc.close();
        } 
        catch(IOException e) { e.printStackTrace(); }

        this.maj();
    }


    public static void main(String[] a)
    {
        new Controleur();
    }
}