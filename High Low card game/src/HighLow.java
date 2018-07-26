import javax.swing.JOptionPane;
/*The Hi-Lo card game is one where the user is presented with an
initial card (2 – 10, Jack, Queen, King, or Ace) and has to guess
that the next card with be Higher (Hi), Lower (Lo) or Equal to the current card.
They must guess successfully 4 times in a row in order to win.*/

public class HighLow {

	public static void main(String[] args) {
		DeckOfCards theDeck = new DeckOfCards();
		theDeck.shuffle();
		String[] options = { "higher", "lower", "equal"};
		int answer = JOptionPane.showConfirmDialog(null, "would you like to play high/low");
		PlayingCard oldCard;
		PlayingCard newCard = theDeck.deal(theDeck);
		String card = "";
		int correctGuess= 0;
		boolean game = (answer == JOptionPane.YES_OPTION);
		while(game){
			oldCard = newCard;
			card = newCard.toPictograph();
			System.out.print(card);
			String theCard = newCard.toString();
			answer = JOptionPane.showOptionDialog(null, " the current card is the " + theCard + " \n is the next card higher, lower or equal to the current card", "Options", 
					JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
			newCard = theDeck.deal(theDeck);
			if((answer == 2)&&(oldCard.isRankEqual(newCard))){
				correctGuess++;
			}
			else if((answer == 1)&&(!oldCard.isRankLessThan(newCard))&&(!oldCard.isRankEqual(newCard))){
				correctGuess++;
			}
			else if((answer == 0)&&(oldCard.isRankLessThan(newCard))){
				correctGuess++;
			}
			else{
				correctGuess = 0;
			}
			String theNewCard = newCard.toString();
			if(correctGuess > 0){
				JOptionPane.showMessageDialog(null, " you got it right! the next card was the " + theNewCard);
			}
			else{
				JOptionPane.showMessageDialog(null, " you got it wrong, the next card was the " + theNewCard);
			}
			if(correctGuess == 4){
				JOptionPane.showMessageDialog(null, " Congrates! you won the high/low game");
			}
			if(theDeck.isEmpty()){
				theDeck = new DeckOfCards();
				theDeck.shuffle();
			}
			if((answer!=0)&&(answer!=1)&&(answer!=2)){
				break;
			}
		}
	}
}