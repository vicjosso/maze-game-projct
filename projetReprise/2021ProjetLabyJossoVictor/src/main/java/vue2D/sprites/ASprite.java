package vue2D.sprites;

import java.util.Collection;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ISalle;
import personnages.IPersonnage;

/**
 *
 * @author vjosso
 */
public abstract class ASprite implements ISprite{
    
    protected IPersonnage entite;
    private int unite = 15;
    private Image img;
    private int coordX;
    private int coordY;
    
    public ASprite(IPersonnage perso, Image img){
        this.entite = perso;
        this.img = img;
    }
    
    @Override
    public void dessiner(GraphicsContext g){
        //vérifier l'utilisation de unite, parce que coord peut être en pixel et non coord
        //g.drawImage(this.img, this.coordX * unite, this.coordY * unite, unite, unite);
        g.drawImage(this.img, this.coordX, this.coordY, unite, unite);
    }
    
    @Override
    public void setCoordonnees(int xpix, int ypix){
        this.coordX = xpix;
        this.coordY = ypix;
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ISalle getPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPosition(ISalle s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
