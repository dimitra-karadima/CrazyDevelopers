
/*Class that contains necessary functions for our database:
 * input of data , data presentation, delete and change of data
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
	private static ArrayList<ArrayListLine> lists[]; // array that contains array lists
	private static Scanner input = new Scanner(System.in); // new Scanner object

	/*
	 * Constructor of our class Sets length of our array of array lists
	 */
	public Functions(int num) {
		lists = new ArrayList[num];
		for (int i = 0; i < num; i++) {
			lists[i] = new ArrayList<>();
		}
	}

	/*
	 * Method that adds a new object(line) to a specific list
	 */
	public void addLine(ArrayListLine object, int num) {
		lists[num].add(object);
	}

	/*
	 * Method that allows user to add the new line to a table Asks for the number of
	 * table to add a new line and then asks for the Strings for every column After
	 * it creates a new line using the addLine(...) method
	 */
	public void addChoice(int[] arrayNumberColumns) {
		System.out.print("Enter number of table you wish to add a new object: ");
		int tableAdd = input.nextInt();
		String[] newObject = new String[arrayNumberColumns[tableAdd - 1]];
		for (int i = 0; i < arrayNumberColumns[tableAdd - 1]; i++) {
			System.out.print("Enter something for column " + (i + 1) + ": ");
			newObject[i] = input.next();
		}
		ArrayListLine xx = new ArrayListLine(newObject);
		addLine(xx, tableAdd - 1);
	}

	/*
	 * Method that deletes an object(line)
	 */
	public void delete(int rem, int num) {
		lists[num].remove(rem);
	}

	/*
	 * Method that deletes a specific line of a specific table Asks user to input
	 * number of table and number of line Uses method delete of class Functions to
	 * do so
	 */
	public void deleteChoice() {
		System.out.print("Select list to delete an item: ");
		int list = input.nextInt();
		System.out.print("Select number of item: ");
		int item = input.nextInt();
		delete(item - 1, list - 1);
	}

	/*
	 * Method that prints a specific object of a list
	 */
	public void print(int list, int num2) {
		lists[list].get(num2).printLine();
	}

	/*
	 * Method that prints all the lines and columns(all the objects ArrayListLine
	 * there are) of the existing tables Uses the method print of Functions to do so
	 */
	public void printChoice() {
		for (int i = 0; i < lists.length; i++) {
			System.out.println("\tTable " + (i + 1));
			for (int j = 0; j < lists[i].size(); j++) {
				print(i, j);
			}
			System.out.println();
		}
	}

	/*
	 * Method that changes an object of a specific line
	 */
	public void change(int list, int line, int column, String change) {
		lists[list].get(line).changeColumn(column, change);
	}

	/*
	 * Method that allows a user to change a specific column of a specific line of a
	 * specific table Ask user to input number of table, number of line and number
	 * of column This method uses the method change of class Functions to do so
	 */
	public void changeChoice() {
		System.out.print("Select table to change an item from : ");
		int table = input.nextInt();
		System.out.print("Select the line of item: ");
		int item = input.nextInt();
		System.out.print("Select the column of the item: ");
		int col = input.nextInt();
		System.out.print("Enter new value: ");
		String newValue = input.next();
		change(table - 1, item - 1, col - 1, newValue);
	}

	/*
	 * Method that prints the menu to the screen and returns the choice of the user
	 */
	public int choiceForFunctions() {
		System.out.println("Enter: 1 to add, 2 to show, 3 to delete, 4 to change data");
		int choice = input.nextInt();
		return choice;

	}

	/*
	 * Method to create an array with columns the number of columns of the specific
	 * position of the table by asking user to enter positive numbers for example if
	 * columnPerTable={3,5,1} means that table 1 has 3 columns , table 2 has 5
	 * columns, table 3 has 1 column returns this table
	 */
	public int[] menuColumns(int tables) {
		int[] columnPerTable = new int[tables];
		for (int i = 0; i < tables; i++) {
			System.out.print("Enter a positive amount of columns for table " + (i + 1) + ": ");
			columnPerTable[i] = input.nextInt();
		}
		return columnPerTable;
	}
}
