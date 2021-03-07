package eu.hanskruse.noaber.with;

import static eu.hanskruse.noaber.Noaber.noaber;

import java.util.function.Function;

/**
 * Compose functionality.
 *
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 */
public interface WithCompose {

  /**
   * Compose function chain.
   * @param <T> type of the function argument and result
   * @param functions functions to compose
   * @return result of function chaining.
   */
  default <T> Function<T, T> compose(@SuppressWarnings("unchecked") final Function<T, T>... functions) {
    if (functions == null) {
      throw new IllegalArgumentException("functions is null");
    }

    if (functions.length == 0) {
      return noaber()::identity;
    }

    if (noaber().stream(functions).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }

    if (functions.length == 1) {
      return (argument) -> functions[0].apply(argument);
    }

    return (argument) -> {
      T acc = functions[0].apply(argument);
      for (int i = 1; i < functions.length; i++) {
        acc = functions[i].apply(acc);
      }
      return acc;
    };

  }

  /**
   * Compose function chain.
   *
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <R> return type
   * @param f1 first function
   * @param f2 second function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, R> Function<T1, R> compose(final Function<T1, T2> f1, //
      final Function<T2, R> f2) {
    if (noaber().stream(f1, f2).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f2.compose(f1);
  }

  /**
   * Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <R> return type
   * @param f1 first function
   * @param f2 second function
   * @param f3 third function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, R> Function<T1, R> compose(final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, R> f3) {
    if (noaber().stream(f1, f2, f3).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f3.compose(compose(f1, f2));
  }

  /**
   * /** Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <T4> type of 4th function argument
   * @param <R> return type
   * @param f1 first function
   * @param f2 second function
   * @param f3 third function
   * @param f4 fourth function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, T4, R> Function<T1, R> compose( //
      final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, T4> f3, //
      final Function<T4, R> f4) {
    if (noaber().stream(f1, f2, f3, f4).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f4.compose(compose(f1, f2, f3));
  }

  /**
   * Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <T4> type of 4th function argument
   * @param <T5> type of 5th function argument
   * @param <R> return type
   * @param f1 first function
   * @param f2 second function
   * @param f3 third function
   * @param f4 fourth function
   * @param f5 fifth function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, T4, T5, R> Function<T1, R> compose( //
      final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, T4> f3, //
      final Function<T4, T5> f4, //
      final Function<T5, R> f5) {
    if (noaber().stream(f1, f2, f3, f4, f5).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f5.compose(compose(f1, f2, f3, f4));
  }

  /**
   * Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <T4> type of 4th function argument
   * @param <T5> type of 5th function argument
   * @param <T6> type of 6th function argument
   * @param <R> return type
   * @param f1 first function
   * @param f2 second function
   * @param f3 third function
   * @param f4 fourth function
   * @param f5 fifth function
   * @param f6 sixth function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, T4, T5, T6, R> Function<T1, R> compose( //
      final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, T4> f3, //
      final Function<T4, T5> f4, //
      final Function<T5, T6> f5, //
      final Function<T6, R> f6) {
    if (noaber().stream(f1, f2, f3, f4, f5, f6).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f6.compose(compose(f1, f2, f3, f4, f5));
  }

  /**
   * Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <T4> type of 4th function argument
   * @param <T5> type of 5th function argument
   * @param <T6> type of 6th function argument
   * @param <T7> type of 7th function argument
   * @param <R> return type
   * @param f1 first function
   * @param f2 second function
   * @param f3 third function
   * @param f4 fourth function
   * @param f5 fifth function
   * @param f6 sixth function
   * @param f7 sixth function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, T4, T5, T6, T7, R> Function<T1, R> compose( //
      final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, T4> f3, //
      final Function<T4, T5> f4, //
      final Function<T5, T6> f5, //
      final Function<T6, T7> f6, final Function<T7, R> f7) {
    if (noaber().stream(f1, f2, f3, f4, f5, f6, f7).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f7.compose(compose(f1, f2, f3, f4, f5, f6));
  }

  /**
   * Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <T4> type of 4th function argument
   * @param <T5> type of 5th function argument
   * @param <T6> type of 6th function argument
   * @param <T7> type of 7th function argument
   * @param <T8> type of 8th function argument
   * @param <R> return type
   * @param f1 first function
   * @param f2 second function
   * @param f3 third function
   * @param f4 fourth function
   * @param f5 fifth function
   * @param f6 sixth function
   * @param f7 sixth function
   * @param f8 eighth function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<T1, R> compose( //
      final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, T4> f3, //
      final Function<T4, T5> f4, //
      final Function<T5, T6> f5, //
      final Function<T6, T7> f6, //
      final Function<T7, T8> f7, //
      final Function<T8, R> f8) {
    if (noaber().stream(f1, f2, f3, f4, f5, f6, f7, f8).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f8.compose(compose(f1, f2, f3, f4, f5, f6, f7));
  }

  /**
   * Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <T4> type of 4th function argument
   * @param <T5> type of 5th function argument
   * @param <T6> type of 6th function argument
   * @param <T7> type of 7th function argument
   * @param <T8> type of 8th function argument
   * @param <T9> type of 9th function argument
   * @param <R> return type
   * @param f1 first function
   * @param f2 second function
   * @param f3 third function
   * @param f4 fourth function
   * @param f5 fifth function
   * @param f6 sixth function
   * @param f7 sixth function
   * @param f8 eighth function
   * @param f9 ninth function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<T1, R> compose(//
      final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, T4> f3, //
      final Function<T4, T5> f4, //
      final Function<T5, T6> f5, //
      final Function<T6, T7> f6, //
      final Function<T7, T8> f7, //
      final Function<T8, T9> f8, //
      final Function<T9, R> f9) {
    if (noaber().stream(f1, f2, f3, f4, f5, f6, f7, f8, f9).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f9.compose(compose(f1, f2, f3, f4, f5, f6, f7, f8));
  }

  /**
   * Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <T4> type of 4th function argument
   * @param <T5> type of 5th function argument
   * @param <T6> type of 6th function argument
   * @param <T7> type of 7th function argument
   * @param <T8> type of 8th function argument
   * @param <T9> type of 9th function argument
   * @param <T10> type of 10th function argument
   * @param <R> return type
   * @param f1  first function
   * @param f2  second function
   * @param f3  third function
   * @param f4  fourth function
   * @param f5  fifth function
   * @param f6  sixth function
   * @param f7  sixth function
   * @param f8  eighth function
   * @param f9  ninth function
   * @param f10 tenth function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> Function<T1, R> compose( //
      final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, T4> f3, //
      final Function<T4, T5> f4, //
      final Function<T5, T6> f5, //
      final Function<T6, T7> f6, //
      final Function<T7, T8> f7, //
      final Function<T8, T9> f8, //
      final Function<T9, T10> f9, //
      final Function<T10, R> f10) {
    if (noaber().stream(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f10.compose(compose(f1, f2, f3, f4, f5, f6, f7, f8, f9));
  }

  /**
   * Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <T4> type of 4th function argument
   * @param <T5> type of 5th function argument
   * @param <T6> type of 6th function argument
   * @param <T7> type of 7th function argument
   * @param <T8> type of 8th function argument
   * @param <T9> type of 9th function argument
   * @param <T10> type of 10th function argument
   * @param <T11> type of 11th function argument
   * @param <R> return type
   * @param f1  first function
   * @param f2  second function
   * @param f3  third function
   * @param f4  fourth function
   * @param f5  fifth function
   * @param f6  sixth function
   * @param f7  sixth function
   * @param f8  eighth function
   * @param f9  ninth function
   * @param f10 tenth function
   * @param f11 eleventh function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> Function<T1, R> compose( //
      final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, T4> f3, //
      final Function<T4, T5> f4, //
      final Function<T5, T6> f5, //
      final Function<T6, T7> f6, //
      final Function<T7, T8> f7, //
      final Function<T8, T9> f8, //
      final Function<T9, T10> f9, //
      final Function<T10, T11> f10, //
      final Function<T11, R> f11) {
    if (noaber().stream(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f11.compose(compose(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10));
  }

  /**
   * Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <T4> type of 4th function argument
   * @param <T5> type of 5th function argument
   * @param <T6> type of 6th function argument
   * @param <T7> type of 7th function argument
   * @param <T8> type of 8th function argument
   * @param <T9> type of 9th function argument
   * @param <T10> type of 10th function argument
   * @param <T11> type of 11th function argument
   * @param <T12> type of 12th function argument
   * @param <R> return type
   * @param f1  first function
   * @param f2  second function
   * @param f3  third function
   * @param f4  fourth function
   * @param f5  fifth function
   * @param f6  sixth function
   * @param f7  sixth function
   * @param f8  eighth function
   * @param f9  ninth function
   * @param f10 tenth function
   * @param f11 eleventh function
   * @param f12 twelfth function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> Function<T1, R> compose( //
      final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, T4> f3, //
      final Function<T4, T5> f4, //
      final Function<T5, T6> f5, //
      final Function<T6, T7> f6, //
      final Function<T7, T8> f7, //
      final Function<T8, T9> f8, //
      final Function<T9, T10> f9, //
      final Function<T10, T11> f10, //
      final Function<T11, T12> f11, //
      final Function<T12, R> f12) {
    if (noaber().stream(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f12.compose(compose(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11));
  }

  /**
   * Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <T4> type of 4th function argument
   * @param <T5> type of 5th function argument
   * @param <T6> type of 6th function argument
   * @param <T7> type of 7th function argument
   * @param <T8> type of 8th function argument
   * @param <T9> type of 9th function argument
   * @param <T10> type of 10th function argument
   * @param <T11> type of 11th function argument
   * @param <T12> type of 12th function argument
   * @param <T13> type of 13th function argument
   * @param <R> return type
   * @param f1  first function
   * @param f2  second function
   * @param f3  third function
   * @param f4  fourth function
   * @param f5  fifth function
   * @param f6  sixth function
   * @param f7  sixth function
   * @param f8  eighth function
   * @param f9  ninth function
   * @param f10 tenth function
   * @param f11 eleventh function
   * @param f12 twelfth function
   * @param f13 thirteenth function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> Function<T1, R> compose( //
      final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, T4> f3, //
      final Function<T4, T5> f4, //
      final Function<T5, T6> f5, //
      final Function<T6, T7> f6, //
      final Function<T7, T8> f7, //
      final Function<T8, T9> f8, //
      final Function<T9, T10> f9, //
      final Function<T10, T11> f10, //
      final Function<T11, T12> f11, //
      final Function<T12, T13> f12, //
      final Function<T13, R> f13) {
    if (noaber().stream(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f13.compose(compose(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12));
  }

  /**
   * Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <T4> type of 4th function argument
   * @param <T5> type of 5th function argument
   * @param <T6> type of 6th function argument
   * @param <T7> type of 7th function argument
   * @param <T8> type of 8th function argument
   * @param <T9> type of 9th function argument
   * @param <T10> type of 10th function argument
   * @param <T11> type of 11th function argument
   * @param <T12> type of 12th function argument
   * @param <T13> type of 13th function argument
   * @param <T14> type of 14th function argument
   * @param <R> return type
   * @param f1  first function
   * @param f2  second function
   * @param f3  third function
   * @param f4  fourth function
   * @param f5  fifth function
   * @param f6  sixth function
   * @param f7  sixth function
   * @param f8  eighth function
   * @param f9  ninth function
   * @param f10 tenth function
   * @param f11 eleventh function
   * @param f12 twelfth function
   * @param f13 thirteenth function
   * @param f14 fourteenth function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> Function<T1, R> compose( //
      final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, T4> f3, //
      final Function<T4, T5> f4, //
      final Function<T5, T6> f5, //
      final Function<T6, T7> f6, //
      final Function<T7, T8> f7, //
      final Function<T8, T9> f8, //
      final Function<T9, T10> f9, //
      final Function<T10, T11> f10, //
      final Function<T11, T12> f11, //
      final Function<T12, T13> f12, //
      final Function<T13, T14> f13, //
      final Function<T14, R> f14) {
    if (noaber().stream(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f14.compose(compose(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13));
  }

  /**
   * Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <T4> type of 4th function argument
   * @param <T5> type of 5th function argument
   * @param <T6> type of 6th function argument
   * @param <T7> type of 7th function argument
   * @param <T8> type of 8th function argument
   * @param <T9> type of 9th function argument
   * @param <T10> type of 10th function argument
   * @param <T11> type of 11th function argument
   * @param <T12> type of 12th function argument
   * @param <T13> type of 13th function argument
   * @param <T14> type of 14th function argument
   * @param <T15> type of 15th function argument
   * @param <R> return type
   * @param f1  first function
   * @param f2  second function
   * @param f3  third function
   * @param f4  fourth function
   * @param f5  fifth function
   * @param f6  sixth function
   * @param f7  sixth function
   * @param f8  eighth function
   * @param f9  ninth function
   * @param f10 tenth function
   * @param f11 eleventh function
   * @param f12 twelfth function
   * @param f13 thirteenth function
   * @param f14 fourteenth function
   * @param f15 fifteenth function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> Function<T1, R> compose( //
      final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, T4> f3, //
      final Function<T4, T5> f4, //
      final Function<T5, T6> f5, //
      final Function<T6, T7> f6, //
      final Function<T7, T8> f7, //
      final Function<T8, T9> f8, //
      final Function<T9, T10> f9, //
      final Function<T10, T11> f10, //
      final Function<T11, T12> f11, //
      final Function<T12, T13> f12, //
      final Function<T13, T14> f13, //
      final Function<T14, T15> f14, //
      final Function<T15, R> f15) {
    if (noaber().stream(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15).anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f15.compose(compose(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14));
  }

  /**
   * Compose function chain.
   * @param <T1> type of 1st function argument
   * @param <T2> type of 2nd function argument
   * @param <T3> type of 3th function argument
   * @param <T4> type of 4th function argument
   * @param <T5> type of 5th function argument
   * @param <T6> type of 6th function argument
   * @param <T7> type of 7th function argument
   * @param <T8> type of 8th function argument
   * @param <T9> type of 9th function argument
   * @param <T10> type of 10th function argument
   * @param <T11> type of 11th function argument
   * @param <T12> type of 12th function argument
   * @param <T13> type of 13th function argument
   * @param <T14> type of 14th function argument
   * @param <T15> type of 15th function argument
   * @param <T16> type of 16th function argument
   * @param <R> return type
   * @param f1  first function
   * @param f2  second function
   * @param f3  third function
   * @param f4  fourth function
   * @param f5  fifth function
   * @param f6  sixth function
   * @param f7  sixth function
   * @param f8  eighth function
   * @param f9  ninth function
   * @param f10 tenth function
   * @param f11 eleventh function
   * @param f12 twelfth function
   * @param f13 thirteenth function
   * @param f14 fourteenth function
   * @param f15 fifteenth function
   * @param f16 sixteenth function
   * @return result of function chaining.
   */
  @SuppressWarnings("unchecked")
  default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> Function<T1, R> compose( //
      final Function<T1, T2> f1, //
      final Function<T2, T3> f2, //
      final Function<T3, T4> f3, //
      final Function<T4, T5> f4, //
      final Function<T5, T6> f5, //
      final Function<T6, T7> f6, //
      final Function<T7, T8> f7, //
      final Function<T8, T9> f8, //
      final Function<T9, T10> f9, //
      final Function<T10, T11> f10, //
      final Function<T11, T12> f11, //
      final Function<T12, T13> f12, //
      final Function<T13, T14> f13, //
      final Function<T14, T15> f14, //
      final Function<T15, T16> f15, //
      final Function<T16, R> f16) {

    if (noaber().stream(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16)
        .anyMatch(f -> f == null)) {
      throw new IllegalArgumentException("functions should not be null");
    }
    return f16.compose(compose(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15));
  }
}
