package eu.hanskruse.trackhacks.noaber;

import static eu.hanskruse.trackhacks.noaber.Noaber.noaber;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Pattern matching functionality.
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 */
public interface WithPatternMatching {

  /**
   * Composes a predicate with the identity function.
   *
   * @param predicate
   *          predicate to compose with
   * @return FunctionalPredicate
   */
  default <T> FunctionalPredicate<T, T> functionalPredicate(final Predicate<T> predicate) {
    return functionalPredicate(predicate, noaber()::identity);
  }

  /**
   * Composes a predicate and a function.
   *
   * @param predicate
   *          predicate to compose with
   * @param function
   *          function to compose with
   * @return FunctionalPredicate
   */
  default <T, R> FunctionalPredicate<T, R> functionalPredicate(final Predicate<T> predicate,
      final Function<T, R> function) {
    requireNonNull(predicate);
    requireNonNull(function);
    return t -> {
      if (!predicate.test(t)) {
        return Optional.empty();
      }
      final R result = function.apply(t);
      if (isNull(result)) {
        return Optional.empty();
      }
      return Optional.of(result);
    };
  }

  /**
   * Match captures the value to match against returning a CaseAcceptor.
   *
   * @param value
   *          the value to capture
   * @return a CaseAcceptor.
   */
  default <T> CaseAcceptor<T> match(final T value) {
    return new CaseAcceptor<>(value);
  }

  /**
   * Default case.
   *
   * @param f
   *          function to perform on default case
   * @return default case
   */
  default <T, R> Case<T, R> orElse(final Function<T, R> f) {
    return x -> isNull(f) ? Optional.empty() : Optional.of(f.apply(x));
  }

  /**
   * Default case.
   *
   * @param result
   *          to return
   * @return default case
   */
  default <T, R> Case<T, R> orElse(final R result) {
    return x -> isNull(result) ? Optional.empty() : Optional.of(result);
  }

  /**
   * When wraps a class as predicate to match against that class.
   *
   * @param clazz
   *          class to match
   * @return PredicateWrapper
   */
  default <T> FunctionalPredicateWrapper<T, T> whenClass(final Class<T> clazz) {
    requireNonNull(clazz);
    return whenPredicate(t -> nonNull(t) &&  clazz.isInstance(t) );
  }

  /**
   * When wraps a value as predicate.
   *
   * @param ppredicate
   *          predicate
   * @param result
   *          the result to return if p
   * @return PredicateWrapper
   */
  default <T, R> FunctionalPredicateWrapper<T, R> whenFunctionalPredicate(
      final FunctionalPredicate<T, R> functionalPredicate) {
    return new FunctionalPredicateWrapper<>(functionalPredicate);
  }

  /**
   * When wraps a value as predicate.
   *
   * @param ppredicate
   *          predicate
   * @param result
   *          the result to return if p
   * @return PredicateWrapper
   */
  default <T> FunctionalPredicateWrapper<T, T> whenPredicate(final Predicate<T> predicate) {
    return new FunctionalPredicateWrapper<>(functionalPredicate(predicate));
  }

  /**
   * When wraps a regular expression pattern as predicate.
   *
   * @param pattern
   *          to match against
   * @return PredicateWrapper
   */
  default FunctionalPredicateWrapper<CharSequence, CharSequence> whenRegEx(final Pattern pattern) {
    requireNonNull(pattern);
    return whenPredicate((t) -> nonNull(t) && pattern.matcher(t).matches());
  }

  /**
   * When wraps a regular expression pattern as predicate.
   *
   * @param pattern
   *          to match against
   * @return PredicateWrapper
   */
  default FunctionalPredicateWrapper<CharSequence, CharSequence> whenRegEx(final String pattern) {
    requireNonNull(pattern);
    return whenRegEx(Pattern.compile(pattern));
  }

  /**
   * When wraps a value as predicate to match for equality.
   *
   * @param value
   *          to match
   * @return PredicateWrapper
   */
  default <T> FunctionalPredicateWrapper<T, T> whenValue(final T value) {
    return whenPredicate(t -> java.util.Objects.equals(t, value));
  }

  /**
   * Creates a pattern matcher to match with.
   *
   * @param cases
   *          cases to match with
   * @return a patter matcher to match the cases with
   */
  default <T, R> PatternMatcher<T, R> with(@SuppressWarnings("unchecked") final Case<T, R>... cases) {
    return new PatternMatcher<>(cases);
  }
}

