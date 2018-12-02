
/*
 * Main method to run the program
 */
import java.util.*;
import java.io.*;

public class Main2 {
	private static Scanner input = new Scanner(System.in); // new Scanner object

	public static void main(String[] args) {
		int exitCode = 0;
		int numTables = openingMenu(); // User enters amount of tables for data base
		Functions data = new Functions(numTables); // new Functions object called data
		data.nameTables(numTables);
		int[] arrayNumberColumns = data.menuColumns(numTables);
		// Creation of an array that contains the amount of columns for every table

		while (exitCode == 0) {
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
			case (5): { // case of ending loop and programm to save to file
				try {
					System.out.println("Enter the name of the file you want to save the database:");
					String name = input.next();
					FileWriter file = new FileWriter("C:\\Users/Public\\" + name); // creates the file with name given
																					// by the user
					data.fileAdd(name);
					System.out.println("Congratulations! You can now find the database in C:\\Users/Public\\" + name); // informs
					input.close();		//releases useless resource																				// the
					file.close();		//releases useless resource																								// user
																														// where
																														// to
																														// find
																														// the
																														// file
				} catch (IOException e) {
					System.out.println("Error!");
				}
				exitCode = 1; // ends programm
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
		Exceptions e = new Exceptions();
		e.display("Enter amount of tables: "); // tables check
		int tables = e.NotIntegerException();
		while (tables <= 0) {
			e.display("Enter positive quantity: ");
			tables = e.NotIntegerException();
		}
		return tables;
	}
}
