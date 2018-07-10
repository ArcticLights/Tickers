package algorithms;

import java.awt.Color;
import java.awt.Point;
import java.io.IOException;
import java.lang.reflect.Array;

import javax.swing.JButton;

import webSocket.GetPercentStock;
import webSocket.GetPriceStock;

public class JButtonArray extends frameComponents.MainFrame {

	public static boolean passed = false;
	public static boolean passed2 = false;
	public static void genPrices(JButton[] buttonArray, String [] symbols) throws IOException {
	
		int c = 0;
		int d = 0;
		int xPos = 0;
   		int yPos = 0;
   		String tempPosY = "";
   		boolean passed = false;
   		boolean passed2 = false;
		for(int i = 0; i < Array.getLength(buttonArray); i++) {
	        	
	            	buttonArray[i] = new JButton(String.valueOf(i));
	            
	                buttonArray[i].setSize(205,20);
	               
	                if (!passed) {
	                yPos = 30 + i * 35;
	                }	                
	                buttonArray[i].setLocation(50 + xPos, yPos);
	                mainFrame.getContentPane().add(buttonArray[i]);
	                buttonArray[i].setText(symbols[i]);
	                buttonArray[i].setBorderPainted(false);
	                buttonArray[i].setFocusPainted(false);
	                buttonArray[i].setBackground(Color.DARK_GRAY);
	                
	                
	                tempPosY = buttonArray[i].getLocation().toString().substring(buttonArray[i].getLocation().toString().indexOf("y=") + 2, buttonArray[i].getLocation().toString().indexOf("]"));
	                
	                if (Integer.parseInt(tempPosY) > 660 && !passed2) {
	                	xPos = 250;
	                	buttonArray[i].setLocation(50 + xPos, 30 + c * 35);
	                	c++;
	                	passed = true;
	                }
	                tempPosY = buttonArray[i].getLocation().toString().substring(buttonArray[i].getLocation().toString().indexOf("y=") + 2, buttonArray[i].getLocation().toString().indexOf("]"));
	                
	                
	                if(Integer.parseInt(tempPosY) > 660) {
	                xPos = 500;
	                buttonArray[i].setLocation(50 + xPos, 30 + d * 35);
	                d++;
	                passed2 = true;
	                	}
	                
	        }
		
		   buttonArray[Array.getLength(buttonArray) - 1].setVisible(false);
		   
	
		
	}
	
	public static void runPrices(JButton[] buttonArray, String [] symbols, boolean redoSym, String [] names) throws IOException {
		
		backPressed = false;
		
		for (int i = 0; i < Array.getLength(buttonArray); i++){
			
			
			if (backPressed) {
				i = 0;
				break;
			}
			
			
			String temp = symbols[i] + ": " + GetPriceStock.getPrice(symbols[i]) + "  " + GetPercentStock.getPercent(symbols[i]);
			buttonArray[i].setText(temp);
		
			 if (temp.contains("\"")) {
	         	buttonArray[i].setText(temp.substring(0, temp.indexOf("\"") - 1) + " " + temp.substring(temp.indexOf("\"") + 1, temp.length()));

	         }
			if (temp.contains("-")) {
				buttonArray[i].setBackground(Color.RED);
				buttonArray[i].setOpaque(true);
			}
			
			else {
				buttonArray[i].setBackground(Color.GREEN);
				buttonArray[i].setOpaque(true);
				}
			
			if (redoSym) {
				ChangeSymbol.changeSYM(buttonArray, names, i);
				 if (buttonArray[i].getText().contains("-")) {
					 buttonArray[i].setBackground(Color.RED);
				 }
				 else {
					 buttonArray[i].setBackground(Color.green);
				 }
			}
			
			buttonArray[i].setForeground(Color.BLACK);
			if (i >= buttonArray.length && nysePressed && !marketOpen) {
				i = 0;
				break;
			}
			
			}
		
	}
	
	
}
