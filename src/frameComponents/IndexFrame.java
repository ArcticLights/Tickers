package frameComponents;

import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.Array;

import javax.swing.JButton;

import webSocket.GetPercentStock;
import webSocket.GetPriceStock;
import algorithms.JButtonArray;


public class IndexFrame extends MainFrame {
	
	private static JButton indexes [] = new JButton[7];
	private static String symbols[] = {"^DJI","^GSPC","^IXIC","^RUT","^FTSE","^HSI", ""};
	
	public static void genIndex() throws IOException {
		
		JButtonArray.genPrices(indexes, symbols);
	}

	public static void runIndex() throws IOException, InterruptedException {
		
		JButtonArray.runPrices(indexes, symbols, false, null);	
	
	}
	
}