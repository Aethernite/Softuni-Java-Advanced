package BoxOfInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        GenericBox<Integer> box = new GenericBox<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            box.add(Integer.parseInt(br.readLine()));
        }
        System.out.println(box);
    }
}
