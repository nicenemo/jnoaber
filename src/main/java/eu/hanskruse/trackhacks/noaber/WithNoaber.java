package eu.hanskruse.trackhacks.noaber;

/**
 * Noaber library with all kinds of handy functionality.
 *
 * @author Hans Kruse
 *
 */
public interface WithNoaber extends //
    WithCompose, //
    WithCurry, //
    WithIdentity, //
    WithLogic, //
    WithMapReduce, //
    WithPartialApplication, //
    WithPatternMatching,
    WithStats,
    WithStream {
  // facade that combines other interfaces into one interface to be extended
}
