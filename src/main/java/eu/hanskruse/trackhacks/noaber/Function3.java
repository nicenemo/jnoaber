package eu.hanskruse.trackhacks.noaber;

/**
 * A function with 3 arguments.
 * @param <T1> 1st type argument
 * @param <T2> 2nd type argument
 * @param <T3> 3th type argument
 * @param <R> type argument for the return type
 */
@FunctionalInterface
public interface Function3<//
    T1, //
    T2, //
    T3, //
    R> {

    /**
     * Apply the function.
     * @param t1 1st argument
     * @param t2 2nd argument
     * @param t3 3th argument
     * @return the result of applying the function
     */  
    public R apply(//
      T1 t1, //
      T2 t2, //
      T3 t3);
}