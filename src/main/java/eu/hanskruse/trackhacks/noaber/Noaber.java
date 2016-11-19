package eu.hanskruse.trackhacks.noaber;

/**
 * Anchor for getting a singleton instance to Noaber library. This can be used
 * for situation where you do not want to use inheritance to mix in the
 * underscore library.
 * 
 * @author Hans Kruse
 *
 */
public final class Noaber implements $ {
	/**
	 * Singleton Noaber Instance that can be imported with static.
	 */
	public static final $ $ = new Noaber();

	/**
	 * prevent construction.
	 */
	private Noaber() {
		// do nothing
	}
}
