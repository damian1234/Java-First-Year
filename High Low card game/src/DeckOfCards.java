import java.util.Random;
public class DeckOfCards { // begin DeckOfCards data type 

	// playing cards of deck of cards 
	private PlayingCard[] deck; 

	// count of the number of playing 
	// card remaining in the deck. 
	private int count;  
	// invariant: 0 <= count <= PlayingCard.SUITS.length * PlayingCard.RANK.length

	// construct a deck of 56 different playing cards in rank order 
	// arranged by suit, ie, not shuffled.   
	public DeckOfCards() { 
		int suits = PlayingCard.SUITS.length; 
		int ranks = PlayingCard.RANKS.length; 
		count = suits * ranks;  

		deck = new PlayingCard[count]; 

		for (int suitIndex = 0; suitIndex < suits; suitIndex++) 
			for (int rankIndex = 0; rankIndex < ranks; rankIndex++) 
				deck[suitIndex * ranks + rankIndex] =  
				new PlayingCard(rankIndex, suitIndex); 
	} 

	// have all playing cards in the deck been dealt? 
	public boolean isEmpty() {
		boolean finished = false;
		if( count == 0){
			finished = true;
			count = 56;
		}
		return finished;
		// ... you must fill in the body of this method! 
	}  

	// return the top playing card from the 
	// deck of cards assuming the deck is non-empty, 
	// otherwise the cards that have been dealt are
	// re-shuffled and the new top playing card is dealt. 
	public PlayingCard deal(DeckOfCards theDeck) { 
		PlayingCard topCard = deck[count-1];
		count--;
		return topCard;
	} 

	// randomaly shuffle the remaining playing cards in the deck. 
	public void shuffle() { 

		if (deck!=null)
		{
			Random generator = new Random();
			for (int index=0; index<deck.length; index++ )
			{
				int otherIndex = generator.nextInt(deck.length);
				PlayingCard temp = deck[index];
				deck[index] = deck[otherIndex];
				deck[otherIndex] = temp;
				
			}
		}

	} 

	// convert the deck of cards to pictographs in a String value.  
	public String toPictographs() { 
		String deckAsString = ""; 
		for(int index = 0; index < count; index++) {  
			deckAsString = deckAsString + deck[index].toPictograph() + " "; 
			if ((index + 1) % PlayingCard.RANKS.length == 0) 
				deckAsString = deckAsString + "\n";             
		} 
		return deckAsString; 
	} 

	// test the DeckOfCards data type by creating a deck of cards 
	// then suffling the deck and dealing two cards from the deak. 
	

} // end DeckOfCards data type
