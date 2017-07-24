package eu.hanskruse.trackhacks;
import  static eu.hanskruse.trackhacks.noaber.$.*;

import org.junit.Test;

import eu.hanskruse.trackhacks.noaber.FunctionalPredicate;
import  eu.hanskruse.trackhacks.testdata.OddEven;
import junit.framework.TestCase;
public class FunctionalPredicateTest extends TestCase {
	
	
	@SuppressWarnings("static-method")
	@Test
	public void testFunctionalPredicateWithLambda(){
     FunctionalPredicate<Integer> fp= asFunctionalPredicate(x -> x%2 !=0);
     assertTrue(fp.apply(43).isPresent());
     assertFalse(fp.apply(42).isPresent());
	}
	
	@SuppressWarnings("static-method")
	@Test
	public void testFunctionalPredicateWithOdd(){
     FunctionalPredicate<Integer> fp= asFunctionalPredicate(OddEven::odd);
     assertTrue(fp.apply(43).isPresent());
     assertFalse(fp.apply(42).isPresent());
	}
	
	
	
	

}
