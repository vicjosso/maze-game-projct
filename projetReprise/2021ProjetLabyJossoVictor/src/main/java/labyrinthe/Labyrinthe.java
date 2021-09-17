package labyrinthe;

import Exceptions.InvalidLabyFileException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import outils.Fichier;
import personnages.IPersonnage;

/**
 * Classe de gestion de Labyrinthe
 * 
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    protected ISalle entree;
    protected ISalle sortie;
    private int largeur;
    private int hauteur;

    /**
     * Créer un labyrinthe à partir d'un nom de fichier
     * 
     * @param file, nom du fichier à charger
     * @throws InvalidLabyFileException 
     */
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

    /**
     * Retourne l'nesemble des positions accessibles à partir de la position d'un personnage
     * 
     * @param bob, personnage
     * @return ensemble des positions accessibles
     */
    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        
        Collection<ISalle> sallesAccessibles = new ArrayList<>();
        
        for(ISalle salle : this){
            if(bob.getPosition().estAdjacente(salle)){
                    sallesAccessibles.add(salle);
            }
        }
        
        return sallesAccessibles;
    }

    /**
     * Retourne l'entrée du labyrinthe
     * 
     * @return entrée du labyrinthe
     */
    @Override
    public ISalle getEntree() {
        return entree;
    }

    /**
     * Retourne la sortie du labyrinthe
     * 
     * @return sortie du labyrinthe
     */
    @Override
    public ISalle getSortie() {
        return sortie;
    }

    
    /**
     * Fonction non implémenté
     * 
     * @param u
     * @param v
     * @return 
     */
    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    /**
     * Retourne la largeur du labyrinthe
     * 
     * @return largeur du labyrinthe
     */
    @Override
    public int getLargeur() {
        return largeur;
    }

    /**
     * Retourne la hauteur du labyrinthe
     * 
     * @return hauteur du labyrinthe
     */
    @Override
    public int getHauteur() {
        return hauteur;
    }

}
