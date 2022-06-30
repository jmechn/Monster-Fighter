package characters;

/**
 * This class implements a Pikimon and their associated attributes.
 * 
 * @author Jaymee Chen
 *
 */

public abstract class Pikimon{

	public static final int DEFAULT_LEVEL = 1;
	public static final int DEFAULT_EXPERIENCE = 0;
	public static final int DEFAULT_MAXHP = 100;
	public static final int DEFAULT_HEALAMOUNT = 20;
	public static final String DEFAULT_STATUS = "Normal";
	public static final int DEFAULT_HAPPINESS = 100;
	
	private String name;	
	private int hp;
	private int maxHp;
	private int attack;
	private int speed;
	private int healAmount;
	private int experience;
	private int level;
	private String type;
	private String rarity;
	private String status;
	private int happiness;
	private String imagePath;
	private int maxLevel = 10;


	public Pikimon() {
	}
	
	/**
	 * 
	 * Basic constructor for the Pikimon class
	 * 
	 * @param level
	 * @param experience
	 * @param name
	 * @param hp
	 * @param maxHp
	 * @param attack
	 * @param speed
	 * @param healAmount
	 * @param type
	 * @param rarity
	 * @param status
	 * @param happiness
	 * @param path
	 * 
	 */
	public Pikimon(int level, int experience, String name, int hp, int maxHp, int attack, int speed, int healAmount,  String type, String rarity, String status, int happiness, String path){
		this.experience = experience;
		this.level = level;
		this.name = name;
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.attack = attack;
		this.speed = speed;
		this.healAmount = healAmount;
		this.type = type;
		this.rarity= rarity;
		this.status = status;
		this.happiness = happiness;
		this.imagePath = path;
	}
	
	/**
	 * Getting function for the default Pikimon level
	 * 
	 * @return default Pikimon Level
	 * 
	 */
	public static int getDefaultLevel() {
		return DEFAULT_LEVEL;
	}

	
	/**
	 * Getting function for the default Pikimon experience
	 * 
	 * @return default Pikimon experience
	 * 
	 */
	
	public static int getDefaultExperience() {
		return DEFAULT_EXPERIENCE;
	}
	
	/**
	 * Getting function for the default Pikimon health
	 * 
	 * @return default Pikimon health
	 * 
	 */

	public int getDefaultHp() {
		return DEFAULT_MAXHP;
	}

	/**
	 * Getting function for the default Pikimon maximum health
	 * 
	 * @return default Pikimon maximum health
	 * 
	 */
	
	public int getDefaultMaxhp() {
		return DEFAULT_MAXHP;
	}
	
	/**
	 * Getting function for the default Pikimon heal amount
	 * 
	 * @return default Pikimon heal amount
	 * 
	 */

	public int getDefaultHealamount() {
		return DEFAULT_HEALAMOUNT;
	}

	
	/**
	 * Getting function for the default Pikimon default status
	 * 
	 * @return default Pikimon default status
	 * 
	 */
	
	public String getDefaultStatus() {
		return DEFAULT_STATUS;
	}
	
	/**
	 * Getting function for the default Pikimon default happiness
	 * 
	 * @return default Pikimon default happiness
	 * 
	 */
	
	public int getDefaultHappiness() {
		return DEFAULT_HAPPINESS;
	}

	/**
	 * Getting function for the Pikimon name
	 * 
	 * @return Pikimon name
	 * 
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * Getting function for the Pikimon hp
	 * 
	 * @return Pikimon hp
	 * 
	 */
	
	public int getHp() {
		return hp;
	}
	
	
/**
 * Setting function for the Pikimon Hp
 * 
 * @param health integer
 * 
 */
	public void setHp(int health) {
		this.hp = health;
	}
	
	/**
	 * Getting function for the Pikimon max hp
	 * 
	 * @return Pikimon max hp
	 * 
	 */
	
	public int getMaxHp() {
		return maxHp;
	}
	
	/**
	 * Getting function for the Pikimon attack
	 * 
	 * @return Pikimon max attack
	 * 
	 */
	
	public int getAttack() {
		return attack;
	}
	
	
	/**
	 * Getting function for the Pikimon speed
	 * 
	 * @return Pikimon max speed
	 * 
	 */
	
	public int getSpeed() {
		return speed;
	}
	
	
	/**
	 * Getting function for the Pikimon heal amount
	 * 
	 * @return Pikimon heal amount
	 * 
	 */
	
	public int getHealAmount() {
		return healAmount;
	}
	
	
	/**
	 * Getting function for the Pikimon experience
	 * 
	 * @return Pikimon experience
	 * 
	 */
	public int getExperience() {
		return this.experience;
	}
	
	
	/**
	 * 
	 * Setting function for the Pikimon Experience. Calculates how many times it levels up.
	 * 
	 * @param experience
	 * @return the dialogue to ouput in the GUI
	 */
	public String setExperience(int experience) {
		int maxExp = 100;
		this.experience += experience;
		if (this.experience >= maxExp) {
			levelUp();
			this.experience = this.experience - maxExp;
			return (String.format("%s leveled up to %d", this.getName(), this.level));
		} 
		else {
			return  (String.format("%s has gained %d EXP", this.getName(), experience));
		}
	}
	
	/**
	 * Getting function for the Pikimon level
	 * 
	 * @return Pikimon level
	 * 
	 */
	
	public int getLevel() {
		return level;
	}
	
	/**
	 * Getting function for the Pikimon type
	 * 
	 * @return Pikimon type
	 * 
	 */
	
	public String getType() {
		return type;
	}
	
	/**
	 * Getting function for the Pikimon rarity
	 * 
	 * @return Pikimon rarity
	 * 
	 */
	
	public String getRarity() {
		return rarity;
	}
	
	/**
	 * Getting function for the Pikimon status
	 * 
	 * @return Pikimon status
	 * 
	 */
	
	public String getStatus() {
		return status;
		
	}
	
	/**
	 * Getting function for the Pikimon happiness
	 * 
	 * @return Pikimon happiness
	 * 
	 */
	
	public int getHappiness() {
		return happiness;
		
	}
	
	
	/**
	 * Getting function for the Pikimon image path
	 * 
	 * @return Pikimon image path
	 * 
	 */
	
	public String getImagePath() {
		return imagePath;
	}
	
	/**
	 * 
	 * Getting function for the Pikimon maximum level
	 * 
	 * @return Pikimon maximum level that it can level up to.
	 */
	public int getMaxLevel() {
		return maxLevel;
	}

	/**
	 * Setting function for the Pikimon maximum level
	 * 
	 * @param maxLevel
	 */
	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	
	/**
	 * 
	 * Setting function to change the stats of a Pikimon with the given parameters
	 * 
	 * @param attack
	 * @param speed
	 * @param hp
	 */
	
	public void changeStats(int attack, int speed, int hp) {
		this.attack = attack;
		this.speed = speed;
		this.maxHp = hp;
		this.hp = hp;
	}
	
	/**
	 * 
	 * Function to level up and change the stats of the Pikimon
	 * 
	 */
	public void levelUp() {
		int lvlUpAmount = this.experience % 2;
		if (this.level<=this.maxLevel) {
			this.level += 1;
			if (lvlUpAmount % 2 == 0) {
				this.attack = this.attack + (lvlUpAmount * 10);
				this.speed = this.speed + (lvlUpAmount * 10);
				this.hp = this.hp + (lvlUpAmount * 10);
				this.maxHp = this.maxHp + (lvlUpAmount * 10);
			}
			else {
				this.attack = this.attack + (lvlUpAmount * 5);
				this.speed = this.speed + (lvlUpAmount * 5);
				this.hp = this.hp + (lvlUpAmount * 5);
				this.maxHp = this.maxHp + (lvlUpAmount * 5);
			}
		}
	}
	
	/**
	 * 
	 * Function to update the stats after a new day
	 * 
	 * @param level of Pikimon
	 */
	public void updateStats(int level) {
		if (level % 2 == 0) {
			this.level = level;
			this.attack = this.attack + (level * 2);
			this.speed = this.speed + (level*10);
			this.hp = this.hp + (level*10);
			this.maxHp = this.maxHp + (level*10);
		}
		else if (level > 0){
			this.level = level;
			this.attack = this.attack + (level);
			this.speed = this.speed + (level * 5);
			this.hp = this.hp + (level * 5);
			this.maxHp = this.maxHp + (level * 5);
		}
		else {
			this.level = level;
		}
	}
	
	/**
	 * Function to heal the Pikimon
	 * 
	 * @param healAmount
	 * @return
	 */
	public boolean heal(int healAmount) {
		if (this.hp == this.maxHp) {
			return false;
		}
		else {
			if ((this.hp + healAmount)>=this.maxHp) {
				this.hp = this.maxHp;
			}
			else {
				this.hp = this.hp + healAmount;	
			}
			return true;
		}
	}
}



	
