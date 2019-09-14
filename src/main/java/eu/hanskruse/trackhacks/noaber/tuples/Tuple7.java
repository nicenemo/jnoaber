package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 7 elements.
 */
public abstract class Tuple7 extends BaseTuple {

  /**
   * Creates a {@link Tuple7}.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param <T3> type of 3th element
   * @param <T4> type of 4th element
   * @param <T5> type of 5th element
   * @param <T6> type of 6th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @param t3   3th element
   * @param t4   4th element
   * @param t5   5th element
   * @param t6   6th element
   * @return the created {@link Tuple7}
   */
  public static <//
      T0, //
      T1, //
      T2, //
      T3, //
      T4, //
      T5, //
      T6> Tuple7 of(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4, //
          final T5 t5, //
          final T6 t6) {
    return new Tuple7() {
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
        default:
          throw createIndexOutOfBoundsException(i, size());
        }
      }
    };
  }

  @Override
  public int size() {
    return 7;
  }
}
