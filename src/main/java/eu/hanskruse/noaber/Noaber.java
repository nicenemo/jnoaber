package eu.hanskruse.noaber;

/**
 * Noaber utility with all kinds of handy functionality.
 *
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public final class Noaber implements WithNoaber {

  /** Singleton instance of noaber. */
  public static final WithNoaber $ = new Noaber();

  /**
   * Not to be instantiated.
   */
  private Noaber() {
    // Do nothing.
  }

}
