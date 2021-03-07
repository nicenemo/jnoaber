package eu.hanskruse.noaber.tuples;

/**
 * Tuple of 2 elements.
 *
 * @param <T0> type of 0th element
 * @param <T1> type of 1th element
 */
public abstract class Tuple2<//
    T0, //
    T1> extends BaseTuple {
  private Tuple1<//
      T1>//
  tail = null;

  /**
   * Creates a {@link Tuple2} of 2 elements.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   *
   * @param t0   0th element
   * @param t1   1th element
   * @return the created {@link Tuple2}
   */
  public static <//
      T0, //
      T1> Tuple2<//
          T0, //
          T1> of(//
              final T0 t0, //
              final T1 t1) {
    return new Tuple2<//
        T0, //
        T1>() {
      @SuppressWarnings("unchecked")
      @Override
      public <R> R get(int i) {
        switch (i) {
          case 0:
            return (R) t0;
          case 1:
            return (R) t1;
          default:
            throw createIndexOutOfBoundsException(i, size());
        }
      }

      @Override
      public T0 get_0() {
        return t0;
      }

      @Override
      public T1 get_1() {
        return t1;
      }

    };
  }

  @Override
  public int size() {
    return 2;
  }

  /**
   * Gets the 0th element.
   *
   * @return 0th element
   */
  public abstract T0 get_0();

  /**
   * Gets the 1st element.
   *
   * @return 1st element
   */
  public abstract T1 get_1();

  /**
   * Gets a {@link Tuple1} with all the elements of this tuple skipping the first
   * one.
   *
   * @return the tail of this tuple as {@code Tuple1}
   */
  @Override
  public Tuple1<T1> tail() {
    if (null == tail) {
      tail = Tuple1.of(this.get_1());
    }
    return tail;
  }

}
