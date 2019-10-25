import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashSet<String>> map = new LinkedHashMap<>();

        while(true){
            String input = br.readLine();
            if(input.equals("JOKER")){
                break;
            }
            String[] personAndCards = input.split(": ");
            String[] cards = personAndCards[1].split(", ");
            LinkedHashSet<String> set;
            if(map.containsKey(personAndCards[0])) {
                set = map.get(personAndCards[0]);
            }else{
                set = new LinkedHashSet<String>();
            }
            Collections.addAll(set,cards);
            map.put(personAndCards[0], set);
        }

        for(String key: map.keySet()){
            LinkedHashSet<String> set = map.get(key);
            int total = 0;
            for(String card: set){
                Card object = new Card(card);
                total += object.getTotal();
            }
            System.out.println(key + ": " + total);
        }
    }
}


class Card{
    private int power;
    private int multiplier;
    private int total;


    public Card(String in){
        String[] card = in.split("");

        switch(card[0]){
            case "1":
                this.power = 10;
                card[1] = card[2];
                break;
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                this.power = Integer.parseInt(card[0]);
                break;
            case "J":
                this.power = 11;
                break;
            case "Q":
                this.power = 12;
                break;
            case "K":
                this.power = 13;
                break;
            case "A":
                this.power = 14;
                break;
        }

        switch(card[1]){
            case "S":
                this.multiplier = 4;
                break;
            case "H":
                this.multiplier = 3;
                break;
            case "D":
                this.multiplier = 2;
                break;
            case "C":
                this.multiplier = 1;
                break;
        }

        this.total = power * multiplier;
    }

    public int getTotal() {
        return total;
    }

}