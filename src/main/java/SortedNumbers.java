import java.util.Arrays;
import java.util.stream.Collectors;

public class SortedNumbers {
    public static String extractAndSortNumbers(String[] array) {
        return Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(",\\s*")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        String[] inputArray = {"1, 2, 0", "4, 5"};
        String result = extractAndSortNumbers(inputArray);
        System.out.println(result);
    }
}