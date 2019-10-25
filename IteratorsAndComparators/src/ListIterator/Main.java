package ListIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] create = br.readLine().split("\\s+");
        String[] list = new String[create.length-1];
        for(int i=1; i<create.length;i++){
            list[i-1] = create[i];
        }
        ListLib<String> lib = new ListLib<String>(list);

        while(true){
            String input = br.readLine();
            if(input.equals("END")){
                break;
            }
            switch(input){
                case "Move":
                    System.out.println(lib.move());
                    break;
                case "Print":
                    lib.print();
                    break;
                case "HasNext":
                    System.out.println(lib.hasNext());
                    break;
                case "PrintAll":
                    lib.printAll();
                    break;
            }


        }

    }
}
