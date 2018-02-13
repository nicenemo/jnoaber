package eu.hanskruse.trackhacks.noaber;

import static eu.hanskruse.trackhacks.noaber.WithStream.stream;

import java.util.Optional;
import java.util.function.BinaryOperator;

public interface WithMapReduce {
  /**
   * Reduce a number of items.
   * 
   * @param accumulator
   *            the reducing operator
   * @param items
   *            the items to be reduced
   * @return the reduced value
   */
  public static <T> T reduce(final BinaryOperator<T> accumulator, @SuppressWarnings("unchecked") final T... items) {
      Optional<T> result = stream(items).reduce(accumulator);
      if (result.isPresent()) {
          return result.get();
      }
      throw new IllegalStateException(
              String.format("reducing with binary operator %s failed", accumulator.getClass().getCanonicalName()));
  }

  /**
   * Reduce a number of items.
   * 
   * @param identity
   *            the identity, e.g. 0 for addition, 1 for multiplication.
   * @param accumulator
   *            the reducing operator
   * @param items
   *            the items to be reduced
   * @return reduced value
   */
  public static <T> T reduce(final T identity, final BinaryOperator<T> accumulator,
          @SuppressWarnings("unchecked") final T... items) {
      return stream(items).reduce(identity, accumulator);
  }

}
