package eu.hanskruse.trackhacks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;

import eu.hanskruse.trackhacks.noaber.$;
import eu.hanskruse.trackhacks.testdata.OddEven;
import eu.hanskruse.trackhacks.testdata.Planet;
import eu.hanskruse.trackhacks.testdata.SolarSystem;


public class MatchingTest implements $ {

	@Test
	public void matchAndKaasEven() {

		final int n = 42;
		Optional<String> actual = match(n).with( // 
				kaas(OddEven::odd, n1 -> "Odd"), //
				kaas(OddEven::even, n1 -> "Even"),//
				orelse("Strange")
				);
		assertEquals("Even", actual.get());
	}
		
	@Test
	public void matchAndKaasOdd() {

		final int n = 13;
		Optional<String> actual = match(n).with( // 
				kaas(OddEven::odd, n1 -> "Odd"), //
				kaas(OddEven::even, n1 -> "Even"),//
				orelse("Strange")
				);
		assertEquals("Odd", actual.get());
	}

	@Test
	public void matchAndKaasOverload() {

		final Planet n = Planet.Pluto;
		Optional<Integer> actual= match(n).with( // 
				kaas(SolarSystem::Mercurius, n1 -> n1.length()), //
				kaas(SolarSystem::Pluto, n1 -> 42),// evaluation should stop here
				kaas(SolarSystem::Pluto, n1 -> 41),//
				kaas(SolarSystem::Earth, n1 -> 0),//
				kaas(SolarSystem::Saturn, n1 -> 0),//
				orelse(-1)
				);
		assertEquals(42, actual.get().intValue());
	}
	
	@Test
	public void matchTypeWithEnum(){
	  final Planet n = Planet.Pluto;
	  Optional<String> actual =match(n).with(kaas(Planet.class,"It is a planet")); 
	  assertTrue(actual.isPresent());
	  assertEquals("It is a planet",actual.get());
	}
}
