package MoveTest;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;

public class showDisplayModes {
	
	
	
    public static void main(String[] args) {
    GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = environment.getDefaultScreenDevice();
    int c = 0;
    int resolutionCount = 0;
    int c2 = 0;
    int displayList[][] = new int[100][4];
    
    
    DisplayMode[] ds = device.getDisplayModes();
    
    for(int i = 0; i<ds.length; i++){
        //System.out.println(ds[i].getWidth()+", "+ds[i].getHeight()+", "+ds[i].getBitDepth()+", "+ds[i].getRefreshRate());
        displayList[resolutionCount][c2++] = ds[i].getWidth();
        //System.out.println(c2);
        displayList[resolutionCount][c2++] = ds[i].getHeight();
        //System.out.println(c2);
        displayList[resolutionCount][c2++] = ds[i].getBitDepth();
        //System.out.println(c2);
        displayList[resolutionCount][c2++] = ds[i].getRefreshRate();
        //System.out.println(c2);
        for(c = 0; c < 4; c++) {
        	//System.out.println(displayList[resolutionCount][c]);
        }
        resolutionCount++;
        c2 = 0;
        c = 0;
    	}
    }
    
    //getter
    
    public static int[][] getDisplayList(int[][] displayList) {
    	return displayList;
    	//return Arrays.copyOf(displayList, displayList.length);
    }
        
    public int getResolutionCount(int resolutionCount) {
    	
    	System.out.println(resolutionCount);
    	return resolutionCount;
    }

    
}
