import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class ReverseAndExclude5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors
             .toCollection(ArrayList::new));

        int dev = Integer.parseInt(br.readLine());
        //REMOVE CHECK
        BiPredicate<Integer,Integer> shouldRemove = (num, div) -> num%div!=0;
        //REVERSE
        Function<List<Integer>, List<Integer>> reverse = (list) ->{
            Collections.reverse(list);
            return list;
        };
        //PRINT
        Consumer<List<Integer>> print = list -> {
            for(Integer num: list){
                System.out.print(num + " ");
            }
            System.out.println();
        };
        //REVERSE AND REMOVE
       numbers = reverse.apply(numbers);
       numbers = numbers.stream()
               .filter(x -> shouldRemove.test(x,dev))
               .collect(Collectors.toList());

       print.accept(numbers);
    }
}
