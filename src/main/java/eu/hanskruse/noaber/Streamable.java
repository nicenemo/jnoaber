package eu.hanskruse.noaber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import java.util.stream.Stream;

/**
* The "stateless" companion to {@link java.util.stream.Stream}. While for
* {@code Iterator} there is a {@code Iterable} no such thing exists for
* {@code Stream} in the JDK. This provides such a type. Currently it lifts
* {@code filter(...)}, {@code map(...)} and {@code flatMap(...)} of
* {@code Stream} into itself.
*
* REMARK: in future iterations more functions of {@code Stream} may be lifted
* into this type.
*
* @param <T> type of the {@link Streamable}'s {@code Stream} elements.
*/
@FunctionalInterface
public interface Streamable<T> {

  /**
  * Gets a "fresh" {@code Stream} of {@code T}.
  *
  * @return the {@code Stream} of {@code T}
  */
  Stream<T> stream();

  default Streamable<T> filter(Predicate<? super T> predicate) {
    return () -> this.stream().filter(predicate);
  }

  /**
  * Lazily maps over the elements given the provided mapping function.
  *
  * @param <R>    return type of the elements to be provided by the
  *               {@code Stream} of the returned {@code Streamable}
  * @param mapper mapping function
  * @return a {@code Streamable} that returns a {@code Stream} of {@code R}
  */
  default <R> Streamable<R> map(Function<? super T, ? extends R> mapper) {
    return () -> this.stream().map(mapper);
  }

  /**
  * Lazily maps over the elements given the provided flat mapping function.
  *
  * @param <R>    return type of the elements to be provided by the
  *               {@code Stream} of the returned {@code Streamable}
  * @param mapper mapping function.
  * @return {@code Streamable} that returns a {@code Stream} of {@code R}
  */
  default <R> Streamable<R> flatMap(Function<? super T, ? extends Streamable<? extends R>> mapper) {
    return () -> this.stream().flatMap(streamable -> mapper.apply(streamable).stream());
  }

  /**
  * Concatenenats streameables.
  *
  * @param streamables streamables to be concatenated
  * @return streamable consisting of the concatenation of streamables
  */
  default Streamable<T> concat(Streamable<T>... streamables) {
    return Streamable.concat(this, streamables);
  }

  /**
  * Concatenate Streamables.
  *
  * @param <T1> type of {@code Streamable}s in tail
  * @param head first streamable
  * @param tail other streameables to be concatenated to the head.
  * @return streamable consisting of the concatenation of streamables
  */
  static <T1> Streamable<T1> concat(Streamable<T1> head, Streamable<T1>... tail) {
    return () -> {
      final Streamable<T1> seed = head == null ? Stream::empty : head;
      final Stream<Streamable<T1>> xs = tail == null ? Stream.empty() : Arrays.stream(tail);
      return xs.filter(x -> x != null).map(Streamable::stream).collect(seed::stream, Stream::concat, Stream::concat);
    };
  }

  /**
  * Filters a {@link Streamable} in to a {@link Streamable} of distinct values.
  *
  * @return {@link Streamable} of distinct values.
  */
  default Streamable<T> distinct() {
    return () -> this.stream().distinct();
  }

  /**
  * Limits the {@link Streamable} to {@code maxSize} elements.
  *
  * @param maxSize the maximum number of elements to return
  * @return a {@link Streamable} of {@code maxSize} elements
  */
  default Streamable<T> limit(long maxSize) {
    return () -> this.stream().limit(maxSize);
  }

  /**
  * Parallelizes the {@link java.util.stream.Stream} provided by this
  * {@link Streamable}.
  *
  * @return a {@link Streamable} that provides a parallel
  *         {@link java.util.stream.Stream}
  */
  default Streamable<T> parallel() {
    return () -> this.stream().parallel();
  }

  /**
  * Inserts an action into the stream execution. The action does have no effect
  * on the processing of the stream except for being able to abort it with an
  * exception, running for ever, consuming processing and memory.
  *
  * @param action the action to insert
  * @return a {@link Streamable} with the action inserted into the processing of
  *         the {@link java.util.stream.Stream}.
  */
  default Streamable<T> peek(Consumer<? super T> action) {
    return () -> this.stream().peek(action);
  }

  /**
  * Unparallelizes the {@link java.util.stream.Stream} provided by this
  * {@link Streamable}.
  *
  * @return a {@link Streamable} that provides a sequential
  *         {@link java.util.stream.Stream}
  */
  default Streamable<T> sequential() {
    return () -> this.stream().sequential();
  }

  /**
  * Skip {code n} elemenents in the {link java.util.stream.Stream}
  *
  * @param n number of elements to skip
  * @return Streamable with {@code n} elements in the
  *         {@link java.util.stream.Stream} skipped
  */
  default Streamable<T> skip(Long n) {
    return () -> this.stream().skip(n);
  }

  /**
  * Sorts the {@link java.util.stream.Stream} provided by this
  * {@link Streamable}.
  *
  * @return a {@link Streamable} that provides a sorted
  *         {@link java.util.stream.Stream}
  */
  default Streamable<T> sorted() {
    return () -> this.stream().sorted();
  }

  /**
  * Sorts the {@link java.util.stream.Stream} provided by this
  * {@link Streamable}.
  *
  * @param comparator the {@code java.util.Comparator} to use to sort the
  *                   {@link java.util.stream.Stream}.
  * @return a {@link Streamable} that provides a sorted
  *         {@link java.util.stream.Stream}
  */
  default Streamable<T> sorted(Comparator<? super T> comparator) {
    return () -> this.stream().sorted(comparator);
  }

  /**
  * Allows the {@link java.util.stream.Stream} provided by this
  * {@link Streamable} to be unordered
  *
  * @return a {@link Streamable} that provides an unordered
  *         {@link java.util.stream.Stream}
  */
  default Streamable<T> unordered() {
    return () -> this.stream().unordered();
  }

}
