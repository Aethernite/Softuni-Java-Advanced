import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] arr = Arrays.stream(br.readLine().split("\\s+"))
                .map(String::trim).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        Function<Integer[], Integer> min = numbers -> {
          int num = numbers[0];
          for(Integer i: numbers){
              if(num>i){
                  num = i;
              }
          }
          return num;
        };

        System.out.println(min.apply(arr));
    }
}
