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

public class Level2 extends BasicGameState {
    int apples;

    
    Image Background,floor;
    
    int ax,ay;
    
    Rectangle ground, finish;

    SpriteSheet spriteID,spriteRR,spriteRL,spriteJ,spriteF,spriteH;
    Animation i,rr,rl,j,f,H;
    SpriteSheet spriteApple;
    Animation Apple;
    SpriteSheet spriteFlag;
    Animation Flag;
    MainCharacter Franklen;
    
    Apple[] Apples = new Apple[10];
    
    SpriteSheet Dead;
    Animation die;

    
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
    ax = (int)(Math.random()* 750);
    ay = (int)(Math.random()* 100) + 400;
        
    apples = 0;
        
    Dead = new SpriteSheet("Images/Free/Main Characters/Desappearing (96x96).png",32,32);
    die = new Animation(Dead,50);
            
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
    
    spriteH = new SpriteSheet("Images/Free/Main Characters/Pink Man/Hit (32x32).png",32,32);
    H = new Animation(spriteH,50);
    //
    
    spriteApple = new SpriteSheet("Images/Free/Items/Fruits/Apple.png",32,32);
    Apple = new Animation(spriteApple,50);
    
        for (int k = 0; k < Apples.length; k++) {
            Apples[k] = new Apple(ax,ay);
            ax = (int)(Math.random()* 750);
            ay = (int)(Math.random()*100) + 400;
        }
    
    //
    Background=new Image("Images/Free/Background/Pink.png");
    floor=new Image("Images/Free/Terrain/Floor1.png");
    
    spriteFlag = new SpriteSheet("Images/Free/Items/Checkpoints/Checkpoint/Checkpoint (Flag Idle)(64x64).png",64,64);
    Flag = new Animation(spriteFlag,50);
    
    Franklen = new MainCharacter(100,50,10,2,10,500,i,rr,rl,j,f,H,false,false,true,true);

    
    ground = new Rectangle(0,552,805,48);
    
    finish = new Rectangle(780,512,25,40);
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
            for (int k = 0; k < Apples.length; k++) {
                if(Franklen.getHitBox().intersects(Apples[k].getHitbox())&&Apples.length>0){
                    
                Apples[k].setX(1000);
                    
                apples++;
                }
        }
            

            if(finish.intersects(Franklen.getHitBox())&&apples==10){
                sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
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
    
    g.setColor(Color.black);
    
    g.drawString("Collect all the apples to win", 375, 10);

    
    Flag.draw(finish.getX()-25, finish.getY()-24);
    
    Franklen.getAnimation().draw(Franklen.getXP(),Franklen.getYP());
    
        for (int k = 0; k < Apples.length; k++) {
            Apples[k].draw(Apple);
           // g.fill(Apples[k].getHitbox());
        }

    
    
    
    //g.fill(Franklen.getHitBox());
    
    //g.fill(Bob.getHitBox());
    
    
    }
    
    public int getID() {
       return 3;  //this id will be different for each screen
    }

    
}
