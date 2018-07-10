package algorithms;

import java.lang.reflect.Array;

import javax.swing.JButton;

public class ChangeSymbol {
	
	public static void changeSYM(JButton[] buttons, String names[], int c ) {
		
	
			int temp = buttons[c].getText().indexOf(":");
			buttons[c].setText(names[c] + buttons[c].getText().substring(temp + 1, buttons[c].getText().length()));
			
	}

}
