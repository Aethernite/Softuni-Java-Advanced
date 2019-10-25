import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;



public class PredicateParty10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> guests = Arrays.stream(br.readLine().split("\\s+")).collect(Collectors.toList());
        while (true) {
            String[] input = br.readLine().split("\\s+");
            if (input[0].equals("Party!")) {
                break;
            }
            BiPredicate<String, String> predication = getPredicate(input[1]);


            switch (input[0]) {
                case "Double":
                    for (int i = 0; i < guests.size(); i++) {
                        String guest = guests.get(i);
                        if (predication.test(guests.get(i), input[2])) {
                            guests.add(i++, guest);
                        }
                    }
                    break;
                case "Remove":
                    guests.removeIf(e -> predication.test(e, input[2]));
                    break;
            }

        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guests);
            System.out.println(String.format("%s are going to the party!", String.join(", ", guests)));
        }
    }

    private static BiPredicate<String,String> getPredicate(String type) {
        switch (type) {
            case "StartsWith":
                return (name,prefix) ->{
                    return name.startsWith(prefix);
                };
            case "EndsWith":
                return (name,suffix) ->{
                    return name.endsWith(suffix);
                };
            case "Length":
                return (name,length) ->{
                    return name.length()==Integer.parseInt(length);
                };

            case "Contains":
                return (name,substring) ->{
                    return name.contains(substring);
                };
            default: return null;
        }
    }
}
