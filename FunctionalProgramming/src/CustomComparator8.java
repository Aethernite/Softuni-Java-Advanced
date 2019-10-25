import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomComparator8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Comparator<Integer> comparator = Comparator.comparing(
                num -> num%2!=0 );

        List<Integer> numbers = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors
                .toCollection(ArrayList::new));
        Collections.sort(numbers);
        numbers.sort(comparator);

        for(Integer num: numbers){
            System.out.print(num + " ");
        }
        System.out.println();

    }
}
