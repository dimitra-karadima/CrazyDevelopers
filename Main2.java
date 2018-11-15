
/*
 * Main method to run the program
 */
import java.util.*;

public class Main2 {
	private static Scanner input = new Scanner(System.in); // new Scanner object

	public static void main(String[] args) {
		int numTables = openingMenu(); // User enters amount of tables for data base
		Functions data = new Functions(numTables); // new Functions object called data
		int[] arrayNumberColumns = data.menuColumns(numTables);
		// Creation of an array that contains the amount of columns for every table

		for (;;) {
			switch (data.choiceForFunctions()) { // Condition
			case (1): { // case of adding a new object
				data.addChoice(arrayNumberColumns);
				break;
			}
			case (2): { // case of printing data
				data.printChoice(numTables);
				break;
			}
			case (3): { // case of deleting data
				data.deleteChoice();
				break;

			}
			case (4): { // case of changind data
				data.changeChoice();
				break;
			}
			default: {
				System.out.println("Invalid choice");
			}
			}
		}
	}

	/*
	 * Method that asks user to enter the number of tables for the database and
	 * return this integer
	 */
	public static int openingMenu() {
		System.out.print("Enter amount of tables: "); // tables check
		int tables = input.nextInt();
		while (tables <= 0) {
			System.out.print("Enter positive quantity: ");
			tables = input.nextInt();
		}
		return tables;
	}
}
