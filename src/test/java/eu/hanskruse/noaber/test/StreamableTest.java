package eu.hanskruse.noaber.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eu.hanskruse.noaber.Streamable;
import eu.hanskruse.noaber.WithNoaber;

public class StreamableTest implements WithNoaber {
  private List<Streamable<Integer>> xxs;
  private int[] lengths;

  /**
  * Initializes the tests
  */
  @BeforeEach
  public void initialize() {
    xxs = new ArrayList<>();
    lengths = new int[16];
    final BiFunction<Integer, Integer, Streamable<Integer>> f = (start,
    finish) -> () -> IntStream.range(start, finish).mapToObj(Integer::valueOf);
    for (int i = 0; i < 16; i++) {
      xxs.add(f.apply(i + 1, i + 4));
      lengths[i] = xxs.get(i).stream().toArray().length;
    }
  }

  @Test
  public void testDistinct() {
    final Streamable<Integer> xs = Arrays.asList(3, 3, 4, 5, 5)::stream;
    assertArrayEquals(new Integer[] { 3, 4, 5 }, xs.distinct().stream().toArray(Integer[]::new));
  }

  @Test
  public void testLimit() {
    final Streamable<Integer> xs = Arrays.asList(3, 3, 4, 5, 5)::stream;
    assertArrayEquals(new Integer[] { 3, 3, 4 }, xs.limit(3L).stream().toArray(Integer[]::new));
  }

  @Test
  public void testParallel() {
    final Streamable<Integer> xs = Arrays.asList(3, 3, 4, 5, 5)::stream;
    assertFalse(xs.stream().isParallel());
    assertTrue(xs.parallel().stream().isParallel());
  }

  @Test
  public void testPeek() {
    final AtomicInteger sum = new AtomicInteger(0);
    Streamable<Integer> xs = Arrays.asList(3, 3, 4, 5, 5)::stream;
    xs.peek(i -> sum.addAndGet(i)).stream().forEach(i -> {
    /* process the stream, do nothing */});
    assertEquals(sum(xs.stream().mapToInt(Integer::intValue).toArray()), sum.get());
  }

  @Test
  public void testSequential() {
    Streamable<Integer> xs = Arrays.asList(3, 3, 4, 5, 5)::stream;
    assertFalse(xs.stream().isParallel());
    xs = xs.parallel();
    assertTrue(xs.stream().isParallel());
    xs = xs.sequential();
    assertFalse(xs.stream().isParallel());
  }

  @Test
  public void testskip() {
    final Streamable<Integer> xs = Arrays.asList(3, 3, 4, 5, 5)::stream;
    assertArrayEquals(new Integer[] { 4, 5, 5 }, xs.skip(2L).stream().toArray(Integer[]::new));
  }
}
