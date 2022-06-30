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
import javax.swing.JSpinner;
import javax.swing.JSlider;

public class ChooseDaysScreen extends JFrame {
	
	private JPanel contentPane;
	private JLabel background;
	/**
	 * Create the frame to choose days
	 * 
	 * @param game 
	 */
	public ChooseDaysScreen(Game game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setResizable(false);
		contentPane.setLayout(null);
		
		JSlider dayInput = new JSlider();
		dayInput.setMajorTickSpacing(1);
		dayInput.setPaintLabels(true);
		dayInput.setPaintTicks(true);
		dayInput.setMinimum(5);
		dayInput.setMaximum(15);
		dayInput.setBounds(194, 68, 256, 38);
		dayInput.setBackground(new Color(255, 255, 255));
		
		contentPane.add(dayInput);
		
		JButton dayConfirm = new JButton("Enter");
		dayConfirm.setBackground(SystemColor.control);
		dayConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dayConfirm.setBounds(283, 118, 72, 25);
		dayConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					game.setDays(dayInput.getValue());
					dispose();
					ChooseDifficultyScreen chooseDifficultyScreen = new ChooseDifficultyScreen(game);
					chooseDifficultyScreen.setVisible(true);
					
					
				};
		});
		
		JLabel miguel = new JLabel("");
		miguel.setIcon(new ImageIcon(ChooseDaysScreen.class.getResource("/images/sprites/miguel120.png")));
		miguel.setBounds(10, 21, 120, 134);
		contentPane.add(miguel);
		contentPane.add(dayConfirm);
		/* Opaque text panel */
		
		JPanel textPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) textPanel.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		textPanel.setBounds(0, 154, 505, 127);
		textPanel.setBackground(new Color(255, 255, 255, 123));
		contentPane.add(textPanel);
		
		JLabel lblDialogue = new JLabel(String.format("<html>Right! %s... What a great name... <br>How many days would you like to play?</html>", game.getName()));
		textPanel.add(lblDialogue);
		lblDialogue.setForeground(SystemColor.desktop);
		lblDialogue.setHorizontalAlignment(SwingConstants.LEFT);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(ChooseDaysScreen.class.getResource("/images/Backgrounds/battlebgIndoorA.png")));
		background.setBackground(Color.BLACK);
		background.setBounds(0, 0, 512, 288);
		contentPane.add(background);
	}
}
