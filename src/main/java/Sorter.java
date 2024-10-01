import java.util.List;
import java.util.stream.Collectors;

public class Sorter {
    public static List<String> toUpperAndSort(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
    }
}
