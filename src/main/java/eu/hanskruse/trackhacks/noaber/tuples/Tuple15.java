package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 15 elements.
 */
public abstract class Tuple15 extends BaseTuple {

  /**
   * Creates a {@link Tuple15}.
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
   * @param <T13> type of 13th element
   * @param <T14> type of 14th element
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
   * @param t13   13th element
   * @param t14   14th element
   * @return the created {@link Tuple15}
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
      T12, //
      T13, //
      T14> Tuple15 of(//
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
          final T12 t12, //
          final T13 t13, //
          final T14 t14) {
    return new Tuple15() {
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
        case 13:
          return (R) t13;
        case 14:
          return (R) t14;
        default:
          throw createIndexOutOfBoundsException(i, size());
        }
      }

      @Override
      public T0 head(){
        return t0;
      }
    };
  }

    @Override
    public int size() {
      return 15;
    }
}
