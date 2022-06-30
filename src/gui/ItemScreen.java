
package gui;
import inventory.MainInventory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Shop.ItemsForSale;
import game.Battle;
import game.Game;
import game.PikimonTeam;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemScreen extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public static boolean coughSyrupBut=false;
	public static boolean BandaidBut=false;
	public static boolean PanadolBut=false;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ItemScreen(Game game, MainInventory inventory, PikimonTeam pikimonTeam, Battle battle, ItemsForSale shop) {
		setTitle("Inventory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel coins=new JLabel(String.format("Coins: %d", game.getCoins()));
		coins.setForeground(Color.WHITE);
		coins.setFont(new Font("Tahoma", Font.BOLD, 11));
		coins.setBounds(10, 11, 102, 14);
		contentPane.add(coins);
		
		JLabel itemCount = new JLabel(String.format("Items: %d", inventory.getPotionList().size()));
		itemCount.setFont(new Font("Tahoma", Font.BOLD, 12));
		itemCount.setForeground(Color.WHITE);
		itemCount.setBounds(414, 10, 73, 14);
		contentPane.add(itemCount);
		
		
		
		JLabel title = new JLabel("Pikimon Inventory");
		title .setForeground(Color.WHITE);
		title .setFont(new Font("Tahoma", Font.PLAIN, 20));
		title .setBounds(139, -12, 177, 53);
		contentPane.add(title );
		
		JLabel bandaidImage = new JLabel("Bandaid");
		bandaidImage.setIcon(new ImageIcon(ItemScreen.class.getResource("/images/Inventory/bandaid-rezied.jpg")));
		bandaidImage.setBounds(38, 75, 73, 87);
		contentPane.add(bandaidImage);
		
		JLabel coughSyrupImage = new JLabel("Cough Syrup");
		coughSyrupImage.setIcon(new ImageIcon(ItemScreen.class.getResource("/images/Inventory/Cough Syrup.png")));
		coughSyrupImage.setBounds(375, 82, 73, 72);
		contentPane.add(coughSyrupImage);
		
		JButton BandaidDelete = new JButton("Delete");
		BandaidDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int delete=inventory.getPotionIndex("Bandaid");
				inventory.getPotionList().remove(delete);
				game.setCoins(5);
				coins.setText(String.format("Coins: %d", game.getCoins()));
				itemCount.setText(String.format("Items: %d", inventory.getPotionList().size()));
			
				
						}
		});
		BandaidDelete.setBackground(Color.LIGHT_GRAY);
		BandaidDelete.setBounds(76, 162, 73, 14);
		contentPane.add(BandaidDelete);
		
		JLabel BandaidLabel = new JLabel("Bandaid");
		BandaidLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		BandaidLabel.setForeground(Color.WHITE);
		BandaidLabel.setBounds(50, 50, 49, 14);
		contentPane.add(BandaidLabel);
		
		JLabel PanadolImage = new JLabel("");
		PanadolImage.setIcon(new ImageIcon(ItemScreen.class.getResource("/images/Inventory/Panadol.jpg")));
		PanadolImage.setBounds(199, 90, 80, 57);
		contentPane.add(PanadolImage);
		
		JLabel PanadolLabel = new JLabel("Panadol");
		PanadolLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		PanadolLabel.setForeground(Color.WHITE);
		PanadolLabel.setBounds(218, 50, 49, 14);
		contentPane.add(PanadolLabel);
		
		JLabel CoughSyrupLabel = new JLabel("Cough Syrup");
		CoughSyrupLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		CoughSyrupLabel.setForeground(Color.WHITE);
		CoughSyrupLabel.setBounds(375, 50, 73, 14);
		contentPane.add(CoughSyrupLabel);
		
		JButton PanadolUse = new JButton("Use");
		PanadolUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ItemScreenHealing newmenu = new ItemScreenHealing(game,inventory,pikimonTeam,battle,shop);
				newmenu.setVisible(true);
				ItemScreen.PanadolBut= true;
								
			}
		});
		PanadolUse.setBackground(Color.LIGHT_GRAY);
		PanadolUse.setBounds(166, 162, 67, 14);
		contentPane.add(PanadolUse);
		
		JButton PanadolDelete = new JButton("Delete");
		PanadolDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int delete=inventory.getPotionIndex("Panadol");
				inventory.getPotionList().remove(delete);
				game.setCoins(20);
				coins.setText(String.format("Coins: %d", game.getCoins()));
				itemCount.setText(String.format("Items: %d", inventory.getPotionList().size()));
				
			}
		});
		PanadolDelete.setBackground(Color.LIGHT_GRAY);
		PanadolDelete.setBounds(243, 162, 73, 14);
		contentPane.add(PanadolDelete);
		
		JButton CoughSyrupUse = new JButton("Use");
		CoughSyrupUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ItemScreenHealing newmenu = new ItemScreenHealing(game,inventory,pikimonTeam,battle,shop);
				newmenu.setVisible(true);
				ItemScreen.coughSyrupBut=true;
				
				
			}
		});
		CoughSyrupUse.setBackground(Color.LIGHT_GRAY);
		CoughSyrupUse.setBounds(347, 162, 60, 14);
		contentPane.add(CoughSyrupUse);
		
		JButton CoughSyrupDelete = new JButton("Delete");
		CoughSyrupDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int delete=inventory.getPotionIndex("Cough Syrup");
				inventory.getPotionList().remove(delete);
				game.setCoins(30);
				coins.setText(String.format("Coins: %d", game.getCoins()));
				itemCount.setText(String.format("Items: %d", inventory.getPotionList().size()));
				
			}
		});
		CoughSyrupDelete.setBackground(Color.LIGHT_GRAY);
		CoughSyrupDelete.setBounds(417, 162, 70, 14);
		contentPane.add(CoughSyrupDelete);
		
		JButton BandaidUse = new JButton("Use");
		BandaidUse.setBackground(Color.LIGHT_GRAY);
		BandaidUse.setBounds(10, 162, 56, 14);
		contentPane.add(BandaidUse);
		
		BandaidUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				ItemScreenHealing newmenu = new ItemScreenHealing(game,inventory,pikimonTeam,battle,shop);
				newmenu.setVisible(true);
				ItemScreen.BandaidBut=true;
				
				
			}
		});
		buttonGroup.add(BandaidUse);
		
		
		
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuScreen newMenu= new MenuScreen(game,inventory,pikimonTeam,battle,shop);
				newMenu.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 249, 115, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Can restore hp by 25.");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(10, 187, 125, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Can save Pikimon by 50 hp");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(166, 187, 160, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Can revive Pikimon by 75 hp");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(336, 187, 165, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon(ItemScreen.class.getResource("/images/Inventory/forest.jpg")));
		lblNewLabel_10.setBounds(-13, 0, 559, 301);
		contentPane.add(lblNewLabel_10);
		
		if (inventory.getPotionList().size()==0) {
			BandaidUse.setVisible(false);
			BandaidDelete.setVisible(false);
			
			CoughSyrupDelete.setVisible(false);
			CoughSyrupUse.setVisible(false);
			
			PanadolDelete.setVisible(false);
			PanadolUse.setVisible(false);
	
			
			
		}
		
		

	}
	
}
