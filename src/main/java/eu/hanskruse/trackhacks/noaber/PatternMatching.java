package eu.hanskruse.trackhacks.noaber;

/**
 * Advanced pattern matching, aka a switch statement on steroids.
 * Inspired by pattern matching in languages such as F# and Scala.
 * @author Hans Kruse
 *
 */
public interface PatternMatching {
	
	/**
	 * Match captures the value to match against returning a CaseAcceptor.
	 * @param value the value to capture
	 * @return a CaseAcceptor.
	 */
	public default <T>  CaseAcceptor<T> match(final T value){
		return new CaseAcceptor<>(value);
	}
}
