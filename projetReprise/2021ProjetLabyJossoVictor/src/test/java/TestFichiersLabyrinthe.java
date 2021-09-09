
import Exceptions.InvalidLabyFileException;
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

        String nomFichier = f.getPath();
        Fichier fichier = new Fichier(nomFichier);

        if (!nomFichier.endsWith(".txt")) {
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

    @Test
    public void testCoordonneesSalles() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);

        Fichier f;

        for (File file : fichiers) {
                System.out.println("test du fichier" + file.toString());
                if(file.getName().contains("nvalid")) continue;
                assertTrue(testCoordonneesSallesFichier(file)); //erreur logique
        }
    }

    //vérifier le contenu de fonction
    //passe les tests sans renvoyer d'erreur alors que cela devrait
    public boolean testPasDeDoublonFichier(File file) throws InvalidLabyFileException{
        Fichier f = new Fichier(file.getPath());

        //création d'un labyrinthe de comparaison
        Labyrinthe lab = new Labyrinthe();
        lab.creerLabyrinthe(file.getPath());
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
        return true;
    }

    
    //bloque au fichier invalide2 et 7
    @Test
    public void testPasDeDoublon() throws InvalidLabyFileException{
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);

        for (File file : fichiers) {
            System.out.println("test du fichier " + file.getName());
            if(file.getName().contains("nvalid")) continue;
            assertTrue(testPasDeDoublonFichier(file));
        }
    }

    @Test
    public void testChemin() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

}
