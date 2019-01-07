package gr.aueb.dmst.dds.CrazyDevelopers;

/** ArrayListLine class.
 *   *that will be used as a whole different  line in our database
 *  
 * @author oneofthecraziest
 */
public class  ArrayListLine {
 protected String[] line;
 // theoretical columns of our data base

 /**
  * Constructor of our class.
  * @param line String Array
  */
 public ArrayListLine(String[] line) {
   this.line = line;
 }

 /**
  * @param column first int value
  * @param x second string value
  * method that helps changing a specific column of our line.
  */
 public void changeColumn(int column, String x) {
   line[column] = x;
 }

 /**
  * Method that prints specific Line, will be used in the class Functions.
  */
 public void printLine() {
   System.out.print("|");
   for (int i = 0; i < line.length; i++) {
     System.out.printf("%15s %5s|",line[i],"");
   }
   System.out.println("\t");
 }

 /**
  * Method that returns specific Line in an array, will be used in the class.
  * Functions
  * @return specific line x
  */
 public String[] getLine() {
   String[] x = new String[line.length];
   for (int i = 0; i < line.length; i++) {
     x[i] = line[i];
   }
   return x;
 }
}
