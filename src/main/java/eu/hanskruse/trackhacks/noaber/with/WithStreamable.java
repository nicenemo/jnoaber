package eu.hanskruse.trackhacks.noaber.with;

import static eu.hanskruse.trackhacks.noaber.Noaber.$;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import eu.hanskruse.trackhacks.noaber.functions.*;
import eu.hanskruse.trackhacks.noaber.Streamable;

/**
* Streamable functionality.
*
* @author Hans Kruse
* @version 1.0.0
* @since 1.0.0
*/
public interface WithStreamable {
  default < //
  T1, //
  T2, //
  R> Streamable<R> forEach2( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  BiFunction< //
  T1, //
  T2, //
  R> f) {
    return forEach2(s1, s2, (t1, t2) -> true, f);
  }
  
  default < //
  T1, //
  T2, //
  R> Streamable<R> forEach2( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  BiPredicate<T1, T2> p, //
  BiFunction< //
  T1, //
  T2, //
  R> f) {
    return s1.flatMap( //
    t1 -> s2.filter(//
    $().leftApply(p).apply(t1)).map( //
    $().leftApply(f).apply( //
    t1)));
  }
  
  default <//
  T1, //
  T2, //
  T3, //
  R> Streamable<R> forEach3( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Function3< //
  T1, //
  T2, //
  T3, //
  R> f) {
    return forEach3(s1, s2, s3, (t1, t2, t3) -> true, f);
  }
  
  default <//
  T1, //
  T2, //
  T3, //
  R> Streamable<R> forEach3( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Predicate3< //
  T1, //
  T2, //
  T3> p, //
  final Function3< //
  T1, //
  T2, //
  T3, //
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.map( //
    t3 -> f.apply( //
    t1, //
    t2, //
    t3))));
  }
  
  
  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  R> Streamable<R> forEach4( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Function4< //
  T1, //
  T2, //
  T3, //
  T4, //
  R> f) {
    return forEach4(s1,s2,s3,s4,(t1, t2, t3, t4) -> true, f);
  }
  
  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  R> Streamable<R> forEach4( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Predicate4< //
  T1, //
  T2, //
  T3, //
  T4> p, //
  final Function4< //
  T1, //
  T2, //
  T3, //
  T4, //
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.map( //
    t4 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4)))));
  }
  
  
  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  R> Streamable<R> forEach5( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Function5< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  R> f) {
    return forEach5(s1,s2,s3,s4,s5,(t1,t2,t3,t4,t5) -> true, f);
  }
  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  R> Streamable<R> forEach5( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Predicate5< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5> p, //
  final Function5< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.map( //
    t5 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5))))));
  }
  
  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  R> Streamable<R> forEach6( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Function6< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  R> f) {
    return forEach6(s1,s2,s3,s4,s5,s6,(t1,t2,t3,t4,t5,t6) -> true, f);
  }
  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  R> Streamable<R> forEach6( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Predicate6< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6> p, //
  final Function6< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.map( //
    t6 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6)))))));
  }
  
  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  R> Streamable<R> forEach7( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Function7< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  R> f) {
    return forEach7(s1,s2,s3,s4,s5,s6,s7,(t1,t2,t3,t4,t5,t6,t7) -> true, f);
  }
  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  R> Streamable<R> forEach7( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Predicate7< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7> p, //
  final Function7< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.map(//
    t7 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7))))))));
  }
  
  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  R> Streamable<R> forEach8( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Function8< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  R> f) {
    return forEach8(s1,s2,s3,s4,s5,s6,s7,s8, (t1,t2,t3,t4,t5,t6,t7,t8) -> true, f);
  }
  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  R> Streamable<R> forEach8( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Predicate8< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8> p, //
  final Function8< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.map(//
    t8 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8)))))))));
  }
  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9, //
  R> Streamable<R> forEach9( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Function9< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9, //
  R> f) {
    return forEach9(s1,s2,s3,s4,s5,s6,s7,s8,s9,(t1,t2,t3,t4,t5,t6,t7,t8,t9) -> true, f);
  }
  default < //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9, //
  R> Streamable<R> forEach9( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Predicate9< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9> p,
  final Function9< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9, //
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.map(t9 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9))))))))));
  }
  default < //
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
  R> Streamable<R> forEach10( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Function10< //
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
  R> f) {
    return forEach10(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10, (t1,t2,t3,t4,t5,t6,t7,t8,t9,t10) -> true, f);
  }
  
  default < //
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
  R> Streamable<R> forEach10( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Predicate10< //
  T1, //
  T2, //
  T3, //
  T4, //
  T5, //
  T6, //
  T7, //
  T8, //
  T9, //
  T10> p, //
  final Function10< //
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
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.map( //
    t10 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10)))))))))));
  }
  
  default < //
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
  R> Streamable<R> forEach11( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Streamable<T11> s11, //
  final Function11< //
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
  R> f) {
    return forEach11(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11, (t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11) -> true, f);
  }
  default < //
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
  R> Streamable<R> forEach11( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Streamable<T11> s11, //
  final Predicate11< //
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
  T11> p, //
  final Function11< //
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
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.flatMap( //
    t10 -> s11.map(t11 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10, //
    t11))))))))))));
  }
  
  default < //
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
  R> Streamable<R> forEach12( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Streamable<T11> s11, //
  final Streamable<T12> s12, //
  final Function12< //
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
  R> f) {
    return forEach12(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12) -> true, f);
  }
  default < //
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
  R> Streamable<R> forEach12( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Streamable<T11> s11, //
  final Streamable<T12> s12, //
  final Predicate12< //
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
  T12> p, //
  final Function12< //
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
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.flatMap( //
    t10 -> s11.flatMap( //
    t11 -> s12.map(t12 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10, //
    t11, //
    t12)))))))))))));
  }
  
  default < //
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
  R> Streamable<R> forEach( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Streamable<T11> s11, //
  final Streamable<T12> s12, //
  final Streamable<T13> s13, //
  final Function13< //
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
  R> f) {
    return forEach13(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13) -> true, f);
  }
  default < //
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
  R> Streamable<R> forEach13( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Streamable<T11> s11, //
  final Streamable<T12> s12, //
  final Streamable<T13> s13, //
  final Predicate13< //
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
  T13> p, //
  final Function13< //
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
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.flatMap( //
    t10 -> s11.flatMap( //
    t11 -> s12.flatMap( //
    t12 -> s13.map(//
    t13 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10, //
    t11, //
    t12, //
    t13))))))))))))));
  }
  
  default < //
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
  T14, //
  R> Streamable<R> forEach14( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Streamable<T11> s11, //
  final Streamable<T12> s12, //
  final Streamable<T13> s13, //
  final Streamable<T14> s14, //
  final Function14< //
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
  T14, //
  R> f) {
    return forEach14(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14) -> true, f);
  }
  default < //
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
  T14, //
  R> Streamable<R> forEach14( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Streamable<T11> s11, //
  final Streamable<T12> s12, //
  final Streamable<T13> s13, //
  final Streamable<T14> s14, //
  final Predicate14< //
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
  T14> p, //
  final Function14< //
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
  T14, //
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.flatMap( //
    t10 -> s11.flatMap( //
    t11 -> s12.flatMap( //
    t12 -> s13.flatMap(//
    t13 -> s14.map( //
    t14 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10, //
    t11, //
    t12, //
    t13, //
    t14)))))))))))))));
  }
  
  default < //
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
  T14, //
  T15, //
  R> Streamable<R> forEach15( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Streamable<T11> s11, //
  final Streamable<T12> s12, //
  final Streamable<T13> s13, //
  final Streamable<T14> s14, //
  final Streamable<T15> s15, //
  final Function15< //
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
  T14, //
  T15, //
  R> f) {
    return forEach15(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15, (t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15) -> true,f);
  }
  default < //
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
  T14, //
  T15, //
  R> Streamable<R> forEach15( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Streamable<T11> s11, //
  final Streamable<T12> s12, //
  final Streamable<T13> s13, //
  final Streamable<T14> s14, //
  final Streamable<T15> s15, //
  final Predicate15< //
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
  T14, //
  T15> p, //
  final Function15< //
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
  T14, //
  T15, //
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.flatMap( //
    t10 -> s11.flatMap( //
    t11 -> s12.flatMap( //
    t12 -> s13.flatMap(//
    t13 -> s14.flatMap( //
    t14 -> s15.map( //
    t15 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10, //
    t11, //
    t12, //
    t13, //
    t14, //
    t15))))))))))))))));
  }
  
  default < //
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
  T14, //
  T15, //
  T16, //
  R> Streamable<R> forEach16( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Streamable<T11> s11, //
  final Streamable<T12> s12, //
  final Streamable<T13> s13, //
  final Streamable<T14> s14, //
  final Streamable<T15> s15, //
  final Streamable<T16> s16, //
  final Function16< //
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
  T14, //
  T15, //
  T16, //
  R> f) {
    return forEach16(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16, (t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16)-> true, f);
  }
  default < //
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
  T14, //
  T15, //
  T16, //
  R> Streamable<R> forEach16( //
  final Streamable<T1> s1, //
  final Streamable<T2> s2, //
  final Streamable<T3> s3, //
  final Streamable<T4> s4, //
  final Streamable<T5> s5, //
  final Streamable<T6> s6, //
  final Streamable<T7> s7, //
  final Streamable<T8> s8, //
  final Streamable<T9> s9, //
  final Streamable<T10> s10, //
  final Streamable<T11> s11, //
  final Streamable<T12> s12, //
  final Streamable<T13> s13, //
  final Streamable<T14> s14, //
  final Streamable<T15> s15, //
  final Streamable<T16> s16, //
  final Predicate16< //
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
  T14, //
  T15, //
  T16> p,
  final Function16< //
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
  T14, //
  T15, //
  T16, //
  R> f) {
    return s1.flatMap( //
    t1 -> s2.flatMap( //
    t2 -> s3.flatMap( //
    t3 -> s4.flatMap( //
    t4 -> s5.flatMap( //
    t5 -> s6.flatMap( //
    t6 -> s7.flatMap( //
    t7 -> s8.flatMap( //
    t8 -> s9.flatMap( //
    t9 -> s10.flatMap( //
    t10 -> s11.flatMap( //
    t11 -> s12.flatMap( //
    t12 -> s13.flatMap(//
    t13 -> s14.flatMap( //
    t14 -> s15.flatMap( //
    t15 -> s16.map( //
    t16 -> f.apply( //
    t1, //
    t2, //
    t3, //
    t4, //
    t5, //
    t6, //
    t7, //
    t8, //
    t9, //
    t10, //
    t11, //
    t12, //
    t13, //
    t14, //
    t15, //
    t16)))))))))))))))));
  }
}
