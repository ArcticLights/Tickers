// © Bailey Danseglio 2018 //

package frameComponents;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DisplayTime extends MainFrame {
	
	public String liveTime;

	
	public static void showTime() throws InterruptedException {
		
		while (runTime) {
			if (cryptoPressed || indexPressed)
			{
				time.setVisible(false);
			}
			
			else {
				time.setVisible(true);
			}
			
			String timeStamp = new SimpleDateFormat("HH:mm:ss:SSS").format(Calendar.getInstance().getTime());
			time.setText(timeStamp);
			
			int newStamp;
			newStamp = Integer.valueOf(timeStamp.replace(":", ""));
			
			if ((newStamp >= 93000000) && newStamp <=160000000) {
				marketOpen = true;
			}
			else {
				marketOpen = false;
			}
			if (marketOpen) {
				marketStatus.setText("Market Open");
				marketStatus.setForeground(Color.GREEN);
	                   	
				for (int i = 0; i < cats.length; i++) {
					cats[i].setBackground(Color.GREEN);
				}
			}
			
			else  {
				marketStatus.setText("Markets Closed");
				marketStatus.setForeground(Color.RED);
				for (int i = 0; i < cats.length; i++) {
					cats[i].setBackground(Color.RED);
				}
			}
		}
	}
}