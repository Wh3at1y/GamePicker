package picker.view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PopUps
	{
		private ImageIcon chatIcon;
		
		public PopUps()
		{
			chatIcon = new ImageIcon("images/Error.png");
		}
		
		public void showText(String input)
		{
			String popUpTitle = "Game Picker Notify";
			JOptionPane.showMessageDialog(null, input, popUpTitle, 0, chatIcon);
		}
	}
