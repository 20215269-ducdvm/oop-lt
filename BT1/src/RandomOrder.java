import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomOrder {
    private ArrayList<Integer> numbers = new ArrayList<>();
    public RandomOrder(int maxNumber) {
        for (int i = 1; i <= maxNumber; i++) {
            numbers.add(i);
        }
    }
    public void removeNumber(int number) {
        numbers.remove(number);
    }
    public void shuffle() {
        Collections.shuffle(numbers);
    }
    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
