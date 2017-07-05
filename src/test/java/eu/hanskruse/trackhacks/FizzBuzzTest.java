package eu.hanskruse.trackhacks;

import java.util.Optional;
import java.util.Random;
import org.junit.Test;

import eu.hanskruse.trackhacks.noaber.$;
import eu.hanskruse.trackhacks.testdata.FizzBuzz;

public class FizzBuzzTest implements $,FizzBuzz {
	
	@Test
	public void fizzBuzzExample(){
		new Random().ints().limit(100).mapToObj(n -> 
		
	    	match(n).with(
	    	 
	    	 kaas(this::fizzBuzz,"Fizz Buzz"),
	    	 kaas(this::fizz,"Fizz"),
	         kaas(this::buzz,"Buzz"),//
	         
	         orelse(Integer.toString(n))
	         
	        ))//
		
		
		.map(Optional::get)//
		.forEach(System.out::println);
	}
}

/*

   F# Style pattern matching is implemented in Noaber (... implements $).

   See https://github.com/nicenemo/jnoaber

*/