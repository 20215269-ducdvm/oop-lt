import java.util.Random;

public class Dice {
    private int value;
    private double probability;
    private Random random;

    public Dice(int value, double probability) {
        this.value = value;
        this.probability = probability;
        random = new Random();
    }
    public int roll() {
        double p = random.nextDouble();
        if (p < probability) {
            return value;
        } else {
            int result;
            do {
                result = random.nextInt(6) + 1;
            } while (result == value);
            return result;
        }
    }
}
