package eu.hanskruse.trackhacks.noaber;

/**
 * Anchor for getting a singleton instance to Noaber library. This
 * can be used for situation where you do not want to use inheritance to mix in
 * the underscore library.
 * 
 * @author Hans Kruse
 *
 */
public class Noaber implements $ {
	private static final $ instance = new Noaber();
	
	/**
	 * prevent construction.
	 */
	private Noaber() {
		// do nothing
	}
	
	/**
	 * 
	 * @return Singleton instance of the Joepie library
	 */
	public static $ $() {
		return instance;
	}
}
