package eu.hanskruse.trackhacks.noaber;
import static eu.hanskruse.trackhacks.noaber.Noaber.$;

import java.util.function.BiFunction;

public interface WithIterable {

  default <T1, T2,R> Streamable<R> comprehend(//
      final Iterable<T1> i1, //
      final Iterable<T2> i2,
      final BiFunction<T1,T2,R> f) {
    return $().comprehend(() -> $().stream(i1), () -> $().stream(i2), f);

  }
  
  default <T1, T2, T3,R> Streamable<R> comprehend(//
      final Iterable<T1> i1, //
      final Iterable<T2> i2, //
      final Iterable<T3> i3,//
      final Function3<T1,T2,T3,R> f) {
    return $().comprehend(() -> $().stream(i1), () -> $().stream(i2), () -> $().stream(i3), f);
  }

  default <T1, T2, T3, T4,R> Streamable<R> comprehend(//
      final Iterable<T1> i1, //
      final Iterable<T2> i2, //
      final Iterable<T3> i3, //
      final Iterable<T4> i4, //
      final Function4<T1,T2,T3,T4,R> f) {
    return $().comprehend(() -> $().stream(i1), () -> $().stream(i2), () -> $().stream(i3),() -> $().stream(i4), f);
      }
  //...
}
