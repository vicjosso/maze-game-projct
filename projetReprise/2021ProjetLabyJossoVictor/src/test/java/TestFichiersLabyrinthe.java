import static org.junit.Assert.*;
import java.io.File;
import labyrinthe.Salle;
import org.junit.Test;
import outils.Fichier;

/**
 *
 * @author INFO Professors team
 */
public class TestFichiersLabyrinthe {

    private File[] getFiles(File repertoire) {
        if (!repertoire.isDirectory()) {
            fail("testCoordonneesSalles - les tests ne concernent pas un répertoire");
        }
        File[] fichiers = repertoire.listFiles();
        return fichiers;
    }
    
    //vérification de la bonne extension de fichier
    //vérification de la présence ou non de caractère autre que des chiffres
    //vérification de nombre négatif
    public boolean testCoordonneesSallesFichier(File f){
        
        String nomFichier = f.getName();
        Fichier fichier = new Fichier(nomFichier);
        
        if(!nomFichier.endsWith(".txt")) return false;
        
        //try catch inutile car aucun moyen d'avoir un retour de lettre, retour par défaut -1 
        //trouver un moyen de faire la différence entre retour dû à une erreur et dû à la fin du fichier
        try{
            int l;
            int h;
            int cpt = 0;
            while(cpt != -1){
                cpt = fichier.lireNombre();
                if(cpt == -1) break;
                l = cpt;
                h = fichier.lireNombre();
                if(l < 0 || h < 0) return false;
            }
        } catch (Exception e){ //Exception à finir et rajouter
            System.err.println(e);
            return false;
        }
        
        return true;
    }

    @Test
    public void testCoordonneesSalles() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        
        Fichier f;
        
        
        for(File file : fichiers){
            if(testCoordonneesSallesFichier(file)){
                System.out.println("test du fichier" + file.toString());
                
                f = new Fichier(file.toString());
                
                int longueur = f.lireNombre();
                int hauteur = f.lireNombre();
                
                Salle entree = new Salle(f.lireNombre(), f.lireNombre());
                Salle sortie = new Salle(f.lireNombre(), f.lireNombre());
                
                assertTrue(entree.getX() > 0 && longueur >= entree.getX() && sortie.getX() > 0 && longueur >= sortie.getX());
                assertTrue(entree.getY() > 0 && hauteur >= entree.getY() && sortie.getY() > 0 && hauteur >= sortie.getY());
            }
            else{
                System.out.println("fichier " + file.toString() + " invalide");
            }
        }
    }


    @Test
    public void testPasDeDoublon() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

    @Test
    public void testChemin() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

}
