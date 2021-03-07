package eu.hanskruse.noaber.tuples;

/**
 * Tuple of 3 elements.
 *
 * @param <T0> type of 0th element
 * @param <T1> type of 1th element
 * @param <T2> type of 2th element
 */
public abstract class Tuple3<//
    T0, //
    T1, //
    T2> extends BaseTuple {
  private Tuple2<//
      T1, //
      T2>//
  tail = null;

  /**
   * Creates a {@link Tuple3} of 3 elements.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @return the created {@link Tuple3}
   */
  public static <//
      T0, //
      T1, //
      T2> Tuple3<//
          T0, //
          T1, //
          T2> of(//
              final T0 t0, //
              final T1 t1, //
              final T2 t2) {
    return new Tuple3<//
        T0, //
        T1, //
        T2>() {
      @SuppressWarnings("unchecked")
      @Override
      public <R> R get(int i) {
        switch (i) {
          case 0:
            return (R) t0;
          case 1:
            return (R) t1;
          case 2:
            return (R) t2;
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

      @Override
      public T2 get_2() {
        return t2;
      }

    };
  }

  @Override
  public int size() {
    return 3;
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
   * Gets the 2nd element.
   *
   * @return 2nd element
   */
  public abstract T2 get_2();

  /**
   * Gets a {@link Tuple2} with all the elements of this tuple skipping the first
   * one.
   *
   * @return the tail of this tuple as {@code Tuple2}
   */
  @Override
  public Tuple2<//
      T1, //
      T2>//
      tail() {
    if (null == tail) {
      tail = Tuple2.of(//
          this.get_1(), //
          this.get_2());
    }
    return tail;
  }
}
