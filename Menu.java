
/*
 * Class that contains all the menus needed for the program 
 */
import java.util.*;
public class Menu {
	Exceptions e = new Exceptions(); //new Exceptions object called e
	private String names[][];
	private String namesT[];
	int columnPerTable[];
	Scanner input = new Scanner(System.in);

	/*
	 * Method that asks user to enter the number of tables for the database and
	 * return this integer
	 */
	public static int openingMenu() {
		Exceptions e = new Exceptions();
		e.display("Enter amount of tables: "); // tables check
		int tables = e.NotIntegerException();
		while (tables <= 0) {			//checks that amount of tables is bigger than 0 and not an integer
			e.display("Enter positive quantity: ");
			tables = e.NotIntegerException();
		}
		return tables;
	}

	/*
	 * Method that prints the menu to the screen and returns the choice of the user
	 */
	public int choiceForFunctions() {
		e.display("Enter: 1 to add, 2 to show, 3 to delete, 4 to change data, 5 to end programm and save it on a file");
		int choice = e.NotIntegerException();// InputMisMatchException is only checked here
		return choice;
	}

	/*
	 * Method to create an array with columns the number of columns of the specific
	 * position of the table by asking user to enter positive numbers for example if
	 * columnPerTable={3,5,1} means that table 1 has 3 columns , table 2 has 5
	 * columns, table 3 has 1 column returns this table
	 */
	public int[] menuColumns(int tables) {
		columnPerTable = new int[tables];
		for (int i = 0; i < tables; i++) {
			e.display("Enter a positive amount of columns for table " + (i + 1) + ": ");
			int amount=e.NotIntegerException();
			while (amount<1) {						//checks that amount is bigger than 0 and an integer
				e.display("Enter a positive amount of columns for table " + (i + 1) + ": ");
				amount = e.NotIntegerException();
			}
			columnPerTable[i]=amount;
		}
		addNames(columnPerTable);
		return columnPerTable;
	}

	/*
	 * Method to create an two-dimension array with lines the number of tables the
	 * user wants and columns the number of columns of the specific table. The user
	 * gives the names for each column of every table and the method inserts these names
	 * into the tho-dimension array names[][]
	 */
	public void addNames(int[] columnPerTable) {
		names = new String[columnPerTable.length][];
		for (int i = 0; i < columnPerTable.length; i++) {
			names[i] = new String[columnPerTable[i]];
			for (int j = 0; j < names[i].length; j++) {
				System.out.print("Enter name for the #" + (i + 1) + " table and #" + (j + 1) + " column:");
				names[i][j] = input.next();
			}
		}
	}

	/*
	 * Method to give user the opportunity to name every table of the DataBase
	 * The table names are saved in the one-dimension array namesT[]
	 */
	public void nameTables(int tables) {
		namesT = new String[tables];
		for (int i = 0; i < tables; i++) {
			System.out.println("Enter name for the #" + (i + 1) + " table:");
			namesT[i] = input.next();
		}
	}
	/*
	 * Simple get methods for names[][] and namesT[]
	 * Will be used by Main2 class
	 * Usefull for the addChoice() and printChoice()
	 */
	public String[][] getNames() {
		return names;
	}

	public String[] getNamesT() {
		return namesT;
	}
}