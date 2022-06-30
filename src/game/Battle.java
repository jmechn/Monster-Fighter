package game;

import java.util.ArrayList;
import characters.Pikimon;
import other.RandomNumGen;


/**
 * 
 * Functionality of the battle aspect of the application
 * 
 * @author Jaymee Chen
 *
 *
 */
public class Battle {

	private int minAttack = 10;
	private int maxAttack = 15;
	private int minHp = 20;
	private int maxHp = 40;
	private int minSpeed = 5;
	private int maxSpeed = 20;
	private int minLevel = 1;
	private int maxLevel = 2;
	private int enemyIndex;
	private int playerIndex = 0;
	private boolean playerTurn;
	private String winDialogue;
	private int battleCount = 0;
	private int minimumStatGap = 1;
	private ArrayList<Pikimon> randomEnemyList = new ArrayList<Pikimon>();

	RandomNumGen randomNumGen = new RandomNumGen();
	
	/**
	 * 
	 * Generates a random array of enemy Pikikmon with random stats
	 * 
	 * @param game enironment
	 * @param enemy Pikimon array list
	 */
	public void generateEnemyPikimon(Game game, ArrayList<Pikimon> enemyPikimon) {

		/** Reset Enemy  list **/
		randomEnemyList.clear();
		
		/** Calls method uniqueRandomList(int max) to generate a unique list of pikimon indexes **/
		randomNumGen.uniqueRandomList(enemyPikimon.size());
		
		for (int i = 0; i<3; i++) {
			/* Initialising randomly generated stats for each Enemy Pikimon */
			int randPikimonIndex = randomNumGen.getUniqueList().get(i);
			randomEnemyList.add(enemyPikimon.get(randPikimonIndex));
			int randAttack = randomNumGen.numberGenerator(minAttack, maxAttack + minimumStatGap);
			int randLevel = randomNumGen.numberGenerator(minLevel + game.getEventEnemyLevel(), maxLevel + game.getEventEnemyLevel()+ minimumStatGap);
			int randSpeed = randomNumGen.numberGenerator(minSpeed, maxSpeed + minimumStatGap);
			int randHp = randomNumGen.numberGenerator(minHp, maxHp + minimumStatGap);
			randomEnemyList.get(i).changeStats(randAttack, randSpeed, randHp);
			/* Enemy levels up as days go on */
			if (game.getDay()>1) {
				randomEnemyList.get(i).updateStats(randLevel);
				}
			
			}
		
		}
	
	/**
	 * 
	 * Generates a random boss
	 * 
	 * @param game
	 * @param bossPikimon array list
	 */
	public void generateBossPikimon(Game game, ArrayList<Pikimon> bossPikimon) {
		
		/* Initialising randomly generated stats for Boss Pikimon */
		int randPikimonIndex = randomNumGen.numberGenerator(0, bossPikimon.size()-1);
		int randAttack = randomNumGen.numberGenerator(minAttack, maxAttack + minimumStatGap);
		int randSpeed = randomNumGen.numberGenerator(minSpeed, maxSpeed + minimumStatGap);
		int randLevel = randomNumGen.numberGenerator(minLevel+game.getEventEnemyLevel(), maxLevel + game.getEventEnemyLevel());
		int randHp = randomNumGen.numberGenerator(minHp, maxHp + minimumStatGap);
		
		/* Resets the previous enemy list */
		randomEnemyList.clear();
		randomEnemyList.add(bossPikimon.get(randPikimonIndex));
		
		bossPikimon.get(randPikimonIndex).changeStats(randAttack, randSpeed, randHp);
		randomEnemyList.get(randPikimonIndex).updateStats(randLevel);
		
		/* Enemy levels up as days go on */
		
		randomEnemyList.get(randPikimonIndex).updateStats(randomNumGen.numberGenerator(minLevel,maxLevel + game.getEventEnemyLevel()));
		
		setEnemyIndex(randPikimonIndex);
	}

	/**
	 * 
	 * Attack functionality, deals damage to the defender
	 * 
	 * @param game
	 * @param player's Pikimon
	 * @param enemy
	 * @param pikimon Team array
	 * @param isPlayerTurn boolean
	 * @return
	 */
	public String battleDamage(Game game, Pikimon player, Pikimon enemy, PikimonTeam pikimonTeam, boolean isPlayerTurn) {
		
		
		if (isPlayerTurn) {
			enemy.setHp(enemy.getHp() - player.getAttack());
			setTurn(false);
			return checkDead(game, enemy, enemy, pikimonTeam, isPlayerTurn);
		}
		else {
			player.setHp(player.getHp() - enemy.getAttack());
			setTurn( true);
			return checkDead(game, player, player, pikimonTeam, isPlayerTurn);
		}
		
		

	}
	
	/**
	 * 
	 * Functionality to check if pikimon receiving the damage is dead
	 * 
	 * @param game
	 * @param attacker
	 * @param defender
	 * @param pikimonTeam
	 * @param isPlayerTurn boolean
	 * @return
	 */
	public String checkDead(Game game, Pikimon attacker, Pikimon defender, PikimonTeam pikimonTeam, boolean isPlayerTurn) {	
		if(defender.getHp()<= 0) {
			if (isPlayerTurn == false) {
				pikimonTeam.removePikimon();
				return String.format("%s fainted and was removed from your party.", defender.getName());

			}
			else {
				win(game, defender, game.getDay(), game.getDifficultyMult());
				return String.format("%s fainted.", defender.getName());
			}
		}
		else{
			return String.format("%s did %d damage to %s%n" 
					,attacker.getName(),attacker.getAttack(), defender.getName());
			}
		}
	
	/**
	 * 
	 * Adds the scores and coins gained from the battle
	 * 
	 * @param game
	 * @param enemy Pikimon
	 * @param current day
	 * @param difficulty multiplier 
	 */
	public void win(Game game, Pikimon enemyPikimon, int day, int difficultyMult) {
		int minimumBagels = 5;
		int randMult = randomNumGen.numberGenerator(1, 3);
		int money = enemyPikimon.getLevel() * day * randMult * difficultyMult;
		int bagels = minimumBagels * randMult * difficultyMult;
		
		battleCount += 1;
		game.setCoins(-(money));
		game.setGainedCoins(money);
		game.setBagels(bagels);
		
		winDialogue = String.format("<html>%s dropped %d coins."
				+ "<br>You gained %d Bagels.</html>", 
				enemyPikimon.getName(), money,
				bagels);
		
	}
	
	/**
	 * 
	 * Getter function for random enemy list
	 * 
	 * @return random enemy list
	 */
	public ArrayList<Pikimon> getRandomEnemyList() {
		return randomEnemyList;
	}
	
	/**
	 * 
	 * Calculates the turn based off speed
	 * 
	 * @param enemy Speed
	 * @param player Speed
	 */
	public void calcTurn(int enemySpeed, int playerSpeed) {
		if (playerSpeed>enemySpeed){
			playerTurn = true;
		}
		else {
			playerTurn = false;
		}
				
	}
	
	/**
	 * Getter function for the playerTurn
	 * 
	 * @return is true if player turn
	 * 
	 */
	public boolean getTurn() {
		return playerTurn;
	}
	
	/**
	 * 
	 * Setter function for player turn
	 * 
	 * @param turn
	 */
	public void setTurn(boolean turn) {
		this.playerTurn = turn;
	}
	
	/**
	 * 
	 * Set the base stats for the randomly generated pikimon
	 * 
	 * @param game
	 */
	public void setStats(Game game) {
		int bossMultMinHp = 20;
		int bossMultMaxHp = 20;
		int bossMultAttack = 10;
		
		/* HARD MODE: Days will affect the stats of enemy */
		if (game.getDifficulty().equals("hard") && game.getDay() == 1){
			minAttack += 5;
			maxAttack += 10;
			minHp += 10;
			maxHp += 20;
			minSpeed += 5 ;
			maxSpeed += 10;
			minLevel +=1;
		}
		else if(game.getDifficulty().equals("hard")) {
			/* BOSS BATTLE: Attack will increase in hard mode */
			if (game.getDay()% 5 == 0 && game.getDay() != 0) {
				minAttack += bossMultAttack;
				maxLevel +=2;
			}

			if (game.getDay() % 3 == 2 && minLevel<10){	
				maxLevel +=1;
			}
		}
		else {
			if (game.getDay() > 1) {
				minAttack += 1;
				maxAttack += 2;
				minHp += 5;
				maxHp += game.getDay();
				minSpeed += 5 ;
				maxSpeed += 10;
				if (game.getDay() % 5 == 0) {
					maxLevel +=1;
					}
				}
			}
			
		/* BOSS BATTLE: add extra boss stats */
		if (game.getDay() % 5 == 0 && game.getDay() != 0) {
			minAttack += game.getDay();
			maxAttack += game.getDay();
			minHp += 2 + bossMultMinHp;
			maxHp += game.getDay()+ bossMultMaxHp;
			minSpeed += 5 ;
			maxSpeed += 15;

		}	
	}

	/**
	 * 
	 * Getter function for enemy index
	 * 
	 * @return enemyIndex
	 */
	public int getEnemyIndex() {
		return enemyIndex;
	}

	/**
	 * 
	 * Getter function for player Index
	 * 
	 * @return playerIndex
	 */
	public int getPlayerIndex() {
		return playerIndex;
	}
	
	
	/**
	 * 
	 * setter function for player Index
	 * 
	 * @param playerIndex
	 * 
	 */
	
	public void setPlayerIndex(int playerIndex) {
		this.playerIndex = playerIndex;
	}
	
	/**
	 * 
	 * setter function for enemy index
	 * 
	 * @param enemyIndex
	 * 
	 */
	
	public void setEnemyIndex(int enemyIndex) {
		this.enemyIndex = enemyIndex;
	}


	
	/**
	 * 
	 * Getter function for winning dialogue for the GUI
	 * 
	 * @return winDialogue
	 * 
	 */
	
	public String getWinDialogue() {
		return winDialogue;
	}

	
	/**
	 * 
	 * Setter function for winning dialogue for the GUI
	 * 
	 * @param winDialogue
	 * 
	 */
	
	public void setWinDialogue(String winDialogue) {
		this.winDialogue = winDialogue;
	}
	
	/**
	 * 
	 * Getter function for battleCount to make sure battleCount is less than stamina
	 * 
	 * @return battleCount
	 * 
	 */

	public int getBattleCount() {
		return battleCount;
	}

	
	
	/**
	 * 
	 * Setter function for battleCount
	 * 
	 * @param battleCount
	 * 
	 */

	public void setBattleCount(int battleCount) {
		this.battleCount = battleCount;
	}
		
}
