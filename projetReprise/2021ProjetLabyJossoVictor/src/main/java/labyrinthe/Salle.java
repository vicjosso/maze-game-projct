package labyrinthe;

/**
 * Classe de gestion de Salle
 * 
 * @author vjosso
 */
public class Salle implements ISalle {
    
    protected int x;
    protected int y;
    
    /**
     * Constructeur de Salle
     * 
     * @param x, placement sur l'axe horizontal
     * @param y, placement sur l'axe vertical 
     */
    public Salle(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * Retourne la position sur l'axe horizontale
     * 
     * @return la valeur x
     */
    @Override
    public int getX(){
        return x;
    }
    
    
    /**
     * Retourne la position sur l'axe verticale
     * 
     * @return la valeur y
     */
    @Override
    public int getY(){
        return y;
    }
    
    
    /**
     * Vérifie si deux salles sont adjacentes
     * 
     * @param autre, salle de comparaison
     * @return vrai si la salle concerné est adjacente à celle rentré
     */
    @Override
    public boolean estAdjacente(ISalle autre){
        boolean vertical = this.y+1 == autre.getY() || this.y == autre.getY() || this.y-1 == autre.getY();
        boolean horizontal = this.x+1 == autre.getX() || this.x == autre.getX() || this.x-1 == autre.getX();
        return vertical && horizontal;
    }
    
    /**
     * Redéfinition de la méthodes equals
     * 
     * @param o, object de comparaison
     */
    @Override
    public boolean equals(Object o){
        if (o == this)  return true;
        
        if (!(o instanceof ISalle)) return false;
        
        ISalle other = (ISalle) o;
        
        return (other.getX() == this.getX() && other.getY() == this.getY());
    }
    
}
