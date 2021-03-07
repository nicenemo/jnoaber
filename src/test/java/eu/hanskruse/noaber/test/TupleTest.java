package eu.hanskruse.noaber.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static eu.hanskruse.noaber.Noaber.$;

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

public class TupleTest implements WithNoaber {

  // tuple element types.
  private static final class T0 {
  };

  private static final class T1 {
  };

  private static final class T2 {
  };

  private static final class T3 {
  };

  private static final class T4 {
  };

  private static final class T5 {
  };

  private static final class T6 {
  };

  private static final class T7 {
  };

  private static final class T8 {
  };

  private static final class T9 {
  };

  private static final class T10 {
  };

  private static final class T11 {
  };

  private static final class T12 {
  };

  private static final class T13 {
  };

  private static final class T14 {
  };

  private static final class T15 {
  };

  // exected tuple element values.
  private static final T0 et0 = new T0();
  private static final T1 et1 = new T1();
  private static final T2 et2 = new T2();
  private static final T3 et3 = new T3();
  private static final T4 et4 = new T4();
  private static final T5 et5 = new T5();
  private static final T6 et6 = new T6();
  private static final T7 et7 = new T7();
  private static final T8 et8 = new T8();
  private static final T9 et9 = new T9();
  private static final T10 et10 = new T10();
  private static final T11 et11 = new T11();
  private static final T12 et12 = new T12();
  private static final T13 et13 = new T13();
  private static final T14 et14 = new T14();
  private static final T15 et15 = new T15();

  private static final Tuple0 tuple0 = $().tuple();
  private static final Tuple1<T0> tuple1 = $().tuple(//
      et0);
  private static final Tuple2<T0, T1> tuple2 = $().tuple(//
      et0, //
      et1);

  private static final Tuple3<T0, T1, T2> tuple3 = $().tuple(//
      et0, //
      et1, //
      et2);

  private static final Tuple4<T0, T1, T2, T3> tuple4 = $().tuple(//
      et0, //
      et1, //
      et2, //
      et3);

  private static final Tuple5<T0, T1, T2, T3, T4> tuple5 = $().tuple(//
      et0, //
      et1, //
      et2, //
      et3, //
      et4);

  private static final Tuple6<T0, T1, T2, T3, T4, T5> tuple6 = $().tuple(//
      et0, //
      et1, //
      et2, //
      et3, //
      et4, //
      et5);

  private static final Tuple7<T0, T1, T2, T3, T4, T5, T6> tuple7 = $().tuple(//
      et0, //
      et1, //
      et2, //
      et3, //
      et4, //
      et5, //
      et6);

  private static final Tuple8<T0, T1, T2, T3, T4, T5, T6, T7> tuple8 = $().tuple(//
      et0, //
      et1, //
      et2, //
      et3, //
      et4, //
      et5, //
      et6, //
      et7);

  private static final Tuple9<T0, T1, T2, T3, T4, T5, T6, T7, T8> tuple9 = $().tuple(//
      et0, //
      et1, //
      et2, //
      et3, //
      et4, //
      et5, //
      et6, //
      et7, //
      et8);

  private static final Tuple10<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> tuple10 = $().tuple(//
      et0, //
      et1, //
      et2, //
      et3, //
      et4, //
      et5, //
      et6, //
      et7, //
      et8, //
      et9);

  private static final Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> tuple11 = $().tuple(//
      et0, //
      et1, //
      et2, //
      et3, //
      et4, //
      et5, //
      et6, //
      et7, //
      et8, //
      et9, //
      et10);

  private static final Tuple12<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> tuple12 = $().tuple(//
      et0, //
      et1, //
      et2, //
      et3, //
      et4, //
      et5, //
      et6, //
      et7, //
      et8, //
      et9, //
      et10, //
      et11);

  private static final Tuple13<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> tuple13 = $().tuple(//
      et0, //
      et1, //
      et2, //
      et3, //
      et4, //
      et5, //
      et6, //
      et7, //
      et8, //
      et9, //
      et10, //
      et11, //
      et12);

  private static final Tuple14<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> tuple14 = $().tuple(//
      et0, //
      et1, //
      et2, //
      et3, //
      et4, //
      et5, //
      et6, //
      et7, //
      et8, //
      et9, //
      et10, //
      et11, //
      et12, //
      et13);

  private static final Tuple15<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> tuple15 = $().tuple(//
      et0, //
      et1, //
      et2, //
      et3, //
      et4, //
      et5, //
      et6, //
      et7, //
      et8, //
      et9, //
      et10, //
      et11, //
      et12, //
      et13, //
      et14);

  private static final Tuple16<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> tuple16 = $()
      .tuple(//
          et0, //
          et1, //
          et2, //
          et3, //
          et4, //
          et5, //
          et6, //
          et7, //
          et8, //
          et9, //
          et10, //
          et11, //
          et12, //
          et13, //
          et14, //
          et15);

  private final static List<Tuple> tuples = new ArrayList<>();
  private final static List<Object> expectedElements = new ArrayList<>();

  @BeforeAll
  public static void beforeAll() {
    Collections.addAll(tuples, tuple0, tuple1, tuple2, tuple3, tuple4, tuple5, tuple6, tuple7, tuple8, tuple9, tuple10,
        tuple11, tuple12, tuple13, tuple14, tuple15, tuple16);
    Collections.addAll(expectedElements, et0, et1, et2, et3, et4, et5, et6, et7, et8, et9, et10, et11, et12, et13, et14,
        et15);

  }

  public static Stream<Tuple> tuples() {
    return tuples.stream();
  }

  public static IntStream intRange() {
    return IntStream.range(0, tuples.size());
  }

  @ParameterizedTest
  @MethodSource("intRange")
  public void testLength(int i) {
    assertEquals(i, tuples.get(i).size());
  }

  @ParameterizedTest
  @MethodSource("tuples")
  public void tupleValuesAreEqualToExpectedValues(final Tuple sut) {
    final Object[] expected = expectedElements.stream().limit(sut.size()).toArray();
    final Object[] actual = IntStream.range(0, sut.size()).mapToObj(sut::get).toArray();
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("tuples")
  public void testGetWithNegativeIndexIsNotAllowed(final Tuple sut) {
    assertThrows(IndexOutOfBoundsException.class, () -> sut.get(-1));
  }

  @ParameterizedTest
  @MethodSource("tuples")
  public void testWithIndexEqualToSize(final Tuple sut) {
    assertThrows(IndexOutOfBoundsException.class, () -> sut.get(sut.size()));
  }

  @ParameterizedTest
  @MethodSource("tuples")
  public void testWithIndexLargerThanSize(final Tuple sut) {
    assertThrows(IndexOutOfBoundsException.class, () -> sut.get(sut.size() + 1));
  }

  @ParameterizedTest
  @MethodSource("tuples")
  public void getAllEqualsGetAllViaIterable(final Tuple sut) {
    final Object[] arrayObtainedViaGet = IntStream.range(0, sut.size()).mapToObj(sut::get).toArray();
    final Object[] arrayObtainedViaIterable = StreamSupport.stream(sut.asIterable().spliterator(), false).toArray();
    assertArrayEquals(arrayObtainedViaGet, arrayObtainedViaIterable);
  }

  @ParameterizedTest
  @MethodSource("tuples")
  public void GetAllEqualsGetAllViaStream(final Tuple sut) {
    final Object[] arrayObtainedViaGet = IntStream.range(0, sut.size()).mapToObj(sut::get).toArray();
    final Object[] arrayObtainedViaIterable = sut.stream().toArray();
    assertArrayEquals(arrayObtainedViaGet, arrayObtainedViaIterable);
  }

  @Test
  public void testTuple3WithBooleanStringAndInteger() {
    final Tuple sut = tuple(Boolean.TRUE, "Hello", 42);
    final Boolean actualBoolean = sut.get(0);
    assertTrue(actualBoolean.booleanValue());
    assertEquals("Hello", sut.get(1));
    final Integer actualInteger = sut.get(2);
    assertEquals(42, actualInteger.intValue());
  }

  @Test
  public void tupleIterationWithIntegers() {
    final long expected = 6L;
    final Tuple sut = tuple(1, 2, 3);
    final long actual = sut.stream().map(Integer.class::cast).mapToInt(Integer::intValue).summaryStatistics().getSum();
    assertEquals(expected, actual);
  }

  @Test
  public void tupleIterationWithIntegersTooButWithouthCast() {
    final long expected = 6L;
    final Tuple sut = tuple(1, 2, 3);
    final Stream<Integer> actualStream = sut.stream();
    final long actual = actualStream.mapToInt(Integer::intValue).summaryStatistics().getSum();
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("tuples")
  public void headTest(final Tuple sut) {
    if (sut instanceof Tuple0) {
      assertThrows(NoSuchElementException.class, sut::head);
      return;
    }
    assertEquals(et0, sut.head());
  }



  @ParameterizedTest
  @MethodSource("tuples")
  public void lastTest(final Tuple sut) {
    if (sut instanceof Tuple0) {
      assertThrows(NoSuchElementException.class, sut::head);
      return;
    }
    final Object expectedLastElement = expectedElements.get(sut.size() -1);
    final Object actualLastElement = sut.last();
    assertEquals(expectedLastElement, actualLastElement);
  }

  @ParameterizedTest
  @MethodSource("tuples")
  public void tailTest(final Tuple sut) {
    if (sut instanceof Tuple0) {
      assertThrows(UnsupportedOperationException.class, sut::tail);
      return;
    }

    final Tuple tail = sut.tail();
    if (sut instanceof Tuple1) {
      assertTrue(tail instanceof Tuple0);
      return;
    }

    final Object expectedFirstOfTail = sut.get(1);
    final Object actualFirstOfTail = tail.head();
    assertEquals(expectedFirstOfTail, actualFirstOfTail);

    final Object expectedLastOfTail = sut.last();
    final Object actualLastOfTail = tail.last();
    assertEquals(expectedLastOfTail, actualLastOfTail);

    final Object[] expectedTailElements = sut.stream().skip(1).toArray();
    final Object[] actualTailElements = tail.stream().toArray();
    assertArrayEquals(expectedTailElements, actualTailElements);
  }

  @ParameterizedTest
  @MethodSource("tuples")
  public void toArrayTest(final Tuple sut) {
    final Object[] expectedToArrayElements = expectedElements.stream().limit(sut.size()).toArray();
    final Object[] actualToArrayElements = sut.toArray();
    assertArrayEquals(expectedToArrayElements, actualToArrayElements);
  }

  @ParameterizedTest
  @MethodSource("tuples")
  public void toArrayTestWithProvidedArrayOfCorrectSize(final Tuple sut) {
    final Object[] expectedToArrayElements = expectedElements.stream().limit(sut.size()).toArray();
    final Object[] providedArray = new Object[sut.size()];
    final Object[] actualToArrayElements = sut.toArray(providedArray);
    assertEquals(providedArray, actualToArrayElements);
    assertArrayEquals(expectedToArrayElements, actualToArrayElements);
  }

  @ParameterizedTest
  @MethodSource("tuples")
  public void toArrayTestWithProvidedArrayOfLargerSize(final Tuple sut) {
    final Object[] expectedToArrayElements = expectedElements.stream().limit(sut.size()).toArray();
    final Object[] providedArray = new Object[sut.size() + 1];
    final Object[] actualToArrayElements = sut.toArray(providedArray);
    assertEquals(providedArray, actualToArrayElements);
    final  Object[] truncatedActualArray = Arrays.stream(actualToArrayElements).limit(sut.size()).toArray();
    assertArrayEquals(expectedToArrayElements, truncatedActualArray);
  }

  @ParameterizedTest
  @MethodSource("tuples")
  public void toArrayTestWithProvidedArrayOSmallerSize(final Tuple sut) {
    if (sut instanceof Tuple0) {
      return;
    }
    final Object[] expectedToArrayElements = expectedElements.stream().limit(sut.size()).toArray();
    final Object[] providedArray = new Object[Math.min(sut.size() - 1, 0)];
    final Object[] actualToArrayElements = sut.toArray(providedArray);
    assertNotEquals(providedArray, actualToArrayElements);
    assertArrayEquals(expectedToArrayElements, actualToArrayElements);
  }
}
