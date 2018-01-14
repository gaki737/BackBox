/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author anon
 */
public class Keyboard implements KeyListener {

    private static boolean[] keys = new boolean[512];
    public static boolean isKeyDown(int keyCode){
        if(keyCode>=0&&keyCode<keys.length) return keys[keyCode];
        else return false;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode>=0&&keyCode<keys.length) keys[keyCode]= true;
    }    
 
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode>=0&&keyCode<keys.length) keys[keyCode]= false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
}
