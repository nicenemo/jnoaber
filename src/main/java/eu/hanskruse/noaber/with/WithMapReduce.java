package eu.hanskruse.noaber.with;

import static eu.hanskruse.noaber.Noaber.$;

import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * Map Reduce functionality.
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 */
public interface WithMapReduce {

  /**
   * Reduce a number of items.
   * @param <T> type of items
   * @param accumulator
   *          the reducing operator
   * @param items
   *          the items to be reduced
   * @return the reduced value
   */
  default <T> T reduce(final BinaryOperator<T> accumulator, @SuppressWarnings("unchecked") final T... items) {
    final Optional<T> result = $.stream(items).reduce(accumulator);
    if (result.isPresent()) {
      return result.get();
    }
    throw new IllegalStateException(
        String.format("reducing with binary operator %s failed", accumulator.getClass().getCanonicalName()));
  }

  /**
   * Reduce a number of items.
   * @param <T> type of items
   * @param identity
   *          the identity, e.g. 0 for addition, 1 for multiplication.
   * @param accumulator
   *          the reducing operator
   * @param items
   *          the items to be reduced
   * @return reduced value
   */
  default <T> T reduce(final T identity, final BinaryOperator<T> accumulator,
      @SuppressWarnings("unchecked") final T... items) {
    return $.stream(items).reduce(identity, accumulator);
  }

}
