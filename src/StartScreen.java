import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class StartScreen extends BasicGameState {
Image Screen;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
   Screen = new Image("Images/wp.jpg");
   
   Screen = Screen.getScaledCopy(800,600);

    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
       Input in = gc.getInput();
       
       if(in.isKeyPressed(Input.KEY_SPACE)){
        sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
       }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       g.setColor(Color.yellow);
       
       g.drawString("Welcome",100,200);
       
       Screen.draw(0,0);
    }
    
    public int getID() {
       return 0;  //this id will be different for each screen
    }

    
}
