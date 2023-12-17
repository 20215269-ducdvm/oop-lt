package game;

import dice.Dice;
import player.Player;
import random.Order;
import referee.Referee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Player[] players = new Player[4];
    private final Dice[] dices = new Dice[4];
    private final Referee referee = new Referee();
    private static boolean isGameOver;

    public Game() {
    }
    private void initDice() {
        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice(i + 1, 0.2);
        }
    }
    private void initPlayers() throws Exception{
        System.out.println("Enter number of human players: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfHumanPlayers = scanner.nextInt();
        if (numberOfHumanPlayers < 0 || numberOfHumanPlayers > 4) {
            throw new Exception("Number of human players must be between 0 and 4!");

        }
        //initiate human players
        for (int i = 0; i < numberOfHumanPlayers; i++) {
            players[i] = new Player("Player " + (i + 1), true);
            System.out.println("Welcome " + players[i].getName() + "!");
        }
        //initiate computer players
        for (int i = numberOfHumanPlayers; i < 4; i++) {
            players[i] = new Player("Computer " + (i - numberOfHumanPlayers + 1), false);
            System.out.println("Welcome " + players[i].getName() + "!");
        }
    }
    private void playRound() throws Exception{
        List<Integer> playerNumbers = new ArrayList<>();
        while (true) {
            int score = 0;
            int playerNumber;

            while(true) {
                playerNumber = referee.choosePlayer();
                if (playerNumber < 1 || playerNumber > 4) {
                    throw new Exception("Player number must be between 1 and 4!");
                }
                if (!playerNumbers.contains(playerNumber)) {
                    break;
                }
                System.out.println("Player " + playerNumber + " has already played this round!");
            }

            playerNumbers.add(playerNumber);

            Player player = players[playerNumber - 1];
            System.out.println(player.getName() + "'s turn.");
            Order randomOrder = new Order(4);
            randomOrder.shuffle();

            ArrayList<Integer> numbers = randomOrder.getNumbers();
            for (int number : numbers) {
                Dice dice = dices[number - 1];
                player.rollingDice();
                int value = dice.roll();
                System.out.println("Dice " + number + " rolled: " + value + "\n");
                score += value;
            }

            System.out.println(player.getName() + "'s score: " + score + "\n");
            if (score == 21) {
                player.setScore(21);
                System.out.println(player.getName() + " wins!");
                isGameOver = true;
                playerNumbers.clear();
                break;
            } else if (score > 21) {
                player.setScore(0);
            } else {
                player.setScore(score);
            }

            if (playerNumbers.size() == 4) {
                playerNumbers.clear();
                break;
            }
        }
    }
    public void playGame() throws Exception {
        initDice();
        initPlayers();
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
            for (Player player : players) {
                if (!player.getIsHuman() && player.getScore() != 21) {
                    player.setFailEmotion();
                    player.showEmotion();
                }
            }

            System.out.println("Start another round? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equals("n")) {
                System.out.println("Game over! Thanks for playing!");
                break;
            }
        }
    }
    private void printScore() {
        System.out.println("Final score:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }
}
