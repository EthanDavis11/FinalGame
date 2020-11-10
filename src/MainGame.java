import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MainGame extends BasicGameState {
    Image Background,floor;
    
    Rectangle ground;

    SpriteSheet spriteID,spriteRR,spriteRL,spriteJ,spriteF;
    Animation i,rr,rl,j,f;
    MainCharacter Franklen;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    
    spriteID = new SpriteSheet("Images/Free/Main Characters/Pink Man/Idle (32x32).png",32,32);
    i = new Animation(spriteID,50);
    
    spriteRR = new SpriteSheet("Images/Free/Main Characters/Pink Man/Run (32x32).png",32,32);
    rr = new Animation(spriteRR,50);
    
    spriteRL = new SpriteSheet("Images/Free/Main Characters/Pink Man/Run2 (32x32).png",32,32);
    rl = new Animation(spriteRL,50);
    
    spriteJ = new SpriteSheet("Images/Free/Main Characters/Pink Man/Jump (32x32).png",32,32);
    j = new Animation(spriteJ,50);
    
    spriteF = new SpriteSheet("Images/Free/Main Characters/Pink Man/Fall (32x32).png",32,32);
    f = new Animation(spriteF,50);
    
    Background=new Image("Images/Free/Background/Blue.png");
    floor=new Image("Images/Free/Terrain/Floor1.png");
    
    Franklen = new MainCharacter(100,50,10,1,10,500,i,rr,rl,j,f,false,false);
    
    ground = new Rectangle(0,552,805,48);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        
        //Input in = gc.getInput();
        
            
            //spriteID = new SpriteSheet("Images/Free/Main Characters/Pink Man/Run (32x32).png",32,32);
            //CA = new Animation(spriteID,50);

            //spriteID = new SpriteSheet("Images/Free/Main Characters/Pink Man/Run2 (32x32).png",32,32);
            //CA = new Animation(spriteID,50);
        
            Franklen.CheckMove(gc);
            
            if(ground.getY()<=Franklen.getYP()+32){
                Franklen.setGround(true);
            }
            else{
                Franklen.setGround(false);
            }
        }
    
        
    

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        for (int i = 0; i < 800; i+=64) {
            for (int j = 0; j < 600; j+=64) {
                   Background.draw(i,j);
            }
        }
        
        for (int i = 0; i < 800; i+=48) {
                    floor.draw(i,552);
                    
            
        }
        
    g.setColor(Color.yellow);
    
    Franklen.getAnimation().draw(Franklen.getXP(),Franklen.getYP());
    
    }
    
    public int getID() {
       return 2;  //this id will be different for each screen
    }

    
}
