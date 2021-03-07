package eu.hanskruse.noaber.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import org.quicktheories.WithQuickTheories;

import eu.hanskruse.noaber.patternMatching.Case;
import eu.hanskruse.noaber.WithNoaber;
import eu.hanskruse.testdata.FizzBuzz;
import eu.hanskruse.testdata.food.fastfood.Hamburger;
import eu.hanskruse.testdata.food.fruit.Apple;
import eu.hanskruse.testdata.food.fruit.apples.Elstar;

/**
* Pattern matching examples.
*
* @author Hans Kruse
*
*/
public class PatternMatchingTest implements WithQuickTheories, WithNoaber {

  /**
  * FizzBuzz example.
  */
  @Test
  public void fizzBuzzExample() {
    qt().forAll(integers().all()).check(i -> {
      @SuppressWarnings("unchecked")
      final Optional<String> result = //
      (Optional<String>) match(i).with(//
      whenPredicate(FizzBuzz::fizzBuzz).then(n -> "FizzBuzz:" + n),
      whenPredicate(FizzBuzz::fizz).then(n -> "Fizz:" + n),
      whenPredicate(FizzBuzz::buzz).then(n -> "Buzz:" + n), //
      orElse(n -> "Something else:" + n)//
      );
      // result.ifPresent(System.err::println);
      return result.isPresent();
    });
  }

  public boolean isApple(final Object o) {
    return whenClass(Apple.class).then(Boolean.TRUE).apply((Apple) o).isPresent();
  }

  @Test
  public void anElstartIsAnApple() {
    assertTrue(isApple(new Elstar()));
  }

  @Disabled("TODO: fix type resolution")
  @Test
  public void aHamburgerIsNotAnApple() {
    final Hamburger hamburger = new Hamburger();
    assertFalse(isApple(hamburger));
  }


  @Test
  public void aa() {
    final Case<Elstar, String> caseClause = whenClass(Elstar.class).then(x -> "Elstar" + x.getClass());
    @SuppressWarnings("unchecked")
    Optional<String> result = (Optional<String>) match(new Elstar()).with(caseClause);
    assertTrue(result.isPresent());
  }

  /*
  * @Test public void classMatchingExample() { final Fruit o = new Elstar();
    * final Optional<String> result = // match(o).with(//
    * whenClass(Elstar.class).then("Elstar"), whenClass(Fuji.class).then("Fuji"),
    * whenClass(Braeburn.class).then("Braeburn"),
    * whenClass(McIntosh.class).then("McIntosh"), whenClass(Apple.class).then(a
    * ->"Not a known apple: "+ a.getClass().getName()),
    * whenClass(Fruit.class).then(a ->"Not an Apple but it is fruit: "+
    * a.getClass().getName()), whenClass(FastFood.class).then(a
    * ->"Not an Apple but fastfood :( : "+ a.getClass().getName()),
    * whenClass(Food.class).then(a ->"Not an apple but you can eat it! : "+
    * a.getClass().getName()), orElse(n -> "Not edible" + n)// );
    * //result.ifPresent(System.err::println); assertTrue(result.isPresent()); }
    */

    /**
    * Class matching example.
    */
    /*
    * @Test public void classMatchingExample() { final Food food = new Hamburger();
      * final Optional<String> result = // match(new Elstar()).with(//
      * whenClass(Elstar.class).then("Elstar"), whenClass(Fuji.class).then("Fuji"),
      * whenClass(Braeburn.class).then("Braeburn"),
      * whenClass(McIntosh.class).then("McIntosh"), whenClass(Apple.class).then(a
      * ->"Not a known apple: "+ a.getClass().getName()),
      * whenClass(Fruit.class).then(a ->"Not an Apple but it is fruit: "+
      * a.getClass().getName()), whenClass(FastFood.class).then(a
      * ->"Not an Apple but fastfood :( : "+ a.getClass().getName()),
      * whenClass(Food.class).then(a ->"Not an apple but you can eat it! : "+
      * a.getClass().getName()), orElse(n -> "Not edible" + n)// );
      * //result.ifPresent(System.err::println); assertTrue(result.isPresent()); }
      */
    }
