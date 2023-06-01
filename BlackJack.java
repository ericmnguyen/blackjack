import java.util.Scanner;

public class BlackJack {
  public static void main(String[] args) {
    int totalMoney;
    int round = 1;
    int bet = 100;

    System.out.println("Hello, Welcome to blackjack cards!!!");
    System.out.print("Please input your amount of money: ");
    Scanner scanner = new Scanner(System.in);
    totalMoney = scanner.nextInt();
    while (bet != 0) {
      System.out.println("You have " + totalMoney + "$ in total.");
      System.out.print("Input your betting (press 0 to quit the game): ");
      bet = scanner.nextInt();
      if (bet == 0) {
        return;
      } else if (bet > totalMoney) {
        System.out.println("Not enough money. Please try again!");
        continue;
      } else if (bet < 0) {
        System.out.println("Invalid input. Please try again!");
        continue;
      }
      
      System.out.println("---------------* Round " + round + " *---------------");
      System.out.println("Shuffling cards...");
      DeckOfCards deckOfCards = new DeckOfCards();
      deckOfCards.shuffleCards();
      // deckOfCards.showAll();
      
      Hand playerHand = new Hand();
      Hand dealerHand = new Hand();
      playerHand.addCard(deckOfCards.withdraw());
      playerHand.addCard(deckOfCards.withdraw());
      dealerHand.addCard(deckOfCards.withdraw());
      dealerHand.addCard(deckOfCards.withdraw());
      System.out.println("Player hand: " + playerHand);
      
      // player's turn
      String isStand = "";
      while(!isStand.toLowerCase().equals("s") && playerHand.shouldShowHitOrStand()) {
        System.out.print("Hit or Stand?(h/s): ");
        isStand = scanner.next();
        if(isStand.toLowerCase().equals("h")) {
          playerHand.addCard(deckOfCards.withdraw());
          System.out.println("Player hand: " + playerHand);
        }
      }

      //dealer's turn
      System.out.println("Dealer hand: " + dealerHand);
      while(dealerHand.getValue() < 15) {
        dealerHand.addCard(deckOfCards.withdraw());
        System.out.println("Dealer hand: " + dealerHand);
      }
      System.out.println("POINTS: " + dealerHand.getValue());

      // show the result
      if(dealerHand.getValue() == 0 && playerHand.getValue() != 0) {
        // dealer got blackjack
        System.out.println("Dealer won!");
        // take player's bet
        totalMoney -= bet;
      } else if(playerHand.getValue() == 0 && dealerHand.getValue() != 0) {
        // player got blackjack
        System.out.println("Player won!");
        // give player money
        totalMoney += bet;
      } else if(dealerHand.getValue() > 21 && playerHand.getValue() > 21
          || dealerHand.getValue() == playerHand.getValue()) {
        // draw
        System.out.println("Draw!");
      } else if(dealerHand.getValue() > playerHand.getValue() && dealerHand.getValue() <= 21
                || dealerHand.getValue() <= 21 && playerHand.getValue() > 21 ) {
        // dealer won
        System.out.println("Dealer won!");
        // take player's bet
        totalMoney -= bet;
      } else if(playerHand.getValue() > dealerHand.getValue() && playerHand.getValue() <= 21
              || playerHand.getValue() <= 21 && dealerHand.getValue() > 21) {
        // player won
        System.out.println("Player won!");
        // give player money
        totalMoney += bet;
      }

      round++;
    }

    scanner.close();
    System.out.println("Game stopped.");
  }
}
