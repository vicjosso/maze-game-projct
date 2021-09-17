package personnages;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.Salle;
import vue2D.sprites.ASprite;

/**
 * Classe de gestion du Sprite du Heros
 * 
 * @author vjosso
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent>{
    
    /**
     * Initialisation des images du héros
     */
    private final static Image imgL = new Image("file:icons/link/LinkRunShieldL1.gif");
    private final static Image imgU = new Image("file:icons/link/LinkRunU1.gif");
    private final static Image imgR = new Image("file:icons/link/LinkRunR1.gif");
    private final static Image imgD = new Image("file:icons/link/LinkRunShieldD1.gif");

    /**
     * Constructeur de HerosSprite
     * 
     * @param perso, personnage du héros
     */
    public HerosSprite(IPersonnage perso){
        super(perso, imgD);
    }
    
    /**
     * Méthode de gestion du déplacement du personnage
     * 
     * @param event 
     */
    @Override
    public void handle(KeyEvent event){
        Heros heros = (Heros) entite;
        switch(event.getCode()){
            case UP:
                this.img = imgU;
                heros.salleChoisie = new Salle(this.entite.getPosition().getX(), this.entite.getPosition().getY()-1);
                break;
            case RIGHT:
                this.img = imgR;
                heros.salleChoisie = new Salle(this.entite.getPosition().getX()+1, this.entite.getPosition().getY());
                break;
            case DOWN:
                this.img = imgD;
                heros.salleChoisie = new Salle(this.entite.getPosition().getX(), this.entite.getPosition().getY()+1);
                break;
            case LEFT:
                this.img = imgL;
                heros.salleChoisie = new Salle(this.entite.getPosition().getX()-1, this.entite.getPosition().getY());
                break;
            default:
                break;
        }
    }
    
}
