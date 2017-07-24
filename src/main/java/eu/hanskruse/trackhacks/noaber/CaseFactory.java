package eu.hanskruse.trackhacks.noaber;

import java.util.Optional;
import java.util.function.BiFunction;
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
public final class CaseFactory {

	/**
	 * A case statement.
	 * @param clazz the class that the value of the argument of the returned function should be assignable from.
	 * @param f the function to execute when clazz is assignable from the given argument of the returned function.
	 * @return the Optional result of value if clazz is is assigneable from the given argument of the returned function. 
	 * Return Optional.Empty() if clazz is is not assignable from the given argument of the returned function.
	 * 
	 */
	public static <T, R> FunctionalPredicate<T,R> kaas(final Class<T> clazz, final R value) {
		return (T t) -> (t == null) || clazz.isAssignableFrom(t.getClass()) ? Optional.of(value) : Optional.empty();
	}
	
	/**
	 * A case statement.
	 * @param clazz the class that the value of the argument of the returned function should be assignable from.
	 * @param f the function to execute when clazz is assignable from the given argument of the returning function.
	 * It retrieves clazz as it's first argument.
	 * @return the Optional result of f if clazz is assignable from the given argument of the returning function 
	 * Return Optional.Empty() if clazz is not assignable from the given argument of the returning function
	 * 
	 */
	public static <T1,T2, R> FunctionalPredicate<T2,R> kaas(final  Class<T1> clazz, final BiFunction<Class<T1>,T2, R> f) {
		return (T2 t) -> (t == null ||clazz.isAssignableFrom(t.getClass()) ) ? Optional.of(f.apply(clazz,t)) : Optional.empty();
	}
	
	
	/**
	 * A case statement.
	 * @param clazz the class that the value of the argument of the returned function should be assignable from.
	 * @param f the function to execute when clazz is assignable from the given argument of the returning function
	 * @return the Optional result of f if clazz is assignable from the given argument of the returning function 
	 * Return Optional.Empty() if clazz is not assignable from the given argument of the returning function
	 * 
	 */
	public static <T1,T2, R> FunctionalPredicate<T2,R> kaas(final  Class<T1> clazz, final Function<T2, R> f) {
		return (T2 t) -> (t == null ||clazz.isAssignableFrom(t.getClass()) ) ? Optional.of(f.apply(t)) : Optional.empty();
	}
	
	/**
	 * A case statement.
	 * @param p the predicate
	 * @param f the function to execute when p is truthy.
	 * @return the Optional result of f if p is truthy. Return Optional.Empty() if p is falsy.
	 */
	public static <T1, T2, R> FunctionalPredicate<T1, R> kaas(final Function<T1, Optional<T2>> p,	final BiFunction<T1,T2, R> f) {
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
	public static <T1, T2, R> FunctionalPredicate<T1,R> kaas(final Function<T1, Optional<T2>> p, final Function<T2, R> f) {
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

	public static <T1, T2, R> FunctionalPredicate<T1, R> kaas(final Function<T1, Optional<T2>> p, final R value) {
		return (T1 t) -> {
			Optional<T2> pOptionalResult = p.apply(t);
			return pOptionalResult.isPresent() ? Optional.of(value) : Optional.empty();
		};
	}
	
	/**
	 * A case statement.
	 * @param p the predicate
	 * @param f the function to execute when p is true
	 * @return the Optional result of f if p is true. Return Optional.Empty() if p is false
	 */
	public static <T, R> FunctionalPredicate<T,R> kaas(final Predicate<T> p, final Function<T, R> f) {
		return (T t) -> p.test(t) ? Optional.of(f.apply(t)) : Optional.empty();
	}
	
	/**
	 * A case statement.
	 * @param p the predicate
	 * @param f the function to execute when p is true
	 * @return the Optional result of value if p is true. Return Optional.Empty() if p is false
	 */
	public static <T, R> FunctionalPredicate<T, R> kaas(final Predicate<T> p, final R value) {
		return (T t) -> p.test(t) ? Optional.of(value) : Optional.empty();
	}
	
	/**
	 * A case statement.
	 * @param t1 value to test for equality with t
	 * @param f the function to execute when p is true
	 * @return the Optional result of f if p is true. Return Optional.Empty() if p is false
	 */
	public static <T, R> FunctionalPredicate<T,R> kaasValue(final T t1, final Function<T, R> f) {
		return (T t) -> (t==null && t1==null) || (t!=null && t.equals(t1)) ? Optional.of(f.apply(t)) : Optional.empty();
	}
	
	
	/**
	 * A case statement.
	 * @param v the value to test for equality with t
	 * @param f the function to execute when p is true
	 * @return the Optional result of value if p is true. Return Optional.Empty() if p is false
	 */
	public static <T, R> FunctionalPredicate<T, R> kaasValue(T t1, final R value) {
		return (T t) -> (t==null && t1==null) || (t!=null && t.equals(t1)) ? Optional.of(value) : Optional.empty();
	}
	
	
	/**
	 * A default case statement.
	 * @param p the predicate
	 * @param f the function to execute when p is truthy.
	 * @return the Optional result of f if p is truthy. Return Optional.Empty() if p is falsy.
	 */
	public static <T, R> FunctionalPredicate<T,R> orelse(final Function<T, R> f) {
		return (T t) -> {
			return Optional.of(f.apply(t));
		};
	}
	
	/**
	 * A default case statement.
	 * @param value to return for every t.
	 * @return Optional.of(value)
	 */
	public static <T, R> FunctionalPredicate<T, R> orelse(final R value) {
		return (T t) -> {
			return Optional.of(value);
		};
	}
}
