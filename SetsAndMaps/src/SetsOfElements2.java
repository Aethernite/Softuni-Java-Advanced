import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class SetsOfElements2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<Integer> setN = new LinkedHashSet<Integer>();
        LinkedHashSet<Integer> setM = new LinkedHashSet<Integer>();
        String[] sizes = br.readLine().split("\\s");
        int n = Integer.parseInt(sizes[0]);
        int m = Integer.parseInt(sizes[1]);

        for(int i=0; i<n; i++){
            setN.add(Integer.parseInt(br.readLine()));
        }

        for(int i=0; i<m; i++){
            setM.add(Integer.parseInt(br.readLine()));
        }



        for(Integer num: setN){
            if(setM.contains(num)){
                System.out.print(num + " ");
            }
        }
    }
}
