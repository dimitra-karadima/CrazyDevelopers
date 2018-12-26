package dds.gr.aueb.dmst.crazydevelopers;

/*
 * Class that will be used to check whether an Exception is thrown or not
 * to guarantee that the program will end normally
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

  // Method that it initializes the variable x
  public void display(String x) {
    text = x;
  }

  /**
   * Method that checks if the value that the user gives throws the.
   * InputMismatchException or the ArrayOutOfBoundsException and ends when none of
   * the above Exceptions are thrown
   */
  public int outOfBoundsException(ArrayList<ArrayListLine>[] lists, int x1) {
    int exitcode = 0;
    int i = 0;
    while (exitcode == 0) { // loops until none Exception is thrown
      try {
        i++;
        if (i != 1) {  // not entering the first time
          try {  // happens only if the argument throws ArrayIndexOutBoundsException
            System.out.println("Try again!");
            System.out.println(text);
            @SuppressWarnings("resource")
            Scanner input = new Scanner(System.in);
            x1 = input.nextInt();
            if (x1 <= lists.length & x1 > 0) {
              exitcode = 1;
            }
          } catch (InputMismatchException e) {
            System.out.println("Wrong type!");
            exitcode = 0;
          }
        } else if (x1 <= lists.length & x1 > 0) { // checks the argument of the method
          exitcode = 1;
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        exitcode = 0;
      }
    }
    return x1;
  }

  /**
   * Method used for the same reason but with one more argument because we need to.
   * get to second dimension of the array lists
   */
  public int outOfBoundsException(ArrayList<ArrayListLine>[] lists, int x1, int list) {
    int exitcode = 0;
    int i = 0;
    while (exitcode == 0) {
      try {
        if (i != 0) {
          try {
            System.out.println("Try again!");
            System.out.println(text);
            @SuppressWarnings("resource")
            Scanner input = new Scanner(System.in);
            x1 = input.nextInt();
            if (x1 <= lists[list - 1].size() && x1 > 0) {
              exitcode = 1;
            }
          } catch (InputMismatchException e) {
            System.out.println("Wrong type!");
            exitcode = 0;
          }
        }
        i++;
        if (x1 <= lists[list - 1].size() && x1 > 0) {
          exitcode = 1;
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        exitcode = 0;
      }
    }
    return x1;
  }
  
  /**
   * Method used for the same reason but with different arguments because we need.
   * to use the features for every list
   */
  public int outOfBoundsException(int[] arrayNumberColumns, int x1, int list) {
    int exitcode = 0;
    int i = 0;
    while (exitcode == 0) {
      try {
        if (i != 0) {
          try {
            System.out.println("Try again!");
            System.out.println(text);
            @SuppressWarnings("resource")
            Scanner input = new Scanner(System.in);
            x1 = input.nextInt();
            if (x1 <= arrayNumberColumns[list - 1] && x1 > 0) {
              exitcode = 1;
            }
          } catch (InputMismatchException e) {
            System.out.println("Wrong type!");
            exitcode = 0;
          }
        }
        i++;
        if (x1 <= arrayNumberColumns[list - 1] && x1 > 0) {
          exitcode = 1;
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        exitcode = 0;
      }
    }
    return x1;
  }
  
  /**
   * Method used to check if there is data to a specific table.
   * If there is no data in the DataBase return true otherwise false
   */
  public boolean noDataBaseException(ArrayList<ArrayListLine>[] lists, int list) {
    boolean exit = false;
    if (lists[list].size() == 0) {
      exit = true;
    }
    return exit;
  }
}

