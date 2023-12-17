package dice;

import java.util.Random;
import random.Order;
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
            Order randomOrder = new Order(6);
            randomOrder.removeNumber(value);
            return randomOrder.getNumbers().get(random.nextInt(5));
        }
    }
}
