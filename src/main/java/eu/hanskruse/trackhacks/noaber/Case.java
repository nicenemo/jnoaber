package eu.hanskruse.trackhacks.noaber;

import java.util.Optional;
import java.util.function.Function;

/**
 * Shorthand modelling a case clause.
 * @author Hans Kruse
 *
 * @param <T> the type of the argument
 * @param <R> the type of the optional result
 */
@FunctionalInterface
public interface Case<T,R> extends Function<T, Optional<R>> {
 //do nothing. just a shorthand
}
