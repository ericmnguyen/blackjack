public class Card {
  private int cardNumber;
  private int suit;
  private String cardName;
  private String symbol;

  public Card(int cardNumber, int suit) {
    this.cardNumber = cardNumber;
    this.suit = suit;
  }

  // TODO: getCardName, setCardName, getCardSymbol, setCardSymbol

  public String toString() {
    switch(cardNumber) {
      case 0:
        cardName = "Ace";
      case 1,2,3,4,5,6,7,8,9:
        cardName = "" + (cardNumber + 1);
        break;
      case 10:
        cardName = "Jack";
        break;
      case 11:
        cardName = "Queen";
        break;
      case 12:
        cardName = "King";
        break;
      default:
        cardName = "Default";
        break;
    }
    switch(suit) {
      case 0:
        symbol = "Hearts";
        break;
      case 1:
        symbol = "Diamonds";
        break;
      case 2:
        symbol = "Spades";
        break;
      case 3:
        symbol = "Clubs";
        break;
    }

    return cardName + " of " + symbol;
  }
}
