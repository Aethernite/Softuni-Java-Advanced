import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateForNames6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        List<String> list = Arrays.stream(br.readLine().split("\\s+")).collect(Collectors.toList());

        BiPredicate<String, Integer> check = (str, len) -> str.length()<=len;

        BiConsumer<List<String>, Integer> print = (names, len) ->{
            for(String name: names){
                if(check.test(name,len)){
                    System.out.println(name);
                }
            }
        };

        print.accept(list,length);

    }
}
