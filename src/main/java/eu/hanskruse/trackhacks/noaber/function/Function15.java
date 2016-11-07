package eu.hanskruse.trackhacks.noaber.function;

import java.util.function.Function;

/**
 * Function with 15 arguments.
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
 * @param <T12> type of twelfth argument
 * @param <T13> type of thirteenth argument
 * @param <T14> type of fourteenth argument
 * @param <T15> type of fifteenth argument
 * @param <R> type of result
 */
@FunctionalInterface
public interface Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9,T10, T11, T12, T13, T14, T15, R> {
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
	 * @param t12 twelfth argument
	 * @param t13 thirteenth argument
	 * @param t14 fourteenth argument
	 * @param t15 fifteenth argument
	 * @return the result
	 */
	public R apply(T1 t1, T2 t2, T3 t3,T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15);
	
	/**
	 * Apply a function after this function.
	 * 
	 * @param after
	 *            the function to apply
	 * @return function that has this functions, arguments and the return type
	 *         of after
	 */
	default <V> Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, V> andThen(
			Function<? super R, ? extends V> after) {
		return (T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13,
				T14 t14, T15 t15) -> after.apply(apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
	}
}
