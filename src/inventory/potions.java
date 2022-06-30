package inventory;

public class potions {
   public int hp;
   public int points;
   public String difficulty;
   public  String potionName;
   public String Status;
	
	
   public potions(String potionName){
      this.potionName=potionName;
   }

   public potions( String difficulty,String potionName) {
      this.difficulty= difficulty;
      this.potionName= potionName;
   }
	

   
   public int gethp(String potionName) {
	   if (potionName.equals("Panadol")) {
		   this.hp=50;
	   }
	   else if (potionName.equals("Cough Syrup")) {
		   this.hp=75;
	   }
	   else if  (potionName.equals("Bandaid")) {
	  
	   this.hp=25;
   }
	   return hp;
   }
	

	
   public String getPotionName() {
      return potionName;
   }
   public String getDifficulty() {
	   return this.difficulty;
   }
   
}
