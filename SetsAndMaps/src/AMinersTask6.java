import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class AMinersTask6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>();
        while(true){
            String input = br.readLine();
            if(input.equals("stop")){
                break;
            }
            int quantity = Integer.parseInt(br.readLine());
            if(map.containsKey(input)){
                map.put(input,map.get(input)+quantity);
            }else {
                map.put(input, quantity);
            }
        }

        for(String key: map.keySet()){
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
