package eu.hanskruse.trackhacks.noaber;
import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

import java.util.Optional;
import java.util.function.Function;

/**
 * Wraps a FunctionalPredicate.
 * @author Hans Kruse
 *
 * @param <T> type of the predicate
 */
public class FunctionalPredicateWrapper<T,R1> {
  private final FunctionalPredicate<T,R1> functionalPredicate;
  
  /**
   * Creates a PredicateWrapper
   * @param value FunctionalPredicate to wrap.
   */
  public FunctionalPredicateWrapper(FunctionalPredicate<T,R1> value) {
    requireNonNull(value);
    this.functionalPredicate = value;
  }
  
  /**
   * function to execute when the wrapped predicate is true.
   * @param f function to execute
   * @return a Case
   */
  public <R> Case<T,R> then(Function<R1,R> f){
   
    return t -> {
      if(isNull(f)) {
        return Optional.empty();
      }
      final Optional<R1> predicateResult= this.functionalPredicate.apply(t);
      if(!predicateResult.isPresent()) {
        return Optional.empty();
      }
      
      final R result= f.apply(predicateResult.get());
      if(isNull(result)) {
        return Optional.empty();
      }
      return Optional.of(result);
    };
  }
  
  /**
   * Value to return when the wrapped predicate is true.
   * @param result
   * @return a Case
   */
  public <R> Case<T,R> then(R result){
    return t -> {
      if(isNull(result)) {
        return Optional.empty();
      }
      final Optional<R1> predicateResult= this.functionalPredicate.apply(t);
      if(!predicateResult.isPresent()) {
        return Optional.empty();
      }
      return Optional.of(result);
    };
  }
}
