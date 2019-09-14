package eu.hanskruse.trackhacks.noaber;


import eu.hanskruse.trackhacks.noaber.with.*;

/**
 * {@code WithNoaber} is an interface that you can implement to get all kinds of utility
 * functionality at your fingertips.
 * However since this is a Java interface the provided methods become part of your API.
 * It may be adviceable to delegate to the {@link eu.hanskruse.trackhacks.noaber.Noaber.$()} singleton implementation instead.
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
    WithPatternMatching,
    WithStats,
    WithStream,
    WithTuples {
  // nothing here
}
