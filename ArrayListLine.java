/* ArrayListLine class
 *that will be used as a whole different  line in our database
 
 */
public class ArrayListLine {
	private String str1;
	private String str2;
	private String str3; //theoretical columns of our data base
	
	/*Constractor of our class
	 * 
	 */
	public ArrayListLine(String x1,String x2,String x3) {
		str1=x1;
		str2=x2;
		str3=x3;
	}
	
	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}

	public String getStr3() {
		return str3;
	}

	public void setStr3(String str3) {
		this.str3 = str3;
	}

	/* Basic toString format
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "| " + str1 + "\t\t" + str2 + "\t\t" + str3 +"\t\t|";
	}

	
	
}
