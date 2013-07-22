package bonus;
<<<<<<< HEAD
=======

>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6
public class Bonus {
	private int [] bonus;

	public int takeBonus(){
		return bonus[0];
	}
	
	public static Bonus noBonus(){
		return new Bonus(new int[]{0, 0});
	}
	
	public static Bonus strikeBonus(){
<<<<<<< HEAD
	
=======
>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6
		return new Bonus(new int[]{1, 1});
	}
	
	public static Bonus spareBonus(){
		return new Bonus(new int[]{1, 0});
	}
	
	public Bonus remainingBonus(){
		return new Bonus(new int[]{bonus[1], 0});
	};
	
	public Bonus add(Bonus addBonus){
		return new Bonus(new int []{bonus[0] + addBonus.bonus[0], 
				                    bonus[1] + addBonus.bonus[1]});
	}
	
	public Bonus(int [] bonus){
		this.bonus = bonus.clone();
	}
}