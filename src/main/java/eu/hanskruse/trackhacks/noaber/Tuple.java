package eu.hanskruse.trackhacks.noaber;

import java.util.Iterator;

/**
 * Tuple is a generic readonly container for multiple fields of possible
 * different types.
 *
 */
public interface Tuple {

  /**
   * Gets a value of a specific index from the tuple.
   *
   * @param <R> return type of the selected field
   * @param i   {@code 0..n} index of the field to get
   * @return the selected field at position {@code i} in the tuple.
   * @throws IndexOutOfBoundsException thrown when i<0 or i>n where n is the last
   *                                   index of the Tuple
   */
  public <R> R get(int i);

  /**
   * Gets the number of elements of the {@link Tuple}.
   *
   * @return the number of elements of the {@Link Tuple}
   */
  public int size();

  public default <T> Iterable<T> asIterable() {
    return new Iterable<T>() {

      @Override
      public Iterator<T> iterator() {
        return new Iterator<T>() {
          int i = -1;

          @Override
          public boolean hasNext() {
            return i < size() - 1;
          }

          @Override
          public T next() {
            i++;
            return get(i);
          }
        };
      }
    };
  }
}
