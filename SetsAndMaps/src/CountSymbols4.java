import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountSymbols4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        TreeMap<Character,Integer> map = new TreeMap<Character,Integer>();


        for(int i=0; i<input.length(); i++){
            char character = input.charAt(i);
            if(map.containsKey(character)){
                map.put(character, map.get(character)+1);
            }
            else{
                map.put(character,1);
            }
        }


        for(char character: map.keySet()){
            System.out.println(character + ": " + map.get(character) + " time/s");
        }
    }
}
