package gr.aueb.dmst.dds.CrazyDevelopers;

/*
 * Class that will be used to check whether an Exception is thrown or not
 * to guarantee that the program will end normally
 */
/**
 * @author oneofthecraziest
 */


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {
  String text;
  
  /**
   * Method that reads the choice of the user and checks to see if the value of.
   * the choice produces the InputMismatchException and ends when the value is
   * valid and no Exception is thrown
   * @return choice of the user
   */
  public int notIntegerException() {
    int choice = 0;
    int exitcode = 0;
    while (exitcode == 0) { // loops until InputMismatchException is not caught
      try {
        @SuppressWarnings("resource")
          Scanner input = new Scanner(System.in);
        System.out.println(text);
        choice = input.nextInt();
        exitcode = 1;
      } catch (InputMismatchException e) {
        System.out.println("Wrong type!");
        exitcode = 0;
      }
    }
    return choice;
  }

 /**
  * Method that it initializes the variable x
  * @param x string value
  */
  public void display(String x) {
    text = x;
  }

  /**
   * Method that checks if the value that the user gives throws the.
   * InputMismatchException or the ArrayOutOfBoundsException and ends when none of
   * the above Exceptions are thrown
   * @param x1 int value
   * @param lists ArrayList of ArrayListLine
   * @return x1 
   */
  public int outOfBoundsException(ArrayList<ArrayListLine>[] lists, int x1) {
    int exit = 0;
    while (exit == 0) { // guarantees that ArrayOutOfBoundsException is not thrown
      if (x1 > lists.length || x1 < 1) {
        display("Please insert an positive integer and less than array length");
        x1 = notIntegerException();
      } else {
        exit = 1;
      }
    }
    return x1;
  }

  /**
   * Method used for the same reason but with one more argument because we need to.
   * get to second dimension of the array lists
   * @param x1 first int value
   * @param list second int value
   * @param lists ArrayList of ArrayListLine
   * @return x1 
   */
  public int outOfBoundsException(ArrayList<ArrayListLine>[] lists, int x1, int list) {
    int exit = 0;
    while (exit == 0) { // guarantees that ArrayOutOfBoundsException is not thrown
      if (x1 > lists[list - 1].size() || x1 < 1) {
        display("Please insert an positive integer and less than array length");
        x1 = notIntegerException();
      } else {
        exit = 1;
      }
    }
    return x1;
  }
  
  /**
   * Method used for the same reason but with one more argument because we need to.
   * get to second dimension of the array lists
   * @param x1 first int value
   * @param list second int value
   * @param arrayNumberColumns String Array
   * @return x1
   */
  public int outOfBoundsException(int[] arrayNumberColumns, int x1, int list) {
    int exit = 0;
    while (exit == 0) { // guarantees that ArrayOutOfBoundsException is not thrown
      if (x1 > arrayNumberColumns[list - 1] || x1 < 1) {
        display("Please insert an positive integer and less than array length");
        x1 = notIntegerException();
      } else {
        exit = 1;
      }
    }
    return x1;
  }
  
  /**
   * Method used to check if there is data to a specific table.
   * If there is no data in the DataBase return true otherwise false
   * @param list first int value 
   * @param lists ArrayList of ArrayListLine
   * @return exit boolean value
   */
  public boolean noDataBaseException(ArrayList<ArrayListLine>[] lists, int list) {
    boolean exit = false;
    if (lists[list].size() == 0) {
      exit = true;
    }
    return exit;
  }
}
