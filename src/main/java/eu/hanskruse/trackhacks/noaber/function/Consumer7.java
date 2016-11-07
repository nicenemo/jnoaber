package eu.hanskruse.trackhacks.noaber.function;

/**
 * Consumer with 7 arguments.
 * @author Hans Kruse
 *
 * @param <T1> type of first argument
 * @param <T2> type of second argument
 * @param <T3> type of third argument
 * @param <T4> type of fourth argument
 * @param <T5> type of fifth argument
 * @param <T6> type of sixth argument
 * @param <T7> type of seventh argument
 */
@FunctionalInterface
public interface Consumer7<T1, T2, T3, T4, T5, T6, T7> {
	/**
	 * Apply this consumer to its arguments.
	 * @param t1 first argument
	 * @param t2 second argument
	 * @param t3 third argument
	 * @param t4 fourth argument
	 * @param t5 fifth argument
	 * @param t6 sixth argument
	 * @param t7 seventh argument
	 */
	public void apply(T1 t1, T2 t2, T3 t3,T4 t4, T5 t5, T6 t6, T7 t7);
}
