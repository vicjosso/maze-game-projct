package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ISalle;
import personnages.IPersonnage;

/**
 *
 * @author vjosso
 */
public abstract class ASprite implements ISprite{
    
    //private IPersonnage entite;
    private int unite = 15;
    private Image img;
    private int coordX;
    private int coordY;
    
    public ASprite(Image img){
        this.img = img;
    }
    
    @Override
    public void dessiner(GraphicsContext g){
        //vérifier l'utilisation de unite, parce que coord peut être en pixel et non coord
        g.drawImage(this.img, this.coordX * unite, this.coordY * unite, unite, unite);
    }
    
    @Override
    public void setCoordonnees(int xpix, int ypix){
        this.coordX = xpix;
        this.coordY = ypix;
    }
}
