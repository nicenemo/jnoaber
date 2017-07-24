package eu.hanskruse.trackhacks;

import static eu.hanskruse.trackhacks.noaber.$.*;
import eu.hanskruse.trackhacks.noaber.$;
import java.util.function.Function;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests for compose.
 */
public class ComposeTest extends TestCase  {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public ComposeTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ComposeTest.class);
	}


	/**
	 * Inc function that returns argument + 1.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument+1
	 */
	private int inc(int argument) {
		return argument + 1;
	}

	/**
	 * Inc function that returns argument+1
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument+1
	 */
	private int incPlus100(int argument) {
		return argument + 1 + 100;
	}

	/**
	 * Test Compose with 2 function.
	 */
	@SuppressWarnings("static-method")
	public void testCompose2() {
		final String expected = "42";
		final Function<String,String> f = compose( //
				$::identity, // 1
				$::identity); // 2
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 3 functions.
	 */
	@SuppressWarnings("static-method")
	public void testCompose3() {
		final String expected = "42";
		final Function<String,String> f  = compose( //
				$::identity, // 1
				$::identity, // 2
				$::identity); // 3
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 4 functions.
	 */
	@SuppressWarnings("static-method")
	public void testCompose4() {
		final String expected = "42";
		final Function<String,String> f = compose( //
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity); // 4
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 5 functions.
	 */
	@SuppressWarnings("static-method")
	public void testCompose5() {
		final String expected = "42";
		final Function<String,String> f  = compose(//
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity, // 4
				$::identity); // 5
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 6 functions.
	 */
	@SuppressWarnings("static-method")
	public void testCompose6() {
		final String expected = "42";
		final Function<String,String> f = compose( //
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity, // 4
				$::identity, // 5
				$::identity); // 6
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 7 functions.
	 */
	@SuppressWarnings("static-method")
	public void testCompose7() {
		final String expected = "42";
		final Function<String,String> f  = compose(//
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity, // 4
				$::identity, // 5
				$::identity, // 6
				$::identity); // 7
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 8 functions.
	 */
	@SuppressWarnings("static-method")
	public void testCompose8() {
		final String expected = "42";
		final Function<String,String> f = compose( //
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity, // 4
				$::identity, // 5
				$::identity, // 6
				$::identity, // 7
				$::identity); // 8
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 9 functions.
	 */
	@SuppressWarnings("static-method")
	public void testCompose9() {
		final String expected = "42";
		final Function<String,String> f  = compose( //
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity, // 4
				$::identity, // 5
				$::identity, // 6
				$::identity, // 7
				$::identity, // 8
				$::identity); // 9
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 10 functions.
	 */
	@SuppressWarnings("static-method")
	public void testCompose10() {
		final String expected = "42";
		final Function<String,String> f  = compose( //
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity, // 4
				$::identity, // 5
				$::identity, // 6
				$::identity, // 7
				$::identity, // 8
				$::identity, // 9
				$::identity); // 10
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 11 functions.
	 */
	@SuppressWarnings("static-method")
	public void testCompose11() {
		final String expected = "42";
		final Function<String,String> f = compose( //
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity, // 4
				$::identity, // 5
				$::identity, // 6
				$::identity, // 7
				$::identity, // 8
				$::identity, // 9
				$::identity, // 10
				$::identity); // 11
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 12 functions.
	 */
	@SuppressWarnings("static-method")
	public void testCompose12() {
		final String expected = "42";
		final Function<String,String> f = compose( //
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity, // 4
				$::identity, // 5
				$::identity, // 6
				$::identity, // 7
				$::identity, // 8
				$::identity, // 9
				$::identity, // 10
				$::identity, // 11
				$::identity); // 12
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 13 functions.
	 */
	@SuppressWarnings("static-method")
	public void testCompose13() {
		final String expected = "42";
		final Function<String,String> f = compose( //
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity, // 4
				$::identity, // 5
				$::identity, // 6
				$::identity, // 7
				$::identity, // 8
				$::identity, // 9
				$::identity, // 10
				$::identity, // 11
				$::identity, // 12
				$::identity); // 13
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 14 functions.
	 */
	@SuppressWarnings("static-method")
	public void testCompose14() {
		final String expected = "42";
		final Function<String,String> f = compose( //
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity, // 4
				$::identity, // 5
				$::identity, // 6
				$::identity, // 7
				$::identity, // 8
				$::identity, // 9
				$::identity, // 10
				$::identity, // 11
				$::identity, // 12
				$::identity, // 13
				$::identity); // 14
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 15 functions.
	 */
	@SuppressWarnings("static-method")
	public void testCompose15() {
		final String expected = "42";
		final Function<String,String> f = compose( //
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity, // 4
				$::identity, // 5
				$::identity, // 6
				$::identity, // 7
				$::identity, // 8
				$::identity, // 9
				$::identity, // 10
				$::identity, // 11
				$::identity, // 12
				$::identity, // 13
				$::identity, // 14
				$::identity); // 15
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 16 functions
	 */
	@SuppressWarnings("static-method")
	public void testCompose16() {
		final String expected = "42";
		final Function<String,String> f = compose( //
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity, // 4
				$::identity, // 5
				$::identity, // 6
				$::identity, // 7
				$::identity, // 8
				$::identity, // 9
				$::identity, // 10
				$::identity, // 11
				$::identity, // 12
				$::identity, // 13
				$::identity, // 14
				$::identity, // 15
				$::identity); // 16
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with more than 16 functions with same type for argument and
	 * return value.
	 */
	@SuppressWarnings({ "unchecked", "static-method" })
	public void testComposeMore() {
		final String expected = "42";
		final Function<String,String> f = compose( //
				$::identity, // 1
				$::identity, // 2
				$::identity, // 3
				$::identity, // 4
				$::identity, // 5
				$::identity, // 6
				$::identity, // 7
				$::identity, // 8
				$::identity, // 9
				$::identity, // 10
				$::identity, // 11
				$::identity, // 12
				$::identity, // 13
				$::identity, // 14
				$::identity, // 15
				$::identity, // 16
				$::identity, // 17
				$::identity); // 18
		final String actual =f.apply(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with more than 16 functions with same type for argument and
	 * return value.
	 */
	@SuppressWarnings("unchecked")
	public void testComposeArgCount() {
		final int expected = 120;
		final Function<Integer, Integer> f = compose( //
				this::inc, // 1
				this::inc, // 2
				this::inc, // 3
				this::inc, // 4
				this::inc, // 5
				this::inc, // 6
				this::inc, // 7
				this::inc, // 8
				this::inc, // 9
				this::inc, // 10
				this::inc, // 11
				this::inc, // 12
				this::inc, // 13
				this::inc, // 14
				this::inc, // 15
				this::inc, // 16
				this::inc, // 17
				this::inc, // 18
				this::inc, // 19
				this::incPlus100); // 20 //last a different function to prevent
									// of by one errors

		final int actual =f.apply(0);
		assertEquals(expected, actual);
	}
}
