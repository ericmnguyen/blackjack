public class DeckOfCards {
  private int numberOfCards;
  private int totalOfCards;
  private Card[] cards = new Card[52];

  public DeckOfCards () {
    totalOfCards = 52;
    for(int i=0;i<52;i+=1) {
      Card card = new Card(i);
      cards[i] = card;
    }
  }

  public void shuffleCards() {
  	for(int i=0; i<cards.length;i++)     {
  	    int j=(int)(Math.random()*(cards.length-i));
  	    Card tmp=cards[i];
  	    cards[i]=cards[i+j];
  	    cards[i+j]=tmp;
  	}
  }

  public void showAll() {
    for(int i=0;i<52;i++) {
      System.out.print(cards[i].toString() + "\t");
    }
  }
}
