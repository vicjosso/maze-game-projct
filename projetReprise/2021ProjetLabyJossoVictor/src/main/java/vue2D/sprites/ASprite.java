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
    private final int unite = 15;
    protected Image img;
    
    public ASprite(IPersonnage perso, Image img){
        this.entite = perso;
        this.img = img;
    }
    
    @Override
    public void dessiner(GraphicsContext g){
        //vérifier l'utilisation de unite, parce que coord peut être en pixel et non coord
        //g.drawImage(this.img, this.coordX * unite, this.coordY * unite, unite, unite);
        g.drawImage(this.img, this.entite.getPosition().getX() * unite, this.entite.getPosition().getY() * unite, unite, unite);
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return entite.faitSonChoix(sallesAccessibles);
    }

    @Override
    public ISalle getPosition() {
        return this.entite.getPosition();
    }

    @Override
    public void setPosition(ISalle s) {
        this.entite.setPosition(s);
    }
}
