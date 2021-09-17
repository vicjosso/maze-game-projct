package personnages;

import javafx.scene.image.Image;
import vue2D.sprites.ASprite;

/**
 * Classe de gestion du Sprite de Monstre
 * 
 * @author vjosso
 */
public class MonstreSprite extends ASprite{
    
    /**
     * Initialisation de l'image du monstre
     */
    private static Image image = new Image("file:icons/monstre0.gif");
    
    /**
     * Constructeur de Monstre
     * 
     * @param monstre, 
     */
    public MonstreSprite(IPersonnage monstre){
        super(monstre, image);
    }
    
}
