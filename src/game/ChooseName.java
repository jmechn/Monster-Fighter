package game;

import javax.swing.JOptionPane;

/**
 * Class to check for invalid names
 * 
 * @author Jaymee Chen and Angela Yu
 * 
 */

public class ChooseName {

	private String names;
	
	/**
	 * 
	 * Setter function for name
	 * 
	 * @param name input
	 * 
	 */
	public ChooseName(String names) {
		this.names = names;
	}
	
	/**
	 * 
	 * Getter function for name
	 * 
	 * @return name
	 */
	public String getNames() {
		return this.names;
	}
	
	/**
	 * Error checking for name
	 * 
	 * @param game
	 * @return true when valid name is input
	 */
	public boolean nameSelection(Game game) {
		
		if (names.length()<3 || names.length()>15 || !names.matches("[a-zA-Z]+")){
			JOptionPane.showMessageDialog(null, "Please enter a name with 3-15 alphabetical letters and no symbols or spaces.");	
		}	
		else {
			game.setName(names);
			return true;
		}
		
		return false;
	}
	

}
