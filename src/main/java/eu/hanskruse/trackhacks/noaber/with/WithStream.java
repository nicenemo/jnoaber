package eu.hanskruse.trackhacks.noaber.with;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


/**
 * Stream functionality.
 *
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 */
public interface WithStream {

  /**
   * Convert a varargs array to a stream.
   *
   * @param items items to convert
   * @return the converted stream
   */
  default DoubleStream stream(final double... items) {
    return Arrays.stream(items);
  }

  /**
   * Convert a varargs array to a stream.
   *
   * @param items items to convert
   * @return the converted stream
   */
  default IntStream stream(final int... items) {
    return Arrays.stream(items);
  }

  /**
   * Convert a varargs array to a stream.
   *
   * @param items items to convert
   * @return the converted stream
   */
  default LongStream stream(final long... items) {
    return Arrays.stream(items);
  }

  /**
   * Convert a varargs array to a stream.
   *
   * @param items items to convert
   * @return the converted stream
   */
  @SuppressWarnings("unchecked")
  default <T> Stream<T> stream(final T... items) {
    return Arrays.stream(items);
  }

  /**
   * Turns an {@code Iterable} of {@code T} into a {@code Stream} of {@code T}
   *
   * @param <T> the type of the elements of the {@code Iterable} and resulting
   *            {@code Stream}.
   * @param i   the {@code Iterable} of {@code T}
   * @return the resulting {@code Stream} of {@code T}
   */
  default <T> Stream<T> stream(Iterable<T> i) {
    return StreamSupport.stream(i.spliterator(), false);
  }

  /**
   * Turns an {@code Iterable} of {@code T} into a parallel {@code Stream} of
   * {@code T}
   *
   * @param <T> the type of the elements of the {@code Iterable} and resulting
   *            {@code Stream}.
   * @param i   the {@code Iterable} of {@code T}
   * @return the resulting {@code Stream} of {@code T}
   */
  default <T> Stream<T> streamParallel(Iterable<T> i) {
    return StreamSupport.stream(i.spliterator(), true);
  }
}
