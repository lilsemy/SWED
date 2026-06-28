import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext(); ) {
            Integer number = iterator.next();

            if (number % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println(numbers); // [1, 3, 5]
    }
}
