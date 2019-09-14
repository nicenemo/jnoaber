package eu.hanskruse.trackhacks.noaber.with;

import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *  Predicate Support.
 */
public interface WithPredicate {

  /**
   * Right apply to turn a {@code BiPredicate} into a {@code Predicate}.
   * @param p the {@code BiPredicate} to rightApply into a {@code Predicate}
   */
  default <T1, T2> Function<T2,Predicate<T1>> rightApply(final BiPredicate<T1, T2> p) {
    return t2 -> t1 -> p.test(t1, t2);
  }

  /**
   * Left apply to turn a {@code BiPredicate} into a {@code Predicate}.
   * @param p the {@code BiPredicate} to leftApply into a {@code Predicate}
   */
  default <T1, T2> Function<T1,Predicate<T2>> leftApply(final BiPredicate<T1, T2> p) {
    return t1 -> t2 -> p.test(t1, t2);
  }

  default <T1,T2,R> Function<T2,Function<T1,R>> rightApply(final BiFunction<T1,T2,R> f){
    return (T2 t2) -> (T1 t1) -> f.apply(t1,t2);
  }

  default <T1,T2,R> Function<T1,Function<T2,R>> leftApply(final BiFunction<T1,T2,R> f){
    return (T1 t1) -> (T2 t2) -> f.apply(t1,t2);
  }


}
