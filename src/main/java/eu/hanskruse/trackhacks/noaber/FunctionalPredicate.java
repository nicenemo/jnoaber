package eu.hanskruse.trackhacks.noaber;

import java.util.Optional;
import java.util.function.Function;

/**
 * Shorthand modelling a case clause.
 * @author Hans Kruse
 *
 * @param <T> the type of the argument
 */
@FunctionalInterface
public interface FunctionalPredicate<T> extends Function<T, Optional<T>> {
 //do nothing. just a shorthand
}
