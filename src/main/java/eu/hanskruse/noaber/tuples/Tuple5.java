package eu.hanskruse.noaber.tuples;

/**
 * Tuple of 5 elements.
 *
 * @param <T0> type of 0th element
 * @param <T1> type of 1th element
 * @param <T2> type of 2th element
 * @param <T3> type of 3th element
 * @param <T4> type of 4th element
 */
public abstract class Tuple5<//
    T0, //
    T1, //
    T2, //
    T3, //
    T4> extends BaseTuple {
  private Tuple4<//
      T1, //
      T2, //
      T3, //
      T4>//
  tail = null;

  /**
   * Creates a {@link Tuple5} of 5 elements.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param <T3> type of 3th element
   * @param <T4> type of 4th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @param t3   3th element
   * @param t4   4th element
   * @return the created {@link Tuple5}
   */
  public static <//
      T0, //
      T1, //
      T2, //
      T3, //
      T4> Tuple5<//
          T0, //
          T1, //
          T2, //
          T3, //
          T4> of(//
              final T0 t0, //
              final T1 t1, //
              final T2 t2, //
              final T3 t3, //
              final T4 t4) {
    return new Tuple5<//
        T0, //
        T1, //
        T2, //
        T3, //
        T4>() {
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
          case 4:
            return (R) t4;
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

      @Override
      public T4 get_4() {
        return t4;
      }
    };
  }

  @Override
  public int size() {
    return 5;
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
   * Gets the 4th element.
   *
   * @return 4th element
   */
  public abstract T4 get_4();

  /**
   * Gets a {@link Tuple4} with all the elements of this tuple skipping the first
   * one.
   *
   * @return the tail of this tuple as {@code Tuple4}
   */
  @Override
  public Tuple4<//
      T1, //
      T2, //
      T3, //
      T4>//
      tail() {
    if (null == tail) {
      tail = Tuple4.of(//
          this.get_1(), //
          this.get_2(), //
          this.get_3(), //
          this.get_4());
    }
    return tail;
  }

}
