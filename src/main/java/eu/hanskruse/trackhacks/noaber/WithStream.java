package eu.hanskruse.trackhacks.noaber;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public interface WithStream {

  /**
   * Convert a varargs array to a stream.
   * 
   * @param items
   *            items to convert
   * @return the converted stream
   */
  public static DoubleStream stream(final double... items) {
      return Arrays.stream(items);
  }

  /**
   * Convert a varargs array to a stream.
   * 
   * @param items
   *            items to convert
   * @return the converted stream
   */
  public static IntStream stream(final int... items) {
      return Arrays.stream(items);
  }

  /**
   * Convert a varargs array to a stream.
   * 
   * @param items
   *            items to convert
   * @return the converted stream
   */
  public static LongStream stream(final long... items) {
      return Arrays.stream(items);
  }

  /**
   * Convert a varargs array to a stream.
   * 
   * @param items
   *            items to convert
   * @return the converted stream
   */
  @SuppressWarnings("unchecked")
  public static <T> Stream<T> stream(final T... items) {
      return Arrays.stream(items);
  }

}
