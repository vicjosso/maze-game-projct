package personnages;

import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.ISalle;
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
    
    public HerosSprite(){
        super(image);
    }
    
    public void handle(KeyEvent event){
        switch(event.getCode()){
            case UP:
                
                break;
            case RIGHT:
                
                break;
            case DOWN:
                
                break;
            case LEFT:
                
                break;
            default:
                
                break;
        }
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
