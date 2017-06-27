package eu.hanskruse.trackhacks;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import eu.hanskruse.trackhacks.noaber.$;

//$ import Leipajuusta as a Cake pattern/Mixin
public class LeipajuustoTest implements $ {

	@Test
	public void matchAndKaasEven() {

		final int n = 42;
		@SuppressWarnings("unchecked")
		String actual = match(n, // 
				kaas(OddEven::odd, n1 -> "Odd"), //
				kaas(OddEven::even, n1 -> "Even")//
				);
		assertEquals("Even", actual);
	}
		
	@Test
	public void matchAndKaasOdd() {

		final int n = 13;
		@SuppressWarnings("unchecked")
		String actual = match(n, // 
				kaas(OddEven::odd, n1 -> "Odd"), //
				kaas(OddEven::even, n1 -> "Even")//
				);
		assertEquals("Odd", actual);
	}

	@Test
	public void matchAndKaasOverload() {

		final Planet n = Planet.Pluto;
		@SuppressWarnings("unchecked")
		 int actual= match(n, // 
				kaas(SolarSystem::Mercurius, n1 -> n1.length()), //
				kaas(SolarSystem::Pluto, n1 -> 42),// evaluation should stop here
				kaas(SolarSystem::Pluto, n1 -> 41),//
				kaas(SolarSystem::Earth, n1 -> 0),//
				kaas(SolarSystem::Saturn, n1 -> 0)//
				);
		assertEquals(42, actual);
	}
}
