package CarSalesman;

public class Engine {
    String model;
    int power;
    String efficiency;
    int displacement;

    public Engine(String model, int power, String efficiency, int displacement) {
        this.model = model;
        this.power = power;
        this.efficiency = efficiency;
        this.displacement = displacement;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }
}
