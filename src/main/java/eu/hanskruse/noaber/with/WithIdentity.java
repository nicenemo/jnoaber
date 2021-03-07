package eu.hanskruse.noaber.with;

/**
 * Identity functionality.
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 */
public interface WithIdentity {

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default boolean identity(final boolean argument) {
    return argument;
  }

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default boolean[] identity(final boolean[] argument) {
    return argument;
  }

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default double identity(final double argument) {
    return argument;
  }

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default double[] identity(final double[] argument) {
    return argument;
  }

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default float identity(final float argument) {
    return argument;
  }

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default float[] identity(final float[] argument) {
    return argument;
  }

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default int identity(final int argument) {
    return argument;
  }

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default int[] identity(final int[] argument) {
    return argument;
  }

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default long identity(final long argument) {
    return argument;
  }

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default long[] identity(final long[] argument) {
    return argument;
  }

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default short identity(final short argument) {
    return argument;
  }

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default short[] identity(final short[] argument) {
    return argument;
  }

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default String identity(final String argument) {
    return argument;
  }

  /**
   * Identity function that only returns it's arguments.
   *
   * @param argument
   *          the argument to return
   * @return argument
   */
  default String[] identity(final String[] argument) {
    return argument;
  }

  /**
   * Identity Function that only returns its arguments.
   * @param <T>  type of argument
   * @param argument
   *          argument to return
   * @return argument
   */
  default <T> T identity(final T argument) {
    return argument;
  }
}
