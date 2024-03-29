package application;

import java.io.IOException;
import java.util.Collection;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.HerosSprite;
import personnages.IPersonnage;
import personnages.MonstreSprite;
import vue2D.IVue;
import vue2D.sprites.ISprite;

/**
 *
 * @author INFO Professors team
 */
public class Core {
    ISprite heros;
    ILabyrinthe labyrinthe;
    private int nbMonstre = 10;

    /**
     * Initialise le labytinthe
     */
    protected void initLabyrinthe() {
        // creation du labyrinthe
        labyrinthe = new labyrinthe.Labyrinthe();
        chargementLaby("labys/level3.txt");
    }

    /**
     * Initialise les sprites
     * 
     * @param vue, contexte graphique
     */
    protected void initSprites(IVue vue) { 
        IPersonnage h = new personnages.Heros(labyrinthe.getEntree());
        this.heros = new HerosSprite(h); //paramètre labyrinthe retiré
        vue.add(this.heros);
        for(int i = 0; i < nbMonstre; i++) vue.add(new MonstreSprite(new personnages.Monstre(labyrinthe.getSortie()))); //spawn des monstres
    }

    /**
     * Gère le jeu
     * 
     * @param vue, contexte graphique
     */
    protected void jeu(IVue vue) {
        // boucle principale
        ISalle destination = null;
        while (!labyrinthe.getSortie().equals(heros.getPosition())) {
            // choix et deplacement
            for (IPersonnage p : vue) {
                Collection<ISalle> sallesAccessibles = labyrinthe.sallesAccessibles(p);
                destination = p.faitSonChoix(sallesAccessibles); // on demande au personnage de faire son choix de salle
                p.setPosition(destination); // deplacement
            }
            // detection des collisions
            boolean collision = false;
            ISprite monstre = null;
            for (ISprite p : vue) {
                if (p != heros) {
                    if (p.getPosition().equals(heros.getPosition())) {
                        System.out.println("Collision !!");
                        collision = true;
                        monstre = p;
                    }
                }
            }
            if (collision) {
                vue.remove(monstre);
                vue.remove(heros);
                System.out.println("Perdu !");
                System.out.println("Plus que " + vue.size() + " personnages ...");
                //respawn du héros
                heros.setPosition(labyrinthe.getEntree());
                vue.add(heros);
            }

            temporisation(50);
        }
        System.out.println("Gagné!");
    }

    /**
     * Chargement du fichier à partir d'un nom
     * 
     * @param fic, nom du fichier 
     */
    private void chargementLaby(String fic) {
        try {
            labyrinthe.creerLabyrinthe(fic);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Gère la vitesse d'éxécution du jeu
     * 
     * @param nb, temps de pause en millisecondes
     */
    protected void temporisation(int nb) {
        try {
            Thread.sleep(nb); // pause de nb millisecondes
        } catch (InterruptedException ie) {
        };
    }
}
