package eu.hanskruse.trackhacks.noaber;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Leipajuusto provides functional programming style pattern matching in Java.
 * It is a bit like a switch statement on steroids.
 * 
 * With just
 * 
 * The classname Leipajuusto is a Swedisch Cheese usually serverd with coffee.
 * Since Java is American slang for coffee and the combination of cheese and
 * coffee is a bit alien to most people I choose this name.
 * 
 * @author Hans Kruse
 *
 */
public interface Leipajuusto {

	/**
	 * function that does a dynamic case. I name it 'kaas' because it is the
	 * Dutch word for cheese and it does not cause name clashes.
	 * 
	 * @param p
	 *            the predicate a guard for the function. When true, the
	 *            function of the second argument of kaas will be executed.
	 * @param f
	 *            function that will be execute if p results in true
	 * @return a function that executes p and if p is true f. It returns
	 *         Option.empty() if p is false, else an option with as value the
	 *         result of f will be returned.
	 */
	public default <T, R> Function<T, Optional<R>> kaas(final Predicate<T> p, final Function<T, R> f) {
		return (T t) -> p.test(t) ? Optional.of(f.apply(t)) : Optional.empty();
	}

	/**
	 * Overload of the dynamic case function named 'kaas' to prevent name
	 * clashes. Instead of a predicate, a function with optional result is used
	 * as guard. If the function returns Optional.empty(), the second argument
	 * of the dynamic case, is not executed. This is a bit of a filter and map
	 * in one function.
	 * 
	 * @param p
	 *            the predicate a guard for the function. When true, the
	 *            function of the second argument of kaas will be executed.
	 * @param f
	 *            function that will be execute if p results in true
	 * @return a function that executes p and if p is true f. It returns
	 *         Option.empty() if p is false, else an option with as value the
	 *         result of f will be returned.
	 */
	public default <T1, T2, R> Function<T1, Optional<R>> kaas(final Function<T1, Optional<T2>> p,
			final Function<T2, R> f) {
		return (T1 t) -> {
			Optional<T2> pOptionalResult = p.apply(t);
			return pOptionalResult.isPresent() ? Optional.of(f.apply(pOptionalResult.get())) : Optional.empty();
		};
	}
	/**
	 * Matcher that given a value of t iterates over a list of dynamic case
	 * clauses, the results of 'kaas' functions calls. These are functions 't'
	 * is applied to these functions. every function gives an optional result.
	 * Iteration stops on the first result that is not Optional.empty();
	 * 
	 * @param t
	 *            the function to check wit th
	 * @param kazen
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public default <T, R> R match(final T t, final Function<T, Optional<R>>... kazen) {
		for (final Function<T, Optional<R>> kaas : kazen) {
			final Optional<R> r = kaas.apply(t);
			if (r.isPresent()) {
				return r.get();
			}
		}
		throw new IllegalStateException("no match found. missing a default kaas. Perhaps your cheese was moved");

	}
}
