
import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author etha6200
 */
public class Apple {
    int x,y;
    
    Rectangle hitbox;
    public Apple(int X, int Y){
        x=X;
        y=Y;
        hitbox = new Rectangle(x,y,32,32);
    }
    
    public void draw( Animation a){
       a.draw(x, y);
       hitbox.setX(x);
       hitbox.setY(y);
       
    }
    
    public Rectangle getHitbox(){
        return hitbox;
    }
    
    public void setX(int X){
        x=X;
    }
}
