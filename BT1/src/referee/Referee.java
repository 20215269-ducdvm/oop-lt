package referee;

import java.util.Scanner;

public class Referee {

    public Referee() {
    }

    public int choosePlayer() {
        //choose a player from input
        System.out.println("Choose a player: ");
        Scanner scanner = new Scanner(System.in);
        int playerNumber = scanner.nextInt();
        if (playerNumber < 1 || playerNumber > 4) {
            throw new ArrayIndexOutOfBoundsException("Player number must be between 1 and 4!");
        }
        return playerNumber;
    }

}
