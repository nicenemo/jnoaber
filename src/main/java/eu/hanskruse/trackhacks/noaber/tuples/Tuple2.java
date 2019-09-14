package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 2 elements.
 */
public interface Tuple2 extends Tuple {

    @Override
    default int size() {
      return 2;
    }
}