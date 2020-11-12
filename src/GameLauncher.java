import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class GameLauncher extends StateBasedGame {

    public GameLauncher(String title) {
        super(title);
    }
    
    public void initStatesList(GameContainer gc) throws SlickException {
       this.addState(new StartScreen());
       this.addState(new LevelSelect());
       this.addState(new MainGame());
       this.addState(new Level2());
       this.addState(new Level3());
       this.addState(new EndScreen());
    }

    public static void main(String args[]) throws SlickException {
        GameLauncher game = new GameLauncher("Totally Not a Nitrome Ripoff");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 600, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}