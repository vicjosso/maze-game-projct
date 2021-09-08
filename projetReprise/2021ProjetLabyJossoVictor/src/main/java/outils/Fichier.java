package outils;

import Exceptions.InvalidLabyFileException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import labyrinthe.ISalle;
import labyrinthe.Labyrinthe;

/**
 *
 * @author INFO Professors team
 */
public class Fichier {
    Scanner sc=null;
    
    public Fichier(String nomFichier){
        try{
	    sc = new Scanner(new File(nomFichier));
	}
	catch(Exception e){ System.out.println(e); }     
    }
    
  // retourne le prochain entier dans le fichier
  // retourne -1 s'il n'y en a pas
    public int lireNombre(){
        if (sc.hasNextInt()){
            return sc.nextInt();
        }
        return -1;
    }
    
    //refaire la fonction en utilisant this plutot que faire des appels douteux
    public static boolean testValid(String nomfichier) throws InvalidLabyFileException{
        
        
        //rajouter ce truc nul throw new InvalidLabyFileException("");
        
        String path = "labys/" + nomfichier;
        
        //
        //test doublon
        //

        //création d'un labyrinthe de comparaison
        Labyrinthe lab = new Labyrinthe();
        lab.creerLabyrinthe(path);
        //initialisation de la liste de comparaison
        ArrayList<ISalle> listeV = new ArrayList<>();
        //boucle de vérification
        int i = 0;
        for (ISalle labS : lab) {
            i++;
            if (!listeV.contains(labS)) {
                listeV.add(labS);
            } else {
                System.out.println(i);
                return false;
            }
        }
        
        //
        //test salles
        //
        
        //erreur de type mystère
        Fichier fichier = new Fichier(path);

        if (!path.endsWith(".txt")) {
            return false;
        }

        //trouver un moyen de faire la différence entre retour dû à une erreur et dû à la fin du fichier
        int l = fichier.lireNombre();
        int h = fichier.lireNombre();
        int x;
        int y;
        int cpt = 0;
        while (cpt != -1) {
            cpt = fichier.lireNombre();
            if (cpt == -1) {
                break;
            }
            x = cpt;
            y = fichier.lireNombre();
            if (x < 0 || y < 0 || x > l || y > h) {
                return false;
            }
        }

        return true;
        
    }
    
}
