package eu.hanskruse.trackhacks.noaber;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Provides variable arguments variants of the Binary operations in java.Math.
 * 
 * @author hkruse
 *
 */
public interface VarArgMath {

	/**
	 * Calculates the average over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the average from
	 * @return the average
	 */
	public default double average(final double... items) {
		return doubleSummaryStatistics(items).getAverage();
	}

	/**
	 * Calculates the average over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the average from
	 * @return the average
	 */
	public default float average(final float... items) {
		return sum(items) / items.length;
	}

	/**
	 * Calculates the average over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the average from
	 * @return the average
	 */
	public default double average(final int... items) {
		return intSummaryStatistics(items).getAverage();
	}

	/**
	 * Calculates the average over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the average from
	 * @return the average
	 */
	public default double average(final long... items) {
		return longSummaryStatistics(items).getAverage();
	}

	/**
	 * Calculates the average over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the average from
	 * @return the average
	 */
	public default double average(final short... items) {
		return sum(items) / items.length;
	}

	/**
	 * Calculate the summary statistics on items.
	 * 
	 * @param items
	 *            the items to calculate the statistics on
	 * @return the summary statistics
	 */
	public default DoubleSummaryStatistics doubleSummaryStatistics(final double... items) {
		return stream(items).summaryStatistics();
	}

	/**
	 * Calculate the summary statistics on items.
	 * 
	 * @param items
	 *            the items to calculate the statistics on
	 * @return the summary statistics
	 */
	public default IntSummaryStatistics intSummaryStatistics(final int... items) {
		return stream(items).summaryStatistics();
	}

	/**
	 * Calculate the summary statistics on items.
	 * 
	 * @param items
	 *            the items to calculate the statistics on
	 * @return the summary statistics
	 */
	public default LongSummaryStatistics longSummaryStatistics(final long... items) {
		return stream(items).summaryStatistics();
	}

	/**
	 * Calculates the maximum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the maximum from
	 * @return the maximum
	 */
	public default double max(final double... items) {
		return doubleSummaryStatistics(items).getMax();
	}

	/**
	 * Calculates the maximum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the maximum from
	 * @return the maximum
	 */
	public default float max(final float... items) {
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
	 *            the items to calculate the maximum from
	 * @return the maximum
	 */
	public default int max(final int... items) {
		return intSummaryStatistics(items).getMax();
	}

	/**
	 * Calculates the maximum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the maximum from
	 * @return the maximum
	 */
	public default long max(final long... items) {
		return longSummaryStatistics(items).getMax();
	}

	/**
	 * Calculates the maximum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the maximum from
	 * @return the maximum
	 */
	public default short max(final short... items) {
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
	 *            the items to calculate the minimum from
	 * @return the maximum
	 */
	public default double min(final double... items) {
		return doubleSummaryStatistics(items).getMin();
	}

	/**
	 * Calculates the minimum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the minimum from
	 * @return the maximum
	 */
	public default float min(final float... items) {
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
	 *            the items to calculate the minimum from
	 * @return the maximum
	 */
	public default int min(final int... items) {
		return intSummaryStatistics(items).getMin();
	}

	/**
	 * Calculates the minimum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the minimum from
	 * @return the maximum
	 */
	public default long min(final long... items) {
		return longSummaryStatistics(items).getMin();
	}

	/**
	 * Calculats the minimum over a number of items.
	 * 
	 * @param items
	 *            the items to calculate the minumum from
	 * @return the minimum
	 */
	public default short min(final short... items) {
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
	 * Reduce a number of items.
	 * 
	 * @param accumulator
	 *            the reducing operator
	 * @param items
	 *            the items to be reduced
	 * @return the reduced value
	 */
	public default <T> T reduce(final BinaryOperator<T> accumulator, @SuppressWarnings("unchecked") final T... items) {
		Optional<T> result = stream(items).reduce(accumulator);
		if (result.isPresent()) {
			return result.get();
		}
		throw new IllegalStateException(
				String.format("reducing with binary operator %s failed", accumulator.getClass().getCanonicalName()));
	}

	/**
	 * Reduce a number of items.
	 * 
	 * @param identity
	 *            the identity, e.g. 0 for addition, 1 for multiplication.
	 * @param accumulator
	 *            the reducing operator
	 * @param items
	 *            the items to be reduced
	 * @return reduced value
	 */
	public default <T> T reduce(final T identity, final BinaryOperator<T> accumulator,
			@SuppressWarnings("unchecked") final T... items) {
		return stream(items).reduce(identity, accumulator);
	}

	/**
	 * Convert a varargs array to a stream.
	 * 
	 * @param items
	 *            items to convert
	 * @return the converted stream
	 */
	public default DoubleStream stream(final double... items) {
		return Arrays.stream(items);
	}

	/**
	 * Convert a varargs array to a stream.
	 * 
	 * @param items
	 *            items to convert
	 * @return the converted stream
	 */
	public default IntStream stream(final int... items) {
		return Arrays.stream(items);
	}

	/**
	 * Convert a varargs array to a stream.
	 * 
	 * @param items
	 *            items to convert
	 * @return the converted stream
	 */
	public default LongStream stream(final long... items) {
		return Arrays.stream(items);
	}

	/**
	 * Convert a varargs array to a stream.
	 * 
	 * @param items
	 *            items to convert
	 * @return the converted stream
	 */
	@SuppressWarnings("unchecked")
	public default <T> Stream<T> stream(final T... items) {
		return Arrays.stream(items);
	}

	/**
	 * Calculates the sum over a number of items.
	 * 
	 * @param items
	 *            the items to sum the minimum from
	 * @return the maximum
	 */
	public default double sum(final double... items) {
		return doubleSummaryStatistics(items).getSum();
	}

	/**
	 * Calculates the sum over a number of items.
	 * 
	 * @param items
	 *            the items to sum the minimum from
	 * @return the maximum
	 */
	public default float sum(final float... items) {
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
	 *            the items to sum
	 * @return the maximum
	 */
	public default long sum(final int... items) {
		return intSummaryStatistics(items).getSum();
	}

	/**
	 * Calculates the sum over a number of items.
	 * 
	 * @param items
	 *            the items to sum
	 * @return the maximum
	 */
	public default long sum(final long... items) {
		return longSummaryStatistics(items).getSum();
	}

	/**
	 * Calculates the sum over a number of items.
	 * 
	 * @param items
	 *            the items to sum
	 * @return the sum of the items
	 */
	public default long sum(final short... items) {
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
	 * Short circuit evaluated multiarg and
	 * 
	 * @param items
	 *            boolean arguments to and
	 * @return true if All boolean items are true, false if one item is false or
	 *         if there are no items or items is null
	 */
	public default boolean and(final boolean... items) {
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
	public default boolean or(final boolean... items) {
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
}
