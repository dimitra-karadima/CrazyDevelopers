package gr.aueb.dmst.dds.CrazyDevelopers;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FunctionsTest {

  Functions fun;
  ArrayListLine ar;
  String[] test = {"1"};
  
  @Before
  public void setUp() throws Exception {
    fun = new Functions(5);
    ar = new ArrayListLine(test);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testConstructor() {
    assertEquals(5,fun.lists.length);
    assertEquals(0,fun.lists[0].size());
  }

}
