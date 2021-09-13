package personnages;

import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import vue2D.sprites.ASprite;

/**
 *
 * @author vjosso
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent>{

    //
    // implémentation de toutes les méthodes encore nécessaire
    //
    
    private static Image image = new Image("file:icons/link/LinkRunShieldL1.gif");
    
    public HerosSprite(IPersonnage perso){
        super(perso, image);
    }
    
    @Override
    public void handle(KeyEvent event){
        //code de type mytérieux test, pas sûr du fonctionnement
        Heros heros = (Heros) entite;
        switch(event.getCode()){
            case UP:
                heros.salleChoisie = new Salle(this.entite.getPosition().getX(), this.entite.getPosition().getY()-1);
                break;
            case RIGHT:
                heros.salleChoisie = new Salle(this.entite.getPosition().getX()+1, this.entite.getPosition().getY());
                break;
            case DOWN:
                heros.salleChoisie = new Salle(this.entite.getPosition().getX(), this.entite.getPosition().getY()+1);
                break;
            case LEFT:
                heros.salleChoisie = new Salle(this.entite.getPosition().getX()-1, this.entite.getPosition().getY());
                break;
            default:
                break;
        }
    }
    
}
