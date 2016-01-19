package picker.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import picker.controller.PickerController;

public class GUIPanel extends JPanel
	{
		private PopUps popUp;
		
		private SpringLayout baseLayout;
		
		private ArrayList<String> gameList;
		
		private JButton chooseButton;
		private JButton addButton;
		private JButton clearButton;
		
		private JTextField gameText;
		private JTextArea showGames;
		
		private Font gameFont;
		
		public GUIPanel(PickerController baseController)
		{			
			popUp = new PopUps();
			
			baseLayout = new SpringLayout();
			
			gameList = new ArrayList<String>();
			
			chooseButton = new JButton("Randomly Select");
			addButton = new JButton("Add a Game");
			clearButton = new JButton("Clear Games");
			
			gameText = new JTextField(); 
			gameText.setToolTipText("Enter A Game Name");
			
			showGames = new JTextArea();
			showGames.setFont(gameFont);
			showGames.setText("Games Added : \n");
			showGames.setEditable(false);
			
			gameFont = new Font("Geneva", Font.PLAIN, 14);
			
			setupPanel();
			setupLayout();
			setupListeners();
		}
		
		private void setupPanel()
		{
			setLayout(baseLayout);
			add(chooseButton);
			add(addButton);
			add(clearButton);
			add(gameText);
			add(showGames);
			
			setBackground(Color.white);
		}
		
		private void setupLayout()
		{
			baseLayout.putConstraint(SpringLayout.WEST, chooseButton, 0, SpringLayout.WEST, this);
			baseLayout.putConstraint(SpringLayout.SOUTH, chooseButton, -10, SpringLayout.SOUTH, this);
			baseLayout.putConstraint(SpringLayout.NORTH, showGames, 20, SpringLayout.SOUTH, gameText);
			baseLayout.putConstraint(SpringLayout.WEST, showGames, 0, SpringLayout.WEST, gameText);
			baseLayout.putConstraint(SpringLayout.WEST, gameText, 10, SpringLayout.WEST, this);
			baseLayout.putConstraint(SpringLayout.EAST, gameText, -145, SpringLayout.EAST, this);
			baseLayout.putConstraint(SpringLayout.NORTH, addButton, 1, SpringLayout.NORTH, gameText);
			baseLayout.putConstraint(SpringLayout.WEST, addButton, 6, SpringLayout.EAST, gameText);
			baseLayout.putConstraint(SpringLayout.NORTH, gameText, 10, SpringLayout.NORTH, this);
			baseLayout.putConstraint(SpringLayout.NORTH, clearButton, 0, SpringLayout.NORTH, chooseButton);
			baseLayout.putConstraint(SpringLayout.EAST, clearButton, -10, SpringLayout.EAST, this);
		}
		
		private void setupListeners()
		{
			clearButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						gameList.clear();
						showGames.setText("Games Added : \n");
					}
				});
			
			chooseButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						emptyListChecker();
					}
				});
			
			addButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						if(gameList.size() == 6)
							{
								popUp.showText("You have reached the game limit.");
							}
						
						else if(gameText.getText().length() == 0 || gameText.getText().equalsIgnoreCase(" "))
							{
								popUp.showText("Nothing was entered.");
							}
						
						else if(gameText.getText().length() >= 18)
							{
								popUp.showText("Too many characters!");
							}
						else
							{
								gameList.add(gameText.getText());
								showGames.setText("Games Added : \n");
								
								for(String printWords : gameList)
									{
										showGames.append(printWords + "\n");
									}
								
							}
						gameText.setText("");
					}
				});
		}
		
		private void randomGame()
		{
			Random randomGame = new Random();
			String selectedGame = gameList.get(randomGame.nextInt(gameList.size()));
			
			System.out.println(selectedGame);
			popUp.showText("The game that was chosen is : " + selectedGame);
		}
		
		private void emptyListChecker()
		{
			if(gameList.isEmpty())
				{
					popUp.showText("Nothing is in the list.");
				}
			else
				{
					randomGame();
				}
		}
	}
