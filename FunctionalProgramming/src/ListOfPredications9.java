import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredications9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BiPredicate<Integer,Integer> divisable = (num,div) -> num%div==0;

        List<Integer> numbers = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors
                .toCollection(ArrayList::new));

        for(int i=1; i<=n; i++){
            boolean check = true;
            for(int num: numbers){
                if(!divisable.test(i,num)){
                    check = false;
                }
            }
            if(check){
                System.out.print(i + " ");
            }


        }
    }
}
