package eu.hanskruse.trackhacks.noaber;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Advanced pattern matching with the least amount of syntactic noise.
 * Inspired by functional programming languages such as Scala or F#.
 * 
 * This is an advanced version of Java's switch statement.
 * There is a function match that corresponds to the switch clause.
 * The match function accepts a value to match against and a set of clauses called 'kazen'. 
 * These 'kazen' can be generated with a 'kaas' functions that accepts a predicate as first argument and a function as second argument.
 * The 'kaas' function closes over the predicate and the second argument and gives an optional result to be used with the beforementioned match function.
 * 
 * Several overloads exists for the 'kaas' and 'match' functions for your convenience.
 * 
 * Accidently 'kaas' is the Dutch word for cheese with plural 'kazen'. 'Kaas' is use the to prevent a name clash with the 'case' keyword.
 * Leipajuusto, if fitted with the proper diacritics, is a Swedish/Finish word for a cheese served with coffee. 'Java' is also American slang for coffee.
 * I Consider it a perfect fit.
 * 
 * @author Hans Kruse
 *
 */
public interface Leipajuusto {

	/**
	 * A case statement.
	 * @param p the predicate
	 * @param f the function to execute when p is truthy.
	 * @return the Optional result of f if p is truthy. Return Optional.Empty() if p is falsy.
	 */
	public default <T, R> Function<T, Optional<R>> kaas(final Predicate<T> p, final Function<T, R> f) {
		return (T t) -> p.test(t) ? Optional.of(f.apply(t)) : Optional.empty();
	}
	
	/**
	 * A case statement.
	 * @param p the predicate
	 * @param f the function to execute when p is truthy.
	 * @return the Optional result of f if p is truthy. Return Optional.Empty() if p is falsy.
	 */
	public default <T, R> Function<T, Optional<R>> kaas(final Predicate<T> p, final R value) {
		return (T t) -> p.test(t) ? Optional.of(value) : Optional.empty();
	}

	/**
	 * A case statement.
	 * @param p the predicate
	 * @param f the function to execute when p is truthy.
	 * @return the Optional result of f if p is truthy. Return Optional.Empty() if p is falsy.
	 */
	public default <T1, T2, R> Function<T1, Optional<R>> kaas(final Function<T1, Optional<T2>> p,
			final Function<T2, R> f) {
		return (T1 t) -> {
			Optional<T2> pOptionalResult = p.apply(t);
			return pOptionalResult.isPresent() ? Optional.of(f.apply(pOptionalResult.get())) : Optional.empty();
		};
	}
	
	/**
	 * A case statement.
	 * @param p the predicate
	 * @param f the function to execute when p is truthy.
	 * @return the Optional result of f if p is truthy. Return Optional.Empty() if p is falsy.
	 */
	public default <T1, T2, R> Function<T1, Optional<R>> kaas(final Function<T1, Optional<T2>> p,
			final BiFunction<T1,T2, R> f) {
		return (T1 t) -> {
			Optional<T2> pOptionalResult = p.apply(t);
			return pOptionalResult.isPresent() ? Optional.of(f.apply(t,pOptionalResult.get())) : Optional.empty();
		};
	}
	
	/**
	 * A case statement.
	 * @param p the predicate
	 * @param f the function to execute when p is truthy.
	 * @return the Optional result of f if p is truthy. Return Optional.Empty() if p is falsy.
	 */

	public default <T1, T2, R> Function<T1, Optional<R>> kaas(final Function<T1, Optional<T2>> p,
			final R value) {
		return (T1 t) -> {
			Optional<T2> pOptionalResult = p.apply(t);
			return pOptionalResult.isPresent() ? Optional.of(value) : Optional.empty();
		};
	}
	
	//TODO: find a better way to prevent ambiguity error when having a consumer as a second argument.
	//for now renamed these functions KaasConsumer.
	
	/**
	 * A case statement.
	 * @param p the predicate
	 * @param f the function to execute when p is truthy.
	 * @return the Optional result of f if p is truthy. Return Optional.Empty() if p is falsy.
	 */

	public default <T> Predicate<T> kaasConsumer(final Predicate<T> p, final Consumer<T> f) {
		return (T t) -> {
			if(p.test(t)){
				f.accept(t);
				return true;
			}
		    return false;
		};
	}
	
	/**
	 * A case statement.
	 * @param p the predicate
	 * @param f the function to execute when p is truthy.
	 * @return the Optional result of f if p is truthy. Return Optional.Empty() if p is falsy.
	 */
	public default <T1, T2> Predicate<T1> kaasConsumer(final Function<T1, Optional<T2>> p,
			final Consumer<T2> f) {
		return (T1 t) -> {
			Optional<T2> pOptionalResult = p.apply(t);
			if(pOptionalResult.isPresent()){
				f.accept(pOptionalResult.get());
				return true;
			}
			return false;
		};
	}
	
	/**
	 * Match function that returns the result of a matching clause.
	 * Intended to be used with 'kaas' clauses that accept a value, a Function or a BiFunction as second parameter.
	 * The value of the first function that has a present result will be returned. The remaining functions are not considered.
	 * @param t value to match
	 * @param kazen the list of functions to match against t
	 * @return the non optional value of the result of the first function with a present result.
	 */
	@SuppressWarnings("unchecked")
	public default <T, R> R match(final T t, final Function<T, Optional<R>>... kazen) {
		for (final Function<T, Optional<R>> kaas : kazen) {
			final Optional<R> r = kaas.apply(t);
			if (r.isPresent()) {
				return r.get();
			}
		}
		throw new IllegalStateException("...Perhaps your cheese was moved");
		
	}
	
	/**
	 * Creates a match function that captures a set of 'kaas' clauses, returning a function that accepts a value to be matched against the 'kaas' clauses.
	 * Intended to be used with 'kaas' clauses that accept a value, a Function or a BiFunction as second parameter.
	 * The value of the first function that has a present result will be returned. The remaining functions are not considered.
	 * @param t value to match
	 * @param kazen the list of functions to match against t
	 * @return the non optional value of the result of the first function with a present result.
	 */
	@SuppressWarnings("unchecked")
	public default <T, R> Function<T,R> CreateMatcher(final Function<T, Optional<R>>... kazen) {
		return t-> match(t,kazen);			
	}
	

	/**
	 * Matches value t to a list of predicates. Exits on the first predicate which gives true.
	 * Intended to be used with 'kaas' clauses that have a Consumer as a second parameter.
	 * The Predicates typically close over an embedded consumer.
	 * @param t the value to match
	 * @param kazen the list of predicates to match against t.
	 */
	@SuppressWarnings("unchecked")
	public default <T>  void match(final T t, final Predicate<T>... kazen) {
		for (final Predicate<T> kaas : kazen) {
			if (kaas.test(t)) {
				return;
			}
		}
		throw new IllegalStateException("...Perhaps your cheese was moved");
		
	}
	
	/**
	 * Creates a match function that captures a set of 'kaas' clauses, returning a Consumer that accepts a value to be matched against the 'kaas' clauses.
	 * Intended to be used with 'kaas' clauses that have a Consumer as a second parameter.
	 * The Predicates typically close over an embedded consumer.
	 * @param t the value to match
	 * @param kazen the list of predicates to match against t.
	 */
	@SuppressWarnings("unchecked")
	public default <T>  Consumer<T> createMatcher(final Predicate<T>... kazen) {
		return (t) -> match(t,kazen);
	}
}

//see https://github.com/nicenemo/jnoaber
