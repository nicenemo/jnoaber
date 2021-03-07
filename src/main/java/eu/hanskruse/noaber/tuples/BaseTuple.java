package eu.hanskruse.noaber.tuples;

/**
 * Base class for Tuple implementations.
 */
public abstract class BaseTuple implements Tuple{

  /**
   * Creates a BaseTuple.
   */
  protected BaseTuple(){
    // do nothing
  }

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
}
