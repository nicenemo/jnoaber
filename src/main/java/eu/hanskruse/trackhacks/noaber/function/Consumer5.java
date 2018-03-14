package eu.hanskruse.trackhacks.noaber.function;

/**
 * Consumer with 5 arguments.
 * @author Hans Kruse
 *
 * @param <T1> type of first argument
 * @param <T2> type of second argument
 * @param <T3> type of third argument
 * @param <T4> type of fourth argument
 * @param <T5> type of fifth argument
 */
@FunctionalInterface
public interface Consumer5<T1, T2, T3, T4, T5> {
	/**
	 * Apply this action to its arguments.
	 * @param t1 first argument
	 * @param t2 second argument
	 * @param t3 third argument
	 * @param t4 fourth argument
	 * @param t5 fifth argument
	 */
	public void apply(T1 t1, T2 t2, T3 t3,T4 t4, T5 t5);
}