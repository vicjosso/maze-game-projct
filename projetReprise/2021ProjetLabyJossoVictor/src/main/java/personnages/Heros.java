package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 *
 * @author vjosso
 */
public class Heros extends APersonnage{
    
    //pas fini
    ISalle salleChoisie;
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles){
        
        return this.salleChoisie;
    }
}
