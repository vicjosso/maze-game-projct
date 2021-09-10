package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 *
 * @author vjosso
 */
public class Heros extends APersonnage{
    
    //pas fini
    public ISalle salleChoisie;
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles){
        if(sallesAccessibles.contains(salleChoisie)){
            return this.salleChoisie;
        } else {
            return position;
        }
        
    }
}
