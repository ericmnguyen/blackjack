public class DeckOfCards {
  private int numberOfCards;
  private int totalOfCards;
  private String[] cards = new String[52];

  public DeckOfCards () {
    totalOfCards = 52;
    for(int i=0;i<52;i+=1) {
      Card card = new Card(i);
      cards[i] = card.toString();
    }
  }

  public String withdrawCards(int numberOfCards) {
    return "";
  }

}
