package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedHashMap<String, Car> map = new LinkedHashMap<>();
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split("\\s+");
            if(!map.containsKey(input[0])){
                Car car = new Car(input[0], Integer.parseInt(input[1]), Double.parseDouble(input[2]));
                map.put(input[0], car);
            }
        }


        while(true){
            String[] input = br.readLine().split("\\s+");
            if(input[0].equals("End")){
                break;
            }
            int distance = Integer.parseInt(input[2]);
            String model = input[1];
            Car car = map.get(input[1]);
            car.drive(distance);
            map.put(input[1], car);
        }

        map.forEach((k,v) ->{
           System.out.println(String.format("%s %.2f %d",v.getModel(), v.getFuel(), v.getDistance()));
        });
    }
}
