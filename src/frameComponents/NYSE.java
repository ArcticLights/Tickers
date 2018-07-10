package frameComponents;

import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.Array;

import javax.swing.JButton;

import algorithms.JButtonArray;
import webSocket.GetPercentStock;
import webSocket.GetPriceStock;

public class NYSE extends MainFrame {
	
	
	private static String symbols[] = {"AAPL", "SBUX" , "INTC", "AMD", "TSLA", "BAC", "RUN", "FB", "WEN", "IRBT", "TMUS", "JPM", "C", "WFC", "F", "TEVA", 
			"AMGN", "USB", "MU", "BOX", "AMBA", "BPMX", "SNAP", "SPOT", "HSY", "V", "BKS", "DKS", "GM", "GOOG", "GE", "JNJ", "GPRO", "IBM", "MCD", "MA", "WFC", "NFLX", "NDAQ", "PYPL", "FSLR"
			, "HLT", "NYT", "MS", "PFE", "FNB", "ORCL", "TROW", ""};
	
	
	
	public static JButton stocks [] = new JButton[symbols.length];
	public static void genNYSE() throws IOException {
	
		JButtonArray.genPrices(stocks, symbols);
		
	}

	public static void runNYSE() throws IOException, InterruptedException {
		
		JButtonArray.runPrices(stocks, symbols, false, null);	
		
	}
	
}