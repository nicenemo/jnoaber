package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 6 elements.
 *
 * @param <T0> type of 0th element
 * @param <T1> type of 1th element
 * @param <T2> type of 2th element
 * @param <T3> type of 3th element
 * @param <T4> type of 4th element
 * @param <T5> type of 5th element
 */
public abstract class Tuple6<//
    T0, //
    T1, //
    T2, //
    T3, //
    T4, //
    T5> extends BaseTuple {

  /**
   * Creates a {@link Tuple6} of 6 elements.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param <T3> type of 3th element
   * @param <T4> type of 4th element
   * @param <T5> type of 5th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @param t3   3th element
   * @param t4   4th element
   * @param t5   5th element
   * @return the created {@link Tuple6}
   */
  public static <//
      T0, //
      T1, //
      T2, //
      T3, //
      T4, //
      T5> Tuple6<//
          T0, //
          T1, //
          T2, //
          T3, //
          T4, //
          T5> of(//
              final T0 t0, //
              final T1 t1, //
              final T2 t2, //
              final T3 t3, //
              final T4 t4, //
              final T5 t5) {
    return new Tuple6<//
        T0, //
        T1, //
        T2, //
        T3, //
        T4, //
        T5>() {
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
        case 5:
          return (R) t5;
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

      @Override
      public T5 get_5() {
        return t5;
      }
    };
  }

  @Override
  public int size() {
    return 6;
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
   * Gets the 5th element.
   *
   * @return 5th element
   */
  public abstract T5 get_5();

}
