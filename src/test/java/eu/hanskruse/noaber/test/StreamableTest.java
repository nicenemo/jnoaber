package eu.hanskruse.noaber.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eu.hanskruse.noaber.Streamable;
import eu.hanskruse.noaber.WithNoaber;

final class StreamableTest implements WithNoaber {
  private List<Streamable<Integer>> xxs;
  private int[] lengths;

  /**
  * Initializes the tests
  */
  @BeforeEach
  void initialize() {
    xxs = new ArrayList<>();
    lengths = new int[16];
    final BiFunction<Integer, Integer, Streamable<Integer>> f = (start,
    finish) -> () -> IntStream.range(start, finish).mapToObj(Integer::valueOf);
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
  void forEachExample() {
    System.err.println("Defining dutch postal codes.." + System.currentTimeMillis());

    final Streamable<Integer> firstTwoDigits = () -> IntStream.range(10, 99).boxed();
    final Streamable<Integer> lastTwoDigits = () -> IntStream.range(0, 10).boxed();
    final Streamable<String> az = () -> IntStream.rangeClosed((int) 'A', (int) 'Z')
    .mapToObj(i -> Character.toString((char) i));

    final Streamable<String> dutchPostalCodes = forEach(//
    firstTwoDigits, lastTwoDigits, az, az, (d1, d2, az1, az2) -> (d1 * 100 + d2) != 1000,
    (d1, d2, az1, az2) -> String.format("%s%s%s%s", d1, d2, az1, az2));

    System.err.println("Defined dutch postal codes.." + System.currentTimeMillis());

    System.err.println("Skip 10000 take 10 and print those.. " + System.currentTimeMillis());
    System.out.println(dutchPostalCodes.stream().parallel().skip(10000).limit(10).collect(Collectors.joining(",\n")));
    System.err.println("Done with, skip 10000 take 10 and print those.. " + System.currentTimeMillis());
  }

  @Test
  void forEach2() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    x1 -> xxs.get(1), //
    (t0, t1) -> t0 > 0, //
    Integer::sum);
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(2));
  }

  @Test
  void forEach2NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    x1 -> xxs.get(1), //
    (t0, t1) -> t0 + t1);
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(2));
  }

  @Test
  void forEach3() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    x1 -> xxs.get(1), //
    x2 -> xxs.get(2), //
    (t0, t1, t2) -> t0 > 0, //
    (t0, t1, t2) -> t0 + t1 + t2);
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(3));
  }

  @Test
  void forEach3NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    x1 -> xxs.get(1), //
    x2 -> xxs.get(2), //
    (t0, t1, t2) -> t0 + t1 + t2);
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(3));
  }

  @Test
  void forEach4() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    (t0, t1, t2, t3) -> t0 > 0, //
    (t0, t1, t2, t3) -> t0 + t1 + t2 + t3);
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(4));
  }

  @Test
  void forEach4NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    (t0, t1, t2, t3) -> t0 + t1 + t2 + t3);
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(4));
  }

  @Test
  void forEach5() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    (t0, t1, t2, t3, t4) -> t0 > 0, //
    (t0, t1, t2, t3, t4) -> t0 + t1 + t2 + t3 + t4);
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(5));
  }

  @Test
  void forEach5NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    (t0, t1, t2, t3, t4) -> t0 + t1 + t2 + t3 + t4);
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(5));
  }

  @Test
  void forEach6() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    (t0, t1, t2, t3, t4, t5) -> t0 > 0, //
    (t0, t1, t2, t3, t4, t5) -> t0 + t1 + t2 + t3 + t4 + t5);
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(6));
  }

  @Test
  void forEach6NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    (t0, t1, t2, t3, t4, t5) -> t0 + t1 + t2 + t3 + t4 + t5);
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(6));
  }

  @Test
  void forEach7() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(7));
  }

  @Test
  void forEach7NoFilter() {
    Streamable<Integer> xs = forEach(//
    xxs.get(0), //
    xxs.get(1), //
    xxs.get(2), //
    xxs.get(3), //
    xxs.get(4), //
    xxs.get(5), //
    xxs.get(6), //
    (t0, t1, t2, t3, t4, t5, t6) -> t0 + t1 + t2 + t3 + t4 + t5 + t6);
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(7));
  }

  @Test
  void forEach8() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(8));
  }

  @Test
  void forEach8NoFilter() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(8));
  }

  @Test
  void forEach9() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(9));
  }

  @Test
  void forEach9NoFilter() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(9));
  }

  @Test
  void forEach10() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(10));
  }

  @Test
  void forEach10NoFilter() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(10));
  }

  @Test
  void forEach11() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(11));
  }

  @Test
  void forEach11NoFilter() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(11));
  }

  @Test
  void forEach12() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(12));
  }

  @Test
  void forEach12NoFilter() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(12));
  }

  @Test
  void forEach13() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(13));
  }

  @Test
  void forEach13NoFilter() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(13));
  }

  @Test
  void forEach14() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(14));
  }

  @Test
  void forEach14NoFilter() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(14));
  }

  @Test
  void forEach15() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(15));
  }

  @Test
  void forEach15NoFilter() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(15));
  }

  @Test
  void forEach16() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(16));
  }

  @Test
  void forEach16NoFilter() {
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
    assertThat(xs.stream().parallel().toArray()).hasSize(prodLengths(16));
  }

  @Test
  void distinct() {
    final Streamable<Integer> xs = Arrays.asList(3, 3, 4, 5, 5)::stream;
    assertThat(xs.distinct().stream().toArray(Integer[]::new)).containsExactly(new Integer[]{3, 4, 5});
  }

  @Test
  void limit() {
    final Streamable<Integer> xs = Arrays.asList(3, 3, 4, 5, 5)::stream;
    assertThat(xs.limit(3L).stream().toArray(Integer[]::new)).containsExactly(new Integer[]{3, 3, 4});
  }

  @Test
  void parallel() {
    final Streamable<Integer> xs = Arrays.asList(3, 3, 4, 5, 5)::stream;
    assertThat(xs.stream().isParallel()).isFalse();
    assertThat(xs.parallel().stream().isParallel()).isTrue();
  }

  @Test
  void peek() {
    final AtomicInteger sum = new AtomicInteger(0);
    Streamable<Integer> xs = Arrays.asList(3, 3, 4, 5, 5)::stream;
    xs.peek(i -> sum.addAndGet(i)).stream().forEach(i -> {
    /* process the stream, do nothing */});
    assertThat(sum.get()).isEqualTo(sum(xs.stream().mapToInt(Integer::intValue).toArray()));
  }

  @Test
  void sequential() {
    Streamable<Integer> xs = Arrays.asList(3, 3, 4, 5, 5)::stream;
    assertThat(xs.stream().isParallel()).isFalse();
    xs = xs.parallel();
    assertThat(xs.stream().isParallel()).isTrue();
    xs = xs.sequential();
    assertThat(xs.stream().isParallel()).isFalse();
  }

  @Test
  void skip() {
    final Streamable<Integer> xs = Arrays.asList(3, 3, 4, 5, 5)::stream;
    assertThat(xs.skip(2L).stream().toArray(Integer[]::new)).containsExactly(new Integer[]{4, 5, 5});
  }

}
