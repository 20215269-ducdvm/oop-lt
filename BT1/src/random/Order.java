package random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private ArrayList<Integer> numbers = new ArrayList<>();
    public Order(int maxNumber) {
        for (int i = 1; i <= maxNumber; i++) {
            numbers.add(i);
        }
    }
    public void removeNumber(int number) {
        numbers.remove(Integer.valueOf(number));
    }
    public void shuffle() {
        Collections.shuffle(numbers);
    }
    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
