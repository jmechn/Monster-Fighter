package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import characters.Pikimon;
import Shop.ItemsForSale;
import buyCharacters.Articuna;
import buyCharacters.FireChicken;
import buyCharacters.Ninetails;
import buyCharacters.Snorex;
import buyCharacters.Sudowood;
import buyCharacters.Venasaur;
import game.Battle;
import game.Game;
import game.PikimonTeam;
import inventory.MainInventory;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ShopPikimonSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ShopPikimonSelection(Game game, MainInventory inventory, PikimonTeam pikimonTeam, Battle battle, ItemsForSale shop) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel updateTeam = new JLabel("");
		updateTeam.setForeground(Color.WHITE);
		updateTeam.setFont(new Font("Tahoma", Font.BOLD, 11));
		updateTeam.setBounds(140, 78, 235, 14);
		contentPane.add(updateTeam);
		
		JLabel coinCounter = new JLabel(String.format("Coins: %d", game.getCoins()));
		coinCounter.setForeground(Color.WHITE);
		coinCounter.setFont(new Font("Tahoma", Font.BOLD, 11));
		coinCounter.setBounds(15, 11, 84, 14);
		contentPane.add(coinCounter);
		

		
		JLabel Title = new JLabel("Please select a Pikimon to buy:");
		Title.setForeground(Color.WHITE);
		Title.setFont(new Font("Tahoma", Font.BOLD, 18));
		Title.setBounds(94, 23, 313, 44);
		contentPane.add(Title);
		
		JButton PikiButtonOne = new JButton("");
		PikiButtonOne.setIcon(new ImageIcon(ShopPikimonSelection.class.getResource("/images/buyPikimon/combusken-resize.png")));
		PikiButtonOne.setBounds(89, 156, 69, 60);
		contentPane.add(PikiButtonOne);
		PikiButtonOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getPlayerTeam().size()<4) {
					if (game.getCoins()>100) {
						Pikimon chick=new FireChicken(Pikimon.getDefaultLevel());
						pikimonTeam.addPikimon(chick);
						game.setCoins(100);
						coinCounter.setText(String.format("Coins: %d", game.getCoins()));
						updateTeam.setText(chick.getName()+" is added to your team!");
					}
					
				}
				else {
					updateTeam.setText("Sorry team is full!");
					PikiButtonOne.setVisible(false);
					
				}
			}
		});

		
		JButton PikiButtonTwo = new JButton("");
		PikiButtonTwo.setIcon(new ImageIcon(ShopPikimonSelection.class.getResource("/images/buyPikimon/ninetales-resized.png")));
		PikiButtonTwo.setBounds(168, 124, 69, 60);
		contentPane.add(PikiButtonTwo);
		PikiButtonTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getPlayerTeam().size()<4) {
					if (game.getCoins()>100) {
						Ninetails tail= new Ninetails(Pikimon.getDefaultLevel());
						pikimonTeam.addPikimon(tail);
						game.setCoins(100);
						coinCounter.setText(String.format("Coins: %d", game.getCoins()));
						updateTeam.setText(tail.getName()+" is added to your team!");
					}
					
				}
				else {
					updateTeam.setText("Sorry team is full!");
					PikiButtonOne.setVisible(false);
					
				}
					}
			
		});
		
		JButton PikiButtonThree = new JButton("");
		PikiButtonThree.setIcon(new ImageIcon(ShopPikimonSelection.class.getResource("/images/buyPikimon/sudowoodo-resize.png")));
		PikiButtonThree.setBounds(252, 124, 77, 60);
		contentPane.add(PikiButtonThree);
		PikiButtonThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getPlayerTeam().size()<4) {
					if (game.getCoins()>100) {
						Sudowood sudo= new Sudowood(Pikimon.getDefaultLevel());
						pikimonTeam.addPikimon(sudo);
						game.setCoins(100);
						coinCounter.setText(String.format("Coins: %d", game.getCoins()));
						updateTeam.setText(sudo.getName()+" is added to your team!");
					}
					
				}
				else {
					updateTeam.setText("Sorry team is full!");
					PikiButtonOne.setVisible(false);
					
				}
			}
		});

		
		
		JLabel lblNewLabel = new JLabel("Price: $100");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(15, 109, 77, 14);
		contentPane.add(lblNewLabel);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShopScreen screen= new ShopScreen(game,inventory,pikimonTeam,battle,shop);
				screen.setVisible(true);
				
			}
		});
		Back.setBounds(10, 249, 89, 23);
		contentPane.add(Back);
		
		JButton articunaBut = new JButton("");
		articunaBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getPlayerTeam().size()<4) {
					if (game.getCoins()>100) {
						Articuna tail= new Articuna(Pikimon.getDefaultLevel());
						pikimonTeam.addPikimon(tail);
						game.setCoins(100);
						coinCounter.setText(String.format("Coins: %d", game.getCoins()));
						updateTeam.setText(tail.getName()+" is added to your team!");
					}
					
				}
				else {
					updateTeam.setText("Sorry team is full!");
					PikiButtonOne.setVisible(false);
					
				}
					}
			
			
		});
		articunaBut.setIcon(new ImageIcon(ShopPikimonSelection.class.getResource("/images/buyPikimon/articuno - Copy.png")));
		articunaBut.setBounds(338, 156, 69, 60);
		contentPane.add(articunaBut);
		
		JButton SnorexBut = new JButton("");
		SnorexBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (game.getPlayerTeam().size()<4) {
					if (game.getCoins()>100) {
						Snorex tail= new Snorex(Pikimon.getDefaultLevel());
						pikimonTeam.addPikimon(tail);
						game.setCoins(100);
						coinCounter.setText(String.format("Coins: %d", game.getCoins()));
						updateTeam.setText(tail.getName()+" is added to your team!");
					}
					
				}
				else {
					updateTeam.setText("Sorry team is full!");
					PikiButtonOne.setVisible(false);
					
				}
					}
			
				
			
		});
		SnorexBut.setIcon(new ImageIcon(ShopPikimonSelection.class.getResource("/images/buyPikimon/snorlax.png")));
		SnorexBut.setBounds(168, 208, 69, 44);
		contentPane.add(SnorexBut);
		
		JButton VenasaurBut = new JButton("");
		VenasaurBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getPlayerTeam().size()<4) {
					if (game.getCoins()>100) {
						Venasaur tail= new Venasaur(Pikimon.getDefaultLevel());
						pikimonTeam.addPikimon(tail);
						game.setCoins(100);
						coinCounter.setText(String.format("Coins: %d", game.getCoins()));
						updateTeam.setText(tail.getName()+" is added to your team!");
					}
					
				}
				else {
					updateTeam.setText("Sorry team is full!");
					PikiButtonOne.setVisible(false);
					
				}
					}
			
			
		});
		VenasaurBut.setIcon(new ImageIcon(ShopPikimonSelection.class.getResource("/images/buyPikimon/venusaur.png")));
		VenasaurBut.setBounds(252, 208, 77, 44);
		contentPane.add(VenasaurBut);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(ShopPikimonSelection.class.getResource("/images/Backgrounds/inventoryBackground.jpg")));
		lblNewLabel_2.setBounds(-93, -29, 656, 312);
		contentPane.add(lblNewLabel_2);
		
	
	

		
		
		
		
	}

}
