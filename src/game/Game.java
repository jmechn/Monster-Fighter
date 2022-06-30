package game;

import java.util.ArrayList;


import boss.Detto;
import characters.*;
import enemy.*;
import other.RandomNumGen;
/**
 * 
 * Game environment for application
 * 
 * @author Jaymee Chen
 *
 */

public class Game {

	private  ArrayList<Pikimon> pikimonOptions = new ArrayList<Pikimon>();
	private  ArrayList<Pikimon> playerTeam = new ArrayList<Pikimon>();
	private  ArrayList<Pikimon> enemyTeam = new ArrayList<Pikimon>();
	private  ArrayList<Pikimon> bossTeam = new ArrayList<Pikimon>();

	
	private String finalName;
	private int finalDays;
	private String finalDifficulty;
	private int dayCounter = 0;
	private int coins = 150;
	private int gainedCoins = 0;
	private int bagels = 0;
	private int difficultyMult;
	private int maxStamina = 3;
	private int eventEnemyLevel = 0;
	RandomNumGen rand = new RandomNumGen();
	
	/**
	 * 
	 * Sets the difficulty multiplier for randomly generated Pikimon and stat changers
	 * 
	 */
	public void setUpGame() {
		
		if (finalDifficulty.equals("easy")) {
			difficultyMult = 2;
		}
		else {
			difficultyMult = 3;
		}
	}
	
	/**
	 * 
	 * Constructs Pikimon options and adds the chosen pikimon to the team
	 * 
	 * @param game
	 * @param chosen pikimonIndex
	 * @param pikimonTeam
	 */
	public void teamSetUp(Game game, int pikimonIndex, PikimonTeam pikimonTeam) {
		setUpGame();
		constructPikimon(finalDifficulty);
		playerTeam.add(pikimonOptions.get(pikimonIndex));
		pikimonTeam.setPikimonTeam(game);

	}
	
	/**
	 * 
	 * Constructor for the player's start options
	 * 
	 * @param finalDifficulty
	 */
	public void constructPikimon(String finalDifficulty) {
		constructEnemy(finalDifficulty);
		Pikacho pikacho = new Pikacho(Pikimon.getDefaultLevel());
		Bobblesaur bobblesaur = new Bobblesaur(Pikimon.getDefaultLevel());
		Squortle squortle = new Squortle(Pikimon.getDefaultLevel());
		Chormander chormander = new Chormander(Pikimon.getDefaultLevel());
		Ash ash = new Ash(Pikimon.getDefaultLevel());	
		
		pikimonOptions.add(bobblesaur);
		pikimonOptions.add(chormander);
		pikimonOptions.add(pikacho);
		pikimonOptions.add(squortle);
		pikimonOptions.add(ash);

	}
	
	/**
	 * 
	 * Constructor for the enemy pikimon
	 * 
	 * @param finalDifficulty
	 */
	public void constructEnemy(String finalDifficulty) {
		int level = 1;
		if (finalDifficulty.equals("hard")){
			level = 2;
		}
		
		Wailmore wailmore = new Wailmore(level);
		Darnitan darnitan = new Darnitan(level);
		Elekidding elekidding = new Elekidding(level);
		Stinkfisk stinkfisk = new Stinkfisk(level);
		Sus sus = new Sus(level);
		Detto detto = new Detto(level);
		
		enemyTeam.add(wailmore);
		enemyTeam.add(darnitan);
		enemyTeam.add(elekidding);
		enemyTeam.add(stinkfisk);
		enemyTeam.add(sus);
		bossTeam.add(detto);
		
		for (int i = 0; i < enemyTeam.size(); i++) {
			enemyTeam.get(i).updateStats(enemyTeam.get(i).getLevel());
		}
	}
	
	/**
	 * 
	 * Getter function for difficulty
	 * 
	 * @return Difficulty chosen
	 */
	public String getDifficulty() {
		return finalDifficulty;
	}
	
	
	/**
	 * 
	 * Getter function for name
	 * 
	 * @return name chosen
	 */
	
	public String getName() {
		return finalName;
	}

	/**
	 * 
	 * Getter function for player team
	 * 
	 * @return player team
	 */

	public ArrayList<Pikimon> getPlayerTeam() {
		return playerTeam;
	}
	
	/**
	 * 
	 * Getter function for enemy team
	 * 
	 * @return enemy team 
	 */
	
	public ArrayList<Pikimon> getEnemyTeam() {
		return enemyTeam;
	}
	
	
	/**
	 * 
	 * Getter function for boss team
	 * 
	 * @return boss team 
	 */
	
	public ArrayList<Pikimon> getBossTeam() {
		return bossTeam;
	}
	
	
	/**
	 * 
	 * Getter function for starter options
	 * 
	 * @return starter options 
	 */
	
	public ArrayList<Pikimon> getPikimonOptions() {	
		return pikimonOptions;
	}

	
	/**
	 * 
	 * Setter function for player team
	 * 
	 * @param player team
	 */
	
	public void setPlayerTeam(ArrayList<Pikimon> playerTeam) {
		this.playerTeam = playerTeam;
	}
	
	
	/**
	 * 
	 * getter function for current day
	 * 
	 * @return current day
	 */

	public int getDay() {
		return dayCounter;
	}
	
	/**
	 * 
	 * getter function for chosen days
	 * 
	 * @return chosen days
	 */
	
	public int getMaxDays() {
		return finalDays;
	}
	
	/**
	 * 
	 * getter function for number of coins
	 * 
	 * @return number of coins
	 */
	
	
	public int getCoins() {
		return coins;
	}
	
	
	/**
	 * 
	 * setter function for number of coins
	 * 
	 * @param number of coins to subtract
	 */
	
	public void setCoins(int i) {
		this.coins = this.coins - i;
		
	}
	
	/**
	 * 
	 * setter function for bagels (points)
	 * 
	 * @param number of bagels to add
	 */
	
	public void setBagels(int bagels) {
		this.bagels += bagels;
	}
	
	/**
	 * 
	 * Getter function for bagels (points)
	 * 
	 * @return number of bagels player has
	 */
	public int getBagels() {
		return this.bagels;
	}
	
	
	/**
	 * 
	 * Getter function for difficulty multiplier
	 * 
	 * @return difficulty multiplier
	 */
	
	public int getDifficultyMult(){
		return this.difficultyMult;
	}
	
	/**
	 * 
	 * Getter function for how many coins player has gained 
	 * 
	 * @return gained coins
	 */
	
	public int getGainedCoins() {
		return this.gainedCoins;
	}
	/**
	 * 
	 * Setter function for how many coins player has gained
	 * 
	 * @param coins gained from battle
	 */
	public void setGainedCoins(int coins) {
		this.gainedCoins += coins;
	}
	
	/**
	 * 
	 * Setter function for name
	 * 
	 * @param name chosen
	 */
	public void setName(String name) {
		finalName = name;
	}
	
	/**
	 * 
	 * Setter function for chosen difficulty
	 * 
	 * @param chosen difficulty
	 */
	public void setDifficulty(String difficulty) {
		finalDifficulty = difficulty;
		
	}
	
	/**
	 * 
	 * Setter function for chosen days
	 * 
	 * @param chosen days
	 */
	
	public void setDays(int days) {
		finalDays = days;
		
	}
	
	/**
	 * 
	 * Sets background depending on the number of days
	 * 
	 * @return background image path
	 */
	public String setBackground() {
		if (getDay()>9){
			return "/images/Backgrounds/battlebgCaveDarker.png";
		}
		else if (getDay()>4){
			return "/images/Backgrounds/battlebgMountainNight.png";
		}
		else {
			return "/images/Backgrounds/battlebgFieldEve.png";
		}
	}
	

	/**
	 * 
	 * Getter function for player's stamina
	 * 
	 * @return max Stamina
	 */
	public int getMaxStamina() {
		return maxStamina;
	}
	
	/**
	 * 
	 * Setter function for player's stamina
	 * 
	 * @param max Stamina
	 */

	public void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}
	
	
	/**
	 * 
	 * Random event: level up for Pikimon
	 * 
	 * @return GUI Dialogue output
	 */
	public String eventLevel() {

		ArrayList <Pikimon> pikimonTeam = getPlayerTeam();
		int randInt;
		if (getDifficulty().equals("hard")){
			 
			
			for (int pikimonIndex = 0; pikimonIndex< pikimonTeam.size(); pikimonIndex++) {
				randInt = rand.numberGenerator(50, 101);
				pikimonTeam.get(pikimonIndex).setExperience(randInt);
				
				}
			}
		else {
			for (int pikimonIndex = 0; pikimonIndex< pikimonTeam.size(); pikimonIndex++) {
				randInt = rand.numberGenerator(50, 201);
				pikimonTeam.get(pikimonIndex).setExperience(randInt);
				}
			
			}
		return "Your pikimon studied overnight (Check your team for more info)";
		}
	
	/**
	 * 
	 * Random event: Stamina debuff
	 * 
	 * @return GUI Dialogue output
	 */

	public String eventStamina(){
		setMaxStamina(3);
		if (getDifficulty().equals("hard") || getDay() > 5) {
			String[] randomEvent = {"You tripped over a stick and hurt your leg!<br>Stamina reduced to 2", 
					"You ate too much last night.<br>Food coma ... Stamina reduced to 2", 
					"Yikes, you're feeling lazy. <br>Stamina reduced to 2",
					"You have to cram for SENG201!<br>Stamina reduced to 2"};
			int randInt = rand.numberGenerator(1, 10);
			
			if(randInt == 1){
				setMaxStamina(1);
				return "<html>A wild pikachu used thunderbolt on you<br>and you can barely move.<br>Stamina reduced to 1</html>";
			}
			else if(randInt>8){
				setMaxStamina(2);
				return randomEvent[rand.numberGenerator(1, (randomEvent.length-1))];		
			}
			else {
				return "Good morning. You slept well.";
			}
		}
		else {
			return "Good morning. You slept well.";
		}
	}
	
	/**
	 * 
	 * Random event: Enemy level booster
	 * 
	 * @return GUI Dialogue output
	 */
	
	public String eventEnemyLevel(){
		setEventEnemyLevel(0);
		int randInt = rand.numberGenerator(1,101);
		if (getDifficulty().equals("hard")) {
			
			if(randInt >= 5){
				setEventEnemyLevel(2);
				return "<html>Miguel's lab experiment went VERY wrong!<br>Enemies are now significantly harder...</html>";
			}
			else if (randInt >=90 && randInt>=50){
				setEventEnemyLevel(1);
				return "<html>Miguel's lab experiment went wrong!<br>Enemies are now harder...</html>";
			}
			else {
				
			}
		}
		else {
			if(randInt >= 90){
				setEventEnemyLevel(1);
				return "<html>Miguel's lab experiment went wrong!<br>Enemies are significantly harder...</html>";
			}
		}
		
		return "<html>Miguel's lab experiment was successful tonight!</html>";
	}
	
	
	/**
	 * 
	 * Function to go to next day
	 * Resets stamina
	 * Adds more stats to enemy pikimon
	 * 
	 * @param battle
	 * @param pikimonTeam
	 */
	public void newDay(Battle battle, PikimonTeam pikimonTeam) {
		this.dayCounter +=1;
		battle.setBattleCount(0);
		battle.setStats(this);
		if (getDay() > 1) {
			pikimonTeam.newDay();
		}
		
	}

	/**
	 * random dialogue greeter
	 * 
	 * @return dialogue
	 */
	public String randomGreeter() {
		String[] greetings = {"Howdy", "Yowza", "G'day", "Yo", "Hello", "Hi", "Oh it's you"};
			
		
		int randGreetIndex = rand.numberGenerator(0,greetings.length-1);
		return greetings[randGreetIndex];
	}

	
	/**
	 * 
	 * Getter function for enemy level booster
	 * 
	 * @return random event enemy level booster
	 */
	public int getEventEnemyLevel() {
		return this.eventEnemyLevel;
	}
	
	
	/**
	 * 
	 * Setter function for enemy level booster
	 * 
	 * @param random event enemy level booster
	 */
	public void setEventEnemyLevel(int level) {
		this.eventEnemyLevel = level;
	}


	}

