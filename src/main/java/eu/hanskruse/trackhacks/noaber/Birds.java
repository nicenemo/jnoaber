package eu.hanskruse.trackhacks.noaber;

/**
 * Some functions...TODO better comment
 * @author Hans Kruse
 *
 */
public interface Birds {
	
	/** Identity Function
	 * @param argument argument to return
	 * @return argument
	 */
	public default <T> T identity(final T argument){
		return argument;
	}
	

	/**
	 * Identity function for strings that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public default String identity(final String argument) {
		return argument;
	}
}
