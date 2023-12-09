import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomOrder {
    private ArrayList<Integer> numbers = new ArrayList<>();
    public RandomOrder() {
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Collections.shuffle(numbers);
    }
    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
