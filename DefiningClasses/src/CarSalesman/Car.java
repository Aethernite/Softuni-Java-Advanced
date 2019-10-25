package CarSalesman;

public class Car {
    String model;
    Engine engine;
    int weight;
    String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.model+":" +"\n");
        sb.append(engine.getModel()+":"+"\n");
        sb.append("Power: " + engine.getPower() + "\n");
        if(engine.getDisplacement()!=-1) {
            sb.append("Displacement: " + engine.getDisplacement()+ "\n");
        } else{
            sb.append("Displacement: n/a" + "\n");
        }
        sb.append("Efficiency: " + engine.getEfficiency() + "\n");
        if(weight!=-1) {
            sb.append("Weight: " + weight + "\n");
        } else{
            sb.append("Weight: n/a"+ "\n");
        }
        sb.append("Color: " + color);
        return sb.toString();
    }
}
