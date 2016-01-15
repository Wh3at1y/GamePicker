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
			JOptionPane.showMessageDialog(null, input, input, 0, chatIcon);

		}
	}
