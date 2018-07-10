// © Bailey Danseglio 2018 //

package frameComponents;

import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.Array;

import javax.swing.JButton;

import algorithms.JButtonArray;
import webSocket.GetPercentStock;
import webSocket.GetPriceStock;

public class CryptoFrame extends MainFrame {

	private static String symbols[] = {"BTC-USD", "ETH-USD", "DASH-USD", "LTC-USD", "XRP-USD", ""};
	private static String names[] = {"BTC","ETH", "DASH", "LTC", "XRP", ""};
	public static JButton cryptos[] = new JButton[symbols.length];
	
	public static void genCrypto() throws IOException {
			JButtonArray.genPrices(cryptos, symbols);	
	    }
		
	
	
	public static void runCrypto() throws IOException, InterruptedException {


		JButtonArray.runPrices(cryptos, symbols, true, names);	
		
		
	}
	

}