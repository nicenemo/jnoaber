package eu.hanskruse.trackhacks.noaber;

import java.util.Optional;
import java.util.function.Function;

/**
 * Composition of a Function and a Predicate.
 * if the wrapped predicate is true,
 * apply the function and return the the result wrapped as an Optional.
 * If the wrapped predicate is false return Optional.empty()
 * 
 * @author Hans Kruse
 *
 * @param <T>
 *          the type of the argument
 * @param <R>
 *          the type of the result
 */
@FunctionalInterface
public interface FunctionalPredicate<T, R> extends Function<T, Optional<R>> {
  // do nothing. just a shorthand
}
