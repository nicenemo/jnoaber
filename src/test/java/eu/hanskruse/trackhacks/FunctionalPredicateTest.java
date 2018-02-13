package eu.hanskruse.trackhacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.hanskruse.trackhacks.noaber.FunctionalPredicate;
import static eu.hanskruse.trackhacks.noaber.WithLogic.asFunctionalPredicate;
import  eu.hanskruse.trackhacks.testdata.OddEven;
public class FunctionalPredicateTest  {
	
	
	@Test
	public void testFunctionalPredicateWithLambda(){
     FunctionalPredicate<Integer> fp= asFunctionalPredicate(x -> x%2 !=0);
     assertTrue(fp.apply(43).isPresent());
     assertFalse(fp.apply(42).isPresent());
	}
	
	@Test
	public void testFunctionalPredicateWithOdd(){
     FunctionalPredicate<Integer> fp= asFunctionalPredicate(OddEven::odd);
     assertTrue(fp.apply(43).isPresent());
     assertFalse(fp.apply(42).isPresent());
	}
	
	
	
	

}
