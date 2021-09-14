package personnages;

import javafx.scene.image.Image;
import labyrinthe.Salle;
import vue2D.sprites.ASprite;

/**
 *
 * @author vjosso
 */
public class MonstreSprite extends ASprite{
    
    private static Image image = new Image("file:icons/monstre0.gif");
    
    public MonstreSprite(IPersonnage monstre){
        super(monstre, image);
    }
    
}
