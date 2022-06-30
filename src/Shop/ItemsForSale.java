package Shop;

import java.util.*;

import buyCharacters.*;
import characters.Pikimon;
import game.Game;
import game.PikimonTeam;
import inventory.*;
import other.RandomNumGen;

public class ItemsForSale {
	private boolean listStuff = true;
	private RandomNumGen random = new RandomNumGen();
	private Scanner scan = new Scanner(System.in);
	public int prices = 10;

	private static ArrayList<String> potionList = new ArrayList<String> (Arrays.asList("Bandaid", "Panadol", "Cough Syrup" ));
	private ArrayList<Pikimon> buyCommonPikimon = new ArrayList<Pikimon>(Arrays.asList(new FireChicken(Pikimon.getDefaultLevel()),
					new Jigglypoff(Pikimon.getDefaultLevel()),

					new Sudowood(Pikimon.getDefaultLevel()), new Venasaur(Pikimon.getDefaultLevel())));
	
	private ArrayList<Pikimon> buyRarePikimon= new ArrayList<Pikimon>
			(Arrays.asList(new Jigglypoff(Pikimon.getDefaultLevel()), new Articuna (Pikimon.getDefaultLevel())));
	
		
	
	public ItemsForSale() {

	}

	public void listItems(Game game, MainInventory inventory, PikimonTeam pikimon) {
		
		System.out.println("Welcome to Pikimon Shop! \nCoins: $" + game.getCoins()
		+ "\nPlease enter a number between 1 - 2  or 'back':\n");
		System.out.println("Shop: \n1) Potions\n2) Pikimons");
		do {
			

			String input = scan.nextLine().toLowerCase();
			if (input.equals("back")) {
				listStuff = false;
			} else {
				try {
					int itemIndex = Integer.valueOf(input);
					if (itemIndex == 1) {
						displayPotions(game, inventory);
						listStuff=false;
					} else if (itemIndex == 2) {
						displayPikimon(game,pikimon);
						listStuff=false;
					} else {
						System.out.println("Please enter a number between 1 - 2 or 'back'\n");

					}
				} catch (InputMismatchException e) {
					System.out.println("Please enter a number between 1 - 2 or 'back'\n");
				} catch (NumberFormatException e) {
					System.out.println("Please enter a number between 1 - 2 or 'back'\n");
				}

			}
		} while (listStuff);

	}
	public ArrayList<String> randomPotion(ArrayList<String>potionList){	
		ArrayList<String>randomPotion=new ArrayList<String>();
		int num;
		for (int i=0; i<3;i++) {
		num=random.numberGenerator(0, this.potionList.size()-1);
		randomPotion.add(this.potionList.get(num));
		}
		
		return randomPotion;
	}
	

	public void displayPotions(Game game, MainInventory inventory) {
		ArrayList<String>randomPotion= new ArrayList<String>();
		randomPotion=(randomPotion(this.potionList));
		boolean potionExit = true;
		System.out.println("Select the potion you want to buy or type 'back':");

		do {

			for (int i = 0; i < randomPotion.size(); i++) {
				System.out.println((i + 1) + ")" + randomPotion.get(i) + ": $" + (this.prices = this.prices + 10));
			}
			String input = scan.nextLine().toLowerCase();
			if (input.equals("back")) {
			potionExit = false;
			
			}
			if (game.getCoins()<=0 || game.getCoins()<prices ) {
				System.out.println("Sorry, but you have no money");
				potionExit=false;
			}
			else {
			try {
				int inputInt = Integer.valueOf(input);
				if (inputInt <= randomPotion.size()) {
					inventory.getPotionList().add(new potions(randomPotion.get(inputInt-1)));
					potionExit = false;
				
					System.out.println(randomPotion.get(inputInt-1)+ " is added into your inventory");
					randomPotion.remove(inputInt-1);
					game.setCoins(10 * inputInt);
				} else {
					System.out.println("Please enter a number between 1 - " + randomPotion.size() + " or 'back'\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number between 1 - " + randomPotion.size() + " or 'back'\n");
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number between 1 - " + randomPotion.size() + " or 'back'\n");
			}
		} }while (potionExit);

	}

	public void displayPikimon(Game game,PikimonTeam pikimonTeam) {
		boolean exitPikimon = true;
		ArrayList<Pikimon>randomPikimon= new ArrayList<Pikimon>();
		randomPikimon=(randomPikimon(game));
		System.out.println("Select a Pikimon you want to buy or type 'back': \n$100\n");
		do {
			// pikimonTeam.printPikimon(randomPikimon, randomPikimon.size());

			String input = scan.nextLine().toLowerCase();

			if (input.equals("back")) {
				exitPikimon = false;
			} 
			if (game.getCoins()<=0 || game.getCoins()<100 ) {
				System.out.println("Sorry, but you have no money");
				exitPikimon=false;
			}
			else {
				try {
					int inputInt = Integer.valueOf(input);
					if (inputInt<=randomPikimon.size()) {
						System.out.println(randomPikimon.get(inputInt-1).getName() + " is added to your inventory");
						game.getPlayerTeam().add(randomPikimon.get(inputInt-1));
						randomPikimon.remove(inputInt-1);
						game.setCoins(100);
						exitPikimon=false;
						
					}
					else {
						System.out.println("Please enter a number between 1 - " + (randomPikimon.size()) + " or 'back'\n");
					}
				}
				catch (InputMismatchException e) {
					System.out.println("Please enter a number between 1 - " + (randomPikimon.size()) + " or 'back'\n");
				}
				catch (NumberFormatException e) {
					System.out.println("Please enter a number between 1 - " + (randomPikimon.size()) + " or 'back'\n");
				}
			}


		} while (exitPikimon);

	}

	

	
	public ArrayList<Pikimon> randomPikimon(Game game){
		int num;
		ArrayList<Pikimon> randomPikimons=new ArrayList<Pikimon>();
		if (game.getDay()<5) {
			for (int i=0; i<3; i++) {
				num =random.numberGenerator(0,this.buyCommonPikimon.size()-1);
				randomPikimons.add(this.buyCommonPikimon.get(num));
				
			}
		}
			else if (game.getDay()>=5) {
				for (int i=0; i<4; i++) {
					this.buyCommonPikimon.addAll(buyRarePikimon);
					num=random.numberGenerator(0,buyCommonPikimon.size()-1);
					randomPikimons.add(this.buyCommonPikimon.get(num));
					
				}
			}
		return randomPikimons;
			
		}	
		
		
	}
