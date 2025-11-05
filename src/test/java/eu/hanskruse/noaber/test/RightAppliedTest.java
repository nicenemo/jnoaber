package eu.hanskruse.noaber.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import eu.hanskruse.testdata.food.fastfood.Hamburger;
import eu.hanskruse.testdata.food.fruit.Apple;
import eu.hanskruse.testdata.food.fruit.apples.McIntosh;

final class RightAppliedTest {

  @Test
  void rightAppliedAnApple() {
    assertThat(isApple(new McIntosh())).isTrue();
  }

  @Test
  void rightAppliedAHamburger() {
    assertThat(isApple(new Hamburger())).isFalse();
  }

  public static Predicate<Object> matchClass(final Class<?> clazz) {
    return clazz::isInstance;
  }

  public static boolean isApple(final Object o) {
    return matchClass(Apple.class).test(o);
  }

}
