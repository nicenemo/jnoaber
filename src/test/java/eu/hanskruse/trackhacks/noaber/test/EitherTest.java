package eu.hanskruse.trackhacks.noaber.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import eu.hanskruse.trackhacks.noaber.Either;

/**
 * Unit tests for Either<E,T>
 *
 * @author kruse@hanskruse.eu
 *
 */
public class EitherTest {

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
   * @param object
   *          ignored
   * @return true
   */
  private static boolean always(Object object) {
    return true;
  }

  /**
   * identity helper function that does nothing to the provided argument.
   *
   * @param value
   *          value to return
   * @return provided value
   */
  private static <T> T identity(final T value) {
    return value;
  }

  /**
   * Always return false
   *
   * @param object
   *          ignored
   * @return false
   */
  private static boolean never(Object object) {
    return false;
  }

  private ConsumerCheck consumerCheck;

  /**
   * Expected exception.
   */
  @Rule
  public ExpectedException exception = ExpectedException.none();

  private IllegalStateException left;

  private String right;

  private Either<IllegalStateException, String> sut;

  @Test
  public void emptyEitherGivesLeftPresentFalse() {
    sut = Either.empty();
    assertFalse(sut.isLeftPresent());
  }

  @Test
  public void emptyEitherGivesRightPresentFalse() {
    sut = Either.empty();
    assertFalse(sut.isRightPresent());
  }

  @Test
  public void emptyEqualsEmpty() {
    sut = Either.empty();
    assertTrue(sut.equals(Either.empty()));
  }

  @Test
  public void emptyEqualsNullableLeftWithNull() {
    sut = Either.empty();
    assertTrue(sut.equals(Either.ofNullableLeft(null)));
  }

  @Test
  public void emptyEqualsNullableRightWithNull() {
    sut = Either.empty();
    assertTrue(sut.equals(Either.ofNullableRight(null)));
  }

  @Test
  public void emptyWithIfLeftIsNotConsumed() {
    sut = Either.empty();
    sut.ifLeftPresent(consumerCheck::leftConsumer);
    verify(consumerCheck, times(0)).leftConsumer(any());
  }

  @Test
  public void emptyWithIfRightIsNotConsumed() {
    sut = Either.empty();
    sut.ifRightPresent(consumerCheck::rightConsumer);
    verify(consumerCheck, times(0)).rightConsumer(any());
  }

  @Test
  public void filterLeftWithEmptyGiveEmptyOnAlways() {
    sut = Either.empty();
    final Optional<IllegalStateException> result = sut.filterLeft(EitherTest::always);
    assertFalse(result.isPresent());
  }

  @Test
  public void filterLeftWithLeftAndNullPredicateThrowsNullPointerException() {
    sut = Either.ofLeft(left);
    exception.expect(NullPointerException.class);
    sut.filterLeft(null);
  }

  @Test
  public void filterLeftWithLeftPresentGivesEmptyOnNever() {
    sut = Either.ofLeft(left);
    final Optional<IllegalStateException> result = sut.filterLeft(EitherTest::never);
    assertFalse(result.isPresent());
  }

  @Test
  public void filterLeftWithLeftPresentGivesLeftOnAlways() {
    sut = Either.ofLeft(left);
    final Optional<IllegalStateException> result = sut.filterLeft(EitherTest::always);
    assertTrue(result.isPresent());
    assertEquals(left, result.get());
  }

  @Test
  public void filterLeftWithRightPresentGivesEmptyOnAlways() {
    sut = Either.ofRight(right);
    final Optional<IllegalStateException> result = sut.filterLeft(EitherTest::always);
    assertFalse(result.isPresent());
  }

  @Test
  public void filterRightWithEmptyGivesEmptyOnAlways() {
    sut = Either.empty();
    final Optional<String> result = sut.filterRight(EitherTest::always);
    assertFalse(result.isPresent());
  }

  @Test
  public void filterRightWithLeftPresentGivesEmptyOnAlways() {
    sut = Either.ofLeft(left);
    final Optional<String> result = sut.filterRight(EitherTest::always);
    assertFalse(result.isPresent());
  }

  @Test
  public void filterRightWithRightAndNullPredicateThrowsNullPointerException() {
    sut = Either.ofRight(right);
    exception.expect(NullPointerException.class);
    sut.filterRight(null);
  }

  @Test
  public void filterRightWithRightPresentGivesEmptyOnNever() {
    sut = Either.ofRight(right);
    final Optional<String> result = sut.filterRight(EitherTest::never);
    assertFalse(result.isPresent());
  }

  @Test
  public void filterRightWithRightPresentGivesRightOnAlways() {
    sut = Either.ofRight(right);
    final Optional<String> result = sut.filterRight(EitherTest::always);
    assertTrue(result.isPresent());
    assertEquals(right, result.get());
  }

  @Test
  public void getLeftOnEmptyThrowsNoSuchElementException() {
    sut = Either.empty();
    exception.expect(NoSuchElementException.class);
    sut.getLeft();
  }

  @Test
  public void getLeftOnRightThrowsNoSuchElementException() {
    sut = Either.ofRight(right);
    exception.expect(NoSuchElementException.class);
    sut.getLeft();
  }

  @Test
  public void getRightOnEmptyThrowsNoSuchElementException() {
    sut = Either.empty();
    exception.expect(NoSuchElementException.class);
    sut.getRight();
  }

  @Test
  public void getRightOnLeftThrowsNoSuchElementException() {
    sut = Either.ofLeft(left);
    exception.expect(NoSuchElementException.class);
    sut.getRight();
  }

  @Test
  public void hashCodeOnEmptyEitherWorks() {
    sut = Either.empty();
    assertTrue(sut.hashCode() > 0);
  }

  @Test
  public void ifLeftNotPresentOther() {
    final IllegalStateException other = new IllegalStateException("other");
    sut = Either.empty();
    final IllegalStateException actual = sut.ifLeftNotPresent(other);
    assertEquals(other, actual);
  }

  @Test
  public void ifLeftNotPresentOtherGet() {
    final Supplier<IllegalStateException> other = () -> new IllegalStateException("other");
    sut = Either.empty();
    final IllegalStateException actual = sut.ifLeftNotPresentGet(other);
    assertEquals(other, actual);
  }

  @Test
  public void ifLeftNotPresentOtherGetWithNullSupplierThrowsNullPointerException() {
    final Supplier<IllegalStateException> other = null;
    sut = Either.empty();
    exception.expect(NullPointerException.class);
    sut.ifLeftNotPresentGet(other);
  }

  @Test
  public void ifLeftPresentNotOther() {
    final IllegalStateException other = new IllegalStateException("other");
    sut = Either.ofLeft(left);
    final IllegalStateException actual = sut.ifLeftNotPresent(other);
    assertEquals(left, actual);
  }

  @Test
  public void ifLeftPresentNotOtherGet() {
    final Supplier<IllegalStateException> other = () -> new IllegalStateException("other");
    sut = Either.ofLeft(left);
    final IllegalStateException actual = sut.ifLeftNotPresentGet(other);
    assertEquals(left, actual);
  }

  @Test
  public void ifRightNotPresentOther() {
    final String other = "other";
    sut = Either.empty();
    final String actual = sut.ifRightNotPresent(other);
    assertEquals(other, actual);
  }

  @Test
  public void ifRightNotPresentOtherGet() {
    final Supplier<String> other = () -> "other";
    sut = Either.empty();
    final String actual = sut.ifRightNotPresentGet(other);
    assertEquals(other, actual);
  }

  @Test
  public void ifRightNotPresentOtherGetWithNullSupplierThrowsNullPointerException() {
    final Supplier<String> other = null;
    sut = Either.empty();
    exception.expect(NullPointerException.class);
    sut.ifRightNotPresentGet(other);
  }

  @Test
  public void ifRightPresentNotOther() {
    final String other = "other";
    sut = Either.ofRight(right);
    final String actual = sut.ifRightNotPresent(other);
    assertEquals(right, actual);
  }

  @Test
  public void ifRightPresentNotOtherGet() {
    final Supplier<String> other = () -> "other";
    sut = Either.ofRight(right);
    final String actual = sut.ifRightNotPresentGet(other);
    assertEquals(right, actual);
  }

  /**
   * Initializes test.
   */
  @Before
  public void init() {
    left = new IllegalStateException();
    right = "right value";
    consumerCheck = mock(ConsumerCheck.class);
  }

  @Test
  public void isEmptyOnEmpty() {
    sut = Either.empty();
    assertTrue(sut.isEmpty());
  }

  @Test
  public void leftEqualEitherWithSameLeftValue() {
    sut = Either.ofLeft(left);
    assertTrue(sut.equals(Either.ofLeft(left)));
  }

  @Test
  public void leftEqualItSelf() {
    sut = Either.ofLeft(left);
    assertTrue(sut.equals(sut));
  }

  @Test
  public void leftEqualsDifferentLeftWorks() {
    sut = Either.ofLeft(left);
    assertFalse(sut.equals(Either.ofLeft(new IllegalStateException("different"))));
  }

  @Test
  public void leftEqualsWithNullWorks() {
    sut = Either.ofLeft(left);
    assertFalse(sut.equals(null));
  }

  @Test
  public void leftGivesLeftPresentTrue() {
    sut = Either.ofLeft(left);
    assertTrue(sut.isLeftPresent());
  }

  @Test
  public void leftGivesRightPresentFalse() {
    sut = Either.ofLeft(left);
    assertFalse(sut.isRightPresent());
  }

  @Test
  public void leftIfLeftPresentWithNullConsumerThrowsNullPointerException() {
    sut = Either.ofLeft(left);
    exception.expect(NullPointerException.class);
    sut.ifLeftPresent(null);
  }

  @Test
  public void leftNotEqualEmpty() {
    sut = Either.ofLeft(left);
    assertFalse(sut.equals(Either.empty()));
  }

  @Test
  public void leftNotEqualRight() {
    sut = Either.ofLeft(left);
    assertFalse(sut.equals(Either.ofRight(right)));
  }

  @Test
  public void leftWithIfLeftIsConsumed() {
    sut = Either.ofLeft(left);
    sut.ifLeftPresent(consumerCheck::leftConsumer);
    verify(consumerCheck, times(1)).leftConsumer(left);
  }

  @Test
  public void leftWithIfRightIsNotConsumed() {
    sut = Either.ofLeft(left);
    sut.ifRightPresent(consumerCheck::rightConsumer);
    verify(consumerCheck, times(0)).rightConsumer(any());
  }

  @Test
  public void mapLeftLeftGivesResult() {
    sut = Either.ofLeft(left);
    final Optional<? extends IllegalStateException> result = sut.mapLeft(EitherTest::identity);
    assertTrue(result.isPresent());
    assertEquals(result.get(), left);
  }

  @Test
  public void mapLeftWithemptyGivesEmpty() {
    sut = Either.empty();
    final Optional<? extends IllegalStateException> result = sut.mapLeft(EitherTest::identity);
    assertFalse(result.isPresent());
  }

  @Test
  public void mapLeftWithLeftAndNullPredicateThrowsNullPointerException() {
    sut = Either.ofLeft(left);
    exception.expect(NullPointerException.class);
    sut.mapLeft(null);
  }

  @Test
  public void mapLeftWithRightGivesEmpty() {
    sut = Either.ofRight(right);
    final Optional<? extends IllegalStateException> result = sut.mapLeft(EitherTest::identity);
    assertFalse(result.isPresent());
  }

  @Test
  public void mapRightWithEmptyGivesEmpty() {
    sut = Either.empty();
    final Optional<? extends String> result = sut.mapRight(EitherTest::identity);
    assertFalse(result.isPresent());
  }

  @Test
  public void mapRightWithLeftGivesEmpty() {
    sut = Either.ofLeft(left);
    final Optional<? extends String> result = sut.mapRight(EitherTest::identity);
    assertFalse(result.isPresent());
  }

  @Test
  public void mapRightWithRightAndNullPredicateThrowsNullPointerException() {
    sut = Either.ofRight(right);
    exception.expect(NullPointerException.class);
    sut.mapRight(null);
  }

  @Test
  public void mapRightWithRightGivesResult() {
    sut = Either.ofRight(right);
    final Optional<? extends String> result = sut.mapRight(EitherTest::identity);
    assertTrue(result.isPresent());
    assertEquals(result.get(), right);
  }

  @Test
  public void NotisEmptyOnLeft() {
    sut = Either.ofLeft(left);
    assertFalse(sut.isEmpty());
  }

  @Test
  public void NotisEmptyOnRight() {
    sut = Either.ofRight(right);
    assertFalse(sut.isEmpty());
  }

  @Test
  public void ofLeftWithNullThrowsNullPointerException() {
    exception.expect(NullPointerException.class);
    sut = Either.ofLeft(null);
  }

  @Test
  public void ofNullableLeftWithNullGivesEmpty() {
    sut = Either.ofNullableLeft(null);
    assertTrue(sut.isEmpty());
  }

  @Test
  public void ofNullableRightWithNullGivesEmpty() {
    sut = Either.ofNullableRight(null);
    assertTrue(sut.isEmpty());
  }

  @Test
  public void ofRighWithNullThrowsNullPointerException() {
    exception.expect(NullPointerException.class);
    sut = Either.ofRight(null);
  }

  @Test
  public void rightEqualEitherWithSameRightValue() {
    sut = Either.ofRight(right);
    assertTrue(sut.equals(Either.ofRight(right)));
  }

  @Test
  public void rightEqualItSelf() {
    sut = Either.ofRight(right);
    assertTrue(sut.equals(sut));
  }

  @Test
  public void rightEqualsDifferentRightWorks() {
    sut = Either.ofRight(right);
    assertFalse(sut.equals(Either.ofRight("different")));
  }

  @SuppressWarnings("unlikely-arg-type")
  @Test
  public void rightEqualsSomethingDifferentWorks() {
    sut = Either.ofRight(right);
    assertFalse(sut.equals("different"));
  }

  @Test
  public void rightEqualsWithNullWorks() {
    sut = Either.ofRight(right);
    assertFalse(sut.equals(null));
  }

  @Test
  public void rightGivesLeftPresentFalse() {
    sut = Either.ofRight(right);
    assertFalse(sut.isLeftPresent());
  }

  @Test
  public void rightGivesRightPresentTrue() {
    sut = Either.ofRight(right);
    assertTrue(sut.isRightPresent());
  }

  @Test
  public void rightIfRightPresentWithNullConsumerThrowsNullPointerException() {
    sut = Either.ofRight(right);
    exception.expect(NullPointerException.class);
    sut.ifRightPresent(null);
  }

  @Test
  public void rightNotEqualEmpty() {
    sut = Either.ofRight(right);
    assertFalse(sut.equals(Either.empty()));
  }

  @Test
  public void rightNotEqualLeft() {
    sut = Either.ofRight(right);
    assertFalse(sut.equals(Either.ofLeft(left)));
  }

  @Test
  public void rightWithIfLeftIsNotConsumed() {
    sut = Either.ofRight(right);
    sut.ifLeftPresent(consumerCheck::leftConsumer);
    verify(consumerCheck, times(0)).leftConsumer(any());
  }

  @Test
  public void rightWithIfRightIsConsumed() {
    sut = Either.ofRight(right);
    sut.ifRightPresent(consumerCheck::rightConsumer);
    verify(consumerCheck, times(1)).rightConsumer(right);
  }

  @Test
  public void swapEmptyIsEmpty() {
    sut = Either.empty();
    assertEquals(sut, sut.swap());
  }

  @Test
  public void swapLeftGivesIsLeftPresentFalse() {
    sut = Either.ofLeft(left);
    assertFalse(sut.swap().isLeftPresent());
  }

  @Test
  public void swapLeftGivesLeftOngetRight() {
    sut = Either.ofLeft(left);
    assertEquals(left, sut.swap().getRight());
  }

  @Test
  public void swapRightGivesRightOngetLeft() {
    sut = Either.ofRight(right);
    assertEquals(right, sut.swap().getLeft());
  }

  @Test
  public void swapRightGivesRightPresentFalse() {
    sut = Either.ofRight(right);
    assertFalse(sut.swap().isRightPresent());
  }

  @Test
  public void toStringOnEmptyEitherWorks() {
    sut = Either.empty();
    assertTrue(sut.toString().length() > 0);
  }
}
