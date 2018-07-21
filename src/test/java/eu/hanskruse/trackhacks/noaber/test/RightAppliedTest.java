package eu.hanskruse.trackhacks.noaber.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

import org.junit.Ignore;
import org.junit.Test;

import eu.hanskruse.trackhacks.testdata.food.fastfood.Hamburger;
import eu.hanskruse.trackhacks.testdata.food.fruit.Apple;
import eu.hanskruse.trackhacks.testdata.food.fruit.apples.McIntosh;


public class RightAppliedTest {

  @SuppressWarnings("static-method")
  @Test
  public void testRightAppliedAnApple() {
    assertTrue(isApple(new McIntosh()));
  }

  @SuppressWarnings("static-method")
  @Ignore
  @Test
  public void testRightAppliedAHamburger() {
    assertFalse(isApple(new Hamburger()));
  }

  public static Predicate<Object> matchClass(final Class<?> clazz){
     return o -> clazz.isInstance(o);
  }


  public static boolean isApple(final Object o) {
    return matchClass(Apple.class).test(o);
  }

}
