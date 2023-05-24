import java.util.Scanner;

public class BlackJack {
  public static void main(String[] args)
  {
    int totalMoney;
    int round = 1;
    int bet = 100;

    System.out.println("Hello, Welcome to blackjack cards!!!");
    System.out.print("Please input your amount of money: ");
    Scanner scanner = new Scanner(System.in);
    totalMoney = scanner.nextInt();
    System.out.println("You have " + totalMoney + "$ in total.");
    while(bet != 0) {
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
      deckOfCards.showAll();
      round++;
    }

    System.out.println("Game stopped.");
  }
}
