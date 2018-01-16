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
import javax.swing.JComboBox;

public class Launcher extends JFrame {
	
	private Launcher frame;
	private JPanel contentPane;
	private JComboBox comboBox;
	
	private GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private GraphicsDevice device = environment.getDefaultScreenDevice();
    private DisplayMode[] ds = device.getDisplayModes();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher frame = new Launcher();
					frame.setVisible(true);
					frame.setResizable(false);
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JButton btnLaunch = new JButton("Launch");
		btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int chosenSetting = comboBox.getSelectedIndex();
				
				if(chosenSetting != -1){
					MoveTest game = new MoveTest();
					//game.RunGame(ds[chosenSetting].getWidth(), ds[chosenSetting].getHeight(), ds[chosenSetting].getBitDepth(), ds[chosenSetting].getRefreshRate());
					frame.dispose();
				}
				
			}
		});
		contentPane.add(btnLaunch, BorderLayout.SOUTH);
		
		comboBox = new JComboBox();
		contentPane.add(comboBox, BorderLayout.NORTH);
		
	     
	   	for(DisplayMode displayMode : ds){
	   		comboBox.addItem(displayMode.getWidth() + "x" + displayMode.getHeight() + " " + displayMode.getRefreshRate() + " " + displayMode.getBitDepth());
	   	}
	    
	}
}
