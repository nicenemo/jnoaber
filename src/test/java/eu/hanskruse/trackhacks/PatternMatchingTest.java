package eu.hanskruse.trackhacks;

import org.junit.Test;

import eu.hanskruse.trackhacks.testdata.FizzBuzz;
import eu.hanskruse.trackhacks.noaber.WithPatternMatching;
import java.util.Optional;

import org.quicktheories.WithQuickTheories;

/**
 * Pattern matching examples.
 * @author Hans Kruse
 *
 */
public class PatternMatchingTest implements WithQuickTheories, WithPatternMatching {

  /**
   *   FizzBuzz example.
   */
  @Test
  public void fizzBuzzExample() {
    qt().forAll(integers().all()).check(i ->{
    final Optional<String> r =//
        match(i).with(//
            whenPredicate(FizzBuzz::fizzBuzz).then(n -> "FizzBuzz:"+n),
            whenPredicate(FizzBuzz::fizz).then(n -> "Fizz:" + n),
            whenPredicate(FizzBuzz::buzz).then(n -> "Buzz:" + n),//
            orElse(n->"Something else:" + n)//
            ); 
    r.ifPresent(System.err::println);
    return r.isPresent();
    });
  }
}
