package eu.hanskruse.noaber.tuples;

import java.util.NoSuchElementException;

/**
 * Tuple of 0 elements.
 *
 */
public abstract class Tuple0 extends BaseTuple {

  /**
   * Creates a {@link Tuple0} of 0 elements.
   *
   * @return the created {@link Tuple0}
   */
  public static Tuple0 of() {
    return new Tuple0() {
      @Override
      public <R> R get(int i) {
        throw createIndexOutOfBoundsException(i, size());
      }
    };
  }

  @Override
  public int size() {
    return 0;
  }

  /**
   * Always throws a {@link NoSuchElementException}.
   *  {@code Tuple0} has n0 elements.
   */
  @Override
  public <R> R head() {
    throw new NoSuchElementException("Tuple0 has no first helement. It has no elements");
  }

  /**
   * Gets a {@link Tuple} with all the elements of this tuple skipping the first
   * one.
   *
   * @return the tail of this tuple as {@code Tuple}
   */
  @Override
  public Tuple tail() {
    throw new UnsupportedOperationException("Tuple0 has no elements.");
  }

   /**
   * Whether the {@code Tuple} is empty. This is always {@code true}.
   *
   * @return {@code true}
   */
  @Override
  public boolean isEmpty() {
    return true;
  }

  /**
   * Convert this {@code Tuple} to an {@code Object[]}.
   * @return an {@code Object[]} representation of this {@code Tuple}.
   */
  @Override
  public Object[] toArray() {
    return new Object[]{};
  }

   /**
   * Convert this {@code Tuple} to an {@code Object[]}.
   * @return an {@code Object[]} representation of this {@code Tuple}.
   */
  /***
  *  Fill an array with the elements of this {@code Tuple}.
   * @param <T> type of the provided array
   * @param arr the array to file
   * @return arr filled with the elements of the tuple or a new array with the elements of the tuple if the provided array was too small.
   */
  @Override
  public <T >T[] toArray(T[] arr) {
    return arr;
  }
}
