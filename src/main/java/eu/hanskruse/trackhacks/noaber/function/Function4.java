package eu.hanskruse.trackhacks.noaber.function;

import java.util.function.Function;

/**
 * Function with 4 arguments.
 * @author Hans Kruse
 *
 * @param <T1> type of first argument
 * @param <T2> type of second argument
 * @param <T3> type of third argument
 * @param <T4> type of fourth argument
 * @param <R> type of result
 */
@FunctionalInterface
public interface Function4<T1, T2, T3, T4, R> {
	/**
	 * Apply this function to its arguments.
	 * @param t1 first argument
	 * @param t2 second argument
	 * @param t3 third argument
	 * @param t4 fourth argument
	 * @return the result
	 */
	public R apply(T1 t1, T2 t2, T3 t3,T4 t4);
	
	/**
	 * Apply a function after this function.
	 * 
	 * @param after
	 *            the function to apply
	 * @return function that has this functions, arguments and the return type
	 *         of after
	 */
	default <V> Function4<T1, T2, T3, T4, V> andThen(Function<? super R, ? extends V> after) {
		return (T1 t1, T2 t2, T3 t3, T4 t4) -> after
				.apply(apply(t1, t2, t3, t4));
	}
}
