import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Names {
    public static String getNames(List<String> names){
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> ((i / 2) + 1) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }
}
