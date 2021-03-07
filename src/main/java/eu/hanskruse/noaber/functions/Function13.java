package eu.hanskruse.noaber.functions;

/**
 * A function with 13 arguments.
 * @param <T1> 1st type argument
 * @param <T2> 2nd type argument
 * @param <T3> 3th type argument
 * @param <T4> 4th type argument
 * @param <T5> 5th type argument
 * @param <T6> 6th type argument
 * @param <T7> 7th type argument
 * @param <T8> 8th type argument
 * @param <T9> 9th type argument
 * @param <T10> 10th type argument
 * @param <T11> 11th type argument
 * @param <T12> 12th type argument
 * @param <T13> 13th type argument
 * @param <R> type argument for the return type
 */
@FunctionalInterface
public interface Function13<//
    T1, //
    T2, //
    T3, //
    T4, //
    T5, //
    T6, //
    T7, //
    T8, //
    T9, //
    T10, //
    T11, //
    T12, //
    T13, //
    R> {

    /**
     * Apply the function.
     * @param t1 1st argument
     * @param t2 2nd argument
     * @param t3 3th argument
     * @param t4 4th argument
     * @param t5 5th argument
     * @param t6 6th argument
     * @param t7 7th argument
     * @param t8 8th argument
     * @param t9 9th argument
     * @param t10 10th argument
     * @param t11 11th argument
     * @param t12 12th argument
     * @param t13 13th argument
     * @return the result of applying the function
     */
    public R apply(//
      T1 t1, //
      T2 t2, //
      T3 t3, //
      T4 t4, //
      T5 t5, //
      T6 t6, //
      T7 t7, //
      T8 t8, //
      T9 t9, //
      T10 t10, //
      T11 t11, //
      T12 t12, //
      T13 t13);
}
