package SpeedRacing;

public class Car {
    String model;
    double fuel;
    double cost;
    int distance;

    public Car(String model, double fuel, double cost) {
        this.model = model;
        this.fuel = fuel;
        this.cost = cost;
        this.distance = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void drive(int distance){
        double fuel = this.fuel;
        double fuelNeeded = distance * this.cost;
        if(fuel - fuelNeeded < 0){
            System.out.println("Insufficient fuel for the drive");
            return;
        }
        this.fuel = this.fuel - fuelNeeded;
        this.distance += distance;
    }

}
