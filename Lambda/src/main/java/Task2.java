import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 8, 20, 15, 3, 12);
        List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
        List<Integer> doubledOddNumbers = map(numbers, n -> n % 2 != 0 ? n * 2 : n);
        int sumAllNumbers = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Original List: " + numbers);
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Doubled Odd Numbers: " + doubledOddNumbers);
        System.out.println("Sum of all Numbers: " + sumAllNumbers);
    }
    public static List<Integer> filter(List<Integer> list, java.util.function.Predicate<Integer> predicate) {
        return list.stream().filter(predicate).toList();
    }
    public static List<Integer> map(List<Integer> list, java.util.function.Function<Integer, Integer> mapper) {
        return list.stream().map(mapper).toList();
    }
}
