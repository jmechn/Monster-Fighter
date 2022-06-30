package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.ChooseName;
import game.Game;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

/**
 * Choose name screen
 *
 * @author Jaymee Chen
 *
 */
public class ChooseNameScreen extends JFrame {
	
	private JPanel contentPane;
	private JTextField nameInput;
	private JLabel background;
	
	/**
	 * Create the frame to choose name
	 * 
	 * @param game 
	 */
	public ChooseNameScreen(Game game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setResizable(false);
		contentPane.setLayout(null);
		
		/* Next Window */
		
		JButton nameConfirm = new JButton("Enter");
		nameConfirm.setBackground(SystemColor.control);
		nameConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nameConfirm.setBounds(283, 118, 72, 25);
		nameConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseName name = new ChooseName(nameInput.getText());
				if(name.nameSelection(game)) {
					dispose();
					ChooseDaysScreen chooseDaysScreen = new ChooseDaysScreen(game);
					chooseDaysScreen.setVisible(true);
					
					
				};
			}
		});
		
		JLabel miguel = new JLabel("");
		miguel.setIcon(new ImageIcon(ChooseNameScreen.class.getResource("/images/sprites/miguel120.png")));
		miguel.setBounds(10, 21, 120, 134);
		contentPane.add(miguel);
		contentPane.add(nameConfirm);
		/* Opaque text panel */
		
		JPanel textPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) textPanel.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		textPanel.setBounds(0, 154, 505, 127);
		textPanel.setBackground(new Color(255, 255, 255, 123));
		contentPane.add(textPanel);
		
		JLabel lblDialogue = new JLabel("So trainer,  what is your name?");
		textPanel.add(lblDialogue);
		lblDialogue.setForeground(SystemColor.desktop);
		lblDialogue.setHorizontalAlignment(SwingConstants.LEFT);
		
		nameInput = new JTextField();
		nameInput.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		nameInput.setBounds(183, 74, 285, 33);
		contentPane.add(nameInput);
		nameInput.setColumns(10);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(ChooseNameScreen.class.getResource("/images/Backgrounds/battlebgIndoorA.png")));
		background.setBackground(Color.BLACK);
		background.setBounds(0, 0, 512, 288);
		contentPane.add(background);
	}

}
