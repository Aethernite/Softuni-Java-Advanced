import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class UniqueUsernames1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String input = br.readLine();
            set.add(input);
        }

        for(String str: set){
            System.out.println(str);
        }
    }
}


