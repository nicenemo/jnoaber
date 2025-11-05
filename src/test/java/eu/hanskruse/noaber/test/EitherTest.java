package eu.hanskruse.noaber.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eu.hanskruse.noaber.Either;

/**
 * Unit tests for Either<E,T>
 *
 * @author kruse@hanskruse.eu
 *
 */
final class EitherTest {

  /**
  * Interface to be mocked to check if consumer were called.
  *
  * @author kruse@hanskruse.eu
  *
  */
  public interface ConsumerCheck {

    void leftConsumer(IllegalStateException left);

    void rightConsumer(String right);
  }

  /**
  * Always return true.
  *
  * @param object ignored
  * @return true
  */
  private static boolean always(Object object) {
    return true;
  }

  /**
  * identity helper function that does nothing to the provided argument.
  *
  * @param value value to return
  * @return provided value
  */
  private static <T> T identity(final T value) {
    return value;
  }

  /**
  * Always return false
  *
  * @param object ignored
  * @return false
  */
  private static boolean never(Object object) {
    return false;
  }

  private ConsumerCheckImpl consumerCheck;

  private IllegalStateException left;

  private String right;

  private Either<IllegalStateException, String> sut;

  @Test
  void emptyEitherGivesLeftPresentFalse() {
    sut = Either.empty();
    assertThat(sut.isLeftPresent()).isFalse();
  }

  @Test
  void emptyEitherGivesRightPresentFalse() {
    sut = Either.empty();
    assertThat(sut.isRightPresent()).isFalse();
  }

  @Test
  void emptyEqualsEmpty() {
    sut = Either.empty();
    assertThat(sut).isEqualTo(Either.empty());
  }

  @Test
  void emptyEqualsNullableLeftWithNull() {
    assertThat(Either.ofNullableLeft(null)).isEqualTo(Either.empty());
  }

  @Test
  void emptyEqualsNullableRightWithNull() {
    assertThat(Either.ofNullableRight(null)).isEqualTo(Either.empty());
  }

  @Test
  void emptyWithIfLeftIsNotConsumed() {
    sut = Either.empty();
    sut.ifLeftPresent(consumerCheck::leftConsumer);
    assertThat(consumerCheck.isLeftCalled()).isFalse();
  }

  @Test
  void emptyWithIfRightIsNotConsumed() {
    sut = Either.empty();
    sut.ifRightPresent(consumerCheck::rightConsumer);
    assertThat(consumerCheck.isRightCalled()).isFalse();
  }

  @Test
  void filterLeftWithEmptyGiveEmptyOnAlways() {
    sut = Either.empty();
    final Optional<IllegalStateException> result = sut.filterLeft(EitherTest::always);
    assertThat(result).isEmpty();
  }

  @Test
  void filterLeftWithLeftAndNullPredicateThrowsNullPointerException() {
    sut = Either.ofLeft(left);
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> sut.filterLeft(null));
  }

  @Test
  void filterLeftWithLeftPresentGivesEmptyOnNever() {
    sut = Either.ofLeft(left);
    final Optional<IllegalStateException> result = sut.filterLeft(EitherTest::never);
    assertThat(result).isEmpty();
  }

  @Test
  void filterLeftWithLeftPresentGivesLeftOnAlways() {
    sut = Either.ofLeft(left);
    final Optional<IllegalStateException> result = sut.filterLeft(EitherTest::always);
    assertThat(result).hasValue(left);
  }

  @Test
  void filterLeftWithRightPresentGivesEmptyOnAlways() {
    sut = Either.ofRight(right);
    final Optional<IllegalStateException> result = sut.filterLeft(EitherTest::always);
    assertThat(result).isEmpty();
  }

  @Test
  void filterRightWithEmptyGivesEmptyOnAlways() {
    sut = Either.empty();
    final Optional<String> result = sut.filterRight(EitherTest::always);
    assertThat(result).isEmpty();
  }

  @Test
  void filterRightWithLeftPresentGivesEmptyOnAlways() {
    sut = Either.ofLeft(left);
    final Optional<String> result = sut.filterRight(EitherTest::always);
    assertThat(result).isEmpty();
  }

  @Test
  void filterRightWithRightAndNullPredicateThrowsNullPointerException() {
    sut = Either.ofRight(right);
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> sut.filterRight(null));
  }

  @Test
  void filterRightWithRightPresentGivesEmptyOnNever() {
    sut = Either.ofRight(right);
    final Optional<String> result = sut.filterRight(EitherTest::never);
    assertThat(result).isEmpty();
  }

  @Test
  void filterRightWithRightPresentGivesRightOnAlways() {
    sut = Either.ofRight(right);
    final Optional<String> result = sut.filterRight(EitherTest::always);
    assertThat(result)
            .hasValue(right);
  }

  @Test
  void getLeftOnEmptyThrowsNoSuchElementException() {
    sut = Either.empty();
    assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> sut.getLeft());
  }

  @Test
  void getLeftOnRightThrowsNoSuchElementException() {
    sut = Either.ofRight(right);
    assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> sut.getLeft());
  }

  @Test
  void getRightOnEmptyThrowsNoSuchElementException() {
    sut = Either.empty();
    assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> sut.getRight());
  }

  @Test
  void getRightOnLeftThrowsNoSuchElementException() {
    sut = Either.ofLeft(left);
    assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> sut.getRight());
  }

  @Test
  void hashCodeOnEmptyEitherWorks() {
    sut = Either.empty();
    assertThat(sut.hashCode()).isPositive();
  }

  @Test
  void ifLeftNotPresentOther() {
    final IllegalStateException other = new IllegalStateException("other");
    sut = Either.empty();
    final IllegalStateException actual = sut.ifLeftNotPresent(other);
    assertThat(actual).isEqualTo(other);
  }

  @Test
  void ifLeftNotPresentOtherGet() {
    final IllegalStateException expected = new IllegalStateException("other");
    final Supplier<IllegalStateException> other = () -> expected;
    sut = Either.empty();
    final IllegalStateException actual = sut.ifLeftNotPresentGet(other);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void ifLeftNotPresentOtherGetWithNullSupplierThrowsNullPointerException() {
    final Supplier<IllegalStateException> other = null;
    sut = Either.empty();
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> sut.ifLeftNotPresentGet(other));
  }

  @Test
  void ifLeftNotPresentThrow() {
    final Supplier<IllegalArgumentException> thrower = () -> new IllegalArgumentException("other");
    sut = Either.empty();
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> sut.ifLeftNotPresentThrow(thrower));
  }

  @Test
  void ifLeftPresentDoNotThrow() {
    final Supplier<IllegalArgumentException> thrower = () -> new IllegalArgumentException("other");
    sut = Either.ofLeft(left);
    final IllegalStateException actual = sut.ifLeftNotPresentThrow(thrower);
    assertThat(actual).isEqualTo(left);
  }

  @Test
  void ifLeftPresentNotOther() {
    final IllegalStateException other = new IllegalStateException("other");
    sut = Either.ofLeft(left);
    final IllegalStateException actual = sut.ifLeftNotPresent(other);
    assertThat(actual).isEqualTo(left);
  }

  @Test
  void ifLeftPresentNotOtherGet() {
    final Supplier<IllegalStateException> other = () -> new IllegalStateException("other");
    sut = Either.ofLeft(left);
    final IllegalStateException actual = sut.ifLeftNotPresentGet(other);
    assertThat(actual).isEqualTo(left);
  }

  @Test
  void ifRightNotPresentOther() {
    final String other = "other";
    sut = Either.empty();
    final String actual = sut.ifRightNotPresent(other);
    assertThat(actual).isEqualTo(other);
  }

  @Test
  void ifRightNotPresentOtherGet() {
    final String expected = "other";
    final Supplier<String> other = () -> expected;
    sut = Either.empty();
    final String actual = sut.ifRightNotPresentGet(other);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void ifRightNotPresentOtherGetWithNullSupplierThrowsNullPointerException() {
    final Supplier<String> other = null;
    sut = Either.empty();
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> sut.ifRightNotPresentGet(other));
  }

  @Test
  void ifRightNotPresentThrow() {
    final Supplier<IllegalArgumentException> thrower = () -> new IllegalArgumentException("other");
    sut = Either.empty();
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> sut.ifRightNotPresentThrow(thrower));
  }

  @Test
  void ifRightPresentDoNotThrow() {
    final Supplier<IllegalArgumentException> thrower = () -> new IllegalArgumentException("other");
    sut = Either.ofRight(right);
    final String actual = sut.ifRightNotPresentThrow(thrower);
    assertThat(actual).isEqualTo(right);
  }

  @Test
  void ifRightPresentNotOther() {
    final String other = "other";
    sut = Either.ofRight(right);
    final String actual = sut.ifRightNotPresent(other);
    assertThat(actual).isEqualTo(right);
  }

  @Test
  void ifRightPresentNotOtherGet() {
    final Supplier<String> other = () -> "other";
    sut = Either.ofRight(right);
    final String actual = sut.ifRightNotPresentGet(other);
    assertThat(actual).isEqualTo(right);
  }

  /**
  * Initializes test.
  */
  @BeforeEach
  void init() {
    left = new IllegalStateException();
    right = "right value";
    consumerCheck = new ConsumerCheckImpl();
  }

  @Test
  void isEmptyOnEmpty() {
    sut = Either.empty();
    assertThat(sut.isEmpty()).isTrue();
  }

  @Test
  void leftEqualEitherWithSameLeftValue() {
    sut = Either.ofLeft(left);
    assertThat(Either.ofLeft(left)).isEqualTo(sut);
  }
/*
  @Test
  void leftEqualItSelf() {
    sut = Either.ofLeft(left);
    assertThat(sut).isEqualTo(sut);
  }
*/
  @Test
  void leftEqualsDifferentLeftWorks() {
    sut = Either.ofLeft(left);
    assertThat(Either.ofLeft(new IllegalStateException("different"))).isNotEqualTo(sut);
  }

  @Test
  void leftEqualsWithNullWorks() {
    sut = Either.ofLeft(left);
    assertThat(sut).isNotNull();
  }

  @Test
  void leftGivesLeftPresentTrue() {
    sut = Either.ofLeft(left);
    assertThat(sut.isLeftPresent()).isTrue();
  }

  @Test
  void leftGivesRightPresentFalse() {
    sut = Either.ofLeft(left);
    assertThat(sut.isRightPresent()).isFalse();
  }

  @Test
  void leftIfLeftPresentWithNullConsumerThrowsNullPointerException() {
    sut = Either.ofLeft(left);
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> sut.ifLeftPresent(null));
  }

  @Test
  void leftNotEqualEmpty() {
    sut = Either.ofLeft(left);
    assertThat(Either.empty()).isNotEqualTo(sut);
  }

  @Test
  void leftNotEqualRight() {
    sut = Either.ofLeft(left);
    assertThat(Either.ofRight(right)).isNotEqualTo(sut);
  }

  @Test
  void leftWithIfLeftIsConsumed() {
    sut = Either.ofLeft(left);
    sut.ifLeftPresent(consumerCheck::leftConsumer);
    assertThat(consumerCheck.isLeftCalled()).isTrue();
    assertThat(consumerCheck.getLeft()).isEqualTo(left);
  }

  @Test
  void leftWithIfRightIsNotConsumed() {
    sut = Either.ofLeft(left);
    sut.ifRightPresent(consumerCheck::rightConsumer);
    assertThat(consumerCheck.isRightCalled()).isFalse();
  }

  @Test
  void mapLeftLeftGivesResult() {
    sut = Either.ofLeft(left);
    final Optional<? extends IllegalStateException> result = sut.mapLeft(EitherTest::identity);
    assertThat(result).isPresent();
    assertThat(left).isEqualTo(result.get());
  }

  @Test
  void mapLeftWithemptyGivesEmpty() {
    sut = Either.empty();
    final Optional<? extends IllegalStateException> result = sut.mapLeft(EitherTest::identity);
    assertThat(result).isEmpty();
  }

  @Test
  void mapLeftWithLeftAndNullPredicateThrowsNullPointerException() {
    sut = Either.ofLeft(left);
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> sut.mapLeft(null));
  }

  @Test
  void mapLeftWithRightGivesEmpty() {
    sut = Either.ofRight(right);
    final Optional<? extends IllegalStateException> result = sut.mapLeft(EitherTest::identity);
    assertThat(result).isEmpty();
  }

  @Test
  void mapRightWithEmptyGivesEmpty() {
    sut = Either.empty();
    final Optional<? extends String> result = sut.mapRight(EitherTest::identity);
    assertThat(result).isEmpty();
  }

  @Test
  void mapRightWithLeftGivesEmpty() {
    sut = Either.ofLeft(left);
    final Optional<? extends String> result = sut.mapRight(EitherTest::identity);
    assertThat(result).isEmpty();
  }

  @Test
  void mapRightWithRightAndNullPredicateThrowsNullPointerException() {
    sut = Either.ofRight(right);
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> sut.mapRight(null));
  }

  @Test
  void mapRightWithRightGivesResult() {
    sut = Either.ofRight(right);
    final Optional<? extends String> result = sut.mapRight(EitherTest::identity);
    assertThat(result).isPresent();
    assertThat(right).isEqualTo(result.get());
  }

  @Test
  void NotisEmptyOnLeft() {
    sut = Either.ofLeft(left);
    assertThat(sut.isEmpty()).isFalse();
  }

  @Test
  void NotisEmptyOnRight() {
    sut = Either.ofRight(right);
    assertThat(sut.isEmpty()).isFalse();
  }

  @Test
  void ofLeftWithNullThrowsNullPointerException() {
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> sut = Either.ofLeft(null));
  }

  @Test
  void ofNullableLeftWithNullGivesEmpty() {
    sut = Either.ofNullableLeft(null);
    assertThat(sut.isEmpty()).isTrue();
  }

  @Test
  void ofNullableRightWithNullGivesEmpty() {
    sut = Either.ofNullableRight(null);
    assertThat(sut.isEmpty()).isTrue();
  }

  @Test
  void ofRighWithNullThrowsNullPointerException() {
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> Either.ofRight(null));
  }

  @Test
  void rightEqualEitherWithSameRightValue() {
    sut = Either.ofRight(right);
    assertThat(Either.ofRight(right)).isEqualTo(sut);
  }
/*
  @Test
  void rightEqualItSelf() {
    sut = Either.ofRight(right);
    assertThat(sut).isEqualTo(sut);
  }
*/
  @Test
  void rightEqualsDifferentRightWorks() {
    sut = Either.ofRight(right);
    assertThat(Either.ofRight("different")).isNotEqualTo(sut);
  }

  @SuppressWarnings("unlikely-arg-type")
  @Test
  void rightEqualsSomethingDifferentWorks() {
    sut = Either.ofRight(right);
    assertThat(sut).isNotEqualTo("different");
  }

  @Test
  void rightEqualsWithNullWorks() {
    sut = Either.ofRight(right);
    assertThat(sut).isNotNull();
  }

  @Test
  void rightGivesLeftPresentFalse() {
    sut = Either.ofRight(right);
    assertThat(sut.isLeftPresent()).isFalse();
  }

  @Test
  void rightGivesRightPresentTrue() {
    sut = Either.ofRight(right);
    assertThat(sut.isRightPresent()).isTrue();
  }

  @Test
  void rightIfRightPresentWithNullConsumerThrowsNullPointerException() {
    sut = Either.ofRight(right);
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> sut.ifRightPresent(null));
  }

  @Test
  void rightNotEqualEmpty() {
    sut = Either.ofRight(right);
    assertThat(Either.empty()).isNotEqualTo(sut);
  }

  @Test
  void rightNotEqualLeft() {
    sut = Either.ofRight(right);
    assertThat(Either.ofLeft(left)).isNotEqualTo(sut);
  }

  @Test
  void rightWithIfLeftIsNotConsumed() {
    sut = Either.ofRight(right);
    sut.ifLeftPresent(consumerCheck::leftConsumer);
    assertThat(consumerCheck.isLeftCalled()).isFalse();
  }

  @Test
  void rightWithIfRightIsConsumed() {
    sut = Either.ofRight(right);
    sut.ifRightPresent(consumerCheck::rightConsumer);
    assertThat(consumerCheck.isRightCalled()).isTrue();
    assertThat(consumerCheck.getRight()).isEqualTo(right);
  }

  @Test
  void swapEmptyIsEmpty() {
    sut = Either.empty();
    assertThat(sut.swap()).isEqualTo(sut);
  }

  @Test
  void swapLeftGivesIsLeftPresentFalse() {
    sut = Either.ofLeft(left);
    assertThat(sut.swap().isLeftPresent()).isFalse();
  }

  @Test
  void swapLeftGivesLeftOngetRight() {
    sut = Either.ofLeft(left);
    assertThat(sut.swap().getRight()).isEqualTo(left);
  }

  @Test
  void swapRightGivesRightOngetLeft() {
    sut = Either.ofRight(right);
    assertThat(sut.swap().getLeft()).isEqualTo(right);
  }

  @Test
  void swapRightGivesRightPresentFalse() {
    sut = Either.ofRight(right);
    assertThat(sut.swap().isRightPresent()).isFalse();
  }

  @Test
  void toStringOnEmptyEitherWorks() {
    sut = Either.empty();
    assertThat(sut.toString()).isNotEmpty();
  }
}
