package eu.hanskruse.trackhacks.noaber;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Represents a value of one of two possible types. (a disjoint union.)
 * Instances of {@code Either} are either an instance of {@code left} or {@code right}.
 * This implementation of {@code Either} also allows for an empty value, where neither {@code left} or @code{right} are set.
 * A common use of Either is as an alternative to exception handling. Convention in other languages,
 * such as Scala, is that left is used for the exception and right for the success.
 *
 * @author kruse@hanskruse.eu
 *
 * @param <E>
 *          {code left} type parameter, typically used for errors.
 * @param <T>
 *          {@code right} type parameter, typically used for the value if there is no error.
 */
public final class Either<E, T> {

  /*
   * Just One empty is enough.
   */
  private static final Either<?, ?> EMPTY = new Either<>(null, null);

  /**
   * Creates an empty {@code Either}.
   *
   * @param <E1>
   *          {@code left} type parameter
   * @param <T1>
   *          {@code right} type parameter
   * @return Empty Either.
   */
  public static <E1, T1> Either<E1, T1> empty() {
    @SuppressWarnings("unchecked")
    final Either<E1, T1> either = (Either<E1, T1>) EMPTY;
    return either;
  }

  /**
   * Creates an {@code Either} with the {@code left} value set. The {@code left} value may not be null.
   *
   * @param <E1>
   *          {@code left} type parameter
   * @param <T1>
   *          {@code right} type parameter
   * @param left
   *          left value
   * @return {@code Either} with left value set
   * @throws NullPointerException
   *           if left is null
   */
  public static <E1, T1> Either<E1, T1> ofLeft(final E1 left) {
    if (null == left) {
      throw new NullPointerException("Either.ofLeft: Left should not be null.");
    }
    return new Either<>(left, null);
  }

  /**
   * Creates an {@code Either} with the {@code left} value set.The {@code left} value may be null.
   *
   * @param <E1>
   *          {@code left} type parameter.
   * @param <T1>
   *          {@code right} type parameter.
   * @param left
   *          {@code left} value
   * @return {@code Either} with {@code left} value set
   */
  public static <E1, T1> Either<E1, T1> ofNullableLeft(final E1 left) {
    if (null == left) {
      return empty();
    }
    return new Either<>(left, null);
  }

  /**
   * Creates an {@code Either} with the right value set. Right may be null.
   *
   * @param <E1>
   *          {@code left} type parameter
   * @param <T1>
   *          {@code right} type parameter
   * @param right
   *          {@code right} value
   * @return {@code Either} with {@code right} value set
   */
  public static <E1, T1> Either<E1, T1> ofNullableRight(final T1 right) {
    if (null == right) {
      return empty();
    }
    return new Either<>(null, right);
  }

  /**
   * Creates an {@code Either} with the right value set. The {@code right} value may not be null.
   *
   * @param <E1>
   *          {@code left} type parameter
   * @param <T1>
   *          {@code right} type parameter
   * @param right
   *          right value
   * @return {@code Either} with {@code right} value set
   * @throws NullPointerException
   *           if {@code right} is null
   */
  public static <E1, T1> Either<E1, T1> ofRight(final T1 right) {
    if (null == right) {
      throw new NullPointerException("Either.ofRight: Right should not be null.");
    }
    return new Either<>(null, right);
  }

  /* left value. */
  private final E left;

  /* right value. */
  private final T right;

  /**
   * Creates an {@code Either} instance.
   *
   * @param left {@code left} value
   * @param right {@code right} value
   */
  private Either(final E left, final T right) {
    this.left = left;
    this.right = right;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    // Best we can do because of type erasure in Java.
    @SuppressWarnings("rawtypes")
    final Either other = (Either) obj;
    if (left == null) {
      if (other.left != null) {
        return false;
      }
    } else if (!left.equals(other.left)) {
      return false;
    }
    if (right == null) {
      if (other.right != null) {
        return false;
      }
    } else if (!right.equals(other.right)) {
      return false;
    }
    return true;
  }

  /**
   * If a {@code left} value is present,
   * and the value matches the given predicate,
   * return an {@code Optional} describing the value,
   * otherwise return an {@code Optional.empty}.
   *
   * @param predicate
   *          {@code Predicate} to apply to the {@code left} value, if present
   * @return an {@code Optional} describing filtered {@code left} value,
   *         if a {@code left} value is present and the {@code left} value matches the given predicate,
   *         otherwise an empty Optional
   * @throws NullPointerException
   *           if the predicate is null throw a {@code NullPointerException}
   */
  public Optional<E> filterLeft(final Predicate<? super E> predicate) {
    if (null == predicate) {
      throw new NullPointerException("Either.filterLeft: Predicate should not be null");
    }
    if (!isLeftPresent()) {
      return Optional.empty();
    }
    if (!predicate.test(left)) {
      return Optional.empty();
    }
    return Optional.of(left);
  }

  /**
  * If a {@code right} value is present,
   * and the value matches the given predicate,
   * return an {@code Optional} describing the value,
   * otherwise return an {@code Optional.empty}.
   *
   * @param predicate
   *          to apply to the {@code right} value, if present
   * @return an {@code Optional} describing filtered {@code right} value,
   *         if a {@code right} value is present and the {@code right} value matches the given predicate,
   *         otherwise an empty Optional
   * @throws NullPointerException
   *           if the predicate is null throw a {@code NullPointerException}
   */
  public Optional<T> filterRight(final Predicate<? super T> predicate) {
    if (null == predicate) {
      throw new NullPointerException("Either.filterRight: Predicate should not be null");
    }
    if (!isRightPresent()) {
      return Optional.empty();
    }
    if (!predicate.test(right)) {
      return Optional.empty();
    }
    return Optional.of(right);
  }

  /**
   * Gets the {@code left} value.
   *
   * @return left {@code left} value
   * @throws NoSuchElementException
   *           a {@code NoSuchElementException} is thrown when {@code left} is not present
   */
  public E getLeft() {
    if (!isLeftPresent()) {
      throw new NoSuchElementException("Either.getLeft: Left is not present.");
    }
    return left;
  }

  /**
   * Gets the right value.
   *
   * @return right  {@code right} value
   * @throws NoSuchElementException
   *           a {@code NoSuchElementException} is thrown when {@code right} is not present
   */
  public T getRight() {
    if (!isRightPresent()) {
      throw new NoSuchElementException("Either.getRight: right is not present.");
    }
    return right;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (left == null ? 0 : left.hashCode());
    result = prime * result + (right == null ? 0 : right.hashCode());
    return result;
  }

  /**
   * Returns provided {@code other} value if {@code left} is not present.
   *
   * @param other
   *          value to return if {@code left} is not present
   * @return left if {@code left} is present else other
   */
  public E ifLeftNotPresent(final E other) {
    if (!isLeftPresent()) {
      return other;
    }
    return left;
  }

  /**
   * Returns value provided by a {@code Provider} if {@code left} is not present.
   *
   * @param other
   *          provider to provide a value to return if {@code left} is not present
   * @return left if {@code left} is present else other
   * @throws NullPointerException
   *           throws a {@code NullPointerException} if other is null
   */
  public E ifLeftNotPresentGet(final Supplier<? extends E> other) {
    if (null == other) {
      throw new NullPointerException("Either.ifLeftNotPresentGet: other should not be null");
    }
    if (!isLeftPresent()) {
      return other.get();
    }
    return left;
  }

  /**
   * Throw a {@code Throwable} of type {@code X} provided by a {@code Provider} if {code left} is not present.
   *
   * @param other
   *          provider to provide exception to throw if {code left} is not present
   * @return left if {@code left} is present
   * @throws X
   *           {@code Throwable} that will be thrown if {code left} is not present
   * @throws NullPointerException
   *          throws a {@code NullPointerException} if other is null
   */
  public <X extends Throwable> E ifLeftNotPresentThrow(final Supplier<? extends X> other) throws X {
    if (null == other) {
      throw new NullPointerException("Either.ifLeftNotPresentThrow: other should not be null");
    }
    if (!isLeftPresent()) {
      throw other.get();
    }
    return left;
  }

  /**
   * If {code left} has a value apply the {@code Consumer} to the {code left} value.
   *
   * @param consumer
   *          {@code left} to apply if {@code left} is present
   * @throws NullPointerException
   *          throws a {@code NullPointerException} if {@code consumer} is null
   */
  public void ifLeftPresent(final Consumer<? super E> consumer) {
    if (null == consumer) {
      throw new NullPointerException("Either.ifLeftPresent: consumer should not be null");
    }
    if (isLeftPresent()) {
      consumer.accept(left);
    }
  }

  /**
   * Returns provided {@code other} value if {@code right} is not present.
   *
   * @param other
   *          value to return if {@code right} is not present
   * @return left if {@code right} is present else other
   */
  public T ifRightNotPresent(final T other) {
    if (!isRightPresent()) {
      return other;
    }
    return right;
  }

  /**
   * Returns value provided by a {@code Provider} if {@code right} is not present.
   *
   * @param other
   *          provider to provide a value to return if {@code right} is not present
   * @return right if {@code right} is present else other
   * @throws NullPointerException
   *          throws a {@code NullPointerException} if other is null
   */
  public T ifRightNotPresentGet(final Supplier<? extends T> other) {
    if (null == other) {
      throw new NullPointerException("Either.ifRightNotPresentGet: other should not be null");
    }
    if (!isRightPresent()) {
      return other.get();
    }
    return right;
  }

  /**
   * Throw a {@code Throwable} of type {@code X} provided by a {@code Provider} if {code right} is not present.
   *
   * @param other
   *          provider to provide exception to throw if {code right} is not present
   * @return right if {@code right} is present
   * @throws X
   *           {@code Throwable} that will be thrown if {code right} is not present
  * @throws NullPointerException
   *          throws a {@code NullPointerException} if other is null
   */
  public <X extends Throwable> T ifRightNotPresentThrow(final Supplier<? extends X> other) throws X {
    if (null == other) {
      throw new NullPointerException("Either.ifRightNotPresentThrow: other should not be null");
    }
    if (!isRightPresent()) {
      throw other.get();
    }
    return right;
  }



  /**
   * If {code right} has a value apply the {@code Consumer} to the {code right} value.
   *
   * @param consumer
   *          {@code left} to apply if {@code right} is present
   * @throws NullPointerException
   *          throws a {@code NullPointerException} if {@code consumer} is null
   */
  public void ifRightPresent(final Consumer<? super T> consumer) {
    if (null == consumer) {
      throw new NullPointerException("Either.ifRightPresent: consumer should not be null");
    }
    if (isRightPresent()) {
      consumer.accept(right);
    }
  }

  /**
   * True if neither {@code left} or {@code right} are present.
   *
   * @return true if neither {@code left} or {@code right} are present
   */
  public boolean isEmpty() {
    return !isLeftPresent() && !isRightPresent();
  }

  /**
   * True if the {@code left} value is present.
   *
   * @return true if the {@code left} value is present
   */
  public boolean isLeftPresent() {
    return left != null;
  }

  /**
   * True if the {@code right} value is present.
   *
   * @return true if the {@code right} value is present
   */
  public boolean isRightPresent() {
    return right != null;
  }

  /**
   * If a {@code left} value is present, apply the provided mapping function to it,
   *  and if the result is non-null, return an Optional describing the result.
   *
   * @param <U>
   *          the type of the result of the mapping function
   * @param mapper
   *          a mapping function to apply to the {@code left} value,
   *           if present {@code left} value of this {@code Either}, if a
   *         {@code left} value is present, otherwise an empty {@code Optional}
    *          throws a {@code NullPointerException} if {@code mapper} is null
   */
  public <U> Optional<? extends U> mapLeft(final Function<? super E, ? extends U> mapper) {
    if (null == mapper) {
      throw new NullPointerException("Either.mapLeft: Mapper should not be null");
    }
    if (!isLeftPresent()) {
      return Optional.empty();
    }
    return Optional.ofNullable(mapper.apply(left));
  }

  /**
   * If a {@code right} value is present, apply the provided mapping function to it,
   *  and if the result is non-null, return an Optional describing the result.
   *
   * @param <U>
   *          the type of the result of the mapping function
   * @param mapper
   *          a mapping function to apply to the {@code right} value,
   *           if present {@code right} value of this {@code Either}, if a
   *         {@code right} value is present, otherwise an empty {@code Optional}
    *          throws a {@code NullPointerException} if {@code mapper} is null
   */
  public <U> Optional<? extends U> mapRight(final Function<? super T, ? extends U> mapper) {
    if (null == mapper) {
      throw new NullPointerException("Either.mapRight: Mapper should not be null");
    }
    if (!isRightPresent()) {
      return Optional.empty();
    }
    return Optional.ofNullable(mapper.apply(right));
  }

  /**
   * Gets a new {@code Either} with {@code left} and {@code right} swapped.
   *
   * @return Swapped {@code Either}
   */
  public Either<T, E> swap() {
    if (isEmpty()) {
      return empty();
    }
    return new Either<>(right, left);
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Either [left=" + left + ", right=" + right + "]";
  }
}
