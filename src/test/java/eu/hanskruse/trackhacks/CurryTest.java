package eu.hanskruse.trackhacks;
import static eu.hanskruse.trackhacks.noaber.WithCurry.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import junit.framework.TestCase;

public class CurryTest extends TestCase {

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public CurryTest(String testName) {
		super(testName);
	}
	
	@SuppressWarnings("static-method")
	public void testLeftCurryOnBiFunction(){
	 final String expected ="42";
	 BiFunction<Integer,Boolean, String> f = (x,b) -> Integer.toString((b?x:42));	
	 Function<Integer, Function<Boolean, String>> cf=leftCurry(f);
	 final String actual =cf.apply(3).apply(false);
	 assertEquals(expected, actual);
	 
	}
	
	@SuppressWarnings("static-method")
	public void testRightCurryOnBiFunction(){
	  final String expected ="42";
	  BiFunction<Integer,Boolean, String> f = (x,b) -> Integer.toString((b?x:42));	
	  Function<Boolean, Function<Integer, String>> cf=rightCurry(f);
	  String actual = cf.apply(false).apply(3);
	  assertEquals(expected, actual);
	}
}
