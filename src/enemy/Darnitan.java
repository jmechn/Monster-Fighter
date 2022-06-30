package enemy;

/**
 * 
 * This class implements an "Enemy" Pikimon Class.
 * 
 * @author Jaymee Chen
 *
 */

import characters.Pikimon;

public class Darnitan extends Pikimon {
	public Darnitan(int level) {
		super(level, DEFAULT_EXPERIENCE, "Darnitan", DEFAULT_MAXHP, DEFAULT_MAXHP, 20, 25
				, DEFAULT_HEALAMOUNT, "Fire", "Common", DEFAULT_STATUS
				, DEFAULT_HAPPINESS, "/images/sprites/enemy/darmanitan.png");	
	}


}
