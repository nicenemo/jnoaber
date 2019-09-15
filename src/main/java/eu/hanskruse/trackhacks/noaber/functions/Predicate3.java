package eu.hanskruse.trackhacks.noaber.functions;

/**
 * A predicate with 3 arguments.
 * @param <T1> 1st type argument
 * @param <T2> 2nd type argument
 * @param <T3> 3th type argument
 */
@FunctionalInterface
public interface Predicate3<//
    T1, //
    T2, //
    T3> {

    /**
     * Test the predicate.
     * @param t1 1st argument
     * @param t2 2nd argument
     * @param t3 3th argument
     * @return the test result
     */
    public boolean test(//
      T1 t1, //
      T2 t2, //
      T3 t3);
}
