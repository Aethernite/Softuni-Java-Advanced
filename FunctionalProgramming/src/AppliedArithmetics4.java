import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] arr = Arrays.stream(br.readLine().split("\\s+"))
                .map(String::trim).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        //PRINT
        Consumer<Integer[]> print = list -> {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        };
        //ADD
        Function<Integer[], Integer[]> add = list ->{
            for(int i=0; i<list.length; i++){
                list[i] = list[i]+1;
            }
            return list;
        };
        Function<Integer[], Integer[]> multiply = list ->{
            for(int i=0; i<list.length; i++){
                list[i] = list[i]*2;
            }
            return list;
        };
        //SUBTRACT
        Function<Integer[], Integer[]> subtract = list ->{
            for(int i=0; i<list.length; i++){
                list[i] = list[i]-1;
            }
            return list;
        };


        while(true){
            String input = br.readLine();
            if(input.equals("end")){
                break;
            }
            switch(input){
                case "add":
                    arr = add.apply(arr);
                    break;
                case "subtract":
                    arr = subtract.apply(arr);
                    break;
                case "multiply":
                    arr = multiply.apply(arr);
                    break;
                case "print":
                    print.accept(arr);
                    break;
            }
        }


    }
}
