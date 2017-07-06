package eu.hanskruse.trackhacks.noaber;

import java.util.Optional;

/**
 * CaseAcceptor captures the argument of the match function and provides a with
 * method that accepts case clauses to evaluate.
 * 
 * @author Hans Kruse
 *
 * @param <T>
 *            type of the argument.
 */
public final class CaseAcceptor<T> {
	private final T t;

	public CaseAcceptor(final T value) {
		this.t = value;
	}

	/**
	 * Evaluate a set of cases until one has a none Optional.Empty() result.
	 * Return that result.
	 * 
	 * @param cases
	 *            set of cases
	 * @return the first case that has a none Optional.empty result. If the list
	 *         is empty or null Optional.empty() will be returned.
	 */
	@SafeVarargs
	public final <R> Optional<R> with(final Case<T, R>... cases) {
		if (cases != null) {
			for (final Case<T, R> kaas : cases) {
				final Optional<R> r = kaas.apply(this.t);
				if (r.isPresent()) {
					return r;
				}
			}
		}
		return Optional.empty();
	}
}