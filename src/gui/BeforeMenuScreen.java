package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Shop.ItemsForSale;
import game.Battle;
import game.ChooseName;
import game.Game;
import game.PikimonTeam;
import inventory.MainInventory;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
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
public class BeforeMenuScreen extends JFrame {
	
	private JPanel contentPane;

	public BeforeMenuScreen(Game game, PikimonTeam pikimonTeam) {
		MainInventory inventory = new MainInventory(game.getDifficulty());
		Battle battle = new Battle();
		ItemsForSale shop= new ItemsForSale();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setResizable(false);
		
		JButton nextButton = new JButton("Next");
		nextButton.setBounds(407, 245, 72, 25);
		nextButton.setBackground(SystemColor.control);
		nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				game.newDay(battle, pikimonTeam);
				MenuScreen menuScreen = new MenuScreen(game, inventory, pikimonTeam, battle, shop);
				menuScreen.setVisible(true);
			}
		});
		contentPane.add(nextButton);
		
		JLabel miguel = new JLabel("");
		miguel.setIcon(new ImageIcon(BeforeMenuScreen.class.getResource("/images/sprites/miguel120.png")));
		miguel.setBounds(186, 21, 120, 134);
		contentPane.add(miguel);
		
		
		/* Opaque text panel */
		
		JPanel textPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) textPanel.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		textPanel.setBounds(0, 154, 505, 127);
		textPanel.setBackground(new Color(255, 255, 255, 123));
		contentPane.add(textPanel);
		
		JLabel lblDialogue = new JLabel(String.format("<html>%s... What a great choice... <br>A world of dreams and adventures with Pikimon awaits!<br>"
				+ "Fight away the evil and earn bagels! Gotta code em' All!</html>"
				, game.getPlayerTeam().get(0).getName()));
		textPanel.add(lblDialogue);
		lblDialogue.setForeground(SystemColor.desktop);
		lblDialogue.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 512, 288);
		background.setBackground(Color.BLACK);
		background.setIcon(new ImageIcon(BeforeMenuScreen.class.getResource("/images/Backgrounds/battlebgIndoorA.png")));
		contentPane.add(background);
	}
}
