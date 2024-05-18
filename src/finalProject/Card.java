//Using the Card java file from the linked list assignment

package finalProject;

public class Card {

	//instance variables, sometimes called data variables
	private String cardSuit;
	private String cardName;
	private int cardValue;
	private String cardPicture;

	//default constructor
	public Card() {
		cardSuit = "heart";
		cardName = "King";
		cardValue = 10;
		cardPicture = "kh.gif";
		
	}

	public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
		super();
		this.cardSuit = cardSuit;
		this.cardName = cardName;
		this.cardValue = cardValue;
		this.cardPicture = cardPicture;
	}

	public String getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(String cardSuit) {
		this.cardSuit = cardSuit;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	public String getCardPicture() {
		return cardPicture;
	}

	public void setCardPicture(String cardPicture) {
		this.cardPicture = cardPicture;
	}

	@Override
	public String toString() {
		return "Card [cardSuit=" + cardSuit + ", cardName=" + cardName + ", cardValue=" + cardValue + ", cardPicture="
				+ cardPicture + "]";
	}

	
	public boolean equals(Card cardToCompare) {
		/*
		System.out.println("comparing cards in equals");
		System.out.println(this.cardName + " to " + cardToCompare.cardName);
		System.out.println(this.cardSuit + " to " + cardToCompare.cardSuit);
		*/
		

		return this.cardSuit.equals(cardToCompare.getCardSuit()) &&
				this.getCardName().equals(cardToCompare.getCardName());
	}	
	
	
}//end class