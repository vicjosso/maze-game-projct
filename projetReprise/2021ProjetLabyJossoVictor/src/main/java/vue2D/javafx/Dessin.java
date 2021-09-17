package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import vue2D.sprites.ISprite;

/**
* Classe de Dessin de l'interface
* 
* @author INFO Professors team
*/

public class Dessin extends Canvas {
    
    private Collection<ISprite> sprites;
    private ILabyrinthe labyrinthe;
    private int unite = 15;
    public static GraphicsContext tampon;
    private Image solImage;
    private Image saulImage;
    private Image sortieImg;
   
    /**
     * Constructeur de Dessin
     * 
     * @param labyrinthe, labyrinthe de jeu
     * @param sprites, ensemble des entités du jeu
     */
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites)
    {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        setWidth(labyrinthe.getLargeur()*unite);
        setHeight(labyrinthe.getHauteur()*unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond(); 
    }
    
    /**
     * Méthode de chargement des images
     */
     public void chargementImages(){
    	solImage = new Image("file:icons/pyramide.jpg");
        saulImage = new Image("file:icons/ground.gif");
        sortieImg = new Image("file:icons/sortie.gif");
    }
    
     /**
      * Méthode de chargement du fond de jeu
      */
    public void dessinFond(){
        tampon.drawImage(solImage,0,0,unite*labyrinthe.getLargeur(),
                unite*labyrinthe.getHauteur());
    }
    
    /**
     * Méthode de dessin du labyrinthe
     */
    public void dessinLab(){
        for(ISalle lab : labyrinthe){
            tampon.drawImage(saulImage, lab.getX() * unite, lab.getY() * unite, unite, unite);
        }
        tampon.drawImage(sortieImg, labyrinthe.getEntree().getX() * unite, labyrinthe.getEntree().getY() * unite, unite, unite);
        tampon.drawImage(sortieImg, labyrinthe.getSortie().getX() * unite, labyrinthe.getSortie().getY() * unite, unite, unite);
    }

}
