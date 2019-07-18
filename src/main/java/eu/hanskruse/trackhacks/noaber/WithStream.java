package eu.hanskruse.trackhacks.noaber;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.AbstractMap.SimpleEntry;

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
   * Combine two streams. Similar to Scala's for comprehension or .NET LINQ's from
   * clause. We use {@code Supplier}s because a {@code Stream} can be consumed
   * only once.
   * 
   * @param <T0> type of the 0th stream
   * @param <T1> type of the 1th stream
   * @param s0   the 0th stream supplier
   * @param s1   the 1th stream supplier
   * @return combined stream
   */
  default <T0, T1> Stream<Tuple> stream(final Supplier<Stream<T0>> s0, final Supplier<Stream<T1>> s1) {
    return s0.get().flatMap(t0 -> s1.get().map(t1 -> Tuple.of(t0, t1)));
  }
/*
  default <//
      T0, //
      T1, //
      T2> //
  Stream<Tuple> stream(//
      final Supplier<Stream<T1>> s0, //
      final Supplier<Stream<T1>> s1, //
      final Supplier<Stream<T2>> s2) {
    return s0.get().flatMap(t0 -> s1.get().flatMap(t1 -> s2.get().map(t2 -> Tuple.of(t0, t1, t2))));
      }*/
/*
  default <//
      T0, //
      T1, //
      T2, //
      T3> //
  Stream<Tuple> stream(//
      final Supplier<Stream<T1>> s0, //
      final Supplier<Stream<T1>> s1, //
      final Supplier<Stream<T2>> s2, //
      final Supplier<Stream<T3>> s3) {
    return s0.get()
        .flatMap(t0 -> s1.get().flatMap(t1 -> s2.get().flatMap(t2 -> s3.get().map(t3 -> Tuple.of(t0, t1, t2, t3)))));
  }*/
}
