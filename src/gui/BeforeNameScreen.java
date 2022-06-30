package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.Game;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;

/**
 * 
 * Storyline 
 * 
 * @author Jaymee Chen
 *
 */

public class BeforeNameScreen extends JFrame {
	
	private JPanel contentPane;
	/**
	 * Create the frame.
	 * @param game 
	 */
	public BeforeNameScreen(Game game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setResizable(false);
		
		JButton nameConfirm = new JButton("Next");
		nameConfirm.setBounds(407, 245, 72, 25);
		nameConfirm.setBackground(SystemColor.control);
		nameConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nameConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ChooseNameScreen chooseNameScreen = new ChooseNameScreen(game);
				chooseNameScreen.setVisible(true);
			}
		});
		
		
		contentPane.add(nameConfirm);
		
		
		/* Opaque text panel */
		
		JPanel textPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) textPanel.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		textPanel.setBounds(0, 154, 505, 127);
		textPanel.setBackground(new Color(255, 255, 255, 123));
		contentPane.add(textPanel);
		
		JLabel lblDialogue = new JLabel("<html>Welcome to the world of Pikimon! My name is Miguel! People call <br>me the SENG201 Prof! This world is inhabited by creatures called <br>Pikimon.</html>");
		textPanel.add(lblDialogue);
		lblDialogue.setForeground(SystemColor.desktop);
		lblDialogue.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BeforeNameScreen.class.getResource("/images/sprites/miguel120.png")));
		lblNewLabel.setBounds(172, 21, 120, 134);
		contentPane.add(lblNewLabel);
		
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 512, 288);
		background.setBackground(Color.BLACK);
		background.setIcon(new ImageIcon(BeforeNameScreen.class.getResource("/images/Backgrounds/battlebgIndoorA.png")));
		contentPane.add(background);
	}
}
