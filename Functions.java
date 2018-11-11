/*Class that contains necessary functions for our database:
 * input of data , data presentation, delete and change of data
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
	 static ArrayList<ArrayListLine> lists[]; //array that contains arraylists
	
	/*
	 * Constractor of our class
	 * Sets length of our array of arraylists
	 */
	public Functions(int num) {
		lists=new ArrayList [num];
		for(int i=0;i<num;i++){
			   lists[i]=new ArrayList<>();
		}
	}
	
	/*
	 * Method that adds a new object(line) to a specific list
	 */
	public void add(ArrayListLine object,int num) {
		lists[num].add(object);
	}
	
	/*
	 * Method that deletes an object(line) 
	 */
	public void delete(int rem,int num) {
		lists[num].remove(rem);
	}
	
	/*
	 * Method that prints a specifil object of a list
	 */
	public void print(int list,int num2) {
		lists[list].get(num2).printLine();;
		
	}
	
	/*
	 * Method that changes an object of a specific line
	 */
	public void change(int list,int line,int column,String change) {
		lists[list].get(line).changeColumn(column, change);
	}
}
