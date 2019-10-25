import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilter11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> guests = Arrays.stream(br.readLine().split("\\s+")).collect(Collectors.toList());
        List<Filter> filters = new ArrayList<Filter>();
        List<Filter> toRemove = new ArrayList<Filter>();
        while(true) {
            String[] input = br.readLine().split(";");
            if (input[0].equals("Print")) {
                break;
            }
            switch (input[0]) {
                case "Add filter": {
                    Filter filter = new Filter(input[1], input[2]);
                    filters.add(filter);
                    break;
                }
                case "Remove filter": {
                    Filter filter = new Filter(input[1], input[2]);
                    for (Filter fi : filters) {
                        if (fi.getType().equals(filter.getType()) && fi.getParameter().equals(filter.getParameter())) {
                            toRemove.add(fi);
                        }
                    }
                    filters.removeAll(toRemove);
                    break;
                }
            }
        }
         guests = applyFilters(guests,filters);
            for(String name: guests){
                System.out.print(name + " ");
            }

        }

    public static List<String> applyFilters(List<String> guests, List<Filter> filters){

        for(Filter filter: filters){
            BiPredicate<String, String> predication = getPredicate(filter.getType());
           guests = guests.stream().filter(e->predication.test(e,filter.getParameter())).collect(Collectors.toList());
        }

        return guests;
    }


    private static BiPredicate<String,String> getPredicate(String type) {
        switch (type) {
            case "Starts with":
                return (name,prefix) ->{
                    return !name.startsWith(prefix);
                };
            case "Ends with":
                return (name,suffix) ->{
                    return !name.endsWith(suffix);
                };
            case "Length":
                return (name,length) ->{
                    return name.length()==Integer.parseInt(length);
                };

            case "Contains":
                return (name,substring) ->{
                    return !name.contains(substring);
                };
            default: return null;
        }
    }


}
class Filter{
    String type;
    String parameter;

    public Filter(String type, String parameter) {
        this.type = type;
        this.parameter = parameter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}