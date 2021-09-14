package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 *
 * @author vjosso
 */
public class Heros extends APersonnage{
    
    public ISalle salleChoisie;
    
    public Heros(ISalle entree){
        this.position = entree;
        this.salleChoisie = entree;
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles){
        if(sallesAccessibles.contains(salleChoisie)){
            return this.salleChoisie;
        } else {
            return position;
        }
    }
}
