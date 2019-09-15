package eu.hanskruse.trackhacks.noaber.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import eu.hanskruse.trackhacks.noaber.Streamable;
import eu.hanskruse.trackhacks.noaber.WithNoaber;

public class StreamableTest implements WithNoaber {

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
      xxs.add(f.apply(i, i + 3));
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
  public void testForEach2() {
    Streamable<Integer> xs = forEach2(xxs.get(0), xxs.get(1), (t0, t1) -> t0 + t1);
    assertEquals(prodLengths(2), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach3() {
    Streamable<Integer> xs = forEach3(xxs.get(0), xxs.get(1), xxs.get(2), (t0, t1, t2) -> t0 + t1 + t2);
    assertEquals(prodLengths(3), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach4() {
    Streamable<Integer> xs = forEach4(xxs.get(0), xxs.get(1), xxs.get(2), xxs.get(3),
        (t0, t1, t2, t3) -> t0 + t1 + t2 + t3);
    assertEquals(prodLengths(4), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach5() {
    Streamable<Integer> xs = forEach5(xxs.get(0), xxs.get(1), xxs.get(2), xxs.get(3), xxs.get(4),
        (t0, t1, t2, t3, t4) -> t0 + t1 + t2 + t3 + t4);
    assertEquals(prodLengths(5), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach6() {
    Streamable<Integer> xs = forEach6(xxs.get(0), xxs.get(1), xxs.get(2), xxs.get(3), xxs.get(4), xxs.get(5),
        (t0, t1, t2, t3, t4, t5) -> t0 + t1 + t2 + t3 + t4 + t5);
    assertEquals(prodLengths(6), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach7() {
    Streamable<Integer> xs = forEach7(xxs.get(0), xxs.get(1), xxs.get(2), xxs.get(3), xxs.get(4), xxs.get(5),
        xxs.get(6), (t0, t1, t2, t3, t4, t5, t6) -> t0 + t1 + t2 + t3 + t4 + t5 + t6);
    assertEquals(prodLengths(7), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach8() {
    Streamable<Integer> xs = forEach8(xxs.get(0), xxs.get(1), xxs.get(2), xxs.get(3), xxs.get(4), xxs.get(5),
        xxs.get(6), xxs.get(7), (t0, t1, t2, t3, t4, t5, t6, t7) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7);
    assertEquals(prodLengths(8), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach9() {
    Streamable<Integer> xs = forEach9(xxs.get(0), xxs.get(1), xxs.get(2), xxs.get(3), xxs.get(4), xxs.get(5),
        xxs.get(6), xxs.get(7), xxs.get(8),
        (t0, t1, t2, t3, t4, t5, t6, t7, t8) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8);
    assertEquals(prodLengths(9), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach10() {
    Streamable<Integer> xs = forEach10(xxs.get(0), xxs.get(1), xxs.get(2), xxs.get(3), xxs.get(4), xxs.get(5),
        xxs.get(6), xxs.get(7), xxs.get(8), xxs.get(9),
        (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9);
    assertEquals(prodLengths(10), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach11() {
    Streamable<Integer> xs = forEach11(xxs.get(0), xxs.get(1), xxs.get(2), xxs.get(3), xxs.get(4), xxs.get(5),
        xxs.get(6), xxs.get(7), xxs.get(8), xxs.get(9), xxs.get(10),
        (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10);
    assertEquals(prodLengths(11), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach12() {
    Streamable<Integer> xs = forEach12(xxs.get(0), xxs.get(1), xxs.get(2), xxs.get(3), xxs.get(4), xxs.get(5),
        xxs.get(6), xxs.get(7), xxs.get(8), xxs.get(9), xxs.get(10), xxs.get(11), (t0, t1, t2, t3, t4, t5, t6, t7, t8,
            t9, t10, t11) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11);
    assertEquals(prodLengths(12), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach13() {
    Streamable<Integer> xs = forEach13(xxs.get(0), xxs.get(1), xxs.get(2), xxs.get(3), xxs.get(4), xxs.get(5),
        xxs.get(6), xxs.get(7), xxs.get(8), xxs.get(9), xxs.get(10), xxs.get(11), xxs.get(12), (t0, t1, t2, t3, t4, t5,
            t6, t7, t8, t9, t10, t11, t12) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12);
    assertEquals(prodLengths(13), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach14() {
    Streamable<Integer> xs = forEach14(xxs.get(0), xxs.get(1), xxs.get(2), xxs.get(3), xxs.get(4), xxs.get(5),
        xxs.get(6), xxs.get(7), xxs.get(8), xxs.get(9), xxs.get(10), xxs.get(11), xxs.get(12), xxs.get(13),
        (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9
            + t10 + t11 + t12 + t13);
    assertEquals(prodLengths(14), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach15() {
    Streamable<Integer> xs = forEach15(xxs.get(0), xxs.get(1), xxs.get(2), xxs.get(3), xxs.get(4), xxs.get(5),
        xxs.get(6), xxs.get(7), xxs.get(8), xxs.get(9), xxs.get(10), xxs.get(11), xxs.get(12), xxs.get(13), xxs.get(14),
        (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) -> t0 + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8
            + t9 + t10 + t11 + t12 + t13 + t14);
    assertEquals(prodLengths(15), xs.stream().parallel().toArray().length);
  }

  @Test
  public void testForEach16() {
    Streamable<Integer> xs = forEach16(xxs.get(0), xxs.get(1), xxs.get(2), xxs.get(3), xxs.get(4), xxs.get(5),
        xxs.get(6), xxs.get(7), xxs.get(8), xxs.get(9), xxs.get(10), xxs.get(11), xxs.get(12), xxs.get(13), xxs.get(14),
        xxs.get(15), (t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) -> t0 + t1 + t2 + t3 + t4
            + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 + t15);
    assertEquals(prodLengths(16), xs.stream().parallel().toArray().length);
  }

}
