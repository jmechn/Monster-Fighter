package other;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomNumGen {
	Random rand = new Random();
	private ArrayList<Integer> uniqueList = new ArrayList<Integer>();
	
	public RandomNumGen(){
		
	}

	public int numberGenerator(int min, int max){

		return rand.nextInt(min, max+1);
	}
	
	public void uniqueRandomList(int max) {
        for (int i=0; i<max; i++) {
        	uniqueList.add(i);
        } 
        Collections.shuffle(uniqueList);
	}
	
	public ArrayList<Integer> getUniqueList() {
		return this.uniqueList;
	}
}
