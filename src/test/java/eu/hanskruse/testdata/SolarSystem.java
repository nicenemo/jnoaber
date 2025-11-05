package eu.hanskruse.testdata;

import java.util.Optional;

/**
 * Sample 'predicates' for testing the kaas function overloads that results in optional values.
 *
 * @author hans kruse
 */
public final class SolarSystem {

  /**
   * Check whether this is the planet Earth.
   *
   * @param p
   *          Planet to check
   * @return Optional String value if true, else Optional.Empty.
   */
  public static Optional<String> Earth(final Planet p) {
    return p == Planet.EARTH ? Optional.of(p.toString()) : Optional.empty();
  }

  /**
   * Check whether p is the planet Jupiter.
   *
   * @param p
   *          Planet to check
   * @return Optional String value if true, else Optional.Empty.
   */
  public static Optional<String> Jupiter(final Planet p) {
    return p == Planet.JUPITER ? Optional.of(p.toString()) : Optional.empty();
  }

  /**
   * Check whether this is the planet Mars.
   *
   * @param p
   *          Planet to check
   * @return Optional String value if true, else Optional.Empty.
   */
  public static Optional<String> Mars(final Planet p) {
    return p == Planet.MARS ? Optional.of(p.toString()) : Optional.empty();
  }

  /**
   * Check whether this is the planet Mercurius.
   *
   * @param p
   *          Planet to check
   * @return Optional String value if true, else Optional.Empty.
   */
  public static Optional<String> Mercurius(final Planet p) {
    return p == Planet.MERCURIUS ? Optional.of(p.toString()) : Optional.empty();
  }

  /**
   * Check whether p is the planet Neptune.
   *
   * @param p
   *          Planet to check
   * @return Optional String value if true, else Optional.Empty.
   */
  public static Optional<String> Neptune(final Planet p) {
    return p == Planet.NEPTUNE ? Optional.of(p.toString()) : Optional.empty();
  }

  /**
   * Check whether p is the planet Pluto.
   *
   * @param p
   *          Planet to check
   * @return Optional String value if true, else Optional.Empty.
   */
  public static Optional<String> Pluto(final Planet p) {
    return p == Planet.PLUTO ? Optional.of(p.toString()) : Optional.empty();
  }

  /**
   * Check whether this is the planet Saturn.
   *
   * @param p
   *          Planet to check
   * @return Optional String value if true, else Optional.Empty.
   */
  public static Optional<String> Saturn(final Planet p) {
    return p == Planet.SATURN ? Optional.of(p.toString()) : Optional.empty();
  }

  /**
   * Check whether p is the planet Uranus.
   *
   * @param p
   *          Planet to check
   * @return Optional String value if true, else Optional.Empty.
   */
  public static Optional<String> Uranus(final Planet p) {
    return p == Planet.URANUS ? Optional.of(p.toString()) : Optional.empty();
  }

  /**
   * Check whether this is the planet Venus.
   *
   * @param p
   *          Planet to check
   * @return Optional String value if true, else Optional.Empty.
   */
  public static Optional<String> Venus(final Planet p) {
    return p == Planet.VENUS ? Optional.of(p.toString()) : Optional.empty();
  }

  /**
   * Do not instantiate.
   */
  private SolarSystem() {
    // do nothing
  }
}
