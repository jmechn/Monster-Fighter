package enemy;


/**
 * 
 * This class implements an "Enemy" Pikimon Class.
 * 
 * @author Jaymee Chen
 *
 */

import characters.Pikimon;

public class Goblin extends Pikimon {
	public Goblin(int level) {
		super(level, DEFAULT_EXPERIENCE, "Goblin", DEFAULT_MAXHP, DEFAULT_MAXHP, 20, 25
				, DEFAULT_HEALAMOUNT, "Poison", "Common", DEFAULT_STATUS
				, DEFAULT_HAPPINESS, "/images/sprites/enemy/gulpin.png");	
	}


}
