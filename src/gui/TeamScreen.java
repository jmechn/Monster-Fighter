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
import javax.swing.JTextPane;

public class TeamScreen extends JFrame {
	
	private JPanel contentPane;
	/**
	 * Create the frame.
	 * @param game 
	 * @param inventory 
	 * @param viewTeam2 
	 * @param menu2 
	 * @param pikimonTeam 
	 * @param shop 
	 * @param battle 
	 */
	public TeamScreen(Game game, MainInventory inventory, PikimonTeam pikimonTeam, Battle battle, ItemsForSale shop) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setFocusable(false);
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setResizable(false);
		
		JButton goBack = new JButton("Back");
		goBack.setBounds(10, 21, 72, 25);
		goBack.setBackground(SystemColor.control);
		goBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MenuScreen menuScreen = new MenuScreen(game, inventory, pikimonTeam, battle, shop);
				menuScreen.setVisible(true);
			}
		});
		contentPane.add(goBack);
		
		
		if (pikimonTeam.getSize() > 0) {
			/* First Pikimon */
			
			JLabel PikimonName1 = new JLabel(game.getPlayerTeam().get(0).getName());
			PikimonName1.setFont(new Font("Tahoma", Font.BOLD, 11));
			PikimonName1.setForeground(SystemColor.window);
			PikimonName1.setBounds(10, 83, 92, 14);
			contentPane.add(PikimonName1);

			JLabel pikimonImage1 = new JLabel("");
			pikimonImage1.setBounds(0, 40, 112, 112);
			pikimonImage1.setIcon(new ImageIcon(TeamScreen.class.getResource(game.getPlayerTeam().get(0).getImagePath())));
			pikimonImage1.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(pikimonImage1);
			
			JTextPane pikimonStats1 = new JTextPane();
			pikimonStats1.setEditable(false);
			pikimonStats1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			pikimonStats1.setFont(new Font("Tahoma", Font.PLAIN, 10));
			pikimonStats1.setText(String.format("\n\n\n\nLevel: %d\n"
					+ "HP: %d/%d\n"
					+ "Attack: %d\n"
					+ "Speed: %d\n"
					+ "Type: %s\n"
					+ "Statis: %s"
					, game.getPlayerTeam().get(0).getLevel()
					, game.getPlayerTeam().get(0).getHp(), game.getPlayerTeam().get(0).getMaxHp()
					, game.getPlayerTeam().get(0).getAttack()
					, game.getPlayerTeam().get(0).getSpeed()
					, game.getPlayerTeam().get(0).getType()
					, game.getPlayerTeam().get(0).getStatus()));
			pikimonStats1.setBounds(6, 100, 116, 137);
			pikimonStats1.setBackground(new Color(255, 255, 255, 123));
			contentPane.add(pikimonStats1);
		}
		
		if (pikimonTeam.getSize() >1) {
			/* Second Pikimon */
			JLabel PikimonName2 = new JLabel(game.getPlayerTeam().get(1).getName());
			PikimonName2.setForeground(Color.WHITE);
			PikimonName2.setFont(new Font("Tahoma", Font.BOLD, 11));
			PikimonName2.setBounds(134, 83, 92, 14);
			contentPane.add(PikimonName2);
			
			JLabel pikimonImage2 = new JLabel("");
			pikimonImage2.setHorizontalAlignment(SwingConstants.CENTER);
			pikimonImage2.setBounds(124, 40, 112, 112);
			pikimonImage2.setIcon(new ImageIcon(TeamScreen.class.getResource(game.getPlayerTeam().get(1).getImagePath())));
			contentPane.add(pikimonImage2);
			
			JTextPane pikimonStats2 = new JTextPane();
			pikimonStats2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			pikimonStats2.setText(String.format("\n\n\n\nLevel: %d\n"
					+ "HP: %d/%d\n"
					+ "Attack: %d\n"
					+ "Speed: %d\n"
					+ "Type: %s\n"
					+ "Statis: %s"
					, game.getPlayerTeam().get(1).getLevel()
					, game.getPlayerTeam().get(1).getHp(), game.getPlayerTeam().get(1).getMaxHp()
					, game.getPlayerTeam().get(1).getAttack()
					, game.getPlayerTeam().get(1).getSpeed()
					, game.getPlayerTeam().get(1).getType()
					, game.getPlayerTeam().get(1).getStatus()));
			pikimonStats2.setFont(new Font("Tahoma", Font.PLAIN, 10));
			pikimonStats2.setEditable(false);
			pikimonStats2.setBackground(new Color(255, 255, 255, 123));
			pikimonStats2.setBounds(130, 100, 116, 137);
			contentPane.add(pikimonStats2);
		}
		
		if (pikimonTeam.getSize()>2) {	
			/* Third Pikimon */
			
			JLabel PikimonName3 = new JLabel(game.getPlayerTeam().get(2).getName());
			PikimonName3.setForeground(Color.WHITE);
			PikimonName3.setFont(new Font("Tahoma", Font.BOLD, 11));
			PikimonName3.setBounds(261, 83, 92, 14);
			contentPane.add(PikimonName3);
			
			JLabel pikimonImage3 = new JLabel("");
			pikimonImage3.setHorizontalAlignment(SwingConstants.CENTER);
			pikimonImage3.setIcon(new ImageIcon(TeamScreen.class.getResource(game.getPlayerTeam().get(2).getImagePath())));
			pikimonImage3.setBounds(251, 40, 112, 112);
			contentPane.add(pikimonImage3);
			
			JTextPane pikimonStats3 = new JTextPane();
			pikimonStats3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			pikimonStats3.setText(String.format("\n\n\n\nLevel: %d\n"
					+ "HP: %d/%d\n"
					+ "Attack: %d\n"
					+ "Speed: %d\n"
					+ "Type: %s\n"
					+ "Statis: %s"
					, game.getPlayerTeam().get(2).getLevel()
					, game.getPlayerTeam().get(2).getHp(), game.getPlayerTeam().get(2).getMaxHp()
					, game.getPlayerTeam().get(2).getAttack()
					, game.getPlayerTeam().get(2).getSpeed()
					, game.getPlayerTeam().get(2).getType()
					, game.getPlayerTeam().get(2).getStatus()));
			pikimonStats3.setFont(new Font("Tahoma", Font.PLAIN, 10));
			pikimonStats3.setEditable(false);
			pikimonStats3.setBackground(new Color(255, 255, 255, 123));
			pikimonStats3.setBounds(257, 100, 116, 137);
			contentPane.add(pikimonStats3);
		}
		
		if (pikimonTeam.getSize() > 3) {
			/* Fourth Pikimon */
			JLabel PikimonName4 = new JLabel(game.getPlayerTeam().get(3).getName());
			PikimonName4.setForeground(Color.WHITE);
			PikimonName4.setFont(new Font("Tahoma", Font.BOLD, 11));
			PikimonName4.setBounds(383, 83, 92, 14);
			contentPane.add(PikimonName4);
			
			JLabel pikimonImage4 = new JLabel("");
			pikimonImage4.setHorizontalAlignment(SwingConstants.CENTER);
			pikimonImage4.setIcon(new ImageIcon(TeamScreen.class.getResource(game.getPlayerTeam().get(3
					).getImagePath())));
			pikimonImage4.setBounds(373, 40, 112, 112);
			contentPane.add(pikimonImage4);
			
			
			JTextPane pikimonStats4 = new JTextPane();
			pikimonStats4.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			pikimonStats4.setText(String.format("\n\n\n\nLevel: %d\n"
					+ "HP: %d/%d\n"
					+ "Attack: %d\n"
					+ "Speed: %d\n"
					+ "Type: %s\n"
					+ "Statis: %s"
					, game.getPlayerTeam().get(3).getLevel()
					, game.getPlayerTeam().get(3).getHp(), game.getPlayerTeam().get(3).getMaxHp()
					, game.getPlayerTeam().get(3).getAttack()
					, game.getPlayerTeam().get(3).getSpeed()
					, game.getPlayerTeam().get(3).getType()
					, game.getPlayerTeam().get(3).getStatus()));
			pikimonStats4.setFont(new Font("Tahoma", Font.PLAIN, 10));
			pikimonStats4.setEditable(false);
			pikimonStats4.setBackground(new Color(255, 255, 255, 123));
			pikimonStats4.setBounds(379, 100, 116, 137);
			contentPane.add(pikimonStats4);
		}
		
		JLabel background = new JLabel("");
		background.setFont(new Font("Tahoma", Font.PLAIN, 10));
		background.setBounds(0, 0, 512, 288);
		background.setBackground(Color.BLACK);
		background.setIcon(new ImageIcon(TeamScreen.class.getResource("/images/Backgrounds/battlebgIndoorC.png")));
		contentPane.add(background);	
	}
}
	
