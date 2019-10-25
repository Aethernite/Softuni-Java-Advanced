package Pokemon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Trainer> map = new LinkedHashMap<>();
        while(true){
            String[] input = br.readLine().split("\\s+");
            if(input[0].equals("Tournament")){
                break;
            }
            Pokemon poke = new Pokemon(input[1], input[2], Integer.parseInt(input[3]));
            if(!map.containsKey(input[0])){
                Trainer tr = new Trainer(input[0]);
                ArrayList<Pokemon> collection = tr.getCollection();
                collection.add(poke);
                tr.setCollection(collection);
                map.put(input[0],tr);
            }
            else{
                Trainer tr = map.get(input[0]);
                ArrayList<Pokemon> collection = tr.getCollection();
                collection.add(poke);
                tr.setCollection(collection);
            }
        }



        while(true){
            String input = br.readLine();
            if(input.equals("End")){
                break;
            }
            map.forEach((k,v)->{
               v.tournament(input);
            });
        }


        map.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().getBadges(), b1.getValue().getBadges()))
                .forEach(t -> {
                    System.out.println(String.format("%s %s %s", t.getKey(),
                            t.getValue().getBadges(),
                            t.getValue().getCollection().size()));
                });


    }
}
