import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class KnightsOfHonor2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<String>(Arrays.asList(br.readLine().split("\\s+")));
        Consumer<List<String>> print = list -> {
            for (String str : list) {
                System.out.println("Sir " + str);
            }
        };

        print.accept(names);

    }
}
