package eu.hanskruse.trackhacks.noaber;

public interface WithPatternMatching {
  /**
   * Match captures the value to match against returning a CaseAcceptor.
   * @param value the value to capture
   * @return a CaseAcceptor.
   */
  public static <T>  CaseAcceptor<T> match(final T value){
      return new CaseAcceptor<>(value);
  }
  
  /**
   * Creates a pattern matcher to match with
   * @param cases cases to match with
   * @return a patter matcher to match the cases with
   */
  @SuppressWarnings("unchecked")
  public static <T,R> PatternMatcher<T,R> with(final Case<T, R>... cases){
      return new PatternMatcher<>(cases);
  }
}
