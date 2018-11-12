
/*
 * Main method to run the program
 */
import java.util.*;

public class Main2 {
	private static Scanner input = new Scanner(System.in); // new Scanner object

	public static void main(String[] args) {
		int tables = openingMenu(); // User enters amount of tables for data base
		Functions data = new Functions(tables); // new Functions object called data
		int[] arrayNumberColumns = menuColumns(tables); // Creation of an array that contains the amount of columns for
														// every table
		for (;;) {
			menuForFunctions(); // print menu
			int choice = input.nextInt();
			switch (choice) { // Condition
			case (1): { // case of adding a new object
				System.out.print("Enter number of table you wish to add a new object: ");
				int tableAdd = input.nextInt();
				String[] newObject = new String[arrayNumberColumns[tableAdd - 1]];
				for (int i = 0; i < arrayNumberColumns[tableAdd - 1]; i++) {
					System.out.print("Enter something for column " + (i + 1) + ": ");
					newObject[i] = input.next();
				}
				ArrayListLine xx = new ArrayListLine(newObject);
				data.add(xx, tableAdd - 1);
				break;
			}
			case (2): { // case of printing data
				for (int i = 0; i < tables; i++) {
					System.out.println("\tTable " + (i + 1));
					for (int j = 0; j < data.lists[i].size(); j++) {
						data.print(i, j);
					}
					System.out.println();
				}
				break;
			}
			case (3): { // case of deleting data
				System.out.print("Select list to delete an item: ");
				int list = input.nextInt();
				System.out.print("Select number of item: ");
				int item = input.nextInt();
				data.delete(item - 1, list - 1);
				break;

			}
			case (4): { // case of changind data
				System.out.print("Select table to change an item from : ");
				int table = input.nextInt();
				System.out.print("Select the line of item: ");
				int item = input.nextInt();
				System.out.print("Select the column of the item: ");
				int col = input.nextInt();
				System.out.print("Enter new value: ");
				String newValue = input.next();
				data.change(table - 1, item - 1, col - 1, newValue);
				break;
			}
			default: {
				System.out.println("Invalid choice");
			}
			}

		}

	}

	/*
	 * Method that prints the menu to the screen
	 */
	public static void menuForFunctions() {
		System.out.println(" Enter: 1 to add, 2 to show, 3 to delete, 4 to change data");
	}

	public static int openingMenu() {
		System.out.print("Enter amount of tables: "); // tables check
		int tables = input.nextInt();
		while (tables <= 0) {
			System.out.print("Enter positive quantity: ");
			tables = input.nextInt();
		}
		return tables;
	}

	public static int[] menuColumns(int tables) {
		int[] columnPerTable = new int[tables];
		for (int i = 0; i < tables; i++) {
			System.out.print("Enter a positive amount of columns for table " + (i + 1) + ": ");
			columnPerTable[i] = input.nextInt();
		}
		return columnPerTable;
	}
}
