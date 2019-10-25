import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class PhoneBook5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
        while(true){
            String input = br.readLine();
            if(input.equals("search")){
                break;
            }
            String[] contact = input.split("-");
            map.put(contact[0], contact[1]);
        }

        while(true){
            String input = br.readLine();
            if(input.equals("stop")){
                break;
            }
            if(map.containsKey(input)){
                System.out.println(input + " -> " + map.get(input));
            }else{
                System.out.println("Contact " + input +" does not exist.");
            }

        }
    }
}
