package eu.hanskruse.trackhacks.noaber.tuples;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
  <R> R get(int i);

  /**
   * Gets the number of elements of the {@link Tuple}.
   *
   * @return the number of elements of the {@Link Tuple}
   */
  int size();

  /**
   * Gets the first element of the tuple
   *
   * @param <R> type to cast to.
   * @return first element of the tuple
   */
  default <R> R first() {
    return get(0);
  }

  /**
   * Gets the last element of the tuple
   *
   * @param <R> type to cast to.
   * @return the last element of the tuple
   */
  default <R> R last() {
    return get(size() - 1);
  }

  /**
   * Stream the tuple's values
   *
   * @param <T> type the values must be casted to.
   * @return stream of the tuple's values.
   */
  default <T> Stream<T> stream() {
    final Iterable<T> iterable = asIterable();
    return StreamSupport.stream(iterable.spliterator(), false);
  }

  /**
   * Return an iterable of the Tuple's values.
   *
   * @param <T> type the vlaues must be casted to.
   * @return stream of the tuple's values
   */
  default <T> Iterable<T> asIterable() {
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
