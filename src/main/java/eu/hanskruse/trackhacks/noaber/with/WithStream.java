package eu.hanskruse.trackhacks.noaber.with;

import static eu.hanskruse.trackhacks.noaber.Noaber.$;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import eu.hanskruse.trackhacks.noaber.functions.Function3;
import eu.hanskruse.trackhacks.noaber.functions.Function4;
import eu.hanskruse.trackhacks.noaber.functions.Function5;
import eu.hanskruse.trackhacks.noaber.functions.Function6;
import eu.hanskruse.trackhacks.noaber.functions.Function7;
import eu.hanskruse.trackhacks.noaber.functions.Function8;
import eu.hanskruse.trackhacks.noaber.functions.Function9;
import eu.hanskruse.trackhacks.noaber.functions.Function10;
import eu.hanskruse.trackhacks.noaber.functions.Function11;
import eu.hanskruse.trackhacks.noaber.functions.Function12;
import eu.hanskruse.trackhacks.noaber.functions.Function13;
import eu.hanskruse.trackhacks.noaber.functions.Function14;
import eu.hanskruse.trackhacks.noaber.functions.Function15;
import eu.hanskruse.trackhacks.noaber.functions.Function16;

import eu.hanskruse.trackhacks.noaber.Streamable;

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

  default < //
  T1, //
  T2, //
  R> Streamable<R> comprehend( //
    final Streamable<T1> s1, //
    final Streamable<T2> s2, //
    BiFunction< //
    T1, //
    T2, //
    R> f) {
      return s1.flatMap( //
      t1 -> s2.map( //
      $().leftApply(f).apply(t1)));
    }


  default < //
    T1, //
    T2, //
    R> Streamable<R> comprehend( //
      final Streamable<T1> s1, //
      final Streamable<T2> s2, //
      BiPredicate<T1,T2> p, //
      BiFunction< //
      T1, //
      T2, //
      R> f) {
    return s1.flatMap( //
    t1 -> s2.filter(//
    $().leftApply(p).apply(t1)).map( //
    $().leftApply(f).apply( //
    t1)));
  }


  default <//
    T1, //
    T2, //
    T3, //
    R> Streamable<R> comprehend( //
      final Streamable<T1> s1, //
      final Streamable<T2> s2, //
      final Streamable<T3> s3,
      final Function3< //
      T1, //
      T2, //
      T3, //
      R> f) {
    return s1.flatMap( //
      t1 -> s2.flatMap( //
      t2 -> s3.map( //
      t3 -> f.apply( //
      t1, //
      t2, //
      t3))));
  }

  default < //
    T1, //
    T2, //
    T3, //
    T4, //
    R> Streamable<R> comprehend( //
      final Streamable<T1> s1, //
      final Streamable<T2> s2, //
      final Streamable<T3> s3, //
      final Streamable<T4> s4, //
      final Function4< //
      T1, //
      T2, //
      T3, //
      T4, //
      R> f) {
    return s1.flatMap( //
      t1 -> s2.flatMap( //
      t2 -> s3.flatMap( //
      t3 -> s4.map( //
      t4 -> f.apply( //
      t1, //
      t2, //
      t3, //
      t4)))));
  }

  default < //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    R> Streamable<R> comprehend( //
      final Streamable<T1> s1, //
      final Streamable<T2> s2, //
      final Streamable<T3> s3, //
      final Streamable<T4> s4, //
      final Streamable<T5> s5, //
      final Function5< //
      T1, //
      T2, //
      T3, //
      T4, //
      T5, //
      R> f) {
    return s1.flatMap( //
      t1 -> s2.flatMap( //
      t2 -> s3.flatMap( //
      t3 -> s4.flatMap( //
      t4 -> s5.map( //
      t5 ->  f.apply( //
      t1, //
      t2, //
      t3, //
      t4, //
      t5))))));
  }

  default < //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    R> Streamable<R> comprehend( //
      final Streamable<T1> s1, //
      final Streamable<T2> s2, //
      final Streamable<T3> s3, //
      final Streamable<T4> s4, //
      final Streamable<T5> s5, //
      final Streamable<T6> s6, //
      final Function6< //
      T1, //
      T2, //
      T3, //
      T4, //
      T5, //
      T6, //
      R> f) {
    return s1.flatMap( //
      t1 -> s2.flatMap( //
      t2 -> s3.flatMap( //
      t3 -> s4.flatMap( //
      t4 -> s5.flatMap( //
      t5 -> s6.map( //
      t6 -> f.apply( //
      t1, //
      t2, //
      t3, //
      t4, //
      t5, //
      t6)))))));
  }

  default < //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    T7, //
    R> Streamable<R> comprehend( //
      final Streamable<T1> s1, //
      final Streamable<T2> s2, //
      final Streamable<T3> s3, //
      final Streamable<T4> s4, //
      final Streamable<T5> s5, //
      final Streamable<T6> s6, //
      final Streamable<T7> s7, //
      final Function7< //
      T1, //
      T2, //
      T3, //
      T4, //
      T5, //
      T6, //
      T7, //
      R> f) {
    return s1.flatMap( //
      t1 -> s2.flatMap( //
      t2 -> s3.flatMap( //
      t3 -> s4.flatMap( //
      t4 -> s5.flatMap( //
      t5 -> s6.flatMap( //
      t6 -> s7.map(//
      t7 -> f.apply( //
      t1, //
      t2, //
      t3, //
      t4, //
      t5, //
      t6, //
      t7))))))));
  }

  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  R> Streamable<R> comprehend( //
    final Streamable<T1> s1, //
    final Streamable<T2> s2, //
    final Streamable<T3> s3, //
    final Streamable<T4> s4, //
    final Streamable<T5> s5, //
    final Streamable<T6> s6, //
    final Streamable<T7> s7, //
    final Streamable<T8> s8, //
    final Function8< //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    T7, //
    T8, //
    R> f) {
  return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.map(//
    t8 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8)))))))));
  }

  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9, //
  R> Streamable<R> comprehend( //
    final Streamable<T1> s1, //
    final Streamable<T2> s2, //
    final Streamable<T3> s3, //
    final Streamable<T4> s4, //
    final Streamable<T5> s5, //
    final Streamable<T6> s6, //
    final Streamable<T7> s7, //
    final Streamable<T8> s8, //
    final Streamable<T9> s9, //
    final Function9< //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    T7, //
    T8, //
    T9, //
    R> f) {
  return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.map(
    t9 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9))))))))));
  }


  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9, //
  T10, //
  R> Streamable<R> comprehend( //
    final Streamable<T1> s1, //
    final Streamable<T2> s2, //
    final Streamable<T3> s3, //
    final Streamable<T4> s4, //
    final Streamable<T5> s5, //
    final Streamable<T6> s6, //
    final Streamable<T7> s7, //
    final Streamable<T8> s8, //
    final Streamable<T9> s9, //
    final Streamable<T10> s10, //
    final Function10< //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    T7, //
    T8, //
    T9, //
    T10, //
    R> f) {
  return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.map( //
    t10 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10)))))))))));
  }

  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9, //
  T10, //
  T11, //
  R> Streamable<R> comprehend( //
    final Streamable<T1> s1, //
    final Streamable<T2> s2, //
    final Streamable<T3> s3, //
    final Streamable<T4> s4, //
    final Streamable<T5> s5, //
    final Streamable<T6> s6, //
    final Streamable<T7> s7, //
    final Streamable<T8> s8, //
    final Streamable<T9> s9, //
    final Streamable<T10> s10, //
    final Streamable<T11> s11, //
    final Function11< //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    T7, //
    T8, //
    T9, //
    T10, //
    T11, //
    R> f) {
  return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.flatMap( //
    t10 -> s11.map(
    t11 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10, //
    t11))))))))))));
  }

  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9, //
  T10, //
  T11, //
  T12, //
  R> Streamable<R> comprehend( //
    final Streamable<T1> s1, //
    final Streamable<T2> s2, //
    final Streamable<T3> s3, //
    final Streamable<T4> s4, //
    final Streamable<T5> s5, //
    final Streamable<T6> s6, //
    final Streamable<T7> s7, //
    final Streamable<T8> s8, //
    final Streamable<T9> s9, //
    final Streamable<T10> s10, //
    final Streamable<T11> s11, //
    final Streamable<T12> s12, //
    final Function12< //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    T7, //
    T8, //
    T9, //
    T10, //
    T11, //
    T12, //
    R> f) {
  return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.flatMap( //
    t10 -> s11.flatMap( //
    t11 -> s12.map(
    t12 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10, //
    t11, //
    t12)))))))))))));
  }

  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9, //
  T10, //
  T11, //
  T12, //
  T13, //
  R> Streamable<R> comprehend( //
    final Streamable<T1> s1, //
    final Streamable<T2> s2, //
    final Streamable<T3> s3, //
    final Streamable<T4> s4, //
    final Streamable<T5> s5, //
    final Streamable<T6> s6, //
    final Streamable<T7> s7, //
    final Streamable<T8> s8, //
    final Streamable<T9> s9, //
    final Streamable<T10> s10, //
    final Streamable<T11> s11, //
    final Streamable<T12> s12, //
    final Streamable<T13> s13, //
    final Function13< //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    T7, //
    T8, //
    T9, //
    T10, //
    T11, //
    T12, //
    T13, //
    R> f) {
  return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.flatMap( //
    t10 -> s11.flatMap( //
    t11 -> s12.flatMap( //
    t12 -> s13.map(//
    t13 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10, //
    t11, //
    t12, //
    t13))))))))))))));
  }

  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9, //
  T10, //
  T11, //
  T12, //
  T13, //
  T14, //
  R> Streamable<R> comprehend( //
    final Streamable<T1> s1, //
    final Streamable<T2> s2, //
    final Streamable<T3> s3, //
    final Streamable<T4> s4, //
    final Streamable<T5> s5, //
    final Streamable<T6> s6, //
    final Streamable<T7> s7, //
    final Streamable<T8> s8, //
    final Streamable<T9> s9, //
    final Streamable<T10> s10, //
    final Streamable<T11> s11, //
    final Streamable<T12> s12, //
    final Streamable<T13> s13, //
    final Streamable<T14> s14, //
    final Function14< //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    T7, //
    T8, //
    T9, //
    T10, //
    T11, //
    T12, //
    T13, //
    T14, //
    R> f) {
  return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.flatMap( //
    t10 -> s11.flatMap( //
    t11 -> s12.flatMap( //
    t12 -> s13.flatMap(//
    t13 -> s14.map( //
    t14 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10, //
    t11, //
    t12, //
    t13, //
    t14)))))))))))))));
  }


  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9, //
  T10, //
  T11, //
  T12, //
  T13, //
  T14, //
  T15, //
  R> Streamable<R> comprehend( //
    final Streamable<T1> s1, //
    final Streamable<T2> s2, //
    final Streamable<T3> s3, //
    final Streamable<T4> s4, //
    final Streamable<T5> s5, //
    final Streamable<T6> s6, //
    final Streamable<T7> s7, //
    final Streamable<T8> s8, //
    final Streamable<T9> s9, //
    final Streamable<T10> s10, //
    final Streamable<T11> s11, //
    final Streamable<T12> s12, //
    final Streamable<T13> s13, //
    final Streamable<T14> s14, //
    final Streamable<T15> s15, //
    final Function15< //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    T7, //
    T8, //
    T9, //
    T10, //
    T11, //
    T12, //
    T13, //
    T14, //
    T15, //
    R> f) {
  return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.flatMap( //
    t10 -> s11.flatMap( //
    t11 -> s12.flatMap( //
    t12 -> s13.flatMap(//
    t13 -> s14.flatMap( //
    t14 -> s15.map( //
    t15 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10, //
    t11, //
    t12, //
    t13, //
    t14, //
    t15))))))))))))))));
  }


  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9, //
  T10, //
  T11, //
  T12, //
  T13, //
  T14, //
  T15, //
  T16, //
  R> Streamable<R> comprehend( //
    final Streamable<T1> s1, //
    final Streamable<T2> s2, //
    final Streamable<T3> s3, //
    final Streamable<T4> s4, //
    final Streamable<T5> s5, //
    final Streamable<T6> s6, //
    final Streamable<T7> s7, //
    final Streamable<T8> s8, //
    final Streamable<T9> s9, //
    final Streamable<T10> s10, //
    final Streamable<T11> s11, //
    final Streamable<T12> s12, //
    final Streamable<T13> s13, //
    final Streamable<T14> s14, //
    final Streamable<T15> s15, //
    final Streamable<T16> s16, //
    final Function16< //
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    T7, //
    T8, //
    T9, //
    T10, //
    T11, //
    T12, //
    T13, //
    T14, //
    T15, //
    T16, //
    R> f) {
  return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.flatMap( //
    t10 -> s11.flatMap( //
    t11 -> s12.flatMap( //
    t12 -> s13.flatMap(//
    t13 -> s14.flatMap( //
    t14 -> s15.flatMap( //
    t15 -> s16.map( //
    t16 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10, //
    t11, //
    t12, //
    t13, //
    t14, //
    t15, //
    t16)))))))))))))))));
  }
}
