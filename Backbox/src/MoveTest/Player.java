package MoveTest;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Player {
    private Rectangle bounding;
    private float f_posx;
    private float f_posy;
    private int worldsize_x;
    private int worldsize_y;
    private BufferedImage look;
    private LinkedList<Bullet> bullets;
    private float timeSinceLastShot = 0;
    private final float SHOTFREQUENZY = 0.1f;
    
    public Player (int x, int y, int size, int worldsize_x, int worldsize_y, LinkedList<Bullet> bullets){
        try {
            look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/raumschiffchen.png"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        bounding = new Rectangle(x, y, look.getWidth(), look.getHeight());
        f_posx = x;
        f_posy = y;
        this.worldsize_x = worldsize_x;
        this.worldsize_y = worldsize_y;
        this.bullets = bullets;
        

    }



    
    
    public void update (float timeSinceLastFrame){
        
    	timeSinceLastShot+=timeSinceLastFrame;
    	
        //Hier wird die Bewegungssteuerung an den Player uebergeben
        if(Keyboard.isKeyDown(KeyEvent.VK_W))f_posy-=300*timeSinceLastFrame;
        if(Keyboard.isKeyDown(KeyEvent.VK_S))f_posy+=300*timeSinceLastFrame;
        if(Keyboard.isKeyDown(KeyEvent.VK_D))f_posx+=300*timeSinceLastFrame;
        if(Keyboard.isKeyDown(KeyEvent.VK_A))f_posx-=300*timeSinceLastFrame;
        if(timeSinceLastShot>SHOTFREQUENZY&&Keyboard.isKeyDown(KeyEvent.VK_SPACE)){
        	timeSinceLastShot = 0;
        	bullets.add(new Bullet(f_posx, f_posy, 500, 0));
        }
         
        if(f_posx<0)f_posx=0;
        if(f_posy<0)f_posy=0;
        if(f_posx>worldsize_x-bounding.width)f_posx=worldsize_x-bounding.width;
        if(f_posy>worldsize_y-bounding.height)f_posy=worldsize_y-bounding.height;
    
         
        bounding.x=(int)f_posx;
        bounding.y=(int)f_posy;
         
         
        
    }
    public Rectangle getBounding(){
        return bounding;
    }
    
    public BufferedImage getLook(){
        return look;
    }
}

