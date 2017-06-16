package eu.hanskruse.trackhacks;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import eu.hanskruse.trackhacks.noaber.$;


public class LeipajuustoTest implements $ {

	
	@Test
	public void matchtest() {

		final int n = 42;
		@SuppressWarnings("unchecked")
		String actual = match(n, // 
				kaas(OddEven::odd, n1 -> "Odd"), //
				kaas(OddEven::even, n1 -> "Even")//
				);
		assertEquals("Even", actual);
	}
}
