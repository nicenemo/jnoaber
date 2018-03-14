package eu.hanskruse.trackhacks.noaber;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public interface WithPartialApplication {

  /**
   * Partially applies a bifunction with the leftmost argument.
   *
   * @param operator
   *          operator to lefApply on
   * @param t
   *          the parameter to be applied
   * @return a function that accepts an argument for the rightmost argument
   *         for the bifunction
   */
  default <U, T, R> Function<U, R> leftApply(final BiFunction<U, T, R> operator, final T t) {
    return (u) -> operator.apply(u, t);
  }

  /**
   * Partially applies a binary operator with the leftmost argument.
   *
   * @param operator
   *          operator to lefApply on
   * @param t
   *          the parameter to be applied
   * @return a function that accepts an argument for the rightmost agument of
   *         the binary operator
   */
  default <T> Function<T, T> leftApply(final BinaryOperator<T> operator, final T t) {
    return (u) -> operator.apply(u, t);
  }

  /**
   * Partially applies a bifunction with the rightmost argument.
   *
   * @param operator
   *          operator to rightApply on
   * @param u
   *          the parameter to be applied
   * @return a function that accepts an argument for the leftmost argument for
   *         the bifunction
   */
  default <U, T, R> Function<T, R> rightApply(final BiFunction<U, T, R> operator, final U u) {
    return (t) -> operator.apply(u, t);
  }

  /**
   * Partially applies a binary operator with the rightmost argument.
   *
   * @param operator
   *          operator to rightApply on
   * @param u
   *          the parameter to be applied
   * @return a function that accepts an argument for the leftmost argument of
   *         the binary operator
   */
  default <T> Function<T, T> rightApply(final BinaryOperator<T> operator, final T u) {
    return (t) -> operator.apply(u, t);
  }
}
