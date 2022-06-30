package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Shop.ItemsForSale;
import game.Battle;
import game.Game;
import game.PikimonTeam;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import java.awt.Cursor;

public class ChooseDifficultyScreen extends JFrame {

	private JPanel contentPane;
	private String miguelDialogue;
	
	/**
	 * Create the frame to choose difficulty
	 * 
	 * @param game 
	 */
	public ChooseDifficultyScreen(Game game) {
		PikimonTeam pikimonTeam = new PikimonTeam();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
			
	/* Opaque text panel */
		
		JPanel textPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) textPanel.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		textPanel.setBounds(0, 154, 505, 127);
		textPanel.setBackground(new Color(255, 255, 255, 123));
		contentPane.add(textPanel);

		if (game.getMaxDays() == 5) {
			miguelDialogue = "Only 5 days...? Hmm...";
		}
		else if (game.getMaxDays() == 15) {
			miguelDialogue = "Thank you for helping me retrieve my bagels.";
		}
		else if (game.getMaxDays()>7) {
			miguelDialogue = "It's gonna be a wild one :)";
		}
		
		JLabel lblDialogue = new JLabel();
		lblDialogue.setText(String.format("<html>%s<br>What difficulty will you choose?</html>", miguelDialogue));
		textPanel.add(lblDialogue);
		lblDialogue.setForeground(SystemColor.desktop);
		lblDialogue.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		
		
		/* Buttons */
		JButton easyButton = new JButton("Easy");
		easyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		easyButton.setBackground(SystemColor.control);

		easyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.setDifficulty("easy");
				dispose();
				ChoosePikimonScreen choosePikimonScreen = new ChoosePikimonScreen(game, pikimonTeam);
				choosePikimonScreen.setVisible(true);
				
				
			}
		});
		
		easyButton.setBounds(162, 83, 120, 41);
		contentPane.add(easyButton);
		
		JButton hardButton = new JButton("Hard");
		hardButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hardButton.setBackground(SystemColor.control);
		hardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.setDifficulty("hard");
				dispose();
				ChoosePikimonScreen choosePikimonScreen = new ChoosePikimonScreen(game, pikimonTeam);
				choosePikimonScreen.setVisible(true);
			}
		});
		
		
		hardButton.setBounds(330, 83, 120, 41);
		contentPane.add(hardButton);
		
		JLabel miguel = new JLabel("");
		miguel.setIcon(new ImageIcon(ChooseDifficultyScreen.class.getResource("/images/sprites/miguel120.png")));
		miguel.setBounds(10, 21, 120, 134);
		contentPane.add(miguel);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(ChooseDifficultyScreen.class.getResource("/images/Backgrounds/battlebgIndoorA.png")));
		Background.setBounds(0, 0, 512, 288);
		contentPane.add(Background);
	}
}
