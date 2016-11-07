package eu.hanskruse.trackhacks.noaber;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * Provides Left and Right partial application on functions
 * @author hkruse
 *
 */
public interface PartialApplication {

	default <T> Function<T,T> leftApply(BinaryOperator <T> operator, T t){
		return (u) -> operator.apply(t, u);
	}
	
	default <T,U,R> Function<U,R> leftApply(BiFunction <T,U,R> operator, T t){
		return (u) ->operator.apply(t, u);
	}
	
	default <T> Function<T,T> rightApply(BinaryOperator <T> operator, T u){
		return (t) -> operator.apply(t, u);
	}
	
	default <T,U,R> Function<T,R> rightApply(BiFunction <T,U,R> operator, U u){
		return (t) ->operator.apply(t, u);
	}
}
