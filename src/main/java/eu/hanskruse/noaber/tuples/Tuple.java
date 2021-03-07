package eu.hanskruse.noaber.tuples;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;
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
   * @throws IndexOutOfBoundsException thrown when i &lt; 0 or i &gt; n where n is
   *                                   the last index of the Tuple
   */
  <R> R get(int i);

  /**
   * Gets the number of elements of the {@link Tuple}.
   *
   * @return the number of elements of the {@link Tuple}
   */
  int size();

  /**
   * Gets the first element of the tuple
   *
   * @param <R> type to cast to.
   * @return first element of the tuple
   */
  default <R> R head() {
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
   * @param <T> type the values must be casted to.
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
            return (i + 1) < size();
          }

          @Override
          public T next() {
            if (!hasNext()) {
              throw new NoSuchElementException("Trying to move beyound tuple size of " + size());
            }

            i++;
            return get(i);
          }
        };
      }
    };
  }

  /**
   * Gets a {@link Tuple} with all the elements of this tuple skipping the first
   * one.
   *
   * @return the tail of this tuple as {@code Tuple}
   */
  Tuple tail();

  /**
   * Whether the {@code Tuple} is empty. This is always {@code false} except for
   * {@link Tuple0} where it is always true.
   *
   * @return {@code false}
   */
  default boolean isEmpty() {
    return false;
  }

  /**
   * Convert this {@code Tuple} to an {@code Object[]}.
   *
   * @return an {@code Object[]} representation of this {@code Tuple}.
   */
  default Object[] toArray() {
    final Object[] result = new Object[size()];
    for (int i = 0; i < size(); i++) {
      result[i] = get(i);
    }
    return result;
  }

  /**
   * Convert this {@code Tuple} to an {@code Object[]}.
   *
   * @return an {@code Object[]} representation of this {@code Tuple}.
   */
  /***
   * Fill an arrat with the elements of this {@code Tuple}.
   *
   * @param <T> type of the provided array
   * @param arr the array to file
   * @return arr filled with the elements of the tuple or a new array with the
   *         elements of the tuple if the provided array was too small.
   */
  default <T> T[] toArray(T[] arr) {
    if (null == arr) {
      throw new NullPointerException("Argument arr should not be null");
    }
    if (arr.length < size()) {

      arr = (T[]) Array.newInstance(arr.getClass().getComponentType(), size());
    }
    for (int i = 0; i < size(); i++) {

      T value = (T) get(i);
      arr[i] = value;
    }
    return arr;
  }
}
