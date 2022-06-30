package boss;

import characters.Pikimon;

/**
 * This class implements a "Boss" Pikimon class.
 * 
 * @author Jaymee Chen
 *
 */
public class Detto extends Pikimon {
	/**
	 * 
	 * constructor for boss pikimon Detto
	 * 
	 * @param level
	 */
	public Detto(int level) {
		super(level, DEFAULT_EXPERIENCE, "Detto", 120, 120, 20, 25
				, DEFAULT_HEALAMOUNT, "Normal", "BOSS", DEFAULT_STATUS
				, DEFAULT_HAPPINESS, "/images/sprites/ditto.png");	
	}


}
