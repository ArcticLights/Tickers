// © Bailey Danseglio 2018 //

package frameComponents;

import java.io.IOException;

public class ClearFrame extends MainFrame {


	public static void clearSection() throws IOException {
		
		
		mainFrame.getContentPane().removeAll();
		MainFrame.createMainFrame();
		
	}
}