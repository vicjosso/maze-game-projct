package labyrinthe;

import Exceptions.InvalidLabyFileException;
import java.util.ArrayList;
import java.util.Collection;

import outils.Fichier;
import personnages.IPersonnage;

/**
 *
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    protected ISalle entree;
    protected ISalle sortie;
    private int largeur;
    private int hauteur;

    @Override
    public void creerLabyrinthe(String file) throws InvalidLabyFileException{
        Fichier f = new Fichier(file); 
        String fichierSecours = "labys/level7.txt";

        if (Fichier.testValid(file)){
            // dimensions
            largeur = f.lireNombre();
            hauteur = f.lireNombre();
            // entree et sortie
            entree = new Salle(f.lireNombre(), f.lireNombre());
            sortie = new Salle(f.lireNombre(), f.lireNombre());
            // reste du labyrinthe
            int cpt = 0;
            while (cpt != -1) {
                cpt = f.lireNombre();
                if (cpt != -1) {
                    this.add(new Salle(cpt, f.lireNombre()));
                }
            }
        } else{
            if(Fichier.testValid(fichierSecours)){
                f = new Fichier(fichierSecours);
                // dimensions
                largeur = f.lireNombre();
                hauteur = f.lireNombre();
                // entree et sortie
                entree = new Salle(f.lireNombre(), f.lireNombre());
                sortie = new Salle(f.lireNombre(), f.lireNombre());
                // reste du labyrinthe
                int cpt = 0;
                while (cpt != -1) {
                cpt = f.lireNombre();
                if (cpt != -1) {
                    this.add(new Salle(cpt, f.lireNombre()));
                }
            }
            } else {
                System.out.println("Fichier illisible");
                System.exit(0);
            }
        }
    }

    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        //methode à faire
        Collection<ISalle> sallesAccessibles;
        
        for(){
            sallesAccessibles.add();
        }
        
        return sallesAccessibles;
    }

    @Override
    public ISalle getEntree() {
        return entree;
    }

    @Override
    public ISalle getSortie() {
        return sortie;
    }

    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    @Override
    public int getLargeur() {
        return largeur;
    }

    @Override
    public int getHauteur() {
        return hauteur;
    }

}
