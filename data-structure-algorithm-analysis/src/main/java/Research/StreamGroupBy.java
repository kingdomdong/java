package Research;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupBy {

    public static void main(String[] args) {
        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, List<String>> result =
                items.stream().collect(
                        Collectors.groupingBy(String::toString, Collectors.toList())
                );

        System.out.println(result);
    }
}
