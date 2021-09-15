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
public abstract class ASprite implements ISprite {

    protected IPersonnage entite;
    protected Image img;
    private ISalle oldPos;
    private final int unite = 15;
    private final float lerpSpeed = 0.7f;

    public ASprite(IPersonnage perso, Image img) {
        this.entite = perso;
        this.img = img;
        this.oldPos = this.entite.getPosition();
    }

    @Override
    public void dessiner(GraphicsContext g) {
        //g.drawImage(this.img, this.entite.getPosition().getX() * unite, this.entite.getPosition().getY() * unite, unite, unite);
        
        g.drawImage(this.img, 
                lerp(this.oldPos.getX(), this.entite.getPosition().getX()) * unite, 
                lerp(this.oldPos.getY(), this.entite.getPosition().getY()) * unite,
                unite,
                unite);
        
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
        this.oldPos = this.entite.getPosition();
        this.entite.setPosition(s);
    }

    float lerp(float a, float b) {
        return a + lerpSpeed * (b - a);
    }
}
