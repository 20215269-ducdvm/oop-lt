import java.util.Objects;

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
    public void setFailEmotion(String failEmotion) {
        this.failEmotion = failEmotion;
    }
    public void showEmotion() {
        System.out.print(name + ": ");
        if (Objects.equals(failEmotion, "happy")) {
            System.out.println("I'm happy!");
        } else if (Objects.equals(failEmotion, "sad")) {
            System.out.println("I'm sad!");
        } else {
            System.out.println("I'm neutral!");
        }
    }
}
