public class DeckOfCards {
  private int numberOfCards;
  private int totalOfCards;
  private String[] cards = new String[52];

  public DeckOfCards () {
    totalOfCards = 52;
    for(int i=0;i<52;i+=1) {
      int symbol = i/13;
      int cardNumber = i%13;
      Card card = new Card(cardNumber, symbol);
      cards[i] = card.toString();
    }
  }

  public String withdrawCards(int numberOfCards) {
    return "";
  }

}
