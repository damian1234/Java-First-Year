import java.util.Arrays;

/**
 * CS2010 (Hilary Term) - Assignment 1
 *
 * Nine Digit Perfect Square
 *
 * A natural number, p, is a perfect square if for some natural number k, k^2=p.
 * For example, 16 is a perfect square, as 4^2=16. The number 20 is not a
 * perfect square as there is no natural number k such that k^2=20.
 *
 * Problem: Develop an algorithm that will find all nine-digit perfect squares
 * that use all nine digits exactly once. For example, 139,854,276 is a solution
 * (the first) as 11,826^2=139,854,276.
 *
 * 1) Fill in the implementation of the methods described in this file.
 *
 * 2) Test your implementation by developing suitable test suite in the
 * NineDigitPerfectSquareTest JUnit test case.
 *
 * @author:
 *
 */

public class NineDigitPerfectSquare {
	int square;
	int odd;
	int root;
	int[] squares;
	public NineDigitPerfectSquare(){
		square =1;
		odd =1;
		root=0;
	}
	/**
	 * A method to return an array containing all squeres between low and high
	 *
	 * @param low: lowest perfect square
	 * @param high: largest perfect square
	 *
	 * @return an array containing all the perfect squares between low and high
	 */
	public int[] perfectSquaresBetween(int low, int high){
		squares = new int[0];
		if(low > high){
			return null;
		}
		if(low <=0){
			low = 1;
		}
		int[] copy = squares;
		int i =1;	
		root = floor_sqrt(low);
		while(square<= high){
			squares = new int[i];
			squares = copy(copy , squares);
			squares[i-1] = square;
			copy = squares;
			i++;
			odd+=2;
			square+=odd;
		}
		return squares;
	}
	int[] copy(int[]x , int[] y){
		for(int i = 0; i <x.length; i++){
			y[i] = x[i];
		}
		return y;
	}
	int floor_sqrt(int x){
		square =1;
		odd =1;
		root=0;
		while( square < x ){
			root = root + 1;
			odd= odd + 2;
			square = square + odd;
		}
		return root;
	} // floor_sqrt
	public int countNineDigitPerfectSquares(){
		squares = getNineDigitPerfectSquares();
		return squares.length;
	}

	/**
	 * A method to determine if the number specified in parameter "number"
	 * contains all 9 digits exactly once.
	 *
	 * @param number
	 *            : A number to be tested
	 * @return whether the number contains all 9 digits exactly once
	 */
	public boolean containsAllDigitsOnce(int number){
		boolean[] check = new boolean[9];
		for(int i  = 0; i < check.length; i++){
			check[i] =false;
		}
		int div = 10;
		for(int i = 0; i < check.length; i++){
			int digit = number%div;
			number /=10;
			if(digit>0){
				if(check[digit-1]){
					return false;
				}
				check[digit-1] = true;
			}
			else{
				return false;
			}
		}
		return true;
	}


	/**
	 * A method to return an array containing all the squares discovered
	 *
	 * @return an array containing all of the perfect squares which
	 * contain all digits 1..9 exactly once.
	 */
	public int[] getNineDigitPerfectSquares() {
		int[] NineDigitSquares = perfectSquaresBetween(100000000, 999999999);
		squares = new int[0];
		int[] copy = squares;
		int j = 1;
		for( int i = 0; i < NineDigitSquares.length;i++){
			int num =NineDigitSquares[i];
			if(containsAllDigitsOnce(num)){
				squares = new int[j];
				squares = copy(copy , squares);
				squares[j-1] = num;
				copy = squares;
				j++;
			}
		}
		
		return squares;

	}
}
