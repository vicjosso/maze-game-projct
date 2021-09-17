package vue2D.sprites;

import java.util.Collection;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ISalle;
import personnages.IPersonnage;

/**
 * Classe de gestion de ASprite (entité)
 * 
 * @author vjosso
 */
public abstract class ASprite implements ISprite {

    protected IPersonnage entite;
    protected Image img;
    private ISalle oldPos;
    private final int unite = 15;
    private final float lerpSpeed = 0.7f;

    /**
     * Constructeur de ASprite
     * 
     * @param perso, personnage concerné 
     * @param img, image lié au personnage
     */
    public ASprite(IPersonnage perso, Image img) {
        this.entite = perso;
        this.img = img;
        this.oldPos = this.entite.getPosition();
    }

    /**
     * Dessine le sprite concerné
     * 
     * @param g, context graphique 
     */
    @Override
    public void dessiner(GraphicsContext g) {
        //g.drawImage(this.img, this.entite.getPosition().getX() * unite, this.entite.getPosition().getY() * unite, unite, unite);
        
        g.drawImage(this.img, 
                lerp(this.oldPos.getX(), this.entite.getPosition().getX()) * unite, 
                lerp(this.oldPos.getY(), this.entite.getPosition().getY()) * unite,
                unite,
                unite);
    }

    /**
     * Permet à l'entité de choisir une salle
     * 
     * @param sallesAccessibles, ensemble des salles accessibles par l'entité
     * @return la salle choisie
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return entite.faitSonChoix(sallesAccessibles);
    }

    /**
     * Permet d'obtenir la position de l'entité
     * 
     * @return la position de l'entité 
     */
    @Override
    public ISalle getPosition() {
        return this.entite.getPosition();
    }

    /**
     * Méthode permettant de définir la position d'une entité, ainsi que son ancienne position 
     * 
     * @param s, futur position
     */
    @Override
    public void setPosition(ISalle s) {
        this.oldPos = this.entite.getPosition();
        this.entite.setPosition(s);
    }

    /**
     * Méthode permettant d'obtenir un déplacement du personnage plus fluide
     * 
     * @param a, point de départ
     * @param b, point d'arrivé
     * @return position après déplacement
     */
    float lerp(float a, float b) {
        return a + lerpSpeed * (b - a);
    }
}
