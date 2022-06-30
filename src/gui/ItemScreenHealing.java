package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Shop.ItemsForSale;
import game.Battle;
import game.Game;
import game.PikimonTeam;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import inventory.MainInventory;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemScreenHealing extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ItemScreenHealing(Game game, MainInventory inventory, PikimonTeam pikimonTeam, Battle battle, ItemsForSale shop) {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Click on the Pikimon you want to heal:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(30, 21, 317, 45);
		contentPane.add(lblNewLabel);
		
		JButton zero = new JButton("0");
		zero.setBackground(Color.BLACK);
		zero.setForeground(Color.BLACK);
		zero.setIcon(new ImageIcon(ItemScreenHealing.class.getResource(game.getPlayerTeam().get(0).getImagePath())));
		zero.setBounds(37, 106, 68, 58);
		contentPane.add(zero);
		
		JButton two = new JButton("2");
		two.setBackground(Color.BLACK);
		two.setBounds(272, 106, 75, 58);
		contentPane.add(two);
		
		JButton three = new JButton("3");
		three.setBackground(Color.BLACK);
		three.setBounds(395, 107, 68, 58);
		contentPane.add(three);
		
		JButton one = new JButton("1");
		one.setBackground(Color.BLACK);
		one.setBounds(147, 106, 75, 58);
		contentPane.add(one);
		
		JLabel hpGainedLabel = new JLabel();		
		hpGainedLabel.setBounds(312, 238, 110, 22);
		
		if (ItemScreen.BandaidBut==true) {
			hpGainedLabel = new JLabel("Hp Gained:25");
		}
		if (ItemScreen.PanadolBut==true) {
			hpGainedLabel = new JLabel("Hp Gained:50");
			
		}
		else {
			hpGainedLabel= new JLabel("Hp Gained:75");
		}
		contentPane.add(hpGainedLabel);

		
		
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ItemScreen newmenu = new ItemScreen(game, inventory,pikimonTeam,battle,shop);
				newmenu.setVisible(true);
			}
		});
		backButton.setBackground(Color.BLACK);
		backButton.setBounds(10, 230, 96, 22);
		contentPane.add(backButton);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon(ItemScreenHealing.class.getResource("/images/Inventory/forest.jpg")));
		background.setBounds(-12, -4, 531, 302);
		contentPane.add(background);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(129, 209, 293, 14);
		contentPane.add(lblNewLabel_1);
		if (game.getPlayerTeam().size()==1) {
			two.setVisible(true);
			
		}
		
		if (game.getPlayerTeam().size()==2) {
			zero.setVisible(true);
			three.setVisible(true);
	
		}
		if (game.getPlayerTeam().size()==3) {
			one.setVisible(true);
			zero.setVisible(true);
			three.setVisible(true);
			
			
			
		}
	}

}
