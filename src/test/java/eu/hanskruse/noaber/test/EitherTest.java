package eu.hanskruse.noaber.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
class EitherTest {

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
    assertFalse(sut.isLeftPresent());
  }

  @Test
  void emptyEitherGivesRightPresentFalse() {
    sut = Either.empty();
    assertFalse(sut.isRightPresent());
  }

  @Test
  void emptyEqualsEmpty() {
    sut = Either.empty();
    assertEquals(Either.empty(), sut);
  }

  @Test
  void emptyEqualsNullableLeftWithNull() {
    assertEquals(Either.empty(), Either.ofNullableLeft(null));
  }

  @Test
  void emptyEqualsNullableRightWithNull() {
    assertEquals(Either.empty(), Either.ofNullableRight(null));
  }

  @Test
  void emptyWithIfLeftIsNotConsumed() {
    sut = Either.empty();
    sut.ifLeftPresent(consumerCheck::leftConsumer);
    assertFalse(consumerCheck.isLeftCalled());
  }

  @Test
  void emptyWithIfRightIsNotConsumed() {
    sut = Either.empty();
    sut.ifRightPresent(consumerCheck::rightConsumer);
    assertFalse(consumerCheck.isRightCalled());
  }

  @Test
  void filterLeftWithEmptyGiveEmptyOnAlways() {
    sut = Either.empty();
    final Optional<IllegalStateException> result = sut.filterLeft(EitherTest::always);
    assertFalse(result.isPresent());
  }

  @Test
  void filterLeftWithLeftAndNullPredicateThrowsNullPointerException() {
    sut = Either.ofLeft(left);
    assertThrows(NullPointerException.class, () -> sut.filterLeft(null));
  }

  @Test
  void filterLeftWithLeftPresentGivesEmptyOnNever() {
    sut = Either.ofLeft(left);
    final Optional<IllegalStateException> result = sut.filterLeft(EitherTest::never);
    assertFalse(result.isPresent());
  }

  @Test
  void filterLeftWithLeftPresentGivesLeftOnAlways() {
    sut = Either.ofLeft(left);
    final Optional<IllegalStateException> result = sut.filterLeft(EitherTest::always);
    assertTrue(result.isPresent());
    assertEquals(left, result.get());
  }

  @Test
  void filterLeftWithRightPresentGivesEmptyOnAlways() {
    sut = Either.ofRight(right);
    final Optional<IllegalStateException> result = sut.filterLeft(EitherTest::always);
    assertFalse(result.isPresent());
  }

  @Test
  void filterRightWithEmptyGivesEmptyOnAlways() {
    sut = Either.empty();
    final Optional<String> result = sut.filterRight(EitherTest::always);
    assertFalse(result.isPresent());
  }

  @Test
  void filterRightWithLeftPresentGivesEmptyOnAlways() {
    sut = Either.ofLeft(left);
    final Optional<String> result = sut.filterRight(EitherTest::always);
    assertFalse(result.isPresent());
  }

  @Test
  void filterRightWithRightAndNullPredicateThrowsNullPointerException() {
    sut = Either.ofRight(right);
    assertThrows(NullPointerException.class, () -> sut.filterRight(null));
  }

  @Test
  void filterRightWithRightPresentGivesEmptyOnNever() {
    sut = Either.ofRight(right);
    final Optional<String> result = sut.filterRight(EitherTest::never);
    assertFalse(result.isPresent());
  }

  @Test
  void filterRightWithRightPresentGivesRightOnAlways() {
    sut = Either.ofRight(right);
    final Optional<String> result = sut.filterRight(EitherTest::always);
    assertTrue(result.isPresent());
    assertEquals(right, result.get());
  }

  @Test
  void getLeftOnEmptyThrowsNoSuchElementException() {
    sut = Either.empty();
    assertThrows(NoSuchElementException.class, () -> sut.getLeft());
  }

  @Test
  void getLeftOnRightThrowsNoSuchElementException() {
    sut = Either.ofRight(right);
    assertThrows(NoSuchElementException.class, () -> sut.getLeft());
  }

  @Test
  void getRightOnEmptyThrowsNoSuchElementException() {
    sut = Either.empty();
    assertThrows(NoSuchElementException.class, () -> sut.getRight());
  }

  @Test
  void getRightOnLeftThrowsNoSuchElementException() {
    sut = Either.ofLeft(left);
    assertThrows(NoSuchElementException.class, () -> sut.getRight());
  }

  @Test
  void hashCodeOnEmptyEitherWorks() {
    sut = Either.empty();
    assertTrue(sut.hashCode() > 0);
  }

  @Test
  void ifLeftNotPresentOther() {
    final IllegalStateException other = new IllegalStateException("other");
    sut = Either.empty();
    final IllegalStateException actual = sut.ifLeftNotPresent(other);
    assertEquals(other, actual);
  }

  @Test
  void ifLeftNotPresentOtherGet() {
    final IllegalStateException expected = new IllegalStateException("other");
    final Supplier<IllegalStateException> other = () -> expected;
    sut = Either.empty();
    final IllegalStateException actual = sut.ifLeftNotPresentGet(other);
    assertEquals(expected, actual);
  }

  @Test
  void ifLeftNotPresentOtherGetWithNullSupplierThrowsNullPointerException() {
    final Supplier<IllegalStateException> other = null;
    sut = Either.empty();
    assertThrows(NullPointerException.class, () -> sut.ifLeftNotPresentGet(other));
  }

  @Test
  void ifLeftNotPresentThrow() {
    final Supplier<IllegalArgumentException> thrower = () -> new IllegalArgumentException("other");
    sut = Either.empty();
    assertThrows(IllegalArgumentException.class, () -> sut.ifLeftNotPresentThrow(thrower));
  }

  @Test
  void ifLeftPresentDoNotThrow() {
    final Supplier<IllegalArgumentException> thrower = () -> new IllegalArgumentException("other");
    sut = Either.ofLeft(left);
    final IllegalStateException actual = sut.ifLeftNotPresentThrow(thrower);
    assertEquals(left, actual);
  }

  @Test
  void ifLeftPresentNotOther() {
    final IllegalStateException other = new IllegalStateException("other");
    sut = Either.ofLeft(left);
    final IllegalStateException actual = sut.ifLeftNotPresent(other);
    assertEquals(left, actual);
  }

  @Test
  void ifLeftPresentNotOtherGet() {
    final Supplier<IllegalStateException> other = () -> new IllegalStateException("other");
    sut = Either.ofLeft(left);
    final IllegalStateException actual = sut.ifLeftNotPresentGet(other);
    assertEquals(left, actual);
  }

  @Test
  void ifRightNotPresentOther() {
    final String other = "other";
    sut = Either.empty();
    final String actual = sut.ifRightNotPresent(other);
    assertEquals(other, actual);
  }

  @Test
  void ifRightNotPresentOtherGet() {
    final String expected = "other";
    final Supplier<String> other = () -> expected;
    sut = Either.empty();
    final String actual = sut.ifRightNotPresentGet(other);
    assertEquals(expected, actual);
  }

  @Test
  void ifRightNotPresentOtherGetWithNullSupplierThrowsNullPointerException() {
    final Supplier<String> other = null;
    sut = Either.empty();
    assertThrows(NullPointerException.class, () -> sut.ifRightNotPresentGet(other));
  }

  @Test
  void ifRightNotPresentThrow() {
    final Supplier<IllegalArgumentException> thrower = () -> new IllegalArgumentException("other");
    sut = Either.empty();
    assertThrows(IllegalArgumentException.class, () -> sut.ifRightNotPresentThrow(thrower));
  }

  @Test
  void ifRightPresentDoNotThrow() {
    final Supplier<IllegalArgumentException> thrower = () -> new IllegalArgumentException("other");
    sut = Either.ofRight(right);
    final String actual = sut.ifRightNotPresentThrow(thrower);
    assertEquals(right, actual);
  }

  @Test
  void ifRightPresentNotOther() {
    final String other = "other";
    sut = Either.ofRight(right);
    final String actual = sut.ifRightNotPresent(other);
    assertEquals(right, actual);
  }

  @Test
  void ifRightPresentNotOtherGet() {
    final Supplier<String> other = () -> "other";
    sut = Either.ofRight(right);
    final String actual = sut.ifRightNotPresentGet(other);
    assertEquals(right, actual);
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
    assertTrue(sut.isEmpty());
  }

  @Test
  void leftEqualEitherWithSameLeftValue() {
    sut = Either.ofLeft(left);
    assertTrue(sut.equals(Either.ofLeft(left)));
  }

  @Test
  void leftEqualItSelf() {
    sut = Either.ofLeft(left);
    assertTrue(sut.equals(sut));
  }

  @Test
  void leftEqualsDifferentLeftWorks() {
    sut = Either.ofLeft(left);
    assertFalse(sut.equals(Either.ofLeft(new IllegalStateException("different"))));
  }

  @Test
  void leftEqualsWithNullWorks() {
    sut = Either.ofLeft(left);
    assertFalse(sut.equals(null));
  }

  @Test
  void leftGivesLeftPresentTrue() {
    sut = Either.ofLeft(left);
    assertTrue(sut.isLeftPresent());
  }

  @Test
  void leftGivesRightPresentFalse() {
    sut = Either.ofLeft(left);
    assertFalse(sut.isRightPresent());
  }

  @Test
  void leftIfLeftPresentWithNullConsumerThrowsNullPointerException() {
    sut = Either.ofLeft(left);
    assertThrows(NullPointerException.class, () -> sut.ifLeftPresent(null));
  }

  @Test
  void leftNotEqualEmpty() {
    sut = Either.ofLeft(left);
    assertFalse(sut.equals(Either.empty()));
  }

  @Test
  void leftNotEqualRight() {
    sut = Either.ofLeft(left);
    assertFalse(sut.equals(Either.ofRight(right)));
  }

  @Test
  void leftWithIfLeftIsConsumed() {
    sut = Either.ofLeft(left);
    sut.ifLeftPresent(consumerCheck::leftConsumer);
    assertTrue(consumerCheck.isLeftCalled());
    assertEquals(left, consumerCheck.getLeft());
  }

  @Test
  void leftWithIfRightIsNotConsumed() {
    sut = Either.ofLeft(left);
    sut.ifRightPresent(consumerCheck::rightConsumer);
    assertFalse(consumerCheck.isRightCalled());
  }

  @Test
  void mapLeftLeftGivesResult() {
    sut = Either.ofLeft(left);
    final Optional<? extends IllegalStateException> result = sut.mapLeft(EitherTest::identity);
    assertTrue(result.isPresent());
    assertEquals(result.get(), left);
  }

  @Test
  void mapLeftWithemptyGivesEmpty() {
    sut = Either.empty();
    final Optional<? extends IllegalStateException> result = sut.mapLeft(EitherTest::identity);
    assertFalse(result.isPresent());
  }

  @Test
  void mapLeftWithLeftAndNullPredicateThrowsNullPointerException() {
    sut = Either.ofLeft(left);
    assertThrows(NullPointerException.class, () -> sut.mapLeft(null));
  }

  @Test
  void mapLeftWithRightGivesEmpty() {
    sut = Either.ofRight(right);
    final Optional<? extends IllegalStateException> result = sut.mapLeft(EitherTest::identity);
    assertFalse(result.isPresent());
  }

  @Test
  void mapRightWithEmptyGivesEmpty() {
    sut = Either.empty();
    final Optional<? extends String> result = sut.mapRight(EitherTest::identity);
    assertFalse(result.isPresent());
  }

  @Test
  void mapRightWithLeftGivesEmpty() {
    sut = Either.ofLeft(left);
    final Optional<? extends String> result = sut.mapRight(EitherTest::identity);
    assertFalse(result.isPresent());
  }

  @Test
  void mapRightWithRightAndNullPredicateThrowsNullPointerException() {
    sut = Either.ofRight(right);
    assertThrows(NullPointerException.class, () -> sut.mapRight(null));
  }

  @Test
  void mapRightWithRightGivesResult() {
    sut = Either.ofRight(right);
    final Optional<? extends String> result = sut.mapRight(EitherTest::identity);
    assertTrue(result.isPresent());
    assertEquals(result.get(), right);
  }

  @Test
  void NotisEmptyOnLeft() {
    sut = Either.ofLeft(left);
    assertFalse(sut.isEmpty());
  }

  @Test
  void NotisEmptyOnRight() {
    sut = Either.ofRight(right);
    assertFalse(sut.isEmpty());
  }

  @Test
  void ofLeftWithNullThrowsNullPointerException() {
    assertThrows(NullPointerException.class, () -> sut = Either.ofLeft(null));
  }

  @Test
  void ofNullableLeftWithNullGivesEmpty() {
    sut = Either.ofNullableLeft(null);
    assertTrue(sut.isEmpty());
  }

  @Test
  void ofNullableRightWithNullGivesEmpty() {
    sut = Either.ofNullableRight(null);
    assertTrue(sut.isEmpty());
  }

  @Test
  void ofRighWithNullThrowsNullPointerException() {
    assertThrows(NullPointerException.class, (() -> Either.ofRight(null)));
  }

  @Test
  void rightEqualEitherWithSameRightValue() {
    sut = Either.ofRight(right);
    assertTrue(sut.equals(Either.ofRight(right)));
  }

  @Test
  void rightEqualItSelf() {
    sut = Either.ofRight(right);
    assertTrue(sut.equals(sut));
  }

  @Test
  void rightEqualsDifferentRightWorks() {
    sut = Either.ofRight(right);
    assertFalse(sut.equals(Either.ofRight("different")));
  }

  @SuppressWarnings("unlikely-arg-type")
  @Test
  void rightEqualsSomethingDifferentWorks() {
    sut = Either.ofRight(right);
    assertFalse(sut.equals("different"));
  }

  @Test
  void rightEqualsWithNullWorks() {
    sut = Either.ofRight(right);
    assertFalse(sut.equals(null));
  }

  @Test
  void rightGivesLeftPresentFalse() {
    sut = Either.ofRight(right);
    assertFalse(sut.isLeftPresent());
  }

  @Test
  void rightGivesRightPresentTrue() {
    sut = Either.ofRight(right);
    assertTrue(sut.isRightPresent());
  }

  @Test
  void rightIfRightPresentWithNullConsumerThrowsNullPointerException() {
    sut = Either.ofRight(right);
    assertThrows(NullPointerException.class, () -> sut.ifRightPresent(null));
  }

  @Test
  void rightNotEqualEmpty() {
    sut = Either.ofRight(right);
    assertFalse(sut.equals(Either.empty()));
  }

  @Test
  void rightNotEqualLeft() {
    sut = Either.ofRight(right);
    assertFalse(sut.equals(Either.ofLeft(left)));
  }

  @Test
  void rightWithIfLeftIsNotConsumed() {
    sut = Either.ofRight(right);
    sut.ifLeftPresent(consumerCheck::leftConsumer);
    assertFalse(consumerCheck.isLeftCalled());
  }

  @Test
  void rightWithIfRightIsConsumed() {
    sut = Either.ofRight(right);
    sut.ifRightPresent(consumerCheck::rightConsumer);
    assertTrue(consumerCheck.isRightCalled());
    assertEquals(right, consumerCheck.getRight());
  }

  @Test
  void swapEmptyIsEmpty() {
    sut = Either.empty();
    assertEquals(sut, sut.swap());
  }

  @Test
  void swapLeftGivesIsLeftPresentFalse() {
    sut = Either.ofLeft(left);
    assertFalse(sut.swap().isLeftPresent());
  }

  @Test
  void swapLeftGivesLeftOngetRight() {
    sut = Either.ofLeft(left);
    assertEquals(left, sut.swap().getRight());
  }

  @Test
  void swapRightGivesRightOngetLeft() {
    sut = Either.ofRight(right);
    assertEquals(right, sut.swap().getLeft());
  }

  @Test
  void swapRightGivesRightPresentFalse() {
    sut = Either.ofRight(right);
    assertFalse(sut.swap().isRightPresent());
  }

  @Test
  void toStringOnEmptyEitherWorks() {
    sut = Either.empty();
    assertTrue(sut.toString().length() > 0);
  }
}
