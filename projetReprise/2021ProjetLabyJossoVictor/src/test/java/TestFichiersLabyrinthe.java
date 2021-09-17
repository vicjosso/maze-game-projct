
import Exceptions.InvalidLabyFileException;
import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;
import labyrinthe.ISalle;
import labyrinthe.Labyrinthe;
import labyrinthe.Salle;
import org.junit.Test;
import outils.Fichier;
import personnages.IPersonnage;

/**
 * Classe de gestion des tests
 * 
 * @author INFO Professors team
 */
public class TestFichiersLabyrinthe {

    /**
     * Méthode permettant d'obtenir un fichier en fonction de son emplacement 
     * 
     * @param repertoire, emplacement du fichier
     * @return le fichier
     */
    private File[] getFiles(File repertoire) {
        if (!repertoire.isDirectory()) {
            fail("testCoordonneesSalles - les tests ne concernent pas un répertoire");
        }
        File[] fichiers = repertoire.listFiles();
        return fichiers;
    }

    /**
     * Méthode de vérification des coordonnées présent dans un fichier
     * 
     * @param f, fichier
     * @return vrai si les coordonnées sont bonnes
     */
    public boolean testCoordonneesSallesFichier(File f) {

        String nomFichier = f.getPath();
        Fichier fichier = new Fichier(nomFichier);

        if (!nomFichier.endsWith(".txt")) {
            return false;
        }

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

    /**
     * Test les coordonnées des salles d'un fichier 
     */
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

    /**
     * Vérifie que aucune salle soit en doublon dans un fichier 
     * 
     * @param file, fichier
     * @return vrai si aucune salle ne contient de doublon
     * @throws InvalidLabyFileException 
     */
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
    
    /**
     * Vérifie qu'il n'y ait pas de doublon de salle dans un fichier
     * 
     * @throws InvalidLabyFileException 
     */
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

    /**
     * Méthode non implémenté
     */
    @Test
    public void testChemin() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }
    
    //test a finir
    @Test
    public void SallesAdjacente() throws InvalidLabyFileException{
        Labyrinthe lab = new Labyrinthe();
        lab.creerLabyrinthe("eeee"); //mode secours
        
        IPersonnage perso;
        
        //lab.sallesAccessibles(perso);
        
    }

}
