import static org.junit.Assert.*;
import java.io.File;
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
        
        if(!nomFichier.endsWith("txt"))return false;
        
        try{
            int cpt = 0;
            while(cpt != -1){
                cpt = fichier.lireNombre();
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
        
        for(File f : fichiers){
            if(testCoordonneesSallesFichier(f)){
                System.out.println("test du fichier" + f.toString());
                
            }
            else{
                System.out.println("fichier " + f.toString() + " invalide");
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
