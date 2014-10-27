import java.util.Random;
import java.util.Scanner;
/**Homework for next time:
 * Write TicTacToe for AI
 * @author Andrew
 *
 */
public class TicTacToe {
	Random randGen;
	Scanner userIn;
	char player;
	char board []= {'1','2','3',
					'4','5','6',
					'7','8','9'};
	public static void main(String[] args) {
		new TicTacToe();
	}
	//Class constructor
	private TicTacToe(){
		randGen = new Random(); 			//Initialize Random number generator
		userIn = new Scanner(System.in);	//Setup Scanner to read from user
		println("Welcome to Tic Tac Toe!");
		if(randGen.nextInt(2)==0) player = 'X';
		else player = 'O';
		while(!checkWins() && !checkFull()){
			switchPlayer();
			printBoard();
			while(promptPlayer());
		}
		printBoard();
		if(checkWins())println("Player "+player+" wins!");
		else println("Stalemate! Let's Play Again!");
	}
	//Make printing easier!
	private void print(String str){
		System.out.print(str);
	}
	private void println(String str){
		System.out.println(str);
	}
	private boolean promptPlayer(){
		print("What square would you like to occupy, "+player+"?");
		return !occupy(userIn.nextInt() - 1);
	}
	private boolean occupy(int square){
		if(square >=0 && square <= 8 && board[square] != 'X' && board[square] != 'O') board[square] = player;
		else return false;
		return true;
	}
	private void printBoard(){
		for(int i = 0; i < 9; i++){
			print(""+board[i]);
			if(i == 2 || i == 5 || i == 8)println("");
			else print("|");
		}
		println("");
	}
	private void switchPlayer(){
		if(player == 'X') player = 'O';
		else player = 'X';
	}
	private boolean checkWins(){
		return  (board[0]==board[1]&&board[1]==board[2])||
				(board[3]==board[4]&&board[4]==board[5])||
				(board[6]==board[7]&&board[7]==board[8])||
				(board[0]==board[4]&&board[4]==board[8])||
				(board[2]==board[4]&&board[4]==board[6])||
				(board[0]==board[3]&&board[3]==board[6])||
				(board[1]==board[4]&&board[4]==board[7])||
				(board[2]==board[5]&&board[5]==board[8]);
	}
	private boolean checkFull(){
		for(int i = 0; i < 9; i++){
			if(board[i] != 'X' && board[i] != 'O') return false;
		}
		return true;
	}
}
