package gr.aueb.dmst.dds.CrazyDevelopers;

/**
 *Class that contains necessary functions for our database:
 * input of data , data presentation, delete and change of data
 */

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
  Exceptions ex = new Exceptions();// new Exceptions object called e
  int[] features;
  protected ArrayList<ArrayListLine>[] lists; // array that contains array lists
  private static Scanner input = new Scanner(System.in); // new Scanner object

  /**
   * Constructor of our class Sets length of our array of array lists.
   * @param num int value
   */

  @SuppressWarnings("unchecked")
  public Functions(int num) {
    lists = new ArrayList[num];
    for (int i = 0; i < num; i++) {
      lists[i] = new ArrayList<ArrayListLine>();
    }
  }

  /**
   * Method that adds a new object(line) to a specific list
   * @param num int value
   * @param object arraylistline
   */
  public void addLine(ArrayListLine object, int num) {
    lists[num].add(object);
  }

  /**
   * Method that allows user to add the new line to a table Asks for the number of
   * table to add a new line and then asks for the Strings for every column After
   * it creates a new line using the addLine(...) method.
   * @param arrayNumberColumns array of int values
   * @param names array of string values
   */
  public void addChoice(int[] arrayNumberColumns, String[][] names) {
    features = arrayNumberColumns;
    ex.display("Enter number of table you wish to add a new object: ");
    // method from exceptions called
    int tableAdd = ex.notIntegerException();// guarantees that InputMismatchException is not thrown
    tableAdd = ex.outOfBoundsException(lists, tableAdd);
    String[] newObject = new String[arrayNumberColumns[tableAdd - 1]];
    for (int i = 0; i < arrayNumberColumns[tableAdd - 1]; i++) {
      System.out.print("Enter something for column " + names[tableAdd - 1][i] + ": ");
      newObject[i] = input.next();
    }
    ArrayListLine xx = new ArrayListLine(newObject);
    addLine(xx, tableAdd - 1);
  }

  /**
   * Method that deletes an object(line)
   * @param rem first int value
   * @param num second int value
   */
  public void delete(int rem, int num) {
    lists[num].remove(rem);
  }

  /**
   * Method that deletes a specific line of a specific table Asks user to input
   * number of table and number of line Uses method delete of class Functions to
   * do so.
   * 
   */
  public void deleteChoice() {
    ex.display("Select list to delete an item: ");
    int list = ex.notIntegerException();
    list = ex.outOfBoundsException(lists, list);
    if (ex.noDataBaseException(lists, list - 1)) {
      System.out.println("This list has no data!"
          + "You first have to add data for you to proceed to this action!");
    } else {
      ex.display("Select number of item: ");
      int item = ex.notIntegerException();
      item = ex.outOfBoundsException(lists, item, list);
      delete(item - 1, list - 1);
    }
  }

  /**
   * Method that prints a specific object of a list and the names of the columns,
   * all given by the user.
   * @param list first int value
   * @param num2 second int value
   * @param names  array of string values 
   */
  public void print(int list, int num2, String[][] names) {
    if (num2 == 0) {
      for (int i = 0; i < names[list].length; i++) {
        System.out.printf("%15s %6s", names[list][i],"");
      }
      System.out.println("\t");
      System.out.println("");
    }
    lists[list].get(num2).printLine();
  }

  /**
   * Method that prints all the lines and columns(all the objects ArrayListLine
   * there are) of the existing tables Uses the method print of Functions to do so.
   * @param names array of string values 
   * @param namesT  array of string values 
   */
  public void printChoice(String[] namesT, String[][] names) {
    for (int i = 0; i < lists.length; i++) {
      System.out.printf("%50s %n", namesT[i]);
      for (int j = 0; j < lists[i].size(); j++) {
        print(i, j,names);
      }
      System.out.println();
    }
  }


  /**
   * Method that changes an object of a specific line
   * @param list first int value
   * @param line second int value
   * @param column third int value
   * @param change fourth string value
   */
  public void change(int list, int line, int column, String change) {
    lists[list].get(line).changeColumn(column, change);
  }

  /**
   * Method that allows a user to change a specific column of a specific line of a
   * specific table or a whole line .Asks user to choose what he wants Then he
   * inputs the number of table and number of line if he chooses to change the
   * whole line , he inputs all the different columns otherwise he clarifies which
   * column he wants to change and goes on to change it This method uses the
   * method change of class Functions to do so.
   * @param arrayNumberColumns array of int values
   */
  public void changeChoice(int[] arrayNumberColumns) {
    ex.display("Select 1 to change a whole line and 2 to change a specific column: ");
    int choiceChange = ex.notIntegerException();
    while (choiceChange != 1 && choiceChange != 2) {
      ex.display("Invalid choice, enter 1 or 2: ");
      choiceChange = ex.notIntegerException();
    }
    ex.display("Select table to change an item from : ");
    int table = ex.notIntegerException();
    table = ex.outOfBoundsException(lists, table);
    if (ex.noDataBaseException(lists,table - 1)) {
      System.out.println("This list has no data!"
          + "You first have to add data for you to proceed to this action!");
    } else {
      ex.display("Select the line of item: ");
      int item = ex.notIntegerException();
      item = ex.outOfBoundsException(lists, item, table);
      if (choiceChange == 1) {
        String[] newObject = new String[arrayNumberColumns[table - 1]];
        for (int i = 0; i < arrayNumberColumns[table - 1]; i++) {
          System.out.print("Enter something for column " + (i + 1) + ": ");
          newObject[i] = input.next();
        }
        for (int i = 0; i < arrayNumberColumns[table - 1]; i++) {
          change(table - 1, item - 1, i, newObject[i]);
        }
      } else {
        ex.display("Select the column of the item: ");
        int col = ex.notIntegerException();
        col = ex.outOfBoundsException(features, col, table);
        System.out.print("Enter new value: ");
        String newValue = input.next();
        change(table - 1, item - 1, col - 1, newValue);
      }
    }
  }

  /**
   * Method to add to an already existing file named by the user file has the same
   * output as the print choice above.
   * @param path string value
   * @param name string value
   * @param names array of string values 
   * @param namesT  array of string values 
   */
  public void fileAdd(String path, String name, String[]namesT, String[][] names) {
    try {
      PrintWriter out = new PrintWriter(path + name); // getting access to the right file
      for (int i = 0; i < lists.length; i++) {
        out.println("\t\t\t\t" + namesT[i]);
        for (int j = 0; j < lists[i].size(); j++) {
          if (j == 0) {
            for (int k = 0; k < names[i].length; k++) {
              out.print("\t" + names[i][k] + "\t");
            }
            out.println("\t");
          }
          out.print("|");
          String[] x = lists[i].get(j).getLine();
          for (int a = 0; a < x.length; a++) {
            out.print("\t" + x[a] + "\t|");
          }
          out.println("\t");
        }
        out.println("\t");
      }
      out.close();
    } catch (IOException e) {
      System.out.println("Error!");
    }
  }
}
