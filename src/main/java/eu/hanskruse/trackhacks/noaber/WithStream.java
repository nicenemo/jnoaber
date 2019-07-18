package eu.hanskruse.trackhacks.noaber;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.AbstractMap.SimpleEntry;

/**
 * Stream functionality.
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 */
public interface WithStream {

  /**
   * Convert a varargs array to a stream.
   *
   * @param items
   *          items to convert
   * @return the converted stream
   */
  default DoubleStream stream(final double... items) {
    return Arrays.stream(items);
  }

  /**
   * Convert a varargs array to a stream.
   *
   * @param items
   *          items to convert
   * @return the converted stream
   */
  default IntStream stream(final int... items) {
    return Arrays.stream(items);
  }

  /**
   * Convert a varargs array to a stream.
   *
   * @param items
   *          items to convert
   * @return the converted stream
   */
  default LongStream stream(final long... items) {
    return Arrays.stream(items);
  }

  /**
   * Convert a varargs array to a stream.
   *
   * @param items
   *          items to convert
   * @return the converted stream
   */
  @SuppressWarnings("unchecked")
  default <T> Stream<T> stream(final T... items) {
    return Arrays.stream(items);
  }

  /**
   * Combine two streams. Similar to Scala's for comprehension or .NET LINQ's from clause.
   * @param <T1> type of the first stream
   * @param <T2> type of the seconds stream
   * @param s1 the first stream
   * @param s2 the second stream
   * @return combined stream
   */
  default <T1,T2> Stream<SimpleEntry<T1,T2>> stream(final Stream<T1> s1, final Stream<T2> s2){
    return stream(s1,s2, SimpleEntry::new);
  }

  /**
   * Combine two streams. Similar to Scala's for comprehension or .NET LINQ's from clause.
    @param <T1> type of the first stream
   * @param <T2> type of the seconds stream
   * @param s1 the first stream
   * @param s2 the second stream
   * @param mapper a mapper function that combines values from the two streams
   * @return combined stream
   */
  default <T1,T2,R> Stream<R> stream(final Stream<T1> s1, final Stream<T2> s2, final BiFunction<T1,T2,R> mapper){
    return s1.flatMap(t1 -> s2.map(t2 -> mapper.apply(t1, t2)));
  }

  /**
   * Combine two streams. Similar to Scala's for comprehension or .NET LINQ's from clause.
    @param <T1> type of the first stream
   * @param <T2> type of the seconds stream
   * @param s1 the first stream
   * @param s2 the second stream
   * @param p a {@code BiPredicate} predicate to filter out unwanted values
   * @param mapper a mapper function that combines values from the two streams
   * @return combined stream
   */
  default <T1,T2,R> Stream<R> stream(final Stream<T1> s1,final Stream<T2> s2,final BiPredicate<T1,T2> p, final BiFunction<T1,T2,R> mapper){
    return s1.flatMap(t1 -> s2.filter( t2-> p.test(t1, t2)).map(t2 -> mapper.apply(t1, t2)));
  }
}
