package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.ChooseName;
import game.Game;
import junit.framework.Assert;

class ChooseNameTest {
	Game game= new Game();
//Testing chooseName to see if name input meets the qualifications
	@BeforeEach
	public void init() {
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void ChooseNameConstructorTest() {
		ChooseName test= new ChooseName("Sarah");
		
		Assert.assertEquals("Constructor Error", "Sarah", test.getNames());
			
	}
	
	@SuppressWarnings("deprecation")
	public void nameSelectionTest() {
		//Testing to see if method sets false to strings that are less than 3
		ChooseName t1= new ChooseName("J");
		//Testing to see if names longer than 15 can't be selected
		ChooseName t2= new ChooseName("qwertyuiopasdfghjklzxcvbnm");
		//Testing invalid names
		ChooseName t3= new ChooseName("$");
		//Testing if it returns choose if the string meets the qualifications
		ChooseName t4= new ChooseName("Elijah");
		
		Assert.assertFalse("Passed-Test", t1.nameSelection(game));
		Assert.assertFalse("Passed-Test", t2.nameSelection(game));
		Assert.assertFalse("Passed-test", t3.nameSelection(game));
		Assert.assertTrue("Passed-Test", t4.nameSelection(game));
		
		
		
	}
	


}
