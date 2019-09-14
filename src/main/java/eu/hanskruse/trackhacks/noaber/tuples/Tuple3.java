package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 3 elements.
 */
public abstract class Tuple3 extends BaseTuple {

  /**
   * Creates a {@link Tuple3}.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @return the created {@link Tuple3}
   */
  public static <//
      T0, //
      T1, //
      T2> Tuple3 of(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2) {
    return new Tuple3() {

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
    return 3;
  }
}
