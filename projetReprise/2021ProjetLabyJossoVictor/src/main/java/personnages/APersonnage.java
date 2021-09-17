package personnages;

import labyrinthe.ISalle;

/**
 * Classe de gestion des personnages
 * 
 * @author vjosso
 */
public abstract class APersonnage implements IPersonnage{
    
    protected ISalle position;
    
    /**
     * Permet d'obtenir la position
     * 
     * @return la position
     */
    @Override
    public ISalle getPosition(){
        return position;
    }
    
    /**
     * Permet de définir une position
     * 
     * @param s, nouvelle position
     */
    @Override
    public void setPosition( ISalle s){
        this.position = s;
    }
}
