package eu.hanskruse.trackhacks.noaber.function;

import java.util.function.Function;

/**
 * Function with 11 arguments.
 * @author Hans Kruse
 *
 * @param <T1> type of first argument
 * @param <T2> type of second argument
 * @param <T3> type of third argument
 * @param <T4> type of fourth argument
 * @param <T5> type of fifth argument
 * @param <T6> type of sixth argument
 * @param <T7> type of seventh argument
 * @param <T8> type of eight argument
 * @param <T9> type of ninth argument
 * @param <T10> type of tenth argument
 * @param <T11> type of eleventh argument
 * @param <R> type of result
 */
@FunctionalInterface
public interface Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9,T10, T11, R> {
	/**
	 * Apply this function to its arguments.
	 * @param t1 first argument
	 * @param t2 second argument
	 * @param t3 third argument
	 * @param t4 fourth argument
	 * @param t5 fifth argument
	 * @param t6 sixth argument
	 * @param t7 seventh argument
	 * @param t8 eight argument
	 * @param t9 ninth argument
	 * @param t10 tenth argument
	 * @param t11 eleventh argument
	 * @return the result
	 */
	public R apply(T1 t1, T2 t2, T3 t3,T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11);
	
	/**
	 * Apply a function after this function.
	 * 
	 * @param after
	 *            the function to apply
	 * @return function that has this functions, arguments and the return type
	 *         of after
	 */
	default <V> Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, V> andThen(
			Function<? super R, ? extends V> after) {
		return (T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11) -> after
				.apply(apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
	}
}