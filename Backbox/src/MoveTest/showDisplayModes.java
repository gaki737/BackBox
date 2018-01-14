package MoveTest;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

public class showDisplayModes {
    public static void main(String[] args) {
    GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = environment.getDefaultScreenDevice();
    int c1 = 0;
    int c2 = 0;
    int displayList[][] = new int[c1][c2];
    
    
    DisplayMode[] ds = device.getDisplayModes();
    
    for(int i = 0; i<ds.length; i++){
        System.out.println(ds[i].getWidth()+", "+ds[i].getHeight()+", "+ds[i].getBitDepth()+", "+ds[i].getRefreshRate());
        displayList[c1][c2] = ds[i].getWidth();
        displayList[c1][c2++] = ds[i].getHeight();
        displayList[c1][c2++] = ds[i].getBitDepth();
        displayList[c1][c2++] = ds[i].getRefreshRate();
        c2 = 0;
        
    	}
    }

    
}
