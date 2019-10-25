import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pattern p = Pattern.compile("^([A-Za-z0-9]+)+@([a-z]+)\\.(uk|us|com)$");
        Matcher m;
        LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
        while(true){
            String input = br.readLine();
            if(input.equals("stop")){
                break;
            }
            String email = br.readLine();
            m = p.matcher(email);
            if(!m.matches()){
                map.put(input,email);
            }
        }


        for(String key: map.keySet()){
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
