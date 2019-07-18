package eu.hanskruse.trackhacks.noaber.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

import eu.hanskruse.trackhacks.noaber.Tuple;
import eu.hanskruse.trackhacks.noaber.WithStream;

/**
 * Unit tests for Stream support.
 *
 * @author kruse@hanskruse.eu
 *
 */
public class StreamTest implements WithStream {

  @Test
  public void testForComprehension2() {
    final Supplier<Stream<Integer>> ns = () -> Arrays.stream(new Integer[] { 0, 1, 2 });
    final Supplier<Stream<String>> xs = () -> Arrays.stream(new String[] { "Apple", "Pear", "Banana" });
    final Stream<Tuple> actual = stream(ns, xs);
    final Tuple[] arr= actual.toArray( n-> new Tuple[n]);
    assertEquals(9, arr.length);

    // row zero
    assertEquals(0, ((Integer)arr[0].get(0)).intValue());
    assertEquals("Apple", arr[0].get(1));

    assertEquals(0, ((Integer)arr[1].get(0)).intValue());
    assertEquals("Pear", arr[1].get(1));

    assertEquals(0, ((Integer)arr[2].get(0)).intValue());
    assertEquals("Banana", arr[2].get(1));
    //end row zero

    // row one
    assertEquals(1, ((Integer)arr[3].get(0)).intValue());
    assertEquals("Apple", arr[3].get(1));

    assertEquals(1, ((Integer)arr[4].get(0)).intValue());
    assertEquals("Pear", arr[4].get(1));

    assertEquals(1, ((Integer)arr[5].get(0)).intValue());
    assertEquals("Banana", arr[5].get(1));
    //end row one

    // row two
    assertEquals(2, ((Integer)arr[6].get(0)).intValue());
    assertEquals("Apple", arr[6].get(1));

    assertEquals(2, ((Integer)arr[7].get(0)).intValue());
    assertEquals("Pear", arr[7].get(1));

    assertEquals(2, ((Integer)arr[8].get(0)).intValue());
    assertEquals("Banana", arr[8].get(1));
    //end row two
  }
}
