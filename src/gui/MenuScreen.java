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
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class MenuScreen extends JFrame {
	
	private JPanel contentPane;
	private JLabel background;
	private JLabel lblDialogue;
	private JLabel lblDay;
	private JLabel bagelIcon;
	private JLabel lblBagel;
	private JLabel coinIcon;
	private JLabel lblCoin;
	private JButton btnBattle;
	private JButton btnTeam;
	private JButton btnInventory;
	private JButton btnShop;
	private JLabel lblDifficulty;
	private JButton btnSleep;
	/**
	 * Create the frame.
	 * @param game 
	 */
	public MenuScreen(Game game, MainInventory inventory, PikimonTeam pikimonTeam, Battle battle,
			ItemsForSale shop){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setResizable(false);
		
		contentPane.setLayout(null);

		/* Days */
		
		lblDay = new JLabel(String.format("Day: %d/%d", game.getDay(), game.getMaxDays()));
		lblDay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDay.setForeground(SystemColor.window);
		lblDay.setBounds(27, 11, 68, 14);
		contentPane.add(lblDay);
		
		/* Bagels */
		
		lblBagel = new JLabel(String.format("Bagels: %d", game.getBagels()));
		lblBagel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBagel.setForeground(Color.WHITE);
		lblBagel.setBounds(107, 11, 74, 14);
		contentPane.add(lblBagel);
		
		bagelIcon = new JLabel("");
		bagelIcon.setIcon(new ImageIcon(MenuScreen.class.getResource("/images/icons/bagelv2.png")));
		bagelIcon.setBounds(85, 0, 32, 32);
		contentPane.add(bagelIcon);
		
		/* Coins */
		
		lblCoin = new JLabel(String.format("Coins: %d", game.getCoins()));
		lblCoin.setForeground(Color.WHITE);
		lblCoin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCoin.setBounds(205, 11, 102, 14);
		contentPane.add(lblCoin);
		
		coinIcon = new JLabel("");
		coinIcon.setIcon(new ImageIcon(MenuScreen.class.getResource("/images/icons/coin.png")));
		coinIcon.setBounds(177, 0, 32, 32);
		contentPane.add(coinIcon);
		
		/* Difficulty */
		
		lblDifficulty = new JLabel(game.getDifficulty().toUpperCase());
		lblDifficulty.setForeground(Color.WHITE);
		lblDifficulty.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDifficulty.setBounds(449, 11, 56, 14);
		contentPane.add(lblDifficulty);
		
		
		
		JLabel stamina = new JLabel(String.format("Stamina: %d/%d",
				(game.getMaxStamina()-battle.getBattleCount()), game.getMaxStamina()));
		stamina.setForeground(Color.WHITE);
		stamina.setFont(new Font("Dialog", Font.BOLD, 11));
		stamina.setBounds(302, 11, 102, 14);
		contentPane.add(stamina);
		
		/* Opaque text panel */
		
		JPanel textPanel = new JPanel();
		textPanel.setBounds(0, 208, 505, 73);
		FlowLayout flowLayout = (FlowLayout) textPanel.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		textPanel.setBackground(new Color(255, 255, 255, 123));
		contentPane.add(textPanel);
		
		lblDialogue = new JLabel(String.format("%s %s. What would you like to do?", game.randomGreeter(), game.getName()));
		textPanel.add(lblDialogue);
		
		btnBattle = new JButton("Battle");
		btnBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				EnemyScreen enemyScreen = new EnemyScreen(game, inventory, pikimonTeam, battle, shop);
				enemyScreen.setVisible(true);
			}
		});
		btnBattle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBattle.setBackground(SystemColor.control);
		btnBattle.setBounds(107, 72, 89, 23);
		contentPane.add(btnBattle);
		if (battle.getBattleCount() == game.getMaxStamina()) {
			btnBattle.setVisible(false);
		}
		
		btnInventory = new JButton("Inventory");
		btnInventory.setFont(new Font("Dialog", Font.BOLD, 10));
		btnInventory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInventory.setBackground(SystemColor.control);
		btnInventory.setBounds(107, 128, 89, 23);
		btnInventory.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				dispose();
				ItemScreen screen= new ItemScreen(game, inventory, pikimonTeam, battle, shop);
				screen.setVisible(rootPaneCheckingEnabled);;
			}
		});

		contentPane.add(btnInventory);
		
		
		btnTeam = new JButton("Team");
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TeamScreen teamScreen = new TeamScreen(game, inventory, pikimonTeam, battle, shop);
				teamScreen.setVisible(true);
			}
		});
		
		btnTeam.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTeam.setBackground(SystemColor.control);
		btnTeam.setBounds(289, 72, 89, 23);
		contentPane.add(btnTeam);
		
		btnShop = new JButton("Shop");
		btnShop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShop.setBackground(SystemColor.control);
		btnShop.setBounds(289, 128, 89, 23);
		btnShop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				dispose();
				ShopScreen screen=new ShopScreen(game, inventory, pikimonTeam, battle, shop);
				screen.setVisible(true);
			}
		});

		contentPane.add(btnShop);
		
		btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				game.newDay(battle, pikimonTeam);
				dispose();
				NewDayScreen newDayScreen = new NewDayScreen(game, inventory, pikimonTeam, battle, shop);
				newDayScreen.setVisible(true);
			
			}
		});
		
		btnSleep.setBackground(SystemColor.window);
		btnSleep.setBounds(202, 163, 89, 23);
		contentPane.add(btnSleep);
		
		if (battle.getBattleCount() == 0) {
			btnSleep.setVisible(false);
		}
		
		
		background = new JLabel("");
		background.setBounds(0, 0, 512, 288);
		background.setFont(new Font("Tahoma", Font.BOLD, 11));
		background.setIcon(new ImageIcon(MenuScreen.class.getResource(String.format("%s", game.setBackground()))));
		background.setBackground(Color.BLACK);
		contentPane.add(background);

	
	}
}
