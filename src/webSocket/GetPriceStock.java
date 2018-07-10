// © Bailey Danseglio 2018 //

package webSocket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetPriceStock {

	public static String getPrice(String SYM) throws IOException {
		
		
		URL URL = new URL("https://finance.yahoo.com/quote/" + SYM + "?p=" + SYM);			
		URLConnection URLconn = URL.openConnection();
		
		InputStreamReader InStream = new InputStreamReader(URLconn.getInputStream());
		
		BufferedReader Buff = new BufferedReader(InStream);
		
		String price = "error";
		
		String line = Buff.readLine();
		
		
		while (line != null) {
			
			if  (line.contains("\"regularMarketPrice\":{\"raw\":")) {
				int target = line.indexOf("\"regularMarketPrice\":{\"raw\":");
				int deci = line.indexOf("." , target);
				int start = deci;
				char tester = ':';
				
				while (line.charAt(start) != tester) {
					start--;
					
				}
				

				 price = line.substring(start + 1, deci + 3);
				 
				 
				if (price.charAt(price.length() - 1) == ',') {
		
					price = line.substring(start + 1, deci + 2) + "0";
						
				}
				
				else {
					price = line.substring(start + 1, deci + 3);
				}
				
				
			}
			line = Buff.readLine();
				
			
		}
		
		return price;
		
		
		
		}
	
}