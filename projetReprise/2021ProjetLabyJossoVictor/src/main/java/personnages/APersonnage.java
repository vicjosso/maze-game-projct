package personnages;

import labyrinthe.ISalle;

/**
 *
 * @author vjosso
 */
public abstract class APersonnage implements IPersonnage{
    
    public ISalle position;
    
    @Override
    public ISalle getPosition(){
        return position;
    }
    
    @Override
    public void setPosition( ISalle s){
        this.position = s;
    }
}
