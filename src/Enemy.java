
import org.newdawn.slick.Animation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ethan
 */
public class Enemy extends Character{
    
    Boolean see=false;
    
    public Enemy(int h, int d, int l, int s, int x, int y, Animation ii, Animation irr, Animation irl, Animation ij, Animation ifa, Animation hit, Boolean g, Boolean jm,Boolean cm,Boolean cm2) {
        super(h, d, l, s, x, y, ii, irr, irl, ij, ifa,hit, g, jm,cm,cm2);
    }
    
    public boolean seePlayer(MainCharacter f){
        if(f.getXP()-XP >= -150 && f.getXP()-XP <= 150 && f.getYP()-YP >= -150 &&f.getYP()-YP <= 150){ 
        see=true;
        return true;
    }
        else{
            see=false;
            return false;
        }
    }
    
    public void MoveToPlayer(MainCharacter f){
        if(f.getXP()>XP){
            XP+=speed;
            Ani=rr;
        }
        else if(f.getXP()<XP){
            XP-=speed;
            Ani=rl;
        }
        
        
    }
    
    public void CheckMove(){
        Hitbox.setX(XP);
        Hitbox.setY(YP);
        if(ground==false){
        Ani = f;
        YP+=speed;
        }
        
        if(see==false&&ground==true){
            Ani=i;
        }
    }
    
}
