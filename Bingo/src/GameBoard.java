import java.util.*;
public class GameBoard {
	private int[] numberList = new int[75];
	private int range = 0;
	Random gen = new Random();
	public GameBoard(){
		for(int i = 0; i < numberList.length; i++){
			numberList[i] = i+1;
		}
	}
	public int nextNum(){
		int index = gen.nextInt(numberList.length-range) + range;
		int num = numberList[index];
		numberList[index] = 0;
		Arrays.sort(numberList);
		range++;
		return num;
	}
	
}