package eu.hanskruse.trackhacks.noaber;

import java.util.stream.*;

/**
 * An {@code FunctionalInterface} for providing a stream. Java's {@code Stream}
 * can only be iterated once.It is more like an enhanced {@code Iterator} than
 * an enhanced {@code iterable}. For doing something Scala like for
 * comprehension or LINQ you need this. It allows you to do nested lazy
 * iterations over multiple Streams.
 *
 * @param <R> type of the {@code Stream}.
 */
@FunctionalInterface
public interface Streamable<R> {
  /**
   * Get's a {@code Stream} to be iterated.
   * 
   * @return the stream to be iterated.
   */
  Stream<R> stream();
}
