package enemy;


/**
 * 
 * This class implements an "Enemy" Pikimon Class.
 * 
 * @author Jaymee Chen
 *
 */


import characters.Pikimon;

public class Elekidding extends Pikimon {
	public Elekidding(int level) {
		super(level, DEFAULT_EXPERIENCE, "Elekidding", DEFAULT_MAXHP, DEFAULT_MAXHP, 20, 25
				, DEFAULT_HEALAMOUNT, "Electricity", "Common", DEFAULT_STATUS
				, DEFAULT_HAPPINESS, "/images/sprites/enemy/elekid.png");	
	}


}
