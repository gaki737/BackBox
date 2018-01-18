package MoveTest;


import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.JFrame;


// Hauptklasse
public class MoveTest {
    public static void RunGame(int width, int height, int bitDepth, int refreshRate, boolean fullscreen, boolean customResolution) {
        
        //Spieler, Hintergrund und das Frame werden erstellt. 
        
    	
    	LinkedList<Bullet> bullets = new LinkedList<Bullet>();
        Player player = new Player(300, 300, 50, width, height, bullets);
        Background bg = new Background(100);
        Frame f = new Frame(player, bg, bullets);
        
        //Das Frame wird gesetzt
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(width, height);
        f.setUndecorated(true);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.makeStrat();

//      Fullscreen funktioniert auf meinem System nicht so ganz da ich keinen Desktop
//      sondern einen WindowManager habe, deswegen lasse ich den Fullscreen aussen vor.
        DisplayMode displayMode = new DisplayMode (width, height, bitDepth, refreshRate);
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = environment.getDefaultScreenDevice();
        
        if (fullscreen = true) {
			device.setFullScreenWindow(f);
		}
		
        
		//Commented this out cause i switched my desktop to Linux and used closed nvidia driver and this driver is bullshit
		
        if (customResolution = false) {
			device.setDisplayMode(displayMode);
		}
		long lastFrame = System.currentTimeMillis();
        
        //Ein Loop der abfragen taetigt die durchgehend laufen muessen.
        while(true){
            if(Keyboard.isKeyDown(KeyEvent.VK_ESCAPE))System.exit(0);
            long thisFrame = System.currentTimeMillis();
            float timeSinceLastFrame = ((float)(thisFrame-lastFrame)) / 1000f;
            lastFrame = thisFrame;
            
            player.update(timeSinceLastFrame);
            bg.update(timeSinceLastFrame);
            f.repaintScreen();
            
            for(int i = 0; i<bullets.size(); i++){
            	bullets.get(i).update(timeSinceLastFrame);
            }
            
            //To fix massive lags with the Linux, flushes the Graphics buffer which Linux uses.
            Toolkit.getDefaultToolkit().sync();
            
            
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
    
}