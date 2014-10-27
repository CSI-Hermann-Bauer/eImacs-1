import java.util.Scanner;

/**
 * 
 */

/**
 * @author Andrew
 *
 */
public class Test2 {
	Scanner userIn;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test2();
	}
	private Test2(){
		userIn = new Scanner(System.in);
		System.out.print("How many dice should we roll?");
		int timesToRoll = userIn.nextInt();
		System.out.print("How many sides in the "+timesToRoll+" die/dice?");
		int sides = userIn.nextInt();
		for(int i = 0; i < timesToRoll; i++) outputDie(sides,i);
	}
	private int rollDice(){
		return (int) (Math.random() * 10 % 6+1);
	}
	private int rollDice(int sides){
		if(sides <=0) rollDice();
		return (int) (Math.random() * sides +1);
	}
	private void outputDie(int sides,int diceNum){
		System.out.println(diceNum + " rolled a "+rollDice(sides)+"!");
	}
}
