package eu.hanskruse.trackhacks.noaber;

/**
 * Noaber library with all kinds of handy functionality.
 *
 * @author Hans Kruse
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface WithNoaber extends //
    WithCompose, //
    WithIdentity, //
    WithLogic, //
    WithMapReduce, //
    /* WithPatternMatching, */
    WithStats,
    WithStream {
  // facade that combines other interfaces into one interface to be extended
}
