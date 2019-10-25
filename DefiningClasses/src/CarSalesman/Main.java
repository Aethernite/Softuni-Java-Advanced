package CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedHashMap<String,Engine> map = new LinkedHashMap<>();
        ArrayList<Car> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            String[] input = br.readLine().split("\\s+");
            Engine engine;
            if(input.length == 4){
                engine = new Engine(input[0],Integer.parseInt(input[1]),input[3],Integer.parseInt(input[2]));
            }
            else if(input.length==3){
                int displacement = -1;
                boolean isEfficiency = false;
                try{
                    displacement = Integer.parseInt(input[2]);
                } catch(Exception e){
                    isEfficiency = true;
                }
                if(isEfficiency){
                    engine = new Engine(input[0],Integer.parseInt(input[1]),input[2],displacement);
                }else{
                    engine = new Engine(input[0],Integer.parseInt(input[1]),"n/a",displacement);
                }
            }
            else{
                engine = new Engine(input[0],Integer.parseInt(input[1]),"n/a", -1);
            }
            map.put(engine.getModel(),engine);
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            String[] input = br.readLine().split("\\s+");
            Car car;
            if(input.length == 2){
                car = new Car(input[0],map.get(input[1]),-1, "n/a");
            }
            else if(input.length == 3){
                int weight = -1;
                String color = "n/a";
                boolean isColor = false;
                try{
                    weight = Integer.parseInt(input[2]);
                } catch(Exception e){
                    isColor = true;
                }
                if(isColor){
                    car = new Car(input[0],map.get(input[1]),-1, input[2]);
                } else{
                    car = new Car(input[0],map.get(input[1]),weight, "n/a");
                }
            }
            else{
                car = new Car(input[0],map.get(input[1]),Integer.parseInt(input[2]), input[3]);
            }
            list.add(car);
        }

        for(Car car: list){
            System.out.println(car);
        }
    }
}
