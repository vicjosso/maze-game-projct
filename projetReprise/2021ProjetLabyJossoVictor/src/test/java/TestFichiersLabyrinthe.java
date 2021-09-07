
import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;
import labyrinthe.ISalle;
import labyrinthe.Labyrinthe;
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
    public boolean testCoordonneesSallesFichier(File f) {

        String nomFichier = f.getName();
        Fichier fichier = new Fichier(nomFichier);

        if (!nomFichier.endsWith(".txt")) {
            return false;
        }

        //try catch inutile car aucun moyen d'avoir un retour de lettre, retour par défaut -1 
        //trouver un moyen de faire la différence entre retour dû à une erreur et dû à la fin du fichier
        try {
            int l;
            int h;
            int cpt = 0;
            while (cpt != -1) {
                cpt = fichier.lireNombre();
                if (cpt == -1) {
                    break;
                }
                l = cpt;
                h = fichier.lireNombre();
                if (l < 0 || h < 0) {
                    return false;
                }
            }
        } catch (Exception e) { //Exception à finir et rajouter
            System.err.println(e);
            return false;
        }

        return true;
    }

    
    //passe les tests sans erreur alors que cela devrait
    @Test
    public void testCoordonneesSalles() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);

        Fichier f;

        for (File file : fichiers) {
            if (testCoordonneesSallesFichier(file)) {
                System.out.println("test du fichier" + file.toString());

                f = new Fichier(file.toString());

                int longueur = f.lireNombre();
                int hauteur = f.lireNombre();

                Salle entree = new Salle(f.lireNombre(), f.lireNombre());
                Salle sortie = new Salle(f.lireNombre(), f.lireNombre());

                assertTrue(entree.getX() > 0 && longueur >= entree.getX() && sortie.getX() > 0 && longueur >= sortie.getX());
                assertTrue(entree.getY() > 0 && hauteur >= entree.getY() && sortie.getY() > 0 && hauteur >= sortie.getY());
            } else {
                System.out.println("fichier " + file.toString() + " invalide");
            }
        }
    }

    //vérifier le contenu de fonction
    //passe les tests sans renvoyer d'erreur alors que cela devrait
    public boolean testPasDeDoublonFichier(File file) {
        Fichier f;
        f = new Fichier(file.toString());

        //créer d'un labyrinthe de comparaison
        Labyrinthe lab = new Labyrinthe();
        lab.creerLabyrinthe(file.toString());
        //initialisation de la liste de comparaison
        ArrayList<ISalle> listeV = new ArrayList<>();
        listeV.add(new Salle(-1, -1));
        //boucle de vérification
        for (ISalle labS : lab) {
            if (!listeV.contains(labS)) {
                listeV.add(labS);
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testPasDeDoublon() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);

        for (File file : fichiers) {
            System.out.println("test du fichier " + file.getName() +" en cours");
            assertTrue(testPasDeDoublonFichier(file));
            System.out.println("test fini");
        }
    }

    @Test
    public void testChemin() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

}
