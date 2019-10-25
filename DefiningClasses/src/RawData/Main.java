package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Car> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split("\\s+");
            String type = input[0];
            Engine engine = new Engine(Integer.parseInt(input[1]),Integer.parseInt(input[2]));
            Cargo cargo = new Cargo(input[4], Integer.parseInt(input[3]));
            Tire tire = new Tire(Double.parseDouble(input[5]), Integer.parseInt(input[6]),Double.parseDouble(input[7]),Integer.parseInt(input[8]),Double.parseDouble(input[9]),Integer.parseInt(input[10]),Double.parseDouble(input[11]),Integer.parseInt(input[12]));
            Car car = new Car(type,engine,cargo,tire);
            list.add(car);
        }
        String input = br.readLine();
        if(input.equals("fragile")){
            for(Car car: list){
                if(car.getCargo().getType().equals("fragile") && car.hasWeakTire()){
                    System.out.println(car.getModel());
                }
            }
        }
        else if(input.equals("flamable")){
            for(Car car: list){
                if(car.getCargo().getType().equals("flamable") && car.getEngine().getPower()>250){
                    System.out.println(car.getModel());
                }
            }
        }
    }
}
