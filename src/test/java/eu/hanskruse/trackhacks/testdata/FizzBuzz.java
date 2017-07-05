package eu.hanskruse.trackhacks.testdata;

/**
 * Modeling the classic fizzbuzz puzzle to be used in a pattern matching use case.
 * @author Hans Kruse
 *
 */
public interface FizzBuzz {
	/**
	 * fizzBuzz.
	 * @param n the number to check
	 * @return true if and only if n can be divided by both 3 and 5.
	 */
	public default boolean fizzBuzz(final int n){
		return fizz(n) && buzz(n);
	}
	
	/**
	 * fizz.
	 * @param n the number to check
	 * @return true if and only if n can be divided by 3.
	 */
	public default boolean fizz(final int n){
		return (n % 3) == 0;
	}
	
	/**
	 * buzz.
	 * @param n the number to check
	 * @return true if and only if n can be divided by 5.
	 */
	public default boolean buzz(final int n){
		return (n % 5) == 0;
	}
	
}
