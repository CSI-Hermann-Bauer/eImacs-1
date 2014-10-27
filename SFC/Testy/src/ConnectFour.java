import java.util.Scanner;
import java.util.Random;
/**
 * 
 */

/**
 * @author Andrew
 *
 */
public class ConnectFour {
	private static final char player1 = 'X';
	private static final char player2 = 'Y';
	private char player;
	private char board [] [] = new char [7][6]; //7 Wide, 6 long;
	private Scanner userIn;
	private Random rand;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ConnectFour();
	}
	public ConnectFour(){
		userIn = new Scanner(System.in);
		rand = new Random();
		if(rand.nextInt()%2 == 0){
			player = player1;
		}else{
			player = player2;
		}
		//Populate board
		fillBoard();
		printBoard();
		//Randomly choose player
		while((!(playerWins(player1)||playerWins(player2))||!boardFull())){
			/* Output board
			 * Switch Player
			 * Get input from player
			 * Check if legal
			 * Insert into board
			 */
			printBoard(); //Print Board
			switchPlayer(); //Switch Player
			int playerChoice = askPlayer(); //Save player choice
			while(!legal(playerChoice)){//check legal
				playerChoice = askPlayer();
			}
			makeMove(playerChoice); //insert
			
		}
		if(playerWins(player2)){
			//Player 2 Wins!
		} else if(playerWins(player1)){
			//Player 1 Wins!
		} else if(boardFull()){
			//Stalemate!
		} else {
			//Should _NOT_ reach here!
			System.out.println("Should not reach here, something is definitely wrong!");
		}
	}
	public boolean boardFull(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j]==' ') return false;
			}
		}
		return true;
	}
	public boolean checkRowWin(char player){
		//TODO: Write
		return false;
	}
	public boolean checkColWin(char player){
		//TODO: Write
		return false;
	}
	public boolean checkDiagWin1(char player){
		//TODO: Write
		return false;
	}
	public boolean checkDiagWin2(char player){
		//TODO: Write
		return false;
	}
	public boolean playerWins(char player){
		return (checkRowWin(player) || checkColWin(player) || checkDiagWin1(player) || checkDiagWin2(player));
	}
	public void fillBoard()	{
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = ' ';
			}
		}
	}
	public void printBoard(){
		for(int i = 0; i < board.length; i++){
			System.out.print(i+1+"\t");
		}
		System.out.println();
		for(int i = 0; i < board[0].length; i++){
			for(int j = 0; j < board.length; j++){
				System.out.print(board[j][i]+"\t");
			}
			System.out.println();
		}
		for(int i = 0; i < board[board.length-1].length*8; i++){
			System.out.print('-');
		}
		System.out.println();
	}
	public boolean legal(int move){
		//TODO Fix!
		/*
		 * Move should be at least 0, but no greater than number of columns (7);
		 * The "0" element in each column must be " "
		 */
		move --;
		if(move < 0){
			System.out.println("Move too low!");
			return false;
		} else if(move > board.length-1){
			System.out.println("Move too high!");
			return false;
		} else if(board[move][0] != ' '){
			System.out.println("Column full!");
			return false;
		} else {
			return true;
		}
	}
	public void makeMove(int move){
		int i = board.length-2;
		move --;
		while((i >=0) && (board[move][i] != ' ')){
			i--;
		}
		System.out.println(move+","+i);
		board[move][i] = player;
	}
	public void switchPlayer(){
		if(player == player1){
			player = player2;
		}else{
			player = player1;
		}
	}
	public int askPlayer(){
		System.out.print("Player " + player+", which colum would you like to move to?>");
		return userIn.nextInt();
	}
}
