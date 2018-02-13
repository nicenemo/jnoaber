package eu.hanskruse.trackhacks.noaber;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface WithLogic {

  /**
   * Short circuit evaluated multiarg and
   * 
   * @param items
   *            boolean arguments to and
   * @return true if All boolean items are true, false if one item is false or
   *         if there are no items or items is null
   */
  public static boolean and(final boolean... items) {
      if (items == null || items.length == 0) {
          return false;
      }

      for (final boolean item : items) {
          if (!item) {
              return false;
          }
      }
      return true;
  }

  /**
   * Short circuit evaluated multiarg or
   * 
   * @param items
   *            boolean arguments to or
   * @return true if All boolean items are true, false if one item is false or
   *         if there are no items or items is null
   */
  public static boolean or(final boolean... items) {
      if (items == null || items.length == 0) {
          return false;
      }

      for (final boolean item : items) {
          if (item) {
              return true;
          }
      }
      return false;
  }
  
  /**
   * Short circuit evaluated multiarg or
   * 
   * @param items predicates
   *            boolean arguments to or
   * @return true if All boolean items are true, false if one item is false or
   *         if there are no items or items is null
   */
  @SuppressWarnings("unchecked")
  public static <T> Predicate<T> or(final Predicate<T>... items) {
      return (t) -> {
        if (items == null || items.length == 0) {
          return false;
        }

        for (final Predicate<T> item : items) {
          if (item.test(t)) {
              return true;
          }
        }
        return false;
      };
  }
  /**
   * Gets a predicate of a predicate on the supplied items
   * @param items the items to apply an predicate over with an or in short circuit fashion
   * @return a predicate of a predicate.
   */
  @SuppressWarnings("unchecked")
  public static <T> Predicate<Predicate<T>> or(final T... items){
      return predicate -> or(predicate,items);
  }
  
  /**
   * Applies a predicate of supplied items and or them in short circuit fashion.
   * @param predicate the predicate to apply to the supplied items
   * @param items the items to apply the predicate on
   * @return true on the first item that the predicates gives true on, else false.
   */
  @SuppressWarnings("unchecked")
  public static <T> boolean or(final Predicate<T> predicate,final T... items) {
            if (items == null || items.length == 0) {
                  return false;
            }
            for (final T item : items) {
                if (predicate.test(item)) {
                      return true;
                  }
            }
            return false;  
  }
  
  
  /**
   * Gets a predicate of a predicate on the supplied items
   * @param items the items to apply an predicate over with an or in short circuit fashion
   * @return a predicate of a predicate.
   */
  public static <T> Predicate<Predicate<T>> or(final Collection<T> items){
      return predicate -> or(predicate,items);
  }
  
  /**
   * Applies a predicate of supplied items and or them in short circuit fashion.
   * @param predicate the predicate to apply to the supplied items
   * @param items the items to apply the predicate on
   * @return true on the first item that the predicates gives true on, else false.
   */
  public static <T> boolean or(final Predicate<T> predicate,final Collection<T> items) {
            if (items == null || items.isEmpty()) {
                  return false;
            }
            for (final T item : items) {
                if (predicate.test(item)) {
                      return true;
                  }
            }
            return false;  
  }

  /**
   * Wrap a predicate into a function that
   * returns the optional value of the argument provided to the predicate 
   * if the predicate is true, else return Optional.empty().
   * @param p the predicate to wrap
   * @return the wrapped predicate
   */
  public static <T> FunctionalPredicate<T> asFunctionalPredicate(final Predicate<T> p){
      return (t) -> p.test(t) ? Optional.of(t) : Optional.empty();
  }
}
