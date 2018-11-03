/*
 * Main method to run the program
 */
import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in); //new Scanner object
		System.out.print("Enter amount of tables: "); // tables check
		int tables =input.nextInt();
		while(tables<=0) {
			System.out.print("Enter positive quantity: ");
			tables =input.nextInt();
		}
		Functions data=new Functions(tables); //new Functions object called data
		for(;;) {
			menu(); // print menu
			int choice=input.nextInt();
			switch(choice) { // Condition 
			case(1):{ // case of adding a new object
				System.out.print("Enter first column: ");
				String col1=input.next();
				System.out.print("Enter second column: ");
				String col2=input.next();
				System.out.print("Enter third column: ");
				String col3=input.next();
				ArrayListLine xx=new ArrayListLine(col1,col2,col3);
				System.out.print("Enter list to add: ");
				int list=input.nextInt();
				data.add(xx, list-1);
				break;
				}
			case (2):{ // case of printing data
				for(int i=0;i<tables;i++) {
					System.out.println("\tList "+(i+1));
					for(int j=0;j<data.lists[i].size();j++) {
						System.out.println(data.get(i,j));
					}
					System.out.println();
					}
				break;
				} 
			case(3):{ //case of deleting data
				System.out.print("Select list to delete an item: ");
				int list=input.nextInt();
				System.out.print("Select number of item: ");
				int item=input.nextInt();
				data.delete(item-1, list-1);
				break;
				
				}
			case(4):{ // case of changind data
				System.out.print("Select list to change an item from : ");
				int list=input.nextInt();
				System.out.print("Select number of item: ");
				int item=input.nextInt();
				System.out.print("Enter first column: ");
				String col1=input.next();
				System.out.print("Enter second column: ");
				String col2=input.next();
				System.out.print("Enter third column: ");
				String col3=input.next();
				ArrayListLine xx=new ArrayListLine(col1,col2,col3);
				data.change(list-1, item-1, xx);
				break;
				}
			default:{
				System.out.println("Invalid choice");
				}
			}
			
		}
		
		
	}
	
	/*
	 * Method that prints the menu to the screen
	 */
	public static void menu() {
		System.out.println(" Enter: 1 to add, 2 to show, 3 to delete, 4 to change data");
	}
}

