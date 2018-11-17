/* ArrayListLine class
 *that will be used as a whole different  line in our database
 
 */
public class ArrayListLine {
	private String[] line;
	// theoretical columns of our data base

	/*
	 * Constructor of our class
	 * 
	 */
	public ArrayListLine(String[] line) {
		this.line = line;
	}

	/*
	 * method that helps changing a specific column of our line
	 */
	public void changeColumn(int column, String x) {
		line[column] = x;
	}

	/*
	 * Method that prints specific Line, will be used in the class Functions
	 */
	public void printLine() {
		System.out.print("|");
		for (int i = 0; i < line.length; i++) {
			System.out.print("\t" + line[i] + "\t|");
		}
		System.out.println("\t");
	}

}
