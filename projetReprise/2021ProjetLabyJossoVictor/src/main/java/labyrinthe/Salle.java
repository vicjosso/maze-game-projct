/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

/**
 *
 * @author vjosso
 */
public class Salle implements ISalle {
    
    protected int x;
    protected int y;
    
    public Salle(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int getX(){
        return x;
    }
    
    @Override
    public int getY(){
        return y;
    }
    
    @Override
    public boolean estAdjacente(ISalle autre){
        //méthode à vérifier
        boolean vertical = this.y+1 == autre.getY() || this.y-1 == autre.getY();
        boolean horizontal = this.x+1 == autre.getX() || this.x-1 == autre.getX();
        return vertical && horizontal;
    }
    
    @Override
    public boolean equals(Object o){
        if (o == this)  return true;
        
        if (!(o instanceof ISalle)) return false;
        
        ISalle other = (ISalle) o;
        
        return (other.getX() == this.getX() && other.getY() == this.getY());
    }
    
}
