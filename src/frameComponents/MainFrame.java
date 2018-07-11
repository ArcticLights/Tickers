// © Bailey Danseglio 2018 //

package frameComponents;

//Swing
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

//Project Imports
import webSocket.GetPriceStock;
import webSocket.GetPercentStock;
import frameComponents.CryptoFrame.*;
import frameComponents.ClearFrame.*;
import frameComponents.DisplayTime.*;
import frameComponents.Comm;

//Handlers
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainFrame {
	
    static JButton cats[];
    static JButton close;
    public static JLabel time;
    
	static Font timeFont = new Font("serif", Font.PLAIN, 64);
	public static Font backFont = new Font("monospaced", Font.BOLD, 24);
	public static Font closeFont = new Font("serif" , Font.PLAIN, 14);
	public static Font copyFont = new Font("monospaced", Font.BOLD, 16);
	
	public static boolean enable = true;
    public static boolean marketOpen = false;
	public static boolean cryptoPressed = false;
	public static boolean indexPressed = false;
	public static boolean nysePressed = false;
	public static boolean commPressed = false;
	public static boolean run = true;
	public static boolean runTime = true;
	public static boolean backPressed = true;
	
    public static JFrame mainFrame = new JFrame("Tickers 1.6");
    public static JButton back;
    public static JLabel marketStatus;
    public static JLabel copyright;
    public static int posX;
    public static int posY;
    public static Color DARK_RED = new Color(180, 0,0);
    
    public static void createMainFrame() {

    	enable = true; 
    	
		//Time
		time = new JLabel("", SwingConstants.CENTER);
		mainFrame.getContentPane().add(time);
		time.setSize(500,150);
		time.setFont(timeFont);
		time.setLocation(450,0);
		time.setForeground(Color.LIGHT_GRAY);
		
		//Back Button
		back = new JButton("Back");
		mainFrame.getContentPane().add(back);
		back.setSize(150,20);
		back.setLocation(1100,660);
		back.setVisible(false);
		back.setForeground(DARK_RED);
		back.setBorderPainted(false);
		back.setBackground(null);
		back.setFocusPainted(false);
    	back.setContentAreaFilled(false);
    	back.setFont(backFont);
    	
    	
		//Close Button
		close = new JButton("X");
		mainFrame.getContentPane().add(close);
		close.setSize(50,50);
		close.setLocation(1240,-15);
		close.setForeground(Color.RED);
		close.setBorderPainted(false); 
        close.setContentAreaFilled(false); 
        close.setFocusPainted(false); 
		close.setFont(closeFont);
        close.setVisible(true);
		
		
		//Market Status Label
		marketStatus = new JLabel("" , SwingConstants.CENTER);
		mainFrame.getContentPane().add(marketStatus);
		marketStatus.setSize(150, 20);
		marketStatus.setLocation(625, 125);
		marketStatus.setForeground(null);
		
		
		//copyright label
		copyright = new JLabel("© Bailey Danseglio 2018, All rights reserved.");
		mainFrame.getContentPane().add(copyright);
		copyright.setSize(550,20);
		copyright.setLocation(550, 695);
		copyright.setForeground(Color.CYAN);
		copyright.setFont(copyFont);
		
		//Move
		mainFrame.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	            posX = e.getX();
	            posY = e.getY();
	        }
	    });
		
		mainFrame.addMouseMotionListener(new MouseAdapter() {
	        public void mouseDragged(MouseEvent evt) {
	            //sets frame position when mouse dragged            
	        	
	            mainFrame.setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
	        }
		});
		
        cats = new JButton[6];

        

        for(int i = 0; i < Array.getLength(cats); i++) {
        	
            cats[i] = new JButton(String.valueOf(i));

        		
                cats[i].setSize(150,20);
                cats[i].setLocation(50,20 + i * 45);
                cats[i].setBorder(null);
                cats[i].setBorderPainted(false);
                cats[i].setFocusPainted(false);
                cats[i].setBackground(Color.DARK_GRAY);
                mainFrame.getContentPane().add(cats[i]);
        }
        
      cats[Array.getLength(cats) - 1].setVisible(false);

      
      	cats[0].setText("CRYPTO");
      	
      	cats[1].setText("INDICIES");
      	cats[2].setText("NYSE");
      	cats[3].setText("COMMODITIES");
      	cats[4].setText("ASIA");
      	cats[5].setVisible(false); //not programmed yet
      	cats[4].setVisible(false); //not programmed yet.
        mainFrame.setSize(1280,720);

        mainFrame.getContentPane().setBackground(Color.DARK_GRAY);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        
        if(!mainFrame.isVisible()) {
        mainFrame.setUndecorated(true);
        mainFrame.setLocationRelativeTo(null);
        }
        
        mainFrame.setVisible(true);

        close.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
        	
        });
        
		cats[0].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				time.setVisible(false);
				marketStatus.setVisible(false);
				
				for (int i = 0; i < cats.length; i++) {
				cats[i].setVisible(false);
				}
				runTime = false;
				cryptoPressed = true;
				back.setVisible(true);
				try {
					CryptoFrame.genCrypto();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}		
			}});
		
		cats[1].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				indexPressed = true;
				for (int i = 0; i < cats.length; i++) {
					cats[i].setVisible(false);
				}
				runTime = false;
				marketStatus.setVisible(false);
				back.setVisible(true);
				try {
					IndexFrame.genIndex();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}			
		});
		
		cats[2].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nysePressed = true;
				for (int  i = 0; i < cats.length; i++) {
					cats[i].setVisible(false);
				}
				runTime = false;
				backPressed = false;
				marketStatus.setVisible(false);
				back.setVisible(true);
				try {
					NYSE.genNYSE();
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		cats[3].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				commPressed = true;
				for (int i = 0; i < cats.length; i++) {
					cats[i].setVisible(false);
				}
				runTime = false;
				marketStatus.setVisible(false);
				back.setVisible(true);
				try {
					Comm.genComm();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		back.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					runTime = true;
					cryptoPressed = false;
					indexPressed = false;
					nysePressed = false;
					commPressed = false;
					backPressed = true;
					back.setVisible(false);
					
					for (int i = 0; i < cats.length; i++) {
					cats[i].setVisible(true);
					}
					
					try {
						ClearFrame.clearSection();
					} catch (IOException e1) {
					
						e1.printStackTrace();
					}

			}
		});
    }
	public static String updatePrice(String SYM) throws IOException {
		
		String price = GetPriceStock.getPrice(SYM);
		
		return price;
	}


    public static void main(String[] args) throws InterruptedException, IOException {
    	
    	createMainFrame();
		DisplayTime.showTime();
		
		run = true;
		while (run) {
			
			if (cryptoPressed) {
				time.setVisible(false);
				CryptoFrame.runCrypto();
				continue;
			}
			
			else if  (indexPressed) {
				time.setVisible(false);
				IndexFrame.runIndex();
				continue;
			}
			
			else if (nysePressed) {
				time.setVisible(false);
			NYSE.runNYSE();
				continue;
			}
			
			
			else if (commPressed) {
				time.setVisible(false);
				Comm.runComm();
				continue;
			}
			
				
				runTime = true;
				time.setVisible(true);
				marketStatus.setVisible(true);
				DisplayTime.showTime();
				continue;
			}
			
		}
	
    }	

