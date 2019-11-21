package eu.hanskruse.trackhacks.noaber.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import eu.hanskruse.trackhacks.noaber.tuples.Tuple;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple2;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple3;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple4;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple5;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple6;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple7;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple8;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple9;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple10;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple11;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple12;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple13;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple14;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple15;
import eu.hanskruse.trackhacks.noaber.tuples.Tuple16;
import eu.hanskruse.trackhacks.noaber.WithNoaber;

@Ignore
public class TupleTest implements WithNoaber{

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

  @Rule
  public ExpectedException exception = ExpectedException.none();

  public static void testTupleIteration(final int expectedSize, final Tuple sut) {
    assertEquals(expectedSize, sut.size());
    int i = 0;
    for (Object o : sut.asIterable()) {
      assertNotNull(o);
      assertEquals(sut.get(i), o);
      i++;
    }
    assertEquals(sut.size(), i);
  }

  @Test
  public void testTuple2() {

    Tuple2 sut = tuple(//
        et0, //
        et1);
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    testTupleIteration(2, sut);
  }

  @Test
  public void testTuple3() {

    Tuple3 sut = tuple(//
        et0, //
        et1, //
        et2);
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    testTupleIteration(3, sut);
  }

  @Test
  public void testTuple4() {

    Tuple4 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3);
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    final T3 at3 = sut.get(3);
    assertEquals(et3, at3);
    testTupleIteration(4, sut);
  }

  @Test
  public void testTuple5() {

    Tuple5 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4);
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    final T3 at3 = sut.get(3);
    assertEquals(et3, at3);
    final T4 at4 = sut.get(4);
    assertEquals(et4, at4);
    testTupleIteration(5, sut);
  }

  @Test
  public void testTuple6() {

    Tuple6 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4, //
        et5);
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    final T3 at3 = sut.get(3);
    assertEquals(et3, at3);
    final T4 at4 = sut.get(4);
    assertEquals(et4, at4);
    final T5 at5 = sut.get(5);
    assertEquals(et5, at5);
    testTupleIteration(6, sut);
  }

  @Test
  public void testTuple7() {

    Tuple7 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4, //
        et5, //
        et6);
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    final T3 at3 = sut.get(3);
    assertEquals(et3, at3);
    final T4 at4 = sut.get(4);
    assertEquals(et4, at4);
    final T5 at5 = sut.get(5);
    assertEquals(et5, at5);
    final T6 at6 = sut.get(6);
    assertEquals(et6, at6);
    testTupleIteration(7, sut);
  }

  @Test
  public void testTuple8() {

    Tuple8 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4, //
        et5, //
        et6, //
        et7);
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    final T3 at3 = sut.get(3);
    assertEquals(et3, at3);
    final T4 at4 = sut.get(4);
    assertEquals(et4, at4);
    final T5 at5 = sut.get(5);
    assertEquals(et5, at5);
    final T6 at6 = sut.get(6);
    assertEquals(et6, at6);
    final T7 at7 = sut.get(7);
    assertEquals(et7, at7);
    testTupleIteration(8, sut);
  }

  @Test
  public void testTuple9() {

    Tuple9 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4, //
        et5, //
        et6, //
        et7, //
        et8);
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    final T3 at3 = sut.get(3);
    assertEquals(et3, at3);
    final T4 at4 = sut.get(4);
    assertEquals(et4, at4);
    final T5 at5 = sut.get(5);
    assertEquals(et5, at5);
    final T6 at6 = sut.get(6);
    assertEquals(et6, at6);
    final T7 at7 = sut.get(7);
    assertEquals(et7, at7);
    final T8 at8 = sut.get(8);
    assertEquals(et8, at8);
    testTupleIteration(9, sut);
  }

  @Test
  public void testTuple10() {

    Tuple10 sut = tuple(//
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
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    final T3 at3 = sut.get(3);
    assertEquals(et3, at3);
    final T4 at4 = sut.get(4);
    assertEquals(et4, at4);
    final T5 at5 = sut.get(5);
    assertEquals(et5, at5);
    final T6 at6 = sut.get(6);
    assertEquals(et6, at6);
    final T7 at7 = sut.get(7);
    assertEquals(et7, at7);
    final T8 at8 = sut.get(8);
    assertEquals(et8, at8);
    final T9 at9 = sut.get(9);
    assertEquals(et9, at9);
    testTupleIteration(10, sut);
  }

  @Test
  public void testTuple11() {

    Tuple11 sut = tuple(//
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
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    final T3 at3 = sut.get(3);
    assertEquals(et3, at3);
    final T4 at4 = sut.get(4);
    assertEquals(et4, at4);
    final T5 at5 = sut.get(5);
    assertEquals(et5, at5);
    final T6 at6 = sut.get(6);
    assertEquals(et6, at6);
    final T7 at7 = sut.get(7);
    assertEquals(et7, at7);
    final T8 at8 = sut.get(8);
    assertEquals(et8, at8);
    final T9 at9 = sut.get(9);
    assertEquals(et9, at9);
    final T10 at10 = sut.get(10);
    assertEquals(et10, at10);
    testTupleIteration(11, sut);
  }

  @Test
  public void testTuple12() {

    Tuple12 sut = tuple(//
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
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    final T3 at3 = sut.get(3);
    assertEquals(et3, at3);
    final T4 at4 = sut.get(4);
    assertEquals(et4, at4);
    final T5 at5 = sut.get(5);
    assertEquals(et5, at5);
    final T6 at6 = sut.get(6);
    assertEquals(et6, at6);
    final T7 at7 = sut.get(7);
    assertEquals(et7, at7);
    final T8 at8 = sut.get(8);
    assertEquals(et8, at8);
    final T9 at9 = sut.get(9);
    assertEquals(et9, at9);
    final T10 at10 = sut.get(10);
    assertEquals(et10, at10);
    final T11 at11 = sut.get(11);
    assertEquals(et11, at11);
    testTupleIteration(12, sut);
  }

  @Test
  public void testTuple13() {

    Tuple13 sut = tuple(//
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
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    final T3 at3 = sut.get(3);
    assertEquals(et3, at3);
    final T4 at4 = sut.get(4);
    assertEquals(et4, at4);
    final T5 at5 = sut.get(5);
    assertEquals(et5, at5);
    final T6 at6 = sut.get(6);
    assertEquals(et6, at6);
    final T7 at7 = sut.get(7);
    assertEquals(et7, at7);
    final T8 at8 = sut.get(8);
    assertEquals(et8, at8);
    final T9 at9 = sut.get(9);
    assertEquals(et9, at9);
    final T10 at10 = sut.get(10);
    assertEquals(et10, at10);
    final T11 at11 = sut.get(11);
    assertEquals(et11, at11);
    final T12 at12 = sut.get(12);
    assertEquals(et12, at12);
    testTupleIteration(13, sut);
  }

  @Test
  public void testTuple14() {

    Tuple14 sut = tuple(//
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
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    final T3 at3 = sut.get(3);
    assertEquals(et3, at3);
    final T4 at4 = sut.get(4);
    assertEquals(et4, at4);
    final T5 at5 = sut.get(5);
    assertEquals(et5, at5);
    final T6 at6 = sut.get(6);
    assertEquals(et6, at6);
    final T7 at7 = sut.get(7);
    assertEquals(et7, at7);
    final T8 at8 = sut.get(8);
    assertEquals(et8, at8);
    final T9 at9 = sut.get(9);
    assertEquals(et9, at9);
    final T10 at10 = sut.get(10);
    assertEquals(et10, at10);
    final T11 at11 = sut.get(11);
    assertEquals(et11, at11);
    final T12 at12 = sut.get(12);
    assertEquals(et12, at12);
    final T13 at13 = sut.get(13);
    assertEquals(et13, at13);
    testTupleIteration(14, sut);
  }

  @Test
  public void testTuple15() {

    Tuple15 sut = tuple(//
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
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    final T3 at3 = sut.get(3);
    assertEquals(et3, at3);
    final T4 at4 = sut.get(4);
    assertEquals(et4, at4);
    final T5 at5 = sut.get(5);
    assertEquals(et5, at5);
    final T6 at6 = sut.get(6);
    assertEquals(et6, at6);
    final T7 at7 = sut.get(7);
    assertEquals(et7, at7);
    final T8 at8 = sut.get(8);
    assertEquals(et8, at8);
    final T9 at9 = sut.get(9);
    assertEquals(et9, at9);
    final T10 at10 = sut.get(10);
    assertEquals(et10, at10);
    final T11 at11 = sut.get(11);
    assertEquals(et11, at11);
    final T12 at12 = sut.get(12);
    assertEquals(et12, at12);
    final T13 at13 = sut.get(13);
    assertEquals(et13, at13);
    final T14 at14 = sut.get(14);
    assertEquals(et14, at14);
    testTupleIteration(15, sut);
  }

  @Test
  public void testTuple16() {

    Tuple16 sut = tuple(//
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
    final T0 at0 = sut.get(0);
    assertEquals(et0, at0);
    final T1 at1 = sut.get(1);
    assertEquals(et1, at1);
    final T2 at2 = sut.get(2);
    assertEquals(et2, at2);
    final T3 at3 = sut.get(3);
    assertEquals(et3, at3);
    final T4 at4 = sut.get(4);
    assertEquals(et4, at4);
    final T5 at5 = sut.get(5);
    assertEquals(et5, at5);
    final T6 at6 = sut.get(6);
    assertEquals(et6, at6);
    final T7 at7 = sut.get(7);
    assertEquals(et7, at7);
    final T8 at8 = sut.get(8);
    assertEquals(et8, at8);
    final T9 at9 = sut.get(9);
    assertEquals(et9, at9);
    final T10 at10 = sut.get(10);
    assertEquals(et10, at10);
    final T11 at11 = sut.get(11);
    assertEquals(et11, at11);
    final T12 at12 = sut.get(12);
    assertEquals(et12, at12);
    final T13 at13 = sut.get(13);
    assertEquals(et13, at13);
    final T14 at14 = sut.get(14);
    assertEquals(et14, at14);
    final T15 at15 = sut.get(15);
    assertEquals(et15, at15);
    testTupleIteration(16, sut);
  }

  @Test
  public void testTuple2Get2() {

    Tuple2 sut = tuple(//
        et0, //
        et1);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(2);
  }

  @Test
  public void testTuple2GetMinus1() {

    Tuple2 sut = tuple(//
        et0, //
        et1);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple3Get3() {

    Tuple3 sut = tuple(//
        et0, //
        et1, //
        et2);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(3);
  }

  @Test
  public void testTuple3GetMinus1() {

    Tuple3 sut = tuple(//
        et0, //
        et1, //
        et2);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple4Get4() {

    Tuple4 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(4);
  }

  @Test
  public void testTuple4GetMinus1() {

    Tuple4 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple5Get5() {

    Tuple5 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(5);
  }

  @Test
  public void testTuple5GetMinus1() {

    Tuple5 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple6Get6() {

    Tuple6 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4, //
        et5);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(6);
  }

  @Test
  public void testTuple6GetMinus1() {

    Tuple6 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4, //
        et5);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple7Get7() {

    Tuple7 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4, //
        et5, //
        et6);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(7);
  }

  @Test
  public void testTuple7GetMinus1() {

    Tuple7 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4, //
        et5, //
        et6);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple8Get8() {

    Tuple8 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4, //
        et5, //
        et6, //
        et7);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(8);
  }

  @Test
  public void testTuple8GetMinus1() {

    Tuple8 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4, //
        et5, //
        et6, //
        et7);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple9Get9() {

    Tuple9 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4, //
        et5, //
        et6, //
        et7, //
        et8);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(9);
  }

  @Test
  public void testTuple9GetMinus1() {

    Tuple9 sut = tuple(//
        et0, //
        et1, //
        et2, //
        et3, //
        et4, //
        et5, //
        et6, //
        et7, //
        et8);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple10Get10() {

    Tuple10 sut = tuple(//
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
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(10);
  }

  @Test
  public void testTuple10GetMinus1() {

    Tuple10 sut = tuple(//
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
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple11Get11() {

    Tuple11 sut = tuple(//
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
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(11);
  }

  @Test
  public void testTuple11GetMinus1() {

    Tuple11 sut = tuple(//
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
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple12Get12() {

    Tuple12 sut = tuple(//
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
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(12);
  }

  @Test
  public void testTuple12GetMinus1() {

    Tuple12 sut = tuple(//
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
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple13Get13() {

    Tuple13 sut = tuple(//
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
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(13);
  }

  @Test
  public void testTuple13GetMinus1() {

    Tuple13 sut = tuple(//
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
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple14Get14() {

    Tuple14 sut = tuple(//
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
    et12,
    et13);
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(14);
  }

  @Test
  public void testTuple14GetMinus1() {

    Tuple14 sut = tuple(//
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
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple15Get15() {

    Tuple15 sut = tuple(//
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
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(15);
  }

  @Test
  public void testTuple15GetMinus1() {

    Tuple15 sut = tuple(//
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
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple16Get16() {

    Tuple16 sut = tuple(//
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
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(16);
  }

  @Test
  public void testTuple16GetMinus1() {

    Tuple16 sut = tuple(//
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
    exception.expect(IndexOutOfBoundsException.class);
    sut.get(-1);
  }

  @Test
  public void testTuple3WithBooleanStringAndInteger() {
    Tuple sut = tuple(Boolean.TRUE, "Hello", 42);
    final Boolean actualBoolean = sut.get(0);
    assertTrue(actualBoolean.booleanValue());
    assertEquals("Hello", sut.get(1));
    final Integer actualInteger = sut.get(2);
    assertEquals(42, actualInteger.intValue());
  }

  @Test
  public void tupleIterationWithIntegers() {
    Tuple sut = tuple(1, 2, 3);
    int sum = 0;
    final Iterable<Integer> iterable = sut.asIterable();
    for (Integer i : iterable) {
      sum += i;
    }
    assertEquals(6, sum);
  }
}
