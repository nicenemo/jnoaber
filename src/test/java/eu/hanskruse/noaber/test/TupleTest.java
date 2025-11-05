package eu.hanskruse.noaber.test;

import static eu.hanskruse.noaber.Noaber.$;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import eu.hanskruse.noaber.tuples.Tuple;
import eu.hanskruse.noaber.tuples.Tuple0;
import eu.hanskruse.noaber.tuples.Tuple1;
import eu.hanskruse.noaber.tuples.Tuple2;
import eu.hanskruse.noaber.tuples.Tuple3;
import eu.hanskruse.noaber.tuples.Tuple4;
import eu.hanskruse.noaber.tuples.Tuple5;
import eu.hanskruse.noaber.tuples.Tuple6;
import eu.hanskruse.noaber.tuples.Tuple7;
import eu.hanskruse.noaber.tuples.Tuple8;
import eu.hanskruse.noaber.tuples.Tuple9;
import eu.hanskruse.noaber.tuples.Tuple10;
import eu.hanskruse.noaber.tuples.Tuple11;
import eu.hanskruse.noaber.tuples.Tuple12;
import eu.hanskruse.noaber.tuples.Tuple13;
import eu.hanskruse.noaber.tuples.Tuple14;
import eu.hanskruse.noaber.tuples.Tuple15;
import eu.hanskruse.noaber.tuples.Tuple16;
import eu.hanskruse.noaber.WithNoaber;

final class TupleTest implements WithNoaber {

  // tuple element types.
  private static final class T0 {
  }

  private static final class T1 {
  }

  private static final class T2 {
  }

  private static final class T3 {
  }

  private static final class T4 {
  }

  private static final class T5 {
  }

  private static final class T6 {
  }

  private static final class T7 {
  }

  private static final class T8 {
  }

  private static final class T9 {
  }

  private static final class T10 {
  }

  private static final class T11 {
  }

  private static final class T12 {
  }

  private static final class T13 {
  }

  private static final class T14 {
  }

  private static final class T15 {
  }

  // exected tuple element values.
  private static final T0 ET_0 = new T0();
  private static final T1 ET_1 = new T1();
  private static final T2 ET_2 = new T2();
  private static final T3 ET_3 = new T3();
  private static final T4 ET_4 = new T4();
  private static final T5 ET_5 = new T5();
  private static final T6 ET_6 = new T6();
  private static final T7 ET_7 = new T7();
  private static final T8 ET_8 = new T8();
  private static final T9 ET_9 = new T9();
  private static final T10 ET_10 = new T10();
  private static final T11 ET_11 = new T11();
  private static final T12 ET_12 = new T12();
  private static final T13 ET_13 = new T13();
  private static final T14 ET_14 = new T14();
  private static final T15 ET_15 = new T15();

  private static final Tuple0 TUPLE_0 = $.tuple();
  private static final Tuple1<T0> TUPLE_1 = $.tuple(//
  ET_0);
  private static final Tuple2<T0, T1> TUPLE_2 = $.tuple(//
  ET_0, //
  ET_1);

  private static final Tuple3<T0, T1, T2> TUPLE_3 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2);

  private static final Tuple4<T0, T1, T2, T3> TUPLE_4 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2, //
  ET_3);

  private static final Tuple5<T0, T1, T2, T3, T4> TUPLE_5 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2, //
  ET_3, //
  ET_4);

  private static final Tuple6<T0, T1, T2, T3, T4, T5> TUPLE_6 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2, //
  ET_3, //
  ET_4, //
  ET_5);

  private static final Tuple7<T0, T1, T2, T3, T4, T5, T6> TUPLE_7 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2, //
  ET_3, //
  ET_4, //
  ET_5, //
  ET_6);

  private static final Tuple8<T0, T1, T2, T3, T4, T5, T6, T7> TUPLE_8 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2, //
  ET_3, //
  ET_4, //
  ET_5, //
  ET_6, //
  ET_7);

  private static final Tuple9<T0, T1, T2, T3, T4, T5, T6, T7, T8> TUPLE_9 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2, //
  ET_3, //
  ET_4, //
  ET_5, //
  ET_6, //
  ET_7, //
  ET_8);

  private static final Tuple10<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> T_9_TUPLE_10 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2, //
  ET_3, //
  ET_4, //
  ET_5, //
  ET_6, //
  ET_7, //
  ET_8, //
  ET_9);

  private static final Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> TUPLE_11 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2, //
  ET_3, //
  ET_4, //
  ET_5, //
  ET_6, //
  ET_7, //
  ET_8, //
  ET_9, //
  ET_10);

  private static final Tuple12<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> TUPLE_12 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2, //
  ET_3, //
  ET_4, //
  ET_5, //
  ET_6, //
  ET_7, //
  ET_8, //
  ET_9, //
  ET_10, //
  ET_11);

  private static final Tuple13<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> TUPLE_13 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2, //
  ET_3, //
  ET_4, //
  ET_5, //
  ET_6, //
  ET_7, //
  ET_8, //
  ET_9, //
  ET_10, //
  ET_11, //
  ET_12);

  private static final Tuple14<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> TUPLE_14 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2, //
  ET_3, //
  ET_4, //
  ET_5, //
  ET_6, //
  ET_7, //
  ET_8, //
  ET_9, //
  ET_10, //
  ET_11, //
  ET_12, //
  ET_13);

  private static final Tuple15<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> TUPLE_15 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2, //
  ET_3, //
  ET_4, //
  ET_5, //
  ET_6, //
  ET_7, //
  ET_8, //
  ET_9, //
  ET_10, //
  ET_11, //
  ET_12, //
  ET_13, //
  ET_14);

  private static final Tuple16<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> TUPLE_16 = $.tuple(//
  ET_0, //
  ET_1, //
  ET_2, //
  ET_3, //
  ET_4, //
  ET_5, //
  ET_6, //
  ET_7, //
  ET_8, //
  ET_9, //
  ET_10, //
  ET_11, //
  ET_12, //
  ET_13, //
  ET_14, //
  ET_15);

  private final static List<Tuple> TUPLES = new ArrayList<>();
  private final static List<Object> EXPECTED_ELEMENTS = new ArrayList<>();

  @BeforeAll
  static void beforeAll() {
    Collections.addAll(TUPLES, TUPLE_0, TUPLE_1, TUPLE_2, TUPLE_3, TUPLE_4, TUPLE_5, TUPLE_6, TUPLE_7, TUPLE_8, TUPLE_9, T_9_TUPLE_10,
    TUPLE_11, TUPLE_12, TUPLE_13, TUPLE_14, TUPLE_15, TUPLE_16);
    Collections.addAll(EXPECTED_ELEMENTS, ET_0, ET_1, ET_2, ET_3, ET_4, ET_5, ET_6, ET_7, ET_8, ET_9, ET_10, ET_11, ET_12, ET_13, ET_14,
    ET_15);

  }

  public static Stream<Tuple> tuples() {
    return TUPLES.stream();
  }

  public static IntStream intRange() {
    return IntStream.range(0, TUPLES.size());
  }

  @MethodSource("intRange")
  @ParameterizedTest
  void length(int i) {
    assertThat(TUPLES.get(i).size()).isEqualTo(i);
  }

  @MethodSource("tuples")
  @ParameterizedTest
  void tupleValuesAreEqualToExpectedValues(final Tuple sut) {
    final Object[] expected = EXPECTED_ELEMENTS.stream().limit(sut.size()).toArray();
    final Object[] actual = IntStream.range(0, sut.size()).mapToObj(sut::get).toArray();
    assertThat(actual).containsExactly(expected);
  }

  @MethodSource("tuples")
  @ParameterizedTest
  void getWithNegativeIndexIsNotAllowed(final Tuple sut) {
    assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> sut.get(-1));
  }

  @MethodSource("tuples")
  @ParameterizedTest
  void withIndexEqualToSize(final Tuple sut) {
    assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> sut.get(sut.size()));
  }

  @MethodSource("tuples")
  @ParameterizedTest
  void withIndexLargerThanSize(final Tuple sut) {
    assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> sut.get(sut.size() + 1));
  }

  @MethodSource("tuples")
  @ParameterizedTest
  void getAllEqualsGetAllViaIterable(final Tuple sut) {
    final Object[] arrayObtainedViaGet = IntStream.range(0, sut.size()).mapToObj(sut::get).toArray();
    final Object[] arrayObtainedViaIterable = StreamSupport.stream(sut.asIterable().spliterator(), false).toArray();
    assertThat(arrayObtainedViaIterable).containsExactly(arrayObtainedViaGet);
  }

  @MethodSource("tuples")
  @ParameterizedTest
  void GetAllEqualsGetAllViaStream(final Tuple sut) {
    final Object[] arrayObtainedViaGet = IntStream.range(0, sut.size()).mapToObj(sut::get).toArray();
    final Object[] arrayObtainedViaIterable = sut.stream().toArray();
    assertThat(arrayObtainedViaIterable).containsExactly(arrayObtainedViaGet);
  }

  @Test
  void tuple3WithBooleanStringAndInteger() {
    final Tuple sut = tuple(Boolean.TRUE, "Hello", 42);
    final Boolean actualBoolean = sut.get(0);
    assertThat(actualBoolean.booleanValue()).isTrue();
    final var firstValue =sut.get(1);
    assertThat(firstValue).isEqualTo("Hello");
    final Integer actualInteger = sut.get(2);
    assertThat(actualInteger.intValue()).isEqualTo(42);
  }

  @Test
  void tupleIterationWithIntegers() {
    final long expected = 6L;
    final Tuple sut = tuple(1, 2, 3);
    final long actual = sut.stream().map(Integer.class::cast).mapToInt(Integer::intValue).summaryStatistics().getSum();
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void tupleIterationWithIntegersTooButWithouthCast() {
    final long expected = 6L;
    final Tuple sut = tuple(1, 2, 3);
    final Stream<Integer> actualStream = sut.stream();
    final long actual = actualStream.mapToInt(Integer::intValue).summaryStatistics().getSum();
    assertThat(actual).isEqualTo(expected);
  }

  @MethodSource("tuples")
  @ParameterizedTest
  void headTest(final Tuple sut) {
    if (sut instanceof Tuple0) {
      assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(sut::head);
      return;
    }
    final var head = sut.head();
    assertThat(head).isEqualTo(ET_0);
  }

  @MethodSource("tuples")
  @ParameterizedTest
  void lastTest(final Tuple sut) {
    if (sut instanceof Tuple0) {
      assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(sut::head);
      return;
    }
    final Object expectedLastElement = EXPECTED_ELEMENTS.get(sut.size() -1);
    final Object actualLastElement = sut.last();
    assertThat(actualLastElement).isEqualTo(expectedLastElement);
  }

  @MethodSource("tuples")
  @ParameterizedTest
  void tailTest(final Tuple sut) {
    if (sut instanceof Tuple0) {
      assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(sut::tail);
      return;
    }

    final Tuple tail = sut.tail();
    if (sut instanceof Tuple1) {
      assertThat(tail).isInstanceOf(Tuple0.class);
      return;
    }

    final Object expectedFirstOfTail = sut.get(1);
    final Object actualFirstOfTail = tail.head();
    assertThat(actualFirstOfTail).isEqualTo(expectedFirstOfTail);

    final Object expectedLastOfTail = sut.last();
    final Object actualLastOfTail = tail.last();
    assertThat(actualLastOfTail).isEqualTo(expectedLastOfTail);

    final Object[] expectedTailElements = sut.stream().skip(1).toArray();
    final Object[] actualTailElements = tail.stream().toArray();
    assertThat(actualTailElements).containsExactly(expectedTailElements);
  }

  @MethodSource("tuples")
  @ParameterizedTest
  void toArrayTest(final Tuple sut) {
    final Object[] expectedToArrayElements = EXPECTED_ELEMENTS.stream().limit(sut.size()).toArray();
    final Object[] actualToArrayElements = sut.toArray();
    assertThat(actualToArrayElements).containsExactly(expectedToArrayElements);
  }

  @MethodSource("tuples")
  @ParameterizedTest
  void toArrayTestWithProvidedArrayOfCorrectSize(final Tuple sut) {
    final Object[] expectedToArrayElements = EXPECTED_ELEMENTS.stream().limit(sut.size()).toArray();
    final Object[] providedArray = new Object[sut.size()];
    final Object[] actualToArrayElements = sut.toArray(providedArray);
    assertThat(actualToArrayElements)
            .isEqualTo(providedArray)
            .containsExactly(expectedToArrayElements);
  }

  @MethodSource("tuples")
  @ParameterizedTest
  void toArrayTestWithProvidedArrayOfLargerSize(final Tuple sut) {
    final Object[] expectedToArrayElements = EXPECTED_ELEMENTS.stream().limit(sut.size()).toArray();
    final Object[] providedArray = new Object[sut.size() + 1];
    final Object[] actualToArrayElements = sut.toArray(providedArray);
    assertThat(actualToArrayElements).isEqualTo(providedArray);
    final  Object[] truncatedActualArray = Arrays.stream(actualToArrayElements).limit(sut.size()).toArray();
    assertThat(truncatedActualArray).containsExactly(expectedToArrayElements);
  }

  @MethodSource("tuples")
  @ParameterizedTest
  void toArrayTestWithProvidedArrayOSmallerSize(final Tuple sut) {
    if (sut instanceof Tuple0) {
      return;
    }
    final Object[] expectedToArrayElements = EXPECTED_ELEMENTS.stream().limit(sut.size()).toArray();
    final Object[] providedArray = new Object[Math.min(sut.size() - 1, 0)];
    final Object[] actualToArrayElements = sut.toArray(providedArray);
    assertThat(actualToArrayElements)
            .isNotEqualTo(providedArray)
            .containsExactly(expectedToArrayElements);
  }
}
