package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Shop.ItemsForSale;
import game.Battle;
import game.Game;
import game.PikimonTeam;
import inventory.MainInventory;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ShopScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ShopScreen(Game game, MainInventory inventory, PikimonTeam pikimonTeam, Battle battle, ItemsForSale shop) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Pikimon Shop");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(127, 11, 322, 24);
		contentPane.add(lblNewLabel);
		
		JLabel coinCounter = new JLabel(String.format("Coins: %d", game.getCoins()));
		coinCounter.setFont(new Font("Tahoma", Font.BOLD, 11));
		coinCounter.setForeground(Color.WHITE);
		coinCounter.setBounds(10, 20, 78, 14);
		contentPane.add(coinCounter);
		
		JButton medicineButton = new JButton("Buy Medicine");
		medicineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShopMedicineSelection screen=new ShopMedicineSelection(game, inventory,pikimonTeam,battle,shop);
				screen.setVisible(true);
			}
		});
		medicineButton.setBounds(89, 176, 112, 24);
		contentPane.add(medicineButton);
		
		JButton PikimonButton = new JButton("Buy Pikimon");
		PikimonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShopPikimonSelection screen= new ShopPikimonSelection(game, inventory,pikimonTeam,battle,shop);
				screen.setVisible(true);
			}
		});
		PikimonButton.setBounds(296, 176, 91, 24);
		contentPane.add(PikimonButton);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuScreen screen= new MenuScreen(game, inventory,pikimonTeam,battle,shop);
				screen.setVisible(true);
			}
		});
		Back.setBounds(10, 249, 89, 23);
		contentPane.add(Back);
		
		JLabel MedicineImage = new JLabel("");
		MedicineImage.setIcon(new ImageIcon(ShopScreen.class.getResource("/images/Inventory/Medicine-resize.jpg")));
		MedicineImage.setBounds(103, 79, 112, 93);
		contentPane.add(MedicineImage);
		
		JLabel PikimonImage = new JLabel("");
		PikimonImage.setIcon(new ImageIcon(ShopScreen.class.getResource("/images/Inventory/pikachu (1).png")));
		PikimonImage.setBounds(291, 79, 96, 76);
		contentPane.add(PikimonImage);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ShopScreen.class.getResource("/images/Backgrounds/inventoryBackground.jpg")));
		lblNewLabel_1.setBounds(-49, -22, 577, 324);
		contentPane.add(lblNewLabel_1);
	}

}
