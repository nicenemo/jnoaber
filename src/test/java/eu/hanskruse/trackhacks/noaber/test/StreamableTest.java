package eu.hanskruse.trackhacks.noaber.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;
import eu.hanskruse.trackhacks.noaber.tuples.*;
import eu.hanskruse.trackhacks.noaber.Streamable;
import eu.hanskruse.trackhacks.noaber.WithNoaber;

public class StreamableTest implements WithNoaber {
  private enum Sex{
    UNKNOWN,
    M,
    F,
    X
  };

  private List<Streamable<Integer>> xxs;
  private int[] lengths;

  /**
  * Initializes the tests
  */
  @Before
  public void initialize() {
    xxs = new ArrayList<>();
    lengths = new int[16];
    final BiFunction<Integer, Integer, Streamable<Integer>> f = (start,
    finish) -> () -> IntStream.range(start, finish).mapToObj(Integer::new);
    for (int i = 0; i < 16; i++) {
      xxs.add(f.apply(i + 1, i + 4));
      lengths[i] = xxs.get(i).stream().toArray().length;
    }
  }

  private int prodLengths(int count) {
    int prod = 1;
    for (int i = 0; i < count; i++) {
      prod *= lengths[i];
    }
    return prod;
  }

  @Test
  public void testForEachExample(){
    System.err.println("Defining dutch postal codes.." + System.currentTimeMillis());

    final Streamable<Integer> firstTwoDigits = () -> IntStream.range(10,99).mapToObj(Integer::valueOf);
    final Streamable<Integer> lastTwoDigits = () -> IntStream.range(0 ,10).mapToObj(Integer::valueOf);
    final Streamable<String> az = () -> IntStream.rangeClosed((int) 'A', (int) 'Z').mapToObj(i -> Character.toString((char)i));

    final Streamable<String> dutchPostalCodes= forEach(//
     firstTwoDigits,
     lastTwoDigits,
     az,
     az,
    (d1,d2,az1,az2) -> (d1*100 + d2) != 1000,
    (d1,d2,az1,az2) -> String.format("%s%s%s%s",d1,d2,az1,az2));

    System.err.println("Defined dutch postal codes.." + System.currentTimeMillis());

    System.err.println("Skip 10000 take 10 and print those.. "+ System.currentTimeMillis());
    System.out.println(dutchPostalCodes.stream().parallel().skip(10000).limit(10).collect(Collectors.joining(",\n")));
    System.err.println("Done with, skip 10000 take 10 and print those.. "+ System.currentTimeMillis());
  }

  @Test
  public void testForEach2() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    (t0, t1) -> t0 > 0, //
    (t0, t1) -> t0 + t1);
    assertEquals(prodLengths(2), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach2NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    (t0, t1) -> t0 + t1);
    assertEquals(prodLengths(2), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach3() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    (t0, t1, t2) -> t0 > 0, //
    (t0, t1, t2) -> t0 + t1 + t2);
    assertEquals(prodLengths(3), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach3NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    (t0, t1, t2) -> t0 + t1 + t2);
    assertEquals(prodLengths(3), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach4() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    (t0, t1, t2, t3) -> t0 > 0, //
    (t0, t1, t2, t3) -> t0 + t1 + t2 + t3);
    assertEquals(prodLengths(4), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach4NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    (t0, t1, t2, t3) -> t0 + t1 + t2 + t3);
    assertEquals(prodLengths(4), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach5() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    (t0, t1, t2, t3, t4) -> t0 > 0, //
    (t0, t1, t2, t3, t4) -> t0 + t1 + t2 + t3 + t4);
    assertEquals(prodLengths(5), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach5NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    (t0, t1, t2, t3, t4) -> t0 + t1 + t2 + t3 + t4);
    assertEquals(prodLengths(5), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach6() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    (t0, t1, t2, t3, t4, t5) -> t0 > 0, //
    (t0, t1, t2, t3, t4, t5) -> t0 + t1 + t2 + t3 + t4 + t5);
    assertEquals(prodLengths(6), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach6NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    (t0, t1, t2, t3, t4, t5) -> t0 + t1 + t2 + t3 + t4 + t5);
    assertEquals(prodLengths(6), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach7() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    (t0, t1, t2, t3, t4, t5, t6) -> t0 > 0, //
    (t0, t1, t2, t3, t4, t5, t6) -> t0 + t1 + t2 + t3 + t4 + t5 + t6);
    assertEquals(prodLengths(7), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach7NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    (t0, t1, t2, t3, t4, t5, t6) -> t0 + t1 + t2 + t3 + t4 + t5 + t6);
    assertEquals(prodLengths(7), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach8() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    (t0, t1, t2, t3, t4, t5, t6, t7) -> t0 > 0, //
    (t0, t1, t2, t3, t4, t5, t6, t7) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7);
    assertEquals(prodLengths(8), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach8NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    (t0, t1, t2, t3, t4, t5, t6, t7) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7);
    assertEquals(prodLengths(8), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach9() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8) -> t0 > 0, //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8);
    assertEquals(prodLengths(9), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach9NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8);
    assertEquals(prodLengths(9), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach10() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    xxs.get(9), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9) -> t0 > 0, //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9);
    assertEquals(prodLengths(10), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach10NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    xxs.get(9), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9);
    assertEquals(prodLengths(10), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach11() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    xxs.get(9), //
    xxs.get(10), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) -> t0 > 0, //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10);
    assertEquals(prodLengths(11), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach11NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    xxs.get(9), //
    xxs.get(10), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10);
    assertEquals(prodLengths(11), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach12() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    xxs.get(9), //
    xxs.get(10), //
    xxs.get(11), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) -> t0 > 0, //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10
    + t11);
    assertEquals(prodLengths(12), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach12NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    xxs.get(9), //
    xxs.get(10), //
    xxs.get(11), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10
    + t11);
    assertEquals(prodLengths(12), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach13() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    xxs.get(9), //
    xxs.get(10), //
    xxs.get(11), //
    xxs.get(12), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) -> t0 > 0, //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10
    + t11 + t12);
    assertEquals(prodLengths(13), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach13NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    xxs.get(9), //
    xxs.get(10), //
    xxs.get(11), //
    xxs.get(12), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10
    + t11 + t12);
    assertEquals(prodLengths(13), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach14() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    xxs.get(9), //
    xxs.get(10), //
    xxs.get(11), //
    xxs.get(12), //
    xxs.get(13), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) -> t0 > 0, //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9
    + t10 + t11 + t12 + t13);
    assertEquals(prodLengths(14), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach14NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    xxs.get(9), //
    xxs.get(10), //
    xxs.get(11), //
    xxs.get(12), //
    xxs.get(13), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9
    + t10 + t11 + t12 + t13);
    assertEquals(prodLengths(14), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach15() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    xxs.get(9), //
    xxs.get(10), //
    xxs.get(11), //
    xxs.get(12), //
    xxs.get(13), //
    xxs.get(14), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) -> t0 > 0, //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8
    + t9 + t10 + t11 + t12 + t13 + t14);
    assertEquals(prodLengths(15), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach15NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), //
    xxs.get(9), //
    xxs.get(10), //
    xxs.get(11), //
    xxs.get(12), //
    xxs.get(13), //
    xxs.get(14), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8
    + t9 + t10 + t11 + t12 + t13 + t14);
    assertEquals(prodLengths(15), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach16() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), ///
    xxs.get(9), //
    xxs.get(10), //
    xxs.get(11), //
    xxs.get(12), //
    xxs.get(13), //
    xxs.get(14), //
    xxs.get(15), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) -> t0 > 0, //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7
    + t8 + t9 + t10 + t11 + t12 + t13 + t14 + t15);
    assertEquals(prodLengths(16), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach16NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    xxs.get(7), //
    xxs.get(8), ///
    xxs.get(9), //
    xxs.get(10), //
    xxs.get(11), //
    xxs.get(12), //
    xxs.get(13), //
    xxs.get(14), //
    xxs.get(15), //
    (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7
    + t8 + t9 + t10 + t11 + t12 + t13 + t14 + t15);
    assertEquals(prodLengths(16), xs.stream().parallel().toArray().length);
  }

  @Test 
  public void testDistinct(){
    Streamable<Integer> xs =Arrays.asList(3,3,4,5,5)::stream;
    assertArrayEquals(new Integer[]{3,4,5}, xs.distinct().stream().toArray(Integer[]::new));
  }
}
