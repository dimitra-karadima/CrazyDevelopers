import java.util.*;
public class Main3 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int i,j,column,row;
		String x,change;
		System.out.print("Enter amount of tables");
		int tables=input.nextInt();
		while(tables<=0) {
			System.out.print("Enter positive quantity: ");
			tables =input.nextInt();
		}
		ArrayList<String>[] data=new ArrayList[tables];
		for (i=0;i<tables;i++) {
			data[i]=new ArrayList<String>();
		}
		for(;;) {
			System.out.println(" Enter: 1 to add, 2 to show, 3 to delete, 4 to change data");
			int choice=input.nextInt();
			switch(choice) {
			case(1):{
				for(i=0;i<tables;i++) {
					System.out.print("Enter amount of #"+(i+1)+" row");
					x=input.next();
					data[i].add(x);
				}
				break;
			}case(2):{
				for (i = 0; i < tables; i++) { 
		            for (j = 0; j < data[i].size(); j++) { 
		                System.out.print(data[i].get(j) + " "); 
		            } 
		            System.out.println(); 
		        } 
				break;
			}case(3):{
				System.out.println("Enter column to delete");
				column=input.nextInt();
				for (i=0;i<tables;i++) {
					data[i].remove(column-1);
				}
				break;
			}case(4):{
				System.out.println("Enter row to change");
				row=input.nextInt();
				System.out.println("Enter column to change");
				column=input.nextInt();
				System.out.println("Enter new amount");
				change=input.next();
				data[row-1].set(column-1, change);
				break;
			}default:{
				break;
			}
			}
		}
	}

}
