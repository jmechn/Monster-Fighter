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

public class NewDayScreen extends JFrame {
	
	private JPanel contentPane;
	private JLabel background;
	private JLabel lblDialogue;
	private JLabel lblDay;
	private JLabel bagelIcon;
	private JLabel lblBagel;
	private JLabel coinIcon;
	private JLabel lblCoin;
	private JLabel lblDifficulty;
	private JLabel lblDialogue_2;
	/**
	 * Create the frame.
	 */
	public NewDayScreen(Game game, MainInventory inventory, PikimonTeam pikimonTeam, Battle battle,
			ItemsForSale shop){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setResizable(false);
		
		contentPane.setLayout(null);
		
		lblDifficulty = new JLabel(game.getDifficulty().toUpperCase());
		lblDifficulty.setForeground(Color.BLACK);
		lblDifficulty.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDifficulty.setBounds(449, 11, 56, 14);
		contentPane.add(lblDifficulty);
		

		/* Opaque text panel */
		
		JPanel textPanel = new JPanel();
		textPanel.setBounds(12, 37, 489, 240);
		textPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(textPanel);
		textPanel.setLayout(null);
		lblDialogue = new JLabel(String.format("<html>%s<br></html>", game.eventStamina()));
		lblDialogue.setFont(new Font("Dialog", Font.BOLD, 10));
		lblDialogue.setHorizontalAlignment(SwingConstants.LEFT);
		lblDialogue.setVerticalAlignment(SwingConstants.TOP);
		lblDialogue.setBackground(new Color(255, 255, 255, 0));
		lblDialogue.setForeground(Color.BLACK);
		lblDialogue.setBounds(37, 40, 410, 32);
		textPanel.add(lblDialogue);
		
		
		JLabel lblDialogue_1 = new JLabel(String.format("<html>%s<br></html>",  game.eventLevel()));
		lblDialogue_1.setVerticalAlignment(SwingConstants.TOP);
		lblDialogue_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDialogue_1.setForeground(Color.BLACK);
		lblDialogue_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblDialogue_1.setBackground(new Color(255, 255, 255, 0));
		lblDialogue_1.setBounds(37, 79, 410, 32);
		textPanel.add(lblDialogue_1);

		lblDialogue_2 = new JLabel(String.format("<html>%s<br>",  game.eventEnemyLevel()));
		lblDialogue_2.setVerticalAlignment(SwingConstants.TOP);
		lblDialogue_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblDialogue_2.setForeground(Color.BLACK);
		lblDialogue_2.setFont(new Font("Dialog", Font.BOLD, 10));
		lblDialogue_2.setBackground(new Color(255, 255, 255, 0));
		lblDialogue_2.setBounds(37, 122, 410, 32);
		textPanel.add(lblDialogue_2);
		
		lblCoin = new JLabel(String.format("Coins: %d", game.getCoins()));
		lblCoin.setBounds(246, 11, 102, 14);
		textPanel.add(lblCoin);
		lblCoin.setForeground(Color.BLACK);
		lblCoin.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		coinIcon = new JLabel("");
		coinIcon.setBounds(218, 0, 32, 32);
		textPanel.add(coinIcon);
		coinIcon.setIcon(new ImageIcon(NewDayScreen.class.getResource("/images/icons/coin.png")));
		
		lblBagel = new JLabel(String.format("Bagels: %d", game.getBagels()));
		lblBagel.setBounds(148, 11, 74, 14);
		textPanel.add(lblBagel);
		lblBagel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBagel.setForeground(Color.BLACK);
		
		lblDay = new JLabel(String.format("Day: %d", game.getDay()));
		lblDay.setBounds(68, 11, 68, 14);
		textPanel.add(lblDay);
		lblDay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDay.setForeground(Color.BLACK);
		
		bagelIcon = new JLabel("");
		bagelIcon.setBounds(126, 0, 32, 32);
		textPanel.add(bagelIcon);
		bagelIcon.setIcon(new ImageIcon(NewDayScreen.class.getResource("/images/icons/bagelv2.png")));
		
		
		JLabel stamina = new JLabel(String.format("Stamina: %d/%d",
				(game.getMaxStamina()-battle.getBattleCount()), game.getMaxStamina()));
		stamina.setForeground(Color.BLACK);
		stamina.setFont(new Font("Dialog", Font.BOLD, 11));
		stamina.setBounds(325, 11, 102, 14);
		textPanel.add(stamina);
		
		JButton backBtn = new JButton("Back to Menu");
		backBtn.setFont(new Font("Dialog", Font.BOLD, 10));
		backBtn.setBounds(181, 203, 115, 25);
		textPanel.add(backBtn);
		backBtn.setBackground(SystemColor.control);
		backBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		

		
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MenuScreen menuScreen = new MenuScreen(game, inventory, pikimonTeam, battle, shop);
				menuScreen.setVisible(true);
			}
		});
		
		background = new JLabel("");
		background.setBounds(0, 0, 512, 288);
		background.setFont(new Font("Tahoma", Font.BOLD, 11));
		background.setIcon(new ImageIcon(NewDayScreen.class.getResource(String.format("%s", game.setBackground()))));
		background.setBackground(Color.BLACK);
		contentPane.add(background);
	
	}
}
