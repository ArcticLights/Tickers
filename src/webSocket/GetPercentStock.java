package webSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetPercentStock {
	
	
    
	public static String getPercent(String SYM) throws IOException {
	
		URL URL = new URL("https://finance.yahoo.com/quote/" + SYM + "?p=" + SYM);
		URLConnection URLconn = URL.openConnection();
		InputStreamReader InStream = new InputStreamReader(URLconn.getInputStream());
		BufferedReader Buff = new BufferedReader(InStream);
		String percent = "error";
		
		String line = Buff.readLine();
		
		
		while (line != null) {
			
			if  (line.contains("\"regularMarketChangePercent\":{\"raw\":")) {
				
				int target = line.indexOf("\"regularMarketChangePercent\":{\"raw\":");
				int start = line.indexOf("\"fmt\":\"", target);
				int end = line.indexOf("%" , target);
				
				
				char tester = ':';
				
				
				
				while (line.charAt(start) != tester) {
					
					start--;
				}
				percent = line.substring(start , end + 1);
				
			}
			line = Buff.readLine();
			
		}
		
		percent = percent.substring(percent.indexOf("\"fmt\":\"") + 7);	
		
		return percent;
		
	}
}


