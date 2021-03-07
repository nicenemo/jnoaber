package eu.hanskruse.noaber.tuples;

/**
 * Tuple of 4 elements.
 *
 * @param <T0> type of 0th element
 * @param <T1> type of 1th element
 * @param <T2> type of 2th element
 * @param <T3> type of 3th element
 */
public abstract class Tuple4<//
    T0, //
    T1, //
    T2, //
    T3> extends BaseTuple {
  private Tuple3<//
      T1, //
      T2, //
      T3>//
  tail = null;

  /**
   * Creates a {@link Tuple4} of 4 elements.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param <T3> type of 3th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @param t3   3th element
   * @return the created {@link Tuple4}
   */
  public static <//
      T0, //
      T1, //
      T2, //
      T3> Tuple4<//
          T0, //
          T1, //
          T2, //
          T3> of(//
              final T0 t0, //
              final T1 t1, //
              final T2 t2, //
              final T3 t3) {
    return new Tuple4<//
        T0, //
        T1, //
        T2, //
        T3>() {
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
          case 3:
            return (R) t3;
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

      @Override
      public T3 get_3() {
        return t3;
      }

    };
  }

  @Override
  public int size() {
    return 4;
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
   * Gets the 3th element.
   *
   * @return 3th element
   */
  public abstract T3 get_3();

  /**
   * Gets a {@link Tuple3} with all the elements of this tuple skipping the first
   * one.
   *
   * @return the tail of this tuple as {@code Tuple3}
   */
  @Override
  public Tuple3<//
      T1, //
      T2, //
      T3>//
      tail() {
    if (null == tail) {
      tail = Tuple3.of(//
          this.get_1(), //
          this.get_2(), //
          this.get_3());
    }
    return tail;
  }
}
