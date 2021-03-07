package eu.hanskruse.noaber.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import eu.hanskruse.testdata.food.fastfood.Hamburger;
import eu.hanskruse.testdata.food.fruit.Apple;
import eu.hanskruse.testdata.food.fruit.apples.McIntosh;

public class RightAppliedTest {

  @Test
  public void testRightAppliedAnApple() {
    assertTrue(isApple(new McIntosh()));
  }

  @Test
  public void testRightAppliedAHamburger() {
    assertFalse(isApple(new Hamburger()));
  }

  public static Predicate<Object> matchClass(final Class<?> clazz) {
    return o -> clazz.isInstance(o);
  }

  public static boolean isApple(final Object o) {
    return matchClass(Apple.class).test(o);
  }

}
