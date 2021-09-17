package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 * Classe de gestion du Heros
 * 
 * @author vjosso
 */
public class Heros extends APersonnage{
    
    public ISalle salleChoisie;
    
    /**
     * Constructeur de Heros
     * 
     * @param entree, entrée du labyrinthe
     */
    public Heros(ISalle entree){
        this.position = entree;
        this.salleChoisie = entree;
    }
    
    /**
     * Vérifie la validité du choix de l'entité et retourne en fonction du résultat
     * 
     * @param sallesAccessibles, salles pouvant être accessible depuis l'entité
     * @return la salle définit
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles){
        if(sallesAccessibles.contains(salleChoisie)){
            return this.salleChoisie;
        } else {
            return position;
        }
    }
}
