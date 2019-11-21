package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 2 elements.
 * @param <T0> type of 0th element
 * @param <T1> type of 1th element 
 */
public abstract class Tuple2<T0,T1> extends BaseTuple {

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
      T1> Tuple2<T0,T1> of(//
          final T0 t0, //
          final T1 t1) {
    return new Tuple2<T0,T1>() {
      @SuppressWarnings("unchecked")
      @Override
      public <R> R get(final int i) {

        switch (i) {
        case 0:
          return (R) t0;
        case 1:
          return (R) t1;
        default:
          throw createIndexOutOfBoundsException(i, size());
        }
      }
    
      @Override
      public T0 get_0(){
        return t0;
      }

      @Override
      public T1 get_1(){
        return t1;
      }
    };
  }

  @Override
  public int size() {
    return 2;
  }

  /**
   * Gets the 0th element.
   */
  public abstract T0 get_0();
  
  /**
   * Gets the 1th element.
   */
  public abstract T1 get_1();

}
