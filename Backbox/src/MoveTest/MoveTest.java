package MoveTest;


import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;


// Hauptklasse
public class MoveTest {
    public static void main(String[] args) {
        
        //Spieler, Hintergrund und das Frame werden erstellt. 
        
        Player player = new Player(300, 300, 50, 1280, 800);
        Background bg = new Background(100);
        Frame f = new Frame(player, bg);
        
        //Das Frame wird gesetzt
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.setUndecorated(true);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.makeStrat();

//      Fullscreen funktioniert auf meinem System nicht so ganz da ich keinen Desktop
//      sondern einen WindowManager habe, deswegen lasse ich den Fullscreen außen vor.
        DisplayMode displayMode = new DisplayMode (1280, 800, -1, 60);
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = environment.getDefaultScreenDevice();
        
        device.setFullScreenWindow(f);
        device.setDisplayMode(displayMode);
        long lastFrame = System.currentTimeMillis();
        
        //Ein Loop der abfragen tätigt die durchgehend laufen müssen.
        while(true){
            if(Keyboard.isKeyDown(KeyEvent.VK_ESCAPE))System.exit(0);
            long thisFrame = System.currentTimeMillis();
            float timeSinceLastFrame = ((float)(thisFrame-lastFrame)) / 1000f;
            lastFrame = thisFrame;
            
            player.update(timeSinceLastFrame);
            bg.update(timeSinceLastFrame);
            f.repaintScreen();
            
            
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
    
}