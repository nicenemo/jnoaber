package eu.hanskruse.trackhacks.noaber;

import java.util.function.BiFunction;

/**
 * Wraps a BiFunction with it's left parameter already applied.
 * @author Hans Kruse
 *
 * @param <T> type of the left parameter of the BiFunction
 * @param <V> type of the right parameter of the BiFunciton
 * @param <R> type of the result
 */
public class LeftApplied<T,V,R> {
  private final BiFunction<T,V,R> bf;
  private final T l;
  
  /**
   * Creates a LefApplied.
   * @param biFunction BiFunction to wrap
   * @param left left parameter
   */
  public LeftApplied(final BiFunction<T,V,R> biFunction, final T left) {
    this.bf = biFunction;
    this.l = left;
  }
  
  /**
   * Apply the right parameter.
   * @param right right parameter
   * @return result of a right apply
   */
  public R apply(final V right) {
    return this.bf.apply(this.l, right);
  }

}
