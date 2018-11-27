
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
				data.printChoice();
				break;
			}
			case (3): { // case of deleting data
				data.deleteChoice();
				break;

			}
			case (4): { // case of changing data
				data.changeChoice(arrayNumberColumns);
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
		Exceptions e=new Exceptions();
		e.display("Enter amount of tables: "); // tables check
		int tables = e.NotIntegerException();
		while (tables <= 0) {
			e.display("Enter positive quantity: ");
			tables = e.NotIntegerException();
		}
		return tables;
	}
}
