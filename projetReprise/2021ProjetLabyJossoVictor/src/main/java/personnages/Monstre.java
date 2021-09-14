package personnages;

import java.util.Collection;
import labyrinthe.ISalle;
import labyrinthe.Salle;

/**
 *
 * @author vjosso
 */
public class Monstre extends APersonnage{

    public ISalle salleChoisie;
    public int cooldown;
    
    public Monstre(ISalle spawn){
        this.position = spawn;
        this.salleChoisie = spawn;
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles){
        deplacementMonstre();
        if(sallesAccessibles.contains(salleChoisie)){
            return this.salleChoisie;
        } else {
            return position;
        }
    }
    
    public void deplacementMonstre(){
        
        int min = 1; 
        int max = 4;
        int range = max - min + 1;
        
        int i = (int) (Math.random()*range)+min;
        
        switch(i){
            case 1:
                this.salleChoisie = new Salle(this.getPosition().getX(), this.getPosition().getY()-1);
                break;
            case 2:
                this.salleChoisie = new Salle(this.getPosition().getX(), this.getPosition().getY()+1);
                break;
            case 3:
                this.salleChoisie = new Salle(this.getPosition().getX()-1, this.getPosition().getY());
                break;
            case 4:
                this.salleChoisie = new Salle(this.getPosition().getX()+1, this.getPosition().getY());
                break;
            default:
                break;
        }
    }
    
}
