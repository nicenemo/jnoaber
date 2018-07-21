package eu.hanskruse.trackhacks.noaber;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Either implementation.
 *
 * @author kruse@hanskruse.eu
 *
 * @param <E>
 *          left field of Either, typically used for errors.
 * @param <T>
 *          right field for Either, typically used for the value if there is no error.
 */
public final class Either<E, T> {

  /*
   * Just One empty is enough.
   */
  private static final Either<?, ?> EMPTY = new Either<>(null, null);

  /**
   * Creates an empty Either.
   *
   * @param <E1>
   *          left type parameter.
   * @param <T1>
   *          right type parameter.
   * @return Empty Either.
   */
  public static <E1, T1> Either<E1, T1> empty() {
    @SuppressWarnings("unchecked")
    final Either<E1, T1> either = (Either<E1, T1>) EMPTY;
    return either;
  }

  /**
   * Creates an Either with the left value set. Left may not be null.
   *
   * @param <E1>
   *          left type parameter.
   * @param <T1>
   *          right type parameter.
   * @param left
   *          left value
   * @return Either with left value set
   * @throws NullPointerException
   *           if left is null
   */
  public static <E1, T1> Either<E1, T1> ofLeft(final E1 left) {
    if (null == left) {
      throw new NullPointerException("Left should not be null.");
    }
    return new Either<>(left, null);
  }

  /**
   * Creates an Either with the left value set. Left may be null.
   *
   * @param <E1>
   *          left type parameter.
   * @param <T1>
   *          right type parameter.
   * @param left
   *          left value
   * @return Either with left value set
   */
  public static <E1, T1> Either<E1, T1> ofNullableLeft(final E1 left) {
    if (null == left) {
      return empty();
    }
    return new Either<>(left, null);
  }

  /**
   * Creates an Either with the right value set. Right may be null.
   *
   * @param <E1>
   *          left type parameter.
   * @param <T1>
   *          right type parameter.
   * @param right
   *          right value
   * @return Either with right value set
   */
  public static <E1, T1> Either<E1, T1> ofNullableRight(final T1 right) {
    if (null == right) {
      return empty();
    }
    return new Either<>(null, right);
  }

  /**
   * Creates an Either with the right value set. Right may not be null.
   *
   * @param <E1>
   *          left type parameter.
   * @param <T1>
   *          right type parameter.
   * @param right
   *          right value
   * @return Either with right value set
   * @throws NullPointerException
   *           if right is null
   */
  public static <E1, T1> Either<E1, T1> ofRight(final T1 right) {
    if (null == right) {
      throw new NullPointerException("Right should not be null.");
    }
    return new Either<>(null, right);
  }

  /* left value. */
  private final E left;

  /* right value. */
  private final T right;

  /**
   * Creates an Either instance.
   *
   * @param left
   * @param right
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
   * If a left value is present,
   * and the value matches the given predicate,
   * return an Optional describing the value,
   * otherwise return an empty Optional.
   *
   * @param predicate
   *          to apply to the left value, if present
   * @return an Optional describing the value of this Optional
   *         if a left value is present and the left value matches the given predicate,
   *         otherwise an empty Optional
   * @throws NullPointerException
   *           if the predicate is null
   */
  public Optional<E> filterLeft(Predicate<? super E> predicate) {
    if (null == predicate) {
      throw new NullPointerException("Predicate should not be null");
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
   * If a right value is present,
   * and the value matches the given predicate,
   * return an Optional describing the value,
   * otherwise return an empty Optional.
   *
   * @param predicate
   *          to apply to the right value, if present
   * @return an Optional describing the value of this Optional
   *         if a right value is present and the right value matches the given predicate,
   *         otherwise an empty Optional
   * @throws NullPointerException
   *           if the predicate is null
   */
  public Optional<T> filterRight(Predicate<? super T> predicate) {
    if (null == predicate) {
      throw new NullPointerException("Predicate should not be null");
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
   * Gets the left value.
   *
   * @return left value
   */
  public E getLeft() {
    if (!isLeftPresent()) {
      throw new NoSuchElementException("Left is not present.");
    }
    return left;
  }

  /**
   * Gets the right value.
   *
   * @return right value
   */
  public T getRight() {
    if (!isRightPresent()) {
      throw new NoSuchElementException("right is not present.");
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
   * If left has a value apply the consumer to the left value.
   *
   * @param consumer
   *          consumer to apply
   */
  public void ifLeftPresent(Consumer<? super E> consumer) {
    if (null == consumer) {
      throw new NullPointerException("Either.ifLeftPresent: consumer should not be null");
    }
    if (isLeftPresent()) {
      consumer.accept(left);
    }
  }

  /**
   * If right has a value apply the consumer to the left value.
   *
   * @param consumer
   *          consumer to apply
   */
  public void ifRightPresent(Consumer<? super T> consumer) {
    if (null == consumer) {
      throw new NullPointerException("Either.ifRightPresent: consumer should not be null");
    }
    if (isRightPresent()) {
      consumer.accept(right);
    }
  }

  /**
   * True if neither left or right are present.
   *
   * @return true if neither eft or right are present
   */
  public boolean isEmpty() {
    return !isLeftPresent() && !isRightPresent();
  }

  /**
   * True if the left value exists.
   *
   * @return true if the left value exists
   */
  public boolean isLeftPresent() {
    return left != null;
  }

  /**
   * True if this right value exists.
   *
   * @return true if the right value exists
   */
  public boolean isRightPresent() {
    return right != null;
  }

  /**
   * If a left value is present, apply the provided mapping function to it, and if the result is non-null, return an
   * Optional describing the result.
   *
   * @param <U>
   *          he type of the result of the mapping function
   * @param mapper
   *          a mapping function to apply to the left value, if present
   * @return an Optional describing the result of applying a mapping function to the left value of this Either, if a
   *         left value is present, otherwise an empty Optional
   * @throws NullPointerException
   *           if the mapper is null
   */
  public <U> Optional<? extends U> mapLeft(Function<? super E, ? extends U> mapper) {
    if (null == mapper) {
      throw new NullPointerException("Mapper should not be null");
    }
    if (!isLeftPresent()) {
      return Optional.empty();
    }
    return Optional.ofNullable(mapper.apply(left));
  }

  /**
   * If a right value is present, apply the provided mapping function to it, and if the result is non-null, return an
   * Optional describing the result.
   *
   * @param <U>
   *          he type of the result of the mapping function
   * @param mapper
   *          a mapping function to apply to the right value, if present
   * @return an Optional describing the result of applying a mapping function to the right value of this Either, if a
   *         right value is present, otherwise an empty Optional
   * @throws NullPointerException
   *           if the mapper is null
   */
  public <U> Optional<? extends U> mapRight(Function<? super T, ? extends U> mapper) {
    if (null == mapper) {
      throw new NullPointerException("Mapper should not be null");
    }
    if (!isRightPresent()) {
      return Optional.empty();
    }
    return Optional.ofNullable(mapper.apply(right));
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
