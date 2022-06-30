package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import characters.Pikacho;
import characters.Pikimon;

class PikimonTest {

	@Test
	public void PikimonConstructorTest() {
		Pikacho test= new Pikacho(1);
	
		//abstract constructor cannot be tested but can test the internal methods from inherited classes
	assertEquals(test.getDefaultLevel(),1);
	assertEquals(test.getName(), "Pikacho");
	assertEquals(test.getRarity(), "Common");
	assertEquals(test.getAttack(),20);
	assertEquals(test.getSpeed(),25);
	assertEquals(test.DEFAULT_HAPPINESS,100);
	assertEquals(test.DEFAULT_HEALAMOUNT,20);
	assertEquals(test.DEFAULT_LEVEL,1);
	assertEquals(test.getType(),"Electricity");
	assertEquals(test.DEFAULT_MAXHP,100);
	
	}

}
