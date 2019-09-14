package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 4 elements.
 */
public abstract class Tuple4 extends BaseTuple {

  /**
   * Creates a {@link Tuple4}.
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
      T3> Tuple4 of(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3) {
    return new Tuple4() {
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
      public T0 head(){
        return t0;
      }
    };
  }

  @Override
  public int size() {
    return 4;
  }
}
