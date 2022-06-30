package inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;


import java.util.Scanner;
import characters.*;
import game.Game;
import game.PikimonTeam;
import Shop.ItemsForSale;

public class MainInventory extends Pikimon {
	private int storageAvail = 10;
	public ArrayList<potions> item = new ArrayList<potions>();
	private Scanner scan = new Scanner(System.in);
	

	boolean goBack = true;

	public MainInventory(String difficulty) {
		if (difficulty.equals("easy")) {
			item.add(new potions("easy", "Panadol"));
			item.add(new potions("easy", "Cough Syrup"));

		}
	}
	public int getPotionIndex(String name) {
		int index=0;
		for (int i=0; i<item.size(); i++) {
			if (item.get(i).getPotionName()==name) {
				index=i;
				break;
			}
		}
		return index;
		
	}

	public void selectPotion(Game game, PikimonTeam pikimonTeam, int itemIndex) {
		System.out.println("You've chosen " + item.get(itemIndex-1 ).getPotionName() + " with hp of "
				+ item.get(itemIndex-1 ).gethp(item.get(itemIndex-1 ).getPotionName()));
		usePotion(game, pikimonTeam, item.get(itemIndex - 1));

	}
	
	
	

	public int potionCounter(String potionName) {
		int counter=0;
		for (int i=0; i<this.item.size(); i++) {
			if( item.get(i).getPotionName().equals(potionName)){
				counter++;
				}	
		}
		return counter;
	}

	public ArrayList<potions> getPotionList() {
		return this.item;
	}

	public void addPotion(potions s) {
		if (this.item.size() < storageAvail) {
			this.item.add(s);
		}
	}

	public void usePotion(Game game, PikimonTeam pikimonTeam, potions potion) {
		boolean usedPotion = true;
		System.out.println("Please select a Pikimon you would like to heal or 'back':");
			do {
				// pikimonTeam.printPikimon(game.getPlayerTeam(), game.getPlayerTeam().size());
				
				String inputString = scan.nextLine().toLowerCase();
				if (inputString.equals("back")) {
					usedPotion = false; 
					}
				else {
					try {
						
						int inputInt = Integer.valueOf(inputString);
						if (inputInt<item.size()) {
						
						int hp = potion.hp;
						game.getPlayerTeam().get(inputInt - 1).heal(hp);
						System.out.println(game.getPlayerTeam().get(inputInt - 1).getName() + " has gained " + hp + " hp \n");
						this.item.remove(potion);
						usedPotion = false; 
						}
						else {
							System.out.println("Please enter a number between 1 - " + (item.size()) + " or 'back'\n");
						}
					
					} 
					catch (InputMismatchException e) {
						System.out.println("Please enter a number between 1 - " + (item.size()) + " or 'back'\n");
					}
					catch (NumberFormatException e) {
						System.out.println("Please enter a number between 1 - " + (item.size()) + " or 'back'\n");
					}
				}
			} while(usedPotion);
		}
	// change depending on the item

	public void displayCurrentItems(Game game, PikimonTeam pikimonTeam) {
		do {
			
			if (item.size()==0) {
				System.out.println ("You have 0 items");
				goBack = false;
			}
			else {
				System.out.println("You currently have " + item.size() + " items in your inventory.");
		
				for (int i = 0; i < this.item.size(); i++) {
					System.out.println((i + 1) + ") " + item.get(i).getPotionName() + ":" + potionCounter(item.get(i).getPotionName()));
				}
		
				System.out.println("Enter the item number you would like to use or type 'back':" );
		
				String input = scan.nextLine().toLowerCase();
				if (input.equals("back")) {
					goBack = false;
				} else {
					try {
						int itemIndex = Integer.valueOf(input);
						if (itemIndex <= this.item.size()) {
							selectPotion(game, pikimonTeam, itemIndex);
						} else {
							System.out.println("Please enter a number between 1 - " + (item.size()) + " or 'back'\n");
						}
					} catch (InputMismatchException e) {
						System.out.println("Please enter a number between 1 - " + (item.size()) + " or 'back'\n");
					} catch (NumberFormatException e) {
						System.out.println("Please enter a number between 1 - " + (item.size()) + " or 'back'\n");
					}
				}
			}
			}while(goBack);
	
		}
	}
