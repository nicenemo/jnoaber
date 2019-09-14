package eu.hanskruse.trackhacks.noaber;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

import java.util.stream.Stream;

/**
 * The "stateless" companion to {@link java.util.stream.Stream}.
 * While for {@code Iterator} there is a {@code Iterable} no such thing exists for {@code Stream} in the JDK.
 * This  provides such a type. Currently it lifts {@code filter(...)}, {@code map(...)} and {@code flatMap(...)} of {@code Stream} into itself.
 *
 *  REMARK: in future iterations more functions of {@code Stream} may be lifted into this type.
 * 
 * @param <T> type of the {@link Streamable}'s {@code Stream} elements.
 */
@FunctionalInterface
public interface Streamable<T> {

  /**
   * Gets a "fresh" {@code Stream} of {@code T}.
   * @return the {@code Stream} of {@code T}
   */
  Stream<T> stream();

  default Streamable<T> filter(Predicate<? super T> predicate) {
    return () -> this.stream().filter(predicate);
  }

  /**
   * Lazily maps over the elements given the provided mapping function.
   * @param <R> return type of the elements to be provided by the {@code Stream} of the  returned {@code Streamable}
   * @param mapper mapping function
   * @return a {@code Streamable} that returns a {@code Stream} of {@code R}
   */
  default <R> Streamable<R> map(Function<? super T, ? extends R> mapper) {
    return () -> this.stream().map(mapper);
  }

  /**
   * Lazily maps over the elements given the provided flat mapping function.
   @param <R> return type of the elements to be provided by the {@code Stream} of the  returned {@code Streamable}
   * @param mapper mapping function.
   * @return  {@code Streamable} that returns a {@code Stream} of {@code R}
   */
  default <R> Streamable<R> flatMap(Function<? super T, ? extends Streamable<? extends R>> mapper) {
    return () -> this.stream().flatMap(streamable -> mapper.apply(streamable).stream());
  }

  default Streamable<T> concat(Streamable<T> ...streamables){
     return Streamable.concat(this,streamables);
  }

  static <T1> Streamable<T1> concat(Streamable<T1> a,Streamable<T1> ...streamables){
    return () -> {
      final Streamable<T1> seed = a == null? Stream::empty : a;
      final Stream<Streamable<T1>> xs= streamables == null ? Stream.empty() : Arrays.stream(streamables);
      return xs.filter(x -> x!=null).map(Streamable::stream).collect(seed::stream, Stream::concat, Stream::concat);
    };
  }
}