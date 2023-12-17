package player;

import java.util.Objects;
import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private String failEmotion;
    private boolean isHuman;
    
    public Player(String name, boolean isHuman) {
        this.name = name;
        this.score = 0;
        this.failEmotion = null;
        this.isHuman = isHuman;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    public boolean getIsHuman() {
        return isHuman;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setFailEmotion() {
        String [] failEmotions = {"sad", "disappointed", "angry", "frustrated", "annoyed", "irritated", "depressed", "miserable", "unhappy", "unlucky"};
        this.failEmotion = failEmotions[(int) (Math.random() * failEmotions.length)];
    }
    public void rollingDice() {
        System.out.println("Rolling dice...");
        if (isHuman) {
            System.out.print("(Press Enter to continue)");
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

    public void showEmotion() {
        System.out.print(name + ": ");
        if (failEmotion != null) {
            System.out.println("I'm " + failEmotion + "!");
        } else {
            System.out.println("I'm happy!");
        }
    }
}
