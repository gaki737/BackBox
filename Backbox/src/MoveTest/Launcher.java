package MoveTest;

import java.awt.BorderLayout;
import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;

public class Launcher extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher frame = new Launcher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Launcher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnLaunch = new JButton("Launch");
		btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnLaunch, BorderLayout.SOUTH);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(table, BorderLayout.CENTER);
		
		
		
//		showDisplayModes sDP = new showDisplayModes();		
//		
//		sDP.main(null);
//		
//		int resolutionCount = 0;
//		resolutionCount = sDP.getResolutionCount(resolutionCount);
//		
//		int displayList[][] = new int[100][4];
//		displayList = sDP.getDisplayList(displayList);
//		
//		int c1 = 0, c2 = 0;
//		int temp;
//		
//		
//		
//		for(int i = 0; i <= resolutionCount; i++) {
//			temp = displayList[2][1];
//			//System.out.println(temp);
//		}
		
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
}
