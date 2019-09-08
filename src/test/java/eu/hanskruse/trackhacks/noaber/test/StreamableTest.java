package eu.hanskruse.trackhacks.noaber.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import eu.hanskruse.trackhacks.noaber.Streamable;
import eu.hanskruse.trackhacks.noaber.WithNoaber;

public class StreamableTest implements WithNoaber {

  public Streamable<String> names;
  public Streamable<String> postalCodes;
  public Streamable<Integer> houseNumbers;

  /**
   * Initializes the tests
   */
  @Before
  public void initialize() {
    names = Arrays.asList("Maria", "Anna", "Katie", "Judy", "Tim", "Jake", "William")::stream;
    postalCodes = Arrays.asList("3122NH", "7577AM", "7419CN")::stream;
    houseNumbers = Arrays.asList(3, 14, 159, 26, 5, 35, 89, 79, 323, 84, 62)::stream;
  }

  @Test
  public void testWrittenOutForComprehension() {
    final int numberOfNames = names.stream().toArray().length;
    final int numberOfPostalCodes = postalCodes.stream().toArray().length;
    final int numberOfHouseNumbers = houseNumbers.stream().toArray().length;

    final int expectedNumberOfCombinations = numberOfNames * numberOfPostalCodes * numberOfHouseNumbers;

    Streamable<String> combinations = //
        names.flatMap(name -> //
        postalCodes.flatMap(postalCode -> //
        houseNumbers.map(houseNumber -> String.format("%s %s %s", name, postalCode, houseNumber))));

    final int actualNumberOfCombinations = combinations.stream().toArray().length;

    assertEquals(expectedNumberOfCombinations, actualNumberOfCombinations);

    final String s = combinations.stream().collect(Collectors.joining(",\n"));
    System.out.println(s);
  }
  
}