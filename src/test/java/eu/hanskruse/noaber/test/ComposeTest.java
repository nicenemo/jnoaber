package eu.hanskruse.noaber.test;
import static org.assertj.core.api.Assertions.assertThat;
import static eu.hanskruse.noaber.Noaber.$;

import java.util.function.Function;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for compose.
 */
final class ComposeTest {

  /**
  * Inc function that returns argument + 1.
  *
  * @param argument the argument to return
  * @return argument+1
  */
  private int inc(int argument) {
    return argument + 1;
  }

  /**
  * Inc function that returns argument+1
  *
  * @param argument the argument to return
  * @return argument+1
  */
  private int incPlus100(int argument) {
    return argument + 1 + 100;
  }

  /**
  * Test Compose with 10 functions.
  */
  @Test
  void compose10() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity, // 4
    $::identity, // 5
    $::identity, // 6
    $::identity, // 7
    $::identity, // 8
    $::identity, // 9
    $::identity); // 10
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 11 functions.
  */
  @Test
  void compose11() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity, // 4
    $::identity, // 5
    $::identity, // 6
    $::identity, // 7
    $::identity, // 8
    $::identity, // 9
    $::identity, // 10
    $::identity); // 11
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 12 functions.
  */
  @Test
  void compose12() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity, // 4
    $::identity, // 5
    $::identity, // 6
    $::identity, // 7
    $::identity, // 8
    $::identity, // 9
    $::identity, // 10
    $::identity, // 11
    $::identity); // 12
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 13 functions.
  */
  @Test
  void compose13() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity, // 4
    $::identity, // 5
    $::identity, // 6
    $::identity, // 7
    $::identity, // 8
    $::identity, // 9
    $::identity, // 10
    $::identity, // 11
    $::identity, // 12
    $::identity); // 13
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 14 functions.
  */
  @Test
  void compose14() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity, // 4
    $::identity, // 5
    $::identity, // 6
    $::identity, // 7
    $::identity, // 8
    $::identity, // 9
    $::identity, // 10
    $::identity, // 11
    $::identity, // 12
    $::identity, // 13
    $::identity); // 14
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 15 functions.
  */
  @Test
  void compose15() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity, // 4
    $::identity, // 5
    $::identity, // 6
    $::identity, // 7
    $::identity, // 8
    $::identity, // 9
    $::identity, // 10
    $::identity, // 11
    $::identity, // 12
    $::identity, // 13
    $::identity, // 14
    $::identity); // 15
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 16 functions
  */
  @Test
  void compose16() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity, // 4
    $::identity, // 5
    $::identity, // 6
    $::identity, // 7
    $::identity, // 8
    $::identity, // 9
    $::identity, // 10
    $::identity, // 11
    $::identity, // 12
    $::identity, // 13
    $::identity, // 14
    $::identity, // 15
    $::identity); // 16
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 2 function.
  */
  @Test
  void compose2() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity); // 2
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 3 functions.
  */
  @Test
  void compose3() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity, // 2
    $::identity); // 3
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 4 functions.
  */
  @Test
  void compose4() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity); // 4
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 5 functions.
  */
  @Test
  void compose5() {
    final String expected = "42";
    final Function<String, String> f = $.compose(//
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity, // 4
    $::identity); // 5
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 6 functions.
  */
  @Test
  void compose6() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity, // 4
    $::identity, // 5
    $::identity); // 6
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 7 functions.
  */
  @Test
  void compose7() {
    final String expected = "42";
    final Function<String, String> f = $.compose(//
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity, // 4
    $::identity, // 5
    $::identity, // 6
    $::identity); // 7
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 8 functions.
  */
  @Test
  void compose8() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity, // 4
    $::identity, // 5
    $::identity, // 6
    $::identity, // 7
    $::identity); // 8
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with 9 functions.
  */
  @Test
  void compose9() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity, // 4
    $::identity, // 5
    $::identity, // 6
    $::identity, // 7
    $::identity, // 8
    $::identity); // 9
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with more than 16 functions with same type for argument and
  * return value.
  */
  @Test
  void composeArgCount() {
    final int expected = 120;
    final Function<Integer, Integer> f = $.compose( //
    this::inc, // 1
    this::inc, // 2
    this::inc, // 3
    this::inc, // 4
    this::inc, // 5
    this::inc, // 6
    this::inc, // 7
    this::inc, // 8
    this::inc, // 9
    this::inc, // 10
    this::inc, // 11
    this::inc, // 12
    this::inc, // 13
    this::inc, // 14
    this::inc, // 15
    this::inc, // 16
    this::inc, // 17
    this::inc, // 18
    this::inc, // 19
    this::incPlus100); // 20 //last a different function to prevent
    // of by one errors

    final int actual = f.apply(0);
    assertThat(actual).isEqualTo(expected);
  }

  /**
  * Test Compose with more than 16 functions with same type for argument and
  * return value.
  */
  @Test
  void composeMore() {
    final String expected = "42";
    final Function<String, String> f = $.compose( //
    $::identity, // 1
    $::identity, // 2
    $::identity, // 3
    $::identity, // 4
    $::identity, // 5
    $::identity, // 6
    $::identity, // 7
    $::identity, // 8
    $::identity, // 9
    $::identity, // 10
    $::identity, // 11
    $::identity, // 12
    $::identity, // 13
    $::identity, // 14
    $::identity, // 15
    $::identity, // 16
    $::identity, // 17
    $::identity); // 18
    final String actual = f.apply(expected);
    assertThat(actual).isEqualTo(expected);
  }
}
