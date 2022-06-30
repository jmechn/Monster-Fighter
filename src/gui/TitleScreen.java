package gui;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;

import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import game.Game;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class TitleScreen {

	private JFrame frame;
	  
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {				
					TitleScreen window = new TitleScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TitleScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 515, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		Game game = new Game();

		frame.getContentPane().setLayout(null);
		
		JLabel lblQuit = new JLabel("");
		lblQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblQuit.setIcon(new ImageIcon(TitleScreen.class.getResource("/images/GUI/NarikGUIQuit.png")));
		lblQuit.setOpaque(true);
		lblQuit.setBackground(SystemColor.inactiveCaption);
		lblQuit.setBounds(191, 177, 92, 32);
		frame.getContentPane().add(lblQuit);
		
		
		JLabel lblNewLabel = new JLabel("Pikimon Night and Day");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Pokemon Pixel Font", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setBounds(0, 22, 496, 88);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblStart = new JLabel("");
		lblStart.setOpaque(true);
		lblStart.setBackground(SystemColor.inactiveCaption);

		lblStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				BeforeNameScreen beforeNameScreen = new BeforeNameScreen(game);
				beforeNameScreen.setVisible(true);
			}
		});
		lblStart.setIcon(new ImageIcon(TitleScreen.class.getResource("/images/GUI/NarikGUIStart.png")));
		lblStart.setBounds(191, 121, 92, 32);
		frame.getContentPane().add(lblStart);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setIcon(new ImageIcon(TitleScreen.class.getResource("/images/Backgrounds/battlebgCaveDarker.png")));
		lblNewLabel_1.setBounds(0, 0, 516, 288);
		frame.getContentPane().add(lblNewLabel_1);
		
		
	//	
	}
}
