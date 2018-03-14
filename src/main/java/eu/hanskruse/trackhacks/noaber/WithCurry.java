package eu.hanskruse.trackhacks.noaber;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public interface WithCurry {

  /**
   * Partially applies a binary operator with the leftmost argument.
   * 
   * @param operator
   *            operator to lefApply on
   * @return a function that accepts an argument for the rightmost agument of
   *         the binary operator
   */
  default <T> Function<T, Function<T, T>> leftCurry(final BinaryOperator<T> operator) {
      return (u) -> (t) -> operator.apply(u, t);
  }

  /**
   * Partially applies a bifunction with the leftmost argument.
   * 
   * @param f
   *            operator to lefApply on
   * @return a function that accepts an argument for the rightmost argument
   *         for the bifunction
   */
  default <T, U, R> Function<T, Function<U, R>> leftCurry(final BiFunction<T, U, R> f) {
      return (u) -> (t) -> f.apply(u, t);
  }

  /**
   * Partially applies a binary operator with the rightmost argument.
   * 
   * @param operator
   *            operator to rightApply on
   * @return a function that accepts an argument for the leftmost argument of
   *         the binary operator
   */
  default <T> Function<T, Function<T, T>> rightCurry(final BinaryOperator<T> operator) {
      return (t) -> (u) -> operator.apply(u, t);
  }

  /**
   * Partially applies a bifunction with the rightmost argument.
   * 
   * @param f
   *            operator to rightApply on
   * @return a function that accepts an argument for the leftmost argument for
   *         the bifunction
   */
  default <U, T, R> Function<T, Function<U, R>> rightCurry(final BiFunction<U, T, R> f) {
      return (t) -> (u) -> f.apply(u, t);
  }
}