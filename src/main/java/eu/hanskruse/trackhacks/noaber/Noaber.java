package eu.hanskruse.trackhacks.noaber;

/**
 * Noaber utility with all kinds of handy functionality.
 *
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public final class Noaber implements WithNoaber {

  /** Singleton instance of noaber */
  private static final WithNoaber singleton = new Noaber();

  /**
   * Shorthand for getting singleton instance of WithNoaber.
   * 
   * @return WithNoaber
   */
  public static WithNoaber $() {
    return singleton;
  }

  /**
   * Gets a WithNoaber instance.
   * 
   * @return WithNoaber
   */
  public static WithNoaber noaber() {
    return singleton;
  }

  /**
   * Not to be instantiated.
   */
  private Noaber() {
    // Do nothing.
  }

}
