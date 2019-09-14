package eu.hanskruse.trackhacks.noaber.with;

import eu.hanskruse.trackhacks.noaber.tuples.Tuple;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple10;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple11;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple12;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple13;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple14;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple15;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple16;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple2;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple3;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple4;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple5;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple6;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple7;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple8;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple9;

/**
 * Create tuples of up to 16 elements.
 */
public interface WithTuples {

  /**
   * Creates a {@link Tuple2}.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param t0   0th element
   * @param t1   1th element
   * @return the created {@link Tuple2}
   */
  default <//
      T0, //
      T1> Tuple2 tuple(//
          final T0 t0, //
          final T1 t1) {
    return Tuple2.of(t0, t1);
  }

  /**
   * Creates a {@link Tuple3}.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @return the created {@link Tuple3}
   */
  default <//
      T0, //
      T1, //
      T2> Tuple3 tuple(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2) {
    return Tuple3.of(t0, t1, t2);
  }

  /**
   * Creates a {@link Tuple4}.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param <T3> type of 3th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @param t3   3th element
   * @return the created {@link Tuple4}
   */
  default <//
      T0, //
      T1, //
      T2, //
      T3> Tuple4 tuple(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3) {
    return Tuple4.of(t0, t1, t2, t3);
  }

  /**
   * Creates a {@link Tuple5}.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param <T3> type of 3th element
   * @param <T4> type of 4th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @param t3   3th element
   * @param t4   4th element
   * @return the created {@link Tuple5}
   */
  default < //
      T0, //
      T1, //
      T2, //
      T3, //
      T4> Tuple5 tuple(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4) {
    return Tuple5.of(t0, t1, t2, t3, t4);
  }

  /**
   * Creates a {@link Tuple6}.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param <T3> type of 3th element
   * @param <T4> type of 4th element
   * @param <T5> type of 5th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @param t3   3th element
   * @param t4   4th element
   * @param t5   5th element
   * @return the created {@link Tuple6}
   */
  default <//
      T0, //
      T1, //
      T2, //
      T3, //
      T4, //
      T5> Tuple6 tuple(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4, //
          final T5 t5) {
    return Tuple6.of(t0, t1, t2, t3, t4, t5);
  }

  /**
   * Creates a {@link Tuple7}.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param <T3> type of 3th element
   * @param <T4> type of 4th element
   * @param <T5> type of 5th element
   * @param <T6> type of 6th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @param t3   3th element
   * @param t4   4th element
   * @param t5   5th element
   * @param t6   6th element
   * @return the created {@link Tuple7}
   */
  default <//
      T0, //
      T1, //
      T2, //
      T3, //
      T4, //
      T5, //
      T6> Tuple7 tuple(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4, //
          final T5 t5, //
          final T6 t6) {
    return Tuple7.of(t0, t1, t2, t3, t4, t5, t6);
  }

  /**
   * Creates a {@link Tuple8}.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param <T3> type of 3th element
   * @param <T4> type of 4th element
   * @param <T5> type of 5th element
   * @param <T6> type of 6th element
   * @param <T7> type of 7th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @param t3   3th element
   * @param t4   4th element
   * @param t5   5th element
   * @param t6   6th element
   * @param t7   7th element
   * @return the created {@link Tuple8}
   */
  default <//
      T0, //
      T1, //
      T2, //
      T3, //
      T4, //
      T5, //
      T6, //
      T7> Tuple8 tuple(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4, //
          final T5 t5, //
          final T6 t6, //
          final T7 t7) {
    return Tuple8.of(t0, t1, t2, t3, t4, t5, t6, t7);
  }

  /**
   * Creates a {@link Tuple9}.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param <T3> type of 3th element
   * @param <T4> type of 4th element
   * @param <T5> type of 5th element
   * @param <T6> type of 6th element
   * @param <T7> type of 7th element
   * @param <T8> type of 8th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @param t3   3th element
   * @param t4   4th element
   * @param t5   5th element
   * @param t6   6th element
   * @param t7   7th element
   * @param t8   8th element
   * @return the created {@link Tuple9}
   */
  default <//
      T0, //
      T1, //
      T2, //
      T3, //
      T4, //
      T5, //
      T6, //
      T7, //
      T8> Tuple9 tuple(//

          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4, //
          final T5 t5, //
          final T6 t6, //
          final T7 t7, //
          final T8 t8) {
    return Tuple9.of(t0, t1, t2, t3, t4, t5, t6, t7, t8);
  }

  /**
   * Creates a {@link Tuple10}.
   *
   * @param <T0> type of 0th element
   * @param <T1> type of 1th element
   * @param <T2> type of 2th element
   * @param <T3> type of 3th element
   * @param <T4> type of 4th element
   * @param <T5> type of 5th element
   * @param <T6> type of 6th element
   * @param <T7> type of 7th element
   * @param <T8> type of 8th element
   * @param <T9> type of 9th element
   * @param t0   0th element
   * @param t1   1th element
   * @param t2   2th element
   * @param t3   3th element
   * @param t4   4th element
   * @param t5   5th element
   * @param t6   6th element
   * @param t7   7th element
   * @param t8   8th element
   * @param t9   9th element
   * @return the created {@link Tuple10}
   */
  default <//
      T0, //
      T1, //
      T2, //
      T3, //
      T4, //
      T5, //
      T6, //
      T7, //
      T8, //
      T9> Tuple10 tuple(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4, //
          final T5 t5, //
          final T6 t6, //
          final T7 t7, //
          final T8 t8, //
          final T9 t9) {
    return Tuple10.of(t0, t1, t2, t3, t4, t5, t6, t7, t8, t9);
  }

  /**
   * Creates a {@link Tuple11}.
   *
   * @param <T0>  type of 0th element
   * @param <T1>  type of 1th element
   * @param <T2>  type of 2th element
   * @param <T3>  type of 3th element
   * @param <T4>  type of 4th element
   * @param <T5>  type of 5th element
   * @param <T6>  type of 6th element
   * @param <T7>  type of 7th element
   * @param <T8>  type of 8th element
   * @param <T9>  type of 9th element
   * @param <T10> type of 10th element
   * @param t0    0th element
   * @param t1    1th element
   * @param t2    2th element
   * @param t3    3th element
   * @param t4    4th element
   * @param t5    5th element
   * @param t6    6th element
   * @param t7    7th element
   * @param t8    8th element
   * @param t9    9th element
   * @param t10   10th element
   * @return the created {@link Tuple11}
   */
  default <//
      T0, //
      T1, //
      T2, //
      T3, //
      T4, //
      T5, //
      T6, //
      T7, //
      T8, //
      T9, //
      T10> Tuple11 tuple(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4, //
          final T5 t5, //
          final T6 t6, //
          final T7 t7, //
          final T8 t8, //
          final T9 t9, //
          final T10 t10) {
    return Tuple11.of(t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  /**
   * Creates a {@link Tuple12}.
   *
   * @param <T0>  type of 0th element
   * @param <T1>  type of 1th element
   * @param <T2>  type of 2th element
   * @param <T3>  type of 3th element
   * @param <T4>  type of 4th element
   * @param <T5>  type of 5th element
   * @param <T6>  type of 6th element
   * @param <T7>  type of 7th element
   * @param <T8>  type of 8th element
   * @param <T9>  type of 9th element
   * @param <T10> type of 10th element
   * @param <T11> type of 11th element
   * @param t0    0th element
   * @param t1    1th element
   * @param t2    2th element
   * @param t3    3th element
   * @param t4    4th element
   * @param t5    5th element
   * @param t6    6th element
   * @param t7    7th element
   * @param t8    8th element
   * @param t9    9th element
   * @param t10   10th element
   * @param t11   11th element
   * @return the created {@link Tuple12}
   */
  default <//
      T0, //
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
      T11> Tuple12 tuple(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4, //
          final T5 t5, //
          final T6 t6, //
          final T7 t7, //
          final T8 t8, //
          final T9 t9, //
          final T10 t10, //
          final T11 t11) {
    return Tuple12.of(t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11);
  }

  /**
   * Creates a {@link Tuple13}.
   *
   * @param <T0>  type of 0th element
   * @param <T1>  type of 1th element
   * @param <T2>  type of 2th element
   * @param <T3>  type of 3th element
   * @param <T4>  type of 4th element
   * @param <T5>  type of 5th element
   * @param <T6>  type of 6th element
   * @param <T7>  type of 7th element
   * @param <T8>  type of 8th element
   * @param <T9>  type of 9th element
   * @param <T10> type of 10th element
   * @param <T11> type of 11th element
   * @param <T12> type of 12th element
   * @param t0    0th element
   * @param t1    1th element
   * @param t2    2th element
   * @param t3    3th element
   * @param t4    4th element
   * @param t5    5th element
   * @param t6    6th element
   * @param t7    7th element
   * @param t8    8th element
   * @param t9    9th element
   * @param t10   10th element
   * @param t11   11th element
   * @param t12   12th element
   * @return the created {@link Tuple13}
   */
  default <//
      T0, //
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
      T12> Tuple13 tuple(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4, //
          final T5 t5, //
          final T6 t6, //
          final T7 t7, //
          final T8 t8, //
          final T9 t9, //
          final T10 t10, //
          final T11 t11, //
          final T12 t12) {
    return Tuple13.of(t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12);
  }

  /**
   * Creates a {@link Tuple14}.
   *
   * @param <T0>  type of 0th element
   * @param <T1>  type of 1th element
   * @param <T2>  type of 2th element
   * @param <T3>  type of 3th element
   * @param <T4>  type of 4th element
   * @param <T5>  type of 5th element
   * @param <T6>  type of 6th element
   * @param <T7>  type of 7th element
   * @param <T8>  type of 8th element
   * @param <T9>  type of 9th element
   * @param <T10> type of 10th element
   * @param <T11> type of 11th element
   * @param <T12> type of 12th element
   * @param <T13> type of 13th element
   * @param t0    0th element
   * @param t1    1th element
   * @param t2    2th element
   * @param t3    3th element
   * @param t4    4th element
   * @param t5    5th element
   * @param t6    6th element
   * @param t7    7th element
   * @param t8    8th element
   * @param t9    9th element
   * @param t10   10th element
   * @param t11   11th element
   * @param t12   12th element
   * @param t13   13th element
   * @return the created {@link Tuple14}
   */
  default <//
      T0, //
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
      T13> Tuple14 tuple(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4, //
          final T5 t5, //
          final T6 t6, //
          final T7 t7, //
          final T8 t8, //
          final T9 t9, //
          final T10 t10, //
          final T11 t11, //
          final T12 t12, //
          final T13 t13) {
    return Tuple14.of(t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13);
  }

  /**
   * Creates a {@link Tuple15}.
   *
   * @param <T0>  type of 0th element
   * @param <T1>  type of 1th element
   * @param <T2>  type of 2th element
   * @param <T3>  type of 3th element
   * @param <T4>  type of 4th element
   * @param <T5>  type of 5th element
   * @param <T6>  type of 6th element
   * @param <T7>  type of 7th element
   * @param <T8>  type of 8th element
   * @param <T9>  type of 9th element
   * @param <T10> type of 10th element
   * @param <T11> type of 11th element
   * @param <T12> type of 12th element
   * @param <T13> type of 13th element
   * @param <T14> type of 14th element
   * @param t0    0th element
   * @param t1    1th element
   * @param t2    2th element
   * @param t3    3th element
   * @param t4    4th element
   * @param t5    5th element
   * @param t6    6th element
   * @param t7    7th element
   * @param t8    8th element
   * @param t9    9th element
   * @param t10   10th element
   * @param t11   11th element
   * @param t12   12th element
   * @param t13   13th element
   * @param t14   14th element
   * @return the created {@link Tuple15}
   */
  default <//
      T0, //
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
      T14> Tuple15 tuple(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4, //
          final T5 t5, //
          final T6 t6, //
          final T7 t7, //
          final T8 t8, //
          final T9 t9, //
          final T10 t10, //
          final T11 t11, //
          final T12 t12, //
          final T13 t13, //
          final T14 t14) {
    return Tuple15.of(t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14);
  }

  /**
   * Creates a {@link Tuple16} of 16 elements.
   *
   * @param <T0>  type of 0th element
   * @param <T1>  type of 1th element
   * @param <T2>  type of 2th element
   * @param <T3>  type of 3th element
   * @param <T4>  type of 4th element
   * @param <T5>  type of 5th element
   * @param <T6>  type of 6th element
   * @param <T7>  type of 7th element
   * @param <T8>  type of 8th element
   * @param <T9>  type of 9th element
   * @param <T10> type of 10th element
   * @param <T11> type of 11th element
   * @param <T12> type of 12th element
   * @param <T13> type of 13th element
   * @param <T14> type of 14th element
   * @param <T15> type of 15th element
   * @param t0    0th element
   * @param t1    1th element
   * @param t2    2th element
   * @param t3    3th element
   * @param t4    4th element
   * @param t5    5th element
   * @param t6    6th element
   * @param t7    7th element
   * @param t8    8th element
   * @param t9    9th element
   * @param t10   10th element
   * @param t11   11th element
   * @param t12   12th element
   * @param t13   13th element
   * @param t14   14th element
   * @param t15   15th element
   * @return the created {@link Tuple16}
   */
  default <//
      T0, //
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
      T15> Tuple16 tuple(//
          final T0 t0, //
          final T1 t1, //
          final T2 t2, //
          final T3 t3, //
          final T4 t4, //
          final T5 t5, //
          final T6 t6, //
          final T7 t7, //
          final T8 t8, //
          final T9 t9, //
          final T10 t10, //
          final T11 t11, //
          final T12 t12, //
          final T13 t13, //
          final T14 t14, //
          final T15 t15) {
    return Tuple16.of(t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15);
  }
}
