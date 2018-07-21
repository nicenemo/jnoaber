package eu.hanskruse.trackhacks.noaber;

import java.util.Optional;

/**
 * A Pattern matcher that captures cases to match with.
 * 
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <T>
 *          the type of the value to match with
 * @param <R>
 *          the return type of match
 */
public final class PatternMatcher<T, R> {

  private final Case<T, R>[] cases;

  /**
   * Creates a pattern matcher.
   * 
   * @param caseValues
   *          the cases
   */
  @SafeVarargs
  public PatternMatcher(Case<T, R>... caseValues) {
    this.cases = caseValues;
  }

  /**
   * match.
   * 
   * @param value
   *          value to match
   * @return result of the match
   */
  public Optional<? extends R> match(final T value) {
    return new CaseAcceptor<>(value).with(this.cases);
  }
}