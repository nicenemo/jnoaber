package eu.hanskruse.trackhacks;

import java.util.Optional;

import org.junit.Test;
import org.quicktheories.WithQuickTheories;

import eu.hanskruse.trackhacks.noaber.WithPatternMatching;
import eu.hanskruse.trackhacks.testdata.FizzBuzz;

/**
 * Pattern matching examples.
 * 
 * @author Hans Kruse
 *
 */
public class PatternMatchingTest implements WithQuickTheories, WithPatternMatching {

  /**
   * FizzBuzz example.
   */
  @Test
  public void fizzBuzzExample() {
    qt().forAll(integers().all()).check(i -> {
      final Optional<String> r = //
          match(i).with(//
              whenPredicate(FizzBuzz::fizzBuzz).then(n -> "FizzBuzz:" + n),
              whenPredicate(FizzBuzz::fizz).then(n -> "Fizz:" + n),
              whenPredicate(FizzBuzz::buzz).then(n -> "Buzz:" + n), //
              orElse(n -> "Something else:" + n)//
      );
      r.ifPresent(System.err::println);
      return r.isPresent();
    });
  }
}
