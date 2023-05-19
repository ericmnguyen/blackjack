import java.util.Scanner;

public class BlackJack {
  public static void main(String[] args)
  {
    int totalMoney;

    System.out.println("Hello, Welcome to blackjack cards!!!");
    System.out.print("Please input your amount of money: ");
    Scanner scanner = new Scanner(System.in);
    totalMoney = scanner.nextInt();
    System.out.println("You have " + totalMoney + "$ in total.");
  }
}
