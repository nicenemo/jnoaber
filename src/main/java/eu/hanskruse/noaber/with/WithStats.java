package eu.hanskruse.noaber.with;

import static eu.hanskruse.noaber.Noaber.noaber;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;

/**
 * Statistics functionality.
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 */
public interface WithStats {

  /**
   * Calculate the summary statistics on items.
   *
   * @param items
   *          the items to calculate the statistics on
   * @return the summary statistics
   */
  default LongSummaryStatistics longSummaryStatistics(final long... items) {
    return noaber().stream(items).summaryStatistics();
  }

  /**
   * Calculates the maximum over a number of items.
   *
   * @param items
   *          the items to calculate the maximum from
   * @return the maximum
   */
  default double max(final double... items) {
    return noaber().doubleSummaryStatistics(items).getMax();
  }

  /**
   * Calculates the maximum over a number of items.
   *
   * @param items
   *          the items to calculate the maximum from
   * @return the maximum
   */
  default float max(final float... items) {
    if (items == null || items.length == 0) {
      throw new IllegalArgumentException("items is null or empty");
    }
    if (items.length == 1) {
      return items[0];

    }

    float acc = items[0];
    final int maxIndex = items.length - 2;
    for (int i = 1; i < maxIndex; i++) {
      acc = Math.max(acc, items[i]);
    }

    return acc;
  }

  /**
   * Calculates the maximum over a number of items.
   *
   * @param items
   *          the items to calculate the maximum from
   * @return the maximum
   */
  default int max(final int... items) {
    return noaber().intSummaryStatistics(items).getMax();
  }

  /**
   * Calculates the maximum over a number of items.
   *
   * @param items
   *          the items to calculate the maximum from
   * @return the maximum
   */
  default long max(final long... items) {
    return longSummaryStatistics(items).getMax();
  }

  /**
   * Calculates the maximum over a number of items.
   *
   * @param items
   *          the items to calculate the maximum from
   * @return the maximum
   */
  default short max(final short... items) {
    if (items == null || items.length == 0) {
      throw new IllegalArgumentException("items is null or empty");
    }
    if (items.length == 1) {
      return items[0];

    }

    int acc = items[0];
    final int maxIndex = items.length - 2;
    for (int i = 1; i < maxIndex; i++) {
      acc = Math.max(acc, items[i]);
    }

    return (short) acc;
  }

  /**
   * Calculates the minimum over a number of items.
   *
   * @param items
   *          the items to calculate the minimum from
   * @return the maximum
   */
  default double min(final double... items) {
    return noaber().doubleSummaryStatistics(items).getMin();
  }

  /**
   * Calculates the minimum over a number of items.
   *
   * @param items
   *          the items to calculate the minimum from
   * @return the maximum
   */
  default float min(final float... items) {
    if (items == null || items.length == 0) {
      throw new IllegalArgumentException("items is null or empty");
    }
    if (items.length == 1) {
      return items[0];

    }

    float acc = items[0];
    final int maxIndex = items.length - 2;
    for (int i = 1; i < maxIndex; i++) {
      acc = Math.min(acc, items[i]);
    }

    return acc;
  }

  /**
   * Calculates the minimum over a number of items.
   *
   * @param items
   *          the items to calculate the minimum from
   * @return the maximum
   */
  default int min(final int... items) {
    return noaber().intSummaryStatistics(items).getMin();
  }

  /**
   * Calculates the minimum over a number of items.
   *
   * @param items
   *          the items to calculate the minimum from
   * @return the maximum
   */
  default long min(final long... items) {
    return longSummaryStatistics(items).getMin();
  }

  /**
   * Calculats the minimum over a number of items.
   *
   * @param items
   *          the items to calculate the minumum from
   * @return the minimum
   */
  default short min(final short... items) {
    if (items == null || items.length == 0) {
      throw new IllegalArgumentException("items is null or empty");
    }
    if (items.length == 1) {
      return items[0];

    }

    int acc = items[0];
    final int maxIndex = items.length - 2;
    for (int i = 1; i < maxIndex; i++) {
      acc = Math.min(acc, items[i]);
    }

    return (short) acc;
  }

  /**
   * Calculates the sum over a number of items.
   *
   * @param items
   *          the items to sum the minimum from
   * @return the maximum
   */
  default double sum(final double... items) {
    return noaber().doubleSummaryStatistics(items).getSum();
  }

  /**
   * Calculates the sum over a number of items.
   *
   * @param items
   *          the items to sum the minimum from
   * @return the maximum
   */
  default float sum(final float... items) {
    if (items == null || items.length == 0) {
      throw new IllegalArgumentException("items is null or empty");
    }
    if (items.length == 1) {
      return items[0];

    }

    float acc = items[0];
    final int maxIndex = items.length - 2;
    for (int i = 1; i < maxIndex; i++) {
      acc += items[i];
    }

    return acc;
  }

  /**
   * Calculates the sum over a number of items.
   *
   * @param items
   *          the items to sum
   * @return the maximum
   */
  default long sum(final int... items) {
    return noaber().intSummaryStatistics(items).getSum();
  }

  /**
   * Calculates the sum over a number of items.
   *
   * @param items
   *          the items to sum
   * @return the maximum
   */
  default long sum(final long... items) {
    return longSummaryStatistics(items).getSum();
  }

  /**
   * Calculates the sum over a number of items.
   *
   * @param items
   *          the items to sum
   * @return the sum of the items
   */
  default long sum(final short... items) {
    if (items == null || items.length == 0) {
      throw new IllegalArgumentException("items is null or empty");
    }
    if (items.length == 1) {
      return items[0];

    }

    long acc = items[0];
    final int maxIndex = items.length - 2;
    for (int i = 1; i < maxIndex; i++) {
      acc += items[i];
    }

    return acc;
  }

  /**
   * Calculates the average over a number of items.
   *
   * @param items
   *          the items to calculate the average from
   * @return the average
   */
  default double average(final double... items) {
    return doubleSummaryStatistics(items).getAverage();
  }

  /**
   * Calculates the average over a number of items.
   *
   * @param items
   *          the items to calculate the average from
   * @return the average
   */
  default float average(final float... items) {
    return sum(items) / items.length;
  }

  /**
   * Calculates the average over a number of items.
   *
   * @param items
   *          the items to calculate the average from
   * @return the average
   */
  default double average(final int... items) {
    return intSummaryStatistics(items).getAverage();
  }

  /**
   * Calculates the average over a number of items.
   *
   * @param items
   *          the items to calculate the average from
   * @return the average
   */
  default double average(final long... items) {
    return longSummaryStatistics(items).getAverage();
  }

  /**
   * Calculates the average over a number of items.
   *
   * @param items
   *          the items to calculate the average from
   * @return the average
   */
  default double average(final short... items) {
    return sum(items) / items.length;
  }

  /**
   * Calculate the summary statistics on items.
   *
   * @param items
   *          the items to calculate the statistics on
   * @return the summary statistics
   */
  default DoubleSummaryStatistics doubleSummaryStatistics(final double... items) {
    return noaber().stream(items).summaryStatistics();
  }

  /**
   * Calculate the summary statistics on items.
   *
   * @param items
   *          the items to calculate the statistics on
   * @return the summary statistics
   */
  default IntSummaryStatistics intSummaryStatistics(final int... items) {
    return noaber().stream(items).summaryStatistics();
  }

}
