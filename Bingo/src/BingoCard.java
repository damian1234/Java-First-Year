import java.lang.reflect.Array;
import java.util.*;

public class BingoCard {
	final int DIMENSIONS = 5;
	private int[] numbers = new int[75];
	int[][] cardNumbers = new int[DIMENSIONS][DIMENSIONS];
	public BingoCard(){
		for(int i = 0; i < DIMENSIONS;i++){
			for(int j = 0; j < DIMENSIONS*3; j++){
				numbers[(i*15)+(j)] = (i*15)+(j+1);

			}
		}
	}
	public void initCard(){
		for(int i = 0; i < DIMENSIONS;i++){
			Random gen = new Random();
			for(int j = 0; j < DIMENSIONS; j++){
				int num = (gen.nextInt(15));
				if(i ==2&&j==2){
					cardNumbers[j][i] = 0;
				}
				else{
					cardNumbers[j][i] = numbers[(i*15)+num];
					if(numbers[(i*15)+num]==0){
						j-=1;
					}
					numbers[(i*15)+num] = 0;
				}
			}
		}
	}
	public boolean checkMatch(int num){
		for(int i =0; i < DIMENSIONS; i++ ){
			for(int j = 0; j< DIMENSIONS; j++){
				if(this.cardNumbers[i][j]== num){
					return true;
				}
			}
		}
		return false;
	}
	public void match(int num){
		for(int i =0; i < DIMENSIONS; i++ ){
			for(int j = 0; j< DIMENSIONS; j++){
				if(this.cardNumbers[i][j]== num){
					this.cardNumbers[i][j] = 0;
				}
			}
		}
	}
	public boolean winner(){
		int winCount = 0;
		for(int i =0; i < DIMENSIONS; i++ ){
			for(int j = 0; j< DIMENSIONS; j++){
				if(cardNumbers[j][i] ==0){
					winCount +=1;
					if(winCount ==5){
						return true;
					}
				}
				else{
					winCount = 0;
					break;
				}
			}
		}
		for(int i =0; i < DIMENSIONS; i++){
			for(int j = 0; j <DIMENSIONS; j++){
				if(cardNumbers[i][j] ==0){
					winCount++;
					if(winCount ==5){
						return true;
					}
				}
				else{
					winCount = 0;
					break;
				}
			}
		}
		for(int i = 0,j = 0; i < DIMENSIONS; i++, j++){
			if(cardNumbers[i][j] == 0){
				winCount++;
				if(winCount ==5){
					return true;
				}
			}
			else{
				winCount = 0;
				break;
			}
		}
		for(int i = 0,j = 4; i < DIMENSIONS; i++, j--){
			if(cardNumbers[i][j] == 0){
				winCount++;
				if(winCount ==5){
					return true;
				}
			}
			else{
				winCount = 0;
				break;
			}
		}
		return false;
	}
}
