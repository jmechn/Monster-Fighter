package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import characters.Pikacho;
import characters.Pikimon;
import game.Game;
import game.PikimonTeam;

class PikimonTeamTest {
	public Game game= new Game();;
	
	@Test
	public void setPikimonTest() {
		PikimonTeam one= new PikimonTeam();
		one.setPikimonTeam(game);
		assertEquals(game.getPlayerTeam(),one.team);
	}
	
	
	@Test
	public void addPikimonTest() {
		PikimonTeam one= new PikimonTeam();
		Pikacho pikacho = new Pikacho(Pikimon.getDefaultLevel());
		//Failed test because team is null, need to initiliased team as empty array first
		//otherwise I'll have to call another method
		assertEquals(2,one.addPikimon(pikacho) );
		one.setPikimonTeam(game);
		assertEquals(one.team.size(), one.addPikimon(pikacho));
		// returning the size of team after adding pikimon
		//Cannot directly access team due to team being private and no game constructor
	}
	@Test
	public void getSizeTest() {
		PikimonTeam one= new PikimonTeam();
		one.setPikimonTeam(game);
		assertEquals(one.team.size(),one.getSize() );
	}
	
	@Test 
	public void removePikimonTest() {
		PikimonTeam one= new PikimonTeam();
		one.setPikimonTeam(game);
		one.team.get(1).setHp(0);
		assertEquals(one.removePikimon(), one.team.size());
		//failed test
	}
	
	@Test
	public void newDayTest() {
		PikimonTeam one= new PikimonTeam();
		one.setPikimonTeam(game);
		Pikimon test= one.team.get(1);
		one.newDay();
		assertEquals(test.getHp(), 100);
		
	}
	
	
	
	

}
