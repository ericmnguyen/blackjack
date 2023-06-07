public class Hand {
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
    int tempPointAce = 0;
    for(int i=0;i<holdingCards.length;i++) {
      tempPoint += holdingCards[i].getCardValue();

      // check if there is an ace card
      if(holdingCards[i].getCardName().equals("Ace")) {
        tempPointAce += 11;
      } else {
        tempPointAce += holdingCards[i].getCardValue();
      }
    }

    // handle black jack
    if (tempPointAce == 21 && holdingCards.length == 2) {
      System.out.println("POINT:  Black Jack!!!");
      return false;
    }

    // print current point
    if(tempPoint != tempPointAce && tempPointAce <= 21) {
      System.out.println("POINT:  " + tempPoint + " or " + tempPointAce);
    } else {
      System.out.println("POINT:  " + tempPoint);
    }

    if(tempPoint < 21) {
      return true;
    }
    return false;
  }

  /*return total value */
  public int getValue() {
    int tempPoint = 0;
    int tempPointAce = 0;
    for(int i=0;i<holdingCards.length;i++) {
      tempPoint += holdingCards[i].getCardValue();

      // check if there is an ace card
      if(holdingCards[i].getCardName().equals("Ace")) {
        tempPointAce += 11;
      } else {
        tempPointAce += holdingCards[i].getCardValue();
      }
    }

    if(tempPoint == 21 && holdingCards.length == 2) {
      // black jack
      return 0;
    }

    if(tempPointAce <= 21 && tempPoint < tempPointAce) {
      return tempPointAce;
    }

    return tempPoint;
  }

  public String toString() {
    String result = "";
    for(int i=0;i<holdingCards.length;i++) {
      result += holdingCards[i] + ", ";
    }
    return result;
  }
}
