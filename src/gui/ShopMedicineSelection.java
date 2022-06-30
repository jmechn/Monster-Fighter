package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Shop.ItemsForSale;
import game.Battle;
import game.Game;
import game.PikimonTeam;
import inventory.MainInventory;
import inventory.potions;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ShopMedicineSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ShopMedicineSelection(Game game, MainInventory inventory, PikimonTeam pikimonTeam, Battle battle, ItemsForSale shop) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel coinsCounter = new JLabel(String.format("Coins: %d", game.getCoins()));
		coinsCounter.setForeground(Color.WHITE);
		coinsCounter.setBounds(0, 11, 80, 14);
		contentPane.add(coinsCounter);
		
		JLabel addPanadol = new JLabel("");
		addPanadol.setFont(new Font("Tahoma", Font.BOLD, 11));
		addPanadol.setForeground(Color.WHITE);
		addPanadol.setBounds(158, 210, 151, 14);
		contentPane.add(addPanadol);
		
		JLabel addCoughSyrup = new JLabel("");
		addCoughSyrup.setForeground(Color.WHITE);
		addCoughSyrup.setBounds(319, 210, 172, 14);
		contentPane.add(addCoughSyrup);
		
		JLabel lblNewLabel = new JLabel("Please select an item to buy:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(89, 32, 299, 28);
		contentPane.add(lblNewLabel);
		
		JLabel BandaidImage = new JLabel("New label");
		BandaidImage.setIcon(new ImageIcon(ShopMedicineSelection.class.getResource("/images/Inventory/bandaid-rezied.jpg")));
		BandaidImage.setBounds(55, 101, 80, 60);
		contentPane.add(BandaidImage);
		
		JLabel PanadolImage = new JLabel("");
		PanadolImage.setIcon(new ImageIcon(ShopMedicineSelection.class.getResource("/images/Inventory/Panadol.jpg")));
		PanadolImage.setBounds(196, 101, 95, 60);
		contentPane.add(PanadolImage);
		
		JLabel CoughSyrupImage = new JLabel("New label");
		CoughSyrupImage.setIcon(new ImageIcon(ShopMedicineSelection.class.getResource("/images/Inventory/Cough Syrup.png")));
		CoughSyrupImage.setBounds(367, 95, 95, 73);
		contentPane.add(CoughSyrupImage);
		
		JLabel Bandaidadded = new JLabel("");
		Bandaidadded.setFont(new Font("Tahoma", Font.BOLD, 11));
		Bandaidadded.setForeground(Color.WHITE);
		Bandaidadded.setBounds(10, 210, 141, 14);
		contentPane.add(Bandaidadded);
		JLabel NoMoney = new JLabel("");
		NoMoney.setForeground(Color.WHITE);
		NoMoney.setFont(new Font("Tahoma", Font.BOLD, 15));
		NoMoney.setBounds(135, 235, 201, 14);
		contentPane.add(NoMoney);
		
		JButton buyBandaidButton = new JButton("Buy");
		buyBandaidButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getCoins()<25) {
					buyBandaidButton.setVisible(false);
					NoMoney.setText("Not enough coins");
				}
				else {
				game.setCoins(25);
				Bandaidadded.setText("added to your inventory");
				inventory.addPotion(new potions("Bandaid"));
				coinsCounter.setText(String.format("Coins: %d", game.getCoins()));
				}
			}
		});
		buyBandaidButton.setBounds(65, 172, 58, 14);
		contentPane.add(buyBandaidButton);
		
		JButton BuyPanadolButton = new JButton("Buy");
		BuyPanadolButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getCoins()<35) {
					BuyPanadolButton.setVisible(false);
					NoMoney.setText("Not enough coins");
				}
				else {
				game.setCoins(35);
				addPanadol.setText("added to inventory!");
				inventory.addPotion(new potions("Panadol"));
				coinsCounter.setText(String.format("Coins: %d", game.getCoins()));
				}
			}
		});
		BuyPanadolButton.setBounds(206, 172, 65, 14);
		contentPane.add(BuyPanadolButton);
		
		JButton CoughSyrupButton = new JButton("Buy");
		CoughSyrupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getCoins()<60) {
					CoughSyrupButton.setVisible(false);
					NoMoney.setText("Not enough coins");
				}
				else {
				game.setCoins(60);
				inventory.addPotion(new potions("Cough Syrup"));
				addCoughSyrup.setText("added to inventory");
				coinsCounter.setText(String.format("Coins: %d", game.getCoins()));
				}
			}
		});
		CoughSyrupButton.setBounds(377, 179, 65, 14);
		contentPane.add(CoughSyrupButton);
		
		JLabel lblNewLabel_4 = new JLabel("Price: $25");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(64, 185, 87, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Price: $35");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(216, 185, 93, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Price: $60");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(387, 196, 75, 14);
		contentPane.add(lblNewLabel_6);
		
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShopScreen screen= new ShopScreen(game,inventory,pikimonTeam,battle,shop);
				screen.setVisible(true);
			}
		});
		backButton.setBounds(10, 249, 89, 23);
		contentPane.add(backButton);
		
		JLabel BandaidLabel = new JLabel("Bandaid: +25hp");
		BandaidLabel.setForeground(Color.WHITE);
		BandaidLabel.setBounds(40, 71, 95, 14);
		contentPane.add(BandaidLabel);
		
		JLabel panadolLabel = new JLabel("Panadol: +50hp");
		panadolLabel.setForeground(Color.WHITE);
		panadolLabel.setBounds(206, 76, 85, 14);
		contentPane.add(panadolLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Cough Syrup: +75hp");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(362, 70, 116, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ShopMedicineSelection.class.getResource("/images/Backgrounds/inventoryBackground.jpg")));
		lblNewLabel_1.setBounds(-16, 0, 545, 299);
		contentPane.add(lblNewLabel_1);
		
		
		
		

	}

}
