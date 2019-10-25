package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(reader.readLine());

        Map<String, Engine> engines = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            if (tokens.length == 2) {
                Engine engine = new Engine(model, power);
                engines.put(model, engine);
            }

            else if (tokens.length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    int displacement = Integer.parseInt(tokens[2]);
                    Engine engine = new Engine(model, power, displacement);
                    engines.put(model, engine);
                }
                else {
                    String efficiency = tokens[2];
                    Engine engine = new Engine(model, power, efficiency);
                    engines.put(model, engine);
                }
            }

            else if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                Engine engine = new Engine(model, power, displacement, efficiency);
                engines.put(model, engine);
            }
        }

        int m = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < m; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            String engineString = tokens[1];
            Engine engine = engines.get(engineString);

            if (tokens.length == 2) {
                Car car = new Car(model, engine);
                cars.put(model, car);
            }

            else if (tokens.length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    int weight = Integer.parseInt(tokens[2]);
                    Car car = new Car(model, engine, weight);
                    cars.put(model, car);
                }
                else {
                    String color = tokens[2];
                    Car car = new Car(model, engine, color);
                    cars.put(model, car);
                }
            }
            else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                Car car = new Car(model, engine, weight, color);
                cars.put(model, car);
            }
        }

        for (Map.Entry e : cars.entrySet()) {
            System.out.println(e.getValue());
        }

    }
}