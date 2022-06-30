package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Shop.ItemsForSale;
import game.Battle;
import game.Game;
import game.PikimonTeam;
import inventory.MainInventory;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class LoseScreen extends JFrame {
	
	private JPanel contentPane;
	private JLabel background;
	private JLabel lblDay;
	private JLabel bagelIcon;
	private JLabel lblBagel;
	private JLabel coinIcon;
	private JLabel lblCoin;
	private JLabel lblDifficulty;
	private JLabel lblNewLabel_1;
	/**
	 * Create the frame.
	 */
	public LoseScreen(Game game, MainInventory inventory, PikimonTeam pikimonTeam, Battle battle,
			ItemsForSale shop){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setResizable(false);
		
		contentPane.setLayout(null);
		

		/* Opaque text panel */
		
		JPanel textPanel = new JPanel();
		textPanel.setBounds(12, 37, 489, 240);
		textPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(textPanel);
		textPanel.setLayout(null);
		
		lblCoin = new JLabel(String.format("Coins: %d | Coins gained: %d", game.getCoins(), game.getGainedCoins()));
		lblCoin.setBounds(249, 78, 175, 14);
		textPanel.add(lblCoin);
		lblCoin.setForeground(Color.BLACK);
		lblCoin.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		coinIcon = new JLabel("");
		coinIcon.setBounds(221, 67, 32, 32);
		textPanel.add(coinIcon);
		coinIcon.setIcon(new ImageIcon(LoseScreen.class.getResource("/images/icons/coin.png")));
		
		lblBagel = new JLabel(String.format("Bagels: %d", game.getBagels()));
		lblBagel.setBounds(151, 78, 74, 14);
		textPanel.add(lblBagel);
		lblBagel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBagel.setForeground(Color.BLACK);
		
		lblDay = new JLabel(String.format("Day: %d", game.getDay()));
		lblDay.setBounds(71, 78, 68, 14);
		textPanel.add(lblDay);
		lblDay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDay.setForeground(Color.BLACK);
		
		bagelIcon = new JLabel("");
		bagelIcon.setBounds(129, 67, 32, 32);
		textPanel.add(bagelIcon);
		bagelIcon.setIcon(new ImageIcon(LoseScreen.class.getResource("/images/icons/bagelv2.png")));
		
		JButton backBtn = new JButton("Quit");
		backBtn.setFont(new Font("Dialog", Font.BOLD, 10));
		backBtn.setBounds(167, 204, 115, 25);
		textPanel.add(backBtn);
		backBtn.setBackground(SystemColor.control);
		backBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		lblDifficulty = new JLabel(String.format("Difficulty: %s", game.getDifficulty().toUpperCase()));
		lblDifficulty.setBounds(161, 103, 165, 14);
		textPanel.add(lblDifficulty);
		lblDifficulty.setForeground(Color.BLACK);
		lblDifficulty.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel = new JLabel(String.format("%s YOU LOST =(", game.getName()));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(71, 11, 312, 54);
		textPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("You are too weak... Go learn JABA.");
		lblNewLabel_1.setBounds(151, 56, 200, 14);
		textPanel.add(lblNewLabel_1);
	
		

		
		background = new JLabel("");
		background.setBounds(0, 0, 512, 288);
		background.setFont(new Font("Tahoma", Font.BOLD, 11));
		background.setIcon(new ImageIcon(LoseScreen.class.getResource(String.format("%s", game.setBackground()))));
		background.setBackground(Color.BLACK);
		contentPane.add(background);
	
	}
}
