package eu.hanskruse.trackhacks.noaber;

import java.util.function.BiPredicate;

/**
 * Wraps a BiPredicate with it's right parameter already applied.
 * @author Hans Kruse
 *
 * @param <T> type of the left parameter of the BiPredicate
 * @param <V> type of the right parameter of the BiPredicate
 */
public class LeftAppliedPredicate<T,V> {
  private final BiPredicate<T,V> bf;
  private final T l;

  /**
   * Creates a RightAppliedPredicate.
   * @param biPredicate biPredicate to wrap
   * @param left left parameter
   */
  public LeftAppliedPredicate(final BiPredicate<T,V> biPredicate, final T left) {
    this.bf = biPredicate;
    this.l = left;
  }

  /**
   * Apply the right parameter.
   * @param right right parameter
   * @return result of a left apply
   */
  public boolean test(final V right) {
    return this.bf.test(this.l, right);
  }

}
