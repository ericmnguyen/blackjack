public class Hand {
  private int point;
  private int numberOfCard = 0;
  private Card[] holdingCards = new Card[numberOfCard + 1];

  public void addCard(Card card) {
    Card[] newCard = new Card[numberOfCard + 1];
    for(int i=0;i<holdingCards.length;i++) {
      newCard[i] = holdingCards[i];
    }
    newCard[numberOfCard] = card;
    holdingCards = newCard;
    numberOfCard++;
  }

  public boolean shouldShowHitOrStand() {
    int tempPoint = 0;
    for(int i=0;i<holdingCards.length;i++) {
      tempPoint += holdingCards[i].getCardValue();
    }
    System.out.println("POINT:  " + tempPoint);
    if(tempPoint < 17) {
      return true;
    }
    return false;
  }

  public int getValue() {
    int point = 0;
    int aceCount = 0;
    for(int i=0;i<holdingCards.length;i++) {
      point += holdingCards[i].getCardValue();
      aceCount = holdingCards[i].getCardValue() == 1 ? aceCount++ : aceCount;
    }
    if(point == 11 && holdingCards.length == 2 && aceCount == 1) {
      // double Aces
      return 1;
    }
    return point;
  }

  public String toString() {
    String result = "";
    for(int i=0;i<holdingCards.length;i++) {
      result += holdingCards[i] + ", ";
    }
    return result;
  }
}
