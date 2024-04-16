import java.util.Scanner;
import java.util.Random;

public class BettingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int check;

        System.out.println(
                "\n\t\t\t\t\t\t=================================== WELCOME TO THE JACKPOT CASINO ===================================");
        System.out.println(
                "\n\t\t\t\t\t\t\t========================= Brought to you by Lady Luck Inc. =========================");
        System.out.println("\n\nWhat's your name, high roller? : ");
        String playerName = scanner.nextLine();
        System.out
                .print("\nWelcome, " + playerName + "! Please tell us how much you're bringing to the table today: $");
        int balance = scanner.nextInt();

        while (true) {
            System.out.println("\nYou're currently sitting on a pile of $" + balance);
            System.out.println("What's your game of choice today? ");
            System.out.println("\n1. 🎰 [777] Jackpot Slots ");
            System.out.println("2. 🔮 Guess the Magic Number ");
            System.out.println("3. 🎲 Roll the Roulette Wheel ");
            System.out.println("\nPlease select by typing the number corresponding to your desired game: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("\nTime to roll the dice! How much are you betting this round?: $");
                int bet = scanner.nextInt();

                if (bet <= balance && bet > 0) {
                    System.out.println("\nFeeling lucky, huh? Let's see what fate has in store for you!");

                    int num1 = random.nextInt(10);
                    int num2 = random.nextInt(10);
                    int num3 = random.nextInt(10);
                    System.out.println("\nAnd the reels are spinning... " + num1 + "   " + num2 + "   " + num3);

                    if (num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 == 0) {
                        System.out.println("\n🎉 Congratulations! Lady Luck is smiling upon you!");
                        balance += bet * 2;
                        System.out.println("You've just won: $" + bet * 2);
                    } else if (num1 % 2 != 0 && num2 % 2 != 0 && num3 % 2 != 0) {
                        System.out.println("\n🎉 Congratulations! Fortune favors the bold!");
                        balance += bet * 2;
                        System.out.println("You've just won: $" + bet * 2);
                    } else if (num1 == num2 && num2 == num3 && num3 == num1) {
                        System.out.println("\n🎉 Congratulations! You've hit the jackpot!");
                        balance += bet * 5;
                        System.out.println("You've just won: $" + bet * 5);
                    } else if (num1 == 7 && num2 == 7 && num3 == 7) {
                        System.out.println("\n🎉 Congratulations! You've struck gold with triple 7s!");
                        balance += bet * 10;
                        System.out.println("You've just won: $" + bet * 10);
                    } else {
                        System.out.println("\nBetter luck next time! Your fortune remains unchanged.");
                        balance -= bet;
                    }

                    System.out.println("\nYour current balance: $" + balance);
                    System.out.println();
                } else if (bet < 0) {
                    System.out.println("\nYou can't wager negative amounts, silly!");
                } else {
                    System.out.println("\nYou can't bet more than you've got, try again.");
                }
            } else if (choice == 2) {
                System.out.print("\nWhat's your lucky number today? Make your bet: $");
                int bet = scanner.nextInt();

                if (bet <= balance && bet > 0) {
                    System.out.println("\nLet's see if your intuition pays off!");

                    int chosenNumber = scanner.nextInt();
                    int num = random.nextInt(5);
                    System.out.println("\nThe magic number is... " + num);

                    if (num == chosenNumber) {
                        System.out.println("\n🎉 Congratulations! You've guessed right!");
                        balance += bet * 2;
                        System.out.println("You've just won: $" + bet * 2);
                    } else {
                        System.out.println("\nOops, better luck next time! Your balance takes a hit.");
                        balance -= bet;
                    }

                    System.out.println("\nYour current balance: $" + balance);
                    System.out.println();
                } else if (bet < 0) {
                    System.out.println("\nYou can't wager negative amounts, silly!");
                } else {
                    System.out.println("\nYou can't bet more than you've got, try again.");
                }
            } else if (choice == 3) {
                System.out.print("\nFeeling adventurous? Place your bets! How much are you wagering?: $");
                int bet = scanner.nextInt();
                if (bet <= balance) {
                    System.out.print("\nHow many numbers are you betting on? [1 - 36]: ");
                    int numCount = scanner.nextInt();
                    int moneyNum = bet / numCount;
                    System.out.println("Each number gets a piece of the pie: $" + moneyNum);

                    int[] numbers = new int[numCount];
                    for (int i = 0; i < numCount; i++) {
                        System.out.print("On which number do you want to place your bet? [1 - 36]: ");
                        numbers[i] = scanner.nextInt();
                    }

                    System.out.println("\nSpinning the wheel of fortune...");
                    int randomNum = random.nextInt(36) + 1;
                    System.out.println("The roulette wheel lands on... " + randomNum);

                    int count = 0;
                    for (int num : numbers) {
                        if (num == randomNum) {
                            count++;
                        }
                    }

                    if (count > 0) {
                        System.out.println("\n🎉 Congratulations! Your numbers came up!");
                        balance += moneyNum * 36;
                        System.out.println("You've just won: $" + moneyNum * 36);
                    } else {
                        System.out.println("\nNo luck this time! Your balance takes a hit.");
                        balance -= bet;
                    }

                    System.out.println("\nYour current balance: $" + balance);
                    System.out.println();
                } else if (bet < 0) {
                    System.out.println("\nYou can't wager negative amounts, silly!");
                } else {
                    System.out.println("\nYou can't bet more than you've got, try again.");
                }
            }

            System.out.println("[Press 1] to play another round, [Press 2] to cash out and quit.");
            check = scanner.nextInt();
            if (check == 2) {
                System.out.println("Thanks for playing at the Jackpot Casino! See you next time!");
                break;
            } else {
                if (balance > 0) {
                    System.out.println("\nLet's keep the good times rolling!");
                } else {
                    System.out.println("\nOh no! You've run out of chips. Better luck next time!");
                    break;
                }
            }
        }

        scanner.close();
    }
}
