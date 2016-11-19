package eu.hanskruse.trackhacks;

import eu.hanskruse.trackhacks.noaber.$;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests for compose.
 */
public class ComposeTests extends TestCase implements $ {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public ComposeTests(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ComposeTests.class);
	}

	/**
	 * Identity function for strings that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	private String identity(String argument) {
		return argument;
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
	public void testCompose2() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity); // 2
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 3 functions.
	 */
	public void testCompose3() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity); // 3
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 4 functions.
	 */
	public void testCompose4() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity); // 4
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 5 functions.
	 */
	public void testCompose5() {
		final String expected = "42";
		final String actual = compose(//
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity, // 4
				this::identity); // 5
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 6 functions.
	 */
	public void testCompose6() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity, // 4
				this::identity, // 5
				this::identity); // 6
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 7 functions.
	 */
	public void testCompose7() {
		final String expected = "42";
		final String actual = compose(//
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity, // 4
				this::identity, // 5
				this::identity, // 6
				this::identity); // 7
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 8 functions.
	 */
	public void testCompose8() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity, // 4
				this::identity, // 5
				this::identity, // 6
				this::identity, // 7
				this::identity); // 8
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 9 functions.
	 */
	public void testCompose9() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity, // 4
				this::identity, // 5
				this::identity, // 6
				this::identity, // 7
				this::identity, // 8
				this::identity); // 9
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 10 functions.
	 */
	public void testCompose10() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity, // 4
				this::identity, // 5
				this::identity, // 6
				this::identity, // 7
				this::identity, // 8
				this::identity, // 9
				this::identity); // 10
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 11 functions.
	 */
	public void testCompose11() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity, // 4
				this::identity, // 5
				this::identity, // 6
				this::identity, // 7
				this::identity, // 8
				this::identity, // 9
				this::identity, // 10
				this::identity); // 11
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 12 functions.
	 */
	public void testCompose12() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity, // 4
				this::identity, // 5
				this::identity, // 6
				this::identity, // 7
				this::identity, // 8
				this::identity, // 9
				this::identity, // 10
				this::identity, // 11
				this::identity); // 12
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 13 functions.
	 */
	public void testCompose13() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity, // 4
				this::identity, // 5
				this::identity, // 6
				this::identity, // 7
				this::identity, // 8
				this::identity, // 9
				this::identity, // 10
				this::identity, // 11
				this::identity, // 12
				this::identity); // 13
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 14 functions.
	 */
	public void testCompose14() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity, // 4
				this::identity, // 5
				this::identity, // 6
				this::identity, // 7
				this::identity, // 8
				this::identity, // 9
				this::identity, // 10
				this::identity, // 11
				this::identity, // 12
				this::identity, // 13
				this::identity); // 14
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 15 functions.
	 */
	public void testCompose15() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity, // 4
				this::identity, // 5
				this::identity, // 6
				this::identity, // 7
				this::identity, // 8
				this::identity, // 9
				this::identity, // 10
				this::identity, // 11
				this::identity, // 12
				this::identity, // 13
				this::identity, // 14
				this::identity); // 15
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with 16 functions
	 */
	public void testCompose16() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity, // 4
				this::identity, // 5
				this::identity, // 6
				this::identity, // 7
				this::identity, // 8
				this::identity, // 9
				this::identity, // 10
				this::identity, // 11
				this::identity, // 12
				this::identity, // 13
				this::identity, // 14
				this::identity, // 15
				this::identity); // 16
		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with more than 16 functions with same type for argument and
	 * return value.
	 */
	@SuppressWarnings("unchecked")
	public void testComposeMore() {
		final String expected = "42";
		final String actual = compose( //
				expected, // 0
				this::identity, // 1
				this::identity, // 2
				this::identity, // 3
				this::identity, // 4
				this::identity, // 5
				this::identity, // 6
				this::identity, // 7
				this::identity, // 8
				this::identity, // 9
				this::identity, // 10
				this::identity, // 11
				this::identity, // 12
				this::identity, // 13
				this::identity, // 14
				this::identity, // 15
				this::identity, // 16
				this::identity, // 17
				this::identity); // 18

		assertEquals(expected, actual);
	}

	/**
	 * Test Compose with more than 16 functions with same type for argument and
	 * return value.
	 */
	@SuppressWarnings("unchecked")
	public void testComposeArgCount() {
		final int expected = 120;
		final int actual = compose( //
				0, // 0
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

		assertEquals(expected, actual);
	}
}
