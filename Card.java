public class Card {
  private int cardNumber;
  private int symbolNumber;

  public Card(int cardNumber) {
    this.cardNumber = cardNumber%13;
    symbolNumber = cardNumber/13;
  }

  public String getCardName() {
    return convertCardNameToString(cardNumber);
  }

  public void setCardName(int cardNumber) {
    this.cardNumber = cardNumber%13;
  }

  // TODO: getCardSymbol, setCardSymbol

  private String convertCardNameToString(int cardNumber) {
    switch(cardNumber) {
      case 0:
        return "Ace";
      case 1,2,3,4,5,6,7,8,9:
        return "" + (cardNumber + 1);
      case 10:
        return "Jack";
      case 11:
        return "Queen";
      case 12:
        return "King";
      default:
        return "";
    }
  }

  private String convertSymbolToString(int symbolNumber) {
    switch(symbolNumber) {
      case 0:
        return "Hearts";
      case 1:
        return "Diamonds";
      case 2:
        return "Spades";
      case 3:
        return "Clubs";
    }
  }

  public String toString() {
    // TODO
  }
}
