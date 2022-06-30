package enemy;

/**
 * 
 * This class implements an "Enemy" Pikimon Class.
 * 
 * @author Jaymee Chen
 *
 */

import characters.Pikimon;

public class Wailmore extends Pikimon {
	public Wailmore(int level) {
		super(level, DEFAULT_EXPERIENCE, "Wailmore", DEFAULT_MAXHP, DEFAULT_MAXHP, 20, 25
				, DEFAULT_HEALAMOUNT, "Water", "Common", DEFAULT_STATUS
				, DEFAULT_HAPPINESS, "/images/sprites/enemy/wailmer.png");	
	}
}
