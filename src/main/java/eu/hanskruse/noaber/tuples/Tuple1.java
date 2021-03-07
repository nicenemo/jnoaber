package eu.hanskruse.noaber.tuples;

/**
 * Tuple of 1 element.
 *
 * @param <T0> type of 0th element
 */
public abstract class Tuple1<//
    T0> extends BaseTuple {
  private enum Tuple0Holder {
    INSTANCE;

    final Tuple0 tuple0 = Tuple0.of();
  }

  /**
   * Creates a {@link Tuple1} of 1 element.
   *
   * @param <T0> type of 0th element
   *
   * @param t0   0th element
   * @return the created {@link Tuple1}
   */
  public static <//
      T0> Tuple1<//
          T0> of(//
              final T0 t0) {
    return new Tuple1<//
        T0>() {
      @SuppressWarnings("unchecked")
      @Override
      public <R> R get(int i) {
        switch (i) {
          case 0:
            return (R) t0;
          default:
            throw createIndexOutOfBoundsException(i, size());
        }
      }

      @Override
      public T0 get_0() {
        return t0;
      }

    };
  }

  @Override
  public int size() {
    return 1;
  }

  /**
   * Gets the 0th element.
   *
   * @return 0th element
   */
  public abstract T0 get_0();

  /**
   * Gets a {@link Tuple0} with all the elements of this tuple skipping the first
   * one.
   *
   * @return the tail of this tuple as {@code Tuple}
   */
  @Override
  public Tuple0 tail() {
    return Tuple0Holder.INSTANCE.tuple0;
  }
}
