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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class EnemyScreen extends JFrame {
	
	private JPanel contentPane;
	private JLabel background;
	private JLabel lblDialogue;
	private JLabel lblDay;
	private JLabel bagelIcon;
	private JLabel lblBagel;
	private JLabel coinIcon;
	private JLabel lblCoin;
	private JLabel enemyPikimonImage1;
	private JLabel enemyPikimonImage2;
	private JLabel enemyPikimonImage3;
	private JButton btnEnemy1;
	private JButton btnEnemy2;
	private JButton btnEnemy3;
	private JTextPane enemyInfo1;
	private JTextPane enemyInfo2;
	private JTextPane enemyInfo3;
	private JLabel lblDifficulty;
	private JButton btnBack;
	/**
	 * Create the frame.
	 * @param game 
	 */
	public EnemyScreen(Game game, MainInventory inventory, PikimonTeam pikimonTeam, Battle battle, ItemsForSale shop){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
		
		/* Days */
		
		lblDifficulty = new JLabel(game.getDifficulty());
		lblDifficulty.setForeground(Color.WHITE);
		lblDifficulty.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDifficulty.setBounds(439, 11, 56, 14);
		contentPane.add(lblDifficulty);
		
		lblDay = new JLabel(String.format("Day: %d", game.getDay()));
		lblDay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDay.setForeground(SystemColor.window);
		lblDay.setBounds(27, 11, 36, 14);
		contentPane.add(lblDay);
		
		/* Bagels */
		
		lblBagel = new JLabel(String.format("Bagels: %d", game.getBagels()));
		lblBagel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBagel.setForeground(Color.WHITE);
		lblBagel.setBounds(107, 11, 74, 14);
		contentPane.add(lblBagel);
		
		bagelIcon = new JLabel("");
		bagelIcon.setIcon(new ImageIcon(EnemyScreen.class.getResource("/images/icons/bagelv2.png")));
		bagelIcon.setBounds(85, 0, 32, 32);
		contentPane.add(bagelIcon);
		
		/* Coins */
		
		lblCoin = new JLabel(String.format("Coins: %d", game.getCoins()));
		lblCoin.setForeground(Color.WHITE);
		lblCoin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCoin.setBounds(205, 11, 102, 14);
		contentPane.add(lblCoin);
		
		coinIcon = new JLabel("");
		coinIcon.setIcon(new ImageIcon(EnemyScreen.class.getResource("/images/icons/coin.png")));
		coinIcon.setBounds(177, 0, 32, 32);
		contentPane.add(coinIcon);
		
		JLabel stamina = new JLabel(String.format("Stamina: %d/%d",
				(game.getMaxStamina()-battle.getBattleCount()), game.getMaxStamina()));
		stamina.setForeground(Color.WHITE);
		stamina.setFont(new Font("Dialog", Font.BOLD, 11));
		stamina.setBounds(302, 11, 102, 14);
		contentPane.add(stamina);
		
		/* Opaque text panel */
		
		JPanel textPanel = new JPanel();
		textPanel.setBounds(0, 208, 505, 73);
		textPanel.setBackground(new Color(255, 255, 255, 123));
		contentPane.add(textPanel);
		
		/* Dialogue label, set when days is compared */
		textPanel.setLayout(null);
		lblDialogue = new JLabel();
		lblDialogue.setBounds(10, 11, 473, 38);
		textPanel.add(lblDialogue);
		
		
		if (game.getDay() == game.getMaxDays() || game.getDay() % 5 == 0){
			if (game.getDay() % 5 == 0) {
				lblDialogue.setText("<html>Last day! Miguel took a day off <br>and left his bag of bagels open.</html>");
			}
			else {
				lblDialogue.setText("The smell of your bagels has attracted a BOSS Pikimon");
			}
			battle.generateBossPikimon(game, game.getBossTeam());
			JButton btnBoss = new JButton("Fight");
			btnBoss.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					battle.setEnemyIndex(battle.getEnemyIndex());
					BattleScreen battleScreen = new BattleScreen(game, inventory, pikimonTeam, battle, shop);
					battleScreen.setVisible(true);
					}
				}
			);
			
			btnBoss.setBounds(331, 24, 110, 42);
			textPanel.add(btnBoss);
			btnBoss.setBackground(SystemColor.menu);

		
			JLabel bossPikimonImage = new JLabel("");
			bossPikimonImage.setBounds(131, 64, 120, 112);
			bossPikimonImage.setIcon(new ImageIcon(EnemyScreen.class.getResource(battle.getRandomEnemyList().get(0).getImagePath())));
			contentPane.add(bossPikimonImage);
			
			JLabel bossName = new JLabel(battle.getRandomEnemyList().get(0).getName());
			bossName.setFont(new Font("Tahoma", Font.BOLD, 11));
			bossName.setBounds(247, 112, 113, 14);
			contentPane.add(bossName);
			
			JTextPane bossInfo = new JTextPane();
			bossInfo.setText(String.format("\n\n\nLevel: %d\n"
					+ "HP: %d/%d\n"
					+ "Attack: %d"
					, battle.getRandomEnemyList().get(0).getLevel()
					, battle.getRandomEnemyList().get(0).getHp(), battle.getRandomEnemyList().get(0).getMaxHp()
					, battle.getRandomEnemyList().get(0).getAttack()));
			bossInfo.setFont(new Font("Tahoma", Font.PLAIN, 9));
			bossInfo.setEditable(false);
			bossInfo.setBackground(new Color(255, 255, 255, 123));
			bossInfo.setBounds(243, 99, 89, 77);
			contentPane.add(bossInfo);
	
		}
		else {
			battle.generateEnemyPikimon(game, game.getEnemyTeam());
			
			/* First enemy Pikimon */
			

			enemyPikimonImage1 = new JLabel("");
			enemyPikimonImage1.setIcon(new ImageIcon(EnemyScreen.class.getResource(battle.getRandomEnemyList().get(0).getImagePath())));
			enemyPikimonImage1.setBounds(37, -18, 120, 112);
			contentPane.add(enemyPikimonImage1);

			JLabel enemyName1 = new JLabel(battle.getRandomEnemyList().get(0).getName());
			enemyName1.setFont(new Font("Tahoma", Font.BOLD, 11));
			enemyName1.setBounds(51, 93, 102, 14);
			contentPane.add(enemyName1);
			
			enemyInfo1 = new JTextPane();
			enemyInfo1.setFont(new Font("Tahoma", Font.PLAIN, 9));
			enemyInfo1.setEditable(false);
			enemyInfo1.setText(String.format("\n\n\nLevel: %d\n"
					+ "HP: %d/%d\n"
					+ "Attack: %d"
					, battle.getRandomEnemyList().get(0).getLevel()
					, battle.getRandomEnemyList().get(0).getHp(), battle.getRandomEnemyList().get(0).getMaxHp()
					, battle.getRandomEnemyList().get(0).getAttack()));
			enemyInfo1.setBounds(47, 93, 89, 77);
			enemyInfo1.setBackground(new Color(255, 255, 255, 123));
			contentPane.add(enemyInfo1);
			
			btnEnemy1 = new JButton("Fight");
			btnEnemy1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEnemy1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					battle.setEnemyIndex(0);
					BattleScreen battleScreen = new BattleScreen(game, inventory, pikimonTeam, battle, shop);
					battleScreen.setVisible(true);
				}
			});
			btnEnemy1.setBackground(SystemColor.control);
			btnEnemy1.setBounds(47, 174, 89, 23);
			contentPane.add(btnEnemy1);
			
			
			/* Second enemy Pikimon */
			
			enemyPikimonImage2 = new JLabel("");
			enemyPikimonImage2.setIcon(new ImageIcon(EnemyScreen.class.getResource(battle.getRandomEnemyList().get(1).getImagePath())));
			enemyPikimonImage2.setBounds(184, -18, 120, 112);
			contentPane.add(enemyPikimonImage2);
			
			JLabel enemyName2 = new JLabel(battle.getRandomEnemyList().get(1).getName());
			enemyName2.setFont(new Font("Tahoma", Font.BOLD, 11));
			enemyName2.setBounds(204, 93, 113, 14);
			contentPane.add(enemyName2);
			
			enemyInfo2 = new JTextPane();
			enemyInfo2.setFont(new Font("Tahoma", Font.PLAIN, 9));
			enemyInfo2.setEditable(false);
			enemyInfo2.setText(String.format("\n\n\nLevel: %d\n"
					+ "HP: %d/%d\n"
					+ "Attack: %d"
					, battle.getRandomEnemyList().get(1).getLevel()
					, battle.getRandomEnemyList().get(1).getHp(), battle.getRandomEnemyList().get(1).getMaxHp()
					, battle.getRandomEnemyList().get(1).getAttack()));

			enemyInfo2.setBackground(new Color(255, 255, 255, 123));
			enemyInfo2.setBounds(200, 93, 89, 77);
			contentPane.add(enemyInfo2);
			
			btnEnemy2 = new JButton("Fight");
			btnEnemy2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEnemy2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					battle.setEnemyIndex(1);
					BattleScreen battleScreen = new BattleScreen(game, inventory, pikimonTeam, battle, shop);
					battleScreen.setVisible(true);
				}
			});
			btnEnemy2.setBackground(SystemColor.control);
			btnEnemy2.setBounds(200, 174, 89, 23);
			contentPane.add(btnEnemy2);
			
			
			/* Third enemy Pikimon */
			
			enemyPikimonImage3 = new JLabel("");
			enemyPikimonImage3.setIcon(new ImageIcon(EnemyScreen.class.getResource(battle.getRandomEnemyList().get(2).getImagePath())));
			enemyPikimonImage3.setBounds(341, -18, 120, 112);
			contentPane.add(enemyPikimonImage3);
			
			
			JLabel enemyName3 = new JLabel(battle.getRandomEnemyList().get(2).getName());
			enemyName3.setFont(new Font("Tahoma", Font.BOLD, 11));
			enemyName3.setBounds(359, 93, 110, 14);
			contentPane.add(enemyName3);
			
			enemyInfo3 = new JTextPane();
			enemyInfo3.setFont(new Font("Tahoma", Font.PLAIN, 9));
			enemyInfo3.setEditable(false);
			enemyInfo3.setText(String.format("\n\n\nLevel: %d\n"
					+ "HP: %d/%d\n"
					+ "Attack: %d"
					, battle.getRandomEnemyList().get(2).getLevel()
					, battle.getRandomEnemyList().get(2).getHp(), battle.getRandomEnemyList().get(2).getMaxHp()
					, battle.getRandomEnemyList().get(2).getAttack()));
			enemyInfo3.setBackground(new Color(255, 255, 255, 123));
			enemyInfo3.setBounds(354, 93, 89, 77);
			contentPane.add(enemyInfo3);
			
			btnEnemy3 = new JButton("Fight");
			btnEnemy3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEnemy3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					battle.setEnemyIndex(2);
					BattleScreen battleScreen = new BattleScreen(game, inventory, pikimonTeam, battle, shop);
					battleScreen.setVisible(true);
				}
			});
			btnEnemy3.setBackground(SystemColor.control);
			btnEnemy3.setBounds(354, 174, 89, 23);
			contentPane.add(btnEnemy3);
			lblDialogue.setText("Wild Pikimon has appeared! Who do you want to fight?");
			
			btnBack = new JButton("Back");
			btnBack.setBounds(428, 20, 65, 23);
			textPanel.add(btnBack);
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnBack.setBackground(SystemColor.menu);
			btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuScreen menuScreen = new MenuScreen(game, inventory, pikimonTeam, battle, shop);
				menuScreen.setVisible(true);
				}
			}
		);}
		
		background = new JLabel("");
		background.setBounds(0, 0, 512, 288);
		background.setFont(new Font("Tahoma", Font.BOLD, 11));
		background.setIcon(new ImageIcon(MenuScreen.class.getResource(String.format("%s", game.setBackground()))));
		background.setBackground(Color.BLACK);
		contentPane.add(background);
	}
}
