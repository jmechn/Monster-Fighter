package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Shop.ItemsForSale;
import characters.Pikimon;
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
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.JTextPane;

/**
 * 
 * Pikimon fight screen
 * 
 * @author Jaymee Chen
 *
 */
public class BattleScreen extends JFrame {
	
	private JPanel contentPane;
	private JLabel background;
	private JLabel lblDialogue;
	private JButton btnBattle;
	private JLabel pikimonImage;
	private Pikimon enemyPikimon;
	private Pikimon playerPikimon;

	
	/**
	 * 
	 * create battle screen
	 * 
	 * @param game
	 * @param inventory
	 * @param pikimonTeam
	 * @param battle
	 * @param shop
	 */
	public BattleScreen(Game game, MainInventory inventory, PikimonTeam pikimonTeam, Battle battle,
			ItemsForSale shop){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		playerPikimon = game.getPlayerTeam().get(battle.getPlayerIndex());
		contentPane = new JPanel();
		
		if(game.getDay() % 5  == 0 && game.getDay() != 0) {
			enemyPikimon = game.getBossTeam().get(battle.getEnemyIndex());
		}
		else {
			enemyPikimon = battle.getRandomEnemyList().get(battle.getEnemyIndex());
		}
		
		battle.calcTurn(enemyPikimon.getSpeed(), playerPikimon.getSpeed());
		
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setResizable(false);
		
		contentPane.setLayout(null);
		
		
		/* Opaque text panel */
		
		JPanel playerInfo = new JPanel();
		playerInfo.setBackground(new Color(255, 255, 255));
		playerInfo.setBounds(279, 144, 225, 53);
		contentPane.add(playerInfo);
		playerInfo.setLayout(null);

		
		JProgressBar pikimonHpBar = new JProgressBar();
		pikimonHpBar.setFocusable(false);
		pikimonHpBar.setFocusTraversalKeysEnabled(false);
		
		pikimonHpBar.setBounds(63, 30, 153, 14);
		pikimonHpBar.setMaximum(playerPikimon.getMaxHp());
		pikimonHpBar.setValue(playerPikimon.getHp());
		
		pikimonHpBar.setStringPainted(true);
		pikimonHpBar.setString(Integer.toString(playerPikimon.getHp()));
		playerInfo.add(pikimonHpBar);
		
		
		JLabel pikimonLevel = new JLabel(String.format("LVL %d", playerPikimon.getLevel()));
		pikimonLevel.setFont(new Font("Tahoma", Font.BOLD, 10));
		pikimonLevel.setBounds(10, 11, 46, 14);
		playerInfo.add(pikimonLevel);
		
		JLabel pikimonName = new JLabel();
		pikimonName.setFont(new Font("Tahoma", Font.BOLD, 10));
		pikimonName.setBounds(63, 11, 99, 14);
		pikimonName.setText(playerPikimon.getName());
		playerInfo.add(pikimonName);
		
		JLabel pikimonHp = new JLabel();
		pikimonHp.setFont(new Font("Tahoma", Font.BOLD, 10));
		pikimonHp.setBounds(10, 28, 64, 14);
		pikimonHp.setText(String.format("%d/%d"
				, playerPikimon.getHp()
				, playerPikimon.getMaxHp()));
		playerInfo.add(pikimonHp);
		
		
		pikimonImage = new JLabel("");
		pikimonImage.setIcon(new ImageIcon(BattleScreen.class.getResource(playerPikimon.getImagePath())));
		pikimonImage.setBounds(61, 85, 120, 112);
		contentPane.add(pikimonImage);
		
		JPanel enemyInfo = new JPanel();
		enemyInfo.setLayout(null);
		enemyInfo.setBackground(new Color(255, 255, 255));
		enemyInfo.setBounds(10, 34, 225, 53);
		contentPane.add(enemyInfo);
		
		JProgressBar enemyHpBar = new JProgressBar();
		enemyHpBar.setFocusable(false);
		enemyHpBar.setFocusTraversalKeysEnabled(false);
		
		enemyHpBar.setBounds(63, 30, 153, 14);
		enemyHpBar.setMaximum(enemyPikimon.getMaxHp());
		enemyHpBar.setValue(enemyPikimon.getHp());
		enemyHpBar.setString(Integer.toString(enemyPikimon.getHp()));
		
		enemyHpBar.setStringPainted(true);
		enemyInfo.add(enemyHpBar);
		
		
		JLabel enemyLevel = new JLabel(String.format("LVL %d",
				enemyPikimon.getLevel()));
		enemyLevel.setFont(new Font("Tahoma", Font.BOLD, 10));
		enemyLevel.setBounds(10, 11, 46, 14);
		enemyInfo.add(enemyLevel);
		
		JLabel enemyName = new JLabel(enemyPikimon.getName());
		enemyName.setFont(new Font("Tahoma", Font.BOLD, 10));
		enemyName.setBounds(63, 11, 99, 14);
		enemyInfo.add(enemyName);
		
		JLabel enemyHp = new JLabel();
		enemyHp.setFont(new Font("Tahoma", Font.BOLD, 10));
		enemyHp.setBounds(10, 28, 64, 14);
		enemyHp.setText(String.format("%d/%d"
				, enemyPikimon.getHp()
				, enemyPikimon.getMaxHp()));
		enemyInfo.add(enemyHp);
		
		JLabel enemyImage = new JLabel("");
		enemyImage.setIcon(new ImageIcon(BattleScreen.class.getResource(enemyPikimon.getImagePath())));
		enemyImage.setBounds(311, 0, 120, 112);
		contentPane.add(enemyImage);
		
		
		
		JPanel textPanel = new JPanel();
		textPanel.setBounds(0, 208, 505, 80);
		textPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(textPanel);
		textPanel.setLayout(null);
		
		JTextPane lblPlayerAction = new JTextPane();
		lblPlayerAction.setText("What would you like to do?");
		lblPlayerAction.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPlayerAction.setBounds(10, 12, 245, 41);
		lblPlayerAction.setVisible(false);
		textPanel.add(lblPlayerAction);
		
		
		lblDialogue = new JLabel();
		lblDialogue.setText(String.format("<html>You sent out %s! <br>What would you like to do?</html>", playerPikimon.getName()));
		lblDialogue.setBounds(10, 11, 245, 42);
		lblDialogue.setFont(new Font("Tahoma", Font.BOLD, 10));
		textPanel.add(lblDialogue);
		

		ActionListener pikimonFight = new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    //	System.out.print(enemyPikimon.getSpeed());
		    	btnBattle.setVisible(false);
		    	lblPlayerAction.setVisible(false);
		    	
		    	lblDialogue.setText(String.format("%s", 
						battle.battleDamage(game, playerPikimon, enemyPikimon, pikimonTeam, battle.getTurn())));
		    	if (game.getPlayerTeam().size()>0) {
					playerPikimon = game.getPlayerTeam().get(0);
					pikimonImage.setIcon(new ImageIcon(BattleScreen.class.getResource(playerPikimon.getImagePath())));
					pikimonName.setText(playerPikimon.getName());
					pikimonLevel.setText(String.format("LVL %d", playerPikimon.getLevel()));
					pikimonHpBar.setMaximum(playerPikimon.getMaxHp());
					pikimonHpBar.setValue(playerPikimon.getHp());
					pikimonHpBar.setString(Integer.toString(playerPikimon.getHp()));
					pikimonHp.setText(String.format("%d/%d"
							, playerPikimon.getHp()
							, playerPikimon.getMaxHp()));
					enemyHpBar.setValue(enemyPikimon.getHp());
					enemyHpBar.setString(Integer.toString(enemyPikimon.getHp()));
					enemyHp.setText(String.format("%d/%d"
							, enemyPikimon.getHp()
							, enemyPikimon.getMaxHp()));
					
						
					if (game.getPlayerTeam().size() == 1) {
						lblDialogue.setText(String.format("<html>Last pikimon!<br>"
								+ "You sent out %s</html>"
								, playerPikimon.getHp()));
							}
						}
		    	else {
		    		/** Removes screen when player runs out of Pikimon. **/
		    		dispose();
		    	}
		    		}
				};
		
			ActionListener defaultLabel = new ActionListener() {
			    public void actionPerformed(ActionEvent evt) {
			    	if (enemyPikimon.getHp()>0) {
			    		btnBattle.setVisible(true);
			    		lblPlayerAction.setVisible(true);
			    	}
			    	else if (game.getPlayerTeam().size() == 0) {
			    		dispose();
						LoseScreen loseScreen = new LoseScreen(game, inventory, pikimonTeam, battle, shop);
						loseScreen.setVisible(true);
					}
			    	else {
			    		dispose();
			    		BattleWinScreen battleWinScreen = new BattleWinScreen(game, inventory, pikimonTeam, battle, shop);
			    		battleWinScreen.setVisible(true);
			    	}
				}};
			
			ActionListener midBattleCheck = new ActionListener() {
			    public void actionPerformed(ActionEvent evt) {
			    	if (game.getPlayerTeam().size() == 0) {
						dispose();
						
						/* Double pop up for lose screen */
						LoseScreen loseScreen = new LoseScreen(game, inventory, pikimonTeam, battle, shop);
						loseScreen.setVisible(true);
			    	}
				}};

					
		
			
		btnBattle = new JButton("Attack");
		btnBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* ERROR CATCHING : makes user unable to spam the attack button */
				btnBattle.setVisible(false);
				
				/**
				 * Calculates if player pikimon or enemy attacks first
				 */
				battle.calcTurn(enemyPikimon.getSpeed(), playerPikimon.getSpeed());
				/**
				 * Delay timer to show animation
				 * 
				 */
				Timer firstTurn = new Timer(300, pikimonFight);
				firstTurn.setRepeats( false );
				firstTurn.start();

				Timer midBattleCheckDead = new Timer(300, midBattleCheck);
				midBattleCheckDead.setRepeats( false );
				midBattleCheckDead.start();
				
				
				Timer secondTurn = new Timer(700, pikimonFight);
				secondTurn.setRepeats( false );
				secondTurn.start();
				
				Timer returnDefaultLabel = new Timer(1000, defaultLabel);
				returnDefaultLabel.setRepeats( false );
				returnDefaultLabel.start();

				
				btnBattle.setVisible(true);
				}
			});
	
		

		
		btnBattle.setBounds(283, 20, 80, 23);
		btnBattle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBattle.setBackground(SystemColor.control);
		textPanel.add(btnBattle);	
		
		
		background = new JLabel("");
		background.setBounds(0, 0, 512, 288);
		background.setFont(new Font("Tahoma", Font.BOLD, 11));
		background.setIcon(new ImageIcon(BattleScreen.class.getResource(String.format("%s", game.setBackground()))));
		background.setBackground(Color.BLACK);
		contentPane.add(background);
	}
}
