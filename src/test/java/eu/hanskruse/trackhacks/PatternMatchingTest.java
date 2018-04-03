package eu.hanskruse.trackhacks;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.quicktheories.WithQuickTheories;

import eu.hanskruse.trackhacks.noaber.WithPatternMatching;
import eu.hanskruse.trackhacks.testdata.FizzBuzz;
import eu.hanskruse.trackhacks.testdata.food.fruit.Apple;
import eu.hanskruse.trackhacks.testdata.food.fruit.apples.Elstar;

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
      final Optional<String> result = //
          match(i).with(//
              whenPredicate(FizzBuzz::fizzBuzz).then(n -> "FizzBuzz:" + n),
              whenPredicate(FizzBuzz::fizz).then(n -> "Fizz:" + n),
              whenPredicate(FizzBuzz::buzz).then(n -> "Buzz:" + n), //
              orElse(n -> "Something else:" + n)//
      );
      //result.ifPresent(System.err::println);
      return result.isPresent();
    });
  }
  
  /**
   * A class should match an instance of itself
   */
  @Test
  public void classMatchesInstanceOfItself() {
    assertTrue(classMatches(Elstar.class).test(new Elstar()));
  }
  
  
  /**
   * A class should match an instance of itself
   */
  @Test
  public void classMatchesInstanceOfADirectSubClass() {
    assertTrue(classMatches(Apple.class).test(new Elstar()));
  }
  
  /**
   * Class matching example.
   */
  /*
  @Test
  public void classMatchingExample() {
      final Food food = new Hamburger();
      final Optional<String> result = //
         match(new Elstar()).with(//
             whenClass(Elstar.class).then("Elstar"),
             whenClass(Fuji.class).then("Fuji"),
             whenClass(Braeburn.class).then("Braeburn"),
             whenClass(McIntosh.class).then("McIntosh"),
             whenClass(Apple.class).then(a ->"Not a known apple: "+ a.getClass().getName()),
             whenClass(Fruit.class).then(a ->"Not an Apple but it is fruit: "+ a.getClass().getName()),
             whenClass(FastFood.class).then(a ->"Not an Apple but fastfood :( : "+ a.getClass().getName()),
             whenClass(Food.class).then(a ->"Not an apple but you can eat it! : "+ a.getClass().getName()),
             orElse(n -> "Not edible" + n)//
      );
      //result.ifPresent(System.err::println);
      assertTrue(result.isPresent());
  }*/
}
