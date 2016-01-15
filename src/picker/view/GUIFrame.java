package picker.view;

import javax.swing.JFrame;

import picker.controller.PickerController;

public class GUIFrame extends JFrame
	{
		
		private GUIPanel basePanel;
		
		public GUIFrame(PickerController baseController)
		{
			basePanel = new GUIPanel(baseController);
			
			setupFrame();
		}
		
		private void setupFrame()
		{
			setTitle("Game Picker");
			setLocationRelativeTo(null);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setContentPane(basePanel);
			setSize(300,300);
			setVisible(true);
		}
	}
