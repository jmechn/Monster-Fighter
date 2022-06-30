package enemy;

/**
 * 
 * This class implements an "Enemy" Pikimon Class.
 * 
 * @author Jaymee Chen
 *
 */

import characters.Pikimon;

public class Stinkfisk extends Pikimon {
	public Stinkfisk(int level) {
		super(level, DEFAULT_EXPERIENCE, "Stinkfisk", DEFAULT_MAXHP, DEFAULT_MAXHP, 20, 25
				, DEFAULT_HEALAMOUNT, "Ground", "Common", DEFAULT_STATUS
				, DEFAULT_HAPPINESS, "/images/sprites/enemy/stunfisk.png");	
	}
}
