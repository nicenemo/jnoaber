package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 9 elements.
 *
 * @param <T0> type of 0th element
 * @param <T1> type of 1th element
 * @param <T2> type of 2th element
 * @param <T3> type of 3th element
 * @param <T4> type of 4th element
 * @param <T5> type of 5th element
 * @param <T6> type of 6th element
 * @param <T7> type of 7th element
 * @param <T8> type of 8th element
 */
public abstract class Tuple9<//
    T0, //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    T7, //
    T8> extends BaseTuple {

  /**
   * Creates a {@link Tuple9} of 9 elements.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param <T3> type of 3th element
   * @param <T4> type of 4th element
   * @param <T5> type of 5th element
   * @param <T6> type of 6th element
   * @param <T7> type of 7th element
   * @param <T8> type of 8th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @param t3   3th element
   * @param t4   4th element
   * @param t5   5th element
   * @param t6   6th element
   * @param t7   7th element
   * @param t8   8th element
   * @return the created {@link Tuple9}
   */
  public static <//
      T0, //
      T1, //
      T2, //
      T3, //
      T4, //
      T5, //
      T6, //
      T7, //
      T8> Tuple9<//
          T0, //
          T1, //
          T2, //
          T3, //
          T4, //
          T5, //
          T6, //
          T7, //
          T8> of(//
              final T0 t0, //
              final T1 t1, //
              final T2 t2, //
              final T3 t3, //
              final T4 t4, //
              final T5 t5, //
              final T6 t6, //
              final T7 t7, //
              final T8 t8) {
    return new Tuple9<//
        T0, //
        T1, //
        T2, //
        T3, //
        T4, //
        T5, //
        T6, //
        T7, //
        T8>() {
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
        case 6:
          return (R) t6;
        case 7:
          return (R) t7;
        case 8:
          return (R) t8;
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

      @Override
      public T6 get_6() {
        return t6;
      }

      @Override
      public T7 get_7() {
        return t7;
      }

      @Override
      public T8 get_8() {
        return t8;
      }
    };
  }

  @Override
  public int size() {
    return 9;
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

  /**
   * Gets the 6th element.
   *
   * @return 6th element
   */
  public abstract T6 get_6();

  /**
   * Gets the 7th element.
   *
   * @return 7th element
   */
  public abstract T7 get_7();

  /**
   * Gets the 8th element.
   *
   * @return 8th element
   */
  public abstract T8 get_8();
}
