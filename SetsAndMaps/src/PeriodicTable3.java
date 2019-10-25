import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class PeriodicTable3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> set = new TreeSet<String>();
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split("\\s");

            for(String str: input){
                set.add(str);
            }
        }

        for(String str: set){
            System.out.print(str + " ");
        }
    }
}
