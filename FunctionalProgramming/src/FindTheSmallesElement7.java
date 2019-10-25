import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallesElement7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors
                .toCollection(ArrayList::new));

        Function<List<Integer>, Integer> findSmallest = (list) ->{
            int min = list.get(0);
            int index = 0;
          for(int i=0; i<list.size();i++){
              if(list.get(i)<=min){
                  min = list.get(i);
                  index = i;
              }
          }
          return index;
        };

        System.out.println(findSmallest.apply(numbers));

    }

}
