package eu.hanskruse.trackhacks.noaber;

import java.util.Optional;
import java.util.function.Function;

/**
 * Composition of a Predicate and a Function.
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
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
