package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 9 elements.
 */
public abstract class Tuple9 extends BaseTuple {

  /**
   * Creates a {@link Tuple9}.
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
      T8> Tuple9 of(//

          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4, //
          final T5 t5, //
          final T6 t6, //
          final T7 t7, //
          final T8 t8) {
    return new Tuple9() {
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
    };
  }

  @Override
  public int size() {
    return 9;
  }
}
