package vue2D.javafx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import labyrinthe.ILabyrinthe;
import vue2D.IVue;
import vue2D.AVue;
import static vue2D.javafx.Dessin.tampon;
import vue2D.sprites.ISprite;

/**
 * Classe de gestion de la Vue
 * 
 * @author INFO Professors team
 */
public class Vue extends AVue implements IVue {

    Dessin dessin;
    ILabyrinthe labyrinthe;
    public Scene scene;

    /**
     * Constructeur de Vue
     * 
     * @param labyrinthe, labyrinthe sur lequel on joue 
     */
    public Vue(ILabyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        dessin = new Dessin(labyrinthe, this);
        Group root = new Group();
        this.scene = new Scene(root);
        root.getChildren().add(dessin);
    }

    /**
     * Méthode de dessin du labyrinthe
     */
    @Override
    public void dessiner() {
        // recopie du fond (image); murs + salles
        dessin.dessinFond();
        dessin.dessinLab();

        for (ISprite sprite : this) {
            sprite.dessiner(tampon);
        }
    }

    /**
     * Redéfinition de la méthode add
     * 
     * @param sprite, entité à vérifié
     * @return vrai si sprite est bon
     */
    @Override
    public boolean add(ISprite sprite) {
        super.add(sprite);
        //si le sprite est controle par le clavier
        if (sprite instanceof EventHandler) {
            //System.out.println("registering keylistener");
            //association de l'ecouteur sur le clavier avec le composant graphique principal
            this.scene.setOnKeyPressed((EventHandler) sprite);
        }
        return true;
    }

}
