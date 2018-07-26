import java.util.*;

import javax.swing.JOptionPane;

public class Main {

	public static final int TIMES_RUN = 500;
	public static void main(String[] args) {
		double turnCount = 0;
		for(int j = 0; j< TIMES_RUN; j++ ){
			GameBoard board = new GameBoard();
			BingoCard card1 = new BingoCard();
			card1.initCard();
			while(!card1.winner()){
				int nextNum = board.nextNum();
				if(card1.checkMatch(nextNum)){
					card1.match(nextNum);

				}
				turnCount++;
			}
		}
		turnCount/= TIMES_RUN;
		JOptionPane.showMessageDialog(null, turnCount);
		BingoCard[] cardArray = new BingoCard[500];
		GameBoard board = new GameBoard();
		for(int i = 0; i <cardArray.length; i ++){
			cardArray[i] = new BingoCard();
			cardArray[i].initCard();
		}
		double totalCount = 0;
		for(int j = 0; j < TIMES_RUN; j++){
			turnCount = 0;
			board = new GameBoard();
			for(int i = 0; i <cardArray.length; i ++){
				cardArray[i] = new BingoCard();
				cardArray[i].initCard();
			}
			boolean winner = false;
			do{
				int nextNum = board.nextNum();
				for(int i = 0; i < cardArray.length; i++){
					if(cardArray[i].checkMatch(nextNum)){
						cardArray[i].match(nextNum);

					}
				}
				turnCount++;
				for(int i = 0; i < cardArray.length; i++){
					if(cardArray[i].winner()){
						winner = true;
					}
				} 
			}while(!winner);
			totalCount += turnCount;
		}
		totalCount /= TIMES_RUN;
		JOptionPane.showMessageDialog(null, totalCount);
	}
}
