package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.Game;
import game.PikimonTeam;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class ChoosePikimonScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param viewTeam 
	 * @param menu 
	 * @param pikimonTeam 
	 * @param shop 
	 * @param battle 
	 */
	public ChoosePikimonScreen(Game game, PikimonTeam pikimonTeam) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setResizable(false);
		
	/* Opaque text panel */
		
		JPanel textPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) textPanel.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		textPanel.setBounds(0, 154, 505, 127);
		textPanel.setBackground(new Color(255, 255, 255, 123));
		contentPane.add(textPanel);
		JLabel lblDialogue = new JLabel(String.format("<html>You have chosen %s... How brave. Now before "
				+ "<br>you set off for your adventure I have a present for you. "
				+ "<br>Please choose wisely.</html>", game.getDifficulty()));
		textPanel.add(lblDialogue);
		lblDialogue.setForeground(SystemColor.desktop);
		lblDialogue.setHorizontalAlignment(SwingConstants.LEFT);
		
		
	if(game.getDifficulty().equals("easy")) {
		
			/* BobbleSaur */ 
			
			JLabel lblBobblesaurImage = new JLabel("");
			lblBobblesaurImage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
				}
			});
			lblBobblesaurImage.setBackground(SystemColor.inactiveCaption);
			lblBobblesaurImage.setIcon(new ImageIcon(ChoosePikimonScreen.class.getResource("/images/sprites/bulbasaur.png")));
			lblBobblesaurImage.setBounds(26, -31, 112, 112);
			contentPane.add(lblBobblesaurImage);
			
			JLabel lblBobblesaur = new JLabel("Bobblesaur");
			lblBobblesaur.setHorizontalAlignment(SwingConstants.CENTER);
			lblBobblesaur.setBounds(26, 92, 117, 27);
			contentPane.add(lblBobblesaur);
			
			JButton btnBobblesaurSelect = new JButton("Select");
			btnBobblesaurSelect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnBobblesaurSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					game.teamSetUp(game, 0, pikimonTeam);
					dispose();
					BeforeMenuScreen beforeMenuScreen = new BeforeMenuScreen(game, pikimonTeam);
					beforeMenuScreen.setVisible(true);
				}
			});
			btnBobblesaurSelect.setBackground(SystemColor.control);
			btnBobblesaurSelect.setBounds(49, 116, 70, 25);
			contentPane.add(btnBobblesaurSelect);

			/* Chormander */
			
			JLabel lblChormanderImage = new JLabel("");
			lblChormanderImage.setIcon(new ImageIcon(ChoosePikimonScreen.class.getResource("/images/sprites/charmander.png")));
			lblChormanderImage.setBounds(129, -31, 112, 112);
			contentPane.add(lblChormanderImage);
			
			JLabel lblChormander = new JLabel("Chormander");
			lblChormander.setHorizontalAlignment(SwingConstants.CENTER);
			lblChormander.setBounds(129, 92, 117, 27);
			contentPane.add(lblChormander);
			
			JButton btnChormanderSelect = new JButton("Select");
			btnChormanderSelect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnChormanderSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					game.teamSetUp(game, 1, pikimonTeam);
					dispose();
					BeforeMenuScreen beforeMenuScreen = new BeforeMenuScreen(game, pikimonTeam);
					beforeMenuScreen.setVisible(true);
				}
			});
			btnChormanderSelect.setBackground(SystemColor.control);
			btnChormanderSelect.setBounds(158, 116, 70, 25);
			contentPane.add(btnChormanderSelect);
			
			/* Pikacho */
			
			JLabel lblPikachoImage = new JLabel("");
			lblPikachoImage.setIcon(new ImageIcon(ChoosePikimonScreen.class.getResource("/images/sprites/pikachu.png")));
			lblPikachoImage.setBounds(223, -31, 120, 112);
			contentPane.add(lblPikachoImage);
			
			JLabel lblPikacho = new JLabel("Pikacho");
			lblPikacho.setHorizontalAlignment(SwingConstants.CENTER);
			lblPikacho.setBounds(233, 92, 117, 27);
			contentPane.add(lblPikacho);
			
			JButton btnPikachoSelect = new JButton("Select");
			btnPikachoSelect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPikachoSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					game.teamSetUp(game, 2, pikimonTeam);
					dispose();
					BeforeMenuScreen beforeMenuScreen = new BeforeMenuScreen(game, pikimonTeam);
					beforeMenuScreen.setVisible(true);
				}
			});
			btnPikachoSelect.setBackground(SystemColor.control);
			btnPikachoSelect.setBounds(256, 116, 70, 25);
			contentPane.add(btnPikachoSelect);
			
			/* Squortle */
			
			JLabel lblSquortleImage = new JLabel("");
			lblSquortleImage.setIcon(new ImageIcon(ChoosePikimonScreen.class.getResource("/images/sprites/squirtle.png")));
			lblSquortleImage.setBounds(326, -31, 120, 112);
			contentPane.add(lblSquortleImage);
			
			JLabel lblSquortle = new JLabel("Squortle");
			lblSquortle.setHorizontalAlignment(SwingConstants.CENTER);
			lblSquortle.setBounds(336, 92, 117, 27);
			contentPane.add(lblSquortle);
			
			JButton btnSquortleSelect = new JButton("Select");
			btnSquortleSelect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnSquortleSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					game.teamSetUp(game, 3, pikimonTeam);
					dispose();
					BeforeMenuScreen beforeMenuScreen = new BeforeMenuScreen(game, pikimonTeam);
					beforeMenuScreen.setVisible(true);
				}
			});
			btnSquortleSelect.setBackground(SystemColor.control);
			btnSquortleSelect.setBounds(360, 116, 70, 25);
			contentPane.add(btnSquortleSelect);
			
			}
	
	else {
		/* BobbleSaur */ 
		
		JLabel lblBobblesaurImage = new JLabel("");
		lblBobblesaurImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		lblBobblesaurImage.setBackground(SystemColor.inactiveCaption);
		lblBobblesaurImage.setIcon(new ImageIcon(ChoosePikimonScreen.class.getResource("/images/sprites/bulbasaur.png")));
		lblBobblesaurImage.setBounds(0, -31, 112, 112);
		contentPane.add(lblBobblesaurImage);
		
		JLabel lblBobblesaur = new JLabel("Bobblesaur");
		lblBobblesaur.setHorizontalAlignment(SwingConstants.CENTER);
		lblBobblesaur.setBounds(0, 92, 117, 27);
		contentPane.add(lblBobblesaur);
		
		JButton btnBobblesaurSelect = new JButton("Select");
		btnBobblesaurSelect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBobblesaurSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.teamSetUp(game, 0, pikimonTeam);
				dispose();
				BeforeMenuScreen beforeMenuScreen = new BeforeMenuScreen(game, pikimonTeam);
				beforeMenuScreen.setVisible(true);
			}
		});
		btnBobblesaurSelect.setBackground(SystemColor.control);
		btnBobblesaurSelect.setBounds(24, 118, 70, 25);
		contentPane.add(btnBobblesaurSelect);
	
		/* Chormander */
		
		JLabel lblChormanderImage = new JLabel("");
		lblChormanderImage.setIcon(new ImageIcon(ChoosePikimonScreen.class.getResource("/images/sprites/charmander.png")));
		lblChormanderImage.setBounds(93, -29, 112, 112);
		contentPane.add(lblChormanderImage);
		
		JLabel lblChormander = new JLabel("Chormander");
		lblChormander.setHorizontalAlignment(SwingConstants.CENTER);
		lblChormander.setBounds(93, 94, 117, 27);
		contentPane.add(lblChormander);
		
		JButton btnChormanderSelect = new JButton("Select");
		btnChormanderSelect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnChormanderSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.teamSetUp(game, 1, pikimonTeam);
				dispose();
				BeforeMenuScreen beforeMenuScreen = new BeforeMenuScreen(game, pikimonTeam);
				beforeMenuScreen.setVisible(true);
			}
		});
		btnChormanderSelect.setBackground(SystemColor.control);
		btnChormanderSelect.setBounds(122, 118, 70, 25);
		contentPane.add(btnChormanderSelect);
		
		/* Pikacho */
		
		JLabel lblPikachoImage = new JLabel("");
		lblPikachoImage.setIcon(new ImageIcon(ChoosePikimonScreen.class.getResource("/images/sprites/pikachu.png")));
		lblPikachoImage.setBounds(187, -29, 120, 112);
		contentPane.add(lblPikachoImage);
		
		JLabel lblPikacho = new JLabel("Pikacho");
		lblPikacho.setHorizontalAlignment(SwingConstants.CENTER);
		lblPikacho.setBounds(197, 94, 117, 27);
		contentPane.add(lblPikacho);
		
		JButton btnPikachoSelect = new JButton("Select");
		btnPikachoSelect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPikachoSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.teamSetUp(game, 2, pikimonTeam);
				dispose();
				BeforeMenuScreen beforeMenuScreen = new BeforeMenuScreen(game, pikimonTeam);
				beforeMenuScreen.setVisible(true);
			}
		});
		btnPikachoSelect.setBackground(SystemColor.control);
		btnPikachoSelect.setBounds(220, 118, 70, 25);
		contentPane.add(btnPikachoSelect);
		
		/* Squortle */
		
		JLabel lblSquortleImage = new JLabel("");
		lblSquortleImage.setIcon(new ImageIcon(ChoosePikimonScreen.class.getResource("/images/sprites/squirtle.png")));
		lblSquortleImage.setBounds(290, -31, 120, 112);
		contentPane.add(lblSquortleImage);
		
		JLabel lblSquortle = new JLabel("Squortle");
		lblSquortle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSquortle.setBounds(293, 92, 117, 27);
		contentPane.add(lblSquortle);
		
		JButton btnSquortleSelect = new JButton("Select");
		btnSquortleSelect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSquortleSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.teamSetUp(game, 3, pikimonTeam);
				dispose();
				BeforeMenuScreen beforeMenuScreen = new BeforeMenuScreen(game, pikimonTeam);
				beforeMenuScreen.setVisible(true);
			}
		});
		btnSquortleSelect.setBackground(SystemColor.control);
		btnSquortleSelect.setBounds(320, 118, 70, 25);
		contentPane.add(btnSquortleSelect);
		
		/* Ash Ketchum */
		
		JLabel lblAsh = new JLabel("Ash Ketchum");
		lblAsh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsh.setBounds(388, 92, 117, 27);
		contentPane.add(lblAsh);
		
		JButton btnAshSelect = new JButton("Select");
		btnAshSelect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAshSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.teamSetUp(game, 4, pikimonTeam);
				dispose();
				BeforeMenuScreen beforeMenuScreen = new BeforeMenuScreen(game, pikimonTeam);
				beforeMenuScreen.setVisible(true);
			}
		});
		btnAshSelect.setBackground(SystemColor.menu);
		btnAshSelect.setBounds(409, 118, 70, 25);
		contentPane.add(btnAshSelect);
		
		JLabel lblAshImage = new JLabel("");
		lblAshImage.setIcon(new ImageIcon(ChoosePikimonScreen.class.getResource("/images/sprites/magikarp.png")));
		lblAshImage.setBounds(385, -31, 120, 112);
		contentPane.add(lblAshImage);
	}
	
	
	
	
	JLabel background = new JLabel("");
	background.setIcon(new ImageIcon(ChoosePikimonScreen.class.getResource("/images/Backgrounds/battlebgIndoorA.png")));
	background.setBounds(0, 0, 512, 288);
	contentPane.add(background);
	


	}
}
