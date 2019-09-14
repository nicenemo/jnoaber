package eu.hanskruse.trackhacks.noaber.tuples;

public abstract class BaseTuple<T0> implements Tuple{
    /**
   * Helper method to create a {@link java.lang.IndexOutOfBoundException} for use
   * when not {@code} 0 lt; index lt; Tuple.size()} is used with
   * {@code Tuple.get()}. Consider private.
   *
   * @param i    the index tried to get
   * @param size the size of the Tuple
   * @return an {@code java.lang.IndexOutOfBoundsException}
   */
  protected static IndexOutOfBoundsException createIndexOutOfBoundsException(int i, int size) {
    return new IndexOutOfBoundsException(i + " is out of bounds for this tuple, use 0.." + (size - 1) + " inclusive.");
  }
  /**
   * Returns the first element of the tuple.
   * @return the first element o the tuple
   */
  public abstract T0 head();
}
