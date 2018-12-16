
/*
 * Main method to run the program
 */
import java.util.*;
import java.io.*;

public class Main2 {
	private static Scanner input = new Scanner(System.in); // new Scanner object
	static String testnames[][];
	static String testnamesT[];
	public static void main(String[] args) {
		int exitCode = 0;
		Menu menu = new Menu(); //new Menu object called menu
		int numTables = menu.openingMenu(); // User enters amount of tables for data base
		Functions data = new Functions(numTables); // new Functions object called data
		menu.nameTables(numTables);
		int[] arrayNumberColumns = menu.menuColumns(numTables);
		// Creation of an array that contains the amount of columns for every table
		testnames = menu.getNames();
		testnamesT = menu.getNamesT();

		while (exitCode == 0) { //loops until user chooses to save the DataBase to a file
			switch (menu.choiceForFunctions()) { // Condition
			case (1): { // case of adding a new object
				data.addChoice(arrayNumberColumns,testnames);
				break;
			}
			case (2): { // case of printing data
				data.printChoice(testnamesT, testnames);
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
				int exitcode = 0;
				while (exitcode == 0) {
					try {
						System.out.println("Enter the name of the file you want to save the database:");
						String name = input.next();
						int choice = menu.findChoice();
						String path;
						if (choice == 2) {
							path = "C:\\Users/Public\\";
							System.out.println("Congratulations! You can now find the database in " + path + name); //informs
																													//the
																													//user
																													//where
																													//to
																													//find
																													//the
																													//file
						} else {
							path = menu.findPath();
							System.out.println("Congratulations! You can now find the file in your pc with name " + name);
							System.out.println("If you did not give full path you will find it in this java project folder with name " + path + name);
							//if the user does now enter correct path programm use the String path as name of the file and saves
							//it in the same folder with this java project
						}
						exitcode = 1;
						FileWriter file = new FileWriter(path + name); // creates the file with name given
																						// by the user
						data.fileAdd(path, name, testnamesT, testnames);
						file.close();	//releases useless resource
					} catch (IOException e) {
						System.out.println("Error!Wrong path given!");
						exitcode = 0;
					}
				}
				input.close();			//releases useless resource
				exitCode = 1; // ends programm
				break;
			}
			default: {
				System.out.println("Invalid choice");
			}
			}
		}
	}
}
