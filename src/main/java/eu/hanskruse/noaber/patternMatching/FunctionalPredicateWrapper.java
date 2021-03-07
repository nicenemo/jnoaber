package eu.hanskruse.noaber.patternMatching;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

import java.util.Optional;
import java.util.function.Function;

/**
 * Wraps a FunctionalPredicate.
 *
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <W> type of the function result of the FunctionalPredicate
 * @param <T>
 *          type of the predicate argument
 *
 */
public class FunctionalPredicateWrapper<T, W> {

  /** capture of the FunctionalPredicate. */
  private final FunctionalPredicate<T, W> functionalPredicate;

  /**
   * Creates a PredicateWrapper.
   *
   * @param value
   *          FunctionalPredicate to wrap.
   */
  public FunctionalPredicateWrapper(FunctionalPredicate<T, W> value) {
    requireNonNull(value);
    this.functionalPredicate = value;
  }

  /**
   * function to execute when the wrapped predicate is true.
   * @param <R> return type of the {@code Case}
   * @param f
   *          function to execute
   * @return a Case
   */
  public <R> Case<T,R> then(Function<W, R> f) {

    return t -> {
      if (isNull(f)) {
        return Optional.empty();
      }
      final Optional<W> predicateResult = this.functionalPredicate.apply(t);
      if (!predicateResult.isPresent()) {
        return Optional.empty();
      }

      final R result = f.apply(predicateResult.get());
      if (isNull(result)) {
        return Optional.empty();
      }
      return Optional.of(result);
    };
  }

  /**
   * Value to return when the wrapped predicate is true.
   * @param <R> type of the Optional result of the case
   * @param result the result
   * @return a Case
   */
  public <R> Case<T, R> then(R result) {
    return t -> {
      if (isNull(result)) {
        return Optional.empty();
      }
      final Optional<W> predicateResult = this.functionalPredicate.apply(t);
      if (!predicateResult.isPresent()) {
        return Optional.empty();
      }
      return Optional.of(result);
    };
  }
}
