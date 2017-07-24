package eu.hanskruse.trackhacks.noaber;

import java.util.Arrays;
import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Noaber library with all kinds of handy functionality.
 * 
 * @author Hans Kruse
 *
 */
public final class $ {
    /**
     * Not to be instantiated.
     */
	private $()
    {
    	//do nothing
    }
    //BEGIN: Identity
	/** Identity Function that only returns its arguments.
	 * @param argument argument to return
	 * @return argument
	 */
	public static <T> T identity(final T argument){
		return argument;
	}
	
	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static boolean identity(final boolean argument) {
		return argument;
	}

	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static int identity(final int argument) {
		return argument;
	}
	
	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static long identity(final long argument) {
		return argument;
	}
	
	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static double identity(final double argument) {
		return argument;
	}
	
	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static float identity(final float argument) {
		return argument;
	}
	
	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static short identity(final short argument) {
		return argument;
	}
	
	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static String identity(final String argument) {
		return argument;
	}
	
	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static boolean[] identity(final boolean[] argument) {
		return argument;
	}

	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static int[] identity(final int[] argument) {
		return argument;
	}
	
	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static long[] identity(final long[] argument) {
		return argument;
	}
	
	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static double[] identity(final double[] argument) {
		return argument;
	}
	
	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static float[] identity(final float[] argument) {
		return argument;
	}
	
	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static short[] identity(final short[] argument) {
		return argument;
	}
	
	/**
	 * Identity function that only returns it's arguments.
	 * 
	 * @param argument
	 *            the argument to return
	 * @return argument
	 */
	public static String[] identity(final String[] argument) {
		return argument;
	}
	//END: Identity
	
	// BEGIN: Curry
	/**
	 * Partially applies a binary operator with the leftmost argument.
	 * 
	 * @param operator
	 *            operator to lefApply on
	 * @return a function that accepts an argument for the rightmost agument of
	 *         the binary operator
	 */
	public static <T> Function<T, Function<T, T>> leftCurry(final BinaryOperator<T> operator) {
		return (u) -> (t) -> operator.apply(u, t);
	}

	/**
	 * Partially applies a bifunction with the leftmost argument.
	 * 
	 * @param f
	 *            operator to lefApply on
	 * @return a function that accepts an argument for the rightmost argument
	 *         for the bifunction
	 */
	public static <T, U, R> Function<T, Function<U, R>> leftCurry(final BiFunction<T, U, R> f) {
		return (u) -> (t) -> f.apply(u, t);
	}

	/**
	 * Partially applies a binary operator with the rightmost argument.
	 * 
	 * @param operator
	 *            operator to rightApply on
	 * @return a function that accepts an argument for the leftmost argument of
	 *         the binary operator
	 */
	public static <T> Function<T, Function<T, T>> rightCurry(final BinaryOperator<T> operator) {
		return (t) -> (u) -> operator.apply(u, t);
	}

	/**
	 * Partially applies a bifunction with the rightmost argument.
	 * 
	 * @param f
	 *            operator to rightApply on
	 * @return a function that accepts an argument for the leftmost argument for
	 *         the bifunction
	 */
	public static <U, T, R> Function<T, Function<U, R>> rightCurry(final BiFunction<U, T, R> f) {
		return (t) -> (u) -> f.apply(u, t);
	}
	// END: Curry
	
	// BEGIN: Compose
	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, R> Function<T1,R> compose(
			final Function<T1, T2> f1, //
			final Function<T2, R> f2) {
		if(stream(f1,f2).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f2.apply( //
			   f1.apply( //
			   argument));
	}

	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, R> Function<T1,R> compose(
			final Function<T1, T2> f1, //
			final Function<T2, T3> f2, //
			final Function<T3, R> f3) {
		if(stream(f1,f2,f3).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f3.apply( //
			   f2.apply( //
			   f1.apply( //
			   argument)));
	}

	/**
	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @param f4 fourth function
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, T4, R> Function<T1,R> compose( //
			final Function<T1, T2> f1, // 
			final Function<T2, T3> f2, //
			final Function<T3, T4> f3, //
			final Function<T4, R> f4) {
		if(stream(f1,f2,f3,f4).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f4.apply( //
			   f3.apply( //
			   f2.apply( //
			   f1.apply( //
			   argument))));
	}

	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @param f4 fourth function
	 * @param f5 fifth function
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, T4, T5, R> Function<T1,R> compose(  //
			final Function<T1, T2> f1, //
			final Function<T2, T3> f2, // 
			final Function<T3, T4> f3, //
			final Function<T4, T5> f4, //
			final Function<T5, R> f5) {
		if(stream(f1,f2,f3,f4,f5).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f5.apply( //
			   f4.apply( //
			   f3.apply( //
			   f2.apply( //
			   f1.apply(
			   argument)))));
	}

	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @param f4 fourth function
	 * @param f5 fifth function
	 * @param f6 sixth function
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, T4, T5, T6, R> Function<T1,R> compose( //
			final Function<T1, T2> f1, //
			final Function<T2, T3> f2, //
			final Function<T3, T4> f3, //
			final Function<T4, T5> f4, //
			final Function<T5, T6> f5, //
			final Function<T6, R> f6) {
		if(stream(f1,f2,f3,f4,f5,f6).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f6.apply( // 
			   f5.apply( // 
			   f4.apply( // 
			   f3.apply( //
			   f2.apply( // 
			   f1.apply( //
			   argument))))));
	}

	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @param f4 fourth function
	 * @param f5 fifth function
	 * @param f6 sixth function
	 * @param f7 sixth function
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, T4, T5, T6, T7, R> Function<T1,R> compose( //
			final Function<T1, T2> f1, //
			final Function<T2, T3> f2, //
			final Function<T3, T4> f3, //
			final Function<T4, T5> f4, //
			final Function<T5, T6> f5, //
			final Function<T6, T7> f6,
			final Function<T7, R> f7) {
		if(stream(f1,f2,f3,f4,f5,f6,f7).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f7.apply( //
			   f6.apply( //
			   f5.apply( //
			   f4.apply( //
			   f3.apply( //
			   f2.apply( //
			   f1.apply( //
			   argument)))))));
	}

	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @param f4 fourth function
	 * @param f5 fifth function
	 * @param f6 sixth function
	 * @param f7 sixth function
	 * @param f8 eighth function
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<T1,R> compose( //
			final Function<T1, T2> f1, //
			final Function<T2, T3> f2, // 
			final Function<T3, T4> f3, //
			final Function<T4, T5> f4, // 
			final Function<T5, T6> f5, //
			final Function<T6, T7> f6, // 
			final Function<T7, T8> f7, //
			final Function<T8, R> f8) {
		if(stream(f1,f2,f3,f4,f5,f6,f7,f8).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f8.apply( //
			   f7.apply( //
			   f6.apply( //
			   f5.apply( //
			   f4.apply( //
			   f3.apply( //
			   f2.apply( //
			   f1.apply( //
			   argument))))))));
	}

	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @param f4 fourth function
	 * @param f5 fifth function
	 * @param f6 sixth function
	 * @param f7 sixth function
	 * @param f8 eighth function
	 * @param f9 ninth function
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<T1,R> compose(//
			final Function<T1, T2> f1, //
			final Function<T2, T3> f2, // 
			final Function<T3, T4> f3, // 
			final Function<T4, T5> f4, // 
			final Function<T5, T6> f5, //
			final Function<T6, T7> f6, //
			final Function<T7, T8> f7, // 
			final Function<T8, T9> f8, //
			final Function<T9, R> f9)  {
		if(stream(f1,f2,f3,f4,f5,f6,f7,f8,f9).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f9.apply( //
			   f8.apply( //
			   f7.apply( //
			   f6.apply( //
			   f5.apply( //
			   f4.apply( //
			   f3.apply( //
			   f2.apply( //
			   f1.apply( //
			   argument)))))))));
	}

	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @param f4 fourth function
	 * @param f5 fifth function
	 * @param f6 sixth function
	 * @param f7 sixth function
	 * @param f8 eighth function
	 * @param f9 ninth function
	 * @param f10 tenth function
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> Function<T1,R> compose( //
			final Function<T1, T2> f1, //
			final Function<T2, T3> f2, //
			final Function<T3, T4> f3, //
			final Function<T4, T5> f4, //
			final Function<T5, T6> f5, //
			final Function<T6, T7> f6, //
			final Function<T7, T8> f7, //
			final Function<T8, T9> f8, //
			final Function<T9, T10> f9, //
			final Function<T10, R> f10) {
		if(stream(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f10.apply( //
			   f9.apply( //
			   f8.apply( //
			   f7.apply( //
			   f6.apply( // 
			   f5.apply( //
			   f4.apply( //
			   f3.apply( //
			   f2.apply( //
			   f1.apply( //
			   argument))))))))));
	}
	

	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @param f4 fourth function
	 * @param f5 fifth function
	 * @param f6 sixth function
	 * @param f7 sixth function
	 * @param f8 eighth function
	 * @param f9 ninth function
	 * @param f10 tenth function
	 * @param f11 eleventh function   
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> Function<T1,R> compose( //
			final Function<T1, T2> f1, //
			final Function<T2, T3> f2, //
			final Function<T3, T4> f3, //
			final Function<T4, T5> f4, //
			final Function<T5, T6> f5, //
			final Function<T6, T7> f6, //
			final Function<T7, T8> f7, //
			final Function<T8, T9> f8, //
			final Function<T9, T10> f9, //
			final Function<T10, T11> f10, //
			final Function<T11,R> f11) {
		if(stream(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f11.apply( //
			   f10.apply( //
			   f9.apply( //
			   f8.apply( //
			   f7.apply( //
			   f6.apply( // 
			   f5.apply( //
			   f4.apply( //
			   f3.apply( //
			   f2.apply( //
			   f1.apply( //
			   argument)))))))))));
	}
	
	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @param f4 fourth function
	 * @param f5 fifth function
	 * @param f6 sixth function
	 * @param f7 sixth function
	 * @param f8 eighth function
	 * @param f9 ninth function
	 * @param f10 tenth function
	 * @param f11 eleventh function   
	 * @param f12 twelfth function       
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> Function<T1,R> compose( //
			final Function<T1, T2> f1, //
			final Function<T2, T3> f2, //
			final Function<T3, T4> f3, //
			final Function<T4, T5> f4, //
			final Function<T5, T6> f5, //
			final Function<T6, T7> f6, //
			final Function<T7, T8> f7, //
			final Function<T8, T9> f8, //
			final Function<T9, T10> f9, //
			final Function<T10, T11> f10, //
			final Function<T11,T12> f11, //
			final Function<T12,R> f12) {
		if(stream(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f12.apply( //
			   f11.apply( //
			   f10.apply( //
			   f9.apply( //
			   f8.apply( //
			   f7.apply( //
			   f6.apply( // 
			   f5.apply( //
			   f4.apply( //
			   f3.apply( //
			   f2.apply( //
			   f1.apply( //
			    argument))))))))))));
	}

	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @param f4 fourth function
	 * @param f5 fifth function
	 * @param f6 sixth function
	 * @param f7 sixth function
	 * @param f8 eighth function
	 * @param f9 ninth function
	 * @param f10 tenth function
	 * @param f11 eleventh function   
	 * @param f12 twelfth function     
	 * @param f13 thirteenth function  
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> Function<T1,R> compose( //
			final Function<T1, T2> f1, //
			final Function<T2, T3> f2, //
			final Function<T3, T4> f3, //
			final Function<T4, T5> f4, //
			final Function<T5, T6> f5, //
			final Function<T6, T7> f6, //
			final Function<T7, T8> f7, //
			final Function<T8, T9> f8, //
			final Function<T9, T10> f9, //
			final Function<T10, T11> f10, //
			final Function<T11,T12> f11, //
			final Function<T12,T13> f12, //
			final Function<T13,R> f13) {
		if(stream(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f13.apply( //
		       f12.apply( //
			   f11.apply( //
			   f10.apply( //
			   f9.apply( //
			   f8.apply( //
			   f7.apply( //
			   f6.apply( // 
			   f5.apply( //
			   f4.apply( //
			   f3.apply( //
			   f2.apply( //
			   f1.apply( //
			    argument)))))))))))));	
	}
	
	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @param f4 fourth function
	 * @param f5 fifth function
	 * @param f6 sixth function
	 * @param f7 sixth function
	 * @param f8 eighth function
	 * @param f9 ninth function
	 * @param f10 tenth function
	 * @param f11 eleventh function   
	 * @param f12 twelfth function     
	 * @param f13 thirteenth function
	 * @param f14 fourteenth function  
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> Function<T1,R> compose( //
			final Function<T1, T2> f1, //
			final Function<T2, T3> f2, //
			final Function<T3, T4> f3, //
			final Function<T4, T5> f4, //
			final Function<T5, T6> f5, //
			final Function<T6, T7> f6, //
			final Function<T7, T8> f7, //
			final Function<T8, T9> f8, //
			final Function<T9, T10> f9, //
			final Function<T10, T11> f10, //
			final Function<T11,T12> f11, //
			final Function<T12,T13> f12, //
			final Function<T13,T14> f13, //
			final Function<T14,R> f14) {
		if(stream(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f14.apply( //
		       f13.apply( //
		       f12.apply( //
			   f11.apply( //
			   f10.apply( //
			   f9.apply( //
			   f8.apply( //
			   f7.apply( //
			   f6.apply( // 
			   f5.apply( //
			   f4.apply( //
			   f3.apply( //
			   f2.apply( //
			   f1.apply( //
			    argument))))))))))))));	
	}
	
	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @param f4 fourth function
	 * @param f5 fifth function
	 * @param f6 sixth function
	 * @param f7 sixth function
	 * @param f8 eighth function
	 * @param f9 ninth function
	 * @param f10 tenth function
	 * @param f11 eleventh function   
	 * @param f12 twelfth function     
	 * @param f13 thirteenth function
	 * @param f14 fourteenth function
	 * @param f15 fifteenth function  
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> Function<T1,R> compose( //
			final Function<T1, T2> f1, //
			final Function<T2, T3> f2, //
			final Function<T3, T4> f3, //
			final Function<T4, T5> f4, //
			final Function<T5, T6> f5, //
			final Function<T6, T7> f6, //
			final Function<T7, T8> f7, //
			final Function<T8, T9> f8, //
			final Function<T9, T10> f9, //
			final Function<T10, T11> f10, //
			final Function<T11,T12> f11, //
			final Function<T12,T13> f12, //
			final Function<T13,T14> f13, //
			final Function<T14,T15> f14, //
			final Function<T15,R> f15) {
		if(stream(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f15.apply( //
		       f14.apply( //
		       f13.apply( //
		       f12.apply( //
			   f11.apply( //
			   f10.apply( //
			   f9.apply( //
			   f8.apply( //
			   f7.apply( //
			   f6.apply( // 
			   f5.apply( //
			   f4.apply( //
			   f3.apply( //
			   f2.apply( //
			   f1.apply( //
			    argument)))))))))))))));	
	}
	
	/**
	 * Compose function chain.
	 * 
	 * @param f1 first function
	 * @param f2 second function
	 * @param f3 third function
	 * @param f4 fourth function
	 * @param f5 fifth function
	 * @param f6 sixth function
	 * @param f7 sixth function
	 * @param f8 eighth function
	 * @param f9 ninth function
	 * @param f10 tenth function
	 * @param f11 eleventh function   
	 * @param f12 twelfth function     
	 * @param f13 thirteenth function
	 * @param f14 fourteenth function
	 * @param f15 fifteenth function 
	 * @param f16 sixteenth function  
	 * @return result of function chaining.
	 */
	@SuppressWarnings("unchecked")
	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> Function<T1,R> compose( //
			final Function<T1, T2> f1, //
			final Function<T2, T3> f2, //
			final Function<T3, T4> f3, //
			final Function<T4, T5> f4, //
			final Function<T5, T6> f5, //
			final Function<T6, T7> f6, //
			final Function<T7, T8> f7, //
			final Function<T8, T9> f8, //
			final Function<T9, T10> f9, //
			final Function<T10, T11> f10, //
			final Function<T11,T12> f11, //
			final Function<T12,T13> f12, //
			final Function<T13,T14> f13, //
			final Function<T14,T15> f14, //
			final Function<T15,T16> f15, //
			final Function<T16,R> f16) {
		
		 
		if(stream(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16).anyMatch(f -> f == null)){
			throw new IllegalArgumentException("functions should not be null");
		}
		return (argument) -> f16.apply( //
		       f15.apply( //
		       f14.apply( //
		       f13.apply( //
		       f12.apply( //
			   f11.apply( //
			   f10.apply( //
			   f9.apply( //
			   f8.apply( //
			   f7.apply( //
			   f6.apply( // 
			   f5.apply( //
			   f4.apply( //
			   f3.apply( //
			   f2.apply( //
			   f1.apply( //
			    argument))))))))))))))));	
	}
	
	/**
	 * Compose function chain.
	 * 
	 * @param argument argument
	 * @param functions
	 * @return result of function chaining.
	 */
     public static <T> Function<T,T> compose(
			@SuppressWarnings("unchecked")
			final Function<T,T> ...functions) {
		 if(functions == null){
			 throw new IllegalArgumentException("functions is null");
		 }
		 
		 if (functions.length == 0){
			 return $::identity;
		 }
		 
		 if(stream(functions).anyMatch(f -> f == null)) {
			 throw new IllegalArgumentException("functions should not be null");
		 }
		 
		
		 
		 if(functions.length == 1) {
			 return (argument) ->  functions[0].apply(argument);
		 }
		 
		 return (argument) -> {
			 T acc =functions[0].apply(argument);
			 for(int i=1; i<functions.length; i++){
				 acc = functions[i].apply(acc);
			 }
			 return acc;
		 };
		
		 
	}

	// END: Compose
    
    // BEGIN: Partial application
 	/**
 	 * Partially applies a binary operator with the leftmost argument.
 	 * 
 	 * @param operator
 	 *            operator to lefApply on
 	 * @param t
 	 *            the parameter to be applied
 	 * @return a function that accepts an argument for the rightmost agument of
 	 *         the binary operator
 	 */
 	public static <T> Function<T, T> leftApply(final BinaryOperator<T> operator, final T t) {
 		return (u) -> operator.apply(u, t);
 	}

 	/**
 	 * Partially applies a bifunction with the leftmost argument.
 	 * 
 	 * @param operator
 	 *            operator to lefApply on
 	 * @param t
 	 *            the parameter to be applied
 	 * @return a function that accepts an argument for the rightmost argument
 	 *         for the bifunction
 	 */
 	public static <U, T, R> Function<U, R> leftApply(final BiFunction<U, T, R> operator, final T t) {
 		return (u) -> operator.apply(u, t);
 	}

 	/**
 	 * Partially applies a binary operator with the rightmost argument.
 	 * 
 	 * @param operator
 	 *            operator to rightApply on
 	 * @param u
 	 *            the parameter to be applied
 	 * @return a function that accepts an argument for the leftmost argument of
 	 *         the binary operator
 	 */
 	public static <T> Function<T, T> rightApply(final BinaryOperator<T> operator, final T u) {
 		return (t) -> operator.apply(u, t);
 	}

 	/**
 	 * Partially applies a bifunction with the rightmost argument.
 	 * 
 	 * @param operator
 	 *            operator to rightApply on
 	 * @param u
 	 *            the parameter to be applied
 	 * @return a function that accepts an argument for the leftmost argument for
 	 *         the bifunction
 	 */
    public static <U, T, R> Function<T, R> rightApply(final BiFunction<U, T, R> operator, final U u) {
 		return (t) -> operator.apply(u, t);
 	}
    // END: Partial application
 	
 	//BEGIN: VarArg Math
 	/**
	 * Calculates the average over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the average from
	 * @return the average
	 */
	public static double average(final double... items) {
		return doubleSummaryStatistics(items).getAverage();
	}

	/**
	 * Calculates the average over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the average from
	 * @return the average
	 */
	public static float average(final float... items) {
		return sum(items) / items.length;
	}

	/**
	 * Calculates the average over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the average from
	 * @return the average
	 */
	public static double average(final int... items) {
		return intSummaryStatistics(items).getAverage();
	}

	/**
	 * Calculates the average over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the average from
	 * @return the average
	 */
	public static double average(final long... items) {
		return longSummaryStatistics(items).getAverage();
	}

	/**
	 * Calculates the average over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the average from
	 * @return the average
	 */
	public static double average(final short... items) {
		return sum(items) / items.length;
	}

	/**
	 * Calculate the summary statistics on items.
	 * 
	 * @param items
	 *            the items to calculate the statistics on
	 * @return the summary statistics
	 */
	public static DoubleSummaryStatistics doubleSummaryStatistics(final double... items) {
		return stream(items).summaryStatistics();
	}

	/**
	 * Calculate the summary statistics on items.
	 * 
	 * @param items
	 *            the items to calculate the statistics on
	 * @return the summary statistics
	 */
	public static IntSummaryStatistics intSummaryStatistics(final int... items) {
		return stream(items).summaryStatistics();
	}

	/**
	 * Calculate the summary statistics on items.
	 * 
	 * @param items
	 *            the items to calculate the statistics on
	 * @return the summary statistics
	 */
	public static LongSummaryStatistics longSummaryStatistics(final long... items) {
		return stream(items).summaryStatistics();
	}

	/**
	 * Calculates the maximum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the maximum from
	 * @return the maximum
	 */
	public static double max(final double... items) {
		return doubleSummaryStatistics(items).getMax();
	}

	/**
	 * Calculates the maximum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the maximum from
	 * @return the maximum
	 */
	public static float max(final float... items) {
		if (items == null || items.length == 0) {
			throw new IllegalArgumentException("items is null or empty");
		}
		if (items.length == 1) {
			return items[0];

		}

		float acc = items[0];
		final int maxIndex = items.length - 2;
		for (int i = 1; i < maxIndex; i++) {
			acc = Math.max(acc, items[i]);
		}

		return acc;
	}

	/**
	 * Calculates the maximum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the maximum from
	 * @return the maximum
	 */
	public static int max(final int... items) {
		return intSummaryStatistics(items).getMax();
	}

	/**
	 * Calculates the maximum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the maximum from
	 * @return the maximum
	 */
	public static long max(final long... items) {
		return longSummaryStatistics(items).getMax();
	}

	/**
	 * Calculates the maximum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the maximum from
	 * @return the maximum
	 */
	public static short max(final short... items) {
		if (items == null || items.length == 0) {
			throw new IllegalArgumentException("items is null or empty");
		}
		if (items.length == 1) {
			return items[0];

		}

		int acc = items[0];
		final int maxIndex = items.length - 2;
		for (int i = 1; i < maxIndex; i++) {
			acc = Math.max(acc, items[i]);
		}

		return (short) acc;
	}

	/**
	 * Calculates the minimum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the minimum from
	 * @return the maximum
	 */
	public static double min(final double... items) {
		return doubleSummaryStatistics(items).getMin();
	}

	/**
	 * Calculates the minimum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the minimum from
	 * @return the maximum
	 */
	public static float min(final float... items) {
		if (items == null || items.length == 0) {
			throw new IllegalArgumentException("items is null or empty");
		}
		if (items.length == 1) {
			return items[0];

		}

		float acc = items[0];
		final int maxIndex = items.length - 2;
		for (int i = 1; i < maxIndex; i++) {
			acc = Math.min(acc, items[i]);
		}

		return acc;
	}

	/**
	 * Calculates the minimum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the minimum from
	 * @return the maximum
	 */
	public static int min(final int... items) {
		return intSummaryStatistics(items).getMin();
	}

	/**
	 * Calculates the minimum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the minimum from
	 * @return the maximum
	 */
	public static long min(final long... items) {
		return longSummaryStatistics(items).getMin();
	}

	/**
	 * Calculats the minimum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the minumum from
	 * @return the minimum
	 */
	public static short min(final short... items) {
		if (items == null || items.length == 0) {
			throw new IllegalArgumentException("items is null or empty");
		}
		if (items.length == 1) {
			return items[0];

		}

		int acc = items[0];
		final int maxIndex = items.length - 2;
		for (int i = 1; i < maxIndex; i++) {
			acc = Math.min(acc, items[i]);
		}

		return (short) acc;
	}

	/**
	 * Reduce a number of items.
	 * 
	 * @param accumulator
	 *            the reducing operator
	 * @param items
	 *            the items to be reduced
	 * @return the reduced value
	 */
	public static <T> T reduce(final BinaryOperator<T> accumulator, @SuppressWarnings("unchecked") final T... items) {
		Optional<T> result = stream(items).reduce(accumulator);
		if (result.isPresent()) {
			return result.get();
		}
		throw new IllegalStateException(
				String.format("reducing with binary operator %s failed", accumulator.getClass().getCanonicalName()));
	}

	/**
	 * Reduce a number of items.
	 * 
	 * @param identity
	 *            the identity, e.g. 0 for addition, 1 for multiplication.
	 * @param accumulator
	 *            the reducing operator
	 * @param items
	 *            the items to be reduced
	 * @return reduced value
	 */
	public static <T> T reduce(final T identity, final BinaryOperator<T> accumulator,
			@SuppressWarnings("unchecked") final T... items) {
		return stream(items).reduce(identity, accumulator);
	}

	/**
	 * Convert a varargs array to a stream.
	 * 
	 * @param items
	 *            items to convert
	 * @return the converted stream
	 */
	public static DoubleStream stream(final double... items) {
		return Arrays.stream(items);
	}

	/**
	 * Convert a varargs array to a stream.
	 * 
	 * @param items
	 *            items to convert
	 * @return the converted stream
	 */
	public static IntStream stream(final int... items) {
		return Arrays.stream(items);
	}

	/**
	 * Convert a varargs array to a stream.
	 * 
	 * @param items
	 *            items to convert
	 * @return the converted stream
	 */
	public static LongStream stream(final long... items) {
		return Arrays.stream(items);
	}

	/**
	 * Convert a varargs array to a stream.
	 * 
	 * @param items
	 *            items to convert
	 * @return the converted stream
	 */
	@SuppressWarnings("unchecked")
	public static <T> Stream<T> stream(final T... items) {
		return Arrays.stream(items);
	}

	/**
	 * Calculates the sum over a number of items.
	 * 
	 * @param items
	 *            the items to sum the minimum from
	 * @return the maximum
	 */
	public static double sum(final double... items) {
		return doubleSummaryStatistics(items).getSum();
	}

	/**
	 * Calculates the sum over a number of items.
	 * 
	 * @param items
	 *            the items to sum the minimum from
	 * @return the maximum
	 */
	public static float sum(final float... items) {
		if (items == null || items.length == 0) {
			throw new IllegalArgumentException("items is null or empty");
		}
		if (items.length == 1) {
			return items[0];

		}

		float acc = items[0];
		final int maxIndex = items.length - 2;
		for (int i = 1; i < maxIndex; i++) {
			acc += items[i];
		}

		return acc;
	}

	/**
	 * Calculates the sum over a number of items.
	 * 
	 * @param items
	 *            the items to sum
	 * @return the maximum
	 */
	public static long sum(final int... items) {
		return intSummaryStatistics(items).getSum();
	}

	/**
	 * Calculates the sum over a number of items.
	 * 
	 * @param items
	 *            the items to sum
	 * @return the maximum
	 */
	public static long sum(final long... items) {
		return longSummaryStatistics(items).getSum();
	}

	/**
	 * Calculates the sum over a number of items.
	 * 
	 * @param items
	 *            the items to sum
	 * @return the sum of the items
	 */
	public static long sum(final short... items) {
		if (items == null || items.length == 0) {
			throw new IllegalArgumentException("items is null or empty");
		}
		if (items.length == 1) {
			return items[0];

		}

		long acc = items[0];
		final int maxIndex = items.length - 2;
		for (int i = 1; i < maxIndex; i++) {
			acc += items[i];
		}

		return acc;
	}

	/**
	 * Short circuit evaluated multiarg and
	 * 
	 * @param items
	 *            boolean arguments to and
	 * @return true if All boolean items are true, false if one item is false or
	 *         if there are no items or items is null
	 */
	public static boolean and(final boolean... items) {
		if (items == null || items.length == 0) {
			return false;
		}

		for (final boolean item : items) {
			if (!item) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Short circuit evaluated multiarg or
	 * 
	 * @param items
	 *            boolean arguments to or
	 * @return true if All boolean items are true, false if one item is false or
	 *         if there are no items or items is null
	 */
	public static boolean or(final boolean... items) {
		if (items == null || items.length == 0) {
			return false;
		}

		for (final boolean item : items) {
			if (item) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Short circuit evaluated multiarg or
	 * 
	 * @param items predicates
	 *            boolean arguments to or
	 * @return true if All boolean items are true, false if one item is false or
	 *         if there are no items or items is null
	 */
	@SuppressWarnings("unchecked")
	public static <T> Predicate<T> or(final Predicate<T>... items) {
		return (t) -> {
		  if (items == null || items.length == 0) {
			return false;
		  }

		  for (final Predicate<T> item : items) {
			if (item.test(t)) {
				return true;
			}
		  }
		  return false;
		};
	}
	/**
	 * Gets a predicate of a predicate on the supplied items
	 * @param items the items to apply an predicate over with an or in short circuit fashion
	 * @return a predicate of a predicate.
	 */
	@SuppressWarnings("unchecked")
	public static <T> Predicate<Predicate<T>> or(final T... items){
		return predicate -> or(predicate,items);
	}
	
	/**
	 * Applies a predicate of supplied items and or them in short circuit fashion.
	 * @param predicate the predicate to apply to the supplied items
	 * @param items the items to apply the predicate on
	 * @return true on the first item that the predicates gives true on, else false.
	 */
	@SuppressWarnings("unchecked")
	public static <T> boolean or(final Predicate<T> predicate,final T... items) {
			  if (items == null || items.length == 0) {
					return false;
			  }
			  for (final T item : items) {
				  if (predicate.test(item)) {
						return true;
					}
			  }
			  return false;  
	}
	
	
	/**
	 * Gets a predicate of a predicate on the supplied items
	 * @param items the items to apply an predicate over with an or in short circuit fashion
	 * @return a predicate of a predicate.
	 */
	public static <T> Predicate<Predicate<T>> or(final Collection<T> items){
		return predicate -> or(predicate,items);
	}
	
	/**
	 * Applies a predicate of supplied items and or them in short circuit fashion.
	 * @param predicate the predicate to apply to the supplied items
	 * @param items the items to apply the predicate on
	 * @return true on the first item that the predicates gives true on, else false.
	 */
	public static <T> boolean or(final Predicate<T> predicate,final Collection<T> items) {
			  if (items == null || items.isEmpty()) {
					return false;
			  }
			  for (final T item : items) {
				  if (predicate.test(item)) {
						return true;
					}
			  }
			  return false;  
	}
 	//END: VarArg Math
	//BEGIN: Pattern matching
	/**
	 * Match captures the value to match against returning a CaseAcceptor.
	 * @param value the value to capture
	 * @return a CaseAcceptor.
	 */
	public static <T>  CaseAcceptor<T> match(final T value){
		return new CaseAcceptor<>(value);
	}
	
	/**
	 * Creates a pattern matcher to match with
	 * @param cases cases to match with
	 * @return a patter matcher to match the cases with
	 */
	@SuppressWarnings("unchecked")
	public static <T,R> PatternMatcher<T,R> with(final Case<T, R>... cases){
		return new PatternMatcher<>(cases);
	}
	//END: Pattern matching
	
    //BEGIN: Other
	public static <T> FunctionalPredicate<T> asFunctionalPredicate(final Predicate<T> p){
		return (t) -> p.test(t) ? Optional.of(t) : Optional.empty();
	}
	//END: Other
}
