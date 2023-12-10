import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Dice[] dices = new Dice[4];
    static Player[] players = new Player[4];
    static void initDice() {
        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice(i + 1, 0.2);
        }
    }
    static void initPlayers() {
        System.out.println("Enter number of human players: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfHumanPlayers = scanner.nextInt();
        //initiate human players
        for (int i = 0; i < numberOfHumanPlayers; i++) {
            players[i] = new Player("Player " + (i + 1), true);
            System.out.println("Welcome " + players[i].getName() + "!");
        }
        //initiate computer players
        for (int i = numberOfHumanPlayers; i < players.length; i++) {
            players[i] = new Player("Computer " + (i + 1 - numberOfHumanPlayers), false);
            System.out.println("Welcome " + players[i].getName() + "!");
        }
    }
    static void rollingDice(Player player) {
        System.out.println("Rolling dice...");
        if (player.getIsHuman()) {
            System.out.print("(Press any key to continue)");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static boolean isGameOver;
    static void playRound() {
        for (Player player : players) {
            int score = 0;

            System.out.println(player.getName() + "'s turn.");
            RandomOrder randomOrder = new RandomOrder(4);
            randomOrder.shuffle();

            ArrayList<Integer> numbers = randomOrder.getNumbers();
            for (int number : numbers) {
                Dice dice = dices[number - 1];
                rollingDice(player);
                int value = dice.roll();
                System.out.println("Dice " + number + " rolled: " + value + "\n");
                score += value;
            }

            System.out.println(player.getName() + "'s score: " + score + "\n");
            if (score == 21) {
                player.setScore(21);
                System.out.println(player.getName() + " wins!");
                isGameOver = true;
                break;
            } else if (score > 21) {
                player.setScore(0);
            } else {
                player.setScore(score);
            }
        }
    }
    static void playGame() {
        int round = 0;
        while (true) {
            round++;
            System.out.println("Round " + round + " starts!\n");
            playRound();

            if (isGameOver) {
                break;
            }

            System.out.println("Round " + round + " ends!\n");
            printScore();
            showEmotion();

            System.out.println("Start another round? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equals("n")) {
                System.out.println("Game over! Thanks for playing!");
                break;
            }
        }

    }
    static void showEmotion() {
        for (Player player : players) {
            if (!player.getIsHuman()) {
                if (player.getScore() == 21)
                    player.setFailEmotion("happy");
                else if (player.getScore() == 0)
                    player.setFailEmotion("sad");
                else
                    player.setFailEmotion("neutral");
                player.showEmotion();
            }

        }
    }
    static void printScore() {
        System.out.println("Final score:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }
    public static void main(String[] args) {
        initDice();
        initPlayers();
        playGame();
    }
}