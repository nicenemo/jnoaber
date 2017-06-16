package eu.hanskruse.trackhacks;

import java.util.Optional;

/**
 * Sample 'predicates' for testing the kaas function overloads that results in optional values.
 * @author hans kruse 
 */
public class SolarSystem {
//TODO: add better documentation
	public static Optional<String> Mercurius(final Planet p){
		return p == Planet.Mercurius? Optional.of(p.toString()):Optional.empty();
	}
	
	public static Optional<String> Venus(final Planet p){
		return p == Planet.Venus? Optional.of(p.toString()):Optional.empty();
	}
	
	public static Optional<String> Earth(final Planet p){
		return p == Planet.Earth? Optional.of(p.toString()):Optional.empty();
	}
	
	public static Optional<String> Mars(final Planet p){
		return p == Planet.Mars? Optional.of(p.toString()):Optional.empty();
	}
	
	public static Optional<String> Jupiter(final Planet p){
		return p == Planet.Jupiter? Optional.of(p.toString()):Optional.empty();
	}
	
	public static Optional<String> Saturn(final Planet p){
		return p == Planet.Saturn? Optional.of(p.toString()):Optional.empty();
	}
	
	public static Optional<String> Uranus(final Planet p){
		return p == Planet.Uranus? Optional.of(p.toString()):Optional.empty();
	}
	
	public static Optional<String> Neptune(final Planet p){
		return p == Planet.Neptune? Optional.of(p.toString()):Optional.empty();
	}
	
	public static Optional<String> Pluto(final Planet p){
		return p == Planet.Pluto? Optional.of(p.toString()):Optional.empty();
	}
	
	
	
}
