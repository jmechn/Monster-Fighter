package enemy;

/**
 * 
 * This class implements an "Enemy" Pikimon Class.
 * 
 * @author Jaymee Chen
 *
 */

import characters.Pikimon;

public class Sus extends Pikimon {
	public Sus(int level) {
		super(level, DEFAULT_EXPERIENCE, "Sus", DEFAULT_MAXHP, DEFAULT_MAXHP, 20, 25
				, DEFAULT_HEALAMOUNT, "Grass", "Common", DEFAULT_STATUS
				, DEFAULT_HAPPINESS, "/images/sprites/enemy/amoonguss.png");	
	}


}
