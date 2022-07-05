//Amit Barash 
import java.util.*;
public class TicTacToe
{
	public static Scanner reader = new Scanner(System.in);
	static String board = "         ";
	final static int LEFT_UP = 0;
	final static int MIDDLE_UP = 1;
	final static int RIGHT_UP = 2;
	final static int LEFT_MIDDLE = 3;
	final static int MIDDLE_MIDDLE = 4;
	final static int RIGHT_MIDDLE = 5;
	final static int LEFT_DOWN = 6;
	final static int MIDDLE_DOWN = 7;
	final static int RIGHT_DOWN = 8;
	/**
	 * this function is an auxiliary function to the function checkTie.
	 * this function checks if the cell is empty.
	 * @param index this is the cell number that the function have to check.
	 * @return it returns true or false. true if the cell is full and false if the cell is empty.
	 */
	public static boolean checkFull(int index)
	{
		if(board.charAt(index) != ' ') //if the character at the index place is space. 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * the function uses the function checkWin to make sure that it is a tie.
	 * the function uses the auxiliary function checkFull to make sure that the board is full.
	 * the function checks if is there a tie on the board by checking if the board is full and there isn't win.
	 * @return it returns true or false. true if there is a tie and false if there isn't tie. 
	 */
	public static boolean checkTie()
	{
		if(checkFull(LEFT_UP) && checkFull(MIDDLE_UP) && checkFull(RIGHT_UP) && checkFull(LEFT_MIDDLE) && checkFull(MIDDLE_MIDDLE) && checkFull(RIGHT_MIDDLE) && checkFull(LEFT_DOWN) && checkFull(MIDDLE_DOWN) && checkFull(RIGHT_DOWN))
		//the if checks if all of the cells are empty and if all board is full.
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * the function checking if there is a win between three cells.
	 * the function gets 3 cells and returns true if there is a win and false if there isn't win.
	 * @param cell1 the first cell that the function checks.
	 * @param cell2 the second cell that the function checks.
	 * @param cell3 the third cell that the function checks.
	 * @return the function returns true or false.
	 */
	public static boolean checkThree(char cell1 , char cell2 , char cell3)
	{
		if((cell1 == cell2 && cell2 == cell3) && cell1 != ' ')
		//the if checks if the cells are equal and also checks that they are a sign and not spaces.
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * the function checks if is there a win on the board.
	 * the function use the function checkThree to check every three cells.
	 * the function returns if there is a win by true or false. win is true, no win is false.
	 * @return the function returns if there is a win by true or false.
	 */
	public static boolean checkWin()
	{
		boolean isUp = checkThree(board.charAt(LEFT_UP) , board.charAt(MIDDLE_UP) , board.charAt(RIGHT_UP)); //gets the three upper cells. 
		boolean isMiddle = checkThree(board.charAt(LEFT_MIDDLE) , board.charAt(MIDDLE_MIDDLE) , board.charAt(RIGHT_MIDDLE)); //gets the three middle cells.
		boolean isDown = checkThree(board.charAt(LEFT_DOWN) , board.charAt(MIDDLE_DOWN) , board.charAt(RIGHT_DOWN)); //gets the three bottom cells.
		boolean isRightCol = checkThree(board.charAt(RIGHT_UP) , board.charAt(RIGHT_MIDDLE) , board.charAt(RIGHT_DOWN)); //gets the three right column cells.
		boolean isMiddleCol = checkThree(board.charAt(MIDDLE_UP) , board.charAt(MIDDLE_MIDDLE) , board.charAt(MIDDLE_DOWN)); //gets the three middle column cells.
		boolean isLeftCol = checkThree(board.charAt(LEFT_UP) , board.charAt(LEFT_MIDDLE) , board.charAt(LEFT_DOWN)); //gets the three left column cells.
		boolean isDiagonal1 = checkThree(board.charAt(LEFT_UP) , board.charAt(MIDDLE_MIDDLE) , board.charAt(RIGHT_DOWN)); //get the three first oblique cells.
		boolean isDiagonal2 = checkThree(board.charAt(RIGHT_UP) , board.charAt(MIDDLE_MIDDLE) , board.charAt(LEFT_DOWN)); // gets the three second oblique cells.
		if(isUp || isMiddle || isDown || isRightCol || isMiddleCol || isLeftCol || isDiagonal1 || isDiagonal2)
		//checks if there is a win between every three cells.
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * the function prints the board as a shape.
	 * the function use the global variable "board".
	 */
	public static void printBoard()
	{
		final String INTERMEDIATE_ROW = "+-+-+-+"; //this is a recurring line, then it is final.
		System.out.println(INTERMEDIATE_ROW);
		System.out.println("|" + board.charAt(LEFT_UP) + "|" + board.charAt(MIDDLE_UP) + "|" + board.charAt(RIGHT_UP) + "|");
		System.out.println(INTERMEDIATE_ROW);
		System.out.println("|" + board.charAt(LEFT_MIDDLE) + "|" + board.charAt(MIDDLE_MIDDLE) + "|" + board.charAt(RIGHT_MIDDLE) + "|");
		System.out.println(INTERMEDIATE_ROW);
		System.out.println("|" + board.charAt(LEFT_DOWN) + "|" + board.charAt(MIDDLE_DOWN) + "|" + board.charAt(RIGHT_DOWN) + "|");
		System.out.println(INTERMEDIATE_ROW);
	}
	/**
	 * this function is an auxiliary function to the function "updateBoard".
	 * this function is updating the place in the global variable "board".
	 * the function gets the sign to replace and the place to replace and returns true or false.
	 * @param player this is the sign that the function place in the board.
	 * @param index this is the place that the function needs to update.
	 * @return the function returns true if the place to update is empty and false if the place is not empty.
	 */
	public static boolean updatePlace(char player , int index)
	{
		if(board.charAt(index) == ' ') //checks if the cell is empty.
		{
			String part1 = board.substring(0 , index);
			String part2 = board.substring(index + 1);
			board = part1 + player + part2;
			return true;
		}
		else
		{
			System.out.println("this cell already taken, try again.");
			return false;
		}	
	}
	/**
	 * this function updates the board by using "updatePlace".
	 * the function use the global variable "board".
	 * the function gets the place in the board to replace and the sign to replace.
	 * the function returns true if the place to update is empty and it update it, or false if the place isn't empty.
	 * @param player. the sign that the function needs to replace.
	 * @param place. the place that the function needs to replace.
	 * @return. the function returns true or false.
	 */
	public static boolean updateBoard(char player , int place)
	{
		boolean placeUpdate = false;
		place--;
		placeUpdate = updatePlace(player , place); //this is the auxiliary function, then I use it here.
		return placeUpdate;
	}
	/**
	 * this function print to the console the rules of the game.
	 */
	public static void printInstructions()
	{
		System.out.println("welcome to tic tac toe text game");
		System.out.println("in this game you insert the cell number by using integer numbers between 1 - 9");
		System.out.println("this is the cell numbers");
		System.out.println("+-+-+-+\n|1|2|3|\n+-+-+-+\n|4|5|6|\n+-+-+-+\n|7|8|9|\n+-+-+-+"); //prints the board with the cell numbers to make sure that the players will understand.
		System.out.println("each player will play in his turn and insert the cell to sign");
		System.out.println("the game will over only when there will be 3 cells with the same sign in sequence");
		System.out.println("or if the board is full and there is no winner.");
		System.out.println("enjoy the game!");
	}
	/**
	 * this function decide if the number is a cell on the board or not.
	 * @param place. this is the number.
	 * @return. the function returns true if the number is exist in the board and false if it is not exist on the board.
	 */
	public static boolean vaildPlace(int place)
	{
		if(place >=1 && place <=9) //if the number is between 1 and 9.
		{
			return true;
		}
		else
		{
			System.out.println("invaild input, try again!");
			return false;
		}
	}
	public static void main(String[] args)
	{
		printInstructions();
		char player = 0;
		for(int i = 0 ; checkWin() == false && checkTie() == false ; i++)
		{
			if(i % 2 == 0) //If the remainder of a number division two equals zero.
			{
				player = 'X';
			}
			else
			{
				player = 'O';
			}
			System.out.println("it's " + player + " turn now, insert the cell number.");
			int cellNum = reader.nextInt();
			while(vaildPlace(cellNum) == false || updateBoard(player , cellNum) == false)
			//if the number is not a cell number or if it is already taken.
			{
				cellNum = reader.nextInt();
			}
			printBoard();
			checkWin();
			checkTie();
		}
		if(checkWin() == true) //if there is a win on the board.
		{
			System.out.println("player " + player + " has won the game!");
		}
		else if(checkTie() == true && checkWin() == false)
		//if there is a tie on the board and there is no win.
		{
			System.out.println("it is a tie, no one won the game...");
		}
		reader.close();
	}
}