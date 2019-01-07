package gr.aueb.dmst.dds.CrazyDevelopers;

/**
 * Class that contains all the menus needed for the program
 */

import java.util.Scanner;

public class Menu {
  Exceptions ex = new Exceptions(); //new Exceptions object called e
  private String[][] names;
  private String[] namesT;
  int []columnPerTable;
  Scanner input = new Scanner(System.in);
  /**
   * Method that asks user to enter the number of tables for the database.
   * @return this integer.
   */
  
  public int openingMenu() {
    ex.display("Enter amount of tables: "); // tables check
    int tables = ex.notIntegerException();
    while (tables <= 0) { //checks that amount of tables is bigger than 0 and not an int
      ex.display("Enter positive quantity: ");
      tables = ex.notIntegerException();
    }
    return tables;
  }
  /**
   * Method that prints the menu to the screen and returns the choice of the user.
   * @return choice for function
   */
  
  public int choiceForFunctions() {
    ex.display("Enter: 1 to add, 2 to show, 3 to delete, 4 to change data, "
        + "5 to print relational model, 6 to end programm and save it on a file");
    int choice = ex.notIntegerException();// InputMisMatchException is only checked here
    return choice;
  }

  /**
   * Method to create an array with columns the number of columns of the specific
   * position of the table by asking user to enter positive numbers for example if
   * columnPerTable={3,5,1} means that table 1 has 3 columns , table 2 has 5
   * columns, table 3 has 1 column returns this table.
   * @param tables int value
   * @return columnPerTable 
   * 
   */
  public int[] menuColumns(int tables) {
    columnPerTable = new int[tables];
    for (int i = 0; i < tables; i++) {
      ex.display("Enter a positive amount of columns for table " + (i + 1) + ": ");
      int amount = ex.notIntegerException();
      while (amount < 1) { //checks that amount is bigger than 0 and an integer
        ex.display("Enter a positive amount of columns for table " + (i + 1) + ": ");
        amount = ex.notIntegerException();
      }
      columnPerTable[i] = amount;
    }
    addNames(columnPerTable);
    return columnPerTable;
  }

  /**
   * Method to create an two-dimension array with lines the number of tables the
   * user wants and columns the number of columns of the specific table. The user
   * gives the names for each column of every table and the method inserts these names
   * into the two-dimension array names[][]
   * @param columnPerTable array of int values
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

  /**
   * Method to give user the opportunity to name every table of the DataBase
   * The table names are saved in the one-dimension array namesT[].
   * @param tables int value
   */
  public void nameTables(int tables) {
    namesT = new String[tables];
    for (int i = 0; i < tables; i++) {
      System.out.println("Enter name for the #" + (i + 1) + " table:");
      namesT[i] = input.next();
    }
  }

  /**
   * Method to declare if the user wants to save the file in a certain path
   * or wants to use the default one (User press 1)
   * The default path is C:\\Users/Public\\ and it is declared by us (User press 2)
   * Returns the choice that the user makes,which is 1 or 2.
   * @return choice of customer
   */
  public String findChoice() {
    ex.display("Enter 1 if you want it to enter the path you want to save the file in"
         + " or 2 to save it to C:\\Users/Public\\ : ");
    int choice = ex.notIntegerException();
    while (choice < 1 || choice > 2) {
      System.out.println("Please enter only 1 or 2!");
      choice = ex.notIntegerException();
    }
    if (choice == 1) {
      return findPath();
    } else {
      return "C:\\Users/Public\\";
    }
  }

  /*
   * Method used only if user chooses to enter his own path
   * Returns path
   */
  public String findPath() {
    System.out.print("Enter the path you want to save your file in: ");
    return input.next();
  }
  
  /**
   * Method used to print relational model
   * it is called only if user enters 5 in the openingMenu().
   */
  public void printModel() {
    for (int i = 0;i < namesT.length; i++) {
      System.out.print(namesT[i] + "(");
      for (int j = 0; j < names[i].length; j++) {
        if (j == (names[i].length - 1)) {
          System.out.println(names[i][j] + ")");
        } else {
          System.out.print(names[i][j] + " ,");
        }
      }
    }
  }

  /**
   * Simple get methods for names[][] and namesT[]
   * Will be used by Main2 class
   * Useful for the addChoice() and printChoice().
   * @return names
   */
  public String[][] getNames() {
    return names;
  }

  public String[] getNamesT() {
    return namesT;
  }
}
