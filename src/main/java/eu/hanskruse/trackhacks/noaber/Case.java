package eu.hanskruse.trackhacks.noaber;

import java.util.Optional;
import java.util.function.Function;

/**
 * Case Clause for pattern matching.
 * 
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <T>
 *          the type of the argument
 * @param <R>
 *          the type of the optional result
 */
@FunctionalInterface
public interface Case<T, R> extends Function<T, Optional<R>> {
  // do nothing. just a shorthand
}