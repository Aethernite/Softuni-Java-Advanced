package GenericCountmethodDoubles;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        GenericBox<Double> box = new GenericBox<Double>();
        List<Double> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            list.add(Double.parseDouble(br.readLine()));
        }
        Double element = Double.parseDouble(br.readLine());
        System.out.println(box.count(list,element));
    }
}
