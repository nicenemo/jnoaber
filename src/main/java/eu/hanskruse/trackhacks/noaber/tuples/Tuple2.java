package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 2 elements.
 */
public abstract class Tuple2 extends BaseTuple {

  /**
   * Creates a {@link Tuple2}.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param t0   0th element
   * @param t1   1th element
   * @return the created {@link Tuple2}
   */
  public static <//
      T0, //
      T1, //
      T2> Tuple2 of(//
          final T0 t0, //
          final T1 t1) {
    return new Tuple2() {
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
    };
  }

  @Override
  public int size() {
    return 2;
  }
}
