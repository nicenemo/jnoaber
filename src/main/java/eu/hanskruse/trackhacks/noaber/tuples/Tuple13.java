package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 13 elements.
 *
 * @param <T0>  type of 0th element
 * @param <T1>  type of 1th element
 * @param <T2>  type of 2th element
 * @param <T3>  type of 3th element
 * @param <T4>  type of 4th element
 * @param <T5>  type of 5th element
 * @param <T6>  type of 6th element
 * @param <T7>  type of 7th element
 * @param <T8>  type of 8th element
 * @param <T9>  type of 9th element
 * @param <T10> type of 10th element
 * @param <T11> type of 11th element
 * @param <T12> type of 12th element
 */
public abstract class Tuple13<//
    T0, //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    T7, //
    T8, //
    T9, //
    T10, //
    T11, //
    T12> extends BaseTuple {

  /**
   * Creates a {@link Tuple13} of 13 elements.
   *
   * @param <T0>  type of 0th element
   * @param <T1>  type of 1th element
   * @param <T2>  type of 2th element
   * @param <T3>  type of 3th element
   * @param <T4>  type of 4th element
   * @param <T5>  type of 5th element
   * @param <T6>  type of 6th element
   * @param <T7>  type of 7th element
   * @param <T8>  type of 8th element
   * @param <T9>  type of 9th element
   * @param <T10> type of 10th element
   * @param <T11> type of 11th element
   * @param <T12> type of 12th element
   * @param t0    0th element
   * @param t1    1th element
   * @param t2    2th element
   * @param t3    3th element
   * @param t4    4th element
   * @param t5    5th element
   * @param t6    6th element
   * @param t7    7th element
   * @param t8    8th element
   * @param t9    9th element
   * @param t10   10th element
   * @param t11   11th element
   * @param t12   12th element
   * @return the created {@link Tuple13}
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
      T8, //
      T9, //
      T10, //
      T11, //
      T12> Tuple13<//
          T0, //
          T1, //
          T2, //
          T3, //
          T4, //
          T5, //
          T6, //
          T7, //
          T8, //
          T9, //
          T10, //
          T11, //
          T12> of(//
              final T0 t0, //
              final T1 t1, //
              final T2 t2, //
              final T3 t3, //
              final T4 t4, //
              final T5 t5, //
              final T6 t6, //
              final T7 t7, //
              final T8 t8, //
              final T9 t9, //
              final T10 t10, //
              final T11 t11, //
              final T12 t12) {
    return new Tuple13<//
        T0, //
        T1, //
        T2, //
        T3, //
        T4, //
        T5, //
        T6, //
        T7, //
        T8, //
        T9, //
        T10, //
        T11, //
        T12>() {
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
        case 9:
          return (R) t9;
        case 10:
          return (R) t10;
        case 11:
          return (R) t11;
        case 12:
          return (R) t12;
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

      @Override
      public T9 get_9() {
        return t9;
      }

      @Override
      public T10 get_10() {
        return t10;
      }

      @Override
      public T11 get_11() {
        return t11;
      }

      @Override
      public T12 get_12() {
        return t12;
      }
    };
  }

  @Override
  public int size() {
    return 13;
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

  /**
   * Gets the 9th element.
   *
   * @return 9th element
   */
  public abstract T9 get_9();

  /**
   * Gets the 10th element.
   *
   * @return 10th element
   */
  public abstract T10 get_10();

  /**
   * Gets the 11th element.
   *
   * @return 11th element
   */
  public abstract T11 get_11();

  /**
   * Gets the 12th element.
   *
   * @return 12th element
   */
  public abstract T12 get_12();

}
