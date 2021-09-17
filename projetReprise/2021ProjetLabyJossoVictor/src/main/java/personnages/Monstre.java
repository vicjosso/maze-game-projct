package personnages;

import java.util.Collection;
import labyrinthe.ISalle;
import labyrinthe.Salle;

/**
 * Classe de gestion de Monstre
 * 
 * @author vjosso
 */
public class Monstre extends APersonnage{

    public ISalle salleChoisie;
    private int cooldown = 5;
    private int frames = 0;
    
    /**
     * Constructeur de Monstre
     * 
     * @param spawn, position d'apparition du monstre
     */
    public Monstre(ISalle spawn){
        this.position = spawn;
        this.salleChoisie = spawn;
    }
    
    /**
     * Méthodes de sélection de salle de déplacement aléatoire pour le monstre
     * 
     * @param sallesAccessibles, liste des salles accessibles
     * @return la salle choisie
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles){
        frames++;
        deplacementMonstre();
        if(frames == cooldown){
            if(sallesAccessibles.contains(salleChoisie)){
                this.frames = 0;
                return this.salleChoisie;
            }
            this.frames = 0;
            return position;
        } else {
            return position;
        }
    }
    
    /**
     * Choisi un déplacement pour le monstre
     */
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
