package gr.aueb.dmst.dds.CrazyDevelopers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ArrayListLineTest {
  
  String[] test = {"1","hi"};
  ArrayListLine ar;

  @Before
  public void setUp() throws Exception {
    ar = new ArrayListLine(test);
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testConstructor() {
    assertEquals(test, ar.line);
  }

  @Test
  public void testChange() {
    String x = "10";
    ar.changeColumn(0, x);
    assertEquals("10",ar.line[0]);
  }
  
  @SuppressWarnings("deprecation")
  @Test
  public void testGetLine() {
    assertEquals(ar.line,ar.getLine());
  }

}
