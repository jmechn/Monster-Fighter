package game;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import characters.Pikimon;

/**
 * This class implements a Pikimon object that stores all the Pikimon.
 * 
 * @author Jaymee Chen
 * 
 *
 */

public class PikimonTeam {
	
	int pikimonNum;
	public ArrayList<Pikimon> team;

	public PikimonTeam() {
		
	}
	
	
	public void setPikimonTeam(Game game) {
		 team = game.getPlayerTeam();
	}
	
	/**
	 * Add pikimon to team
	 * 
	 * @param pikimon to add
	 * @return size of player team
	 */
	public int addPikimon(Pikimon pikimon) {
		team.add(pikimon);
		return this.team.size();
		
	}
	
	/**
	 * 
	 * get player team size
	 * 
	 * @return team size
	 */
	public int getSize() {
		return team.size();
	}
	
	/**
	 * Checks if the HP of any Pikimon is 0. Removes them from the team if their HP is 0.
	 * 
	 * @return The number of Pikimon remaining
	 * 
	 */

	public int removePikimon() {
		team.removeIf(pikimon -> pikimon.getHp() <= 0);
		return team.size();
	}
	
	
	/**
	 *  Function to remove pikimon from team if dead.
	 *  Checks if status is normal, if not deal damage
	 * 
	 * @return The size of the team after fainted Pikimon have been removed
	 * 
	 */
	public int newDay() {
		removePikimon();
		for (Pikimon pikimon : team) {
			if (pikimon.getStatus()!= "Normal") {
				pikimon.setHp(pikimon.getHp()-20);
			}
		}
		System.out.println();
		return team.size();
	}
}
