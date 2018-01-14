/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author anon
 */
@SuppressWarnings("serial")
public class Frame extends JFrame{
    
    final Player player;
    final Background bg;
       
    private BufferStrategy strat;
    
    
    public Frame(Player player, Background bg){
        super("MoveTest");
        addKeyListener(new Keyboard());
        this.player = player;
        this.bg = bg;
    
    }
    
    //Erstellt den Buffer um Screentearing zu verhindern.
    
    public void makeStrat(){
        createBufferStrategy(2);
        strat = getBufferStrategy();
    }
       
    
    public void repaintScreen(){
//      screen.repaint();
        Graphics g = strat.getDrawGraphics();
        draw(g);
        g.dispose();
        strat.show();
        
    }
    
    private void draw(Graphics g){
        g.drawImage(bg.getLook(), bg.getX(), 0, null);
        g.drawImage(bg.getLook(), bg.getX() + bg.getLook().getWidth(), 0, null);
        g.drawImage(player.getLook(), player.getBounding().x, player.getBounding().y, null);
            
    }
}