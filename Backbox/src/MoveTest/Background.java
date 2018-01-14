/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author anon
 */
public class Background {
    private float f_posx;
    private float f_speed;
    private BufferedImage look;
    
    public Background(float f_speed){
        this.f_speed = f_speed;
        try {
            look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/weltraum.png"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update (float timeSinceLastFrame){
        f_posx-=f_speed*timeSinceLastFrame;
        if(f_posx<-look.getWidth())f_posx+=look.getWidth();
    }
    public int getX(){
        return (int)f_posx;
    }
    public BufferedImage getLook(){
        return look;
    }
}