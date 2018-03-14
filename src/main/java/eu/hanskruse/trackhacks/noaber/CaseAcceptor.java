package eu.hanskruse.trackhacks.noaber;

import static java.util.Objects.isNull;

import java.util.Arrays;
import java.util.Optional;

/**
 * Capture argument of match function for pattern matching.
 * Accepts an array of Case clauses.
 *
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <T>
 *          type of the argument.
 */
public final class CaseAcceptor<T> {

  private final T t;

  public CaseAcceptor(final T value) {
    this.t = value;
  }

  /**
   * Evaluate a set of cases until one has a none Optional.Empty() result. Return
   * that result.
   *
   * @param cases
   *          set of cases
   * @return the first case that has a none Optional.empty result. If the list is
   *         empty or null Optional.empty() will be returned.
   */
  @SafeVarargs
  public final <R> Optional<R> with(final Case<T, R>... cases) {
    if (isNull(cases)) {
      return Optional.empty();
    }
    final Optional<Optional<R>> result = Arrays.stream(cases)//
        .map(cse -> cse.apply(this.t))
        .filter(r -> r.isPresent())//
        .findFirst();
    return result.isPresent() ? result.get() : Optional.empty();
  }
}