package GenericSwapMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        GenericBox<String> box = new GenericBox<String>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            box.add(br.readLine());
        }
        int[] indexes = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        box.swap(indexes[0], indexes[1]);
        System.out.println(box);
    }
}
