
package frameComponents;

import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.Array;
import algorithms.ChangeSymbol;
import javax.swing.JButton;

import webSocket.GetPercentStock;
import webSocket.GetPriceStock;
import algorithms.JButtonArray;

public class Comm extends MainFrame {
	

	private static String symbols[] = {"SI=F", "GC=F", "PL=F", "HG=F", "CL=F", "CC=F", "SB=F", ""};
	private static String names[] = {"Silver", "Gold" , "Platinum","Copper", "Crude", "Cocoa", "Sugar", ""};
	public static JButton comms [] = new JButton[Array.getLength(symbols)];
	
	public static void genComm() throws IOException {
		 
		
		JButtonArray.genPrices(comms, symbols);
		   
		
		
	}
	
	public static void runComm() throws IOException, InterruptedException {

		JButtonArray.runPrices(comms, symbols, true, names);
		
	}

}