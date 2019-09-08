package eu.hanskruse.trackhacks.noaber.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import eu.hanskruse.trackhacks.noaber.Streamable;
import eu.hanskruse.trackhacks.noaber.WithNoaber;

public class StreamableTest implements WithNoaber {

  private Streamable<String> names;
  private Streamable<String> postalCodes;
  private Streamable<Integer> houseNumbers;
  private int numberOfNames;
  private int numberOfPostalCodes;
  private int numberOfHouseNumbers;
  private int expectedNumberOfCombinations;

  /**
   * Initializes the tests
   */
  @Before
  public void initialize() {
    names = Arrays.asList("Maria", "Anna", "Katie", "Judy", "Tim", "Jake", "William")::stream;
    postalCodes = Arrays.asList("3122NH", "7577AM", "7419CN")::stream;
    houseNumbers = Arrays.asList(3, 14, 159, 26, 5, 35, 89, 79, 323, 84, 62)::stream;
    numberOfNames = names.stream().toArray().length;
    numberOfPostalCodes = postalCodes.stream().toArray().length;
    numberOfHouseNumbers = houseNumbers.stream().toArray().length;
    expectedNumberOfCombinations = numberOfNames * numberOfPostalCodes * numberOfHouseNumbers;
  }

  @Test
  public void testWrittenOutForComprehension() {
    Streamable<String> combinations = //
        names.flatMap(name -> //
        postalCodes.flatMap(postalCode -> //
        houseNumbers.map(houseNumber -> String.format("%s %s %s", name, postalCode, houseNumber))));

    final int actualNumberOfCombinations = combinations.stream().toArray().length;

    assertEquals(expectedNumberOfCombinations, actualNumberOfCombinations);

    final String s = combinations.stream().collect(Collectors.joining(",\n"));
    System.out.println(s);
  }
  
  @Test
  public void testForComprehension() {
    Streamable<String> combinations = this.comprehend(//
        names, //
        postalCodes, //
        houseNumbers, //
        (name, postalCode, houseNumber) -> String.format("%s %s %s", name, postalCode, houseNumber));
    
    final int actualNumberOfCombinations = combinations.stream().toArray().length;
    assertEquals(expectedNumberOfCombinations, actualNumberOfCombinations);

    final String s = combinations.stream().collect(Collectors.joining(",\n"));
    System.out.println(s);
  }
}