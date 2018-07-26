import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Test class for NineDigitPerfectSquare
 *
 * @author
 *
 *	TODO: Implement tests to cover the functionality provided by your methods.
 *
 */

public class NineDigitPerfectSquareTest {

	@Test
	public void testConstructor() {
		NineDigitPerfectSquare tmp = new NineDigitPerfectSquare();
		assertNotNull("Testing the constructor of NineDigitPerfectSquare", tmp);
	}

	/**
	 * Test method for the containsAllDigitsOnce method
	 */
	@Test
	public void testContainsAllDigitsOnce() {
		NineDigitPerfectSquare ndps = new NineDigitPerfectSquare();
		assertEquals("Testing containsAllDigitsOnce with 123456789, expected true", true, ndps.containsAllDigitsOnce(123456789) );
		assertEquals("Testing containsAllDigitsOnce with 987654321, expected true", true, ndps.containsAllDigitsOnce(987654321) );
		assertEquals("Testing containsAllDigitsOnce with 432198765, expected true", true, ndps.containsAllDigitsOnce(432198765) );
		assertEquals("Testing containsAllDigitsOnce with 111111111, expected false", false, ndps.containsAllDigitsOnce(111111111) );
		assertEquals("Testing containsAllDigitsOnce with 222222222, expected false", false, ndps.containsAllDigitsOnce(222222222) );
		
	}

	@Test
	public void testCountNineDigitPerfectSquares(){
		NineDigitPerfectSquare ndps = new NineDigitPerfectSquare();
		assertEquals("Testing countNineDigitPerfectSquares", 30, ndps.countNineDigitPerfectSquares());
	}
//
	@Test 
	public void perfectSquaresBetween(){
		NineDigitPerfectSquare ndps = new NineDigitPerfectSquare();
		int low = 0;
		int high = 20;
		int[] array= {1,4,9,16};
		assertArrayEquals("Testing countNineDigitPerfectSquares", array,ndps.perfectSquaresBetween(low,high));
		low = 100;
		high = 200;
		int[] array2= {100,121,144,169, 196};
		assertArrayEquals("Testing countNineDigitPerfectSquares", array2,ndps.perfectSquaresBetween(low,high));
		low = 10000;
		high = 20000;
		int[] array3={10000,10201,10404,10609,10816,11025,11236,11449,11664,11881,12100,12321,12544,12769,12996,13225,13456,13689,13924,14161,14400,14641,14884,15129,15376,15625,15876,16129,16384,16641,16900,17161,17424,17689,17956,18225,18496,18769,19044,19321,19600,19881};
		assertArrayEquals("Testing countNineDigitPerfectSquares", array3,ndps.perfectSquaresBetween(low,high));
	}
	@Test
	public void testGetNineDigitPerfectSquares(){
		NineDigitPerfectSquare ndps = new NineDigitPerfectSquare();
		ndps.countNineDigitPerfectSquares();
		int[] actual = ndps.getNineDigitPerfectSquares();
		
		Arrays.sort(actual);
		int[] expected = new int[] { 139854276, 152843769, 157326849,
				215384976, 245893761, 254817369, 326597184, 361874529,
				375468129, 382945761, 385297641, 412739856, 523814769,
				529874361, 537219684, 549386721, 587432169, 589324176,
				597362481, 615387249, 627953481, 653927184, 672935481,
				697435281, 714653289, 735982641, 743816529, 842973156,
				847159236, 923187456 };
		Arrays.sort(expected);
		int[] a =					 {139854276,152843769,157326849,
				215384976, 245893761, 254817369, 326597184, 361874529,
				375468129, 382945761, 385297641, 412739856, 523814769,
				529874361, 537219684, 549386721, 587432169, 589324176,
				597362481, 615387249, 627953481, 653927184, 672935481,
				697435281, 714653289, 735982641, 743816529, 842973156,
				847159236, 923187456 };
		assertArrayEquals("Testing getNineDigitPerfectSquares", expected, actual);

	}
}
